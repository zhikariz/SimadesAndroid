package com.codelab.helmi.simades.surat.usaha;

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

public class SuratUsahaPresenter implements Presenter<SuratUsahaView> {
    private SuratUsahaView suratUsahaView;
    public List<SuratUsahaData> mItems = new ArrayList<>();
    Context context;

    public SuratUsahaPresenter(Context context) {
        this.context = context;
    }

    @Override
    public void onAttach(SuratUsahaView view) {
        suratUsahaView = view;
    }

    @Override
    public void onDetach() {
        suratUsahaView = null;
    }

    public void showData() {
        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<SuratUsahaResponseModel> getData = api.getSuratUsahaData();
        getData.enqueue(new Callback<SuratUsahaResponseModel>() {
            @Override
            public void onResponse(Call<SuratUsahaResponseModel> call, Response<SuratUsahaResponseModel> response) {
                if(response.isSuccessful()) {
                    mItems = response.body().getResult();
                    suratUsahaView.setAdapter(mItems);
                    suratUsahaView.swipeRefreshFalse();
                }else {
                    switch (response.code()) {
                        case 404:
                            Toast.makeText(context, "404 Not Found", Toast.LENGTH_SHORT).show();
                            suratUsahaView.swipeRefreshFalse();
                            break;
                        case 500:
                            Toast.makeText(context, "500 Internal Server Error", Toast.LENGTH_SHORT).show();
                            suratUsahaView.swipeRefreshFalse();
                            break;
                        default:
                            Toast.makeText(context, "Unknown Error", Toast.LENGTH_SHORT).show();
                            suratUsahaView.swipeRefreshFalse();
                            break;
                    }
                }
            }

            @Override
            public void onFailure(Call<SuratUsahaResponseModel> call, Throwable t) {
                suratUsahaView.swipeRefreshFalse();
            }
        });
    }
}
