package com.example.projectteam.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectteam.R;
import com.example.projectteam.model.FilterModel;


public class FilterAdapter extends RecyclerView.Adapter<FilterAdapter.FilterHolder>{

    private FilterModel[] listdata;
    OnClickInterface onClickInterface;
    public FilterAdapter(FilterModel[] listdata,OnClickInterface onClickInterface) {
        this.listdata = listdata;
        this.onClickInterface=onClickInterface;
    }

    @NonNull
    @Override
    public FilterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.filter_item, parent, false);
        FilterHolder viewHolder = new FilterHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FilterAdapter.FilterHolder holder, @SuppressLint("RecyclerView") int position) {
        final FilterModel filterModel = listdata[position];
        holder.textView.setText(filterModel.getTeam());
        holder.imageView.setImageResource(filterModel.getImgId());
        holder.filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickInterface.setClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listdata.length;
    }

    class FilterHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView textView;
        public ConstraintLayout filter;

        public FilterHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.ivCard);
            this.textView = (TextView) itemView.findViewById(R.id.tvFilter);
            this.filter=(ConstraintLayout) itemView.findViewById(R.id.filter);
        }
    }
}
