package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.media.ExifInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    private SharedPreferences preferenceRef;
    private SharedPreferences.Editor preferenceEditor;
    private EditText newPrefText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        preferenceRef = getSharedPreferences("SharedPref", MODE_PRIVATE);
        preferenceEditor = preferenceRef.edit();

    }

    public void savePref(View view) {

        newPrefText = new EditText(this);
        newPrefText = (EditText)findViewById(R.id.editPrefText);
        preferenceEditor.putString("AppPreferenceString", newPrefText.getText().toString());
        preferenceEditor.apply();

        newPrefText.setText("");

    }
}