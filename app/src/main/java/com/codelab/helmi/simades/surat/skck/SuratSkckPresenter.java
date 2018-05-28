package com.codelab.helmi.simades.surat.skck;

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

public class SuratSkckPresenter implements Presenter<SuratSkckView> {
    private SuratSkckView suratSkckView;
    public List<SuratSkckData> mItems = new ArrayList<>();
    RecyclerView.Adapter mAdapter;

    public SuratSkckPresenter(RecyclerView.Adapter mAdapter) {
        this.mAdapter = mAdapter;
    }

    @Override
    public void onAttach(SuratSkckView view) {
        suratSkckView = view;
    }

    @Override
    public void onDetach() {
        suratSkckView = null;
    }

    public void showData(final Context ctx, final RecyclerView mRecycler){
        final SuratSkckData suratSkckData = new SuratSkckData();
        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<SuratSkckResponseModel> getData = api.getSuratPengantarSkckData();
        getData.enqueue(new Callback<SuratSkckResponseModel>() {
            @Override
            public void onResponse(Call<SuratSkckResponseModel> call, Response<SuratSkckResponseModel> response) {
                mItems = response.body().getResult();

                mAdapter = new SuratSkckRecyclerAdapter(ctx, mItems);
                mRecycler.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<SuratSkckResponseModel> call, Throwable t) {

            }
        });
        suratSkckView.onShowData(suratSkckData);
    }
}
