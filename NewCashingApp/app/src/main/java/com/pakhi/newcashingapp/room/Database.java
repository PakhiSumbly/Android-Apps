package com.pakhi.newcashingapp.room;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.pakhi.newcashingapp.entity.PictureItemEntity;

@androidx.room.Database(entities = {PictureItemEntity.class}, version = 1)
public abstract class Database extends RoomDatabase {

    private static Database instance;

    public abstract PicturesItemLocalDAO getDAO();


    public synchronized static Database getInstance(Context context)
    {
        if(instance == null) {
            instance = Room.databaseBuilder(context, Database.class, "picture_items_databases").build();
        }
        return instance;
    }
}
