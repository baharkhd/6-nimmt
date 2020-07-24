package com.example.a6nimmt;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.a6nimmt.logic.DataManager;
import com.example.a6nimmt.logic.GameLogic;

import org.json.JSONException;

import java.io.IOException;

public class GameActivity extends Activity {

    private Game game;
    private DataManager dataManager;
//    private GameLogic gameLogic;
    private static Context gameContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_board);

        gameContext = getApplicationContext();
//        gameLogic = new GameLogic();
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

//    public GameLogic getGameLogic() {
//        return gameLogic;
//    }

    public static Context getGameContext() {
        return gameContext;
    }
}
