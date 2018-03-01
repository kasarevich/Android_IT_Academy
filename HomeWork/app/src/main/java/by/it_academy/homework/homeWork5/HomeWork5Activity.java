package by.it_academy.homework.homeWork5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import by.it_academy.homework.R;

public class HomeWork5Activity extends AppCompatActivity {


    private ImageView mWifiOn;
    private ImageView mWifiOff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework5);

        mWifiOn = findViewById(R.id.wifi_on_image);
        mWifiOff = findViewById(R.id.wifi_off_image);

        mWifiOn.setImageResource(R.drawable.ic_wifi_enable_48dp);
        mWifiOff.setImageResource(R.drawable.ic_wifi_disabled_48dp);

    }


    private BroadcastReceiver myReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo wifi = connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            boolean isConnected = wifi != null && wifi.isConnectedOrConnecting();
         if(isConnected){
             mWifiOn.setVisibility(View.VISIBLE);
             mWifiOff.setVisibility(View.GONE);
         }
         else {
             mWifiOff.setVisibility(View.VISIBLE);
             mWifiOn.setVisibility(View.GONE);
         }
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(myReceiver, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myReceiver);
    }
}
