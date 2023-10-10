package application.playit;

/**
 * Created by User on 02-Feb-18.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.app.Application;
import java.util.Vector;

public class Database extends SQLiteOpenHelper{

    Database(Context context)
    {
        super(context, "PlayIt", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE IF NOT EXISTS users(username VARCHAR,password VARCHAR, PRIMARY KEY(username));");
        db.execSQL("CREATE TABLE IF NOT EXISTS songs(tabs TEXT, songName VARCHAR, username VARCHAR);");
        db.execSQL("CREATE TABLE IF NOT EXISTS scores(songName VARCHAR, score INTEGER, PRIMARY KEY(songName));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS users");
        db.execSQL("DROP TABLE IF EXISTS songs");
        db.execSQL("DROP TABLE IF EXISTS scores");

        onCreate(db);
    }

    @Override
    public void onOpen(SQLiteDatabase db)
    {

    }

    public void addUser(String username, String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        db.insert("users", null, contentValues);
    }

    public boolean doesUserExists(String username)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT username FROM users WHERE username='"+username+"' LIMIT 1;", null);
        int result = c.getCount();
        c.close();
        return result != 0? true:false;
    }

    public boolean checkUser(String username, String password)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT password FROM users WHERE username='"+username+"' LIMIT 1;", null);
        int result = c.getCount();
        if (result == 0)
        {
            c.close();
            return false;
        }
        else
        {
            c.moveToFirst();
            if (c.getString(0).equals(password))
            {
                c.close();
                return true;
            }
            else
            {
                c.close();
                return false;
            }
        }
    }

    public boolean doesSongExists(String songName)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT songName FROM songs WHERE songName='"+songName+"' LIMIT 1;", null);
        int result = c.getCount();
        c.close();
        return result != 0? true:false;
    }

    public void addSong(String tabs, String songName, String username)
    {
        if (this.doesUserExists(username)) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("tabs", tabs);
            contentValues.put("songName", songName);
            contentValues.put("username", username);
            db.insert("songs", null, contentValues);
        }
    }

    public Vector<String[]> findSong(String songName)
    {
        Vector<String[]> returnValue = new Vector<String[]>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor rs = db.rawQuery("SELECT tabs,username FROM songs WHERE songName='"+songName+"';", null);
        int count = rs.getCount();
        for (int i = 0;i<count;i++)
        {
            rs.moveToFirst();
            returnValue.add(new String[]{rs.getString(0), rs.getString(1)});
        }
        rs.close();
        return returnValue;
    }

    public void addScore(String songName, int score)
    {
        if (doesSongExists(songName)) {
            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("songName", songName);
            contentValues.put("score", score);

            int result = getScore(songName);
            if (result == -1) {
                db.insert("scores", null, contentValues);
            }
            else
            {
                db.update("scores", contentValues, "songName='"+songName+"'",null);
            }
        }
    }

    public int getScore(String songName)
    {
        int result = -1;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT score FROM scores WHERE songName='"+songName+"';", null);
        int size = c.getCount();
        if (size!=0)
        {
            c.moveToFirst();
            result = c.getInt(0);
        }
        c.close();
        return result;
    }
}
