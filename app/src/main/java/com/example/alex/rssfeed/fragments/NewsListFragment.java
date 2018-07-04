package com.example.alex.rssfeed.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alex.rssfeed.DataController;
import com.example.alex.rssfeed.R;
import com.example.alex.rssfeed.adapters.NewsItemAdapter;
import com.example.alex.rssfeed.events.GetTechcrunchNewsEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class NewsListFragment extends Fragment {

    public final String KEY_LINK="KEY_LINK";
    RecyclerView mRecyclerView;
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_news_list,container, false);
        mRecyclerView = root.findViewById(R.id.recyclerView);
        mSwipeRefreshLayout = root.findViewById(R.id.swipeRefresh);
        mSwipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        refreshList();
                    }
                });
        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        EventBus.getDefault().register(this);
        DataController.getInstance().getTechcrunchNewsFeed();
    }

    private void refreshList() {
        DataController.getInstance().getTechcrunchNewsFeed();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Subscribe
    public void onEventMainThread(GetTechcrunchNewsEvent event) {
        mSwipeRefreshLayout.setRefreshing(false);
        if (event.rss != null) {
            NewsItemAdapter newsItemAdapter = new NewsItemAdapter(event.rss.getChannel().getItems());
            mRecyclerView.setAdapter(newsItemAdapter);
        }
    }
}
