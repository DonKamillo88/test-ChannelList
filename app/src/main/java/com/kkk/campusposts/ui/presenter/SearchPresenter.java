package com.kkk.campusposts.ui.presenter;

import android.content.Context;

import com.kkk.campusposts.ui.activity.ChannelsView;

/**
 * Created by DonKamillo on 07.09.2016.
 */

public interface SearchPresenter {
    void attachView(Context context, ChannelsView channelsView);

    void onStop();
}
