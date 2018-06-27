package com.codelab.helmi.simades.penduduk;


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

public class ShowPendudukPresenter implements Presenter<PendudukView> {
    private PendudukView pendudukView;
    RecyclerView.Adapter mAdapter;
    public List<PendudukData> mItems = new ArrayList<>();

    public ShowPendudukPresenter(RecyclerView.Adapter mAdapter) {
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

    public void showData(final Context ctx, final RecyclerView mRecycler, String no_kk, final FragmentManager fragmentManager) {
        final PendudukData pendudukData = new PendudukData();
        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<ShowPendudukResponseModel> getData = api.getPendudukData(no_kk);
        getData.enqueue(new Callback<ShowPendudukResponseModel>() {
            @Override
            public void onResponse(Call<ShowPendudukResponseModel> call, Response<ShowPendudukResponseModel> response) {
                if (response.isSuccessful()) {
                    mItems = response.body().getResult();
                    mAdapter = new ShowPendudukRecyclerAdapter(ctx, mItems, fragmentManager);
                    mRecycler.setAdapter(mAdapter);
                    pendudukView.swipeRefreshFalse();
                } else {
                    switch (response.code()) {
                        case 404:
                            Toast.makeText(ctx, "404 Not Found", Toast.LENGTH_SHORT).show();
                            pendudukView.swipeRefreshFalse();
                            break;
                        case 500:
                            Toast.makeText(ctx, "500 Internal Server Error", Toast.LENGTH_SHORT).show();
                            pendudukView.swipeRefreshFalse();
                            break;
                        default:
                            Toast.makeText(ctx, "Unknown Error", Toast.LENGTH_SHORT).show();
                            pendudukView.swipeRefreshFalse();
                            break;
                    }
                }
            }

            @Override
            public void onFailure(Call<ShowPendudukResponseModel> call, Throwable t) {
                Toast.makeText(ctx, "Gagal Mendapatkan Data", Toast.LENGTH_SHORT).show();
                pendudukView.swipeRefreshFalse();
            }
        });


        pendudukView.onShowData(pendudukData);
    }

    public void filterData(final Context ctx, final RecyclerView mRecycler, String nik, final FragmentManager fragmentManager) {

        final PendudukData pendudukData = new PendudukData();
        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<ShowPendudukResponseModel> filterPendudukData = api.filterPendudukData(nik);
        filterPendudukData.enqueue(new Callback<ShowPendudukResponseModel>() {
            @Override
            public void onResponse(Call<ShowPendudukResponseModel> call, Response<ShowPendudukResponseModel> response) {
                if (response.isSuccessful()) {
                    mItems = response.body().getResult();
                    mAdapter = new ShowPendudukRecyclerAdapter(ctx, mItems, fragmentManager);
                    mRecycler.setAdapter(mAdapter);
                    pendudukView.swipeRefreshFalse();
                } else {
                    switch (response.code()) {
                        case 404:
                            Toast.makeText(ctx, "404 Not Found", Toast.LENGTH_SHORT).show();
                            pendudukView.swipeRefreshFalse();
                            break;
                        case 500:
                            Toast.makeText(ctx, "500 Internal Server Error", Toast.LENGTH_SHORT).show();
                            pendudukView.swipeRefreshFalse();
                            break;
                        default:
                            Toast.makeText(ctx, "Unknown Error", Toast.LENGTH_SHORT).show();
                            pendudukView.swipeRefreshFalse();
                            break;
                    }
                }
            }

            @Override
            public void onFailure(Call<ShowPendudukResponseModel> call, Throwable t) {
                Toast.makeText(ctx, "Gagal Mendapatkan Data", Toast.LENGTH_SHORT).show();
                pendudukView.swipeRefreshFalse();
            }
        });

    }
}
