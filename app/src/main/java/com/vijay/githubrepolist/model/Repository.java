package com.vijay.githubrepolist.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Repository {

    @Expose
    Integer id;

    @Expose
    String name;

    @SerializedName("full_name")
    @Expose
    String fullName;

    @Expose
    User owner;

    @SerializedName("html_url")
    @Expose
    String htmlUrl;

    @SerializedName("subscribers_url")
    @Expose
    String subscribers_url;

    @Expose
    String description;

    @SerializedName("forks_count")
    @Expose
    Integer forkCount;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getForkCount() {
        return forkCount;
    }

    public void setForkCount(Integer forkCount) {
        this.forkCount = forkCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSubscribers_url() {
        return subscribers_url;
    }

    public void setSubscribers_url(String subscribers_url) {
        this.subscribers_url = subscribers_url;
    }

}
