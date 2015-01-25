package ru.kpb90.p0031firstproject.modal;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by eMachines on 25.01.2015.
 */
public class News implements Parcelable {
    private final String imageUrl;
    private final String title;
    private final String descr;

    public News(String imageUrl, String title, String descr) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.descr = descr;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getDescr() {
        return descr;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.imageUrl);
        dest.writeString(this.title);
        dest.writeString(this.descr);
    }

    private News(Parcel in) {
        this.imageUrl = in.readString();
        this.title = in.readString();
        this.descr = in.readString();
    }

    public static final Parcelable.Creator<News> CREATOR = new Parcelable.Creator<News>() {
        public News createFromParcel(Parcel source) {
            return new News(source);
        }

        public News[] newArray(int size) {
            return new News[size];
        }
    };
}
