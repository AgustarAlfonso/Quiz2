package com.example.quiz2;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Invoice implements Parcelable {
    String type;
    String tambahan;
    String waktu;
    String total;

    public Invoice() {
    }

    protected Invoice(Parcel in) {
        type = in.readString();
        tambahan = in.readString();
        waktu = in.readString();
        total = in.readString();
    }

    public static final Creator<Invoice> CREATOR = new Creator<Invoice>() {
        @Override
        public Invoice createFromParcel(Parcel in) {
            return new Invoice(in);
        }

        @Override
        public Invoice[] newArray(int size) {
            return new Invoice[size];
        }
    };

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTambahan() {
        return tambahan;
    }

    public void setTambahan(String tambahan) {
        this.tambahan = tambahan;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(type);
        dest.writeString(tambahan);
        dest.writeString(waktu);
        dest.writeString(total);
    }
}
