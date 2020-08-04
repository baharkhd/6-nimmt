package com.example.a6nimmt.menu;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.a6nimmt.R;

public class NameofPlayers extends Fragment {
    EditText[] editTexts;
    String[] names;
    private OnNamesListener mListener;
    private static final String ARG_PARAM1 = "param1";
    private int noOfPlayers;

    public NameofPlayers() {
        // Required empty public constructor
    }

    public static NameofPlayers newInstance() {
        NameofPlayers fragment = new NameofPlayers();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            noOfPlayers = getArguments().getInt(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        editTexts = new EditText[noOfPlayers];
        names = new String[noOfPlayers];
        LinearLayout linearLayout = new LinearLayout(getContext());

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        linearLayout.setLayoutParams(params);
        linearLayout.setHorizontalGravity(Gravity.CENTER_HORIZONTAL);
        linearLayout.setHorizontalGravity(Gravity.CENTER_VERTICAL);

        linearLayout.setGravity(Gravity.CENTER);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        for (int i = 0; i < noOfPlayers; i++) {

            EditText e = (EditText) inflater.inflate(R.layout.player_name_layout, container, false);

            linearLayout.addView(e);
            editTexts[i] = e;
        }
        Button ok = (Button) inflater.inflate(R.layout.ok_button, container, false);
        linearLayout.addView(ok);
        getNames(ok);
        return linearLayout;
    }

    private void getNames(Button ok) {
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean entered_correctly = true;
                for (int i = 0; i < noOfPlayers; i++) {
                    String s = String.valueOf(editTexts[i].getText());
                    if (s.isEmpty() || !entered_correctly) {
                        entered_correctly = false;
                        break;
                    }
                    for (int j = 0; j < i; j++) {
                        if (names[j].equals(s)) {
                            entered_correctly = false;
                            break;
                        }
                    }
                    names[i] = s;
                }
                if (entered_correctly) {
                    if (mListener != null) {
                        mListener.onNamesEntered(names);
                    }
                } else {
                    Toast.makeText(getContext(), R.string.enter_names, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof NameofPlayers.OnNamesListener) {
            mListener = (NameofPlayers.OnNamesListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnNamesListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnNamesListener {
        void onNamesEntered(String[] names);
    }

}
