package com.alimoncul.formula1report.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alimoncul.formula1report.R;
import com.alimoncul.formula1report.StandingsParcelableDriver;

import java.util.ArrayList;

public class StandingsDriversAdapter extends RecyclerView.Adapter<StandingsDriversAdapter.ViewHolder> {

    ArrayList<StandingsParcelableDriver> driversArrayList;
    private Context mContext;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_drivericon;
        TextView tv_position;
        TextView tv_drivername;
        TextView tv_constructorsname;
        TextView tv_driverpoints;

        ViewHolder(View v) {
            super(v);
            iv_drivericon = v.findViewById(R.id.iv_drivericon);
            tv_position = v.findViewById(R.id.tv_position);
            tv_drivername = v.findViewById(R.id.tv_drivername_race);
            tv_constructorsname = v.findViewById(R.id.tv_constructorsname);
            tv_driverpoints = v.findViewById(R.id.tv_driverpoints);
        }
    }

    public StandingsDriversAdapter(Context context, ArrayList<StandingsParcelableDriver> driverArrayList) {
        this.driversArrayList = driverArrayList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public StandingsDriversAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.standings_drivers, parent, false);
        ViewHolder view_holder = new ViewHolder(v);
        return view_holder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StandingsParcelableDriver parcelableDriver = driversArrayList.get(position);
        holder.iv_drivericon.setImageResource(parcelableDriver.getDriverIconId());
        holder.tv_constructorsname.setText(parcelableDriver.getDriverConstructor());
        holder.tv_position.setText(parcelableDriver.getDriverPosition() + "");
        holder.tv_drivername.setText(parcelableDriver.getDriverName() + " " + parcelableDriver.getFamilyName());
        holder.tv_driverpoints.setText(parcelableDriver.getDriverPoint() + "");
        switch (parcelableDriver.getDriverName()) {
            case "Sebastian":
                holder.iv_drivericon.setImageResource(R.drawable.icon_vettel);
                break;
            case "Lewis":
                holder.iv_drivericon.setImageResource(R.drawable.icon_hamilton);
                break;
            case "Kimi":
                holder.iv_drivericon.setImageResource(R.drawable.icon_raikkonen);
                break;
            case "Daniel":
                holder.iv_drivericon.setImageResource(R.drawable.icon_ricciardo);
                break;
            case "Valtteri":
                holder.iv_drivericon.setImageResource(R.drawable.icon_bottas);
                break;
            case "Max":
                holder.iv_drivericon.setImageResource(R.drawable.icon_verstappen);
                break;
            case "Nico":
                holder.iv_drivericon.setImageResource(R.drawable.icon_hulkenberg);
                break;
            case "Fernando":
                holder.iv_drivericon.setImageResource(R.drawable.icon_alonso);
                break;
            case "Kevin":
                holder.iv_drivericon.setImageResource(R.drawable.icon_magnussen);
                break;
            case "Carlos":
                holder.iv_drivericon.setImageResource(R.drawable.icon_sainz);
                break;
            case "Esteban":
                holder.iv_drivericon.setImageResource(R.drawable.icon_ocon);
                break;
            case "Sergio":
                holder.iv_drivericon.setImageResource(R.drawable.icon_perez);
                break;
            case "Pierre":
                holder.iv_drivericon.setImageResource(R.drawable.icon_gasly);
                break;
            case "Charles":
                holder.iv_drivericon.setImageResource(R.drawable.icon_leclerc);
                break;
            case "Romain":
                holder.iv_drivericon.setImageResource(R.drawable.icon_grosjean);
                break;
            case "Stoffel":
                holder.iv_drivericon.setImageResource(R.drawable.icon_vandoorne);
                break;
            case "Lance":
                holder.iv_drivericon.setImageResource(R.drawable.icon_stroll);
                break;
            case "Marcus":
                holder.iv_drivericon.setImageResource(R.drawable.icon_ericsson);
                break;
            case "Brendon":
                holder.iv_drivericon.setImageResource(R.drawable.icon_hartley);
                break;
            case "Sergey":
                holder.iv_drivericon.setImageResource(R.drawable.icon_sirotkin);
                break;
            default:
                holder.iv_drivericon.setImageResource(R.drawable.icon_driver_default);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return driversArrayList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


}
