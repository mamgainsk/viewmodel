package com.org.viewmodeldemo.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.org.viewmodeldemo.R;


public class InfoListViewHolder extends RecyclerView.ViewHolder {

    ImageView image;
    TextView rowTitle, rowDescription;

    public InfoListViewHolder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.row_image);
        rowTitle = itemView.findViewById(R.id.row_title);
        rowDescription = itemView.findViewById(R.id.row_description);
    }
}
