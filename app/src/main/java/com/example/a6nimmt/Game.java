package com.example.a6nimmt;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
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
    private boolean gameIsOver = false;

    private Card backOfCard;
    private Button userBtn;

    private static ArrayList<SelectedCard> selectedCards = new ArrayList<>();

    private TextView score;
    private TextView username;

    private Player current;
    private int counter = 0;
    private Handler handler;

    private MediaPlayer onCardClickSound;

    public Game(Activity activity, Button userBtn) {
        this.activity = activity;
        this.gameLogic = new GameLogic(this);
        backOfCard = new Card(0, 0);
        handler = new Handler();
        this.userBtn = userBtn;
        onCardClickSound = MediaPlayer.create(GameActivity.getGameContext(), R.raw.button_click_1);
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public void gameInit() {

        gameLogic.initGame();

        score = activity.findViewById(R.id.score);
        username = activity.findViewById(R.id.username);


        playerCards.add(backOfCard);
        initRecyclerViews();

//        userBtn = activity.findViewById(R.id.userButton);


        username.setText("??");
        score.setText("??");


//        userBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (gameIsOver) {
//                    Toast.makeText(activity.getApplicationContext(), "Game Over!", Toast.LENGTH_LONG).show();
//                    //Todo : start scoreboard fragment
////                showScoreboard();
//
//                } else {
//                    if (canSelectCard && counter != 0) {
//                        Toast.makeText(activity.getApplicationContext(), "Choose a card, please!", Toast.LENGTH_LONG).show();
//                    } else {
//                        showNextUser();
//                    }
//                }
//
//
//            }
//        });

    }

    public void showScoreboard() {
//        FragmentManager fm =(GameActivity.getGameContext()).getSupportFragmentManager();
//
//        ScoreBoardFragment editNameDialogFragment = ScoreBoardFragment.newInstance("Some Title");
//
//        editNameDialogFragment.show(fm, "fragment_edit_name");
    }

    public void showNextUser() {
        final int arraySize = playerCards.size();
        String currentPlayerName = "??";
        String currentPlayerScore = "??";
        canSelectCard = true;

        if (counter == GameActivity.players.size()) {
            counter = 0;
            playerCards.clear();
            playerCards.add(backOfCard);
            gameLogic.placeCards(selectedCards);
            selectedCards.clear();

        } else {
            current = GameActivity.players.get(counter);
            playerCards.clear();
            playerCards.addAll(current.getCards());

            counter++;
            currentPlayerName = current.getName();
            currentPlayerScore = current.getScore().toString();
        }

        final String name = currentPlayerName;
        final String curScore = currentPlayerScore;

        if (counter == 0 && GameActivity.players.get(0).getCards().size() == 0) {

            gameIsOver = true;

            handler.post(new Runnable() {
                @Override
                public void run() {
                    userBtn.setText("Show Scores");
                    username.setText(name);
                    score.setText(curScore);
                }
            });
        } else {
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

    }


    public void initRecyclerViews() {
        row1RecyclerView = activity.findViewById(R.id.recyclerView1);
        row1Adapter = new CardAdapter(row1);
        row1Adapter.setHasStableIds(true);
        row1RecyclerView.setAdapter(row1Adapter);
        row1RecyclerView.setHasFixedSize(true);
        row1RecyclerView.setItemViewCacheSize(5);


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
        row2RecyclerView.setItemViewCacheSize(5);


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
        row3RecyclerView.setItemViewCacheSize(5);


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
        row4RecyclerView.setItemViewCacheSize(5);


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
        row5RecyclerView.setItemViewCacheSize(10);

        final Handler handler = new Handler();

        row5RecyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(activity.getApplicationContext(), row5RecyclerView
                        , new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, final int position) {
                        onCardClickSound.start();
                        if (counter != 0 && canSelectCard) {
                            selectedCards.add(new SelectedCard(counter - 1, playerCards.get(position)));
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

    public boolean isCanSelectCard() {
        return canSelectCard;
    }

    public boolean isGameIsOver() {
        return gameIsOver;
    }

    public int getCounter() {
        return counter;
    }
}
