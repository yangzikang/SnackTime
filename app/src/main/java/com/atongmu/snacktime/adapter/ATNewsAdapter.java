package com.atongmu.snacktime.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.atongmu.snacktime.R;
import com.atongmu.snacktime.activity.ArticActivity;
import com.atongmu.snacktime.model.KnowModel;
import com.bumptech.glide.Glide;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ATNewsAdapter extends RecyclerView.Adapter<ATNewsAdapter.ATViewHolder> {

    private List<KnowModel>  newses;
    Context mContext;
    public ATNewsAdapter(List newses, Context context){
        this.newses = newses;
        this.mContext = context;
    }

    public ATNewsAdapter.ATViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);
        ATNewsAdapter.ATViewHolder viewHolder = new ATNewsAdapter.ATViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ATViewHolder holder, int position) {
        KnowModel news = newses.get(position);
        holder.title.setText(news.getTitle());
        Glide.with(mContext).load(news.getImage()).placeholder(R.drawable.yes).error(R.drawable.no).into(holder.image);
    }

    @Override
    public int getItemCount()
        {
            return newses.size();
        }


    class ATViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.title) TextView title;
        @BindView(R.id.image)ImageView image;



        public ATViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getPosition();
                String url=newses.get(position).getArtic();//获取正文
                Intent intent = new Intent(mContext, ArticActivity.class);
                intent.putExtra("url",url);
                mContext.startActivity(intent);
                    Toast.makeText(mContext,String.valueOf(position),Toast.LENGTH_SHORT).show();
                }
            });

        }
    }


}