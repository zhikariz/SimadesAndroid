package com.codelab.helmi.simades.kelahiran;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.codelab.helmi.simades.api.RestApi;
import com.codelab.helmi.simades.api.RestServer;
import com.codelab.helmi.simades.base.Presenter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KelahiranPresenter implements Presenter<KelahiranView> {

    RecyclerView.Adapter mAdapter;

    private KelahiranView kelahiranView;
    public List<KelahiranData> mItems = new ArrayList<>();

    public KelahiranPresenter(RecyclerView.Adapter mAdapter) {
        this.mAdapter = mAdapter;
    }

    @Override
    public void onAttach(KelahiranView view) {
        kelahiranView = view;
    }

    @Override
    public void onDetach() {
        kelahiranView = null;
    }

    public void showData(final Context ctx, final RecyclerView mRecycler) {
        final KelahiranData kelahiranData = new KelahiranData();
        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<KelahiranResponseModel> getData = api.getKelahiranData();
        getData.enqueue(new Callback<KelahiranResponseModel>() {
            @Override
            public void onResponse(Call<KelahiranResponseModel> call, Response<KelahiranResponseModel> response) {
                if(response.isSuccessful()){
                mItems = response.body().getResult();
                mAdapter = new KelahiranRecyclerAdapter(ctx, mItems);
                mRecycler.setAdapter(mAdapter);}
                else{
                    switch (response.code()) {
                        case 404:
                            Toast.makeText(ctx, "404 Not Found", Toast.LENGTH_SHORT).show();
                            break;
                        case 500:
                            Toast.makeText(ctx, "500 Internal Server Error", Toast.LENGTH_SHORT).show();
                            break;
                        default:
                            Toast.makeText(ctx, "Unknown Error", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            }

            @Override
            public void onFailure(Call<KelahiranResponseModel> call, Throwable t) {

            }
        });
        kelahiranView.onShowData(kelahiranData);
    }
}
