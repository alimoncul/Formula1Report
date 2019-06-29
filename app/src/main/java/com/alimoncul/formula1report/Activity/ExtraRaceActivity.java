package com.alimoncul.formula1report.Activity;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.alimoncul.formula1report.Adapter.ResultsRaceAdapter;
import com.alimoncul.formula1report.FormulaApi.Example;
import com.alimoncul.formula1report.FormulaApi.Result;
import com.alimoncul.formula1report.R;
import com.alimoncul.formula1report.ResultsParcelableRace;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.angmarch.views.NiceSpinner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ExtraRaceActivity extends AppCompatActivity {
    String selectedYear = "";
    String selectedRace = "";
    int raceCount;
    ArrayList<String> grandPrixNames;
    final List<String> dataSetForYears = new LinkedList<>();
    final List<String> dataSetForRaces = new LinkedList<>();
    private static String URL_RACE_COUNTS = "";
    private static String URL_RACE_RESULT = "";
    int[] years = new int[68];
    NiceSpinner yearSpinner;
    ArrayList<ResultsParcelableRace> mResultRace = new ArrayList<>();
    NiceSpinner raceSpinner;
    RecyclerView recyclerView;
    Button btnGetResult;
    Boolean yearSelected;
    ProgressBar progressBarRound;
    Boolean roundSelected;
    ProgressBar progressBarGet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra_race);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

        yearSelected=false;
        roundSelected=false;
        progressBarGet = findViewById(R.id.progressBarGet);
        recyclerView = findViewById(R.id.rv_results);
        progressBarRound = findViewById(R.id.progressBarRound);
        yearSpinner = findViewById(R.id.year_spinner);
        raceSpinner = findViewById(R.id.race_spinner);
        btnGetResult = findViewById(R.id.buttonGetResults);
        raceSpinner.setEnabled(false);
        raceSpinner.setClickable(false);
        dataSetForYears.add("Please select a year.");
        for (int i = 0; i < years.length; i++) {
            years[i] = (i + 1950);
            dataSetForYears.add(String.valueOf(years[i]));
        }
        yearSpinner.attachDataSource(dataSetForYears);
        yearSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (dataSetForYears.get(yearSpinner.getSelectedIndex()).equals("Please select a year.")) {
                    yearSelected = false;
                    Toast.makeText(ExtraRaceActivity.this, "You didn't select a year!", Toast.LENGTH_LONG).show();
                } else {
                    yearSelected = true;
                    roundSelected = false;
                    raceSpinner.setEnabled(false);
                    raceSpinner.setClickable(false);
                    selectedYear = dataSetForYears.get(yearSpinner.getSelectedIndex());
                    URL_RACE_COUNTS = "http://ergast.com/api/f1/" + selectedYear + ".json";
                    progressBarRound.setVisibility(View.VISIBLE);
                    new getRaceCounts().execute();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        raceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (dataSetForRaces.get(raceSpinner.getSelectedIndex()).equals("Please select a round.")) {
                    roundSelected = false;
                    Toast.makeText(ExtraRaceActivity.this, "You didn't select a round!", Toast.LENGTH_LONG).show();
                } else {
                    roundSelected=true;
                    selectedRace = dataSetForRaces.get(raceSpinner.getSelectedIndex());
                    selectedRace = selectedRace.split("\\s+")[0];
                    URL_RACE_RESULT = "http://ergast.com/api/f1/" + selectedYear + "/" + selectedRace + "/results.json";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btnGetResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (yearSelected && roundSelected) {
                    progressBarGet.setVisibility(View.VISIBLE);
                    raceSpinner.setEnabled(false);
                    raceSpinner.setClickable(false);
                    yearSpinner.setEnabled(false);
                    yearSpinner.setClickable(false);
                    recyclerView.setAdapter(null);
                    new getResults().execute();
                }
                else{
                    Toast.makeText(ExtraRaceActivity.this, "Please select year and round to continue!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void getRaceCount(int n) {
        dataSetForRaces.clear();
        dataSetForRaces.add("Please select a round.");
        int[] races = new int[n];
        for (int i = 0; i < races.length; i++) {
            races[i] = (i + 1);
            dataSetForRaces.add(String.valueOf(races[i]) + "\t " + grandPrixNames.get(i));
        }
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.slide_out);
    }

    public class getRaceCounts extends AsyncTask<String, String, String> {
        String data = "";

        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url = new URL(URL_RACE_COUNTS);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line = "";
                while (line != null) {
                    line = bufferedReader.readLine();
                    if (line == null) break;
                    else data = data + line;
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return data;
        }

        @Override
        protected void onPostExecute(String data) {
            Gson gsonForRaceCount = new GsonBuilder().create();
            grandPrixNames = new ArrayList<>();
            Example example = gsonForRaceCount.fromJson(data, Example.class);
            raceCount = example.getMRData().getRaceTable().getRaces().size();
            for(int i = 0 ; i < raceCount ; i++){
                grandPrixNames.add(example.getMRData().getRaceTable().getRaces().get(i).getRaceName());
            }
            getRaceCount(raceCount);
            raceSpinner.attachDataSource(dataSetForRaces);
            raceSpinner.setEnabled(true);
            raceSpinner.setClickable(true);
            progressBarRound.setVisibility(View.GONE);
        }
    }

    public class getResults extends AsyncTask<String, String, String> {

        //Race Results
        String DriverName;
        String FamilyName;
        int DriverPosition;
        int DriverPoint;
        String Constructor;
        String raceName;
        String data = "";

        @Override
        protected String doInBackground(String... strings) {

            try {
                URL url = new URL(URL_RACE_RESULT);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line = "";
                while (line != null) {
                    line = bufferedReader.readLine();
                    if (line == null) break;
                    else data = data + line;
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return data;
        }

        @Override
        protected void onPostExecute(String data) {
            Gson gsonForRaceResult = new GsonBuilder().create();
            Example example = gsonForRaceResult.fromJson(data, Example.class);
            raceName = example.getMRData().getRaceTable().getRaces().get(0).getRaceName();
            List<Result> result = example.getMRData().getRaceTable().getRaces().get(0).getResults();

            mResultRace.clear();
            for (int i = 0; i < result.size(); i++) {
                DriverPoint = Integer.parseInt(result.get(i).getPoints());
                DriverName = result.get(i).getDriver().getGivenName();
                FamilyName = result.get(i).getDriver().getFamilyName();
                Constructor = result.get(i).getConstructor().getName();
                DriverPosition = Integer.parseInt(result.get(i).getPosition());
                mResultRace.add(new ResultsParcelableRace(DriverPoint, DriverPosition, DriverName, FamilyName, Constructor));
            }
            ResultsRaceAdapter adapter = new ResultsRaceAdapter(getApplicationContext(), mResultRace, 0);
            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(adapter);
            raceSpinner.setEnabled(true);
            raceSpinner.setClickable(true);
            yearSpinner.setEnabled(true);
            yearSpinner.setClickable(true);
            progressBarGet.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }
        return super.onOptionsItemSelected(item);
    }
}
