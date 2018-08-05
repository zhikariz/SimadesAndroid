package com.codelab.helmi.simades.surat.tidak_mampu;

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

public class SuratTidakMampuPresenter implements Presenter<SuratTidakMampuView> {
    private SuratTidakMampuView suratTidakMampuView;
    List<SuratTidakMampuData> mItems = new ArrayList<>();
    Context context;

    public SuratTidakMampuPresenter(Context context) {
        this.context = context;
    }

    @Override
    public void onAttach(SuratTidakMampuView view) {
        suratTidakMampuView = view;
    }

    @Override
    public void onDetach() {
        suratTidakMampuView = null;
    }

    public void showData() {


        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<SuratTidakMampuResponseModel> getData = api.getSuratTidakMampuData();
        getData.enqueue(new Callback<SuratTidakMampuResponseModel>() {
            @Override
            public void onResponse(Call<SuratTidakMampuResponseModel> call, Response<SuratTidakMampuResponseModel> response) {
                if (response.isSuccessful()) {
                    mItems = response.body().getResult();
                    suratTidakMampuView.setAdapter(mItems);
                    suratTidakMampuView.swipeRefreshFalse();
                }else{
                    switch (response.code()) {
                        case 404:
                            Toast.makeText(context, "404 Not Found", Toast.LENGTH_SHORT).show();
                            suratTidakMampuView.swipeRefreshFalse();
                            break;
                        case 500:
                            Toast.makeText(context, "500 Internal Server Error", Toast.LENGTH_SHORT).show();
                            suratTidakMampuView.swipeRefreshFalse();
                            break;
                        default:
                            Toast.makeText(context, "Unknown Error", Toast.LENGTH_SHORT).show();
                            suratTidakMampuView.swipeRefreshFalse();
                            break;
                    }
                }
            }

            @Override
            public void onFailure(Call<SuratTidakMampuResponseModel> call, Throwable t) {
                suratTidakMampuView.swipeRefreshFalse();

            }
        });
    }
}
