package com.alimoncul.formula1report.Fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alimoncul.formula1report.Adapter.ResultsRaceAdapter;
import com.alimoncul.formula1report.R;
import com.alimoncul.formula1report.ResultsParcelableRace;

import java.util.ArrayList;

public class FragmentResultsRace extends Fragment {
    public FragmentResultsRace() {
        // Required empty public constructor
    }

    RecyclerView recyclerView;
    ArrayList<ResultsParcelableRace> mRaceResults = new ArrayList<>();
    String raceName;
    TextView tv_raceName;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        try{
            mRaceResults = getArguments().getParcelableArrayList("mReRace");
            raceName = getArguments().getString("race_name");
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }

        View view = inflater.inflate(R.layout.fragment_result_race, container, false);
        recyclerView = view.findViewById(R.id.rv_standings);
        tv_raceName = view.findViewById(R.id.tv_raceName);
        tv_raceName.setText(raceName);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ResultsRaceAdapter adapter = new ResultsRaceAdapter(getActivity(), mRaceResults, 1);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }
}
