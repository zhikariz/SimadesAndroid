package com.codelab.helmi.simades.surat.ektp;

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

public class SuratEktpPresenter implements Presenter<SuratEktpView> {
    private SuratEktpView suratEktpView;
    public List<SuratEktpData> mItems = new ArrayList<>();
    RecyclerView.Adapter mAdapter;


    public SuratEktpPresenter(RecyclerView.Adapter mAdapter) {
        this.mAdapter = mAdapter;
    }

    @Override
    public void onAttach(SuratEktpView view) {
        suratEktpView = view;
    }

    @Override
    public void onDetach() {
        suratEktpView = null;
    }

    public void showData(final Context ctx, final RecyclerView mRecycler, final FragmentManager fragmentManager) {
        final SuratEktpData suratEktpData = new SuratEktpData();
        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<SuratEktpResponseModel> getData = api.getSuratPengantarEktpData();
        getData.enqueue(new Callback<SuratEktpResponseModel>() {
            @Override
            public void onResponse(Call<SuratEktpResponseModel> call, Response<SuratEktpResponseModel> response) {
                mItems = response.body().getResult();
                mAdapter = new SuratEktpRecyclerAdapter(ctx, mItems,fragmentManager);
                mRecycler.setAdapter(mAdapter);
                suratEktpView.swipeRefreshFalse();
            }

            @Override
            public void onFailure(Call<SuratEktpResponseModel> call, Throwable t) {
                suratEktpView.swipeRefreshFalse();

            }
        });
        suratEktpView.onShowData(suratEktpData);
    }
}
