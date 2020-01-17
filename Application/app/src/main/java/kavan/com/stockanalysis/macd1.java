package kavan.com.stockanalysis;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.Date;
import java.util.List;

public class macd1 extends AppCompatActivity {

    GraphView graph1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_macd1);


        graph1 = findViewById(R.id.graph1);

        Date[] d ;
        d = MainActivity.m_date;
        List<Double> d2 ;
        d2 = MainActivity.m_macd_data;
        List<Double> d3;
        d3 = MainActivity.m_ema_9;
        List<Double> d4;
        d4 = MainActivity.m_histo_data;

        DataPoint[] dp3 = new DataPoint[66];
        try {
            for (int i = 0; i < 66; i++) {
                dp3[i] = new DataPoint(d[i],d4.get(i));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        BarGraphSeries<DataPoint> series3 = new BarGraphSeries<>(dp3);
        graph1.addSeries(series3);

        DataPoint[] dp = new DataPoint[66];
        try {
            for (int i = 0; i < 66; i++) {
                dp[i] = new DataPoint(d[i],d2.get(i));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(dp);
        series.setColor(Color.RED);
        graph1.addSeries(series);

        DataPoint[] dp2 = new DataPoint[66];
        try {
            for (int i = 0; i < 66; i++) {
                dp2[i] = new DataPoint(d[i],d3.get(i));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        LineGraphSeries<DataPoint> series2 = new LineGraphSeries<>(dp2);
        series2.setColor(Color.WHITE);
        graph1.addSeries(series2);


        graph1.getViewport().setScalable(true);
        graph1.getGridLabelRenderer().setHorizontalLabelsAngle(135);

        graph1.getGridLabelRenderer().setHorizontalLabelsVisible(false);
        graph1.getGridLabelRenderer().setVerticalLabelsVisible(false);
        graph1.getViewport().setScalableY(true);
    }
}
