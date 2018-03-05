package by.it_academy.class_work_1.class_work5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;


// Сюда будут приходить события, на которые мы подписались
public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("AAA", "MESSAGE");
    }



}
