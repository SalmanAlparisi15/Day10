package com.example.day10;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.DecimalFormat;

public class Nota extends AppCompatActivity {

    DecimalFormat df = new DecimalFormat("#,###.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nota);
        Intent intent = getIntent();

        if (intent != null) {
            TextView tvcarType = findViewById(R.id.tvnotatype);
            TextView tvDay = findViewById(R.id.tvnotaarea);
            TextView tvPrice = findViewById(R.id.tvnotaday);
            TextView tvDiscount = findViewById(R.id.tvnotadiskon);
            TextView tvTotal = findViewById(R.id.tvnotatotal);

            String carType = intent.getStringExtra("Car Type");
            int totalDay = intent.getIntExtra("Total Day", 0);
            double totalPrice = intent.getDoubleExtra("Total Price", 0);
            double discount = intent.getDoubleExtra("Discount", 0);
            double total = intent.getDoubleExtra("Total", 0);


            tvcarType.setText("Car Type: " + carType);
            tvDay.setText("Total Day: " + totalDay);
            tvPrice.setText("Total Price: " + df.format(totalPrice));
            tvDiscount.setText("Discount: " + df.format(discount));
            tvTotal.setText("Total : " + df.format(total));
        }
    }
}
