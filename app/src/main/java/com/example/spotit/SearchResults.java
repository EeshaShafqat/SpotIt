package com.example.spotit;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SearchResults extends AppCompatActivity {

    List<FeaturedItems> ls;

    RecentSearchesAdapter adapter;

    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        rv = findViewById(R.id.rv_search);


        List<FeaturedItems> ls = new ArrayList<>();
        ls.add(new FeaturedItems("book", "$10/hr", "Islamabad", "7th Mar"));
        ls.add(new FeaturedItems("book", "$10/hr", "Islamabad", "7th Mar"));
        ls.add(new FeaturedItems("book", "$10/hr", "Islamabad", "7th Mar"));
        ls.add(new FeaturedItems("book", "$10/hr", "Islamabad", "7th Mar"));
        ls.add(new FeaturedItems("book", "$10/hr", "Islamabad", "7th Mar"));
        ls.add(new FeaturedItems("book", "$10/hr", "Islamabad", "7th Mar"));
        ls.add(new FeaturedItems("book", "$10/hr", "Islamabad", "7th Mar"));
        ls.add(new FeaturedItems("book", "$10/hr", "Islamabad", "7th Mar"));



        adapter = new RecentSearchesAdapter(SearchResults.this,ls);


        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(SearchResults.this, 2);

        rv.setLayoutManager(layoutManager);
        rv.setAdapter(adapter);





    }
}