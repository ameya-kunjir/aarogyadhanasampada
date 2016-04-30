package com.example.android.aarogyadhanasampda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AuthenticateActivity extends AppCompatActivity {

    String parentActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authenticate);
        parentActivity = getIntent().getStringExtra("caller");
        System.out.println("Parent Caller " + parentActivity);
    }

    public void navigateToOtherScreen(View view)
    {
        if(parentActivity.equalsIgnoreCase("login"))
        {
            Intent intent = new Intent(this, RegistrationActivity.class);
            startActivity(intent);
        }
        else if(parentActivity.equalsIgnoreCase("addclaim"))
        {
            Intent intent = new Intent(this, AddClaimActivity.class);
            startActivity(intent);
        }
    }
}
