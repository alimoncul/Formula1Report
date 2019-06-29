package com.alimoncul.formula1report;

import android.os.Parcel;
import android.os.Parcelable;

public class StandingsParcelableConstructor implements Parcelable {

    private String constructorName;
    private int constructorWins;
    private int constructorPosition;
    private int constructorPoints;

    public StandingsParcelableConstructor(String constructorName, int constructorWins, int constructorPosition, int constructorPoints) {
        this.constructorName = constructorName;
        this.constructorWins = constructorWins;
        this.constructorPosition = constructorPosition;
        this.constructorPoints = constructorPoints;
    }

    public StandingsParcelableConstructor(Parcel in) {
        constructorName = in.readString();
        constructorWins = in.readInt();
        constructorPosition = in.readInt();
        constructorPoints = in.readInt();
    }

    public String getConstructorName() {
        return constructorName;
    }

    public static final Creator<StandingsParcelableConstructor> CREATOR = new Creator<StandingsParcelableConstructor>() {
        @Override
        public StandingsParcelableConstructor createFromParcel(Parcel in) {
            return new StandingsParcelableConstructor(in);
        }

        @Override
        public StandingsParcelableConstructor[] newArray(int size) {
            return new StandingsParcelableConstructor[size];
        }
    };

    public void setConstructorName(String constructorName) {
        this.constructorName = constructorName;
    }

    public int getConstructorWins() {
        return constructorWins;
    }

    public void setConstructorWins(int constructorWins) {
        this.constructorWins = constructorWins;
    }

    public int getConstructorPosition() {
        return constructorPosition;
    }

    public void setConstructorPosition(int constructorPosition) {
        this.constructorPosition = constructorPosition;
    }

    public int getConstructorPoints() {
        return constructorPoints;
    }

    public void setConstructorPoints(int constructorPoints) {
        this.constructorPoints = constructorPoints;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(constructorName);
        dest.writeInt(constructorWins);
        dest.writeInt(constructorPosition);
        dest.writeInt(constructorPoints);
    }
}
