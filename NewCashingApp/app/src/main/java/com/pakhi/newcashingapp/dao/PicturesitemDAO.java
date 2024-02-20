package com.pakhi.newcashingapp.dao;

import com.pakhi.newcashingapp.dto.PictureItemDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PicturesitemDAO {
    @GET("list")
    Call<List<PictureItemDTO>> getPictureItems();
}
