package com.pakhi.newcashingapp.repositories;

//import androidx.room.Database;

import com.pakhi.newcashingapp.AsyncTaskReceiver;
import com.pakhi.newcashingapp.ExecutorSupplier;
import com.pakhi.newcashingapp.dto.PictureItemDTO;
import com.pakhi.newcashingapp.entity.PictureItemEntity;
import com.pakhi.newcashingapp.mapper.PictureItemDTOMapper;
import com.pakhi.newcashingapp.mapper.PictureItemEntityMapper;
import com.pakhi.newcashingapp.model.PictureItem;
import com.pakhi.newcashingapp.remote_server.RemoteDataAccess;
import com.pakhi.newcashingapp.room.Database;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PicturesItemsRepository {
    private Database localStorage;
    private RemoteDataAccess remote;
    private PictureItemEntityMapper entityMapper;
    private PictureItemDTOMapper dtoMapper;

    public PicturesItemsRepository(Database localStorage, RemoteDataAccess remote, PictureItemEntityMapper entityMapper,PictureItemDTOMapper dtoMapper) {
        this.localStorage = localStorage;
        this.remote = remote;
        this.entityMapper = entityMapper;
        this.dtoMapper = dtoMapper;
    }

    public void getPictureItems(AsyncTaskReceiver<List<PictureItem>> callback){
        ExecutorSupplier.getInstance().execute(() -> {
            List<PictureItemEntity> localItems = localStorage.getDAO().getAllPictureItems();
            callback.onSuccess(entityMapper.toModel(localItems));

        });

        Call<List<PictureItemDTO>> call=remote.getPicturesItemDAO().getPictureItems();
        call.enqueue(new Callback<List<PictureItemDTO>>() {
            @Override
            public void onResponse(Call<List<PictureItemDTO>> call, Response<List<PictureItemDTO>> response) {

                if(response.body()!=null && !response.body().isEmpty()) {
                    List<PictureItem> items = dtoMapper.toModel(response.body());
                    callback.onSuccess(items);
                    ExecutorSupplier.getInstance().execute(() -> localStorage.getDAO().saveAllPictureItems(entityMapper.fromModel(items)));
                }
            }

            @Override
            public void onFailure(Call<List<PictureItemDTO>> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }
}