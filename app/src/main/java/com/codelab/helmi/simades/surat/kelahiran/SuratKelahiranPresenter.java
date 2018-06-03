package com.codelab.helmi.simades.surat.kelahiran;

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

public class SuratKelahiranPresenter implements Presenter<SuratKelahiranView> {

    private SuratKelahiranView suratKelahiranView;
    public List<SuratKelahiranData> mItems = new ArrayList<>();
    RecyclerView.Adapter mAdapter;

    public SuratKelahiranPresenter(RecyclerView.Adapter mAdapter) {
        this.mAdapter = mAdapter;
    }

    @Override
    public void onAttach(SuratKelahiranView view) {
        suratKelahiranView = view;
    }

    @Override
    public void onDetach() {
        suratKelahiranView = null;
    }

    public void showData(final Context ctx, final RecyclerView mRecycler, final FragmentManager fragmentManager) {
        final SuratKelahiranData suratKelahiranData = new SuratKelahiranData();
        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<SuratKelahiranResponseModel> getData = api.getSuratKelahiranData();
        getData.enqueue(new Callback<SuratKelahiranResponseModel>() {
            @Override
            public void onResponse(Call<SuratKelahiranResponseModel> call, Response<SuratKelahiranResponseModel> response) {
                mItems = response.body().getResult();
                mAdapter = new SuratKelahiranRecyclerAdapter(ctx, mItems,fragmentManager);
                mRecycler.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<SuratKelahiranResponseModel> call, Throwable t) {

            }
        });
        suratKelahiranView.onShowData(suratKelahiranData);
    }
}
