package com.alimoncul.formula1report.Activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.alimoncul.formula1report.FormulaApi.Constructor;
import com.alimoncul.formula1report.FormulaApi.ConstructorStanding;
import com.alimoncul.formula1report.FormulaApi.Driver;
import com.alimoncul.formula1report.FormulaApi.DriverStanding;
import com.alimoncul.formula1report.FormulaApi.Example;
import com.alimoncul.formula1report.FormulaApi.InterfaceStandings;
import com.alimoncul.formula1report.R;
import com.alimoncul.formula1report.StandingsParcelableConstructor;
import com.alimoncul.formula1report.StandingsParcelableDriver;
import com.alimoncul.formula1report.Fragment.FragmentStandingConstructors;
import com.alimoncul.formula1report.Fragment.FragmentStandingDrivers;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class StandingActivity extends AppCompatActivity {

    Bundle bundleForDrivers;
    Bundle bundleForTeams;

    ArrayList<StandingsParcelableDriver> mStandingsDrivers = new ArrayList<>();
    ArrayList<StandingsParcelableConstructor> mStandingsConstructor = new ArrayList<>();
    ArrayList<String> mPhotos = new ArrayList<>();
    ViewPager viewPager;
    TabLayout tabLayout;

    List<DriverStanding> resultDriver = null;
    List<ConstructorStanding> resultConstructors = null;

    public static RecyclerView recyclerView;
    private static final String URL_STANDINGS_BASE = "http://ergast.com/api/f1/current/";
    FragmentStandingConstructors fragment_standing_constructor;

    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.slide_out);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standing);
        recyclerView = findViewById(R.id.rv_standings);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        ViewPagerAdapter adapter_vp = new ViewPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(adapter_vp);
        tabLayout.setupWithViewPager(viewPager);

        new getStandings().execute();
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        Fragment fragment_standing_drivers = new FragmentStandingDrivers();
        fragment_standing_drivers.setArguments(bundleForDrivers);

        fragment_standing_constructor = new FragmentStandingConstructors();
        fragment_standing_constructor.setArguments(bundleForTeams);

        adapter.addFragment(fragment_standing_drivers, "DRIVERS");
        adapter.addFragment(fragment_standing_constructor, "CONSTRUCTORS");
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

    public class getStandings extends AsyncTask<Void, Boolean, Boolean> {

        @Override
        protected Boolean doInBackground(Void... voids) {
            Boolean isOkay = false;
            Retrofit retrofit_standing_drivers = new Retrofit.Builder().baseUrl(URL_STANDINGS_BASE).addConverterFactory(GsonConverterFactory.create()).build();
            Retrofit retrofit_standing_constructors = new Retrofit.Builder().baseUrl(URL_STANDINGS_BASE).addConverterFactory(GsonConverterFactory.create()).build();

            InterfaceStandings interfaceStandingDrivers = retrofit_standing_drivers.create(InterfaceStandings.class);
            InterfaceStandings interfaceStandingConstructors = retrofit_standing_constructors.create(InterfaceStandings.class);

            Call<Example> callStandingDrivers = interfaceStandingDrivers.getStanding("driverStandings.json");
            Call<Example> callStandingConstructors = interfaceStandingConstructors.getStanding("constructorStandings.json");

            Response<Example> responseDriver = null;
            try {
                responseDriver = callStandingDrivers.execute();
            } catch (IOException e) {
                e.printStackTrace();
                isOkay=false;
            }

            if(responseDriver!=null && responseDriver.isSuccessful()){ //standing drivers query correct
                resultDriver = responseDriver.body().getMRData().getStandingsTable().getStandingsLists().get(0).getDriverStandings();
                mStandingsDrivers.clear();
                for(int i=0 ; i<resultDriver.size() ; i++){
                    mStandingsDrivers.add(new StandingsParcelableDriver(Integer.parseInt(resultDriver.get(i).getPoints()),Integer.parseInt(resultDriver.get(i).getPosition()),Integer.parseInt(resultDriver.get(i).getWins()),resultDriver.get(i).getDriver().getGivenName(),resultDriver.get(i).getDriver().getFamilyName(),resultDriver.get(i).getConstructors().get(0).getName(),0));
                }
                bundleForDrivers = new Bundle();
                bundleForDrivers.putParcelableArrayList("mDriverStandings", mStandingsDrivers);
                isOkay=true;
            }
            else{
                isOkay=false;
            }

            Response<Example> responseConstructors = null;
            try {
                responseConstructors = callStandingConstructors.execute();
            } catch (IOException e) {
                e.printStackTrace();
                isOkay=false;
            }

            if(responseConstructors!=null && responseConstructors.isSuccessful()){ //standing drivers query correct
                resultConstructors = responseConstructors.body().getMRData().getStandingsTable().getStandingsLists().get(0).getConstructorStandings();
                mStandingsConstructor.clear();

                for(int i=0 ; i<resultConstructors.size() ; i++){
                    mStandingsConstructor.add(new StandingsParcelableConstructor(resultConstructors.get(i).getConstructor().getName(),Integer.parseInt(resultConstructors.get(i).getWins()),Integer.parseInt(resultConstructors.get(i).getPosition()),Integer.parseInt(resultConstructors.get(i).getPoints())));
                }
                bundleForTeams = new Bundle();
                bundleForTeams.putParcelableArrayList("mConstructorStandings", mStandingsConstructor);
                isOkay=true;
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
                Toast.makeText(StandingActivity.this, "Unexpected error occurred! Please try again.", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

}

