package by.it_academy.class_work_1;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import by.it_academy.myapplication.R;
import by.it_academy.myapplication.databinding.ActivityMvvmexampleBinding;

public class MVVMExample extends AppCompatActivity {

    private static final String TAG = MVVMExample.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_mvvmexample);

        MVVMEntity entity = new MVVMEntity("sucsessfull!", "super button!");

        ActivityMvvmexampleBinding binding =
        DataBindingUtil.setContentView(this, R.layout.activity_mvvmexample);

        binding.setMyEntity(entity);
    }
}
