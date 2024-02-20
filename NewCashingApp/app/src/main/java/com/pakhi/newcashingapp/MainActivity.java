package com.pakhi.newcashingapp;

import androidx.appcompat.app.AppCompatActivity;
//import androidx.lifecycle.Observer;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
//import android.os.Handler;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.facebook.shimmer.ShimmerFrameLayout;

//import com.pakhi.newcashingapp.model.PictureItem;
import com.pakhi.newcashingapp.model.PictureItem;
import com.pakhi.newcashingapp.view_model.PictureItemViewModel;

import java.util.List;

//import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PictureItemViewModel pictureItemViewModel;
    private PictureItemsAdapter adapter;
    private RecyclerView recyclerView;
    private Button btnLoad;
    private ShimmerFrameLayout shimmer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pictureItemViewModel = new ViewModelProvider(this).get(PictureItemViewModel.class);

        recyclerView = findViewById(R.id.recycler_images);
        btnLoad = findViewById(R.id.btn_load);
        shimmer = findViewById(R.id.shimmer);

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shimmer.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pictureItemViewModel.requestPictureItems();
                    }
                },3000);
                //pictureItemViewModel.requestPictureItems();
            }
        });


        adapter = new PictureItemsAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        pictureItemViewModel.getPicturesLiveData().observe(this, new Observer<List<PictureItem>>() {
            @Override
            public void onChanged(List<PictureItem> pictureItems) {
                Log.d("maid-test", pictureItems.toString() + "got it in main activity");
                adapter.setData(pictureItems);
                shimmer.setVisibility(View.GONE);
            }
        });

        pictureItemViewModel.requestPictureItems();

    }
}




      /*  shimmer = findViewById(R.id.shimmer);

        btnLoad.setOnClickListener(v -> {
            shimmer.setVisibility(View.VISIBLE);
            new Handler().postDelayed(() -> pictureItemViewModel.requestPictureItems(),3000);

    });

        adapter = new PictureItemsAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));



        pictureItemViewModel.getPicturesLiveData().observe(this, pictureItems -> {
            Log.d("pakhi-test",pictureItems.toString()+" got it in the main activity");
            adapter.setData(pictureItems);
            shimmer.setVisibility(View.GONE);

        });
        pictureItemViewModel.requestPictureItems();
    }
} */



//        Call<List<PictureitemDTO>>call=RemoteDataAccess.getInstance().getPicturesItemDAO().getPictureItems();
//        call.enqueue(new Callback<List<PictureitemDTO>>() {
//            @Override
//            public void onResponse(Call<List<PictureitemDTO>> call, Response<List<PictureitemDTO>> response) {
//                Log.d("pakhi-test",response.body().toString());
//            }
//
//            @Override
//            public void onFailure(Call<List<PictureitemDTO>> call, Throwable t) {
//                Log.d("pakhi-test",t.toString());
//
//            }
//        });