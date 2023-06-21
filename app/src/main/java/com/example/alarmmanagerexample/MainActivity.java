package com.example.alarmmanagerexample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    static final int ALARM_REQ_CODE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editText = findViewById(R.id.editText);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        findViewById(R.id.btnSet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int time = Integer.parseInt(editText.getText().toString());
                long triggerTime = System.currentTimeMillis()+(time* 1000L);
                Intent iBroadcast = new Intent(MainActivity.this,MyReceiver.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this,ALARM_REQ_CODE,iBroadcast,PendingIntent.FLAG_UPDATE_CURRENT);
                alarmManager.set(AlarmManager.RTC_WAKEUP,triggerTime,pendingIntent);
            }
        });


    }
}