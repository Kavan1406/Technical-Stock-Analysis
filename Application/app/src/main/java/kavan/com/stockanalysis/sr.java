package kavan.com.stockanalysis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

import static kavan.com.stockanalysis.MainActivity.sharpe_ratio2;

public class sr extends AppCompatActivity {

    TextView t1,t3,sr1,sr2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sr);

        t1 = findViewById(R.id.t1);
        t3 = findViewById(R.id.t3);
        sr1 = findViewById(R.id.sr1);
        sr2 = findViewById(R.id.sr2);



        t1.setText("Sharpe Ratio of "+MainActivity.tckr1);
        t3.setText("Sharpe Ratio of "+MainActivity.tckr2);
        sr1.setText(""+MainActivity.sharpe_ratio);
        sr2.setText(""+MainActivity.sharpe_ratio2);
    }
}
