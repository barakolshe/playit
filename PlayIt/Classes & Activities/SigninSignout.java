package application.playit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import application.playit.MainMenu;

public class SigninSignout extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private TextView message;
    private Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin_signout);
        db = new Database(getApplicationContext());

        //getApplicationContext().deleteDatabase("PlayIt");
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        message = (TextView) findViewById(R.id.message);
    }

    public void signup(View v)
    {
        db.addUser(username.getText().toString(), password.getText().toString());
        message.setText("User successfuly created");
    }

    public void signin(View v)
    {
        if (db.checkUser(username.getText().toString(), password.getText().toString()))
        {
            Intent mainMenu = new Intent(getApplicationContext(), MainMenu.class);
            startActivity(mainMenu);
            finish();
        }
        else
        {
            message.setText("Doesn't exist");
        }
    }
}
