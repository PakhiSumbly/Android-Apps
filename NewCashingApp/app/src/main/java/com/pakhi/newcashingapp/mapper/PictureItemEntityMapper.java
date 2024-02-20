package com.pakhi.newcashingapp.mapper;

import com.pakhi.newcashingapp.entity.PictureItemEntity;
import com.pakhi.newcashingapp.model.PictureItem;

import java.util.List;
import java.util.stream.Collectors;

public class PictureItemEntityMapper implements ObjectMapper<PictureItemEntity, PictureItem> {

    private static final PictureItemEntityMapper instance = new PictureItemEntityMapper();

    private PictureItemEntityMapper(){

    }

    public static PictureItemEntityMapper getInstance() {
        return instance;
    }

    public PictureItem toModel(PictureItemEntity object)
    {
        return new PictureItem(object.getId(),object.getAuthor(),object.getImageUrl());
    }


    @Override
    public PictureItemEntity fromModel(PictureItem object) {
        return new PictureItemEntity(object.getId(),object.getAuthor(),object.getImageUrl());
    }

    @Override
    public List<PictureItemEntity> fromModel(List<PictureItem> object) {
        return object.stream().map(this::fromModel).collect(Collectors.toList());
    }

    @Override
    public List<PictureItem> toModel(List<PictureItemEntity> object) {
        return object.stream().map(this::toModel).collect(Collectors.toList());
    }

}
