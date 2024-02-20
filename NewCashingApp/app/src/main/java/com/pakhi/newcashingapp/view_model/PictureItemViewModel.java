package com.pakhi.newcashingapp.view_model;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.pakhi.newcashingapp.AsyncTaskReceiver;
import com.pakhi.newcashingapp.mapper.PictureItemDTOMapper;
import com.pakhi.newcashingapp.mapper.PictureItemEntityMapper;
import com.pakhi.newcashingapp.model.PictureItem;
import com.pakhi.newcashingapp.remote_server.RemoteDataAccess;
import com.pakhi.newcashingapp.repositories.PicturesItemsRepository;
import com.pakhi.newcashingapp.room.Database;

import java.util.List;

public class PictureItemViewModel extends AndroidViewModel {

    private PicturesItemsRepository repository;
    public PictureItemViewModel(@NonNull Application application)
    {
        super(application);
        repository=new PicturesItemsRepository(Database.getInstance(application), RemoteDataAccess.getInstance(), PictureItemEntityMapper.getInstance(), PictureItemDTOMapper.getInstance());
    }
    private MutableLiveData<List<PictureItem>> itemsLiveData = new MutableLiveData();

    public LiveData<List<PictureItem>> getPicturesLiveData(){
        return itemsLiveData;
    }

    public void requestPictureItems(){
        repository.getPictureItems(new AsyncTaskReceiver<List<PictureItem>>() {
            @Override
            public void onSuccess(List<PictureItem> result) {
                itemsLiveData.postValue(result);
            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.d("pakhi-test","throwable");

            }
        });

    }


}
