package com.codelab.helmi.simades.surat.kelahiran;


import android.content.Context;
import android.widget.Toast;

import com.codelab.helmi.simades.helper.api.RestApi;
import com.codelab.helmi.simades.helper.api.RestServer;
import com.codelab.helmi.simades.base.Presenter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SuratKelahiranPresenter implements Presenter<SuratKelahiranView> {

    private SuratKelahiranView suratKelahiranView;
    public List<SuratKelahiranData> mItems = new ArrayList<>();
    Context context;

    public SuratKelahiranPresenter(Context context) {
        this.context = context;
    }

    @Override
    public void onAttach(SuratKelahiranView view) {
        suratKelahiranView = view;
    }

    @Override
    public void onDetach() {
        suratKelahiranView = null;
    }

    public void showData() {
        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<SuratKelahiranResponseModel> getData = api.getSuratKelahiranData();
        getData.enqueue(new Callback<SuratKelahiranResponseModel>() {
            @Override
            public void onResponse(Call<SuratKelahiranResponseModel> call, Response<SuratKelahiranResponseModel> response) {
                try {
                    if (response.isSuccessful()) {
                        mItems = response.body().getResult();
                        suratKelahiranView.setAdapter(mItems);
                        suratKelahiranView.swipeRefreshFalse();
                    } else {
                        switch (response.code()) {
                            case 404:
                                Toast.makeText(context, "404 Not Found", Toast.LENGTH_SHORT).show();
                                suratKelahiranView.swipeRefreshFalse();
                                break;
                            case 500:
                                Toast.makeText(context, "500 Internal Server Error", Toast.LENGTH_SHORT).show();
                                suratKelahiranView.swipeRefreshFalse();
                                break;
                            default:
                                Toast.makeText(context, "Unknown Error", Toast.LENGTH_SHORT).show();
                                suratKelahiranView.swipeRefreshFalse();
                                break;
                        }
                    }
                } catch (Exception e)
                {
                    e.printStackTrace();
                    suratKelahiranView.swipeRefreshFalse();
                }
            }

            @Override
            public void onFailure(Call<SuratKelahiranResponseModel> call, Throwable t) {

                Toast.makeText(context, t.toString(), Toast.LENGTH_SHORT).show();
                suratKelahiranView.swipeRefreshFalse();
            }
        });
    }
}
