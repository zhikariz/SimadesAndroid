package com.codelab.helmi.simades.pergi;

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

public class PergiPresenter implements Presenter<PergiView> {

    PergiView pergiView;
    RecyclerView.Adapter mAdapter;
    public List<PergiData> mItems = new ArrayList<>();

    public PergiPresenter(RecyclerView.Adapter mAdapter) {
        this.mAdapter = mAdapter;
    }

    @Override
    public void onAttach(PergiView view) {
        pergiView = view;
    }

    @Override
    public void onDetach() {
        pergiView = null;
    }

    public void showData(final Context ctx, final RecyclerView mRecycler) {

        final PergiData pergiData = new PergiData();
        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<PergiResponseModel> getData = api.getPergiData();
        getData.enqueue(new Callback<PergiResponseModel>() {
            @Override
            public void onResponse(Call<PergiResponseModel> call, Response<PergiResponseModel> response) {
                mItems = response.body().getResult();
                mAdapter = new PergiRecyclerAdapter(ctx, mItems);
                mRecycler.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<PergiResponseModel> call, Throwable t) {

            }
        });

        pergiView.onShowData(pergiData);

    }
}
