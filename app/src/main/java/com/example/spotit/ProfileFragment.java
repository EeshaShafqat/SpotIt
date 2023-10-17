package com.example.spotit;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;


public class ProfileFragment extends Fragment {

    private RecyclerView rv;

    private RecyclerView rv3;
    private MyAdapter adapter;
    private RecentSearchesAdapter adapter3;

    ImageView logout;

   FirebaseAuth mAuth;
    ImageView edit;



    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }



    public void editProfile(View view){
        //Intent intent = new Intent(requireContext(), EditProfile.class );
        //startActivity(intent);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        //edit profile

        edit = view.findViewById(R.id.edit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(requireActivity(), EditProfile.class);
                startActivity(intent);
            }
        });


        //logout

        mAuth =  FireAuthSingleton.getInstance();

        logout = view.findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                try {
                    mAuth.signOut();

                    Intent intent = new Intent(requireActivity(), Login.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    requireActivity().finish();

                    // Add code to navigate to the login screen or perform other actions.
                } catch (Exception e) {
                    Log.e("SignOutError", "Error signing out: " + e.getMessage());
                }


            }
        });

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

        //initialize rv3

        rv3 = view.findViewById(R.id.rv3); // Replace with the actual RecyclerView ID in fragment_home.xml

        List<FeaturedItems> recentSearches = new ArrayList<>();
        recentSearches.add(new FeaturedItems("book", "$10/hr", "Islamabad", "7th Mar"));
        recentSearches.add(new FeaturedItems("book", "$10/hr", "Islamabad", "7th Mar"));
        recentSearches.add(new FeaturedItems("book", "$10/hr", "Islamabad", "7th Mar"));
        recentSearches.add(new FeaturedItems("book", "$10/hr", "Islamabad", "7th Mar"));

        adapter3 = new RecentSearchesAdapter(requireContext(), recentSearches);


        LinearLayoutManager layoutManager3 = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        rv3.setLayoutManager(layoutManager3);
        rv3.setAdapter(adapter3);

        return view;


    }
}