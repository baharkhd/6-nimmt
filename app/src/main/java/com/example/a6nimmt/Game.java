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

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

public class Game extends Activity {
//
//    private ArrayList<String> row1;
//    private ArrayList<String> row2;
//    private ArrayList<String> row3;
//    private ArrayList<String> row4;
    private DataManager dataManager;
    private static Context gameContext;

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
    private ArrayList<Card> allCards = MainActivity.allCards;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_board);
        gameContext = getApplicationContext();

        dataManager = new DataManager();
        try {
            dataManager.handleData();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        Card card1 = new Card(1, 1);
        Card card2 = new Card(1, 2);
        Card card3 = new Card(1, 3);
        Card card4 = new Card(1, 4);
        Card card5 = new Card(1, 5);
        Card card6 = new Card(1, 6);
        Card card7 = new Card(1, 7);
        Card card8 = new Card(1, 8);
        Card card9 = new Card(1, 9);
        Card card10 = new Card(1, 10);

        mainCards.add(row1);
        mainCards.add(row2);
        mainCards.add(row3);
        mainCards.add(row4);

        row1.add(card1);
        row1.add(card2);
        row1.add(card3);
        row1.add(card4);

        row2.add(card1);
        row2.add(card2);
        row2.add(card3);
        row2.add(card4);

        row3.add(card1);
        row3.add(card2);
        row3.add(card3);
        row3.add(card4);

        row4.add(card1);
        row4.add(card2);
        row4.add(card3);
        row4.add(card4);

        playerCards.add(card1);
        playerCards.add(card2);
        playerCards.add(card3);
        playerCards.add(card4);
        playerCards.add(card5);
        playerCards.add(card6);
        playerCards.add(card7);
        playerCards.add(card8);
        playerCards.add(card9);
        playerCards.add(card10);

        initRecyclerViews();






    }

    public void initRecyclerViews() {
        row1RecyclerView = findViewById(R.id.recyclerView1);
        row1Adapter = new CardAdapter2(row1, row1RecyclerView);
        row1Adapter.setHasStableIds(true);
        row1RecyclerView.setAdapter(row1Adapter);
        row1RecyclerView.setHasFixedSize(true);


        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(this);
        row1RecyclerView.setLayoutManager(layoutManager1);


        row2RecyclerView = findViewById(R.id.recyclerView2);
        row2Adapter = new CardAdapter2(row2, row2RecyclerView);
        row2Adapter.setHasStableIds(true);
        row2RecyclerView.setAdapter(row2Adapter);
        row2RecyclerView.setHasFixedSize(true);


        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(this);
        row2RecyclerView.setLayoutManager(layoutManager2);


        row3RecyclerView = findViewById(R.id.recyclerView3);
        row3Adapter = new CardAdapter2(row3, row3RecyclerView);
        row3Adapter.setHasStableIds(true);
        row3RecyclerView.setAdapter(row3Adapter);
        row3RecyclerView.setHasFixedSize(true);


        RecyclerView.LayoutManager layoutManager3 = new LinearLayoutManager(this);
        row3RecyclerView.setLayoutManager(layoutManager3);



        row4RecyclerView = findViewById(R.id.recyclerView4);
        row4Adapter = new CardAdapter2(row4, row4RecyclerView);
        row4Adapter.setHasStableIds(true);
        row4RecyclerView.setAdapter(row4Adapter);
        row4RecyclerView.setHasFixedSize(true);


        RecyclerView.LayoutManager layoutManager4 = new LinearLayoutManager(this);
        row4RecyclerView.setLayoutManager(layoutManager4);


        row5RecyclerView = findViewById(R.id.recyclerView5);
        row5Adapter = new CardAdapter2(playerCards, row5RecyclerView);
        row5Adapter.setHasStableIds(true);
        row5RecyclerView.setAdapter(row5Adapter);
        row5RecyclerView.setHasFixedSize(true);


        RecyclerView.LayoutManager layoutManager5 = new LinearLayoutManager(this);
        row5RecyclerView.setLayoutManager(layoutManager5);
    }

    public static Context getGameContext() {
        return gameContext;
    }
}
