package com.kkk.campusposts.services;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by DonKamillo on 07.09.2016.
 */

public class SearchResponse {

    private List<Result> results;

    public class Result {
        @SerializedName("channel_name")
        private String channelName;
        @SerializedName("no_likes")
        private int noLikes;
        @SerializedName("no_comments")
        private int noComments;
        @SerializedName("content")
        private String content;
        @SerializedName("photo")
        private String photo;
        @SerializedName("author")
        private Author author;
        private Picture picture;

        public Result() {
        }

        public Picture getPicture() {
            return picture;
        }

        public String getPhoto() {
            return photo;
        }

        public String getContent() {
            return content;
        }

        public String getChannelName() {
            return channelName;
        }

        public int getNoLikes() {
            return noLikes;
        }

        public int getNoComments() {
            return noComments;
        }

        public Author getAuthor() {
            return author;
        }
    }

    public class Author {
        @SerializedName("full_name")
        private String fullName;
        @SerializedName("colour")
        private String colour;

        public String getFullName() {
            return fullName;
        }

        public String getColour() {
            return colour;
        }
    }

    public class Picture {
        private String small;

        public String getSmall() {
            return small;
        }
    }

    public List<Result> getResults() {
        return results;
    }
}
