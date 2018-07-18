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

public class FantasyActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);


        ImageView iconView = findViewById(R.id.genre_icon_view);
        TextView genreView = findViewById(R.id.genre_name_view);

        iconView.setImageResource(R.drawable.dragon_head);
        genreView.setBackgroundColor(getResources().getColor(R.color.black));
        genreView.setText(R.string.fantasy);

        final ArrayList<Book> books = new ArrayList<>();
        books.add(new Book(R.string.fantasy_book_1, R.string.fantasy_author_1, R.drawable.stag_head));
        books.add(new Book(R.string.fantasy_book_2, R.string.fantasy_author_2, R.drawable.ring));
        books.add(new Book(R.string.fantasy_book_3, R.string.fantasy_author_3, R.drawable.snitch_quidditch_ball));
        books.add(new Book(R.string.fantasy_book_4, R.string.fantasy_author_4, R.drawable.lion));

        BookAdapter showBooks = new BookAdapter(this, books);

        final ListView listView = findViewById(R.id.book_list);
        listView.setAdapter(showBooks);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent playing = new Intent(FantasyActivity.this, PlayingActivity.class);
                playing.putExtra("Book", books.get(position));

                startActivity(playing);
            }
        });

        TextView toLibrary = findViewById(R.id.back_to_library);

        toLibrary.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(FantasyActivity.this, MainActivity.class);
                startActivity(numbersIntent);
            }
        });


    }

}