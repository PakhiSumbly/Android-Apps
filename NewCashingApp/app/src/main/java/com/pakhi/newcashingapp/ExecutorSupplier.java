package com.pakhi.newcashingapp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorSupplier {
    public static final ExecutorService instance = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    private ExecutorSupplier(){

    }
    public static ExecutorService getInstance(){
        return instance;
    }
}
