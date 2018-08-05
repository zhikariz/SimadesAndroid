package com.codelab.helmi.simades.surat.bepergian;

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

public class SuratBepergianPresenter implements Presenter<SuratBepergianView> {
    private SuratBepergianView suratBepergianView;
    private Context context;
    public List<SuratBepergianData> mItems = new ArrayList<>();

    public SuratBepergianPresenter(Context context) {
        this.context = context;
    }

    @Override
    public void onAttach(SuratBepergianView view) {
        suratBepergianView = view;
    }

    @Override
    public void onDetach() {
        suratBepergianView = null;
    }

    public void showData() {

        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<SuratBepergianResponseModel> getData = api.getSuratBepergianData();
        getData.enqueue(new Callback<SuratBepergianResponseModel>() {
            @Override
            public void onResponse(Call<SuratBepergianResponseModel> call, Response<SuratBepergianResponseModel> response) {
                try {
                    if (response.isSuccessful()) {
                        mItems = response.body().getResult();
                        suratBepergianView.setAdapter(mItems);
                        suratBepergianView.swipeRefreshFalse();
                    } else {
                        switch (response.code()) {
                            case 404:
                                Toast.makeText(context, "404 Not Found", Toast.LENGTH_SHORT).show();
                                suratBepergianView.swipeRefreshFalse();
                                break;
                            case 500:
                                Toast.makeText(context, "500 Internal Server Error", Toast.LENGTH_SHORT).show();
                                suratBepergianView.swipeRefreshFalse();
                                break;
                            default:
                                Toast.makeText(context, "Unknown Error", Toast.LENGTH_SHORT).show();
                                suratBepergianView.swipeRefreshFalse();
                                break;
                        }
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    suratBepergianView.swipeRefreshFalse();
                }
            }

            @Override
            public void onFailure(Call<SuratBepergianResponseModel> call, Throwable t) {
                suratBepergianView.swipeRefreshFalse();
            }
        });
    }
}
