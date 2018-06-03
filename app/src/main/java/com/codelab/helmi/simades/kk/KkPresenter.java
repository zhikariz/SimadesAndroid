package com.codelab.helmi.simades.kk;

import android.app.FragmentManager;
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

public class KkPresenter implements Presenter<KkView> {

    private KkView kkView;
    RecyclerView.Adapter mAdapter;
    public List<KkData> mItems = new ArrayList<>();

    public KkPresenter(RecyclerView.Adapter mAdapter) {
        this.mAdapter = mAdapter;
    }

    @Override
    public void onAttach(KkView view) {
        kkView = view;
    }

    @Override
    public void onDetach() {
        kkView = null;
    }

    public void showData(final Context ctx, final RecyclerView mRecycler, final FragmentManager fragmentManager) {
        final KkData kkData = new KkData();
        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<KkResponseModel> getData = api.getKkData();
        getData.enqueue(new Callback<KkResponseModel>() {
            @Override
            public void onResponse(Call<KkResponseModel> call, Response<KkResponseModel> response) {
                mItems = response.body().getResult();
                mAdapter = new KkRecyclerAdapter(ctx, mItems, fragmentManager);
                mRecycler.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<KkResponseModel> call, Throwable t) {

            }
        });


        kkView.onShowData(kkData);
    }
}
