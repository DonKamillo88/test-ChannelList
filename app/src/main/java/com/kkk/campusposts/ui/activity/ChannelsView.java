package com.kkk.campusposts.ui.activity;

import com.kkk.campusposts.services.SearchResponse;

import java.util.List;

/**
 * Created by DonKamillo on 07.09.2016.
 */

public interface ChannelsView {

    void showError(String errorMessage);

    void showChannels(List<SearchResponse.Result> results);

}
