package com.alimoncul.formula1report;

import android.os.Parcel;
import android.os.Parcelable;

public class StandingsParcelableDriver implements Parcelable {
    private int DriverPoint;
    private int DriverPosition;
    private int DriverWins;
    private String DriverName;
    private String FamilyName;
    private String DriverConstructor;
    private int DriverIconId;

    public StandingsParcelableDriver(int DriverPoint, int DriverPosition, int DriverWins, String DriverName, String FamilyName, String DriverConstructor, int DriverIconId) {
        this.DriverPoint = DriverPoint;
        this.DriverPosition = DriverPosition;
        this.DriverWins = DriverWins;
        this.DriverName = DriverName;
        this.FamilyName = FamilyName;
        this.DriverConstructor = DriverConstructor;
        this.DriverIconId = DriverIconId;
    }

    public StandingsParcelableDriver(Parcel in) {
        DriverPoint = in.readInt();
        DriverPosition = in.readInt();
        DriverWins = in.readInt();
        DriverName = in.readString();
        FamilyName = in.readString();
        DriverConstructor = in.readString();
        DriverIconId = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(DriverPoint);
        dest.writeInt(DriverPosition);
        dest.writeInt(DriverWins);
        dest.writeString(DriverName);
        dest.writeString(FamilyName);
        dest.writeString(DriverConstructor);
        dest.writeInt(DriverIconId);
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

    public int getDriverWins() {
        return DriverWins;
    }

    public void setDriverWins(int driverWins) {
        DriverWins = driverWins;
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

    public String getDriverConstructor() {
        return DriverConstructor;
    }

    public void setDriverConstructor(String driverConstructor) {
        DriverConstructor = driverConstructor;
    }

    public static final Creator<StandingsParcelableDriver> CREATOR = new Creator<StandingsParcelableDriver>() {
        @Override
        public StandingsParcelableDriver createFromParcel(Parcel in) {
            return new StandingsParcelableDriver(in);
        }

        @Override
        public StandingsParcelableDriver[] newArray(int size) {
            return new StandingsParcelableDriver[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    public int getDriverIconId() {
        return DriverIconId;
    }

    public void setDriverIconId(int driverIconId) {
        DriverIconId = driverIconId;
    }


}
