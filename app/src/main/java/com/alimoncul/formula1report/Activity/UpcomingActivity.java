package com.alimoncul.formula1report.Activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alimoncul.formula1report.Adapter.UpcomingAdapter;
import com.alimoncul.formula1report.CountdownUpcoming;
import com.alimoncul.formula1report.R;

import java.util.ArrayList;
import java.util.Date;


public class UpcomingActivity extends AppCompatActivity {

    ViewPager viewPager;
    UpcomingAdapter adapter;
    ArrayList<CountdownUpcoming> raceList;
    ArrayList<CountdownUpcoming> toRemoveList = new ArrayList<>();
    long nowTime;

    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.slide_out);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming);
        raceList = new ArrayList<>();
        nowTime = System.currentTimeMillis();
        raceList.add(new CountdownUpcoming("Australian Grand Prix", 58, "5.303 km", getApplicationContext().getResources().getDrawable(R.drawable.australian_grand_prix), new Date(31556952000L+1521954600000L), "Michael Schumacher (4)", "Ferrari (12)", "Lewis Hamilton - Mercedes - 1:21:164"));
        raceList.add(new CountdownUpcoming("Bahrain Grand Prix", 57, "5.412 km", getApplicationContext().getResources().getDrawable(R.drawable.bahrain_grand_prix), new Date(31556952000L+1523200200000L), "Sebastian Vettel (6)", "Ferrari (6)", "Sebastian Vettel - Ferrari - 1:27.958"));
        raceList.add(new CountdownUpcoming("Chinese Grand Prix", 56, "5.451 km", getApplicationContext().getResources().getDrawable(R.drawable.chinese_grand_prix), new Date(31556952000L+1523772600000L), "Lewis Hamilton (5)", "Mercedes (5)", "Sebastian Vettel - Ferrari - 1:31.095"));
        raceList.add(new CountdownUpcoming("Azerbaijan Grand Prix", 51, "6.003 km", getApplicationContext().getResources().getDrawable(R.drawable.azerbaijan_grand_prix), new Date(31556952000L+1525003800000L), "Daniel Ricciardo (1)", "Red Bull (1)", "Sebastian Vettel - Ferrari - 1:41.498"));
        raceList.add(new CountdownUpcoming("Spanish Grand Prix", 66, "4.655 km", getApplicationContext().getResources().getDrawable(R.drawable.spanish_grand_prix), new Date(31556952000L+1526217000000L), "Michael Schumacher (6)", "Ferrari (12)", "Lewis Hamilton - Mercedes - 1:16.173"));
        raceList.add(new CountdownUpcoming("Monaco Grand Prix", 78, "3.337 km", getApplicationContext().getResources().getDrawable(R.drawable.monaco_grand_prix), new Date(31556952000L+1527426600000L), "Ayrton Senna (6)", "McLaren (15)", " Daniel Ricciardo - Red Bull Racing - 1:10.810"));
        raceList.add(new CountdownUpcoming("Canadian Grand Prix", 70, "4.361 km", getApplicationContext().getResources().getDrawable(R.drawable.canadian_grand_prix), new Date(31556952000L+1528654200000L), "Michael Schumacher (7)", "Ferrari (14)", "Sebastian Vettel - Ferrari - 1:10.764"));
        raceList.add(new CountdownUpcoming("French Grand Prix", 53, "5.842 km", getApplicationContext().getResources().getDrawable(R.drawable.french_grand_prix), new Date(31556952000L+1529849400000L), "Michael Schumacher (8)", "Ferrari (17)", "Lewis Hamilton - Mercedes - 1:30.029"));
        raceList.add(new CountdownUpcoming("Austrian Grand Prix", 71, "4.318 km", getApplicationContext().getResources().getDrawable(R.drawable.austrian_grand_prix), new Date(31556952000L+1530450600000L), "Alain Prost (3)", "McLaren (6)", "Valtteri Bottas - Mercedes - 1:03.130"));
        raceList.add(new CountdownUpcoming("British Grand Prix", 52, "5.891 km", getApplicationContext().getResources().getDrawable(R.drawable.british_grand_prix), new Date(31556952000L+1531055400000L), "Lewis Hamilton (5)", "Ferrari (16)", "Lewis Hamilton - Mercedes - 1:25.892"));
        raceList.add(new CountdownUpcoming("German Grand Prix", 67, "4.574 km", getApplicationContext().getResources().getDrawable(R.drawable.german_grand_prix), new Date(31556952000L+1532265000000L), "Rudolf Caracciola (6)", "Ferrari (22)", "Sebastian Vettel - Ferrari - 1:11.212"));
        raceList.add(new CountdownUpcoming("Hungarian Grand Prix", 70, "4.381 km", getApplicationContext().getResources().getDrawable(R.drawable.hungarian_grand_prix), new Date(31556952000L+1532869800000L), "Lewis Hamilton (5)", "McLaren (11)", "Sebastian Vettel - Ferrari - 1:16.276"));
        raceList.add(new CountdownUpcoming("Belgian Grand Prix", 44, "7.004 km", getApplicationContext().getResources().getDrawable(R.drawable.belgian_grand_prix), new Date(31556952000L+1535289000000L), "Michael Schumacher (6)", "Ferrari (16)", "Lewis Hamilton - Mercedes - 1:42.553"));
        raceList.add(new CountdownUpcoming("Italian Grand Prix", 53, "5.793 km", getApplicationContext().getResources().getDrawable(R.drawable.italian_grand_prix), new Date(31556952000L+1535893800000L), "Michael Schumacher (5)", "Ferrari (19)", "Lewis Hamilton - Mercedes - 1:35.554"));
        raceList.add(new CountdownUpcoming("Singapore Grand Prix", 61, "5.065 km", getApplicationContext().getResources().getDrawable(R.drawable.singaore_grand_prix), new Date(31556952000L+1537099800000L), "Sebastian Vettel (4)", "Ferrari (3)", "Sebastian Vettel - Ferrari - 1:39.491"));
        raceList.add(new CountdownUpcoming("Russian Grand Prix", 53, "5.848 km", getApplicationContext().getResources().getDrawable(R.drawable.russian_grand_prix), new Date(31556952000L+1538305800000L), "Lewis Hamilton (2)", "Mercedes (6)", "Sebastian Vettel - Ferrari - 1:33.194"));
        raceList.add(new CountdownUpcoming("Japanese Grand Prix", 53, "5.807 km", getApplicationContext().getResources().getDrawable(R.drawable.japanese_grand_prix), new Date(31556952000L+1538889000000L), "Michael Schumacher (6)", "McLaren (9)", "Lewis Hamilton - Mercedes - 1:27.319"));
        raceList.add(new CountdownUpcoming("United States Grand Prix", 56, "5.513 km", getApplicationContext().getResources().getDrawable(R.drawable.united_states_grand_prix), new Date(31556952000L+1540145400000L), "Lewis Hamilton (6)", "Ferrari (9)", "Lewis Hamilton - Mercedes - 1:33.108"));
        raceList.add(new CountdownUpcoming("Mexican Grand Prix", 71, "4.304 km", getApplicationContext().getResources().getDrawable(R.drawable.mexican_grand_prix), new Date(31556952000L+1540753800000L), "Jim Clark (3)", "Lotus (4)", "Sebastian Vettel - Ferrari - 1:16.488"));
        raceList.add(new CountdownUpcoming("Brazilian Grand Prix", 71, "4.309 km", getApplicationContext().getResources().getDrawable(R.drawable.brazilian_grand_prix), new Date(31556952000L+1541959800000L), "Alain Prost (6)", "McLaren (12)", "Valtteri Bottas - Mercedes - 1:08.322"));
        raceList.add(new CountdownUpcoming("Abu Dhabi Grand Prix", 55, "5.554 km", getApplicationContext().getResources().getDrawable(R.drawable.abu_dhabi_grand_prix), new Date(31556952000L+1543151400000L), "Lewis Hamilton (3)\nSebastian Vettel (3)", "Mercedes (4)", "Valtteri Bottas - Mercedes - 1:40.650"));

        for (int i = 0; i < raceList.size(); i++) {
            long raceTime = raceList.get(i).getEvent_time();
            if (raceTime < nowTime) {
                toRemoveList.add(raceList.get(i));
            }
        }
        raceList.removeAll(toRemoveList);
        viewPager = findViewById(R.id.vp_upcoming);
        adapter = new UpcomingAdapter(UpcomingActivity.this, raceList);
        viewPager.setAdapter(adapter);
    }
}
