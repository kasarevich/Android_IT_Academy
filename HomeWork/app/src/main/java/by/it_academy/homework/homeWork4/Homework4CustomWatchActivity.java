package by.it_academy.homework.homeWork4;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import by.it_academy.homework.R;

public class Homework4CustomWatchActivity extends AppCompatActivity {


    private ImageView mOwl;
    private AnimationDrawable mBlink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Анимация переходов между активити заданы в манифесте черех тему для всего проекта

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework4_custom_watch);

        mOwl = findViewById(R.id.imageView_owl);
        mOwl.setBackgroundResource(R.drawable.owl_animation_hw4);
        mBlink = (AnimationDrawable) mOwl.getBackground();
        mBlink.start();


    }
}
