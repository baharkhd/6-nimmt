package com.example.a6nimmt.logic;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.a6nimmt.MainActivity;

import java.util.ArrayList;
import java.util.Arrays;
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
    private ArrayList<Card> allCards = MainActivity.cards;
    private ArrayList<SelectedCard> selectedCards = new ArrayList<>();
    Random random = new Random();

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void initGame() {

        int[] randomIndexes = random.ints(0, 14).distinct().limit(13).toArray();

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
        players.get(1).getCards().add(allCards.get(randomIndexes[7]));
        players.get(1).getCards().add(allCards.get(randomIndexes[8]));
        players.get(1).getCards().add(allCards.get(randomIndexes[9]));
        players.get(2).getCards().add(allCards.get(randomIndexes[10]));
        players.get(2).getCards().add(allCards.get(randomIndexes[11]));
        players.get(2).getCards().add(allCards.get(randomIndexes[12]));


    }

    public void checkGame() {

//        SelectedCard selectedCard1 = (SelectedCard) players.get(0).getCards().get(0);
//        selectedCard1.setPlayerNumber(0);
//        SelectedCard selectedCard2 = (SelectedCard) players.get(1).getCards().get(0);
//        selectedCard2.setPlayerNumber(1);
//        SelectedCard selectedCard3 = (SelectedCard) players.get(2).getCards().get(0);
//        selectedCard3.setPlayerNumber(2);
//        SelectedCard selectedCard4 = (SelectedCard) players.get(3).getCards().get(0);
//        selectedCard4.setPlayerNumber(3);

        SelectedCard selectedCard1 = new SelectedCard(0, players.get(0).getCards().get(0));
        SelectedCard selectedCard2 = new SelectedCard(1, players.get(1).getCards().get(0));
        SelectedCard selectedCard3 = new SelectedCard(2, players.get(2).getCards().get(0));

        selectedCards.add(selectedCard1);
        selectedCards.add(selectedCard2);
        selectedCards.add(selectedCard3);


        Collections.sort(selectedCards, new Comparator<SelectedCard>() {
            @Override
            public int compare(SelectedCard o1, SelectedCard o2) {
                Integer number1 = o1.getCard().getNumber();
                Integer number2 = o2.getCard().getNumber();
                return number1.compareTo(number2);
            }
        });




        for (SelectedCard card: selectedCards) {
            placeCards(card);
        }

//        for (SelectedCard card:
//             selectedCards) {
//            System.out.println(card.getCard().getNumber());
//        }

    }

    public void placeCards(SelectedCard card) {

        int cardNumber = card.getCard().getNumber();
        HashMap<Integer, Integer> distances = new HashMap<Integer, Integer>();


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
            mainCards.get(firstKey).add(card.getCard());

        } else {

        }



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
}
