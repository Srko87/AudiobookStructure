package com.example.android.audiobookstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ArrayList<Genre> sortByGenre = new ArrayList<>();
        sortByGenre.add(new Genre(R.string.full_library, R.drawable.book_pile, R.color.black));
        sortByGenre.add(new Genre(R.string.fantasy, R.drawable.dragon_head, R.color.black));
        sortByGenre.add(new Genre(R.string.scifi, R.drawable.astronaut_helmet, R.color.black));
        sortByGenre.add(new Genre(R.string.horror, R.drawable.terror, R.color.black));
        sortByGenre.add(new Genre(R.string.self_help, R.drawable.help, R.color.black));

        GenreAdapter genreChoice = new GenreAdapter(this, sortByGenre);

        final ListView listView = findViewById(R.id.genre_list);
        listView.setAdapter(genreChoice);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                switch (position) {
                    case 0:

                        Intent fullLibraryIntent = new Intent(MainActivity.this, FullLibraryActivity.class);
                        startActivity(fullLibraryIntent);
                        break;

                    case 1:
                        Intent fantasyIntent = new Intent(MainActivity.this, FantasyActivity.class);
                        startActivity(fantasyIntent);
                        break;

                    case 2:
                        Intent scifiIntent = new Intent(MainActivity.this, ScifiActivity.class);
                        startActivity(scifiIntent);
                        break;


                    case 3:
                        Intent horrorIntent = new Intent(MainActivity.this, HorrorActivity.class);
                        startActivity(horrorIntent);
                        break;

                    case 4:
                        Toast.makeText(getApplicationContext(), getString(R.string.no_books), Toast.LENGTH_SHORT).show();
                        break;

                    default:
                        break;

                }

            }
        });
    }

}
