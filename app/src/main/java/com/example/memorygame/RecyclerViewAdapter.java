package com.example.memorygame;

import android.content.Context;
import android.content.Intent;
//import android.support.v7.widget.CardView;
//import android.support.v7.widget.RecyclerView;
import android.os.AsyncTask;
import android.text.PrecomputedText;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Aws on 28/01/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext ;
    private List<Card> mData ;
    private int selectedDifficulty;
    private boolean isSleeping;

    private int shownCardsCounter = 0;
//    private List<MyViewHolder> shownCards;
    private Map<MyViewHolder, Card> shownCards = new HashMap<>();

    public RecyclerViewAdapter(Context mContext, List<Card> mData, int selectedDifficulty) {
        this.mContext = mContext;
        this.mData = mData;
        this.selectedDifficulty = selectedDifficulty;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_item_card,parent,false);
        return new MyViewHolder(view, selectedDifficulty);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        // set default card image
        holder.img_book_thumbnail.setImageResource(mData.get(position).getDefaultThumbnail());

        holder.tv_book_title.setText("");

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isSleeping) {
                    return;
                }
                if (shownCardsCounter < 2) {
                    holder.img_book_thumbnail.setImageResource(mData.get(position).getThumbnail());

                    holder.tv_book_title.setText(mData.get(position).getTitle());

                    Card tmp = mData.get(position);
                    MyViewHolder foo = holder;
                    shownCards.put(foo, tmp);
                    shownCardsCounter++;
                } else {
                    resetShownCards();
                    shownCardsCounter = 0;
                }

                if (shownCardsCounter == 2) {
//                    holder.img_book_thumbnail.setImageResource(mData.get(position).getThumbnail());
                    MyAsyncTask task = new MyAsyncTask(holder, mData.get(position));
                    task.execute();
                }
            }
        });
    }

    private class MyAsyncTask extends AsyncTask<Void, Void, Void> {

        public MyAsyncTask(MyViewHolder vh, Card card) {
            super();
            vh.img_book_thumbnail.setImageResource(card.getThumbnail());
            shownCards.put(vh, card);
        }

        private String resp;

        @Override
        protected Void doInBackground(Void... params) {
            isSleeping = true;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            checkCards();
            shownCardsCounter = 0;
            isSleeping = false;
        }
    }


    private void checkCards() {
        String firstTitle = null;
        boolean isSame = false;
        for (Map.Entry<MyViewHolder, Card> entry : shownCards.entrySet()) {
            entry.getKey().img_book_thumbnail.setImageResource(entry.getValue().getDefaultThumbnail());
            if (firstTitle == null) {
                firstTitle = entry.getValue().getTitle();
            } else if (firstTitle == entry.getValue().getTitle()) {
                // found a pair
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                deleteCards();
                isSame = true;
            }
        }

        if (!isSame) {
            resetShownCards();
        }
    }

    private void deleteCards() {
        for (Map.Entry<MyViewHolder, Card> entry : shownCards.entrySet()) {
            entry.getKey().cardView.setVisibility(View.INVISIBLE);
        }
        shownCards = new HashMap<>();
    }
    
    private void resetShownCards() {
        for (Map.Entry<MyViewHolder, Card> entry : shownCards.entrySet()) {
            entry.getKey().img_book_thumbnail.setImageResource(entry.getValue().getDefaultThumbnail());
        }
        shownCards = new HashMap<>();
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_book_title;
        ImageView img_book_thumbnail;
        CardView cardView ;

        ViewGroup.LayoutParams layoutParams;

        public MyViewHolder(View itemView, int selectedDifficulty) {
            super(itemView);

            tv_book_title = (TextView) itemView.findViewById(R.id.book_title_id) ;
            img_book_thumbnail = (ImageView) itemView.findViewById(R.id.book_img_id);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id);

            layoutParams = cardView.getLayoutParams();
            switch (selectedDifficulty) {
                case 1:
                    layoutParams.height = 600;
                    break;
                case 2:
                    layoutParams.height = 400;
                    break;
                case 3:
                    layoutParams.height = 400;
                    break;
            }

        }
    }
}