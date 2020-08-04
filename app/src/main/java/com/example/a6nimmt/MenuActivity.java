package com.example.a6nimmt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.a6nimmt.menu.ChangeBackground;
import com.example.a6nimmt.menu.NameofPlayers;
import com.example.a6nimmt.menu.NoofPlayers;
import com.example.a6nimmt.menu.StartPage;


public class MenuActivity extends AppCompatActivity implements NameofPlayers.OnNamesListener {

    StartPage startPage;
    String TAG1 = "startPage";
    NoofPlayers noofPlayers;
    String TAG2 = "noofPlayers";
    NameofPlayers nameofPlayers;
    String TAG3 = "nameofPlayers";
    public static int no_of_players;
    private static EditText numOfPlayersEditText;
    private NoofPlayers numOfPlayersFrag;

    private MediaPlayer buttonClickSound;

    private int background;

    public static Context appContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        appContext = this.getApplicationContext();

        buttonClickSound = MediaPlayer.create(this, R.raw.button_click_1);


        if (savedInstanceState == null) {
            startPage = new StartPage();
            startPage.setArguments(this.getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().replace(R.id.page_content, startPage)
                    .commit();
        }
    }

    public void startButton(View view) {
        buttonClickSound.start();
        FragmentManager fm = getSupportFragmentManager();

        numOfPlayersFrag = NoofPlayers.newInstance("num of players");

        Bundle args = new Bundle();
        numOfPlayersFrag.setArguments(args);


        numOfPlayersFrag.show(fm, "num of players");


    }

     @Override public void onResume(){
        super.onResume();
        background();
     }

    public void exitButton(View view) {
        buttonClickSound.start();
        startPage.exitButton(view);
    }

    public void numberOfPlayers(View view) {
        buttonClickSound.start();
        EditText editText = numOfPlayersEditText;
        String s = editText.getText().toString().trim();
        boolean b = true;
        if (s.isEmpty()) {
            b = false;
        } else if (Integer.valueOf(s) > 10 || Integer.valueOf(s) < 2) {
            b = false;
        }
        if (b) {
            no_of_players = Integer.valueOf(s);
            enterNamesFragment();
        } else {
            Toast.makeText(this, R.string.number_error,
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void enterNamesFragment() {
        nameofPlayers = NameofPlayers.newInstance();

        Bundle args = new Bundle();
        args.putInt("param1", no_of_players);
        nameofPlayers.setArguments(args);

        getSupportFragmentManager().beginTransaction().remove(numOfPlayersFrag).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.page_content, nameofPlayers)
                .addToBackStack(TAG3).commit();

    }

    @Override
    public void onNamesEntered(String[] names) {
        buttonClickSound.start();

        Intent myIntent = new Intent(this, GameActivity.class);
        myIntent.putExtra("playerNames", names);
        myIntent.putExtra("background", background);
        startActivity(myIntent);
    }

    public static void setNumOfPlayersEditText(EditText numOfPlayersEditText) {
        MenuActivity.numOfPlayersEditText = numOfPlayersEditText;
    }

    public void changeBackground(View view) {
        ChangeBackground changeBackground = new ChangeBackground();
        changeBackground.setArguments(this.getIntent().getExtras());
        getSupportFragmentManager().beginTransaction().replace(R.id.page_content, changeBackground)
                .addToBackStack("back").commit();
    }

    public void backgroundChosen(View view) {
        background = view.getId();
        background();
    }

    private void background() {
        RelativeLayout menuBackground = findViewById(R.id.menu_background);
        switch (background){
            case  R.id.red_image:
                menuBackground.setBackgroundResource(R.drawable.red_colored_background);
                break;
            case R.id.dark_image:
                menuBackground.setBackgroundResource(R.drawable.dark_blue_background);
                break;
            case R.id.colorful_image:
                menuBackground.setBackgroundResource(R.drawable.bright_colors_background);
                break;
            case R.id.white:
                menuBackground.setBackgroundResource(R.drawable.light_wooden_background);
                break;
        }
    }
}
