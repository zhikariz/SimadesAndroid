package com.codelab.helmi.simades.kematian;

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

public class KematianPresenter implements Presenter<KematianView> {

    KematianView kematianView;
    Context context;
    public List<KematianData> mItems = new ArrayList<>();

    public KematianPresenter(Context context) {
        this.context = context;
    }

    @Override
    public void onAttach(KematianView view) {
        kematianView = view;
    }

    @Override
    public void onDetach() {
        kematianView = null;
    }

    public void showData() {
        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<KematianResponseModel> getData = api.getKematianData();
        getData.enqueue(new Callback<KematianResponseModel>() {
            @Override
            public void onResponse(Call<KematianResponseModel> call, Response<KematianResponseModel> response) {
                try {
                    if (response.isSuccessful()) {
                        mItems = response.body().getResult();
                        kematianView.setAdapter(mItems);
                        kematianView.swipeRefreshFalse();
                    } else {
                        switch (response.code()) {
                            case 404:
                                Toast.makeText(context, "404 Not Found", Toast.LENGTH_SHORT).show();
                                kematianView.swipeRefreshFalse();
                                break;
                            case 500:
                                Toast.makeText(context, "500 Internal Server Error", Toast.LENGTH_SHORT).show();
                                kematianView.swipeRefreshFalse();
                                break;
                            default:
                                Toast.makeText(context, "Unknown Error", Toast.LENGTH_SHORT).show();
                                kematianView.swipeRefreshFalse();
                                break;
                        }
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    kematianView.swipeRefreshFalse();
                }
            }

            @Override
            public void onFailure(Call<KematianResponseModel> call, Throwable t) {
                kematianView.swipeRefreshFalse();
            }
        });
    }
}
