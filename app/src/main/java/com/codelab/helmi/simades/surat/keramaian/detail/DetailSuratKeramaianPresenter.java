package com.codelab.helmi.simades.surat.keramaian.detail;

import com.codelab.helmi.simades.helper.api.RestApi;
import com.codelab.helmi.simades.helper.api.RestServer;
import com.codelab.helmi.simades.base.Presenter;
import com.codelab.helmi.simades.surat.keramaian.SuratKeramaianData;
import com.codelab.helmi.simades.surat.keramaian.SuratKeramaianResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailSuratKeramaianPresenter implements Presenter<DetailSuratKeramaianView>{
    DetailSuratKeramaianView detailSuratKeramaianView;
    @Override
    public void onAttach(DetailSuratKeramaianView view) {
        detailSuratKeramaianView = view;
    }

    @Override
    public void onDetach() {
        detailSuratKeramaianView = null;

    }

    public void putStatusPersetujuan(String kdSurat, String statusPersetujuan){
        final SuratKeramaianData suratKeramaianData = new SuratKeramaianData();
        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<SuratKeramaianResponseModel> putData = api.putSuratIzinKeramaian(kdSurat,statusPersetujuan);
        putData.enqueue(new Callback<SuratKeramaianResponseModel>() {
            @Override
            public void onResponse(Call<SuratKeramaianResponseModel> call, Response<SuratKeramaianResponseModel> response) {

            }

            @Override
            public void onFailure(Call<SuratKeramaianResponseModel> call, Throwable t) {

            }
        });
    }
}
