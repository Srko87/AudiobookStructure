package com.example.android.audiobookstructure;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    private int mBookNameID;

    private int mAuthorNameID;

    private int mBookIconId;


    public Book(int bookNameId, int authorNameId, int bookIconId) {
        mBookNameID = bookNameId;
        mAuthorNameID = authorNameId;
        mBookIconId = bookIconId;
    }

    protected Book(Parcel in) {
        mBookNameID = in.readInt();
        mAuthorNameID = in.readInt();
        mBookIconId = in.readInt();
    }


    public int getbookNameID() {
        return mBookNameID;
    }


    public int getauthorNameID() {
        return mAuthorNameID;
    }


    public int getbookIconID() {
        return mBookIconId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mBookNameID);
        parcel.writeInt(mAuthorNameID);
        parcel.writeInt(mBookIconId);
    }
}
