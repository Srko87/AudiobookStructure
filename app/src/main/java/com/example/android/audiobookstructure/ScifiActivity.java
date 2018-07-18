package com.example.android.audiobookstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ScifiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        ImageView iconView = findViewById(R.id.genre_icon_view);
        TextView genreView = findViewById(R.id.genre_name_view);

        iconView.setImageResource(R.drawable.astronaut_helmet);
        genreView.setBackgroundColor(getResources().getColor(R.color.black));
        genreView.setText(R.string.scifi);

        final ArrayList<Book> books = new ArrayList<>();
        books.add(new Book(R.string.scifi_book_1, R.string.scifi_author_1, R.drawable.snowflake_1));
        books.add(new Book(R.string.scifi_book_2, R.string.scifi_author_2, R.drawable.mars_pathfinder));
        books.add(new Book(R.string.scifi_book_3, R.string.scifi_author_3, R.drawable.sands_of_time));

        BookAdapter showBooks = new BookAdapter(this, books);

        final ListView listView = findViewById(R.id.book_list);
        listView.setAdapter(showBooks);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent playing = new Intent(ScifiActivity.this, PlayingActivity.class);
                playing.putExtra("Book", books.get(position));

                startActivity(playing);
            }
        });

        TextView toLibrary = findViewById(R.id.back_to_library);

        toLibrary.setOnClickListener(new View.OnClickListener()

        {

            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(ScifiActivity.this, MainActivity.class);
                startActivity(numbersIntent);
            }
        });


    }

}
