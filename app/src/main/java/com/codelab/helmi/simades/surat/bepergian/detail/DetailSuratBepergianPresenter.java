package com.codelab.helmi.simades.surat.bepergian.detail;

import com.codelab.helmi.simades.api.RestApi;
import com.codelab.helmi.simades.api.RestServer;
import com.codelab.helmi.simades.base.Presenter;
import com.codelab.helmi.simades.surat.bepergian.SuratBepergianData;
import com.codelab.helmi.simades.surat.bepergian.SuratBepergianResponseModel;
import com.codelab.helmi.simades.surat.bepergian.SuratBepergianView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailSuratBepergianPresenter implements Presenter<DetailSuratBepergianView>{
    DetailSuratBepergianView detailSuratBepergianView;
    @Override
    public void onAttach(DetailSuratBepergianView view) {
        detailSuratBepergianView = view;
    }

    @Override
    public void onDetach() {
        detailSuratBepergianView = null;

    }

    public void putStatusPersetujuan(String kdSurat, String statusPersetujuan){
        final SuratBepergianData suratBepergianData = new SuratBepergianData();
        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<SuratBepergianResponseModel> putData = api.putSuratBepergian(kdSurat, statusPersetujuan);
        putData.enqueue(new Callback<SuratBepergianResponseModel>() {
            @Override
            public void onResponse(Call<SuratBepergianResponseModel> call, Response<SuratBepergianResponseModel> response) {

            }

            @Override
            public void onFailure(Call<SuratBepergianResponseModel> call, Throwable t) {

            }
        });
    }
}
