package com.alimoncul.formula1report.Activity;


import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;

//UI
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

//API
import com.alimoncul.formula1report.R;
import com.alimoncul.formula1report.StandingsParcelableConstructor;
import com.alimoncul.formula1report.StandingsParcelableDriver;



public class MainActivity extends AppCompatActivity {

    private static final String URL_STANDINGS_CONSTRUCTOR = "http://ergast.com/api/f1/current/constructorStandings.json";
    private static final String URL_STANDINGS_DRIVERS = "http://ergast.com/api/f1/current/driverStandings.json";
    ArrayList<String> mPhotos = new ArrayList<>();
    ArrayList<StandingsParcelableDriver> mStandingsForDrivers = new ArrayList<>();
    ArrayList<StandingsParcelableConstructor> mStandingsForConstructors = new ArrayList<>();
    Button btn_upcoming, btn_standings, btn_results, btn_extras;
    ProgressBar progressBarUpcoming, progressBarStandings, progressBarResults, progressBarExtras;
    boolean connected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_upcoming = findViewById(R.id.btn_upcoming);
        btn_standings = findViewById(R.id.btn_standings);
        btn_results = findViewById(R.id.btn_results);
        btn_extras = findViewById(R.id.btn_extras);
        progressBarUpcoming = findViewById(R.id.progressBarUpcoming);
        progressBarStandings = findViewById(R.id.progressBarStandings);
        progressBarResults = findViewById(R.id.progressBarResults);
        progressBarExtras = findViewById(R.id.progressBarExtras);

        btn_upcoming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_extras.setClickable(false);
                btn_standings.setClickable(false);
                btn_results.setClickable(false);
                Intent intent = new Intent(getApplicationContext(), UpcomingActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        btn_extras.setClickable(true);
                        btn_standings.setClickable(true);
                        btn_results.setClickable(true);
                    }
                },300);
            }
        });
        btn_standings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(getApplicationContext().CONNECTIVITY_SERVICE);
                if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                        connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
                    //we are connected to a network
                    connected = true;
                } else {
                    connected = false;
                }
                if (!connected) {
                    Toast.makeText(MainActivity.this, "You dont have active internet connection, Please connect a network and try again.", Toast.LENGTH_SHORT).show();
                } else {
                    btn_extras.setClickable(false);
                    btn_upcoming.setClickable(false);
                    btn_results.setClickable(false);
                    btn_standings.animate().x(-150).setDuration(300);
                    progressBarStandings.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(getApplicationContext(), StandingActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    progressBarResults.setVisibility(View.GONE);
                    btn_standings.animate().x(0).setDuration(300);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            btn_extras.setClickable(true);
                            btn_results.setClickable(true);
                            btn_upcoming.setClickable(true);
                        }
                    },400);

                }
            }
        });
        btn_results.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(getApplicationContext().CONNECTIVITY_SERVICE);
                if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                        connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
                    //we are connected to a network
                    connected = true;
                } else {
                    connected = false;
                }
                if (!connected) {
                    Toast.makeText(MainActivity.this, "You dont have active internet connection, Please connect a network and try again.", Toast.LENGTH_SHORT).show();
                } else {
                    btn_extras.setClickable(false);
                    btn_standings.setClickable(false);
                    btn_upcoming.setClickable(false);
                    btn_results.animate().x(-150).setDuration(300);
                    progressBarResults.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    progressBarResults.setVisibility(View.GONE);
                    btn_results.animate().x(0).setDuration(300);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            btn_extras.setClickable(true);
                            btn_standings.setClickable(true);
                            btn_upcoming.setClickable(true);
                        }
                    },400);
                }
            }
        });
        btn_extras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_upcoming.setClickable(false);
                btn_standings.setClickable(false);
                btn_results.setClickable(false);
                Intent intent = new Intent(getApplicationContext(), ExtraActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        btn_upcoming.setClickable(true);
                        btn_standings.setClickable(true);
                        btn_results.setClickable(true);
                    }
                },300);
            }
        });

    }
}
