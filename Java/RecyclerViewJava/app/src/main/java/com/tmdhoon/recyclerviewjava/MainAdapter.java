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

<<<<<<< HEAD
    private ArrayList<MainData> arrayList;                                                                              // Itemlist
    public MainAdapter(ArrayList<MainData> arrayList) {
        this.arrayList = arrayList;
=======
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
>>>>>>> main
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {                               // ViewHolder

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);

        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

<<<<<<< HEAD
        holder.iv_profile.setImageResource(arrayList.get(position).getIv_profile());
        holder.tv_name.setText(arrayList.get(position).getTv_name());

        holder.itemView.setTag(position);
         holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String curName = holder.tv_name.getText().toString();
                Toast.makeText(view.getContext(), curName, Toast.LENGTH_SHORT).show();
            }
        });
=======
        holder.tvContent.setText(list.get(position).getContent());
>>>>>>> main

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