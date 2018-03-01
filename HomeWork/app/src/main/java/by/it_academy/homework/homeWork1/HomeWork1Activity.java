package by.it_academy.homework.homeWork1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import by.it_academy.homework.R;

/**
 * Created by kasarevich on 08.02.2018.
 */

public class HomeWork1Activity extends AppCompatActivity implements View.OnClickListener{
    private TextView mLeftTextView;
    private TextView mRightTextView;
    private Button mChangeButton;

    // реализация через переменную
    /*
    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            change();
        }
    };
    */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework1);

        mLeftTextView = findViewById(R.id.home_work_1_left_text_view);
        mRightTextView = findViewById(R.id.home_work_1_right_text_view);

        mChangeButton = findViewById(R.id.home_work_1_change_button);
        mLeftTextView.setText(R.string.home_work_1_left_text_view);
        mRightTextView.setText(R.string.home_work_1_right_text_view);


        // Реализация через анонимный класс

        /*mChangeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change();
            }
        });*/



        // Реализация через имплемент View.OnClickListener

        //mChangeButton.setOnClickListener(this);


        // Реализация через переменную

        //mChangeButton.setOnClickListener(mOnClickListener);

    }

    @Override
    public void onClick(View v){
        change();

    }

    // Реализачия через android:onClick="onClick1"

    public void onClick1(View v) {
        change();
    }

    private void change(){
        String text = (String) mLeftTextView.getText();
        mLeftTextView.setText(mRightTextView.getText());
        mRightTextView.setText(text);
    }

}
