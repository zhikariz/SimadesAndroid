package com.codelab.helmi.simades.profil;

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
import timber.log.Timber;

public class ProfilPresenter implements Presenter<ProfilView> {

    private ProfilView pView;
    public List<ProfilData> mItems = new ArrayList<>();


    @Override
    public void onAttach(ProfilView view) {
        pView = view;
    }

    @Override
    public void onDetach() {
        pView = null;
    }

    public void showData(final Context ctx) {
        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<ProfilResponseModel> getdata = api.getProfilData();
        getdata.enqueue(new Callback<ProfilResponseModel>() {
            @Override
            public void onResponse(Call<ProfilResponseModel> call, Response<ProfilResponseModel> response) {
                try {
                    if (response.isSuccessful()) {
                        mItems = response.body().getResult();
                        pView.onShowData(mItems);
                    } else {
                        switch (response.code()) {
                            case 404:
                                Toast.makeText(ctx, "404 Not Found", Toast.LENGTH_SHORT).show();
                                break;
                            case 500:
                                Toast.makeText(ctx, "500 Internal Server Error", Toast.LENGTH_SHORT).show();
                                break;
                            default:
                                Toast.makeText(ctx, "Unknown Error", Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ProfilResponseModel> call, Throwable t) {
                Timber.d(t);
            }
        });

    }

}
