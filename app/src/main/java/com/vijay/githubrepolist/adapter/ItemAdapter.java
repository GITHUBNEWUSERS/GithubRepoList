package com.vijay.githubrepolist.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.vijay.githubrepolist.R;
import com.vijay.githubrepolist.activities.RepoDetailsActivity;
import com.vijay.githubrepolist.model.Repository;

import java.util.List;


public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private List<Repository> items;
    private Context context;

    public ItemAdapter(Context applicationContext, List<Repository> itemArrayList) {
        this.context = applicationContext;
        this.items = itemArrayList;
    }

    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_user, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemAdapter.ViewHolder viewHolder, int i) {
        viewHolder.title.setText("Repo Name : " + items.get(i).getName());
        viewHolder.username.setText("User Name : " + items.get(i).getOwner().getLogin());
        viewHolder.githublink.setText(items.get(i).getHtmlUrl());
        viewHolder.description.setText("Description : " + items.get(i).getDescription());
        viewHolder.forkcount.setText("Fork Count : " + items.get(i).getForkCount());

        Picasso.with(context)
                .load(items.get(i).getOwner().getAvatarUrl())
                .placeholder(R.drawable.load)
                .into(viewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title, githublink, description, forkcount, username;
        private ImageView imageView;


        public ViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.title);
            username = view.findViewById(R.id.username);
            description = view.findViewById(R.id.description);
            forkcount = view.findViewById(R.id.forkcount);
            githublink = view.findViewById(R.id.githublink);
            imageView = view.findViewById(R.id.cover);

            //on item click
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        Repository clickedDataItem = items.get(pos);
                        Intent intent = new Intent(context, RepoDetailsActivity.class);
                        intent.putExtra("full_name", items.get(pos).getFullName());
                        intent.putExtra("login", items.get(pos).getOwner().getLogin());
                        intent.putExtra("html_url", items.get(pos).getHtmlUrl());
                        intent.putExtra("subscribers_url", items.get(pos).getSubscribers_url());
                        intent.putExtra("avatar_url", items.get(pos).getOwner().getAvatarUrl());
                        context.startActivity(intent);
                        Toast.makeText(v.getContext(), "You clicked " + clickedDataItem.getOwner().getLogin(), Toast.LENGTH_SHORT).show();
                    }
                }

            });
        }
    }
}
