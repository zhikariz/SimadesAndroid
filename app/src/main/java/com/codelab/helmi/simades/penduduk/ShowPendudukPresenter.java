package com.codelab.helmi.simades.penduduk;

import android.app.FragmentManager;
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

public class ShowPendudukPresenter implements Presenter<PendudukView> {
    private PendudukView pendudukView;
    RecyclerView.Adapter mAdapter;
    public List<PendudukData> mItems = new ArrayList<>();

    public ShowPendudukPresenter(RecyclerView.Adapter mAdapter) {
        this.mAdapter = mAdapter;
    }

    @Override
    public void onAttach(PendudukView view) {
        pendudukView = view;
    }

    @Override
    public void onDetach() {
        pendudukView = null;
    }

    public void showData(final Context ctx, final RecyclerView mRecycler, String nik, final FragmentManager fragmentManager) {
        final PendudukData pendudukData = new PendudukData();
        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<ShowPendudukResponseModel> getData = api.getPendudukData(nik);
        getData.enqueue(new Callback<ShowPendudukResponseModel>() {
            @Override
            public void onResponse(Call<ShowPendudukResponseModel> call, Response<ShowPendudukResponseModel> response) {
                mItems = response.body().getResult();
                mAdapter = new ShowPendudukRecyclerAdapter(ctx, mItems, fragmentManager);
                mRecycler.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<ShowPendudukResponseModel> call, Throwable t) {

            }
        });


        pendudukView.onShowData(pendudukData);
    }
}
