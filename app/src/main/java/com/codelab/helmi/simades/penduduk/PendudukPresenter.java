package com.codelab.helmi.simades.penduduk;

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

public class PendudukPresenter implements Presenter<PendudukView> {
    private PendudukView pendudukView;
    RecyclerView.Adapter mAdapter;
    public List<PendudukData> mItems = new ArrayList<>();

    public PendudukPresenter(RecyclerView.Adapter mAdapter){
        this.mAdapter = mAdapter;
    }

    @Override
    public void onAttach(PendudukView view) {
        pendudukView = view;
    }

    @Override
    public void onDetach() {
        pendudukView = null;
    }

    public void showData(final Context ctx, final RecyclerView mRecycler,String nik){
        final PendudukData pendudukData = new PendudukData();
        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<PendudukResponseModel> getData = api.getPendudukData(nik);
        getData.enqueue(new Callback<PendudukResponseModel>() {
            @Override
            public void onResponse(Call<PendudukResponseModel> call, Response<PendudukResponseModel> response) {
                mItems = response.body().getResult();
                mAdapter = new PendudukRecyclerAdapter(ctx,mItems);
                mRecycler.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<PendudukResponseModel> call, Throwable t) {

            }
        });



        pendudukView.onShowData(pendudukData);
    }
}
