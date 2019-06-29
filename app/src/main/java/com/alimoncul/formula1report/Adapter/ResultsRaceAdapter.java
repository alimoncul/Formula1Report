package com.alimoncul.formula1report.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alimoncul.formula1report.R;
import com.alimoncul.formula1report.ResultsParcelableRace;

import java.util.ArrayList;

public class ResultsRaceAdapter extends RecyclerView.Adapter<ResultsRaceAdapter.ViewHolder> {

    private Context mContext;
    ArrayList<ResultsParcelableRace> raceArrayList;
    int color;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tv_position;
        public TextView tv_constructorsname;
        public TextView tv_drivername;
        public TextView tv_points;
        public ConstraintLayout constraintLayout;

        public ViewHolder(View v) {
            super(v);
            tv_position = v.findViewById(R.id.tv_position_race);
            tv_constructorsname = v.findViewById(R.id.tv_constructorname_race);
            tv_points = v.findViewById(R.id.tv_points_race);
            tv_drivername = v.findViewById(R.id.tv_drivername_race);
            constraintLayout = v.findViewById(R.id.constraintResult);
        }
    }

    public ResultsRaceAdapter(Context context, ArrayList<ResultsParcelableRace> raceList, int color) {
        this.raceArrayList = raceList;
        this.mContext = context;
        this.color = color;
    }

    @NonNull
    @Override
    public ResultsRaceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.results_row, parent, false);
        ViewHolder view_holder = new ViewHolder(v);
        return view_holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ResultsParcelableRace parcelableRace = raceArrayList.get(position);
        holder.tv_drivername.setText(parcelableRace.getDriverName() + " " + parcelableRace.getFamilyName());
        holder.tv_constructorsname.setText(parcelableRace.getConstructor());
        holder.tv_position.setText(String.format("%02d", parcelableRace.getDriverPosition())+"");
        holder.tv_points.setText(parcelableRace.getDriverPoint() + "");
        if(color == 1){
            switch (parcelableRace.getConstructor()) {
                case "Ferrari":
                    holder.constraintLayout.setBackgroundColor(mContext.getResources().getColor(R.color.colorFerrari));
                    break;
                case "Mercedes":
                    holder.constraintLayout.setBackgroundColor(mContext.getResources().getColor(R.color.colorMercedes));
                    break;
                case "Red Bull":
                    holder.constraintLayout.setBackgroundColor(mContext.getResources().getColor(R.color.colorRedbull));
                    break;
                case "Renault":
                    holder.constraintLayout.setBackgroundColor(mContext.getResources().getColor(R.color.colorRenault));
                    break;
                case "Haas F1 Team":
                    holder.constraintLayout.setBackgroundColor(mContext.getResources().getColor(R.color.colorHaasF1Team));
                    break;
                case "Force India":
                    holder.constraintLayout.setBackgroundColor(mContext.getResources().getColor(R.color.colorForceIndia));
                    break;
                case "McLaren":
                    holder.constraintLayout.setBackgroundColor(mContext.getResources().getColor(R.color.colorMcLaren));
                    break;
                case "Toro Rosso":
                    holder.constraintLayout.setBackgroundColor(mContext.getResources().getColor(R.color.colorToroRosso));
                    break;
                case "Sauber":
                    holder.constraintLayout.setBackgroundColor(mContext.getResources().getColor(R.color.colorSauber));
                    break;
                case "Williams":
                    holder.constraintLayout.setBackgroundColor(mContext.getResources().getColor(R.color.colorWilliams));
                    break;
                default:
                    holder.constraintLayout.setBackgroundColor(mContext.getResources().getColor(R.color.colorWhite));
                    break;
            }
        }

    }

    @Override
    public int getItemCount() {
        return raceArrayList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


}
