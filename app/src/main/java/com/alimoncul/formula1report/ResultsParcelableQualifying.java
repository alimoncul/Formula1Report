package com.alimoncul.formula1report;

import android.os.Parcel;
import android.os.Parcelable;

public class ResultsParcelableQualifying implements Parcelable {
    private int QualifyingPosition;
    private String DriverName;
    private String FamilyName;
    private String Constructor;
    private String QualifyingTime;

    public ResultsParcelableQualifying(int QualifyingPosition, String DriverName, String FamilyName, String Constructor, String QualifyingTime) {
        this.QualifyingPosition = QualifyingPosition;
        this.DriverName = DriverName;
        this.FamilyName = FamilyName;
        this.Constructor = Constructor;
        this.QualifyingTime = QualifyingTime;
    }

    public ResultsParcelableQualifying(Parcel in) {
        QualifyingPosition = in.readInt();
        DriverName = in.readString();
        FamilyName = in.readString();
        Constructor = in.readString();
        QualifyingTime = in.readString();
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(QualifyingPosition);
        dest.writeString(DriverName);
        dest.writeString(FamilyName);
        dest.writeString(Constructor);
        dest.writeString(QualifyingTime);
    }
    public static final Creator<ResultsParcelableQualifying> CREATOR = new Creator<ResultsParcelableQualifying>() {
        @Override
        public ResultsParcelableQualifying createFromParcel(Parcel in) {
            return new ResultsParcelableQualifying(in);
        }

        @Override
        public ResultsParcelableQualifying[] newArray(int size) {
            return new ResultsParcelableQualifying[size];
        }
    };
    public int getQualifyingPosition() {
        return QualifyingPosition;
    }

    public void setQualifyingPosition(int qualifyingPosition) {
        QualifyingPosition = qualifyingPosition;
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

    public String getQualifyingTime() {
        return QualifyingTime;
    }

    public void setQualifyingTime(String qualifyingTime) {
        QualifyingTime = qualifyingTime;
    }
    @Override
    public int describeContents() {
        return 0;
    }
}
