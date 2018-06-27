package com.codelab.helmi.simades.user;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.codelab.helmi.simades.api.RestApi;
import com.codelab.helmi.simades.api.RestServer;
import com.codelab.helmi.simades.base.Presenter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserPresenter implements Presenter<UserView> {
    RecyclerView.Adapter mAdapter;

    UserView userView;

    public List<UserData> mItems = new ArrayList<>();

    public UserPresenter(RecyclerView.Adapter mAdapter){
        this.mAdapter = mAdapter;
    }


    @Override
    public void onAttach(UserView view) {
        userView = view;
    }

    @Override
    public void onDetach() {
        userView = null;
    }

    public void showData(final Context ctx, final RecyclerView mRecycler) {
        final UserData userData = new UserData();
        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<UserResponseModel> getdata = api.getUserData();
        getdata.enqueue(new Callback<UserResponseModel>() {
            @Override
            public void onResponse(Call<UserResponseModel> call, Response<UserResponseModel> response) {
                if(response.isSuccessful()) {
                    mItems = response.body().getResult();
                    mAdapter = new UserRecyclerAdapter(ctx, mItems);
                    mRecycler.setAdapter(mAdapter);
                }else{
                    switch (response.code()) {
                        case 404:
                            Toast.makeText(ctx, "404 Not Found", Toast.LENGTH_SHORT).show();
                            break;
                        case 500:
                            Toast.makeText(ctx, "500 Internal Server Error", Toast.LENGTH_SHORT).show();
                            break;
                        default:
                            Toast.makeText(ctx, "Unknown Error", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            }

            @Override
            public void onFailure(Call<UserResponseModel> call, Throwable t) {

            }
        });
        userView.onShowData(userData);
    }
}
