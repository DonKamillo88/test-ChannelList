package com.kkk.campusposts.ui.presenter;

import android.content.Context;

import com.kkk.campusposts.services.CampusSociety;
import com.kkk.campusposts.services.CampusSocietyService;
import com.kkk.campusposts.services.SearchResponse;
import com.kkk.campusposts.ui.activity.ChannelsView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by DonKamillo on 07.09.2016.
 */

public class SearchPresenterImpl implements SearchPresenter, Callback<SearchResponse> {
    private Call<SearchResponse> call;
    private CampusSociety campusSociety;
    private ChannelsView channelsView;

    @Override
    public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
        channelsView.showChannels(response.body().getResults());
    }

    @Override
    public void onFailure(Call<SearchResponse> call, Throwable t) {
        channelsView.showError(t.getMessage());
    }

    @Override
    public void attachView(Context context, ChannelsView channelsView) {
        this.channelsView = channelsView;
    }

    @Override
    public void onStop() {
        if (call != null)
            call.cancel();
    }

    public void callForChannels(String token, String page, String sortBy) {
        call = getCampusSociety().search(token, sortBy, page);
        call.enqueue(this);
    }

    private CampusSociety getCampusSociety() {
        if (campusSociety == null)
            campusSociety = CampusSocietyService.getService();
        return campusSociety;
    }
}
