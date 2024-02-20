package com.pakhi.fragmentapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SearchFragment extends Fragment {

    private TextView txtSearch;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.search_layout,container,false);
        txtSearch = view.findViewById(R.id.txtSearch);
        
        txtSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Search Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("pakhi-test","Search fragment created");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("pakhi-test","Search fragment Paused");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("pakhi-test","Search fragment started");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("pakhi-test","Search fragment stopped");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("pakhi-test","Search fragment destroyed");
    }

}