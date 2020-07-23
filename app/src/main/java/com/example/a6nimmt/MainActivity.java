package com.example.a6nimmt;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a6nimmt.cardsUI.CardAdapter;
import com.example.a6nimmt.logic.Card;
import com.example.a6nimmt.logic.DataManager;
import com.example.a6nimmt.logic.Player;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Player> players = new ArrayList<>();
    public static ArrayList<Card> cards = new ArrayList<>();
    private static Context appContext;
    private DataManager dataManager;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_board);

        appContext = getApplicationContext();
        dataManager = new DataManager();
        try {
            dataManager.handleData();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        ArrayList<String> cards = new ArrayList<>();
        cards.add("card1");
        cards.add("card2");
        cards.add("card3");
        cards.add("card4");
        cards.add("card5");

        ArrayList<String> userCards = new ArrayList<>(cards);
        userCards.add("card6");
        userCards.add("card7");
        userCards.add("card8");
        userCards.add("card9");
        userCards.add("card10");


        RecyclerView recyclerView1 = findViewById(R.id.recyclerView1);
        CardAdapter cardAdapter1 = new CardAdapter(cards);
        cardAdapter1.setHasStableIds(true);
        recyclerView1.setAdapter(cardAdapter1);
        recyclerView1.setHasFixedSize(true);



        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(this);
        recyclerView1.setLayoutManager(layoutManager1);

        RecyclerView recyclerView2 = findViewById(R.id.recyclerView2);
        CardAdapter cardAdapter2 = new CardAdapter(cards);
        recyclerView2.setAdapter(cardAdapter2);
        recyclerView2.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(this);
        recyclerView2.setLayoutManager(layoutManager2);

        RecyclerView recyclerView3 = findViewById(R.id.recyclerView3);
        CardAdapter cardAdapter3 = new CardAdapter(cards);
        recyclerView3.setAdapter(cardAdapter3);
        recyclerView3.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager3 = new LinearLayoutManager(this);
        recyclerView3.setLayoutManager(layoutManager3);

        RecyclerView recyclerView4 = findViewById(R.id.recyclerView4);
        CardAdapter cardAdapter4 = new CardAdapter(cards);
        recyclerView4.setAdapter(cardAdapter4);
        recyclerView4.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager4 = new LinearLayoutManager(this);
        recyclerView4.setLayoutManager(layoutManager4);

        RecyclerView recyclerView5 = findViewById(R.id.recyclerView5);
        CardAdapter cardAdapter5 = new CardAdapter(userCards);
        recyclerView5.setAdapter(cardAdapter5);
        recyclerView5.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager5 = new LinearLayoutManager(this);
        recyclerView5.setLayoutManager(layoutManager5);



//        Player player1 = new Player("bahar", 0);
//        Player player2 = new Player("shughu", 0);
//        Player player3 = new Player("shubu", 0);
//
//
//        players.add(player1);
//        players.add(player2);
//        players.add(player3);
//
//        Card card1 = new Card(1, 1);
//        Card card2 = new Card(1, 2);
//        Card card3 = new Card(1, 3);
//        Card card4 = new Card(1, 4);
//        Card card5 = new Card(1, 5);
//        Card card6 = new Card(1, 6);
//        Card card7 = new Card(1, 7);
//        Card card8 = new Card(1, 8);
//        Card card9 = new Card(1, 9);
//        Card card10 = new Card(1, 10);
//        Card card11 = new Card(1, 11);
//        Card card12 = new Card(1, 12);
//        Card card13 = new Card(1, 13);
//        Card card14 = new Card(1, 14);
//        Card card15 = new Card(1, 15);
//        Card card16 = new Card(1, 16);
//        Card card17 = new Card(1, 17);
//        Card card18 = new Card(1, 18);
//        Card card19 = new Card(1, 19);
//        Card card20 = new Card(1, 20);
//
//        cards.add(card1);
//        cards.add(card2);
//        cards.add(card3);
//        cards.add(card4);
//        cards.add(card5);
//        cards.add(card6);
//        cards.add(card7);
//        cards.add(card8);
//        cards.add(card9);
//        cards.add(card10);
//        cards.add(card11);
//        cards.add(card12);
//        cards.add(card13);
//        cards.add(card14);
//        cards.add(card15);
//        cards.add(card16);
//        cards.add(card17);
//        cards.add(card18);
//        cards.add(card19);
//        cards.add(card20);
//
//        ArrayList<Card> myCards = new ArrayList<>();
//        Card c1 = new Card(1, 34);
//        Card c2 = new Card(2, 23);
//        Card c3 = new Card(3, 56);
//        Card c4 = new Card(4, 21);
//        myCards.add(c1);
//        myCards.add(c2);
//        myCards.add(c3);
//        myCards.add(c4);
//
//        GameLogic gameLogic = new GameLogic();
//        gameLogic.initGame();
//        gameLogic.checkGame();
//        gameLogic.checkGame();
//        gameLogic.checkGame();
//        gameLogic.checkGame();

    }

    public static Context getAppContext() {
        return appContext;
    }
}
