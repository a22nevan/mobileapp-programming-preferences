package com.example.project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private Button btn;

    private SharedPreferences preferenceRef;
    private SharedPreferences.Editor preferenceEditor;

    private TextView prefTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btn = (Button)findViewById(R.id.activityButton);

        preferenceRef = getSharedPreferences("SharedPref", MODE_PRIVATE);
        preferenceEditor = preferenceRef.edit();

        prefTextView = new TextView(this);
        prefTextView = (TextView)findViewById(R.id.prefText);

        preferenceEditor.putString("AppPreferenceString", "No preferences found");
        preferenceEditor.apply();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });



    }

    @Override
    protected void onResume() {
        super.onResume();

        prefTextView.setText(preferenceRef.getString("AppPreferenceString", "No preference found"));

    }
}
