package by.it_academy.homework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Time;
import java.util.ArrayList;

import by.it_academy.homework.homeWork1.HomeWork1Activity;
import by.it_academy.homework.homeWork2.HomeWork2Activity;
import by.it_academy.homework.homeWork3.HomeWork3Activity;
import by.it_academy.homework.homeWork4.HomeWork4Activity;
import by.it_academy.homework.homeWork5.HomeWork5Activity;
import by.it_academy.homework.homeWork7.HomeWork7Activity;
import by.it_academy.homework.homework6.HomeWork6Activity;


public class MainActivity extends AppCompatActivity {
    private TextView mLargeTest;
    private ArrayList<Button> mButtons;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtons = new ArrayList<>();
        mLargeTest = findViewById(R.id.large_text_main);
        initButtons();
        animateViews();

        mButtons.get(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HomeWork1Activity.class);
                startActivity(intent);
            }
        });

        mButtons.get(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HomeWork2Activity.class);
                startActivity(intent);
            }
        });

        mButtons.get(2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HomeWork3Activity.class);
                startActivity(intent);
            }
        });

        mButtons.get(3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HomeWork4Activity.class);
                startActivity(intent);
            }
        });

        mButtons.get(4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HomeWork5Activity.class);
                startActivity(intent);
            }
        });
        mButtons.get(5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HomeWork6Activity.class);
                startActivity(intent);
            }
        });
        mButtons.get(6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HomeWork7Activity.class);
                startActivity(intent);
            }
        });

    }

    private void initButtons(){
        for (int i = 0; i < 7; i++) {
            mButtons.add(new Button(this));
        }

        mButtons.set(0,(Button) findViewById(R.id.home_work_1_main_button));
        mButtons.set(1,(Button) findViewById(R.id.home_work_2_main_button));
        mButtons.set(2,(Button) findViewById(R.id.home_work_3_main_button));
        mButtons.set(3,(Button) findViewById(R.id.home_work_4_main_button));
        mButtons.set(4,(Button) findViewById(R.id.home_work_5_main_button));
        mButtons.set(5,(Button) findViewById(R.id.home_work_6_main_button));
        mButtons.set(6,(Button) findViewById(R.id.home_work_7_main_button));
    }

    private void animateViews(){
        Animation animation = AnimationUtils.makeInAnimation(this, true);
        if (mLargeTest != null) {
            animation.setStartOffset(200);
            animation.setDuration(1200);
            animation.setInterpolator(new OvershootInterpolator());
            mLargeTest.startAnimation(animation);
        }
        if(mButtons!=null){
            for (int i = 0; i < mButtons.size(); i++) {
                int animId = (i%2 ==0)? R.anim.left_to_right : R.anim.right_to_left;
                animation = AnimationUtils.loadAnimation(this, animId);
                animation.setDuration(800);
                animation.setStartOffset(i*200+800);
                mButtons.get(i).startAnimation(animation);
            }
        }
    }
}
