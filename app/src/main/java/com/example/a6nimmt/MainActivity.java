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
import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Player> players = new ArrayList<>();


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);



        Button button = findViewById(R.id.button);
        Player player1 = new Player("Amir" , 10);
        Player player2 = new Player("aida" , 20);
        Player player3 = new Player("Amirre`" , 30);
        players.add(player1);
        players.add(player2);
        players.add(player3);
        Card card28 = new Card(1, 28);
        Card card29 = new Card(1, 29);
        Card card31 = new Card(1, 31);
        Card card32 = new Card(1, 32);
        Card card34 = new Card(1, 34);
        Card card36 = new Card(1, 36);
//        Card card37 = new Card(1, 7);
//        Card card38 = new Card(1, 8);
//        Card card39 = new Card(1, 9);
//        Card card41 = new Card(1, 10);
        player1.getCards().add(card28);
        player1.getCards().add(card29);
        player2.getCards().add(card31);
        player2.getCards().add(card32);
        player2.getCards().add(card34);
        player3.getCards().add(card36);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Handler handler = new Handler();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Intent myIntent = new Intent(MainActivity.this, GameActivity.class);
                        startActivity(myIntent);
                    }
                });
            }
        });

//        appContext = getApplicationContext();



//        Card card28 = new Card(1, 1);
//        Card card29 = new Card(1, 2);
//        Card card31 = new Card(1, 3);
//        Card card32 = new Card(1, 4);
//        Card card34 = new Card(1, 5);
//        Card card36 = new Card(1, 6);
//        Card card37 = new Card(1, 7);
//        Card card38 = new Card(1, 8);
//        Card card39 = new Card(1, 9);
//        Card card41 = new Card(1, 10);
//
//        myCards.add(card28);
//        myCards.add(card29);
//        myCards.add(card31);
//        myCards.add(card32);
//        myCards.add(card34);
//
//        ArrayList<Card> myUserCards = new ArrayList<>(myCards);
//        myUserCards.add(card36);
//        myUserCards.add(card37);
//        myUserCards.add(card38);
//        myUserCards.add(card39);
//        myUserCards.add(card41);
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
//        cards.add("card28");
//        cards.add("card29");
//        cards.add("card31");
//        cards.add("card32");
//        cards.add("card34");
//
//        final ArrayList<String> userCards = new ArrayList<>(cards);
//        userCards.add("card36");
//        userCards.add("card37");
//        userCards.add("card38");
//        userCards.add("card39");
//        userCards.add("card41");
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
//        Card card28 = new Card(1, 1);
//        Card card29 = new Card(1, 2);
//        Card card31 = new Card(1, 3);
//        Card card32 = new Card(1, 4);
//        Card card34 = new Card(1, 5);
//        Card card36 = new Card(1, 6);
//        Card card37 = new Card(1, 7);
//        Card card38 = new Card(1, 8);
//        Card card39 = new Card(1, 9);
//        Card card41 = new Card(1, 10);
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
//        allCards.add(card28);
//        allCards.add(card29);
//        allCards.add(card31);
//        allCards.add(card32);
//        allCards.add(card34);
//        allCards.add(card36);
//        allCards.add(card37);
//        allCards.add(card38);
//        allCards.add(card39);
//        allCards.add(card41);
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
