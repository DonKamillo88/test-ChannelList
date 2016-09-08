package com.kkk.campusposts.ui.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.kkk.campusposts.R;
import com.kkk.campusposts.services.SearchResponse;
import com.kkk.campusposts.ui.presenter.SearchPresenterImpl;
import com.kkk.campusposts.utils.EndlessRecyclerOnScrollListener;

import java.util.List;

/**
 * Created by DonKamillo on 07.09.2016.
 */

public class ChannelsActivity extends AppCompatActivity implements ChannelsView {
    public static final String TOKEN_ARG = "token_agr";
    private static final String SORT_BY = "recent";
    private static final String FIRST_PAGE = "1";

    private SearchPresenterImpl searchPresenter;
    private String token;
    private ChannelAdapter adapter;
    private SwipeRefreshLayout swipeContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel);

        swipeContainer = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                searchPresenter.callForChannels(token, FIRST_PAGE, SORT_BY);
            }
        });

        getParams();
        initRecyclerView();
        initPresenter();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setOnScrollListener(new EndlessRecyclerOnScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int current_page) {
                searchPresenter.callForChannels(token, current_page + "", SORT_BY);
            }
        });

        adapter = new ChannelAdapter(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        searchPresenter.callForChannels(token, FIRST_PAGE, SORT_BY);
    }

    @Override
    protected void onStop() {
        super.onStop();
        searchPresenter.onStop();
    }

    @Override
    public void showError(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
        swipeContainer.setRefreshing(false);
    }

    @Override
    public void showChannels(List<SearchResponse.Result> results) {
        adapter.addItems(results);
        swipeContainer.setRefreshing(false);
    }

    private void getParams() {
        Bundle b = getIntent().getExtras();
        if (b != null)
            token = b.getString(TOKEN_ARG);
    }

    private void initPresenter() {
        searchPresenter = new SearchPresenterImpl();
        searchPresenter.attachView(this, this);
    }
}