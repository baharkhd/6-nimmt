package com.example.a6nimmt;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a6nimmt.cardsUI.CardAdapter;
import com.example.a6nimmt.cardsUI.CardAdapter2;
import com.example.a6nimmt.logic.Card;
import com.example.a6nimmt.logic.DataManager;
import com.example.a6nimmt.logic.GameLogic;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

public class Game {
//
//    private ArrayList<String> row1;
//    private ArrayList<String> row2;
//    private ArrayList<String> row3;
//    private ArrayList<String> row4;
    private DataManager dataManager;
//    private static Context gameContext;
    private GameLogic gameLogic;
    private Activity activity;

    private RecyclerView row1RecyclerView;
    private RecyclerView row2RecyclerView;
    private RecyclerView row3RecyclerView;
    private RecyclerView row4RecyclerView;
    private RecyclerView row5RecyclerView;

    private CardAdapter2 row1Adapter;
    private CardAdapter2 row2Adapter;
    private CardAdapter2 row3Adapter;
    private CardAdapter2 row4Adapter;
    private CardAdapter2 row5Adapter;

    private ArrayList<ArrayList<Card>> mainCards = new ArrayList<ArrayList<Card>>(4);
    private ArrayList<Card> row1 = new ArrayList<>();
    private ArrayList<Card> row2 = new ArrayList<>();
    private ArrayList<Card> row3 = new ArrayList<>();
    private ArrayList<Card> row4 = new ArrayList<>();
    private ArrayList<Card> playerCards = new ArrayList<>();
    private static ArrayList<Card> allCards = new ArrayList<>();

    public Game(Activity activity) {
        this.activity = activity;
    }


    public void gameInit() {
        Card card28 = new Card(1, 28);
        Card card29 = new Card(1, 29);
        Card card31 = new Card(1, 31);
        Card card32 = new Card(1, 32);
        Card card34 = new Card(1, 34);
        Card card36 = new Card(1, 36);
        Card card37 = new Card(1, 37);
        Card card38 = new Card(1, 38);
        Card card39 = new Card(1, 39);
        Card card41 = new Card(1, 41);

        mainCards.add(row1);
        mainCards.add(row2);
        mainCards.add(row3);
        mainCards.add(row4);

        row1.add(card28);
//        row1.add(card29);
//        row1.add(card31);
//        row1.add(card32);

        row2.add(card41);
//        row2.add(card29);
//        row2.add(card31);
//        row2.add(card32);

        row3.add(card36);
//        row3.add(card29);
//        row3.add(card31);
//        row3.add(card32);

        row4.add(card37);
//        row4.add(card29);
//        row4.add(card31);
//        row4.add(card32);

        playerCards.clear();
        playerCards.add(card28);
        playerCards.add(card29);
        playerCards.add(card31);
        playerCards.add(card32);
        playerCards.add(card34);
        playerCards.add(card36);
        playerCards.add(card37);
        playerCards.add(card38);
        playerCards.add(card39);
        playerCards.add(card41);

        initRecyclerViews();

//        ArrayList<Card> selectedCards = new ArrayList<>();
//        selectedCards.add(allCards.get())


    }



//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.game_board);
//        gameContext = getApplicationContext();
//
//        gameLogic = new GameLogic();
//
//    }

    public void initRecyclerViews() {
        row1RecyclerView = activity.findViewById(R.id.recyclerView1);
        row1Adapter = new CardAdapter2(row1, row1RecyclerView);
        row1Adapter.setHasStableIds(true);
        row1RecyclerView.setAdapter(row1Adapter);
        row1RecyclerView.setHasFixedSize(true);


        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(activity) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        row1RecyclerView.setLayoutManager(layoutManager1);


        row2RecyclerView = activity.findViewById(R.id.recyclerView2);
        row2Adapter = new CardAdapter2(row2, row2RecyclerView);
        row2Adapter.setHasStableIds(true);
        row2RecyclerView.setAdapter(row2Adapter);
        row2RecyclerView.setHasFixedSize(true);


        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(activity) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        row2RecyclerView.setLayoutManager(layoutManager2);


        row3RecyclerView = activity.findViewById(R.id.recyclerView3);
        row3Adapter = new CardAdapter2(row3, row3RecyclerView);
        row3Adapter.setHasStableIds(true);
        row3RecyclerView.setAdapter(row3Adapter);
        row3RecyclerView.setHasFixedSize(true);


        RecyclerView.LayoutManager layoutManager3 = new LinearLayoutManager(activity) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        row3RecyclerView.setLayoutManager(layoutManager3);



        row4RecyclerView = activity.findViewById(R.id.recyclerView4);
        row4Adapter = new CardAdapter2(row4, row4RecyclerView);
        row4Adapter.setHasStableIds(true);
        row4RecyclerView.setAdapter(row4Adapter);
        row4RecyclerView.setHasFixedSize(true);


        RecyclerView.LayoutManager layoutManager4 = new LinearLayoutManager(activity) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        row4RecyclerView.setLayoutManager(layoutManager4);


        row5RecyclerView = activity.findViewById(R.id.recyclerView5);
        row5Adapter = new CardAdapter2(playerCards, row5RecyclerView);
        row5Adapter.setHasStableIds(true);
        row5RecyclerView.setAdapter(row5Adapter);
        row5RecyclerView.setHasFixedSize(true);


        RecyclerView.LayoutManager layoutManager5 = new LinearLayoutManager(activity);
        row5RecyclerView.setLayoutManager(layoutManager5);
    }

    public static ArrayList<Card> getAllCards() {
        return allCards;
    }
}
