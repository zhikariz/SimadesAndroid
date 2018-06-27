package com.codelab.helmi.simades.surat.kelahiran;


import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.codelab.helmi.simades.api.RestApi;
import com.codelab.helmi.simades.api.RestServer;
import com.codelab.helmi.simades.base.Presenter;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLHandshakeException;

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
                if(response.isSuccessful()) {
                    mItems = response.body().getResult();
                    mAdapter = new SuratKelahiranRecyclerAdapter(ctx, mItems, fragmentManager);
                    mRecycler.setAdapter(mAdapter);
                    suratKelahiranView.swipeRefreshFalse();
                }else{
                    switch (response.code()) {
                        case 404:
                            Toast.makeText(ctx, "404 Not Found", Toast.LENGTH_SHORT).show();
                            suratKelahiranView.swipeRefreshFalse();
                            break;
                        case 500:
                            Toast.makeText(ctx, "500 Internal Server Error", Toast.LENGTH_SHORT).show();
                            suratKelahiranView.swipeRefreshFalse();
                            break;
                        default:
                            Toast.makeText(ctx, "Unknown Error", Toast.LENGTH_SHORT).show();
                            suratKelahiranView.swipeRefreshFalse();
                            break;
                    }
                }
            }

            @Override
            public void onFailure(Call<SuratKelahiranResponseModel> call, Throwable t) {

                Toast.makeText(ctx, t.toString(), Toast.LENGTH_SHORT).show();
                suratKelahiranView.swipeRefreshFalse();
            }
        });
        suratKelahiranView.onShowData(suratKelahiranData);
    }
}
