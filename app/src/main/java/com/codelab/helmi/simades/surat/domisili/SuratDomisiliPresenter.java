package com.codelab.helmi.simades.surat.domisili;

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

public class SuratDomisiliPresenter implements Presenter<SuratDomisiliView> {
    private SuratDomisiliView suratDomisiliView;
    public List<SuratDomisiliData> mItems = new ArrayList<>();
    Context context;

    public SuratDomisiliPresenter(Context context) {
        this.context = context;
    }

    @Override
    public void onAttach(SuratDomisiliView view) {
        suratDomisiliView = view;
    }

    @Override
    public void onDetach() {
        suratDomisiliView = null;
    }

    public void showData() {
        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<SuratDomisiliResponseModel> getData = api.getSuratDomisiliData();
        getData.enqueue(new Callback<SuratDomisiliResponseModel>() {
            @Override
            public void onResponse(Call<SuratDomisiliResponseModel> call, Response<SuratDomisiliResponseModel> response) {
                try {
                    if (response.isSuccessful()) {
                        mItems = response.body().getResult();
                        suratDomisiliView.setAdapter(mItems);
                        suratDomisiliView.swipeRefreshFalse();
                    } else {
                        switch (response.code()) {
                            case 404:
                                Toast.makeText(context, "404 Not Found", Toast.LENGTH_SHORT).show();
                                suratDomisiliView.swipeRefreshFalse();
                                break;
                            case 500:
                                Toast.makeText(context, "500 Internal Server Error", Toast.LENGTH_SHORT).show();
                                suratDomisiliView.swipeRefreshFalse();
                                break;
                            default:
                                Toast.makeText(context, "Unknown Error", Toast.LENGTH_SHORT).show();
                                suratDomisiliView.swipeRefreshFalse();
                                break;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    suratDomisiliView.swipeRefreshFalse();
                }
            }

            @Override
            public void onFailure(Call<SuratDomisiliResponseModel> call, Throwable t) {
                suratDomisiliView.swipeRefreshFalse();

            }
        });
    }
}
