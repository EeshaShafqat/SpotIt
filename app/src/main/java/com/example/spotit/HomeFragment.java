package com.example.spotit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spotit.YourItems;
import com.example.spotit.YourItemsAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView rv;
    private RecyclerView rv2;
    private RecyclerView rv3;
    private MyAdapter adapter;
    private YourItemsAdapter adapter2;
    private RecentSearchesAdapter adapter3;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Initialize RecyclerView 1
        rv = view.findViewById(R.id.rv); // Replace with the actual RecyclerView ID in fragment_home.xml

        List<FeaturedItems> ls = new ArrayList<>();
        ls.add(new FeaturedItems("book", "$10/hr", "Islamabad", "7th Mar"));
        ls.add(new FeaturedItems("book", "$10/hr", "Islamabad", "7th Mar"));
        ls.add(new FeaturedItems("book", "$10/hr", "Islamabad", "7th Mar"));
        ls.add(new FeaturedItems("book", "$10/hr", "Islamabad", "7th Mar"));
        ls.add(new FeaturedItems("book", "$10/hr", "Islamabad", "7th Mar"));

        adapter = new MyAdapter(requireContext(), ls);

        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(adapter);

        // Initialize RecyclerView 2
        rv2 = view.findViewById(R.id.rv2); // Replace with the actual RecyclerView ID in fragment_home.xml

        List<YourItems> ls2 = new ArrayList<>();
        ls2.add(new YourItems("book", "$10/hr", "395", "7th Mar"));
        ls2.add(new YourItems("mug", "$10/hr", "10", "9th Mar"));
        ls2.add(new YourItems("crockery", "$10/hr", "500", "12th Mar"));
        ls2.add(new YourItems("snacks", "$10/hr", "120", "18th Mar"));
        ls2.add(new YourItems("basket", "$10/hr", "150", "27th Mar"));

        adapter2 = new YourItemsAdapter(requireContext(), ls2);

        LinearLayoutManager layoutManager2 = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        rv2.setLayoutManager(layoutManager2);
        rv2.setAdapter(adapter2);

        // Initialize RecyclerView 3
        rv3 = view.findViewById(R.id.rv3); // Replace with the actual RecyclerView ID in fragment_home.xml

        List<FeaturedItems> recentSearches = new ArrayList<>();
        recentSearches.add(new FeaturedItems("book", "$10/hr", "Islamabad", "7th Mar"));
        recentSearches.add(new FeaturedItems("book", "$10/hr", "Islamabad", "7th Mar"));
        recentSearches.add(new FeaturedItems("book", "$10/hr", "Islamabad", "7th Mar"));
        recentSearches.add(new FeaturedItems("book", "$10/hr", "Islamabad", "7th Mar"));

        adapter3 = new RecentSearchesAdapter(requireContext(), recentSearches);

        LinearLayoutManager layoutManager3 = new GridLayoutManager(requireContext(), 2);;
        rv3.setLayoutManager(layoutManager3);
        rv3.setAdapter(adapter3);

        return view;
    }
}