package com.alimoncul.formula1report.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alimoncul.formula1report.CountdownUpcoming;
import com.alimoncul.formula1report.R;

import java.util.ArrayList;

import cn.iwgang.countdownview.CountdownView;

public class UpcomingAdapter extends PagerAdapter {

    ArrayList<CountdownUpcoming> mRaceList = new ArrayList<>();

    private Context context;
    private LayoutInflater layoutInflater;

    public UpcomingAdapter(Context ctx, ArrayList<CountdownUpcoming> mRaceList)
    {
        this.context = ctx;
        this.mRaceList = mRaceList;

    }

    @Override
    public int getCount() {
        return mRaceList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view==(ConstraintLayout)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        CountdownUpcoming countdownUpcoming = mRaceList.get(position);
        Typeface tp;
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = layoutInflater.inflate(R.layout.upcoming_grandprix, container, false);
        TextView tv_name = v.findViewById(R.id.tv_name);
        TextView tv_round = v.findViewById(R.id.tv_round);
        TextView tv_laps = v.findViewById(R.id.tv_laps);
        TextView tv_length = v.findViewById(R.id.tv_length);
        TextView tv_lastpole = v.findViewById(R.id.tv_last_pole);
        ImageView iv_grandPrixImg = v.findViewById(R.id.iv_grandPrixImg);
        CountdownView countDown = v.findViewById(R.id.countDown);


        tv_name.setText(countdownUpcoming.getName());
        tv_round.setText("Round "+(22-mRaceList.size()+position)+" of 21");
        tv_laps.setText(countdownUpcoming.getLaps()+"");
        tv_length.setText(countdownUpcoming.getLength());
        tv_lastpole.setText(countdownUpcoming.getLast_pole());
        iv_grandPrixImg.setImageDrawable(countdownUpcoming.getUpcoming_image());
        countDown.start(countdownUpcoming.getEvent_time()-System.currentTimeMillis());
        container.addView(v);
        return v;
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
