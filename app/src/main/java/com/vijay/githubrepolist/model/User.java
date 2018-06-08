package com.vijay.githubrepolist.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;





public class User {
    @Expose
    String login;

    @Expose
    Integer id;

    @SerializedName("avatar_url")
    @Expose
    String avatarUrl;

    @Expose
    String url;

    @SerializedName("html_url")
    @Expose
    String htmlUrl;

    @SerializedName("followers_url")
    @Expose
    String followersUrl;

    @SerializedName("following_url")
    @Expose
    String followingUrl;

    @SerializedName("gists_url")
    @Expose
    String gistsUrl;

    @SerializedName("starred_url")
    @Expose
    String starredUrl;

    @SerializedName("subscriptions_url")
    @Expose
    String subscriptionsUrl;

    @SerializedName("organizations_url")
    @Expose
    String organizationsUrl;

    @SerializedName("repos_url")
    @Expose
    String reposUrl;

    @SerializedName("events_url")
    @Expose
    String eventsUrl;

    @SerializedName("received_events_url")
    @Expose
    String receivedEventsUrl;

    @Expose
    String type;

    @SerializedName("site_admin")
    @Expose
    Boolean siteAdmin;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }



    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

}
