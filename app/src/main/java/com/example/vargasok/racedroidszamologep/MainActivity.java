package com.example.vargasok.racedroidszamologep;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button osszeadas;
    Button kivonas;
    Button szorzas;
    Button osztas;
    EditText ETinput1, ETinput2;
    TextView Eredmeny;
    TextView sign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        osszeadas = (Button) findViewById(R.id.osszeadas);
        kivonas = (Button) findViewById(R.id.kivonas);
        szorzas = (Button) findViewById(R.id.szorzas);
        osztas = (Button) findViewById(R.id.osztas);

        ETinput1 = (EditText) findViewById(R.id.input1);
        ETinput2 = (EditText) findViewById(R.id.input2);
        Eredmeny = (TextView) findViewById(R.id.textView);
        sign = (TextView) findViewById(R.id.sign);

        osszeadas.setOnClickListener(this);
        kivonas.setOnClickListener(this);
        szorzas.setOnClickListener(this);
        osztas.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        try
        {
            Eredmeny.setText("");
            double input1 = Double.parseDouble(ETinput1.getText().toString());
            double input2 = Double.parseDouble(ETinput2.getText().toString());
            double ered = 0;
            sign.setText("");
            DecimalFormat df = new DecimalFormat("#,###,###,###");

            if (v.getId() == R.id.osszeadas)
            {
                ered = input1 + input2;
                if (Double.toString(ered).substring(Double.toString(ered).length()- 2).equals(".0"))
                {
                    Eredmeny.setText(Double.toString(ered).substring(0, Double.toString(ered).length()- 2));
                }
                /*else if ()
                {

                }*/
                else
                {
                    Eredmeny.setText(Double.toString(ered));
                }
                sign.setText("+");
                Eredmeny.setText(df.format(ered));
            }

            if (v.getId() == R.id.kivonas)
            {
                ered = input1 - input2;
                if (Double.toString(ered).substring(Double.toString(ered).length()- 2).equals(".0"))
                {
                    Eredmeny.setText(Double.toString(ered).substring(0, Double.toString(ered).length()- 2));
                }
                else
                {
                    Eredmeny.setText(Double.toString(ered));
                }
                sign.setText("-");
            }

            if (v.getId() == R.id.szorzas)
            {
                ered = input1 * input2;
                if (Double.toString(ered).substring(Double.toString(ered).length()- 2).equals(".0"))
                {
                    Eredmeny.setText(Double.toString(ered).substring(0, Double.toString(ered).length()- 2));
                }
                else
                {
                    Eredmeny.setText(Double.toString(ered));
                }
                sign.setText("*");
            }

            if (v.getId() == R.id.osztas)
            {
                if (input2 == 0)
                {
                    Toast.makeText(getApplicationContext(), "0-val nem lehet osztani!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    ered = input1 / input2;
                    if (Double.toString(ered).substring(Double.toString(ered).length()- 2).equals(".0"))
                    {
                        Eredmeny.setText(Double.toString(ered).substring(0, Double.toString(ered).length()- 2));
                    }
                    else
                    {
                        Eredmeny.setText(Double.toString(ered));
                    }
                    sign.setText("/");
                }
            }

        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(), "Szamot kell begepelni", Toast.LENGTH_SHORT).show();
            Eredmeny.setText(e.toString());
            // Krisztián belenyúlt ide feleslegesen
        }
    }
}