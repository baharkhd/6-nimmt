package com.example.a6nimmt;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a6nimmt.cardsUI.CardAdapter;
import com.example.a6nimmt.cardsUI.RecyclerItemClickListener;
import com.example.a6nimmt.logic.Card;
import com.example.a6nimmt.logic.GameLogic;
import com.example.a6nimmt.logic.Player;
import com.example.a6nimmt.logic.SelectedCard;

import java.util.ArrayList;

public class Game {

    private GameLogic gameLogic;
    private Activity activity;

    private RecyclerView row1RecyclerView;
    private RecyclerView row2RecyclerView;
    private RecyclerView row3RecyclerView;
    private RecyclerView row4RecyclerView;
    private RecyclerView row5RecyclerView;

    private CardAdapter row1Adapter;
    private CardAdapter row2Adapter;
    private CardAdapter row3Adapter;
    private CardAdapter row4Adapter;
    private CardAdapter row5Adapter;

    private ArrayList<ArrayList<Card>> mainCards = new ArrayList<ArrayList<Card>>(4);
    private ArrayList<Card> row1 = new ArrayList<>();
    private ArrayList<Card> row2 = new ArrayList<>();
    private ArrayList<Card> row3 = new ArrayList<>();
    private ArrayList<Card> row4 = new ArrayList<>();
    private ArrayList<Card> playerCards = new ArrayList<>();
    private static ArrayList<Card> allCards = new ArrayList<>();
    private boolean canSelectCard = true;

    private Card backOfCard;

    private static ArrayList<SelectedCard> selectedCards = new ArrayList<>();

    private TextView score;
    private TextView username;

    private Player current;
    private int counter = 0;
    private Handler handler;

    public Game(Activity activity) {
        this.activity = activity;
        this.gameLogic = new GameLogic(this);
        backOfCard = new Card(0, 0);
        handler = new Handler();
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public void gameInit() {

        gameLogic.initGame();

        score = activity.findViewById(R.id.score);
        username = activity.findViewById(R.id.username);


        playerCards.add(backOfCard);
        initRecyclerViews();

        Button userBtn = activity.findViewById(R.id.userButton);


        username.setText("??");
        score.setText("??");


        userBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showNextUser();
            }
        });

    }

    public void showNextUser() {
        final int arraySize = playerCards.size();
        String currentPlayerName = "??";
        String currentPlayerScore = "??";
        canSelectCard = true;

        if (counter == MainActivity.players.size()) {
            counter = 0;
            playerCards.clear();
            playerCards.add(backOfCard);
            gameLogic.placeCards(selectedCards);
            selectedCards.clear();

        } else {
            current = MainActivity.players.get(counter);
            playerCards.clear();
            playerCards.addAll(current.getCards());

            counter++;
            currentPlayerName = current.getName();
            currentPlayerScore = current.getScore().toString();
        }

        final String name = currentPlayerName;
        final String curScore = currentPlayerScore;

        handler.post(new Runnable() {
            @Override
            public void run() {
                username.setText(name);
                score.setText(curScore);


                row5Adapter.notifyItemRangeRemoved(0, arraySize);
                row5Adapter.notifyItemInserted(playerCards.size() - 1);
            }
        });
    }


    public void initRecyclerViews() {
        row1RecyclerView = activity.findViewById(R.id.recyclerView1);
        row1Adapter = new CardAdapter(row1);
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
        row2Adapter = new CardAdapter(row2);
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
        row3Adapter = new CardAdapter(row3);
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
        row4Adapter = new CardAdapter(row4);
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
        row5Adapter = new CardAdapter(playerCards);
        row5Adapter.setHasStableIds(true);
        row5RecyclerView.setAdapter(row5Adapter);
        row5RecyclerView.setHasFixedSize(true);

        final Handler handler = new Handler();

        row5RecyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(activity.getApplicationContext(), row5RecyclerView
                        , new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, final int position) {

                        if (counter != 0 && canSelectCard) {
                            selectedCards.add(new SelectedCard(counter - 1 , playerCards.get(position)));
                            playerCards.remove(position);
                            current.getCards().remove(position);
                            canSelectCard = false;

                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    row5Adapter.notifyItemRemoved(position);
                                }
                            });
                        }

                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );


        RecyclerView.LayoutManager layoutManager5 = new LinearLayoutManager(activity);
        row5RecyclerView.setLayoutManager(layoutManager5);
    }

    public static ArrayList<Card> getAllCards() {
        return allCards;
    }

    public static ArrayList<SelectedCard> getSelectedCards() {
        return selectedCards;
    }

    public Activity getActivity() {
        return activity;
    }

    public RecyclerView getRow1RecyclerView() {
        return row1RecyclerView;
    }

    public RecyclerView getRow2RecyclerView() {
        return row2RecyclerView;
    }

    public RecyclerView getRow3RecyclerView() {
        return row3RecyclerView;
    }

    public RecyclerView getRow4RecyclerView() {
        return row4RecyclerView;
    }

    public RecyclerView getRow5RecyclerView() {
        return row5RecyclerView;
    }

    public CardAdapter getRow1Adapter() {
        return row1Adapter;
    }

    public CardAdapter getRow2Adapter() {
        return row2Adapter;
    }

    public CardAdapter getRow3Adapter() {
        return row3Adapter;
    }

    public CardAdapter getRow4Adapter() {
        return row4Adapter;
    }

    public CardAdapter getRow5Adapter() {
        return row5Adapter;
    }

    public ArrayList<ArrayList<Card>> getMainCards() {
        return mainCards;
    }

    public ArrayList<Card> getRow1() {
        return row1;
    }

    public ArrayList<Card> getRow2() {
        return row2;
    }

    public ArrayList<Card> getRow3() {
        return row3;
    }

    public ArrayList<Card> getRow4() {
        return row4;
    }

    public ArrayList<Card> getPlayerCards() {
        return playerCards;
    }

    public void setPlayerCards(ArrayList<Card> playerCards) {
        this.playerCards = playerCards;
    }
}
