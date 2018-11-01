package com.example.topcredu.serviceapplication;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

public class MyAudioService extends Service {

  MediaPlayer myPlayer;
  private static String MESSAGE = "MyAudioService";

  @Override
  public IBinder onBind(Intent intent) {
    // TODO: Return the communication channel to the service.
    throw new UnsupportedOperationException("Not yet implemented");
  }

  @Override
  public void onCreate() {
    super.onCreate();

    myPlayer = MediaPlayer.create(this, R.raw.winter);
    myPlayer.setLooping(true);  //Set Looping
    Log.i(MESSAGE, "Service onCreate...");
  }

  @Override
  public void onStart(Intent intent, int startId) {
    super.onStart(intent, startId);
    Log.i(MESSAGE, "Service onStart...");
    myPlayer.start();
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    myPlayer.stop();
    Log.i(MESSAGE, "Service onDestroy...");
  }

}
