package by.it_academy.class_work_1.class_work5;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;


public class MyService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("Service", "onCreated");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("Service", "onDestroyed");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("Service", "onBind");
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("Service", "onUnBind");
        return super.onUnbind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("Service", "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

}
