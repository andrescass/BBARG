package com.bbarg.bloodborneargentina.bbarg.Adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bbarg.bloodborneargentina.bbarg.App.BbargApp;
import com.bbarg.bloodborneargentina.bbarg.Models.LoreModel;
import com.bbarg.bloodborneargentina.bbarg.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.io.File;
import java.util.List;

public class LoreRecyclerAdapter extends RecyclerView.Adapter<LoreRecyclerAdapter.ViewHolder>{
    private List<LoreModel> lores;
    private int layout;
    private OnItemClickListener itemClickListener;
    private Context mContext;

    public LoreRecyclerAdapter(List<LoreModel> lores, int layout, OnItemClickListener itemClickListener) {
        this.lores = lores;
        this.layout = layout;
        this.itemClickListener = itemClickListener;
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
        holder.Bind(lores.get(position), itemClickListener);
    }

    @Override
    public int getItemCount() {
        return lores.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView loreItemImage;
        TextView loreItemTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            loreItemImage = itemView.findViewById(R.id.lore_image);
            loreItemTitle = itemView.findViewById(R.id.lore_item_title);
        }

        public void Bind(final LoreModel lore, final OnItemClickListener listener)
        {
            loreItemImage.setImageResource(lore.getImageRes());
            loreItemTitle.setText(lore.getTitle());

            final BitmapFactory.Options opt = new BitmapFactory.Options();
            opt.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(("android.resource://com.bbarg.bloodborneargentina./" + String.valueOf(lore.getImageRes())), opt);
            int imageWidth = opt.outWidth;
            int imageHeight = opt.outHeight;

            //int finalHeight = Math.round((float) width/imageWidth*imageHeight);
            loreItemImage.getLayoutParams().height = BbargApp.finalHeight;
            if(lore.getImageUri() != null) {
                File image = new File(lore.getImageUri());
                Picasso.with(mContext).load(image).centerCrop().into(loreItemImage);
            }

            //loreItemTitle.setOnClickListener(new View.OnClickListener() {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(lore, getAdapterPosition());
                    /*if(loreItemBody.getVisibility() == View.GONE)
                    {
                        loreItemBody.setVisibility(View.VISIBLE);
                    }
                    else
                    {
                        loreItemBody.setVisibility(View.GONE);
                    }*/

                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(LoreModel lore, int position);
    }
}
