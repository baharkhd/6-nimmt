package com.example.a6nimmt;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.a6nimmt.cardsUI.CardAdapter2;
import com.example.a6nimmt.logic.DataManager;
import com.example.a6nimmt.logic.GameLogic;
import com.example.a6nimmt.logic.Player;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

public class GameActivity extends Activity {

    private Game game;
    private DataManager dataManager;
//    private GameLogic gameLogic;
    private static Context gameContext;
    Player current;
    int counter = 0 ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_board);
        Button userBtn = findViewById(R.id.userButton);
        final TextView score = findViewById(R.id.score);
        final TextView username = findViewById(R.id.username);
        final ArrayList<Player> players = MainActivity.players;
        current = players.get(0);


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
        username.setText(current.getName());
        score.setText(String.valueOf(current.getScore()));
        CardAdapter2 adapter2 = new CardAdapter2(current.getCards() , game.getRow5RecyclerView());
        game.getRow5RecyclerView().setAdapter(adapter2);
        counter++;

        userBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (counter == players.size()-1){
                    current = players.get(counter);
                    counter = 0;
                }
                else {
                    current = players.get(counter);
                    counter++;
                }
                username.setText(current.getName());
                score.setText(String.valueOf(current.getScore()));
                CardAdapter2 adapter2 = new CardAdapter2(current.getCards() , game.getRow5RecyclerView());
                game.getRow5RecyclerView().setAdapter(adapter2);

            }
        });




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
