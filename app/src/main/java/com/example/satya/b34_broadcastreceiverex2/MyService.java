package com.example.satya.b34_broadcastreceiverex2;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
    public MyService()
    {

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Bundle bundle = intent.getExtras();
        String name= bundle.getString("name");
        Toast.makeText(MyService.this, "name is..."+name, Toast.LENGTH_SHORT).show();
       // MainActivity.tv1.setText("done from service");
        //trigger orstart broadcast receiver -use intent and send broadcast receiver
        //it is a implicit intent because no parameter or no target
        Intent intent1= new Intent() ;
        intent1.setAction("Work_Done");
        sendBroadcast(intent1);
        //code over
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
