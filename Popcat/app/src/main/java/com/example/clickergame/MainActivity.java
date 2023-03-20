package com.example.clickergame;

import static android.view.KeyEvent.ACTION_UP;
import static android.view.MotionEvent.ACTION_BUTTON_PRESS;
import static android.view.MotionEvent.ACTION_DOWN;
import static android.view.MotionEvent.ACTION_HOVER_MOVE;
import static android.view.MotionEvent.ACTION_MOVE;
import static android.view.MotionEvent.ACTION_POINTER_DOWN;
import static com.example.clickergame.R.drawable.popcat_1;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView imgPopCat;
    TextView result;
    int sum;
    Button reset;
    private Vibrator vibrator;

    @SuppressLint({"ClickableViewAccessibility", "SetTextI18n"})

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);

        imgPopCat = findViewById(R.id.img_cat);
        result = findViewById(R.id.tv_result);
        reset = findViewById(R.id.bt_reset);

        imgPopCat.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case ACTION_DOWN: {
                        imgPopCat.setImageResource(R.drawable.popcat_2);
                        sum = sum + 1;
                        result.setText(String.valueOf(sum));
                        vibrator.vibrate(1000);
                        return true;
                    } case ACTION_UP: {
                        imgPopCat.setImageResource(popcat_1);

                        return true;
                    }
                }
                return true;
            }
        });

        if (sum > 100) {
            Toast.makeText(this, "100을 달성 하셨습니다!", Toast.LENGTH_SHORT).show();
        }

        reset.setOnClickListener(view -> {
                    sum = 0;
                    result.setText(String.valueOf(sum));
                    imgPopCat.setImageResource(popcat_1);
                }
        );
    }
}