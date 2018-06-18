package com.codelab.helmi.simades.surat.usaha.detail;

import com.codelab.helmi.simades.api.RestApi;
import com.codelab.helmi.simades.api.RestServer;
import com.codelab.helmi.simades.base.Presenter;
import com.codelab.helmi.simades.surat.usaha.SuratUsahaData;
import com.codelab.helmi.simades.surat.usaha.SuratUsahaResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailSuratUsahaPresenter implements Presenter<DetailSuratUsahaView> {
    DetailSuratUsahaView detailSuratUsahaView;
    @Override
    public void onAttach(DetailSuratUsahaView view) {
        detailSuratUsahaView = view;
    }

    @Override
    public void onDetach() {
        detailSuratUsahaView = null;
    }

    public void putStatusPersetujuan(String kdSurat, String statusPersetujuan){
        final SuratUsahaData suratUsahaData = new SuratUsahaData();
        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<SuratUsahaResponseModel> putData = api.putSuratUsaha(kdSurat, statusPersetujuan);
        putData.enqueue(new Callback<SuratUsahaResponseModel>() {
            @Override
            public void onResponse(Call<SuratUsahaResponseModel> call, Response<SuratUsahaResponseModel> response) {

            }

            @Override
            public void onFailure(Call<SuratUsahaResponseModel> call, Throwable t) {

            }
        });
    }
}
