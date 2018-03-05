package by.it_academy.homework.homeWork5;


import android.app.Service;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by kasarevich on 03.03.2018.
 */

public class WifiService extends Service {

    private WifiManager mManager;
    private WifiBinder mBinder;

    @Override
    public void onCreate() {
        super.onCreate();
        mManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        mBinder = new WifiBinder();
        return mBinder;
    }

    public void changeWifiState(){
        mManager.setWifiEnabled(!mManager.isWifiEnabled());
    }



    public class WifiBinder extends Binder{
        public WifiService getInstance(){
            return WifiService.this;
        }
    }
}
