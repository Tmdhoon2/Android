package com.example.sharedpreferencestest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etId;
    private EditText etPw;
    private Button btLogin;
    private TextView tvId;
    private TextView tvPw;
    private Button btPop;

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
        btPop = findViewById(R.id.btPop);

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

        AlertDialog.Builder builder = new AlertDialog.Builder(this);


        btPop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setTitle("제목");
                builder.setMessage("메시지");
                
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Yes", Toast.LENGTH_SHORT).show();
                    }
                });
                
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "No", Toast.LENGTH_SHORT).show();
                    }
                });
                
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

    }
}