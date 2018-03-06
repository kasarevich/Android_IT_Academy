package by.it_academy.class_work_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import by.it_academy.class_work_1.class_work3.ClassWork3Activity;
import by.it_academy.class_work_1.class_work4.ClassWork4Activity;
import by.it_academy.class_work_1.class_work5.ClassWork5Activity;
import by.it_academy.class_work_1.class_work6.ClassWork6Activity;
import by.it_academy.class_work_1.class_work7.ClassWork7Activity;
import by.it_academy.class_work_1.class_work8.ClassWork8Activity;
import by.it_academy.myapplication.R;

public class ClassWorkActivity extends Activity {

    private static final String TAG = ClassWorkActivity.class.getSimpleName();

    private Button mButton3;
    private Button mButton4;
    private Button mButton5;
    private Button mButton6;
    private Button mButton7;
    private Button mButton8;
    private Button mButton9;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate");
        setContentView(R.layout.activity_class_work1);

        mButton3 = findViewById(R.id.class_work_3);
        mButton4 = findViewById(R.id.class_work_4);
        mButton5 = findViewById(R.id.class_work_5);
        mButton6 = findViewById(R.id.class_work_6);
        mButton7 = findViewById(R.id.class_work_7);
        mButton8 = findViewById(R.id.class_work_8);
        mButton9 = findViewById(R.id.class_work_9);

        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ClassWorkActivity.this, ClassWork3Activity.class);
                startActivity(intent);
            }
        });

        mButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ClassWorkActivity.this, ClassWork4Activity.class);
                startActivity(intent);
            }
        });

        mButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ClassWorkActivity.this, ClassWork5Activity.class);
                startActivity(intent);
            }
        });
        mButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ClassWorkActivity.this, ClassWork6Activity.class);
                startActivity(intent);
            }
        });
        mButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ClassWorkActivity.this, ClassWork7Activity.class);
                startActivity(intent);
            }
        });
        mButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ClassWorkActivity.this, ClassWork8Activity.class);
                startActivity(intent);
            }
        });
        mButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ClassWorkActivity.this, BindingExample.class);
                startActivity(intent);
            }
        });





    }
}
