package com.alimoncul.formula1report;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class CountdownUpcoming extends Date implements Parcelable {
    private String name;
    private int laps;
    private String length;
    private Drawable upcoming_image;
    private Date event_time;
    private String most_wins_drivers;
    private String most_wins_constructors;
    private String last_pole;

    public CountdownUpcoming(String name, int laps, String length, Drawable upcoming_image, Date event_time, String most_wins_drivers, String most_wins_constructors, String last_pole){
        this.name=name;
        this.laps=laps;
        this.length=length;
        this.upcoming_image=upcoming_image;
        this.event_time=event_time;
        this.most_wins_drivers=most_wins_drivers;
        this.most_wins_constructors=most_wins_constructors;
        this.last_pole=last_pole;
    }

    public CountdownUpcoming(Parcel in) {
        name = in.readString();
        laps = in.readInt();
        length = in.readString();
        upcoming_image = (Drawable)in.readParcelable(getClass().getClassLoader());
        event_time = new Date(in.readLong());
        most_wins_drivers = in.readString();
        most_wins_constructors = in.readString();
        last_pole = in.readString();
    }

    public String getMost_wins_drivers() {
        return most_wins_drivers;
    }

    public void setMost_wins_drivers(String most_wins_drivers) {
        this.most_wins_drivers = most_wins_drivers;
    }

    public String getMost_wins_constructors() {
        return most_wins_constructors;
    }

    public void setMost_wins_constructors(String most_wins_constructors) {
        this.most_wins_constructors = most_wins_constructors;
    }

    public String getLast_pole() {
        return last_pole;
    }

    public void setLast_pole(String last_pole) {
        this.last_pole = last_pole;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        Bitmap bitmap = (Bitmap)((BitmapDrawable) upcoming_image).getBitmap();
        dest.writeString(name);
        dest.writeInt(laps);
        dest.writeString(length);
        dest.writeParcelable(bitmap, flags);
        dest.writeLong(event_time.getTime());
        dest.writeString(most_wins_drivers);
        dest.writeString(most_wins_constructors);
        dest.writeString(last_pole);

    }
    public static final Creator<ResultsParcelableRace> CREATOR = new Creator<ResultsParcelableRace>() {
        @Override
        public ResultsParcelableRace createFromParcel(Parcel in) {
            return new ResultsParcelableRace(in);
        }

        @Override
        public ResultsParcelableRace[] newArray(int size) {
            return new ResultsParcelableRace[size];
        }
    };
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLaps() {
        return laps;
    }

    public void setLaps(int laps) {
        this.laps = laps;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public Drawable getUpcoming_image() {
        return upcoming_image;
    }

    public void setUpcoming_image(Drawable upcoming_image) {
        this.upcoming_image = upcoming_image;
    }

    public long getEvent_time() {
        return event_time.getTime();
    }

    public void setEvent_time(Date event_time) {
        this.event_time = event_time;
    }

    @Override
    public int describeContents() {
        return 0;
    }


}
