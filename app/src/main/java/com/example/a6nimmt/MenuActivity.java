package com.example.a6nimmt;

import androidx.appcompat.app.AppCompatActivity;
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

    public static Context appContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        appContext = this.getApplicationContext();

        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> scores = new ArrayList<>();

        names.add("player1");
        names.add("player2");
        names.add("player3");
        names.add("player4");
        names.add("player5");
        names.add("player6");
        names.add("player7");
        names.add("player8");
        names.add("player9");
        names.add("player10");


        scores.add("1");
        scores.add("2");
        scores.add("3");
        scores.add("4");
        scores.add("5");
        scores.add("6");
        scores.add("7");
        scores.add("8");
        scores.add("9");
        scores.add("10");


        FragmentManager fm = getSupportFragmentManager();

        ScoreBoardFragment scoreboard = ScoreBoardFragment.newInstance("Scoreboard");

        Bundle args = new Bundle();
        args.putStringArrayList("names", names);
        args.putStringArrayList("scores", scores);
        scoreboard.setArguments(args);


        scoreboard.show(fm, "scoreboard");





//        if (savedInstanceState == null) {
//            startPage = new StartPage();
//            startPage.setArguments(this.getIntent().getExtras());
//            getSupportFragmentManager().beginTransaction().replace(R.id.page_content, startPage)
//                    .addToBackStack(TAG1).commit();
//        }
    }

    public void startButton(View view) {
        if (findViewById(R.id.no_of_players) != null) {
            noofPlayers = new NoofPlayers();
            noofPlayers.setArguments(this.getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().replace(R.id.no_of_players, noofPlayers)
                    .addToBackStack(TAG2).commit();
        }
    }

    public void exitButton(View view) {
        startPage.exitButton(view);
    }

    public void numberOfPlayers(View view) {
        if (noofPlayers != null) {
            EditText editText = findViewById(R.id.numberInput);
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
                getSupportFragmentManager().beginTransaction().replace(R.id.page_content, nameofPlayers)
                        .addToBackStack(TAG3).commit();
            } else {
                Toast.makeText(this, R.string.number_error,
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onNamesEntered(String[] names) {
        Toast.makeText(this, "names entered", Toast.LENGTH_SHORT).show();

        Intent myIntent = new Intent(this, GameActivity.class);
        myIntent.putExtra("playerNames", names);
        startActivity(myIntent);
    }
}
