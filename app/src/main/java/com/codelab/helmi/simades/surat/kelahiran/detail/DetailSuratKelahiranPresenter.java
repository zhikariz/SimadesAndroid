package com.codelab.helmi.simades.surat.kelahiran.detail;

import com.codelab.helmi.simades.helper.api.RestApi;
import com.codelab.helmi.simades.helper.api.RestServer;
import com.codelab.helmi.simades.base.Presenter;
import com.codelab.helmi.simades.surat.kelahiran.SuratKelahiranData;
import com.codelab.helmi.simades.surat.kelahiran.SuratKelahiranResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailSuratKelahiranPresenter implements Presenter<DetailSuratKelahiranView> {

    DetailSuratKelahiranView detailSuratKelahiranView;

    @Override
    public void onAttach(DetailSuratKelahiranView view) {
        detailSuratKelahiranView = view;
    }

    @Override
    public void onDetach() {
        detailSuratKelahiranView = null;
    }

    public void putStatusPersetujuan(String kdSurat, String statusPersetujuan){
            final SuratKelahiranData suratKelahiranData = new SuratKelahiranData();
            RestApi api = RestServer.getClient().create(RestApi.class);
            Call<SuratKelahiranResponseModel> putData = api.putSuratKelahiran(kdSurat, statusPersetujuan);
            putData.enqueue(new Callback<SuratKelahiranResponseModel>() {
                @Override
                public void onResponse(Call<SuratKelahiranResponseModel> call, Response<SuratKelahiranResponseModel> response) {
                }

                @Override
                public void onFailure(Call<SuratKelahiranResponseModel> call, Throwable t) {
                }
                });
    }
}
