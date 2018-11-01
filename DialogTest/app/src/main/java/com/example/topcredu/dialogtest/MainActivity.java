package com.example.topcredu.dialogtest;


import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
  Button button1;
  Button button2;
  TextView textView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    button1 = findViewById(R.id.button1);
    button2 = findViewById(R.id.button2);
    textView = findViewById(R.id.textView);

    button1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        showDialog1(v);
      }
    });
    button2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        showDialog2(v);
      }
    });
  }

  private void showDialog1(View v) {
    AlertDialog.Builder builder = new AlertDialog.Builder(this);

//    builder.setIcon(R.mipmap.ic_launcher);
    builder.setIcon(android.R.drawable.ic_dialog_alert);
    builder.setTitle("상단 타이틀");

    builder.setMessage("중단 메시지");

    // 하단 버튼들
    builder.setPositiveButton("Yes", new OnClickListener(){
      @Override
      public void onClick(DialogInterface dialog, int which) {
        textView.setText("Yes");
      }
    });
    builder.setNeutralButton("Cancel", new OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
        textView.setText("Cancel");
      }
    });
    builder.setNegativeButton("No", new OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
        textView.setText("No");
      }
    });

    builder.show();
  }

  AlertDialog alertDialog;

  private void showDialog2(View v) {
    AlertDialog.Builder builder = new AlertDialog.Builder(this);

    builder.setTitle("하나를 고르세요");

    View view = View.inflate(this, R.layout.dialog, null);
    Log.d("view is LinearLayout?", "" + (view instanceof LinearLayout));
    builder.setView(view);

    // 하단 버튼들
//    builder.setPositiveButton("Orange", new OnClickListener(){
//      @Override
//      public void onClick(DialogInterface dialog, int which) {
//        textView.setText("Orange");
//      }
//    });
//
//    builder.setNegativeButton("Apple", new OnClickListener() {
//      @Override
//      public void onClick(DialogInterface dialog, int which) {
//        textView.setText("Apple");
//      }
//    });

    // #1
//    final AlertDialog alertDialog = builder.show();
    // #2
    alertDialog = builder.show();

    ImageView imageView = view.findViewById(R.id.imageView);
    ImageView imageView2 = view.findViewById(R.id.imageView2);

    imageView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        textView.setText("Apple");
        alertDialog.dismiss();
      }
    });

    // alertDialog 이 변수를 조작하게 되면
    // 콜백함수안에서 사용하는 참조와 다르게 되어 버그가 발생할 수 있게 되므로
    // 자바는 원천적으로 이런 변수앞에 final 키워드를 붙여서 변수의 조작을
    // 불허합니다.

    imageView2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        textView.setText("Orange");
        alertDialog.dismiss();
      }
    });
  }

}
