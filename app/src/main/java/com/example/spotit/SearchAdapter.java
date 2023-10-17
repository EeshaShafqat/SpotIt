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

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    static Context context;
    static List<String> ls;
    public SearchAdapter(Context context, List<String> ls) {
        this.context = context;
        this.ls = ls;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(context).inflate(R.layout.one_search_result,parent,false);
        return new ViewHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.search.setText(ls.get(position));





    }

    @Override
    public int getItemCount() {
        return ls.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView search;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            search = itemView.findViewById(R.id.search);

        }

        @Override
        public void onClick(View v) {

            int position = this.getAdapterPosition();
            String result = ls.get(position);




            Intent intent = new Intent(context, SearchResults.class);
            //intent.putExtra("result",result);

            context.startActivity(intent);


        }
    }




}
