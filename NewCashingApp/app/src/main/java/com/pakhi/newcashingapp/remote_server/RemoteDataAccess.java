package com.pakhi.newcashingapp.remote_server;

import com.pakhi.newcashingapp.api.RetrofitClient;
import com.pakhi.newcashingapp.dao.PicturesitemDAO;

public class RemoteDataAccess {

    private static final RemoteDataAccess instance = new RemoteDataAccess();

        private RemoteDataAccess() {
        }

        public static RemoteDataAccess getInstance ()
        {
            return instance;
        }
          // now when class loader loads RemoteDataAccess class it will automatically create one single object of RemoteDataAccess type


    //this class provides us with data access objects. We are making it singleton
    public PicturesitemDAO getPicturesItemDAO() {
        return RetrofitClient.getInstance().create(PicturesitemDAO.class);
    }
}