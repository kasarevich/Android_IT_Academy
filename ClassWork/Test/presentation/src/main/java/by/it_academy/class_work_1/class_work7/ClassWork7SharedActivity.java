package by.it_academy.class_work_1.class_work7;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import by.it_academy.myapplication.R;

public class ClassWork7SharedActivity extends AppCompatActivity {

    private final String SHARED = "Shared_Key";
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_work7_shared);

        sharedPreferences = getSharedPreferences(SHARED, Context.MODE_PRIVATE);

    }

    // Сохранение каких-либо данных. (Например флаги, простые данные). к примеру приложение закрыли, потом открыли
    // а открылось в сохраненном состоянии

    @Override
    protected void onResume() {
        super.onResume();
        String text = sharedPreferences.getString(SHARED, "");
        Log.e("AAA", text);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sharedPreferences.edit()
                .putString(SHARED, "Hello")
                .apply();
    }
}
