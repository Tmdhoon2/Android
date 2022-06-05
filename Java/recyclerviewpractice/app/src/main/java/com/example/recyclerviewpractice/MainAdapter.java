package com.example.recyclerviewpractice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.CustomViewHolder> {

    private ArrayList<MainData> arrayList;                                                                          // MainData에서 만든 데이터를 배열로 받아옴
    public MainAdapter(MainActivity mainActivity, ArrayList<MainData> arrayList) {
        this.arrayList = arrayList;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {                                                 // list_item에서 만든 객체를 어댑터와 연결

        protected ImageView iv_profile;
        protected TextView tv_name;
        protected TextView tv_birth;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.iv_profile = (ImageView) itemView.findViewById(R.id.iv_profile);
            this.tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            this.tv_birth = (TextView) itemView.findViewById(R.id.tv_birth);
        }
    }

    @NonNull
    @Override
    public MainAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {              // ViewHolder를 만들때마다 호출 ViewHolder를 초기화 하는 메서드

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);  // list_item을 layouinflater를 이용하여 띄워줌
        CustomViewHolder holder = new CustomViewHolder(view);

        return holder;                                                                                             // 바로 위에서 만든 holder를 return 해준다
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.CustomViewHolder holder, int position) {                     // ViewHolder를 데이터와 연결할 때 호출

        holder.iv_profile.setImageResource(arrayList.get(position).getIv_profile());                               // iv_profile의 이미지를 배열에서 불러온다
        holder.tv_name.setText(arrayList.get(position).getTv_name());                                              // tv_name의 텍스트를 배열에서 불러온다
        holder.tv_birth.setText(arrayList.get(position).getTv_birth());                                            // tv_birth의 텍스트를 배열에서 불러온다

    }

    @Override
    public int getItemCount() {                                                                                    // 데이터 세트 크기를 가져올 때 호출
        return (null !=arrayList? arrayList.size() : 0);                                                           // 배열의 사이즈를 반환한다
    }

}
