package com.pakhi.newcashingapp;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.pakhi.newcashingapp.model.PictureItem;

import java.util.ArrayList;
import java.util.List;

public class PictureItemsAdapter extends RecyclerView.Adapter<PictureItemsAdapter.PictureViewHolder> {

    private List<PictureItem> data = new ArrayList<>();
    @NonNull
    @Override
    public PictureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.picture_item_layout, parent, false);
        return new PictureViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull PictureViewHolder holder, int position) {
        holder.txtTitle.setText(data.get(position).getAuthor());
        Glide.with(holder.itemView.getContext()).load(data.get(position).getImageUrl()).into(holder.imgPicture);

    }

        @Override
        public int getItemCount () {
            return data.size();
        }

        @SuppressLint("NotifyDataSetChanged")
        public void setData (List <PictureItem> data) {
            this.data = data;
            notifyDataSetChanged();
        }

        static class PictureViewHolder extends RecyclerView.ViewHolder {
            TextView txtTitle;
            ImageView imgPicture;

            public PictureViewHolder(@NonNull View itemView) {
                super(itemView);
                txtTitle = itemView.findViewById(R.id.txt_title);
                imgPicture = itemView.findViewById(R.id.img_picture);
            }
        }

}
