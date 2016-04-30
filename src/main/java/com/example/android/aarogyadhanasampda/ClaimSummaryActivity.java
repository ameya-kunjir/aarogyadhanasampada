package com.example.android.aarogyadhanasampda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ClaimSummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_claim_summary);
    }

    public void viewClaimHistory(View view)
    {

        Intent intent = new Intent(this, ClaimHistoryActivity.class);
        startActivity(intent);
    }
}
