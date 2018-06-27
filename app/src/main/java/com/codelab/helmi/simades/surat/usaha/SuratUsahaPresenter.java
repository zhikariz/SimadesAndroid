package com.codelab.helmi.simades.surat.usaha;

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

public class SuratUsahaPresenter implements Presenter<SuratUsahaView> {
    private SuratUsahaView suratUsahaView;
    public List<SuratUsahaData> mItems = new ArrayList<>();
    RecyclerView.Adapter mAdapter;

    public SuratUsahaPresenter(RecyclerView.Adapter mAdapter) {
        this.mAdapter = mAdapter;
    }

    @Override
    public void onAttach(SuratUsahaView view) {
        suratUsahaView = view;
    }

    @Override
    public void onDetach() {
        suratUsahaView = null;
    }

    public void showData(final Context ctx, final RecyclerView mRecycler, final FragmentManager fragmentManager) {
        final SuratUsahaData suratUsahaData = new SuratUsahaData();
        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<SuratUsahaResponseModel> getData = api.getSuratUsahaData();
        getData.enqueue(new Callback<SuratUsahaResponseModel>() {
            @Override
            public void onResponse(Call<SuratUsahaResponseModel> call, Response<SuratUsahaResponseModel> response) {
                if(response.isSuccessful()) {
                    mItems = response.body().getResult();
                    mAdapter = new SuratUsahaRecyclerAdapter(ctx, mItems, fragmentManager);
                    mRecycler.setAdapter(mAdapter);
                    suratUsahaView.swipeRefreshFalse();
                }else {
                    switch (response.code()) {
                        case 404:
                            Toast.makeText(ctx, "404 Not Found", Toast.LENGTH_SHORT).show();
                            suratUsahaView.swipeRefreshFalse();
                            break;
                        case 500:
                            Toast.makeText(ctx, "500 Internal Server Error", Toast.LENGTH_SHORT).show();
                            suratUsahaView.swipeRefreshFalse();
                            break;
                        default:
                            Toast.makeText(ctx, "Unknown Error", Toast.LENGTH_SHORT).show();
                            suratUsahaView.swipeRefreshFalse();
                            break;
                    }
                }
            }

            @Override
            public void onFailure(Call<SuratUsahaResponseModel> call, Throwable t) {
                suratUsahaView.swipeRefreshFalse();
            }
        });
        suratUsahaView.onShowData(suratUsahaData);
    }
}
