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

import com.example.a6nimmt.Game;
import com.example.a6nimmt.MainActivity;
import com.example.a6nimmt.R;
import com.example.a6nimmt.logic.Card;

import java.util.ArrayList;

public class CardAdapter2 extends RecyclerView.Adapter<CardAdapter2.CardViewHolder2> {

    private ArrayList<Card> myCards;
    private RecyclerView mRecyclerView;

//    private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            int itemPosition = mRecyclerView.getChildLayoutPosition(view);
//            String item = myCards.get(itemPosition);
//            MainActivity.addedCards.add(item);
//        }
//    };


    public class CardViewHolder2 extends RecyclerView.ViewHolder {

        public CardViewHolder2(@NonNull View itemView) {
            super(itemView);
        }
    }

    public CardAdapter2(ArrayList<Card> myCards, RecyclerView recyclerView) {
        this.myCards = myCards;
        this.mRecyclerView = recyclerView;
    }

    @NonNull
    @Override
    public CardViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
//        view.setOnClickListener(mOnClickListener);
        return new CardViewHolder2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder2 holder, int position) {
        ImageView cardImage = holder.itemView.findViewById(R.id.image);

        String cardName = "card" + myCards.get(position).getNumber();
        Resources res = Game.getGameContext().getResources();
        int resID = res.getIdentifier(cardName , "drawable", Game.getGameContext().getPackageName());
        Bitmap myBitmap=((BitmapDrawable) Game.getGameContext().getResources().getDrawable(resID)).getBitmap();
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

}
