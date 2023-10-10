package com.example.spotit;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecentSearchesAdapter extends RecyclerView.Adapter<RecentSearchesAdapter.ViewHolder> {

    static Context context;
    List<FeaturedItems> ls;
    public RecentSearchesAdapter(Context context, List<FeaturedItems> ls) {
        this.context = context;
        this.ls = ls;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(context).inflate(R.layout.card_smaller,parent,false);
        return new ViewHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.item_name.setText(ls.get(position).getItem_name());
        holder.item_location.setText(ls.get(position).getCity());
        holder.item_date.setText(ls.get(position).getDate());
        holder.item_price.setText(ls.get(position).getPrice());


    }

    @Override
    public int getItemCount() {
        return ls.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView item_name, item_price, item_location, item_date;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            item_name = itemView.findViewById(R.id.item_name);
            item_price = itemView.findViewById(R.id.price);
            item_location = itemView.findViewById(R.id.location_text);
            item_date = itemView.findViewById(R.id.date);
        }

        @Override
        public void onClick(View v) {


            //Intent intent = new Intent(context, RentIt.class);


            //context.startActivity(intent);

        }
    }


}
