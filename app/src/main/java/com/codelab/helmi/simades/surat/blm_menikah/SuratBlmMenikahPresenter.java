package com.codelab.helmi.simades.surat.blm_menikah;

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

public class SuratBlmMenikahPresenter implements Presenter<SuratBlmMenikahView> {
    private SuratBlmMenikahView suratBlmMenikahView;
    public List<SuratBlmMenikahData> mItems = new ArrayList<>();
    Context context;

    public SuratBlmMenikahPresenter(Context context) {
        this.context = context;
    }

    @Override
    public void onAttach(SuratBlmMenikahView view) {
        suratBlmMenikahView = view;
    }

    @Override
    public void onDetach() {
        suratBlmMenikahView = null;
    }

    public void showData() {
        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<SuratBlmMenikahResponseModel> getData = api.getSuratBlmMenikahData();
        getData.enqueue(new Callback<SuratBlmMenikahResponseModel>() {
            @Override
            public void onResponse(Call<SuratBlmMenikahResponseModel> call, Response<SuratBlmMenikahResponseModel> response) {
                try {
                    if (response.isSuccessful()) {
                        mItems = response.body().getResult();
                        suratBlmMenikahView.setAdapter(mItems);
                        suratBlmMenikahView.swipeRefreshFalse();
                    } else {
                        switch (response.code()) {
                            case 404:
                                Toast.makeText(context, "404 Not Found", Toast.LENGTH_SHORT).show();
                                suratBlmMenikahView.swipeRefreshFalse();
                                break;
                            case 500:
                                Toast.makeText(context, "500 Internal Server Error", Toast.LENGTH_SHORT).show();
                                suratBlmMenikahView.swipeRefreshFalse();
                                break;
                            default:
                                Toast.makeText(context, "Unknown Error", Toast.LENGTH_SHORT).show();
                                suratBlmMenikahView.swipeRefreshFalse();
                                break;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    suratBlmMenikahView.swipeRefreshFalse();
                }
            }

            @Override
            public void onFailure(Call<SuratBlmMenikahResponseModel> call, Throwable t) {
                suratBlmMenikahView.swipeRefreshFalse();
            }
        });
    }
}
