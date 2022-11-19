package com.example.ex082;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText eTN1,eTN2;
    double firstNumber;
    double multiplierNumber;
    String str;
    Intent si;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eTN1 = findViewById(R.id.eTN1);
        eTN2 = findViewById(R.id.eTN2);
        si = new Intent(this,SecondActivity.class);
    }

    public boolean checkNumber(String str)
    {
        if(str.equals("") || str.equals("-") || str.equals(".") || str.equals("-.") || str.equals(".-"))
        {
            return false;
        }
        return true;
    }

    public void arithmetical(View view) {
        if(checkNumber(eTN1.getText().toString()) == false || checkNumber(eTN2.getText().toString()) == false)
        {
            Toast.makeText(this, "there is no data", Toast.LENGTH_SHORT).show();
        }
        else
        {
            str = eTN1.getText().toString();
            firstNumber = Double.parseDouble(str);
            str = eTN2.getText().toString();
            multiplierNumber = Double.parseDouble(str);
            si.putExtra("n", firstNumber);
            si.putExtra("nn", multiplierNumber);
            si.putExtra("nnn", true);
            startActivity(si);
        }
    }

    public void geometric(View view) {
        if(checkNumber(eTN1.getText().toString()) == false || checkNumber(eTN2.getText().toString()) == false)
        {
            Toast.makeText(this, "there is no data", Toast.LENGTH_SHORT).show();
        }
        else
        {
            str = eTN1.getText().toString();
            firstNumber = Double.parseDouble(str);
            str = eTN2.getText().toString();
            multiplierNumber = Double.parseDouble(str);
            si.putExtra("n",firstNumber);
            si.putExtra("nn",multiplierNumber);
            si.putExtra("nnn",false);
            startActivity(si);
        }
    }
}
