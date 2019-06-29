package com.alimoncul.formula1report.Activity;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.alimoncul.formula1report.R;

public class ExtraActivity extends AppCompatActivity {
    Boolean connected;
    Button btnRaceResult,btnQualifyingResult,btnGetStandings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra);
        btnRaceResult = findViewById(R.id.btn_raceResults);
        btnQualifyingResult = findViewById(R.id.btn_qualifyingResults);
        btnGetStandings = findViewById(R.id.btn_getStandings);

        btnRaceResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(getApplicationContext().CONNECTIVITY_SERVICE);
                if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                        connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {

                    connected = true;
                } else {
                    connected = false;
                }
                if (connected == false) {
                    Toast.makeText(ExtraActivity.this, "You dont have active internet connection, Please connect a network and try again.", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getApplicationContext(),ExtraRaceActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                }

            }
        });
    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.slide_out);
    }
}
