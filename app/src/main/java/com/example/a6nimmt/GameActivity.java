package com.example.a6nimmt;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.a6nimmt.cardsUI.CardAdapter;
import com.example.a6nimmt.logic.Card;
import com.example.a6nimmt.logic.DataManager;
import com.example.a6nimmt.logic.Player;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

public class GameActivity extends Activity {

    public static ArrayList<Player> players = new ArrayList<>();
    private Game game;
    private DataManager dataManager;
    private static Context gameContext;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_board);

        Bundle extras = getIntent().getExtras();
        String[] names = extras.getStringArray("playerNames");

        for (String name :
                names) {
            players.add(new Player(name, 0));
        }

        gameContext = getApplicationContext();
        game = new Game(this);

        dataManager = new DataManager();
        try {
            dataManager.handleData();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        game.gameInit();


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
}
