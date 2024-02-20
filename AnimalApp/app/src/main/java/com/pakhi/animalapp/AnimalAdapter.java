package com.pakhi.animalapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

///import org.jetbrains.annotations.NonNls;
///import org.w3c.dom.Text;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalRowHolder> {

        ArrayList<Animal> animalData;
        Context context;
        MyClickInterface myClickInterface;

        public AnimalAdapter(ArrayList<Animal> animalData, Context context, MyClickInterface myClickInterface)
        {
            this.context=context;
            this.animalData=animalData;
            this.myClickInterface = myClickInterface;
        }

    @NonNull
    @Override
    public AnimalRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.animal_row, parent, false);
               return new AnimalRowHolder(view);
        //return null;
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalRowHolder holder, int position) {
        holder.animalName.setText(animalData.get(position).getImage()); //txtAnimalName
        holder.animalImage.setImageResource(animalData.get(position).getImage());  //imgAnimal
        holder.animalName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myClickInterface.onItemClick(holder.getAdapterPosition(), animalData);
            }
        });
    }

    @Override
    public int getItemCount() {
            return animalData.size();
    }

     static class AnimalRowHolder extends RecyclerView.ViewHolder {

        TextView animalName;
        ImageView animalImage;
        public AnimalRowHolder(@NonNull View itemView) {
            super(itemView);

            animalName=itemView.findViewById(R.id.txt_animal_name);
            animalImage=itemView.findViewById(R.id.img_animal);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    myClickInterface.onItemClick(getAdapterPosition());
//                }
//            }

        }
    }

    interface MyClickInterface{
            void onItemClick(int positionOfTheAnimal, ArrayList<Animal> animals);
    }

}
