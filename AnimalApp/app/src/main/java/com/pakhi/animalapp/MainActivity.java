package com.pakhi.animalapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AnimalAdapter.MyClickInterface {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

        ArrayList<Animal> animals = new ArrayList<>();

        animals.add(new Animal("butterfly", R.drawable.butterfly));
        animals.add(new Animal("deer", R.drawable.deer));
        animals.add(new Animal("dog", R.drawable.dog));
        animals.add(new Animal("swan", R.drawable.swan));
        animals.add(new Animal("rabbit", R.drawable.rabbit));
        animals.add(new Animal("leopard", R.drawable.leopard));
        animals.add(new Animal("lion", R.drawable.lion));
        animals.add(new Animal("tortoise", R.drawable.tortoise));

        AnimalAdapter animalAdapter = new AnimalAdapter(animals, this, this );

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(animalAdapter);

    }

    @Override
    public void onItemClick(int positionOfTheAnimal, ArrayList<Animal> animals) {
        Toast.makeText(this, "Clicked"+animals.get(positionOfTheAnimal).getName(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,AnimalInfo.class);
        intent.putExtra("image",animals.get(positionOfTheAnimal).getImage());
        intent.putExtra("name",animals.get(positionOfTheAnimal).getName());
        startActivity(intent);
    }
}