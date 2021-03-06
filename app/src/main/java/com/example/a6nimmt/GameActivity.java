package com.example.a6nimmt;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;

import com.bumptech.glide.Glide;
import com.example.a6nimmt.logic.DataManager;
import com.example.a6nimmt.logic.Player;
import com.example.a6nimmt.scoreboard.ScoreBoardFragment;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class GameActivity extends AppCompatActivity {

    public static ArrayList<Player> players = new ArrayList<>();
    private Game game;
    private DataManager dataManager;
    private static Context gameContext;

    private MediaPlayer buttonClickSound;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_board);

        buttonClickSound = MediaPlayer.create(this, R.raw.button_click_1);

        Bundle extras = getIntent().getExtras();
        String[] names = extras.getStringArray("playerNames");


        int background = extras.getInt("background");
        setBackground(background);

        players.clear();
        for (String name :
                names) {
            players.add(new Player(name, 0));
        }
//        players.add(new Player("bahar", 0));
//        players.add(new Player("shubu", 0));
//        players.add(new Player("shughu", 0));

        gameContext = getApplicationContext();

        dataManager = new DataManager();
        try {
            dataManager.handleData();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Button userBtn = findViewById(R.id.userButton);
        game = new Game(this, userBtn);

        userBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClickSound.start();
                if (game.isGameIsOver()) {
                    Toast.makeText(getApplicationContext(), "Game Over!", Toast.LENGTH_LONG).show();
                    showScoreboard();

                } else {
                    if (game.isCanSelectCard() && game.getCounter() != 0) {
                        Toast.makeText(getApplicationContext(), "Choose a card, please!", Toast.LENGTH_LONG).show();
                    } else {
                        game.showNextUser();
                    }
                }


            }
        });

        game.gameInit();
    }

    public void onMenuButtonClick(View view) {
        buttonClickSound.start();
        finish();
        super.onBackPressed();
    }

    public void showScoreboard() {
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> scores = new ArrayList<>();

        Collections.sort(players, new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                return o1.getScore().compareTo(o2.getScore());
            }
        });

        for (Player player : players) {
            names.add(player.getName());
            scores.add(player.getScore().toString());
        }


        FragmentManager fm = getSupportFragmentManager();

        ScoreBoardFragment scoreboard = ScoreBoardFragment.newInstance("Scoreboard");

        Bundle args = new Bundle();
        args.putStringArrayList("names", names);
        args.putStringArrayList("scores", scores);
        scoreboard.setArguments(args);


        scoreboard.show(fm, "scoreboard");

    }

    public Game getGame() {
        return game;
    }

    public DataManager getDataManager() {
        return dataManager;
    }

    public static Context getGameContext() {
        return gameContext;
    }

    private void setBackground(int id){
        ImageView gameBackground = findViewById(R.id.game_background);
        switch (id){
            case  R.drawable.red_color:
                Glide.with(this).load(R.drawable.red_color).centerCrop().into(gameBackground);
                break;
            case R.drawable.dark_blue:
                Glide.with(this).load(R.drawable.dark_blue).centerCrop().into(gameBackground);
                break;
            case R.drawable.bright_colors:
                Glide.with(this).load(R.drawable.bright_colors).centerCrop().into(gameBackground);
                break;
            case R.drawable.white_wood:
                Glide.with(this).load(R.drawable.white_wood).centerCrop().into(gameBackground);
                View view = findViewById(R.id.separator);
                view.setVisibility(View.GONE);
                break;
        }
    }
}
