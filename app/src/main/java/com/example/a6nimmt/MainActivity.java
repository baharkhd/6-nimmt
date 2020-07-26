package com.example.a6nimmt;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a6nimmt.logic.Card;
import com.example.a6nimmt.logic.Player;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Player> players = new ArrayList<>();


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);


        Button button = findViewById(R.id.button);

        Player player1 = new Player("Amir", 0);
        Player player2 = new Player("aida", 0);
        Player player3 = new Player("Amirre`", 0);
        players.add(player1);
        players.add(player2);
        players.add(player3);


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

    }
}
