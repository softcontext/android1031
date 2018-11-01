package com.example.topcredu.myapplication4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_second);
  }

  public void onClickBefore(View view) {
//    Intent intent = new Intent(this, MainActivity.class);
//    startActivity(intent);
    // 백스택에 이전 액티비로써 MainActivity가 존재하는 경우
    // 이 액티비티를 종료하는 것으로 다음 액티비티가 화면에 표시되게 만들어야 한다.
    finish();
  }

  public void onClickNext(View view) {
    Intent intent = new Intent(this, ThirdActivity.class);
    startActivity(intent);
  }

  public void onClickAnother(View view) {

  }
}
