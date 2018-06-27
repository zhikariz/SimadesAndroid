package com.codelab.helmi.simades.surat.wali;

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

public class SuratWaliPresenter implements Presenter<SuratWaliView> {

    private SuratWaliView suratWaliView;
    public List<SuratWaliData> mItems = new ArrayList<>();
    RecyclerView.Adapter mAdapter;

    public SuratWaliPresenter(RecyclerView.Adapter mAdapter) {
        this.mAdapter = mAdapter;
    }

    @Override
    public void onAttach(SuratWaliView view) {
        suratWaliView = view;
    }

    @Override
    public void onDetach() {
        suratWaliView = null;
    }

    public void showData(final Context ctx, final RecyclerView mRecycler, final FragmentManager fragmentManager) {
        final SuratWaliData suratWaliData = new SuratWaliData();
        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<SuratWaliResponseModel> getData = api.getSuratWaliData();

        getData.enqueue(new Callback<SuratWaliResponseModel>() {
            @Override
            public void onResponse(Call<SuratWaliResponseModel> call, Response<SuratWaliResponseModel> response) {
                if(response.isSuccessful()) {
                    mItems = response.body().getResult();
                    mAdapter = new SuratWaliRecyclerAdapter(ctx, mItems, fragmentManager);
                    mRecycler.setAdapter(mAdapter);
                    suratWaliView.swipeRefreshFalse();
                }else{
                    switch (response.code()) {
                        case 404:
                            Toast.makeText(ctx, "404 Not Found", Toast.LENGTH_SHORT).show();
                            suratWaliView.swipeRefreshFalse();
                            break;
                        case 500:
                            Toast.makeText(ctx, "500 Internal Server Error", Toast.LENGTH_SHORT).show();
                            suratWaliView.swipeRefreshFalse();
                            break;
                        default:
                            Toast.makeText(ctx, "Unknown Error", Toast.LENGTH_SHORT).show();
                            suratWaliView.swipeRefreshFalse();
                            break;
                    }
                }
            }

            @Override
            public void onFailure(Call<SuratWaliResponseModel> call, Throwable t) {
                suratWaliView.swipeRefreshFalse();

            }
        });
        suratWaliView.onShowData(suratWaliData);
    }


}
