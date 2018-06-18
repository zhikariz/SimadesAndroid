package com.codelab.helmi.simades.surat.kematian.detail;

import com.codelab.helmi.simades.api.RestApi;
import com.codelab.helmi.simades.api.RestServer;
import com.codelab.helmi.simades.base.Presenter;
import com.codelab.helmi.simades.surat.kematian.SuratKematianData;
import com.codelab.helmi.simades.surat.kematian.SuratKematianResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailSuratKematianPresenter implements Presenter<DetailSuratKematianView>{

    DetailSuratKematianView detailSuratKematianView;

    @Override
    public void onAttach(DetailSuratKematianView view) {
        detailSuratKematianView = view;
    }

    @Override
    public void onDetach() {
        detailSuratKematianView = null;
    }

    public void putStatusPersetujuan(String kdSurat, String statusPersetujuan){
        final SuratKematianData suratKematianData = new SuratKematianData();
        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<SuratKematianResponseModel> putData = api.putSuratKematian(kdSurat, statusPersetujuan);
        putData.enqueue(new Callback<SuratKematianResponseModel>() {
            @Override
            public void onResponse(Call<SuratKematianResponseModel> call, Response<SuratKematianResponseModel> response) {

            }

            @Override
            public void onFailure(Call<SuratKematianResponseModel> call, Throwable t) {

            }
        });
    }
}
