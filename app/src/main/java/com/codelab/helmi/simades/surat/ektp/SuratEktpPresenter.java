package com.codelab.helmi.simades.surat.ektp;

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

public class SuratEktpPresenter implements Presenter<SuratEktpView> {
    private SuratEktpView suratEktpView;
    public List<SuratEktpData> mItems = new ArrayList<>();
    Context context;


    public SuratEktpPresenter(Context context) {
        this.context = context;
    }

    @Override
    public void onAttach(SuratEktpView view) {
        suratEktpView = view;
    }

    @Override
    public void onDetach() {
        suratEktpView = null;
    }

    public void showData() {
        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<SuratEktpResponseModel> getData = api.getSuratPengantarEktpData();
        getData.enqueue(new Callback<SuratEktpResponseModel>() {
            @Override
            public void onResponse(Call<SuratEktpResponseModel> call, Response<SuratEktpResponseModel> response) {
                if (response.isSuccessful()) {
                    mItems = response.body().getResult();
                    suratEktpView.setAdapter(mItems);
                    suratEktpView.swipeRefreshFalse();
                } else {
                    switch (response.code()) {
                        case 404:
                            Toast.makeText(context, "404 Not Found", Toast.LENGTH_SHORT).show();
                            suratEktpView.swipeRefreshFalse();
                            break;
                        case 500:
                            Toast.makeText(context, "500 Internal Server Error", Toast.LENGTH_SHORT).show();
                            suratEktpView.swipeRefreshFalse();
                            break;
                        default:
                            Toast.makeText(context, "Unknown Error", Toast.LENGTH_SHORT).show();
                            suratEktpView.swipeRefreshFalse();
                            break;
                    }
                }
            }

            @Override
            public void onFailure(Call<SuratEktpResponseModel> call, Throwable t) {
                suratEktpView.swipeRefreshFalse();

            }
        });
    }
}
