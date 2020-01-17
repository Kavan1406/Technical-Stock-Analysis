import requests
from statistics import mean
from statistics import pstdev

def Analysis(stk):
    data = requests.get("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY_ADJUSTED&symbol="+stk+".NSE&apikey=")#your api
    d = data.json()
    def getList(dict): 
        list = [] 
        for key in dict.keys(): 
                list.append(key) 
        return list
    a=getList(d)
    j=0
    di = dict()
    di = d[a[1]]
    q=getList(di)
    stk_price=list()


############################################## Sharpe Ratio #####################################################


    for i in q:
        stk_price.append(float(d[a[1]][q[j]]['5. adjusted close']))
        j+=1  
    b=list()
    for i in range(len(stk_price)-1):
        b.append(((stk_price[i]/stk_price[i+1])-1)*100)
    mn = mean(b)*100
    std = pstdev(b)*10
    sharpe_ratio = (mn-5.826)/std


#################################################### MACD #####################################################


    stk_price_rev = stk_price[::-1]

    def ema(stk_price_rev,n):
        sma = 0
        for i in range(n):
                sma = sma + stk_price_rev[i]
        sma_n = sma/n
        mult = 2/(n+1)

        ema_n = list()

        for a in range(2):
                if(len(ema_n)==0):
                        ema_n.append(((stk_price_rev[n]-sma_n)*mult)+sma_n)
                
                else:
                        k=1
                        for i in range(n+1,len(stk_price_rev)):
                                ema_n.append(((stk_price_rev[i]-ema_n[k-1])*mult)+ema_n[k-1])
        return(ema_n)
                        
    ema_12 = ema(stk_price_rev,12)
    ema_26 = ema(stk_price_rev,26)

    macd = list()
    a=0   
    for i in range(15,88):
        macd.append(ema_12[i]-ema_26[a])
        a+=1
        
    ema_9 = ema(macd,9)
    a=0   
    histo = list()
    macd_dates = list()
    for i in range(10,73):
        histo.append(macd[i]-ema_9[a])
        a+=1
    dates_rev = q[::-1]        
    for i in range(10):
        del macd[0]
    for i in range(37,100):
        macd_dates.append(dates_rev[i])
        
        
############################################# Bollinger Bands ##################################################


    sma_bb = list()
    stdev_bb = list()
    stk_price_20 = list()

    for i in range(81):
        stk_price_20.clear()
        sm = 0
        for j in range(20):
                sm = sm + stk_price_rev[j+i]
        for k in range(20):
                stk_price_20.append(stk_price_rev[k+i])
        sma_bb.append(sm/20)
        stdev_bb.append(pstdev(stk_price_20))

    upper_bb = list()
    lower_bb = list()
    dates_bb = list()

    for i in range(81):
        upper_bb.append(sma_bb[i]+(2*stdev_bb[i]))
        
    for i in range(81):
        lower_bb.append(sma_bb[i]-(2*stdev_bb[i]))
        
    for i in range(20,100):
        dates_bb.append(dates_rev[i])
    
    res = dict()
    res = {
        stk:{
            "Sharpe_ratio":sharpe_ratio,
            "MACD":{
                "Dates":macd_dates,
                "MACD_Data":macd,
                "Histo_Data":histo,
                "EMA_9":ema_9
            },
            "BB":{
                "Upper_bb":upper_bb,
                "Lower_bb":lower_bb,
                "SMA":sma_bb,
                "Dates_bb":dates_bb
            }
        }
    }
    
    return res
#########################################################################################################################

