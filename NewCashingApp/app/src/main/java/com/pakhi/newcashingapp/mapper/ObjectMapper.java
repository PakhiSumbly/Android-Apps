package com.pakhi.newcashingapp.mapper;


import com.pakhi.newcashingapp.entity.PictureItemEntity;
import com.pakhi.newcashingapp.model.PictureItem;


import java.util.List;

public interface ObjectMapper<T,Model> {   //T is data transfer object
    Model toModel(T  object);
    T fromModel(Model object);

    // PictureItemEntity fromModel(PictureItem object);

    List<T> fromModel(List<Model> object);
    List<PictureItem> toModel(List<T>object);

}
