package com.kkk.campusposts.ui.activity;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kkk.campusposts.R;
import com.kkk.campusposts.services.SearchResponse;

import java.util.List;

/**
 * Created by DonKamillo on 07.09.2016.
 */

class ChannelAdapter extends RecyclerView.Adapter<ChannelAdapter.ChannelViewHolder> {
    private List<SearchResponse.Result> channels;
    private Context context;

    ChannelAdapter(Context context) {
        this.context = context;
    }

    void addItems(List<SearchResponse.Result> channels) {
        if (this.channels == null) {
            this.channels = channels;
        } else {
            this.channels.addAll(channels);
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (channels == null) return 0;
        return channels.size();
    }

    @Override
    public void onBindViewHolder(ChannelViewHolder holder, int i) {
        SearchResponse.Result channel = channels.get(i);

        Resources res = context.getResources();

        holder.channelName.setText(channel.getChannelName());
        holder.noComments.setText(String.format(res.getString(R.string.comments), channel.getNoComments()));
        holder.noLikes.setText(String.format(res.getString(R.string.likes), channel.getNoLikes()));
        holder.content.setText(channel.getContent());
        holder.author.setText(channel.getAuthor().getFullName());
        if (channel.getPicture() != null && channel.getPicture().getSmall() != null)
            holder.showPhoto(channel.getPicture().getSmall());
    }

    @Override
    public ChannelViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.channel_item, viewGroup, false);

        return new ChannelViewHolder(itemView);
    }

    class ChannelViewHolder extends RecyclerView.ViewHolder {
        TextView channelName, noComments, noLikes, content, author;
        ImageView photo;

        ChannelViewHolder(View v) {
            super(v);

            photo = (ImageView) v.findViewById((R.id.photo));

            channelName = (TextView) v.findViewById(R.id.channel_name);
            noComments = (TextView) v.findViewById(R.id.no_comments);
            noLikes = (TextView) v.findViewById(R.id.no_likes);
            content = (TextView) v.findViewById(R.id.content);
            author = (TextView) v.findViewById(R.id.author_name);
        }

        void showPhoto(String imageUrl) {
            Glide.with(context)
                    .load(imageUrl)
                    .into(photo);
        }
    }
}