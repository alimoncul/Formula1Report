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
import com.alimoncul.formula1report.Adapter.StandingsConstructorsAdapter;
import com.alimoncul.formula1report.StandingsParcelableConstructor;

import java.util.ArrayList;

public class FragmentStandingConstructors extends Fragment {
    public FragmentStandingConstructors() {
        // Required empty public constructor
    }

    RecyclerView recyclerView;
    ArrayList<StandingsParcelableConstructor> mStandingsForConstructors = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        try{
            mStandingsForConstructors = getArguments().getParcelableArrayList("mConstructorStandings");
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }

        View view = inflater.inflate(R.layout.fragment_standing_constructors, container, false);
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
        StandingsConstructorsAdapter adapter = new StandingsConstructorsAdapter(getActivity(), mStandingsForConstructors);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }
}

