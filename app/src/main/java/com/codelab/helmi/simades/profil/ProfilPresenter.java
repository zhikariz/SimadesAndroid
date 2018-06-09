package com.codelab.helmi.simades.profil;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.codelab.helmi.simades.api.RestApi;
import com.codelab.helmi.simades.api.RestServer;
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
        final ProfilData profilData = new ProfilData();
        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<ProfilResponseModel> getdata = api.getProfilData();
        getdata.enqueue(new Callback<ProfilResponseModel>() {
            @Override
            public void onResponse(Call<ProfilResponseModel> call, Response<ProfilResponseModel> response) {
                try {
                    int kode = response.body().getKode();

                    mItems = response.body().getResult();
                    profilData.setKode_desa(mItems.get(0).getKode_desa());
                    profilData.setNm_desa(mItems.get(0).getNm_desa());
                    profilData.setKecamatan(mItems.get(0).getKecamatan());
                    profilData.setKabupaten(mItems.get(0).getKabupaten());
                    profilData.setPropinsi(mItems.get(0).getPropinsi());
                    profilData.setNm_kepdes(mItems.get(0).getNm_kepdes());
                    profilData.setNip_kepdes(mItems.get(0).getNip_kepdes());
                    profilData.setAlamat_desa(mItems.get(0).getAlamat_desa());
                    profilData.setNo_telp(mItems.get(0).getNo_telp());
                    profilData.setKode_pos(mItems.get(0).getKode_pos());
                    profilData.setImage(mItems.get(0).getImage());


                    pView.onShowData(profilData);
                } catch (Exception e) {
                    Toast.makeText(ctx, "Anda Tidak Terkoneksi Internet !", Toast.LENGTH_SHORT).show();
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
