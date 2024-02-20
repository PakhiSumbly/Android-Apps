package com.pakhi.newcashingapp.room;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.pakhi.newcashingapp.entity.PictureItemEntity;

import java.util.List;



@Dao
public interface PicturesItemLocalDAO {
    @Insert(onConflict = REPLACE)
    void saveAllPictureItems(List<PictureItemEntity> images);


    @Query("SELECT * FROM picture_items")
    List<PictureItemEntity> getAllPictureItems();
}


