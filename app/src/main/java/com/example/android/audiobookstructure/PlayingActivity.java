package com.example.android.audiobookstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayingActivity extends AppCompatActivity {

    public static boolean playOrPause = true;
    public static String statePlayOrPause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);

        if (savedInstanceState != null) {
            playOrPause = savedInstanceState.getBoolean(statePlayOrPause);
        }
        ;

        Intent playing = getIntent();
        Book currentBook = playing.getParcelableExtra("Book");


        int bookIcon = currentBook.getbookIconID();
        int bookName = currentBook.getbookNameID();
        int authorName = currentBook.getauthorNameID();

        ImageView bookIconView = findViewById(R.id.book_icon_view);
        bookIconView.setImageResource(bookIcon);

        TextView bookNameView = findViewById(R.id.book_name_view);
        bookNameView.setText(bookName);

        TextView authorNameView = findViewById(R.id.book_author_view);
        authorNameView.setText(authorName);

        final ImageView playPause = findViewById(R.id.play_and_pause);

        if (playOrPause) {
            playPause.setImageResource(R.drawable.ic_pause);
        } else {
            playPause.setImageResource(R.drawable.ic_play_arrow);
        }


        playPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (playOrPause) {
                    playOrPause = false;
                    playPause.setImageResource(R.drawable.ic_play_arrow);
                    return;
                }

                playOrPause = true;
                playPause.setImageResource(R.drawable.ic_pause);
            }
        });

        TextView toLibrary = findViewById(R.id.to_library);

        toLibrary.setOnClickListener(new View.OnClickListener()

        {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(PlayingActivity.this, MainActivity.class);
                startActivity(numbersIntent);
            }
        });

    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(statePlayOrPause, playOrPause);
    }


    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        playOrPause = savedInstanceState.getBoolean(statePlayOrPause);
    }

}