package com.codelab.helmi.simades.kk;


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

public class KkPresenter implements Presenter<KkView> {

    List<KkData> mItems = new ArrayList<>();
    Context context;
    private KkView kkView;

    public KkPresenter(Context context) {
        this.context = context;
    }

    @Override
    public void onAttach(KkView view) {
        kkView = view;
    }

    @Override
    public void onDetach() {
        kkView = null;
    }

    public void showData() {
        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<KkResponseModel> getData = api.getKkData();


        getData.enqueue(new Callback<KkResponseModel>() {
            @Override
            public void onResponse(Call<KkResponseModel> call, Response<KkResponseModel> response) {
                try {
                    if (response.isSuccessful()) {
                        mItems = response.body().getResult();
                        kkView.setAdapter(mItems);
                        kkView.swipeRefreshFalse();
                    } else {
                        switch (response.code()) {
                            case 404:
                                Toast.makeText(context, "404 Not Found", Toast.LENGTH_SHORT).show();
                                kkView.swipeRefreshFalse();
                                break;
                            case 500:
                                Toast.makeText(context, "500 Internal Server Error", Toast.LENGTH_SHORT).show();
                                kkView.swipeRefreshFalse();
                                break;
                            default:
                                Toast.makeText(context, "Unknown Error", Toast.LENGTH_SHORT).show();
                                kkView.swipeRefreshFalse();
                                break;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    kkView.swipeRefreshFalse();
                }
            }

            @Override
            public void onFailure(Call<KkResponseModel> call, Throwable t) {
                Toast.makeText(context, "Gagal Mendapatkan Data", Toast.LENGTH_SHORT).show();
                kkView.swipeRefreshFalse();
            }
        });
    }
}
