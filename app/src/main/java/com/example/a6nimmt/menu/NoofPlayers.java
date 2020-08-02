package com.example.a6nimmt.menu;


import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.a6nimmt.MenuActivity;
import com.example.a6nimmt.R;
import com.example.a6nimmt.scoreboard.ScoreBoardFragment;

import java.util.ArrayList;


public class NoofPlayers extends DialogFragment {

    public NoofPlayers() {
    }


    public static NoofPlayers newInstance(String title) {

        NoofPlayers frag = new NoofPlayers();

        Bundle args = new Bundle();

        args.putString("scoreboard", title);

        frag.setArguments(args);

        return frag;

    }


    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.num_of_players_fragment, container, false);
        if (getDialog() != null && getDialog().getWindow() != null) {
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        }
        return view;

    }


    @Override

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        EditText editText = view.findViewById(R.id.numberInput);
        MenuActivity.setNumOfPlayersEditText(editText);
    }
}