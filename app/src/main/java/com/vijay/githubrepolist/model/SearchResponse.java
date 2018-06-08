package com.vijay.githubrepolist.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class SearchResponse {
    @SerializedName("total_count")
    @Expose
    Integer totalCount;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Boolean getIncompleteResults() {
        return incompleteResults;
    }

    public void setIncompleteResults(Boolean incompleteResults) {
        this.incompleteResults = incompleteResults;
    }

    @SerializedName("incomplete_results")
    @Expose

    Boolean incompleteResults;
    @SerializedName("items")
    @Expose
    private List<Repository> items;

    public List<Repository> getItems() {
        return items;
    }

    public void setItems(List<Repository> items) {
        this.items = items;
    }
}
