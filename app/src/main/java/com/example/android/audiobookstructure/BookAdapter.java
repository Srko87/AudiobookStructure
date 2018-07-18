package com.example.android.audiobookstructure;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class BookAdapter extends ArrayAdapter<Book> {


    public BookAdapter(Activity context, ArrayList<Book> books) {

        super(context, 0, books);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.book_list_item, parent, false);
        }


        Book currentBook = getItem(position);

        TextView nameTextView = listItemView.findViewById(R.id.book_name_view);

        nameTextView.setText(currentBook.getbookNameID());

        nameTextView.setSelected(true);

        TextView authorTextView = listItemView.findViewById(R.id.book_author_view);

        authorTextView.setText(currentBook.getauthorNameID());

        ImageView iconView = listItemView.findViewById(R.id.book_icon_view);

        iconView.setImageResource(currentBook.getbookIconID());

        return listItemView;
    }
}