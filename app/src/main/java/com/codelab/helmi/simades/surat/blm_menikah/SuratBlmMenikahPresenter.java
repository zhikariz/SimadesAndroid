package com.codelab.helmi.simades.surat.blm_menikah;

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

public class SuratBlmMenikahPresenter implements Presenter<SuratBlmMenikahView> {
    private SuratBlmMenikahView suratBlmMenikahView;
    public List<SuratBlmMenikahData> mItems = new ArrayList<>();
    RecyclerView.Adapter mAdapter;

    public SuratBlmMenikahPresenter(RecyclerView.Adapter mAdapter) {
        this.mAdapter = mAdapter;
    }

    @Override
    public void onAttach(SuratBlmMenikahView view) {
        suratBlmMenikahView = view;
    }

    @Override
    public void onDetach() {
        suratBlmMenikahView = null;
    }

    public void showData(final Context ctx, final RecyclerView mRecycler) {
        final SuratBlmMenikahData suratBlmMenikahData = new SuratBlmMenikahData();
        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<SuratBlmMenikahResponseModel> getData = api.getSuratBlmMenikahData();
        getData.enqueue(new Callback<SuratBlmMenikahResponseModel>() {
            @Override
            public void onResponse(Call<SuratBlmMenikahResponseModel> call, Response<SuratBlmMenikahResponseModel> response) {
                mItems = response.body().getResult();
                mAdapter = new SuratBlmMenikahRecyclerAdapter(ctx, mItems);
                mRecycler.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<SuratBlmMenikahResponseModel> call, Throwable t) {

            }
        });
        suratBlmMenikahView.onShowData(suratBlmMenikahData);
    }
}
