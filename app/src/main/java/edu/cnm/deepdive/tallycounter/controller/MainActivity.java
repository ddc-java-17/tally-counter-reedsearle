package edu.cnm.deepdive.tallycounter.controller;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import edu.cnm.deepdive.tallycounter.R;
import edu.cnm.deepdive.tallycounter.databinding.ActivityMainBinding;
import edu.cnm.deepdive.tallycounter.viewmodel.MainViewModel;
import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

  private static final String TAG = MainActivity.class.getSimpleName();
  private ActivityMainBinding binding;
  private MainViewModel viewModel;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Log.d(TAG, "MainActivity::onCreate");
    binding = ActivityMainBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());
    viewModel = new ViewModelProvider(this)
        .get(MainViewModel.class);
    viewModel
        .getCounter()
        .observe(this, this::setTallyDisplay);
  }

  public void handleIncrement(View v){
    viewModel.incrementCounterValue();
  }


  private void setTallyDisplay(int counter){
    binding.tally.setText(String.valueOf(counter));
  }
}