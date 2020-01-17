package kavan.com.stockanalysis;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.Date;
import java.util.List;

public class bb1 extends AppCompatActivity {

    GraphView graph1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bb1);

        graph1 = findViewById(R.id.graph1);

        Date[] d ;
        d = MainActivity.BB_Dates;
        List<Double> d2 ;
        d2 = MainActivity.Lower_bb;
        List<Double> d3;
        d3 = MainActivity.Upper_bb;
        List<Double> d4;
        d4 = MainActivity.pr;
        List<Double> d5;
        d5 = MainActivity.SMA;


        DataPoint[] dp3 = new DataPoint[66];
        try {
            for (int i = 0; i < 66; i++) {
                dp3[i] = new DataPoint(d[i],d2.get(i));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(dp3);
        series.setColor(Color.WHITE);
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

        LineGraphSeries<DataPoint> series3 = new LineGraphSeries<>(dp2);
        series3.setColor(Color.WHITE);
        graph1.addSeries(series3);

        DataPoint[] dp = new DataPoint[66];
        try {
            for (int i = 0; i < 66; i++) {
                dp[i] = new DataPoint(d[i],d5.get(i));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        LineGraphSeries<DataPoint> series2 = new LineGraphSeries<>(dp);
        series2.setColor(Color.WHITE);
        graph1.addSeries(series2);

        DataPoint[] dp4 = new DataPoint[66];
        try {
            for (int i = 0; i < 66; i++) {
                dp4[i] = new DataPoint(d[i],d4.get(i));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        LineGraphSeries<DataPoint> series4 = new LineGraphSeries<>(dp4);
        series4.setColor(Color.RED);
        graph1.addSeries(series4);
        graph1.getViewport().setScalable(true);

        graph1.getGridLabelRenderer().setHorizontalLabelsVisible(false);
        graph1.getGridLabelRenderer().setVerticalLabelsVisible(false);
        graph1.getViewport().setScalableY(true);
    }
}
