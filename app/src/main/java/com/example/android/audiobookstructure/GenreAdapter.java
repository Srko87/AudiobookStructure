package com.example.android.audiobookstructure;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GenreAdapter extends ArrayAdapter<Genre> {

    public GenreAdapter(Activity context, ArrayList<Genre> sortByGenre) {

        super(context, 0, sortByGenre);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.genre_list, parent, false);
        }

        Genre currentGenre = getItem(position);

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.genre_name_view);

        nameTextView.setText(currentGenre.getGenreNameID());

        nameTextView.setBackgroundResource(currentGenre.getColorId());


        ImageView iconView = (ImageView) listItemView.findViewById(R.id.genre_icon_view);

        iconView.setImageResource(currentGenre.getImageResourceId());


        return listItemView;
    }
}
