package com.example.jorge.lab3;

import android.app.NotificationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.PendingIntent;
import android.support.v7.app.NotificationCompat;



public class ChildActivity extends AppCompatActivity {

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
        Intent targetIntent = getIntent();
        String username = targetIntent.getStringExtra("username");
        String pass = targetIntent.getStringExtra("pass");
        Button buttonBack = (Button) findViewById(R.id.buttonBack);
        int NOTIF_ID = 1234;

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent buttonBack = new Intent(ChildActivity.this, MainActivity.class);
                startActivity(buttonBack);
            }
        });

        if (username.equals("karnal") && pass.equals("pass")) {
            AlertDialog.Builder DialogConf = new AlertDialog.Builder(this);
            DialogConf.setTitle("Welcome" + username);
            DialogConf.setMessage("Hello World");
            DialogConf.setIcon(R.mipmap.ic_launcher);
            AlertDialog MyDialog = DialogConf.create();
            MyDialog.show();

            NotificationCompat.Builder NotifBuilder = new NotificationCompat.Builder(ChildActivity.this);
            NotifBuilder.setSmallIcon(R.mipmap.ic_launcher);
            NotifBuilder.setContentTitle("Important Notification");
            NotifBuilder.setContentText("This is the detail of the notification");

            Intent notificationIntent = new Intent(ChildActivity.this, ChildActivity.class);
            notificationIntent.putExtra("myData", "This string comes from the previous activity");
            PendingIntent contentIntent = PendingIntent.getActivity(ChildActivity.this, 0, notificationIntent, 0);

            NotifBuilder.setContentIntent(contentIntent);

            NotificationManager MyNotification = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            MyNotification.notify(NOTIF_ID, NotifBuilder.build());
            //getnotification(NOTIF_ID);
        } else {
            AlertDialog.Builder DialogConf = new AlertDialog.Builder(this);
            DialogConf.setTitle("Invalid");
            DialogConf.setMessage("Invalid credentials");
            DialogConf.setIcon(R.mipmap.ic_launcher);
            DialogConf.setNeutralButton("Retry",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Intent main = new Intent(ChildActivity.this, MainActivity.class);
                            startActivity(main);
                        }
                    });

            AlertDialog MyDialog = DialogConf.create();
            MyDialog.show();
        }
    }

}