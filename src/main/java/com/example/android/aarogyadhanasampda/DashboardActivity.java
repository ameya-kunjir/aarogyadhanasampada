package com.example.android.aarogyadhanasampda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }

    public void showDashboard(View view) {
        Intent intentMain = new Intent(this, DashboardActivity.class);
        startActivity(intentMain);
    }

    public void showAddClaim(View view) {
        Intent intentAddClaim = new Intent(this, AuthenticateActivity.class);
        intentAddClaim.putExtra("caller", "addclaim");
        startActivity(intentAddClaim);
    }

    public void showClaimHistory(View view) {
        Intent intentClaimHis = new Intent(this, ClaimHistoryActivity.class);
        startActivity(intentClaimHis);
    }

    public void showEditProfile(View view) {
        Intent intentEditProfile = new Intent(this, EditProfileActivity.class);
        startActivity(intentEditProfile);
    }

    public void logOut(View view) {
        Intent intentLogOut = new Intent(this, LoginActivity.class);
        startActivity(intentLogOut);
    }
}
