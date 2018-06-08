package com.vijay.githubrepolist.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.vijay.githubrepolist.adapter.ItemAdapter;
import com.vijay.githubrepolist.R;
import com.vijay.githubrepolist.model.SearchResponse;
import com.vijay.githubrepolist.model.Repository;
import com.vijay.githubrepolist.webservice.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TextView disconnected;
    private EditText search_edt;
    private ImageView search_iv;
    private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        search_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!search_edt.getText().toString().isEmpty()) {
                    loadJSON(search_edt.getText().toString());
                    pd = new ProgressDialog(MainActivity.this);
                    pd.setMessage("Fetching Repo List...");
                    pd.setCancelable(false);
                    pd.show();
                    recyclerView = findViewById(R.id.recyclerView);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    recyclerView.smoothScrollToPosition(0);
                } else {
                    Toast.makeText(MainActivity.this, "field cannot be empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initViews() {
        search_edt = findViewById(R.id.search_edt);
        search_iv = findViewById(R.id.search_iv);
        disconnected = findViewById(R.id.disconnected);
    }

    private void loadJSON(String query) {

        try {
            ApiInterface apiService =
                    com.vijay.githubrepolist.webservice.Client.getClient().create(ApiInterface.class);
            Call<SearchResponse> call = apiService.getRepositories(query);
            call.enqueue(new Callback<SearchResponse>() {
                @Override
                public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                    List<Repository> items = response.body().getItems();
                    recyclerView.setAdapter(new ItemAdapter(getApplicationContext(), items));
                    recyclerView.smoothScrollToPosition(0);
                    pd.hide();
                    disconnected.setVisibility(View.GONE);
                }

                @Override
                public void onFailure(Call<SearchResponse> call, Throwable t) {
                    Log.d("Error", t.getMessage());
                    disconnected.setVisibility(View.VISIBLE);
                    pd.hide();

                }
            });

        } catch (Exception e) {
            Log.d("Error", e.getMessage());
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
