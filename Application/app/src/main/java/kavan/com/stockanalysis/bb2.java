package kavan.com.stockanalysis;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.Date;
import java.util.List;

public class bb2 extends AppCompatActivity {

    GraphView graph2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bb2);

        graph2 = findViewById(R.id.graph2);

        Date[] dd ;
        dd = MainActivity.BB_Dates2;
        List<Double> d9 ;
        d9 = MainActivity.Lower_bb2;
        List<Double> d6;
        d6 = MainActivity.Upper_bb2;
        List<Double> d8;
        d8 = MainActivity.pr2;
        List<Double> d7;
        d7 = MainActivity.SMA2;


        DataPoint[] dp9 = new DataPoint[66];
        try {
            for (int i = 0; i < 66; i++) {
                dp9[i] = new DataPoint(dd[i],d9.get(i));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        LineGraphSeries<DataPoint> series9 = new LineGraphSeries<>(dp9);
        series9.setColor(Color.WHITE);
        graph2.addSeries(series9);

        DataPoint[] dp6 = new DataPoint[66];
        try {
            for (int i = 0; i < 66; i++) {
                dp6[i] = new DataPoint(dd[i],d6.get(i));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        LineGraphSeries<DataPoint> series6 = new LineGraphSeries<>(dp6);
        series6.setColor(Color.WHITE);
        graph2.addSeries(series6);

        DataPoint[] dp7 = new DataPoint[66];
        try {
            for (int i = 0; i < 66; i++) {
                dp7[i] = new DataPoint(dd[i],d7.get(i));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        LineGraphSeries<DataPoint> series7 = new LineGraphSeries<>(dp7);
        series7.setColor(Color.WHITE);
        graph2.addSeries(series7);

        DataPoint[] dp8 = new DataPoint[66];
        try {
            for (int i = 0; i < 66; i++) {
                dp8[i] = new DataPoint(dd[i],d8.get(i));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        LineGraphSeries<DataPoint> series8 = new LineGraphSeries<>(dp8);
        series8.setColor(Color.RED);
        graph2.addSeries(series8);
        graph2.getViewport().setScalable(true);
        graph2.getViewport().setScalableY(true);
        graph2.getGridLabelRenderer().setHorizontalLabelsVisible(false);
        graph2.getGridLabelRenderer().setVerticalLabelsVisible(false);
    }
}
