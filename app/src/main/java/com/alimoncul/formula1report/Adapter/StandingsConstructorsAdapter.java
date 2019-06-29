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
import com.alimoncul.formula1report.StandingsParcelableConstructor;

import java.util.ArrayList;

public class StandingsConstructorsAdapter extends RecyclerView.Adapter<StandingsConstructorsAdapter.ViewHolder> {

    ArrayList<StandingsParcelableConstructor> constructorArrayList;
    private Context mContext;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tv_position;
        public TextView tv_constructorsname;
        public TextView tv_constructorspoints;
        public ConstraintLayout constraintBg;

        public ViewHolder(View v) {
            super(v);
            tv_position = v.findViewById(R.id.tv_position);
            tv_constructorsname = v.findViewById(R.id.tv_constructorsname);
            tv_constructorspoints = v.findViewById(R.id.tv_constructorspoints);
            constraintBg = v.findViewById(R.id.constraintBg);
        }
    }

    public StandingsConstructorsAdapter(Context context, ArrayList<StandingsParcelableConstructor> constructorArrayList) {
        this.constructorArrayList = constructorArrayList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public StandingsConstructorsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.standings_constructors, parent, false);
        ViewHolder view_holder = new ViewHolder(v);
        return view_holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StandingsParcelableConstructor parcelableConstructor = constructorArrayList.get(position);
        holder.tv_constructorsname.setText(parcelableConstructor.getConstructorName());
        holder.tv_position.setText(String.format("%02d", parcelableConstructor.getConstructorPosition())+"");
        holder.tv_constructorspoints.setText(parcelableConstructor.getConstructorPoints() + "");
        switch (parcelableConstructor.getConstructorName()) {
            case "Ferrari":
                holder.constraintBg.setBackgroundColor(mContext.getResources().getColor(R.color.colorFerrari));
                break;
            case "Mercedes":
                holder.constraintBg.setBackgroundColor(mContext.getResources().getColor(R.color.colorMercedes));
                break;
            case "Red Bull":
                holder.constraintBg.setBackgroundColor(mContext.getResources().getColor(R.color.colorRedbull));
                break;
            case "Renault":
                holder.constraintBg.setBackgroundColor(mContext.getResources().getColor(R.color.colorRenault));
                break;
            case "Haas F1 Team":
                holder.constraintBg.setBackgroundColor(mContext.getResources().getColor(R.color.colorHaasF1Team));
                break;
            case "Force India":
                holder.constraintBg.setBackgroundColor(mContext.getResources().getColor(R.color.colorForceIndia));
                break;
            case "McLaren":
                holder.constraintBg.setBackgroundColor(mContext.getResources().getColor(R.color.colorMcLaren));
                break;
            case "Toro Rosso":
                holder.constraintBg.setBackgroundColor(mContext.getResources().getColor(R.color.colorToroRosso));
                break;
            case "Sauber":
                holder.constraintBg.setBackgroundColor(mContext.getResources().getColor(R.color.colorSauber));
                break;
            case "Williams":
                holder.constraintBg.setBackgroundColor(mContext.getResources().getColor(R.color.colorWilliams));
                break;
            default:
                holder.constraintBg.setBackgroundColor(mContext.getResources().getColor(R.color.colorWhite));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return constructorArrayList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
