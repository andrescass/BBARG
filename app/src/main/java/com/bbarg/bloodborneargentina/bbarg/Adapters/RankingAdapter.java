package com.bbarg.bloodborneargentina.bbarg.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bbarg.bloodborneargentina.bbarg.Models.hunters;
import com.bbarg.bloodborneargentina.bbarg.R;

import java.util.List;

public class RankingAdapter extends RecyclerView.Adapter<RankingAdapter.ViewHolder> {
    private List<hunters> hunts;
    private int layout;
    private Context mContext;

    public RankingAdapter(List<hunters> hunts, int layout) {
        this.hunts = hunts;
        this.layout = layout;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        mContext = parent.getContext();
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.Bind(hunts.get(position));
    }

    @Override
    public int getItemCount() {
        return hunts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView huntPos;
        TextView huntName;
        ImageView huntIcon;

        public ViewHolder(View itemView) {
            super(itemView);
            huntPos = itemView.findViewById(R.id.rank_item_pos);
            huntName = itemView.findViewById(R.id.rank_item_name);
            huntIcon = itemView.findViewById(R.id.rank_item_img);
        }

        public void Bind(final hunters hunt)
        {
            huntPos.setText(String.valueOf(hunt.getPosition()));
            huntName.setText(hunt.getName());
            if(hunt.getPosition() > hunt.getLastPos())
            {
                huntIcon.setImageResource(R.drawable.ic_rank_down);
            }
            else if(hunt.getPosition() < hunt.getLastPos())
            {
                huntIcon.setImageResource(R.drawable.ic_rank_up);
            }
            else
            {
                huntIcon.setImageResource(R.drawable.ic_rank_eq);
            }
        }
    }
}
