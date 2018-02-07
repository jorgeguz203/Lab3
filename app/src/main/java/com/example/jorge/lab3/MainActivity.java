package com.example.jorge.lab3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.support.v7.app.NotificationCompat;


public class MainActivity extends AppCompatActivity {

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();
        Button submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView password = (TextView) findViewById(R.id.password);
                TextView user = (TextView) findViewById(R.id.user);
                String username = user.getText().toString();;
                String pass =  password.getText().toString();;
                Toast MyToast = new Toast(context);
                MyToast.makeText(context, "Redirecting", Toast.LENGTH_LONG).show();
                Intent view2 = new Intent(MainActivity.this, ChildActivity.class);
                view2.putExtra("username", username);
                view2.putExtra("pass", pass);
                startActivity(view2);
            }
        });

    }
}
