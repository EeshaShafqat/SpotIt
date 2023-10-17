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

public class YourItemsAdapter extends RecyclerView.Adapter<YourItemsAdapter.MyViewHolder> {

    Context context;
    List<YourItems> ls;

    public YourItemsAdapter(Context context, List<YourItems> ls) {
        this.context = context;
        this.ls = ls;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View row = LayoutInflater.from(context).inflate(R.layout.single_card2,parent,false);
        return new MyViewHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        holder.item_name.setText(ls.get(position).getItem_name());
        holder.item_view_count.setText(ls.get(position).getView_count());
        holder.item_date.setText(ls.get(position).getDate());
        holder.item_price.setText(ls.get(position).getPrice());

    }

    @Override
    public int getItemCount() {
        return ls.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView item_name, item_price, item_view_count, item_date;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);


            item_name = itemView.findViewById(R.id.item_name2);
            item_price = itemView.findViewById(R.id.price2);
            item_view_count = itemView.findViewById(R.id.view_count);
            item_date = itemView.findViewById(R.id.date2);
        }

        @Override
        public void onClick(View v) {

    //putExtra stuff


           // Intent intent = new Intent(context, RentIt.class);


            //context.startActivity(intent);


        }
    }
}
