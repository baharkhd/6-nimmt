package com.example.a6nimmt.logic;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.a6nimmt.MainActivity;

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

public class GameLogic {

    private ArrayList<Player> players = MainActivity.players;
    private ArrayList<ArrayList<Card>> mainCards = new ArrayList<ArrayList<Card>>(4);
    private ArrayList<Card> row1 = new ArrayList<>();
    private ArrayList<Card> row2 = new ArrayList<>();
    private ArrayList<Card> row3 = new ArrayList<>();
    private ArrayList<Card> row4 = new ArrayList<>();
    private ArrayList<Card> allCards = MainActivity.allCards;
    private ArrayList<SelectedCard> selectedCards = new ArrayList<>();
    private final int ROW_LIMIT = 5;
    Random random = new Random();

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void initGame() {

        int[] randomIndexes = random.ints(0, 20).distinct().limit(16).toArray();

        row1.add(allCards.get(randomIndexes[0]));
        row2.add(allCards.get(randomIndexes[1]));
        row3.add(allCards.get(randomIndexes[2]));
        row4.add(allCards.get(randomIndexes[3]));
        mainCards.add(row1);
        mainCards.add(row2);
        mainCards.add(row3);
        mainCards.add(row4);


        players.get(0).getCards().add(allCards.get(randomIndexes[4]));
        players.get(0).getCards().add(allCards.get(randomIndexes[5]));
        players.get(0).getCards().add(allCards.get(randomIndexes[6]));
        players.get(0).getCards().add(allCards.get(randomIndexes[7]));
        players.get(1).getCards().add(allCards.get(randomIndexes[8]));
        players.get(1).getCards().add(allCards.get(randomIndexes[9]));
        players.get(1).getCards().add(allCards.get(randomIndexes[10]));
        players.get(1).getCards().add(allCards.get(randomIndexes[11]));
        players.get(2).getCards().add(allCards.get(randomIndexes[12]));
        players.get(2).getCards().add(allCards.get(randomIndexes[13]));
        players.get(2).getCards().add(allCards.get(randomIndexes[14]));
        players.get(2).getCards().add(allCards.get(randomIndexes[15]));

        System.out.println("first of the game :");
        System.out.println("+++ main allCards :");
        for (int i = 0; i < 4; i++) {
            System.out.println("row " + i + " :");
            for (Card c :
                    mainCards.get(i)) {
                System.out.println(c.getNumber());
            }
            System.out.println("***");
        }

        System.out.println("+++ players allCards :");
        for (int i = 0; i < players.size(); i++) {
            System.out.println("player " + i + " :");
            for (Card c :
                    players.get(i).getCards()) {
                System.out.println(c.getNumber());
            }
            System.out.println("***");
        }


    }

    public void checkGame() {

        selectedCards.clear();
        SelectedCard selectedCard1 = new SelectedCard(0, players.get(0).getCards().get(0));
        SelectedCard selectedCard2 = new SelectedCard(1, players.get(1).getCards().get(0));
        SelectedCard selectedCard3 = new SelectedCard(2, players.get(2).getCards().get(0));
        players.get(0).getCards().remove(0);
        players.get(1).getCards().remove(0);
        players.get(2).getCards().remove(0);


        selectedCards.add(selectedCard1);
        selectedCards.add(selectedCard2);
        selectedCards.add(selectedCard3);

        System.out.println("+++ selected allCards :");
        for (SelectedCard c :
                selectedCards) {
            System.out.println(c.getCard().getNumber());
        }


        Collections.sort(selectedCards, new Comparator<SelectedCard>() {
            @Override
            public int compare(SelectedCard o1, SelectedCard o2) {
                Integer number1 = o1.getCard().getNumber();
                Integer number2 = o2.getCard().getNumber();
                return number1.compareTo(number2);
            }
        });




        placeCards(selectedCards);

        System.out.println("----------------------");
        for (int i = 0; i < 4; i++) {
            System.out.println("row " + i + " :");
            for (Card c :
                    mainCards.get(i)) {
                System.out.println(c.getNumber());
            }
            System.out.println("***");
        }

    }

    public void placeCards(ArrayList<SelectedCard> cards) {
        for (SelectedCard card: cards) {
            placeCard(card);
        }
    }

    public void placeCard(SelectedCard card) {

        int cardNumber = card.getCard().getNumber();
        HashMap<Integer, Integer> distances = new HashMap<>();


        for (int i = 0; i < 4; i++) {
            int lastCardNumber = mainCards.get(i).get(mainCards.get(i).size() - 1).getNumber();
            if (cardNumber > lastCardNumber) {
                distances.put(i, cardNumber - lastCardNumber);
            }
        }

        distances = sortCards(distances);

        if (distances.size() != 0) {
            Iterator<Integer> iterator = distances.keySet().iterator();

            Integer firstKey = null;
            if(iterator.hasNext()){
                firstKey = iterator.next();
            }


            int rowLength = mainCards.get(firstKey).size();
            if (rowLength < ROW_LIMIT) {
                mainCards.get(firstKey).add(card.getCard());
            } else {
                rowIsFull(card, firstKey);
            }

        } else {
            removeRowAndReplaceCard(card);
        }

    }

    public void rowIsFull(SelectedCard card, int rowNumber) {
        int scores = 0;

        for (Card c :
                mainCards.get(rowNumber)) {
                scores += c.getScore();
        }

        players.get(card.getPlayerNumber()).setScore(players.get(
                card.getPlayerNumber()).getScore() + scores);
        mainCards.get(rowNumber).clear();
        mainCards.get(rowNumber).add(card.getCard());
    }



    public void removeRowAndReplaceCard(SelectedCard myCard) {
        int minScore = Integer.MAX_VALUE;
        int rowToBeRemoved = -1;

        for (int i = 0; i < 4; i++) {
            int sum = 0;

            for (Card card : mainCards.get(i)) {
                sum += card.getScore();
            }

            if (sum < minScore) {
                rowToBeRemoved = i;
                minScore = sum;
            }
        }

        mainCards.get(rowToBeRemoved).clear();
        players.get(myCard.getPlayerNumber()).setScore(players.get(myCard.getPlayerNumber()).getScore()
                + minScore);
        mainCards.get(rowToBeRemoved).add(myCard.getCard());



    }

    public HashMap<Integer, Integer> sortCards(HashMap<Integer, Integer> cards) {
        List<Map.Entry<Integer, Integer> > list =
                new LinkedList<>(cards.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() {
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        HashMap<Integer, Integer> temp = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
