package by.it_academy.class_work_1.class_work5;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by kasarevich on 19.02.2018.
 */

public class MyIntentService extends IntentService {

    public static String KEY_LINK = "KEY_LINK";

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String link = intent.getStringExtra(KEY_LINK);
        Log.e("MyIntentService", link);

        try {
            Thread.sleep(5000);  //Все вызванные сервисы выполнятся по очереди
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onDestroy() {

        Log.e("MyIntentService", "On destroy");
        super.onDestroy();
    }
}
