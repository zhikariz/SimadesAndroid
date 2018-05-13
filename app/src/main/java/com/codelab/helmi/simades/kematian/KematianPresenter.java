package com.codelab.helmi.simades.kematian;

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

public class KematianPresenter implements Presenter<KematianView>{

    KematianView kematianView;
    RecyclerView.Adapter mAdapter;
    public List<KematianData> mItems = new ArrayList<>();

    public KematianPresenter(RecyclerView.Adapter mAdapter){
        this.mAdapter = mAdapter;
    }

    @Override
    public void onAttach(KematianView view) {
        kematianView = view;
    }

    @Override
    public void onDetach() {
        kematianView = null;
    }

    public void showData(final Context ctx, final RecyclerView mRecycler){
        final KematianData kematianData = new KematianData();
        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<KematianResponseModel> getData = api.getKematianData();
        getData.enqueue(new Callback<KematianResponseModel>() {
            @Override
            public void onResponse(Call<KematianResponseModel> call, Response<KematianResponseModel> response) {
                mItems = response.body().getResult();
                mAdapter = new KematianRecyclerAdapter(ctx,mItems);
                mRecycler.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<KematianResponseModel> call, Throwable t) {

            }
        });
        kematianView.onShowData(kematianData);
    }
}
