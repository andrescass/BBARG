package com.bbarg.bloodborneargentina.bbarg.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bbarg.bloodborneargentina.bbarg.Models.LoreModel;
import com.bbarg.bloodborneargentina.bbarg.R;

import org.w3c.dom.Text;

import java.util.List;

public class LoreRecyclerAdapter extends RecyclerView.Adapter<LoreRecyclerAdapter.ViewHolder>{
    private List<LoreModel> lores;
    private int layout;
    private Context mContext;

    public LoreRecyclerAdapter(List<LoreModel> lores, int layout) {
        this.lores = lores;
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
        holder.Bind(lores.get(position));
    }

    @Override
    public int getItemCount() {
        return lores.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView loreItemImage;
        TextView loreItemTitle;
        TextView loreItemBody;

        public ViewHolder(View itemView) {
            super(itemView);
            loreItemImage = itemView.findViewById(R.id.lore_image);
            loreItemTitle = itemView.findViewById(R.id.lore_item_title);
            loreItemBody = itemView.findViewById(R.id.lore_item_body);
        }

        public void Bind(final LoreModel lore)
        {
            loreItemImage.setImageResource(lore.getImageRes());
            loreItemTitle.setText(lore.getTitle());
            loreItemBody.setText(lore.getLoreBody());

            loreItemTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(loreItemBody.getVisibility() == View.GONE)
                    {
                        loreItemBody.setVisibility(View.VISIBLE);
                    }
                    else
                    {
                        loreItemBody.setVisibility(View.GONE);
                    }
                }
            });
        }
    }
}
