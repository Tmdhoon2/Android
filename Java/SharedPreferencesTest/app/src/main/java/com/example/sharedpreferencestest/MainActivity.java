package com.example.sharedpreferencestest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etId;
    private EditText etPw;
    private Button btLogin;
    private TextView tvId;
    private TextView tvPw;

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etId = findViewById(R.id.etId);
        etPw = findViewById(R.id.etPw);
        btLogin = findViewById(R.id.btLogin);
        tvId = findViewById(R.id.tvId);
        tvPw = findViewById(R.id.tvPw);

        preferences = getSharedPreferences("UserInfo", MODE_PRIVATE);

        editor = preferences.edit();

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editor.putString("Id", etId.getText().toString()).commit();
                editor.putString("Pw", etPw.getText().toString()).commit();

                tvId.setText(preferences.getString("Id", ""));
                tvPw.setText(preferences.getString("Pw", ""));
            }
        });

    }
}