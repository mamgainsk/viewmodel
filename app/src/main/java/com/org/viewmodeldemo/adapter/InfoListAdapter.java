package com.org.viewmodeldemo.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.org.viewmodeldemo.R;
import com.org.viewmodeldemo.request_pojo.RowDescription;
import com.squareup.picasso.Picasso;

import java.util.List;

public class InfoListAdapter extends RecyclerView.Adapter<InfoListViewHolder> {

    Context context;
    List<RowDescription> rowDescriptions;

    public InfoListAdapter(Context context, List<RowDescription> rowDescriptions) {
        this.context = context;
        this.rowDescriptions = rowDescriptions;
    }


    @NonNull
    @Override
    public InfoListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.info_list_item_layout, parent, false);
        InfoListViewHolder infoListViewHolder = new InfoListViewHolder(view);
        return infoListViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull InfoListViewHolder holder, int position) {
        holder.rowTitle.setText(rowDescriptions.get(position).getTitle());
        holder.rowDescription.setText(rowDescriptions.get(position).getDescription());

        Picasso.get()
                .load(rowDescriptions.get(position).getImageHref())
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        if (rowDescriptions == null) return 0;
        return rowDescriptions.size();
    }
}
