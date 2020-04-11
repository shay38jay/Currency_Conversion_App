package net.androidbootcamp.currencyconversionapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    //Variables
    double euro = 0.914354;
    double canadian = 1.39523;
    double mexPeso = 23.3380;
    double enteredDollars;
    double myExchange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        final EditText currency = findViewById(R.id.txtUsDollar);

        final RadioButton radEuro = findViewById(R.id.radEuro);
        final RadioButton radMexPeso = findViewById(R.id.radMexPeso);
        final RadioButton radCanDollar = findViewById(R.id.radCanDollar);
        final TextView result = findViewById(R.id.txtResult);
        Button exchange = findViewById(R.id.btnConvert);

        exchange.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                enteredDollars =  Double.parseDouble(currency.getText().toString());
                DecimalFormat money = new DecimalFormat("###,###.##");
                if(radEuro.isChecked()){
                    if(enteredDollars < 100000) {
                        myExchange = euro * enteredDollars;
                        result.setText("Converted to U.S. Dollars is $ " + money.format(myExchange));
                    }else {
                        Toast.makeText(MainActivity.this, "Converts only values below $100,000 U.S. Dollars",
                                Toast.LENGTH_LONG).show();
                    }
                }
                if(radMexPeso.isChecked()){
                    if(enteredDollars < 100000) {
                        myExchange = mexPeso * enteredDollars;
                        result.setText("Converted to U.S. Dollars is $ " + money.format(myExchange));
                    }else {
                        Toast.makeText(MainActivity.this, "Converts only values below $100,000 U.S. Dollars",
                                Toast.LENGTH_LONG).show();
                    }
                }
                if(radCanDollar.isChecked()){
                    if(enteredDollars < 100000){
                        myExchange = canadian * enteredDollars;
                        result.setText("Converted to U.S. Dollars is $ " + money.format(myExchange));
                    }else {
                        Toast.makeText(MainActivity.this, "Converts only values below $100,000 U.S. Dollars",
                                Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }
}
