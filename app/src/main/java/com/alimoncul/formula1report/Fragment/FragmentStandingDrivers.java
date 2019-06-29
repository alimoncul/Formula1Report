package com.alimoncul.formula1report.Fragment;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alimoncul.formula1report.R;
import com.alimoncul.formula1report.Adapter.StandingsDriversAdapter;
import com.alimoncul.formula1report.StandingsParcelableDriver;

import java.util.ArrayList;

public class FragmentStandingDrivers extends Fragment {
    public FragmentStandingDrivers() {
        // Required empty public constructor
    }

    ArrayList<StandingsParcelableDriver> mStandingsForDrivers = new ArrayList<>();
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        try{
            mStandingsForDrivers = getArguments().getParcelableArrayList("mDriverStandings");
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }
        View view = inflater.inflate(R.layout.fragment_standing_drivers, container, false);
        recyclerView = view.findViewById(R.id.rv_standings);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        StandingsDriversAdapter adapter = new StandingsDriversAdapter(getActivity(), mStandingsForDrivers);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

    }


}
