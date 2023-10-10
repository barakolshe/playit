package application.playit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void tuner(View v)
    {
        Intent tunerIntent = new Intent(getApplicationContext(), Tuner.class);
        startActivity(tunerIntent);
    }

    public void game(View v)
    {
        Intent gameIntent = new Intent(getApplicationContext(), Game.class);
        startActivity(gameIntent);
    }

    public void songs(View v)
    {
        Intent songsIntent = new Intent(getApplicationContext(), Songs.class);
        startActivity(songsIntent);
    }

    public void addSong(View v)
    {
        Intent addSongIntent = new Intent(getApplicationContext(), AddSongs.class);
        startActivity(addSongIntent);
    }
}
