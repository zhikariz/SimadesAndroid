package com.codelab.helmi.simades.surat.blm_menikah.detail;

import com.codelab.helmi.simades.helper.api.RestApi;
import com.codelab.helmi.simades.helper.api.RestServer;
import com.codelab.helmi.simades.base.Presenter;
import com.codelab.helmi.simades.surat.blm_menikah.SuratBlmMenikahData;
import com.codelab.helmi.simades.surat.blm_menikah.SuratBlmMenikahResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailSuratBlmMenikahPresenter implements Presenter<DetailSuratBlmMenikahView>{
    DetailSuratBlmMenikahView detailSuratBlmMenikahView;
    @Override
    public void onAttach(DetailSuratBlmMenikahView view) {
        detailSuratBlmMenikahView = view;

    }

    @Override
    public void onDetach() {
        detailSuratBlmMenikahView = null;

    }

    public void putStatusPersetujuan(String kdSurat, String statusPersetujuan){
        final SuratBlmMenikahData suratBlmMenikahData = new SuratBlmMenikahData();
        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<SuratBlmMenikahResponseModel> putData = api.putSuratBlmMenikah(kdSurat, statusPersetujuan);
        putData.enqueue(new Callback<SuratBlmMenikahResponseModel>() {
            @Override
            public void onResponse(Call<SuratBlmMenikahResponseModel> call, Response<SuratBlmMenikahResponseModel> response) {

            }

            @Override
            public void onFailure(Call<SuratBlmMenikahResponseModel> call, Throwable t) {

            }
        });
    }
}
