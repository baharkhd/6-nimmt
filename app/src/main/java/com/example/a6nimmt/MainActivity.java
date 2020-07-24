package com.example.a6nimmt;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a6nimmt.cardsUI.CardAdapter;
import com.example.a6nimmt.cardsUI.CardAdapter2;
import com.example.a6nimmt.logic.Card;
import com.example.a6nimmt.logic.DataManager;
import com.example.a6nimmt.logic.Player;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Player> players = new ArrayList<>();
    public static ArrayList<Card> allCards = new ArrayList<>();
//    private static Context appContext;


    public RecyclerView recyclerView1;
    public RecyclerView recyclerView5;
    public CardAdapter2 cardAdapter1;
    public ArrayList<String> cards = new ArrayList<>(5);
    public ArrayList<Card> myCards = new ArrayList<>(5);
    public static ArrayList<String> addedCards = new ArrayList<>();


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);



        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Handler handler = new Handler();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Intent myIntent = new Intent(MainActivity.this, Game.class);
                        startActivity(myIntent);
                    }
                });
            }
        });

//        appContext = getApplicationContext();

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
//
//        myCards.add(card1);
//        myCards.add(card2);
//        myCards.add(card3);
//        myCards.add(card4);
//        myCards.add(card5);
//
//        ArrayList<Card> myUserCards = new ArrayList<>(myCards);
//        myUserCards.add(card6);
//        myUserCards.add(card7);
//        myUserCards.add(card8);
//        myUserCards.add(card9);
//        myUserCards.add(card10);
//
//
//        recyclerView1 = findViewById(R.id.recyclerView1);
//        cardAdapter1 = new CardAdapter2(myCards, recyclerView1);
//        cardAdapter1.setHasStableIds(true);
//        recyclerView1.setAdapter(cardAdapter1);
//        recyclerView1.setHasFixedSize(true);
//
//
//        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(this);
//        recyclerView1.setLayoutManager(layoutManager1);




//        final ArrayList<String> cards = new ArrayList<>(5);
//        cards.add("card1");
//        cards.add("card2");
//        cards.add("card3");
//        cards.add("card4");
//        cards.add("card5");
//
//        final ArrayList<String> userCards = new ArrayList<>(cards);
//        userCards.add("card6");
//        userCards.add("card7");
//        userCards.add("card8");
//        userCards.add("card9");
//        userCards.add("card10");
//
//
//        recyclerView1 = findViewById(R.id.recyclerView1);
//        cardAdapter1 = new CardAdapter(cards, recyclerView1);
//        cardAdapter1.setHasStableIds(true);
//        recyclerView1.setAdapter(cardAdapter1);
//        recyclerView1.setHasFixedSize(true);
//
//
//        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(this);
//        recyclerView1.setLayoutManager(layoutManager1);
//
//        Button userButton = findViewById(R.id.userButton);
//        userButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                myCards.remove(0);
//                cardAdapter1.notifyItemRemoved(0);
//            }
//        });



//        RecyclerView recyclerView2 = findViewById(R.id.recyclerView2);
//        CardAdapter cardAdapter2 = new CardAdapter(cards);
//        recyclerView2.setAdapter(cardAdapter2);
//        recyclerView2.setHasFixedSize(true);
//
//        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(this);
//        recyclerView2.setLayoutManager(layoutManager2);
//
//        RecyclerView recyclerView3 = findViewById(R.id.recyclerView3);
//        CardAdapter cardAdapter3 = new CardAdapter(cards);
//        recyclerView3.setAdapter(cardAdapter3);
//        recyclerView3.setHasFixedSize(true);
//
//        RecyclerView.LayoutManager layoutManager3 = new LinearLayoutManager(this);
//        recyclerView3.setLayoutManager(layoutManager3);
//
//        RecyclerView recyclerView4 = findViewById(R.id.recyclerView4);
//        CardAdapter cardAdapter4 = new CardAdapter(cards);
//        recyclerView4.setAdapter(cardAdapter4);
//        recyclerView4.setHasFixedSize(true);
//
//        RecyclerView.LayoutManager layoutManager4 = new LinearLayoutManager(this);
//        recyclerView4.setLayoutManager(layoutManager4);



//
//        recyclerView5 = findViewById(R.id.recyclerView5);
//        CardAdapter2 cardAdapter5 = new CardAdapter2(myUserCards, recyclerView5);
//        recyclerView5.setAdapter(cardAdapter5);
//        recyclerView5.setHasFixedSize(true);
//
//        RecyclerView.LayoutManager layoutManager5 = new LinearLayoutManager(this);
//        recyclerView5.setLayoutManager(layoutManager5);



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
//        allCards.add(card1);
//        allCards.add(card2);
//        allCards.add(card3);
//        allCards.add(card4);
//        allCards.add(card5);
//        allCards.add(card6);
//        allCards.add(card7);
//        allCards.add(card8);
//        allCards.add(card9);
//        allCards.add(card10);
//        allCards.add(card11);
//        allCards.add(card12);
//        allCards.add(card13);
//        allCards.add(card14);
//        allCards.add(card15);
//        allCards.add(card16);
//        allCards.add(card17);
//        allCards.add(card18);
//        allCards.add(card19);
//        allCards.add(card20);
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


//    public static Context getAppContext() {
//        return appContext;
//    }
}
