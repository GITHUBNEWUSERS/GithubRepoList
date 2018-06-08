package com.vijay.githubrepolist.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vijay.githubrepolist.R;
import com.vijay.githubrepolist.model.Subscribers;

import java.util.List;

public class SubscribersAdapter extends RecyclerView.Adapter<SubscribersAdapter.ViewHolder> {
    private List<Subscribers> items;
    private Context context;

    public SubscribersAdapter(Context applicationContext, List<Subscribers> itemArrayList) {
        this.context = applicationContext;
        this.items = itemArrayList;
    }

    @Override
    public SubscribersAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_user, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.title.setText("Subscriber Name : " + items.get(i).getLogin());
        Picasso.with(context)
                .load(items.get(i).getAvatarUrl())
                .placeholder(R.drawable.load)
                .into(viewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private ImageView imageView;


        public ViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.title);
            imageView = view.findViewById(R.id.cover);
        }
    }
}

