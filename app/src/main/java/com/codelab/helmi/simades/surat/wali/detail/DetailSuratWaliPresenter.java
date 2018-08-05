package com.codelab.helmi.simades.surat.wali.detail;

import com.codelab.helmi.simades.helper.api.RestApi;
import com.codelab.helmi.simades.helper.api.RestServer;
import com.codelab.helmi.simades.base.Presenter;
import com.codelab.helmi.simades.surat.wali.SuratWaliData;
import com.codelab.helmi.simades.surat.wali.SuratWaliResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailSuratWaliPresenter implements Presenter<DetailSuratWaliView> {

    DetailSuratWaliView detailSuratWaliView;

    @Override
    public void onAttach(DetailSuratWaliView view) {
        detailSuratWaliView = view;
    }

    @Override
    public void onDetach() {
        detailSuratWaliView = null;
    }

    public void putStatusPersetujuan(String kdSurat, String statusPersetujuan){
        final SuratWaliData suratWaliData = new SuratWaliData();
        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<SuratWaliResponseModel> putData = api.putSuratWali(kdSurat, statusPersetujuan);
        putData.enqueue(new Callback<SuratWaliResponseModel>() {
            @Override
            public void onResponse(Call<SuratWaliResponseModel> call, Response<SuratWaliResponseModel> response) {

            }

            @Override
            public void onFailure(Call<SuratWaliResponseModel> call, Throwable t) {

            }
        });

    }
}
