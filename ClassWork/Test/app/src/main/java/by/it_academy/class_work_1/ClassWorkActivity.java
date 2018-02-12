package by.it_academy.class_work_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import by.it_academy.class_work_1.class_work3.ClassWork3Activity;
import by.it_academy.myapplication.R;

public class ClassWorkActivity extends Activity {

    private static final String TAG = ClassWorkActivity.class.getSimpleName();

    private Button mButton1;
    private Button mButton2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate");
        setContentView(R.layout.activity_class_work1);

        mButton1 = findViewById(R.id.class_work_3);
        mButton2 = findViewById(R.id.class_work_4);

        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ClassWorkActivity.this, ClassWork3Activity.class);
                startActivity(intent);
            }
        });

        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
