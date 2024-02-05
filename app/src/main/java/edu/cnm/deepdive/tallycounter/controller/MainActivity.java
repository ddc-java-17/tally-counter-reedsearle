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
import edu.cnm.deepdive.tallycounter.databinding.ActivityMainBinding;
import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

  private static final String TAG = MainActivity.class.getSimpleName();
  private int counter;
  private ActivityMainBinding binding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Log.d(TAG, "MainActivity::onCreate");
    binding = ActivityMainBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());
    if(savedInstanceState!=null){
      setCounter(savedInstanceState.getInt("counter",0));
    }else{
      setCounter(3);
    }
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

  public void handleIncrement(View v){
    setCounter(counter + 1);
  }

  private void setCounter(int counter){
    this.counter = counter;
    binding.tally.setText(String.valueOf(counter));
  }
}