package com.codelab.helmi.simades.surat.tidak_mampu.detail;

import com.codelab.helmi.simades.helper.api.RestApi;
import com.codelab.helmi.simades.helper.api.RestServer;
import com.codelab.helmi.simades.base.Presenter;
import com.codelab.helmi.simades.surat.tidak_mampu.SuratTidakMampuData;
import com.codelab.helmi.simades.surat.tidak_mampu.SuratTidakMampuResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailSuratTidakMampuPresenter implements Presenter<DetailSuratTidakMampuView>{
    DetailSuratTidakMampuView detailSuratTidakMampuView;
    @Override
    public void onAttach(DetailSuratTidakMampuView view) {
        detailSuratTidakMampuView = view;
    }

    @Override
    public void onDetach() {
        detailSuratTidakMampuView = null;
    }

    public void putStatusPersetujuan(String kdSurat, String statusPersetujuan){
        final SuratTidakMampuData suratTidakMampuData = new SuratTidakMampuData();
        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<SuratTidakMampuResponseModel> putData = api.putSuratTidakMampu(kdSurat, statusPersetujuan);
        putData.enqueue(new Callback<SuratTidakMampuResponseModel>() {
            @Override
            public void onResponse(Call<SuratTidakMampuResponseModel> call, Response<SuratTidakMampuResponseModel> response) {

            }

            @Override
            public void onFailure(Call<SuratTidakMampuResponseModel> call, Throwable t) {

            }
        });
    }
}
