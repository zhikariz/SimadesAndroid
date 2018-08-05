package com.codelab.helmi.simades.surat.kematian;

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

public class SuratKematianPresenter implements Presenter<SuratKematianView> {
    private SuratKematianView suratKematianView;
    public List<SuratKematianData> mItems = new ArrayList<>();
    private Context context;

    public SuratKematianPresenter(Context context) {
        this.context = context;
    }

    @Override
    public void onAttach(SuratKematianView view) {
        suratKematianView = view;
    }

    @Override
    public void onDetach() {
        suratKematianView = null;
    }

    public void showData() {
        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<SuratKematianResponseModel> getData = api.getSuratKematianData();
        getData.enqueue(new Callback<SuratKematianResponseModel>() {
            @Override
            public void onResponse(Call<SuratKematianResponseModel> call, Response<SuratKematianResponseModel> response) {
                try {
                    if (response.isSuccessful()) {
                        mItems = response.body().getResult();
                        suratKematianView.setAdapter(mItems);
                        suratKematianView.swipeRefreshFalse();
                    } else {
                        switch (response.code()) {
                            case 404:
                                Toast.makeText(context, "404 Not Found", Toast.LENGTH_SHORT).show();
                                suratKematianView.swipeRefreshFalse();
                                break;
                            case 500:
                                Toast.makeText(context, "500 Internal Server Error", Toast.LENGTH_SHORT).show();
                                suratKematianView.swipeRefreshFalse();
                                break;
                            default:
                                Toast.makeText(context, "Unknown Error", Toast.LENGTH_SHORT).show();
                                suratKematianView.swipeRefreshFalse();
                                break;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    suratKematianView.swipeRefreshFalse();
                }
            }

            @Override
            public void onFailure(Call<SuratKematianResponseModel> call, Throwable t) {
                suratKematianView.swipeRefreshFalse();
            }
        });
    }
}
