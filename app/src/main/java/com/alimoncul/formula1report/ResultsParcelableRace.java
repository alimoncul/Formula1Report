package com.alimoncul.formula1report;

import android.os.Parcel;
import android.os.Parcelable;

public class ResultsParcelableRace implements Parcelable {
    private int DriverPoint;
    private int DriverPosition;
    private String DriverName;
    private String FamilyName;
    private String Constructor;


    public ResultsParcelableRace(int driverPoint, int driverPosition, String driverName, String familyName, String constructor) {
        this.DriverPoint = driverPoint;
        this.DriverPosition = driverPosition;
        this.DriverName = driverName;
        this.FamilyName = familyName;
        this.Constructor = constructor;
    }

    public ResultsParcelableRace(Parcel in) {
        DriverPoint = in.readInt();
        DriverPosition = in.readInt();
        DriverName = in.readString();
        FamilyName = in.readString();
        Constructor = in.readString();
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(DriverPoint);
        dest.writeInt(DriverPosition);
        dest.writeString(DriverName);
        dest.writeString(FamilyName);
        dest.writeString(Constructor);
    }

    public int getDriverPoint() {
        return DriverPoint;
    }

    public void setDriverPoint(int driverPoint) {
        DriverPoint = driverPoint;
    }

    public int getDriverPosition() {
        return DriverPosition;
    }

    public void setDriverPosition(int driverPosition) {
        DriverPosition = driverPosition;
    }

    public String getDriverName() {
        return DriverName;
    }

    public void setDriverName(String driverName) {
        DriverName = driverName;
    }

    public String getFamilyName() {
        return FamilyName;
    }

    public void setFamilyName(String familyName) {
        FamilyName = familyName;
    }

    public String getConstructor() {
        return Constructor;
    }

    public void setConstructor(String constructor) {
        Constructor = constructor;
    }
}
