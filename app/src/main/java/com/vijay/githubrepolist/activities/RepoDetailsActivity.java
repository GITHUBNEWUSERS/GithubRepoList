package com.vijay.githubrepolist.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.vijay.githubrepolist.R;
import com.vijay.githubrepolist.adapter.SubscribersAdapter;
import com.vijay.githubrepolist.model.Subscribers;
import com.vijay.githubrepolist.webservice.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RepoDetailsActivity extends AppCompatActivity {
    TextView userName, subcount;
    ImageView imageView;
    private RecyclerView recyclerView;
    private ProgressDialog pd;
    String fullname;
    List<Subscribers> items;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Repo Details");
        imageView = findViewById(R.id.user_image_header);
        userName = findViewById(R.id.username);
        subcount = findViewById(R.id.subcount);
        String username = getIntent().getExtras().getString("login");
        String avatarUrl = getIntent().getExtras().getString("avatar_url");
        fullname = getIntent().getExtras().getString("full_name");
        userName.setText("User Name : "+username);
        init();
        Glide.with(this)
                .load(avatarUrl)
                .placeholder(R.drawable.load)
                .into(imageView);
    }

    void init() {
        pd = new ProgressDialog(RepoDetailsActivity.this);
        pd.setMessage("Fetching Subscribers List...");
        pd.setCancelable(false);
        pd.show();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.smoothScrollToPosition(0);
        loadJSON();
    }

    private void loadJSON() {

        try {
            ApiInterface apiService =
                    com.vijay.githubrepolist.webservice.Client.getClient().create(ApiInterface.class);
            Call<List<Subscribers>> call = apiService.getSubscribers("/repos/" + fullname + "/subscribers");
            call.request().url();
            call.enqueue(new Callback<List<Subscribers>>() {
                @Override
                public void onResponse(Call<List<Subscribers>> call, Response<List<Subscribers>> response) {
                    items = new ArrayList<>();
                    items = response.body();
                    subcount.setText("Subscribers Count : " + items.size());
                    recyclerView.setAdapter(new SubscribersAdapter(getApplicationContext(), items));
                    recyclerView.smoothScrollToPosition(0);
                    pd.hide();
                }

                @Override
                public void onFailure(Call<List<Subscribers>> call, Throwable t) {
                    Log.d("Error", t.getMessage());
                    pd.hide();

                }
            });

        } catch (Exception e) {
            Log.d("Error", e.getMessage());
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

}
