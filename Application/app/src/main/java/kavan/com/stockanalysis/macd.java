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

import java.nio.charset.IllegalCharsetNameException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class macd extends AppCompatActivity {
    GraphView graph1;
    GraphView graph2;
    TextView m1,m2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_macd);

        graph1 = findViewById(R.id.graph1);
        graph2 = findViewById(R.id.graph2);
        m1 = findViewById(R.id.m1);
        m2 = findViewById(R.id.m2);

        m1.setText(""+MainActivity.tckr1);
        m2.setText(""+MainActivity.tckr2);
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

        graph1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(macd.this,macd1.class);
                startActivity(intent);
            }
        });


        Date[] z ;
        z = MainActivity.m_date2;
        List<Double> z2 ;
        z2 = MainActivity.m_macd_data2;
        List<Double> z3;
        z3 = MainActivity.m_ema_92;
        List<Double> z4;
        z4 = MainActivity.m_histo_data2;

        DataPoint[] p3 = new DataPoint[66];
        try {
            for (int i = 0; i < 66; i++) {
                p3[i] = new DataPoint(z[i],z4.get(i));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        BarGraphSeries<DataPoint> serie3 = new BarGraphSeries<>(p3);
        graph2.addSeries(serie3);


        DataPoint[] p = new DataPoint[66];
        try {
            for (int i = 0; i < 66; i++) {
                p[i] = new DataPoint(z[i],z2.get(i));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        LineGraphSeries<DataPoint> serie = new LineGraphSeries<>(p);
        serie.setColor(Color.RED);
        graph2.addSeries(serie);

        DataPoint[] p2 = new DataPoint[66];
        try {
            for (int i = 0; i < 66; i++) {
                p2[i] = new DataPoint(z[i],z3.get(i));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        LineGraphSeries<DataPoint> serie2 = new LineGraphSeries<>(p2);
        serie2.setColor(Color.WHITE);
        graph2.addSeries(serie2);


        graph2.getViewport().setScalable(true);

        graph2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(macd.this,macd2.class);
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
