package com.codelab.helmi.simades.surat.domisili.detail;

import com.codelab.helmi.simades.helper.api.RestApi;
import com.codelab.helmi.simades.helper.api.RestServer;
import com.codelab.helmi.simades.base.Presenter;
import com.codelab.helmi.simades.surat.domisili.SuratDomisiliData;
import com.codelab.helmi.simades.surat.domisili.SuratDomisiliResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailSuratDomisiliPresenter implements Presenter<DetailSuratDomisiliView>{
    DetailSuratDomisiliView detailSuratDomisiliView;
    @Override
    public void onAttach(DetailSuratDomisiliView view) {
        detailSuratDomisiliView = view;

    }

    @Override
    public void onDetach() {
        detailSuratDomisiliView = null;

    }

    public void putStatusPersetujuan(String kdSurat, String statusPersetujuan){
        final SuratDomisiliData suratDomisiliData = new SuratDomisiliData();
        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<SuratDomisiliResponseModel> putData = api.putSuratDomisili(kdSurat, statusPersetujuan);
        putData.enqueue(new Callback<SuratDomisiliResponseModel>() {
            @Override
            public void onResponse(Call<SuratDomisiliResponseModel> call, Response<SuratDomisiliResponseModel> response) {

            }

            @Override
            public void onFailure(Call<SuratDomisiliResponseModel> call, Throwable t) {

            }
        });
    }
}
