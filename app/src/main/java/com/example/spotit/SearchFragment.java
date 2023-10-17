package com.example.spotit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class SearchFragment extends Fragment {

    private RecyclerView recent;
    private RecyclerView popular;

    private SearchAdapter adapter;




    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        // Initialize RecyclerView 1
        recent = view.findViewById(R.id.recent); // Replace with the actual RecyclerView ID in fragment_home.xml

        List<String> ls = new ArrayList<>();
        ls.add(new String("Item Number One"));
        ls.add(new String("Item Number Two"));
        ls.add(new String("Item Number Three"));


        adapter = new SearchAdapter(requireContext(), ls);

        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        recent.setLayoutManager(layoutManager);
        recent.setAdapter(adapter);


        //popular searches
        popular = view.findViewById(R.id.popular); // Replace with the actual RecyclerView ID in fragment_home.xml

        List<String> ls2 = new ArrayList<>();
        ls2.add(new String("Item Number One"));
        ls2.add(new String("Item Number Two"));
        ls2.add(new String("Item Number Three"));
        ls2.add(new String("Item Number Four"));



        adapter = new SearchAdapter(requireContext(), ls2);

        LinearLayoutManager layoutManager2 = new LinearLayoutManager(requireContext());
        popular.setLayoutManager(layoutManager2);
        popular.setAdapter(adapter);


        return view;


    }
}