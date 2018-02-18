package by.it_academy.class_work_1.class_work4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import by.it_academy.myapplication.R;

public class ClassWork4Activity extends AppCompatActivity {
    private Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_work4);

        mButton = findViewById(R.id.buttonCW_3);

    }
}
