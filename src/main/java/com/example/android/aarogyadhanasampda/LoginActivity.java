package com.example.android.aarogyadhanasampda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }


    public void createAccount(View view) {
        Intent intent = new Intent(this, AuthenticateActivity.class);
        intent.putExtra("caller", "login");
        startActivity(intent);
    }

    public void exitApplication(View view) {
        int pid = android.os.Process.myPid();
        android.os.Process.killProcess(pid);
        System.exit(0);
    }

    public void logInToAccount(View view) {
        EditText userID = (EditText) findViewById(R.id.user_id_edit_view);
        EditText password = (EditText) findViewById(R.id.password_edit_view);
        if (userID.getText().toString().equals("AMU110189") && password.getText().toString().equals("Amu@110189")) {
            Intent intent = new Intent(this, DashboardActivity.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }

    }
}
