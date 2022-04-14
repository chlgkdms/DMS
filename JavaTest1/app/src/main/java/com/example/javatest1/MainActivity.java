package com.example.javatest1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView Title;
    Button Click;

    int sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Title = findViewById(R.id.Title);
        Click = findViewById(R.id.Click);

        Click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sum = sum + 1;
                Title.setText(String.valueOf(sum));
            }
        });

        if (sum >= 20)
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
    }
}