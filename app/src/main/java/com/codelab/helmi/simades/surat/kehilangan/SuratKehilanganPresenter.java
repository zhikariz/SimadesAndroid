package com.codelab.helmi.simades.surat.kehilangan;

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

public class SuratKehilanganPresenter implements Presenter<SuratKehilanganView> {
    private SuratKehilanganView suratKehilanganView;
    public List<SuratKehilanganData> mItems = new ArrayList<>();
    RecyclerView.Adapter mAdapter;

    public SuratKehilanganPresenter(RecyclerView.Adapter mAdapter) {
        this.mAdapter = mAdapter;
    }

    @Override
    public void onAttach(SuratKehilanganView view) {
        suratKehilanganView = view;
    }

    @Override
    public void onDetach() {
        suratKehilanganView = null;
    }

    public void showData(final Context ctx, final RecyclerView mRecycler, final FragmentManager fragmentManager) {
        final SuratKehilanganData suratKehilanganData = new SuratKehilanganData();
        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<SuratKehilanganResponseModel> getData = api.getSuratKehilanganData();
        getData.enqueue(new Callback<SuratKehilanganResponseModel>() {
            @Override
            public void onResponse(Call<SuratKehilanganResponseModel> call, Response<SuratKehilanganResponseModel> response) {
                mItems = response.body().getResult();
                mAdapter = new SuratKehilanganRecyclerAdapter(ctx, mItems, fragmentManager);
                mRecycler.setAdapter(mAdapter);
                suratKehilanganView.swipeRefreshFalse();
            }

            @Override
            public void onFailure(Call<SuratKehilanganResponseModel> call, Throwable t) {
                suratKehilanganView.swipeRefreshFalse();

            }
        });
        suratKehilanganView.onShowData(suratKehilanganData);
    }
}
