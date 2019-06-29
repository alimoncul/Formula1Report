package com.alimoncul.formula1report.Fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alimoncul.formula1report.Adapter.ResultsQualifyingAdapter;
import com.alimoncul.formula1report.R;
import com.alimoncul.formula1report.ResultsParcelableQualifying;

import java.util.ArrayList;

public class FragmentResultQualifying extends Fragment {
    public FragmentResultQualifying() {
        // Required empty public constructor
    }

    RecyclerView recyclerView;
    ArrayList<ResultsParcelableQualifying> mQualifyingResults = new ArrayList<>();
    String raceName;
    TextView tv_raceName;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        try{
            mQualifyingResults = getArguments().getParcelableArrayList("qualifying");
            raceName = getArguments().getString("qualifyingName");
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }

        View view = inflater.inflate(R.layout.fragment_result_qualifying, container, false);
        recyclerView = view.findViewById(R.id.rv_standings);
        tv_raceName = view.findViewById(R.id.tv_raceName);
        tv_raceName.setText(raceName);
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ResultsQualifyingAdapter adapter = new ResultsQualifyingAdapter(getActivity(), mQualifyingResults);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }
}
