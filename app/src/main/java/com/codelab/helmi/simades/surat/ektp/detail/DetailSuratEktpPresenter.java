package com.codelab.helmi.simades.surat.ektp.detail;

import com.codelab.helmi.simades.api.RestApi;
import com.codelab.helmi.simades.api.RestServer;
import com.codelab.helmi.simades.base.Presenter;
import com.codelab.helmi.simades.surat.ektp.SuratEktpData;
import com.codelab.helmi.simades.surat.ektp.SuratEktpResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailSuratEktpPresenter implements Presenter<DetailSuratEktpView>{
    DetailSuratEktpView detailSuratEktpView;
    @Override
    public void onAttach(DetailSuratEktpView view) {
        detailSuratEktpView = view;
    }

    @Override
    public void onDetach() {
        detailSuratEktpView = null;

    }

    public void putStatusPersetujuan(String kdSurat, String statusPersetujuan){
        final SuratEktpData suratEktpData = new SuratEktpData();
        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<SuratEktpResponseModel> putData = api.putSuratPengantarEktp(kdSurat, statusPersetujuan);
        putData.enqueue(new Callback<SuratEktpResponseModel>() {
            @Override
            public void onResponse(Call<SuratEktpResponseModel> call, Response<SuratEktpResponseModel> response) {

            }

            @Override
            public void onFailure(Call<SuratEktpResponseModel> call, Throwable t) {

            }
        });
    }
}
