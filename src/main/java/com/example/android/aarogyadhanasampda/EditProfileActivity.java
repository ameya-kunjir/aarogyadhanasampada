package com.example.android.aarogyadhanasampda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class EditProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        Spinner spinner = (Spinner) findViewById(R.id.bank_spinner);

        List<String> banks = new ArrayList<String>();
        banks.add("ICICI Bank");
        banks.add("Punjab National Bank");
        banks.add("HDFC Bank");
        banks.add("Citi Bank");
        banks.add("Kotak Mahindra Bank");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, banks);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }

    public void showDashboard(View view) {
        Intent intentMain = new Intent(this, DashboardActivity.class);
        startActivity(intentMain);
    }
}
