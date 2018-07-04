package com.example.alex.rssfeed.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.alex.rssfeed.R;
import com.example.alex.rssfeed.events.NewsItemSelectedEvent;
import com.example.alex.rssfeed.news.Item;
import com.facebook.drawee.view.SimpleDraweeView;


import org.greenrobot.eventbus.EventBus;

import java.util.List;

public class NewsItemAdapter extends RecyclerView.Adapter<NewsItemAdapter.ViewHolder> {

    private final String IMAGE_KEYWORD = "image";
    private List<Item> mNewsList;
    public Context mContext;

    public NewsItemAdapter(List<Item> newsList) {
        this.mNewsList = newsList;
        hasStableIds();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_news_item, parent, false);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClick(v);
            }
        });
        return new ViewHolder(view);
    }

    private void itemClick(View view) {
        Item item = (Item) view.getTag();
        EventBus.getDefault().post(new NewsItemSelectedEvent(item));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item item = mNewsList.get(position);

        holder.simpleDraweeView.setVisibility(View.GONE);
        holder.textViewTitle.setText(item.getTitle());
        holder.textViewDate.setText(item.getPubDate());

        holder.itemView.setTag(item);
    }

    @Override
    public int getItemCount() {
        if (mNewsList != null) {
            return mNewsList.size();
        }
        else{
            return 0;
        }


    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public SimpleDraweeView simpleDraweeView;
        public TextView textViewTitle;
        public TextView textViewDate;

        public ViewHolder(View itemView) {
            super(itemView);
            simpleDraweeView = itemView.findViewById(R.id.simpleDraweeView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDate = itemView.findViewById(R.id.textViewDate);
        }
    }
}
