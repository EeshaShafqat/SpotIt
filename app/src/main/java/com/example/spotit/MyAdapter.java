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

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    static Context context;
    static List<FeaturedItems> ls;
    public MyAdapter(Context context, List<FeaturedItems> ls) {
        this.context = context;
        this.ls = ls;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(context).inflate(R.layout.single_card,parent,false);
        return new ViewHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.item_name.setText(ls.get(position).getItem_name());
        holder.item_location.setText(ls.get(position).getCity());
        holder.item_date.setText(ls.get(position).getDate());
        holder.item_price.setText(ls.get(position).getPrice());

        @Override public void getView(int position, View convertView, ViewGroup parent) {
            SquaredImageView view = (SquaredImageView) convertView;
            if (view == null) {
                view = new SquaredImageView(context);
            }
            String url = getItem(position);

            Picasso.get().load(url).into(view);
        }

        Picasso.get()
                .load(url)
                .resize(50, 50)
                .centerCrop()
                .into(imageView)


        public class CropSquareTransformation implements Transformation {
            @Override public Bitmap transform(Bitmap source) {
                int size = Math.min(source.getWidth(), source.getHeight());
                int x = (source.getWidth() - size) / 2;
                int y = (source.getHeight() - size) / 2;
                Bitmap result = Bitmap.createBitmap(source, x, y, size, size);
                if (result != source) {
                    source.recycle();
                }
                return result;
            }

            @Override public String key() { return "square()"; }
        }


    }

    @Override
    public int getItemCount() {
        return ls.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {

        TextView item_name, item_price, item_location, item_date;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            item_name = itemView.findViewById(R.id.item_name);
            item_price = itemView.findViewById(R.id.price);
            item_location = itemView.findViewById(R.id.location_text);
            item_date = itemView.findViewById(R.id.date);
        }

        @Override
        public void onClick(View v) {


            int position = this.getAdapterPosition();
            String name = ls.get(position).getItem_name();
            String City = ls.get(position).getCity();
            String Date = ls.get(position).getDate();
            String Price = ls.get(position).getPrice();

            Intent intent = new Intent(context, RentIt.class);
            //intent.putExtra("name",name);

            context.startActivity(intent);

        }
    }


}
