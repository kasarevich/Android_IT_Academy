package by.it_academy.homework.homeWork4;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import by.it_academy.homework.R;

public class OwlAnimActivity extends AppCompatActivity {

    private ImageView mOwl;
    private AnimationDrawable mBlink;
    private Button mStartAnim;
    private Button mStopAnim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework4_owl_anim);

        mStartAnim = findViewById(R.id.hw_4_start_anim);
        mStopAnim = findViewById(R.id.hw_4_stop_anim);

        mOwl = findViewById(R.id.imageView_owl);
        mOwl.setBackgroundResource(R.drawable.owl_animation_hw4);
        mBlink = (AnimationDrawable) mOwl.getBackground();

        mStartAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBlink.start();
            }
        });

        mStopAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBlink.stop();
            }
        });
    }
}
