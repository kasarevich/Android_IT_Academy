package by.it_academy.class_work_1.class_work3;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import by.it_academy.myapplication.BuildConfig;
import by.it_academy.myapplication.R;

public class ClassWork3Activity extends AppCompatActivity {


    private Button mButton1;
    private Button mButton2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_work3);

        mButton1 = findViewById(R.id.class_work_3_button_first);
        mButton2 = findViewById(R.id.class_work_3_button_second);

        mButton1.setText(BuildConfig.API_URL);

        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
