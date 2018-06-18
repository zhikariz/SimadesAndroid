package com.codelab.helmi.simades.surat.skck.detail;

import com.codelab.helmi.simades.api.RestApi;
import com.codelab.helmi.simades.api.RestServer;
import com.codelab.helmi.simades.base.Presenter;
import com.codelab.helmi.simades.surat.skck.SuratSkckData;
import com.codelab.helmi.simades.surat.skck.SuratSkckResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailSuratSkckPresenter implements Presenter<DetailSuratSkckView> {

    DetailSuratSkckView detailSuratSkckView;

    public void onAttach(DetailSuratSkckView view) {
        detailSuratSkckView = view;
    }

    @Override
    public void onDetach() {
        detailSuratSkckView = null;
    }

    public void putStatusPersetujuan(String kdSurat, String statusPersetujuan){
        final SuratSkckData suratSkckData = new SuratSkckData();
        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<SuratSkckResponseModel> putData = api.putSuratPengantarSkck(kdSurat, statusPersetujuan);
        putData.enqueue(new Callback<SuratSkckResponseModel>() {
            @Override
            public void onResponse(Call<SuratSkckResponseModel> call, Response<SuratSkckResponseModel> response) {

            }

            @Override
            public void onFailure(Call<SuratSkckResponseModel> call, Throwable t) {

            }
        });
    }
}
