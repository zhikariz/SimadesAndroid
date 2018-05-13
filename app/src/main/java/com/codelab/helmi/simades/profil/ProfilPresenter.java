package com.codelab.helmi.simades.profil;

import android.util.Log;

import com.codelab.helmi.simades.api.RestApi;
import com.codelab.helmi.simades.api.RestServer;
import com.codelab.helmi.simades.base.Presenter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

    public void showData() {
        final ProfilData profilData = new ProfilData();
        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<ProfilResponseModel> getdata = api.getProfilData();
        getdata.enqueue(new Callback<ProfilResponseModel>() {
            @Override
            public void onResponse(Call<ProfilResponseModel> call, Response<ProfilResponseModel> response) {
                mItems = response.body().getResult();
                profilData.setKode_desa(mItems.get(0).getKode_desa().toString());
                profilData.setNm_desa(mItems.get(0).getNm_desa().toString());
                profilData.setKecamatan(mItems.get(0).getKecamatan().toString());
                profilData.setKabupaten(mItems.get(0).getKabupaten().toString());
                profilData.setPropinsi(mItems.get(0).getPropinsi().toString());
                profilData.setNm_kepdes(mItems.get(0).getNm_kepdes().toString());
                profilData.setNip_kepdes(mItems.get(0).getNip_kepdes().toString());
                profilData.setAlamat_desa(mItems.get(0).getAlamat_desa().toString());
                profilData.setNo_telp(mItems.get(0).getNo_telp().toString());
                profilData.setKode_pos(mItems.get(0).getKode_pos().toString());
                profilData.setImage(mItems.get(0).getImage().toString());



                pView.onShowData(profilData);
            }

            @Override
            public void onFailure(Call<ProfilResponseModel> call, Throwable t) {

            }
        });

    }

}
