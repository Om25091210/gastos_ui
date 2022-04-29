package com.mosio.g_p;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner);
        String[] years = {"Visting Card","Flyer","Brochure","Logo","Banner","Menu","Other(Specify)"};
        spinner.setAdapter(new SpinnerAdapter(this, R.layout.custom_spinner, years,"Select design type"));
    }
}