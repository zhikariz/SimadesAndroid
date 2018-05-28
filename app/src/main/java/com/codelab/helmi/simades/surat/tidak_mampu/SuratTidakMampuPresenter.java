package com.codelab.helmi.simades.surat.tidak_mampu;

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

public class SuratTidakMampuPresenter implements Presenter<SuratTidakMampuView>{
    private SuratTidakMampuView suratTidakMampuView;
    public List<SuratTidakMampuData> mItems = new ArrayList<>();
    RecyclerView.Adapter mAdapter;

    public SuratTidakMampuPresenter(RecyclerView.Adapter mAdapter) {
        this.mAdapter = mAdapter;
    }

    @Override
    public void onAttach(SuratTidakMampuView view) {
        suratTidakMampuView = view;
    }

    @Override
    public void onDetach() {
        suratTidakMampuView = null;
    }

    public void showData(final Context ctx, final RecyclerView mRecycler){
        final SuratTidakMampuData suratTidakMampuData = new SuratTidakMampuData();
        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<SuratTidakMampuResponseModel> getData = api.getSuratTidakMampuData();
        getData.enqueue(new Callback<SuratTidakMampuResponseModel>() {
            @Override
            public void onResponse(Call<SuratTidakMampuResponseModel> call, Response<SuratTidakMampuResponseModel> response) {
                mItems = response.body().getResult();
                mAdapter = new SuratTidakMampuRecyclerAdapter(ctx, mItems);
                mRecycler.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<SuratTidakMampuResponseModel> call, Throwable t) {

            }
        });
        suratTidakMampuView.onShowData(suratTidakMampuData);
    }
}
