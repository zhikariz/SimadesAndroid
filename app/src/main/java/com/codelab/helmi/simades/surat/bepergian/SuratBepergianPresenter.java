package com.codelab.helmi.simades.surat.bepergian;

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

public class SuratBepergianPresenter implements Presenter<SuratBepergianView> {
    private SuratBepergianView suratBepergianView;
    public List<SuratBepergianData> mItems = new ArrayList<>();
    RecyclerView.Adapter mAdapter;

    public SuratBepergianPresenter(RecyclerView.Adapter mAdapter) {
        this.mAdapter = mAdapter;
    }

    @Override
    public void onAttach(SuratBepergianView view) {
        suratBepergianView = view;
    }

    @Override
    public void onDetach() {
        suratBepergianView = null;
    }

    public void showData(final Context ctx, final RecyclerView mRecycler, final FragmentManager fragmentManager) {
        final SuratBepergianData suratBepergianData = new SuratBepergianData();
        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<SuratBepergianResponseModel> getData = api.getSuratBepergianData();
        getData.enqueue(new Callback<SuratBepergianResponseModel>() {
            @Override
            public void onResponse(Call<SuratBepergianResponseModel> call, Response<SuratBepergianResponseModel> response) {
                mItems = response.body().getResult();
                mAdapter = new SuratBepergianRecyclerAdapter(ctx, mItems, fragmentManager);
                mRecycler.setAdapter(mAdapter);
                suratBepergianView.swipeRefreshFalse();
            }

            @Override
            public void onFailure(Call<SuratBepergianResponseModel> call, Throwable t) {
                suratBepergianView.swipeRefreshFalse();
            }
        });
        suratBepergianView.onShowData(suratBepergianData);
    }
}
