package kavan.com.stockanalysis;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.Date;
import java.util.List;

public class bb extends AppCompatActivity {

    GraphView graph1;
    GraphView graph2;
    TextView m1,m2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bb);

        graph1 = findViewById(R.id.graph1);
        graph2 = findViewById(R.id.graph2);
        m1 = findViewById(R.id.m1);
        m2 = findViewById(R.id.m2);

        m1.setText(""+MainActivity.tckr1);
        m2.setText(""+MainActivity.tckr2);
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

        graph1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bb.this,bb1.class);
                startActivity(intent);
            }
        });

        graph2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bb.this,bb2.class);
                startActivity(intent);
            }
        });

        graph1.getGridLabelRenderer().setHorizontalLabelsVisible(false);
        graph2.getGridLabelRenderer().setHorizontalLabelsVisible(false);
        graph1.getGridLabelRenderer().setVerticalLabelsVisible(false);
        graph2.getGridLabelRenderer().setVerticalLabelsVisible(false);
        graph1.getViewport().setScalableY(true);
        graph2.getViewport().setScalableY(true);

    }
}
