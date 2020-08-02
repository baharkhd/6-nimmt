package com.example.a6nimmt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a6nimmt.logic.Player;
import com.example.a6nimmt.menu.NameofPlayers;
import com.example.a6nimmt.menu.NoofPlayers;
import com.example.a6nimmt.menu.StartPage;
import com.example.a6nimmt.scoreboard.ScoreBoardFragment;

import java.util.ArrayList;


public class MenuActivity extends AppCompatActivity implements NameofPlayers.OnNamesListener {

    StartPage startPage;
    String TAG1 = "startPage";
    NoofPlayers noofPlayers;
    String TAG2 = "noofPlayers";
    NameofPlayers nameofPlayers;
    String TAG3 = "nameofPlayers";
    public static int no_of_players;
    private static EditText numOfPlayersEditText;
    private NoofPlayers numOfPlayersFrag;

    public static Context appContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        appContext = this.getApplicationContext();


        if (savedInstanceState == null) {
            startPage = new StartPage();
            startPage.setArguments(this.getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().replace(R.id.page_content, startPage)
                    .addToBackStack(TAG1).commit();
        }
    }

    public void startButton(View view) {
        FragmentManager fm = getSupportFragmentManager();

        numOfPlayersFrag = NoofPlayers.newInstance("num of players");

        Bundle args = new Bundle();
        numOfPlayersFrag.setArguments(args);


        numOfPlayersFrag.show(fm, "num of players");
    }

    public void exitButton(View view) {
        startPage.exitButton(view);
    }

    public void numberOfPlayers(View view) {
        EditText editText = numOfPlayersEditText;
        String s = editText.getText().toString();
        boolean b = true;
        if (s.isEmpty()) {
            b = false;
        } else if (Integer.valueOf(s) > 10 || Integer.valueOf(s) < 2) {
            b = false;
        }
        if (b) {
            no_of_players = Integer.valueOf(s);
            nameofPlayers = NameofPlayers.newInstance(no_of_players);
            nameofPlayers.setArguments(this.getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().remove(numOfPlayersFrag).commit();
            getSupportFragmentManager().beginTransaction().replace(R.id.page_content, nameofPlayers)
                    .addToBackStack(TAG3).commit();
        } else {
            Toast.makeText(this, R.string.number_error,
                    Toast.LENGTH_SHORT).show();
        }
//        }
    }

    @Override
    public void onNamesEntered(String[] names) {
        Toast.makeText(this, "names entered", Toast.LENGTH_SHORT).show();

        Intent myIntent = new Intent(this, GameActivity.class);
        myIntent.putExtra("playerNames", names);
        startActivity(myIntent);
    }

    public static void setNumOfPlayersEditText(EditText numOfPlayersEditText) {
        MenuActivity.numOfPlayersEditText = numOfPlayersEditText;
    }
}
