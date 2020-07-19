package com.example.a6nimmt.menu;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.example.a6nimmt.R;

public class NameofPlayers extends Fragment {
    EditText[] editTexts;
    private static final String ARG_PARAM1 = "param1";
    private int noOfPlayers;

    public NameofPlayers() {
        // Required empty public constructor
    }

    public static NameofPlayers newInstance(int noOfPlayers) {
        NameofPlayers fragment = new NameofPlayers();
        fragment.noOfPlayers = noOfPlayers;
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, String.valueOf(noOfPlayers));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            noOfPlayers = Integer.parseInt(getArguments().getString(ARG_PARAM1));
        }
//        editTexts = new EditText[noOfPlayers];
//        RelativeLayout relativeLayout = getView().findViewById(R.id.nameof_players_layout);
//        for(int i = 0; i < noOfPlayers; i++){
//            EditText e = new EditText(getContext());
//            e.setHint(R.string.name_of_player);
//            e.setId(i);
//            e.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,
//                    ViewGroup.LayoutParams.WRAP_CONTENT));
//            relativeLayout.addView(e);
//            editTexts[i] = e;
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nameof_players, container, false);
    }
}
