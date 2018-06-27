package com.codelab.helmi.simades.kk;


import android.content.Context;
import android.support.v4.app.FragmentManager;
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
                if (response.isSuccessful()) {
                    mItems = response.body().getResult();
                    mAdapter = new KkRecyclerAdapter(ctx, mItems, fragmentManager);
                    mRecycler.setAdapter(mAdapter);
                    kkView.swipeRefreshFalse();
                } else {
                    switch (response.code()) {
                        case 404:
                            Toast.makeText(ctx, "404 Not Found", Toast.LENGTH_SHORT).show();
                            kkView.swipeRefreshFalse();
                            break;
                        case 500:
                            Toast.makeText(ctx, "500 Internal Server Error", Toast.LENGTH_SHORT).show();
                            kkView.swipeRefreshFalse();
                            break;
                        default:
                            Toast.makeText(ctx, "Unknown Error", Toast.LENGTH_SHORT).show();
                            kkView.swipeRefreshFalse();
                            break;
                    }
                }
            }

            @Override
            public void onFailure(Call<KkResponseModel> call, Throwable t) {
                Toast.makeText(ctx, "Gagal Mendapatkan Data", Toast.LENGTH_SHORT).show();
                kkView.swipeRefreshFalse();
            }
        });


        kkView.onShowData(kkData);
    }

    public void filterData(final Context ctx, final RecyclerView mRecycler, String no_kk, final FragmentManager fragmentManager) {
        final KkData kkData = new KkData();
        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<KkResponseModel> filterKkData = api.filterKkData(no_kk);
        filterKkData.enqueue(new Callback<KkResponseModel>() {
            @Override
            public void onResponse(Call<KkResponseModel> call, Response<KkResponseModel> response) {
                if (response.isSuccessful()) {
                    mItems = response.body().getResult();
                    mAdapter = new KkRecyclerAdapter(ctx, mItems, fragmentManager);
                    mRecycler.setAdapter(mAdapter);
                    kkView.swipeRefreshFalse();
                } else {
                    switch (response.code()) {
                        case 404:
                            Toast.makeText(ctx, "404 Not Found", Toast.LENGTH_SHORT).show();
                            kkView.swipeRefreshFalse();
                            break;
                        case 500:
                            Toast.makeText(ctx, "500 Internal Server Error", Toast.LENGTH_SHORT).show();
                            kkView.swipeRefreshFalse();
                            break;
                        default:
                            Toast.makeText(ctx, "Unknown Error", Toast.LENGTH_SHORT).show();
                            kkView.swipeRefreshFalse();
                            break;
                    }
                }
            }

            @Override
            public void onFailure(Call<KkResponseModel> call, Throwable t) {
                Toast.makeText(ctx, "Gagal Mendapatkan Data", Toast.LENGTH_SHORT).show();
                kkView.swipeRefreshFalse();
            }
        });
    }
}
