package by.it_academy.homework.homeWork4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import by.it_academy.homework.R;

public class HomeWork4Activity extends AppCompatActivity {

    private Button mOwlButton;
    private Button mWatchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework4);

        mOwlButton = findViewById(R.id.hw_4_view_the_owl_button);
        mWatchButton = findViewById(R.id.hw_4_view_the_watch_button);

        mOwlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeWork4Activity.this, OwlAnimActivity.class);
                startActivity(intent);
            }
        });

        mWatchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeWork4Activity.this, Homework4CustomWatchActivity.class);
                startActivity(intent);
            }
        });
    }
}
