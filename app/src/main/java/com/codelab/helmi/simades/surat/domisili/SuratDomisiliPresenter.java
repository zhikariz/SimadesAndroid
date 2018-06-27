package com.codelab.helmi.simades.surat.domisili;

import android.content.Context;
import android.support.v4.app.Fragment;
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

public class SuratDomisiliPresenter implements Presenter<SuratDomisiliView> {
    private SuratDomisiliView suratDomisiliView;
    public List<SuratDomisiliData> mItems = new ArrayList<>();
    RecyclerView.Adapter mAdapter;

    public SuratDomisiliPresenter(RecyclerView.Adapter mAdapter) {
        this.mAdapter = mAdapter;
    }

    @Override
    public void onAttach(SuratDomisiliView view) {
        suratDomisiliView = view;
    }

    @Override
    public void onDetach() {
        suratDomisiliView = null;
    }

    public void showData(final Context ctx, final RecyclerView mRecycler, final FragmentManager fragmentManager) {
        final SuratDomisiliData suratDomisiliData = new SuratDomisiliData();
        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<SuratDomisiliResponseModel> getData = api.getSuratDomisiliData();
        getData.enqueue(new Callback<SuratDomisiliResponseModel>() {
            @Override
            public void onResponse(Call<SuratDomisiliResponseModel> call, Response<SuratDomisiliResponseModel> response) {
                if(response.isSuccessful()) {
                    mItems = response.body().getResult();
                    mAdapter = new SuratDomisiliRecyclerAdapter(ctx, mItems, fragmentManager);
                    mRecycler.setAdapter(mAdapter);
                    suratDomisiliView.swipeRefreshFalse();
                }else{
                    switch (response.code()) {
                        case 404:
                            Toast.makeText(ctx, "404 Not Found", Toast.LENGTH_SHORT).show();
                            suratDomisiliView.swipeRefreshFalse();
                            break;
                        case 500:
                            Toast.makeText(ctx, "500 Internal Server Error", Toast.LENGTH_SHORT).show();
                            suratDomisiliView.swipeRefreshFalse();
                            break;
                        default:
                            Toast.makeText(ctx, "Unknown Error", Toast.LENGTH_SHORT).show();
                            suratDomisiliView.swipeRefreshFalse();
                            break;
                    }
                }
            }

            @Override
            public void onFailure(Call<SuratDomisiliResponseModel> call, Throwable t) {
                suratDomisiliView.swipeRefreshFalse();

            }
        });
        suratDomisiliView.onShowData(suratDomisiliData);
    }
}
