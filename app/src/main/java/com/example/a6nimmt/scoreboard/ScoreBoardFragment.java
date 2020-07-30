package com.example.a6nimmt.scoreboard;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.a6nimmt.MenuActivity;
import com.example.a6nimmt.R;

import java.util.ArrayList;

public class ScoreBoardFragment extends DialogFragment {

    public ScoreBoardFragment() {
    }


    public static ScoreBoardFragment newInstance(String title) {

        ScoreBoardFragment frag = new ScoreBoardFragment();

        Bundle args = new Bundle();

        args.putString("scoreboard", title);

        frag.setArguments(args);

        return frag;

    }


    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.scoreboard_layout, container, false);
        if (getDialog() != null && getDialog().getWindow() != null) {
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        }
        return view;

    }


    @Override

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        ArrayList<String> names = getArguments().getStringArrayList("names");
        ArrayList<String> scores = getArguments().getStringArrayList("scores");

        //Todo : change it!
//        LayoutInflater inflater = (LayoutInflater) GameActivity.getGameContext().getSystemService
//                (Context.LAYOUT_INFLATER_SERVICE);

        LayoutInflater inflater = (LayoutInflater) MenuActivity.appContext.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);

        TableLayout tableLayout = view.findViewById(R.id.scoreboard);

        TextView textView1;
        TextView textView2;


        for (int i = 0; i < names.size(); i++) {
            TableRow tableRow = (TableRow) inflater.inflate(R.layout.scoreboard_row,null);
            tableRow.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT));

            textView1 = tableRow.findViewById(R.id.text1);
            textView1.setText(names.get(i));

            textView2 = tableRow.findViewById(R.id.text2);
            textView2.setText(scores.get(i));

            tableLayout.addView(tableRow, new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT,
                    TableLayout.LayoutParams.WRAP_CONTENT));

        }

        TableRow tableRow = (TableRow) inflater.inflate(R.layout.scoreboard_row,null);
        tableRow.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT));

        tableLayout.addView(tableRow, new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));

    }
}
