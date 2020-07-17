package com.example.a6nimmt.logic;

import com.example.a6nimmt.MainActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DataManager {

    private String fileName = "allCards.json";
    private File file;


    public void handleData() throws IOException, JSONException {
        file = new File(MainActivity.getAppContext().getFilesDir(), fileName);

        if (file.exists()) {
            readData();
        } else {
            writeData();
            readData();
        }
    }


    public void writeData() throws IOException, JSONException {

        int score, number;

        JSONArray cardsArray = new JSONArray();

        for (int i = 0; i < 104; i++) {
            number = i + 1;

            if (number == 55) {
                score = 7;
            } else if (number % 10 == 0) {
                score = 3;
            } else if (number % 11 == 0) {
                score = 5;
            } else if (number % 5 == 0) {
                score = 2;
            } else {
                score = 1;
            }

            JSONObject cardObj = new JSONObject();

            cardObj.put("number", number);
            cardObj.put("score", score);

            cardsArray.put(cardObj);
        }

        String dataString = cardsArray.toString();

        file.createNewFile();
        FileWriter fileWriter = new FileWriter(file);

        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(dataString);
        bufferedWriter.close();
    }

    public void readData() throws IOException, JSONException {

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuilder stringBuilder = new StringBuilder();
        String line = bufferedReader.readLine();
        while (line != null){
            stringBuilder.append(line).append("\n");
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        String res = stringBuilder.toString();

        JSONArray cardsArray  = new JSONArray(res);

        MainActivity.cards.clear();
        int number, score;
        for (int i = 0; i < 104; i++) {
            number = Integer.parseInt(((JSONObject)cardsArray.get(i)).get("number").toString());
            score = Integer.parseInt(((JSONObject)cardsArray.get(i)).get("score").toString());
            Card card = new Card(score, number);
            MainActivity.cards.add(card);
        }
    }
}
