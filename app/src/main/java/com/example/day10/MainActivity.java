package com.example.day10;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etRent;
    private RadioButton rbPajero, rbAlphard, rbInnova, rbBrio, rbInside, rbOutside;
    private Button btnRent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etRent = findViewById(R.id.etrent);
        rbPajero = findViewById(R.id.rbpajero);
        rbAlphard = findViewById(R.id.rbalphard);
        rbInnova = findViewById(R.id.rbinnova);
        rbBrio = findViewById(R.id.rbbrio);
        rbInside = findViewById(R.id.rbinside);
        rbOutside = findViewById(R.id.rboutside);
        btnRent = findViewById(R.id.btnRent);


        btnRent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int totalDay = Integer.parseInt(etRent.getText().toString());
                double totalPrice = 0;
                String carType = "";

                if (rbPajero.isChecked()) {
                    totalPrice = 2400000 * totalDay;
                    carType = "Pajero";
                } else if (rbAlphard.isChecked()) {
                    totalPrice = 1550000 * totalDay;
                    carType = "Alphard";
                } else if (rbInnova.isChecked()) {
                    totalPrice = 850000 * totalDay;
                    carType = "Innova";
                } else if (rbBrio.isChecked()) {
                    totalPrice = 550000 * totalDay;
                    carType = "Brio";
                }

                double areaPrice = 0;
                if (rbInside.isChecked()) {
                    areaPrice = 135000 * totalDay;
                } else if (rbOutside.isChecked()) {
                    areaPrice = 250000 * totalDay;
                }

                totalPrice += areaPrice;

                double discount = 0;
                if (totalPrice > 10000000) {
                    discount = totalPrice * 0.07;
                } else if (totalPrice > 5000000) {
                    discount = totalPrice * 0.05;
                }

                double total = totalPrice - discount;

                Intent intent = new Intent(MainActivity.this, Nota.class);
                intent.putExtra("Car Type", carType);
                intent.putExtra("Total Day", totalDay);
                intent.putExtra("Total Price", totalPrice);
                intent.putExtra("Discount", discount);
                intent.putExtra("Total", total);

                startActivity(intent);
            }
        });
    }
}
