package com.veryworks.android.serverconnection;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.veryworks.android.serverconnection.domain.Bbs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc on 6/30/2017.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.Holder>{
    // 1. 데이터 공간 정의
    List<Bbs> data = new ArrayList<>();

    // 2. 데이터를 세팅하는 함수 생성
    public void setData(List<Bbs> data){
        this.data = data;
    }

    // 3. 데이터의 크기를 아답터에 제공 > 아답터가 리스트의 크기를 결정
    @Override
    public int getItemCount() {
        return data.size();
    }

    // 4. 리스트의 크기만큼 ViewHolder의 개수가 생성
    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new Holder(view);
    }

    // 5. 화면에 리스트의 아이템이 그려질때마다 호출되는 함수
    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Bbs bbs = data.get(position);
        holder.textNo.setText(bbs.no + "");
        holder.textTitle.setText(bbs.title);
    }


    class Holder extends RecyclerView.ViewHolder{
        TextView textNo;
        TextView textTitle;
        public Holder(View itemView) {
            super(itemView);
            textNo = (TextView) itemView.findViewById(R.id.textNo);
            textTitle = (TextView) itemView.findViewById(R.id.textTitle);
        }
    }
}
