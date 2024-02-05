package edu.cnm.deepdive.tallycounter.controller;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import edu.cnm.deepdive.tallycounter.R;
import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

  private static final String TAG = MainActivity.class.getSimpleName();
  private TextView tally;
  private int counter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);


    Log.d(TAG, "MainActivity::onCreate");
    setContentView(R.layout.activity_main);
    tally = findViewById(R.id.tally);
    if(savedInstanceState!=null){
      setCounter(savedInstanceState.getInt("counter",0));
    }else{
      setCounter(0);
    }
    Button increment = findViewById(R.id.increment);
    OnClickListener incrementListener = new OnClickListener() {
      @Override
      public void onClick(View v) {
        setCounter(counter + 1);
      }
    };
    increment.setOnClickListener(incrementListener);
  }

  @Override
  protected void onRestart() {
    super.onRestart();
    Log.d(TAG, "MainActiviy::onRestart");
  }

  @Override
  protected void onStart() {
    super.onStart();
    Log.d(TAG, "MainActivity::OnStart");
  }

  @Override
  protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
    Log.d(TAG, "MainActivity::onRestoreInstanceState");
  }

  @Override
  protected void onResume() {
    super.onResume();
    Log.d(TAG, "MainActivity::OnResume");
  }

  @Override
  protected void onPause() {
    super.onPause();
    Log.d(TAG, "MainActivity::OnPause");
  }

  @Override
  protected void onStop() {
    super.onStop();
    Log.d(TAG, "MainActivity::OnStop");
  }

  @Override
  protected void onSaveInstanceState(@NonNull Bundle outState) {
    super.onSaveInstanceState(outState);
    Log.d(TAG, "MainActivity::OnsavedInstanceState");
    outState.putInt("counter",counter);
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    Log.d(TAG, "MainActivity::OnDestroy");
  }

  private void setCounter(int counter){
    this.counter = counter;
    tally.setText(String.valueOf(counter));
  }
}