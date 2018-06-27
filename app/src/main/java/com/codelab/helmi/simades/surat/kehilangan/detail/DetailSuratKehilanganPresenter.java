package com.codelab.helmi.simades.surat.kehilangan.detail;

import com.codelab.helmi.simades.api.RestApi;
import com.codelab.helmi.simades.api.RestServer;
import com.codelab.helmi.simades.base.Presenter;
import com.codelab.helmi.simades.surat.kehilangan.SuratKehilanganData;
import com.codelab.helmi.simades.surat.kehilangan.SuratKehilanganResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailSuratKehilanganPresenter implements Presenter<DetailSuratKehilanganView>{
    DetailSuratKehilanganView detailSuratKehilanganView;

    @Override
    public void onAttach(DetailSuratKehilanganView view) {
    detailSuratKehilanganView = view;
    }

    @Override
    public void onDetach() {
        detailSuratKehilanganView = null;
    }

    public void putStatusPersetujuan(String kdSurat, String statusPersetujuan){
        final SuratKehilanganData suratKehilanganData = new SuratKehilanganData();
        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<SuratKehilanganResponseModel> putData = api.putSuratKehilangan(kdSurat, statusPersetujuan);
        putData.enqueue(new Callback<SuratKehilanganResponseModel>() {
            @Override
            public void onResponse(Call<SuratKehilanganResponseModel> call, Response<SuratKehilanganResponseModel> response) {

            }

            @Override
            public void onFailure(Call<SuratKehilanganResponseModel> call, Throwable t) {

            }
        });
    }
}
