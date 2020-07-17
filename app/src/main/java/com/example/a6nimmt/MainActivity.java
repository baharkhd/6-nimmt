package com.example.a6nimmt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.a6nimmt.menu.NoofPlayers;
import com.example.a6nimmt.menu.StartPage;


public class MainActivity extends AppCompatActivity {

    StartPage startPage;
    NoofPlayers noofPlayers;
    public static int no_of_players;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            startPage = new StartPage();
            startPage.setArguments(this.getIntent().getExtras());
            StartPage.activity = this;
            getSupportFragmentManager().beginTransaction().replace(R.id.page_content, startPage).commit();
        }
    }

    public void startbutton(View view) {
        if (findViewById(R.id.no_of_players) != null) {
            noofPlayers = new NoofPlayers();
            noofPlayers.setArguments(this.getIntent().getExtras());
            NoofPlayers.activity = this;
            getSupportFragmentManager().beginTransaction().replace(R.id.no_of_players, noofPlayers).commit();
        }
    }

    public void exitButton(View view) {
        startPage.exitButton(view);
    }
}
