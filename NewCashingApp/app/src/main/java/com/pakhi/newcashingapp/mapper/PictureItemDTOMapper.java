package com.pakhi.newcashingapp.mapper;


import com.pakhi.newcashingapp.dto.PictureItemDTO;

import com.pakhi.newcashingapp.model.PictureItem;

import java.util.List;
import java.util.stream.Collectors;

public class PictureItemDTOMapper implements ObjectMapper<PictureItemDTO, PictureItem> {

    private static final PictureItemDTOMapper instance = new PictureItemDTOMapper();

    private PictureItemDTOMapper(){

    }

    public static PictureItemDTOMapper getInstance(){
        return instance;
    }

    @Override
    public PictureItem toModel(PictureItemDTO object) {
        return new PictureItem(object.getId(),object.getAuthor(),object.getImageUrl());
    }

    @Override
    public PictureItemDTO fromModel(PictureItem object) {
        PictureItemDTO pictureitemDTO = new PictureItemDTO();
        pictureitemDTO.setId(object.getId());
        pictureitemDTO.setAuthor(object.getAuthor());
        pictureitemDTO.setImageUrl(object.getImageUrl());
        return pictureitemDTO;

    }


    @Override
    public List<PictureItemDTO> fromModel(List<PictureItem> object) {
        return object.stream().map(this::fromModel).collect(Collectors.toList());
    }

    @Override
    public List<PictureItem> toModel(List<PictureItemDTO> object) {
        return object.stream().map(this::toModel).collect(Collectors.toList());
    }
}
