package com.codelab.helmi.simades.penduduk;


import android.content.Context;
import android.widget.Toast;

import com.codelab.helmi.simades.api.RestApi;
import com.codelab.helmi.simades.api.RestServer;
import com.codelab.helmi.simades.base.Presenter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowPendudukPresenter implements Presenter<PendudukView> {
    public List<PendudukData> mItems = new ArrayList<>();
    private PendudukView pendudukView;
    private Context context;

    public ShowPendudukPresenter(Context context) {
        this.context = context;
    }

    @Override
    public void onAttach(PendudukView view) {
        pendudukView = view;
    }

    @Override
    public void onDetach() {
        pendudukView = null;
    }

    public void showData(String no_kk) {
        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<ShowPendudukResponseModel> getData = api.getPendudukData(no_kk);
        getData.enqueue(new Callback<ShowPendudukResponseModel>() {
            @Override
            public void onResponse(Call<ShowPendudukResponseModel> call, Response<ShowPendudukResponseModel> response) {
                try {
                    if (response.isSuccessful()) {
                        mItems = response.body().getResult();
                        pendudukView.setAdapter(mItems);
                        pendudukView.swipeRefreshFalse();
                    } else {
                        switch (response.code()) {
                            case 404:
                                Toast.makeText(context, "404 Not Found", Toast.LENGTH_SHORT).show();
                                pendudukView.swipeRefreshFalse();
                                break;
                            case 500:
                                Toast.makeText(context, "500 Internal Server Error", Toast.LENGTH_SHORT).show();
                                pendudukView.swipeRefreshFalse();
                                break;
                            default:
                                Toast.makeText(context, "Unknown Error", Toast.LENGTH_SHORT).show();
                                pendudukView.swipeRefreshFalse();
                                break;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    pendudukView.swipeRefreshFalse();
                }
            }

            @Override
            public void onFailure(Call<ShowPendudukResponseModel> call, Throwable t) {
                Toast.makeText(context, "Gagal Mendapatkan Data", Toast.LENGTH_SHORT).show();
                pendudukView.swipeRefreshFalse();
            }
        });
    }
}
