package com.example.a6nimmt.cardsUI;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a6nimmt.GameActivity;
import com.example.a6nimmt.R;
import com.example.a6nimmt.logic.Card;

import java.util.ArrayList;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {

    private ArrayList<Card> myCards;
//    private RecyclerView mRecyclerView;

    public class CardViewHolder extends RecyclerView.ViewHolder {

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public CardAdapter(ArrayList<Card> myCards) {
        this.myCards = myCards;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
//        view.setOnClickListener(mOnClickListener);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        ImageView cardImage = holder.itemView.findViewById(R.id.image);

        String cardName;
        if (myCards.get(position).getNumber() == 0) {
            cardName = "card_back";
        } else {
            cardName = "card" + myCards.get(position).getNumber();
        }
        Resources res = GameActivity.getGameContext().getResources();
        int resID = res.getIdentifier(cardName , "drawable", GameActivity.getGameContext().getPackageName());
        Bitmap myBitmap=((BitmapDrawable) GameActivity.getGameContext().getResources().getDrawable(resID)).getBitmap();
//        Bitmap imageRounded=Bitmap.createBitmap(myBitmap.getWidth(), myBitmap.getHeight(), myBitmap.getConfig());
//        Canvas canvas=new Canvas(imageRounded);
//        Paint myPaint=new Paint();
//        myPaint.setAntiAlias(true);
//        myPaint.setShader(new BitmapShader(myBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
//        canvas.drawRoundRect((new RectF(0, 0, myBitmap.getWidth(),
//                myBitmap.getHeight())), 100, 100, myPaint); // Round Image Corner 100 100 100 100

//        cardImage.setImageBitmap(imageRounded);

        cardImage.setImageBitmap(myBitmap);

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
