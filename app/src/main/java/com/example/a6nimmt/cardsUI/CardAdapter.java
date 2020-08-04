package com.example.a6nimmt.cardsUI;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a6nimmt.GameActivity;
import com.example.a6nimmt.R;
import com.example.a6nimmt.logic.Card;

import java.util.ArrayList;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {

    private ArrayList<Card> myCards;
    private Handler handler;

    public class CardViewHolder extends RecyclerView.ViewHolder {

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public CardAdapter(ArrayList<Card> myCards) {
        this.myCards = myCards;
        handler = new Handler();
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);

        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewHolder holder, final int position) {
        ImageView cardImage = holder.itemView.findViewById(R.id.image);

        String cardName;
        if (myCards.get(position).getNumber() == 0) {
            cardName = "card_back";
        } else {
            cardName = "card" + myCards.get(position).getNumber();
        }
        Resources res = GameActivity.getGameContext().getResources();
        int resID = res.getIdentifier(cardName, "drawable", GameActivity.getGameContext().getPackageName());
        Bitmap myBitmap = ((BitmapDrawable) GameActivity.getGameContext().getResources().getDrawable(resID)).getBitmap();
        cardImage.setImageBitmap(myBitmap);

        handler.post(new Runnable() {
            @Override
            public void run() {
                setAnimation(holder.itemView, position);
            }
        });



    }

    private void setAnimation(View viewToAnimate, int position) {

        Animation animation = AnimationUtils.loadAnimation(GameActivity.getGameContext(), R.anim.item_animation_fall_down);
        viewToAnimate.startAnimation(animation);

    }

    @Override
    public int getItemCount() {
        return myCards.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

}
