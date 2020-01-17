from flask import Flask,jsonify,request
from main import Analyse
app = Flask(__name__)

@app.route('/',methods=['POST'])
def test():

    tckr1 = request.get_json("tckr1")
    res_1 = dict()
    res_2 = dict()
    res_1 = Analyse(tckr1['tckr1'])
    res_2 = Analyse(tckr1['tckr2'])
    res = dict()
    res = {tckr1['tckr1']:res_1,tckr1['tckr2']:res_2}
    return jsonify(res)

if __name__ == '__main__':
    app.run()