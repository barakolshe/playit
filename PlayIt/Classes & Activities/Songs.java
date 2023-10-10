package application.playit;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import application.playit.Database;

import java.util.Vector;

public class Songs extends AppCompatActivity{

    private EditText songName;
    private LinearLayout songsView;
    private Vector<String[]> songs;
    private Database db;
    private Intent game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);
        db = new Database(getApplicationContext());

        game = new Intent(getApplicationContext(), Game.class);
        songName = (EditText) findViewById(R.id.songName);
        songsView = (LinearLayout) findViewById(R.id.songs);
    }

    public void searchSongs(View v)
    {
        String song = songName.getText().toString();
        songs = db.findSong(song);

        songsView.removeAllViews();

        int size = songs.size();
        for (int i =0;i<size;i++)
        {
            Button button = new Button(this);
            button.setText(song + " / " + songs.elementAt(i)[1]);
            button.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
            button.setHeight(200);
            button.setGravity(Gravity.CENTER);
            button.setBackgroundResource(R.drawable.button);
            button.setAllCaps(false);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int i = v.getId();
                    game.putExtra("tabs", songs.elementAt(i)[0]);
                    game.putExtra("songName", songs.elementAt(i)[1]);
                    startActivity(game);
                }
            });
            button.setId(i);
            songsView.addView(button);
        }
    }

    public void addSong(View v)
    {
        db.addSong("123",songName.getText().toString(),"barakolshe");
    }
}
