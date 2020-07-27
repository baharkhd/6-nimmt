package com.example.a6nimmt;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;

public class ScoreBoardFragment extends DialogFragment {

    private EditText mEditText;


    public ScoreBoardFragment() {

        // Empty constructor is required for DialogFragment

        // Make sure not to add arguments to the constructor

        // Use `newInstance` instead as shown below

    }


    public static ScoreBoardFragment newInstance(String title) {

        ScoreBoardFragment frag = new ScoreBoardFragment();

        Bundle args = new Bundle();

        args.putString("title", title);

        frag.setArguments(args);

        return frag;

    }


    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_layout, container);

    }


    @Override

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        LayoutInflater inflater = (LayoutInflater)GameActivity.getGameContext().getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);

        TableLayout tableLayout = view.findViewById(R.id.scoreboard);

        TextView textView1;
        TextView textView2;

        ArrayList<String> firsts = new ArrayList<>();
        firsts.add("bahar");
        firsts.add("kk");

        ArrayList<String> seconds = new ArrayList<>();
        seconds.add("baharak");
        seconds.add("khd");



        for (int i = 0; i < 2; i++) {
            TableRow tableRow = (TableRow) inflater.inflate(R.layout.scoreboard_row,null);
            tableRow.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT));

            textView1 = tableRow.findViewById(R.id.text1);
            textView1.setText(firsts.get(i));

            textView2 = tableRow.findViewById(R.id.text2);
            textView2.setText(seconds.get(i));

//        TextView playersText = new TextView(GameActivity.getGameContext());
//        playersText.setText("players");
//
//        TextView scoresText = new TextView(GameActivity.getGameContext());
//        scoresText.setText("scores");
//
//        tableRow.addView(playersText);
//        tableRow.addView(scoresText);

            tableLayout.addView(tableRow, new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT,
                    TableLayout.LayoutParams.WRAP_CONTENT));

        }

        TableRow tableRow = (TableRow) inflater.inflate(R.layout.scoreboard_row,null);
        tableRow.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT));


//        TextView playersText = new TextView(GameActivity.getGameContext());
//        playersText.setText("players");
//
//        TextView scoresText = new TextView(GameActivity.getGameContext());
//        scoresText.setText("scores");
//
//        tableRow.addView(playersText);
//        tableRow.addView(scoresText);

        tableLayout.addView(tableRow, new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));


//        // Get field from view
//
//        mEditText = (EditText) view.findViewById(R.id.txt_your_name);
//
//        // Fetch arguments from bundle and set title
//
//        String title = getArguments().getString("title", "Enter Name");
//
//        getDialog().setTitle(title);
//
//        // Show soft keyboard automatically and request focus to field
//
//        mEditText.requestFocus();
//
//        getDialog().getWindow().setSoftInputMode(
//
//                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

    }
}
