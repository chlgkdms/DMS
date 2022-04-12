package com.example.clickergame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView result;

    Button up;
    Button down;
    Button reset;

    int sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.tvResult);
        up = findViewById(R.id.btnUp);
        down = findViewById(R.id.btnDown);
        reset = findViewById(R.id.btnReset);

        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sum = sum + 1;
                result.setText(String.valueOf(sum));
            }
        });

        if (sum >= 10) {
            Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
        }

        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sum = sum - 1;
                result.setText(String.valueOf(sum));
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sum = 0;
                result.setText(String.valueOf(sum));
            }
        });



    }
}