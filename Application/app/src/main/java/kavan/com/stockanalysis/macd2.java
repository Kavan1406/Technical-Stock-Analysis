package kavan.com.stockanalysis;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.Date;
import java.util.List;

public class macd2 extends AppCompatActivity {
    GraphView graph1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_macd2);

        graph1 = findViewById(R.id.graph1);

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
        graph1.addSeries(serie3);

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

        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(p);
        series.setColor(Color.RED);
        graph1.addSeries(series);

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

        LineGraphSeries<DataPoint> series2 = new LineGraphSeries<>(p2);
        series2.setColor(Color.WHITE);
        graph1.addSeries(series2);


        graph1.getViewport().setScalable(true);

        graph1.getGridLabelRenderer().setHorizontalLabelsVisible(false);
        graph1.getGridLabelRenderer().setVerticalLabelsVisible(false);
        graph1.getViewport().setScalableY(true);
    }
}
