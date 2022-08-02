package com.tmdhoon.recyclerviewjava;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tmdhoon.recyclerviewjava.databinding.ListItemBinding;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.CustomViewHolder>{

    private List<MainData> list;

    public MainAdapter(List<MainData> list) {
        this.list = list;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

       public TextView tvContent;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            tvContent = itemView.findViewById(R.id.tvContent);
        }
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {                               // ViewHolder

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);

        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

        holder.tvContent.setText(list.get(position).getContent());

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View view) {
                list.remove(position);
                notifyItemRemoved(position);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}