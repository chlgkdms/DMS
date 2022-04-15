package com.example.javatest1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView Title;
    ImageView jhm;
    Button reset;
    TextView Score;

    int sum;
    int score = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Title = findViewById(R.id.Title);
        jhm = findViewById(R.id.jhm);
        reset = findViewById(R.id.reset);
        Score = findViewById(R.id.Score);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sum = 0;
                Title.setText(String.valueOf(sum));
            }
        });

        jhm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sum = sum + 1;
                Title.setText(String.valueOf(sum));
                if (sum >= 50){
                    sum = 0;
                    Score.setText(String.valueOf(score));
                    score += 1;
                    Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                }
            }
        });
        }
    }