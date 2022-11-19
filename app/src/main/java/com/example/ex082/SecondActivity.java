package com.example.ex082;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.text.DecimalFormat;
public class SecondActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView lV;
    TextView tV1;
    TextView tV2;
    TextView tV3;
    TextView tV4;
    Intent gi;
    String[] series = new String[20];
    double[] sumArr = new double[20];
    boolean bool;
    double first;
    double multiplierNumber;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tV1 = findViewById(R.id.tV1);
        tV2 = findViewById(R.id.tV2);
        tV3 = findViewById(R.id.tV3);
        tV4 = findViewById(R.id.tV4);
        lV = findViewById(R.id.lV);
        gi = getIntent();

        lV.setOnItemClickListener(this);
        lV.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        first = gi.getDoubleExtra("n", -1919);
        tV1.setText(String.valueOf(first));
        multiplierNumber = gi.getDoubleExtra("nn", -193);
        tV2.setText(String.valueOf(multiplierNumber));
        bool = gi.getBooleanExtra("nnn", false);
        double temp = first;

        if (bool) {

            for (int i = 0; i < series.length; i++) {
                series[i] = df.format(temp);
                sumArr[i] = temp;
                temp = temp + multiplierNumber;
            }
        }
        else {
            for (int i = 0; i < series.length; i++) {
                series[i] = df.format(temp);
                sumArr[i] = temp;
                temp = temp * multiplierNumber;
            }
        }
        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, series);
        lV.setAdapter(adp);
    }

    public void doneActivity(View view) {
        finish();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        tV3.setText(Integer.toString(i));
        double count = 0;
        for(int k = 0; k < i + 1; k++)
        {
            count = count + sumArr[k];
        }
        tV4.setText(Double.toString(count));
    }
}