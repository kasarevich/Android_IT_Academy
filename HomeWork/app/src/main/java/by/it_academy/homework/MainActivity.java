package by.it_academy.homework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import by.it_academy.homework.homeWork1.HomeWork1Activity;
import by.it_academy.homework.homeWork2.HomeWork2Activity;


public class MainActivity extends AppCompatActivity {

    private Button mButtonTask1;
    private Button mButtonTask2;
    private Button mButtonTask3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonTask1 = findViewById(R.id.home_work_1_main_button);
        mButtonTask2 = findViewById(R.id.home_work_2_main_button);
        mButtonTask3 = findViewById(R.id.home_work_3_main_button);

        mButtonTask1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HomeWork1Activity.class);
                startActivity(intent);
            }
        });

        mButtonTask2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HomeWork1Activity.class);
                startActivity(intent);
            }
        });

    }
}
