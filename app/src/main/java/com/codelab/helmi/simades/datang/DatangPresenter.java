package com.codelab.helmi.simades.datang;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.codelab.helmi.simades.api.RestApi;
import com.codelab.helmi.simades.api.RestServer;
import com.codelab.helmi.simades.base.Presenter;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DatangPresenter implements Presenter<DatangView> {

    RecyclerView.Adapter mAdapter;

    DatangView datangView;
    public List<DatangData> mItems = new ArrayList<>();

    public DatangPresenter(RecyclerView.Adapter mAdapter){
        this.mAdapter = mAdapter;
    }

    @Override
    public void onAttach(DatangView view) {
        datangView = view;
    }

    @Override
    public void onDetach() {
        datangView = null;
    }

    public void showData(final Context ctx, final RecyclerView mRecycler){
        final DatangData datangData = new DatangData();
        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<DatangResponseModel> getData = api.getDatangData();
        getData.enqueue(new Callback<DatangResponseModel>() {
            @Override
            public void onResponse(Call<DatangResponseModel> call, Response<DatangResponseModel> response) {
                mItems = response.body().getResult();
                mAdapter = new DatangRecyclerAdapter(ctx,mItems);
                mRecycler.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<DatangResponseModel> call, Throwable t) {

            }
        });

        datangView.onShowData(datangData);

    }
}
