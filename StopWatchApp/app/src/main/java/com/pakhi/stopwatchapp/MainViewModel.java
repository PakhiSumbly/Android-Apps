package com.pakhi.stopwatchapp;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Timer;
import java.util.TimerTask;

public class MainViewModel extends ViewModel {

    private MutableLiveData<String> timeData = new MutableLiveData<>();
    private int elapsedTime =0 ;

    private Timer timer;

    public LiveData<String>getTimeData()
    {
        return timeData;
    }

    public void startStopwatch()
    {
        if(timer!=null)
        {
            timer.cancel();
        }
        timer = new Timer();
//        timer.purge();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                elapsedTime++;
                timeData.postValue(String.valueOf(elapsedTime));
            }

        },1000,1000);
    }


    protected void onCleared()
    {
        super.onCleared();
        timer.cancel();
    }
    

}
