package com.example.android.aarogyadhanasampda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class AddClaimActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_claim);

        Spinner spinner = (Spinner) findViewById(R.id.disease_spinner);
        List<String> diseases = new ArrayList<String>();

        diseases.add("Asthma");
        diseases.add("Beriberi");
        diseases.add("Chickenpox");
        diseases.add("Cholera");
        diseases.add("Dehydration");
        diseases.add("Dengue");
        diseases.add("Gangrene");
        diseases.add("Goitre");
        diseases.add("Hepatitis");
        diseases.add("Jaundice");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, diseases);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        Spinner spinnerAge = (Spinner) findViewById(R.id.age_spinner);
        List<String> ageGroup = new ArrayList<String>();

        diseases.add("00-09");
        diseases.add("10-19");
        diseases.add("20-29");
        diseases.add("30-39");
        diseases.add("40-49");
        diseases.add("50-59");
        diseases.add("60-69");
        diseases.add("70-79");
        diseases.add("80-89");
        diseases.add("90-99");

        // Creating adapter for spinner
        ArrayAdapter<String> ageAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ageGroup);

        // Drop down layout style - list view with radio button
        ageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinnerAge.setAdapter(ageAdapter);
    }

    public void createClaimSummary(View view)
    {

        Intent intent = new Intent(this, ClaimSummaryActivity.class);
        startActivity(intent);
    }

    public void viewClaimSummary(View view)
    {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
