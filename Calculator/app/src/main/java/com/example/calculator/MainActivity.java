package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText et1, et2;
    Button ButtonAdd, ButtonSub;
    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("계산기");

        et1 = findViewById(R.id.editText1);
        et2 = findViewById(R.id.editText2);
        tv = findViewById(R.id.tv);
        ButtonAdd = findViewById(R.id.ButtonAdd);
        ButtonSub = findViewById(R.id.ButtonSub);

        ButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result = Integer.parseInt(et1.getText().toString())+Integer.parseInt(et2.getText().toString());
                tv.setText("계산결과 : "+result);
            }
        });


        ButtonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result2 = Integer.parseInt(et1.getText().toString())-Integer.parseInt(et2.getText().toString());
                tv.setText("계산결과 : "+result2);
            }
        });


    }
}