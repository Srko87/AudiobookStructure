package com.example.android.audiobookstructure;

public class Genre {

    private int mGenreNameID;

    private int mGenreIconId;

    private int mGenreColor;


    public Genre(int genreNameId, int iconResourceId, int genreColorId) {
        mGenreNameID = genreNameId;
        mGenreIconId = iconResourceId;
        mGenreColor = genreColorId;
    }


    public int getGenreNameID() {
        return mGenreNameID;
    }


    public int getImageResourceId() {
        return mGenreIconId;
    }


    public int getColorId() {
        return mGenreColor;
    }
}
