package by.it_academy.class_work_1.class_work5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import by.it_academy.myapplication.R;

public class ClassWork5Activity extends AppCompatActivity {



    private Button mButton;
    private final String ACTION_MY_MESSAGE = "by.it_academy.class_work_1.class_work5.ACTION_MY_MESSAGE";
    private LocalBroadcastManager mBroadcastManager; // Делаем локальный ресивер,
    // чтобы не отправлять данные за пределы приложения

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_work5);

        mBroadcastManager = LocalBroadcastManager.getInstance(this);
        mButton = findViewById(R.id.class_work_5_button);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction( ACTION_MY_MESSAGE);
                mBroadcastManager.sendBroadcast(intent);
            }
        });
    }

    private BroadcastReceiver myReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.e("AAAAAA", "MY MESSAGE MODE");
            /*boolean isAirplaneModeOnOn = intent.getBooleanExtra("state" , false);
            if(isAirplaneModeOnOn){
                Log.e("AAAAAA", "AIRPLANE MODE ON");
            }else {
                Log.e("AAAAAA", "AIRPLANE MODE OFF");
            }*/
        }
    };

    @Override
    protected void onStart() {
        super.onStart();

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_MY_MESSAGE);
        mBroadcastManager.registerReceiver(myReceiver, intentFilter);


        Intent intent = new Intent(this, MyService.class);
        startService(intent);


        Intent intent2 = new Intent(this, MyIntentService.class);
        intent2.putExtra("KEY_LINK", "http://first.intent.service");
        startService(intent2);

        Intent intent3 = new Intent(this, MyIntentService.class);
        intent3.putExtra("KEY_LINK", "http://second.intent.service");
        startService(intent3);

        Intent intent4 = new Intent(this, MyIntentService.class);
        intent4.putExtra("KEY_LINK", "http://third.intent.service");
        startService(intent4);
    }

    @Override
    protected void onStop() {
        super.onStop();
       mBroadcastManager.unregisterReceiver(myReceiver);

       stopService(new Intent(this, MyService.class));
    }
}
