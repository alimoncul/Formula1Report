package com.alimoncul.formula1report.Activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.alimoncul.formula1report.FormulaApi.Example;
import com.alimoncul.formula1report.FormulaApi.InterfaceRaceResult;
import com.alimoncul.formula1report.FormulaApi.QualifyingResult;
import com.alimoncul.formula1report.FormulaApi.Result;
import com.alimoncul.formula1report.Fragment.FragmentResultQualifying;
import com.alimoncul.formula1report.Fragment.FragmentResultsRace;
import com.alimoncul.formula1report.R;
import com.alimoncul.formula1report.ResultsParcelableQualifying;
import com.alimoncul.formula1report.ResultsParcelableRace;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ResultActivity extends AppCompatActivity {
    Bundle bundleForRaceResult;
    Bundle bundleForQualifyingResult;
    ArrayList<ResultsParcelableRace> mRaceResults = new ArrayList<>();
    ArrayList<ResultsParcelableQualifying> mQualifyingResults = new ArrayList<>();
    ViewPager viewPager;
    TabLayout tabLayout;
    String raceName;
    String qualifyingName;
    List<Result> result = null;
    List<QualifyingResult> qualifyingResults = null;
    private static final String URL_RESULTS_BASE = "http://ergast.com/api/f1/current/last/";


    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.slide_out);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        ViewPagerAdapter adapter_vp = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter_vp);
        tabLayout.setupWithViewPager(viewPager);
        new RetrieveResults().execute();
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        Fragment fragment_race_results = new FragmentResultsRace();
        fragment_race_results.setArguments(bundleForRaceResult);

        Fragment fragment_qualifying_results = new FragmentResultQualifying();
        fragment_qualifying_results.setArguments(bundleForQualifyingResult);

        adapter.addFragment(fragment_qualifying_results, "QUALIFYING");
        adapter.addFragment(fragment_race_results, "RACE");

        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    class RetrieveResults extends AsyncTask<Void, Boolean, Boolean> {

        @Override
        protected Boolean doInBackground(Void... voids) {
            Boolean isOkay = false;
            Retrofit retrofit_race = new Retrofit.Builder().baseUrl(URL_RESULTS_BASE).addConverterFactory(GsonConverterFactory.create()).build();
            Retrofit retrofit_qualifying = new Retrofit.Builder().baseUrl(URL_RESULTS_BASE).addConverterFactory(GsonConverterFactory.create()).build();

            InterfaceRaceResult interfaceRaceResult = retrofit_race.create(InterfaceRaceResult.class);
            InterfaceRaceResult interfaceQualifyingResult = retrofit_qualifying.create(InterfaceRaceResult.class);

            Call<Example> call_race = interfaceRaceResult.getResult("results.json");
            Call<Example> call_qualifying = interfaceQualifyingResult.getResult("qualifying.json");

            Response<Example> responseRace = null;
            try {
                responseRace = call_race.execute();
            } catch (IOException e) {
                e.printStackTrace();
                isOkay=false;
            }

            if(responseRace!=null && responseRace.isSuccessful()){ //race query correct
                raceName = responseRace.body().getMRData().getRaceTable().getRaces().get(0).getRaceName();
                result = responseRace.body().getMRData().getRaceTable().getRaces().get(0).getResults();
                mRaceResults.clear();
                for(int i=0 ; i<result.size() ; i++){
                    mRaceResults.add(new ResultsParcelableRace(Integer.parseInt(result.get(i).getPoints()),Integer.parseInt(result.get(i).getPosition()),result.get(i).getDriver().getGivenName(),result.get(i).getDriver().getFamilyName(),result.get(i).getConstructor().getName()));
                }
                bundleForRaceResult = new Bundle();
                bundleForRaceResult.putParcelableArrayList("mReRace", mRaceResults);
                bundleForRaceResult.putString("race_name", raceName);
                isOkay=true;
            }
            else{
                isOkay=false;
            }

            Response<Example> responseQualifying = null;
            try {
                responseQualifying = call_qualifying.execute();
            } catch (IOException e) {
                e.printStackTrace();
                isOkay=false;
            }

            if(responseQualifying!=null && responseQualifying.isSuccessful()){ //qualifying query correct
                isOkay=true;
                qualifyingName = responseQualifying.body().getMRData().getRaceTable().getRaces().get(0).getRaceName();
                qualifyingResults = responseQualifying.body().getMRData().getRaceTable().getRaces().get(0).getQualifyingResults();
                mQualifyingResults.clear();
                for(int i=0 ; i<qualifyingResults.size() ; i++){
                    if(i<10){
                        mQualifyingResults.add(new ResultsParcelableQualifying(Integer.parseInt(qualifyingResults.get(i).getPosition()),qualifyingResults.get(i).getDriver().getGivenName(),qualifyingResults.get(i).getDriver().getFamilyName(),qualifyingResults.get(i).getConstructor().getName(),qualifyingResults.get(i).getQ3()));
                    }
                    else if(i>=10 && i<15){
                        mQualifyingResults.add(new ResultsParcelableQualifying(Integer.parseInt(qualifyingResults.get(i).getPosition()),qualifyingResults.get(i).getDriver().getGivenName(),qualifyingResults.get(i).getDriver().getFamilyName(),qualifyingResults.get(i).getConstructor().getName(),qualifyingResults.get(i).getQ2()));
                    }
                    else if(i>=15){
                        mQualifyingResults.add(new ResultsParcelableQualifying(Integer.parseInt(qualifyingResults.get(i).getPosition()),qualifyingResults.get(i).getDriver().getGivenName(),qualifyingResults.get(i).getDriver().getFamilyName(),qualifyingResults.get(i).getConstructor().getName(),qualifyingResults.get(i).getQ1()));
                    }
                }
                bundleForQualifyingResult = new Bundle();
                bundleForQualifyingResult.putParcelableArrayList("qualifying", mQualifyingResults);
                bundleForQualifyingResult.putString("qualifyingName", qualifyingName);
            }
            else{
                isOkay=false;
            }
            return isOkay;
        }

        @Override
        protected void onPostExecute(Boolean isOkay) {
            if(isOkay){
                setupViewPager(viewPager);
            }
            else{
                Toast.makeText(ResultActivity.this, "Unexpected error occurred! Please try again.", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }
}
