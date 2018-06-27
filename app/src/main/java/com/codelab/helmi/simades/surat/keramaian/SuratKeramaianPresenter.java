package com.codelab.helmi.simades.surat.keramaian;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;

import com.codelab.helmi.simades.api.RestApi;
import com.codelab.helmi.simades.api.RestServer;
import com.codelab.helmi.simades.base.Presenter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SuratKeramaianPresenter implements Presenter<SuratKeramaianView> {
    private SuratKeramaianView suratKeramaianView;
    public List<SuratKeramaianData> mItems = new ArrayList<>();
    RecyclerView.Adapter mAdapter;

    public SuratKeramaianPresenter(RecyclerView.Adapter mAdapter) {
        this.mAdapter = mAdapter;
    }

    @Override
    public void onAttach(SuratKeramaianView view) {
        suratKeramaianView = view;
    }

    @Override
    public void onDetach() {
        suratKeramaianView = null;
    }

    public void showData(final Context ctx, final RecyclerView mRecycler, final FragmentManager fragmentManager) {
        final SuratKeramaianData suratKeramaianData = new SuratKeramaianData();
        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<SuratKeramaianResponseModel> getData = api.getSuratIzinKeramaianData();
        getData.enqueue(new Callback<SuratKeramaianResponseModel>() {
            @Override
            public void onResponse(Call<SuratKeramaianResponseModel> call, Response<SuratKeramaianResponseModel> response) {
                mItems = response.body().getResult();
                mAdapter = new SuratKeramaianRecyclerAdapter(ctx, mItems, fragmentManager);
                mRecycler.setAdapter(mAdapter);
                suratKeramaianView.swipeRefreshFalse();
            }

            @Override
            public void onFailure(Call<SuratKeramaianResponseModel> call, Throwable t) {
                suratKeramaianView.swipeRefreshFalse();

            }
        });

        suratKeramaianView.onShowData(suratKeramaianData);
    }
}
