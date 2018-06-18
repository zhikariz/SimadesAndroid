package com.codelab.helmi.simades.surat.kematian;

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

public class SuratKematianPresenter implements Presenter<SuratKematianView> {
    private SuratKematianView suratKematianView;
    public List<SuratKematianData> mItems = new ArrayList<>();
    RecyclerView.Adapter mAdapter;

    public SuratKematianPresenter(RecyclerView.Adapter mAdapter) {
        this.mAdapter = mAdapter;
    }

    @Override
    public void onAttach(SuratKematianView view) {
        suratKematianView = view;
    }

    @Override
    public void onDetach() {
        suratKematianView = null;
    }

    public void showData(final Context ctx, final RecyclerView mRecycler, final FragmentManager fragmentManager) {
        final SuratKematianData suratKematianData = new SuratKematianData();
        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<SuratKematianResponseModel> getData = api.getSuratKematianData();
        getData.enqueue(new Callback<SuratKematianResponseModel>() {
            @Override
            public void onResponse(Call<SuratKematianResponseModel> call, Response<SuratKematianResponseModel> response) {
                mItems = response.body().getResult();
                mAdapter = new SuratKematianRecyclerAdapter(ctx, mItems,fragmentManager);
                mRecycler.setAdapter(mAdapter);
                suratKematianView.swipeRefreshFalse();
            }

            @Override
            public void onFailure(Call<SuratKematianResponseModel> call, Throwable t) {
                suratKematianView.swipeRefreshFalse();
            }
        });
        suratKematianView.onShowData(suratKematianData);
    }
}
