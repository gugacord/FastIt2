package com.delivery.fastit.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.delivery.fastit.Interface.ItemClickListener;
import com.delivery.fastit.R;

public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView item_name;
    public ImageView item_image;

    private ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);

        item_name = (TextView)itemView.findViewById(R.id.item_name);
        item_image = (ImageView)itemView.findViewById(R.id.item_image);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
            itemClickListener.onClick(view,getAdapterPosition(),false);
        }

}
