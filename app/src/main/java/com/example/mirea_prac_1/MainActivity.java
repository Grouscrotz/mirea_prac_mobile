package com.example.mirea_prac_1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View v) {
        Intent intent = new Intent(this, SecondActivity.class);
        String message = ((EditText)findViewById(R.id.edittext)).getText().toString();
        intent.putExtra("extra_message",message);
        startActivity(intent);

    }
    public void setUpActionBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            ActionBar actionBar = getActionBar();
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

    }

    private void show_Toast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    protected void onStart() {
        super.onStart();
        show_Toast("Start now");
        Log.d("test1","Start now");
    }
    protected void onResume() {
        super.onResume();
        show_Toast("Resume now");
        Log.d("test1","Resume now");
    }
    protected void onPause() {
        super.onPause();
        show_Toast("Resume now");
        Log.d("test1","Pause now");
    }
    protected void onStop() {
        super.onStop();
        show_Toast("Stop now");
        Log.d("test1","Stop now");
    }
    protected void onRestart() {
        super.onRestart();
        show_Toast("Restart now");
        Log.d("test1","Restart now");
    }
    protected void onDestroy() {
        super.onDestroy();
        show_Toast("Destroy now");
        Log.d("test1","Destroy now");
    }
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        show_Toast("onSaveInstance");
        Log.d("test1","OnSaveInstance");
    }


    }


