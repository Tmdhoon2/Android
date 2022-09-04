package com.example.githubapisample.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.githubapisample.R;
import com.example.githubapisample.contract.OnItemClick;
import com.example.githubapisample.contract.UserAdapterContract;
import com.example.githubapisample.model.User;

import java.util.List;

// UserAdapterContract 상속
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> implements UserAdapterContract.View, UserAdapterContract.Model {

    private Context context;
    private OnItemClick onItemClick;
    private List<User> users;

    public UserAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);

        return new UserAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {
        User user = users.get(position);

        Glide.with(context)
                .load(user.getImage())
                .apply(new RequestOptions().circleCrop())
                .into(holder.imageView);

        holder.name.setText(user.getLogin());
        holder.location.setText(user.getLocation());
        holder.blog.setText(user.getBlog());
        holder.follower.setText(String.valueOf(user.getFollowers()));
        holder.following.setText(String.valueOf(user.getFollowing()));

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public void notifyAdapter() {
        notifyDataSetChanged();
    }

    @Override
    public void setOnClickListener(OnItemClick clickListener) {
        this.onItemClick = clickListener;
    }

    @Override
    public void setData(List<User> users) {
        this.users = users;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, location, blog, follower, following;
        ImageView imageView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.user_name);
            location = itemView.findViewById(R.id.user_location);
            blog = itemView.findViewById(R.id.user_blog);
            follower = itemView.findViewById(R.id.user_follower);
            following = itemView.findViewById(R.id.user_following);

            imageView = itemView.findViewById(R.id.user_image);

            itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {
                    onItemClick.onItemClick(getAdapterPosition());
                }
            });
        }
    }
}
