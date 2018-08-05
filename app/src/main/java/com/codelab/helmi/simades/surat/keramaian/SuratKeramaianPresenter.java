package com.codelab.helmi.simades.surat.keramaian;

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

public class SuratKeramaianPresenter implements Presenter<SuratKeramaianView> {
    private SuratKeramaianView suratKeramaianView;
    public List<SuratKeramaianData> mItems = new ArrayList<>();
    private Context context;

    public SuratKeramaianPresenter(Context context) {
        this.context = context;
    }

    @Override
    public void onAttach(SuratKeramaianView view) {
        suratKeramaianView = view;
    }

    @Override
    public void onDetach() {
        suratKeramaianView = null;
    }

    public void showData() {
        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<SuratKeramaianResponseModel> getData = api.getSuratIzinKeramaianData();
        getData.enqueue(new Callback<SuratKeramaianResponseModel>() {
            @Override
            public void onResponse(Call<SuratKeramaianResponseModel> call, Response<SuratKeramaianResponseModel> response) {
                try {
                    if (response.isSuccessful()) {
                        mItems = response.body().getResult();
                        suratKeramaianView.setAdapter(mItems);
                        suratKeramaianView.swipeRefreshFalse();
                    } else {
                        switch (response.code()) {
                            case 404:
                                Toast.makeText(context, "404 Not Found", Toast.LENGTH_SHORT).show();
                                suratKeramaianView.swipeRefreshFalse();
                                break;
                            case 500:
                                Toast.makeText(context, "500 Internal Server Error", Toast.LENGTH_SHORT).show();
                                suratKeramaianView.swipeRefreshFalse();
                                break;
                            default:
                                Toast.makeText(context, "Unknown Error", Toast.LENGTH_SHORT).show();
                                suratKeramaianView.swipeRefreshFalse();
                                break;
                        }
                    }
                } catch (Exception e){
                    e.printStackTrace();
                    suratKeramaianView.swipeRefreshFalse();
                }
            }

            @Override
            public void onFailure(Call<SuratKeramaianResponseModel> call, Throwable t) {
                suratKeramaianView.swipeRefreshFalse();
            }
        });
    }
}
