package com.vijay.githubrepolist.webservice;

import com.vijay.githubrepolist.model.SearchResponse;
import com.vijay.githubrepolist.model.Subscribers;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface ApiInterface {
    @GET("/search/repositories")
    Call<SearchResponse> getRepositories(
            @Query(value = "q") String query
    );

    @GET
    public Call<List<Subscribers>> getSubscribers(@Url String url);

}
