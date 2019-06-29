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
import com.alimoncul.formula1report.ResultsParcelableQualifying;

import java.util.ArrayList;
import java.util.Locale;

public class ResultsQualifyingAdapter extends RecyclerView.Adapter<ResultsQualifyingAdapter.ViewHolder> {

    private Context mContext;
    ArrayList<ResultsParcelableQualifying> qualifyingList;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tv_QualifyingPosition;
        public TextView tv_constructorsname;
        public TextView tv_drivername;
        public TextView tv_qualifyingTime;
        public ConstraintLayout constraintLayout;

        public ViewHolder(View v) {
            super(v);
            tv_QualifyingPosition = v.findViewById(R.id.tv_position_race);
            tv_constructorsname = v.findViewById(R.id.tv_constructornameQualifying);
            tv_qualifyingTime = v.findViewById(R.id.tv_qualifyingTime);
            tv_drivername = v.findViewById(R.id.tv_drivernameQualifying);
            constraintLayout = v.findViewById(R.id.constraintResult);
        }
    }
    public ResultsQualifyingAdapter(Context context, ArrayList<ResultsParcelableQualifying> qualifyingList) {
        this.qualifyingList = qualifyingList;
        this.mContext = context;
    }
    @NonNull
    @Override
    public ResultsQualifyingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.qualifying_row, parent, false);
        ResultsQualifyingAdapter.ViewHolder view_holder = new ResultsQualifyingAdapter.ViewHolder(v);
        return view_holder;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ResultsParcelableQualifying parcelableQualifying = qualifyingList.get(position);
        holder.tv_drivername.setText(parcelableQualifying.getDriverName() + " " + parcelableQualifying.getFamilyName());
        holder.tv_constructorsname.setText(parcelableQualifying.getConstructor());
        holder.tv_QualifyingPosition.setText(String.format(Locale.US,"%02d", parcelableQualifying.getQualifyingPosition())+"");
        holder.tv_QualifyingPosition.setText(String.format(Locale.US,"%02d", parcelableQualifying.getQualifyingPosition())+"");
        holder.tv_qualifyingTime.setText(parcelableQualifying.getQualifyingTime());
        switch (parcelableQualifying.getConstructor()) {
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
    @Override
    public int getItemCount() {
        return qualifyingList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
