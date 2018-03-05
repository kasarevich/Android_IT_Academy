package by.it_academy.homework.homeWork5;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Binder;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import by.it_academy.homework.R;

public class HomeWork5Activity extends AppCompatActivity {

    private Button mChangeButton;
    private WifiService.WifiBinder mBinder;
    private ImageView mWifiState;
    ServiceConnection WifiConnection;
    private boolean isBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework5);

        mWifiState = findViewById(R.id.wifi_state_image);

        mChangeButton = findViewById(R.id.button_wifi_hw5);

        mChangeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if(isBound){
                        mBinder.getInstance().changeWifiState();
                    }
            }
        });


        WifiConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                mBinder = (WifiService.WifiBinder) service;
                isBound = true;
                mChangeButton.setEnabled(true);
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                isBound = false;
                mChangeButton.setEnabled(false);
            }
        };

    }


    private BroadcastReceiver myReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            WifiManager wifiManager = (WifiManager)getApplicationContext().getSystemService(WIFI_SERVICE);
            boolean isConnected = wifiManager.isWifiEnabled();
         if(isConnected){
             mWifiState.setImageResource(R.drawable.ic_wifi_enable_48dp);
         }
         else {
             mWifiState.setImageResource(R.drawable.ic_wifi_disabled_48dp);
         }
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter("android.net.wifi.WIFI_STATE_CHANGED");
//        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGE");
        registerReceiver(myReceiver, intentFilter);

        Intent intent = new Intent(HomeWork5Activity.this, WifiService.class);
        bindService(intent, WifiConnection, BIND_AUTO_CREATE);

    }


    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myReceiver);

        if(isBound) {
            unbindService(WifiConnection);
            isBound = false;
        }
    }


}
