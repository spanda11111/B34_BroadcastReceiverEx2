package com.example.satya.b34_broadcastreceiverex2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
   private EditText et1;
    private Button bt1;
   private TextView tv1;

    //a:crete a dynamic broadcast receiver,because receiver is an inner class
    public class MyReceiver extends BroadcastReceiver
    {
        @Override
        public void onReceive(Context context, Intent intent) {
            tv1.setText("done");

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1= (EditText) findViewById(R.id.et1);
        tv1= (TextView) findViewById(R.id.tv1);
        bt1= (Button) findViewById(R.id.bt1);
        //b:link above broadcast receiver with some intent fillter
        MyReceiver myReceiver = new MyReceiver() ;
        IntentFilter intentFilter = new IntentFilter() ;
        intentFilter.addAction("Work_Done");
        //register receiver
        registerReceiver(myReceiver,intentFilter);
        //
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //here start service pass edit Text
                String name= et1.getText().toString();
                Intent intent = new Intent(MainActivity.this,MyService.class);
                intent.putExtra("name",name);
                startService(intent);
            }
        });
    }

}
