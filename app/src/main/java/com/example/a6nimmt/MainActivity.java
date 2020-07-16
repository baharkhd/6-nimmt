package com.example.a6nimmt;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;

import com.example.a6nimmt.logic.Card;
import com.example.a6nimmt.logic.GameLogic;
import com.example.a6nimmt.logic.Player;
import com.example.a6nimmt.logic.SelectedCard;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Player> players = new ArrayList<>();
    public static ArrayList<Card> cards = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Player player1 = new Player("bahar", 0);
        Player player2 = new Player("shughu", 0);
        Player player3 = new Player("shubu", 0);


        players.add(player1);
        players.add(player2);
        players.add(player3);

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
        Card card11 = new Card(1, 11);
        Card card12 = new Card(1, 12);
        Card card13 = new Card(1, 13);
        Card card14 = new Card(1, 14);
        Card card15 = new Card(1, 15);
        Card card16 = new Card(1, 16);
        Card card17 = new Card(1, 17);
        Card card18 = new Card(1, 18);
        Card card19 = new Card(1, 19);
        Card card20 = new Card(1, 20);

        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        cards.add(card6);
        cards.add(card7);
        cards.add(card8);
        cards.add(card9);
        cards.add(card10);
        cards.add(card11);
        cards.add(card12);
        cards.add(card13);
        cards.add(card14);
        cards.add(card15);
        cards.add(card16);
        cards.add(card17);
        cards.add(card18);
        cards.add(card19);
        cards.add(card20);

        ArrayList<Card> myCards = new ArrayList<>();
        Card c1 = new Card(1, 34);
        Card c2 = new Card(2, 23);
        Card c3 = new Card(3, 56);
        Card c4 = new Card(4, 21);
        myCards.add(c1);
        myCards.add(c2);
        myCards.add(c3);
        myCards.add(c4);

        GameLogic gameLogic = new GameLogic();
        gameLogic.initGame();
        gameLogic.checkGame();
        gameLogic.checkGame();
        gameLogic.checkGame();
        gameLogic.checkGame();


        System.out.println("********* scores:");
        for (Player p :
                players) {
            System.out.println(p.getScore());
        }



    }

    public HashMap<Integer, Integer> sortCards(HashMap<Integer, Integer> cards) {
        List<Map.Entry<Integer, Integer> > list =
                new LinkedList<Map.Entry<Integer, Integer> >(cards.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() {
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
}
