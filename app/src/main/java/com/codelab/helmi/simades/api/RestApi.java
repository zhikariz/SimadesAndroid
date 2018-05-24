package com.codelab.helmi.simades.api;

import com.codelab.helmi.simades.datang.DatangResponseModel;
import com.codelab.helmi.simades.kelahiran.KelahiranResponseModel;
import com.codelab.helmi.simades.kematian.KematianResponseModel;
import com.codelab.helmi.simades.penduduk.PendudukResponseModel;
import com.codelab.helmi.simades.pergi.PergiResponseModel;
import com.codelab.helmi.simades.profil.ProfilData;
import com.codelab.helmi.simades.profil.ProfilResponseModel;
import com.codelab.helmi.simades.surat.kelahiran.SuratKelahiranResponseModel;
import com.codelab.helmi.simades.surat.usaha.SuratUsahaResponseModel;
import com.codelab.helmi.simades.user.UserResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface RestApi {
    @Headers({
            "Content-Type: application/x-www-form-urlencoded"
    })

    @GET("api/profil_desa")
    Call<ProfilResponseModel> getProfilData();

    @GET("api/user")
    Call<UserResponseModel> getUserData();

    @GET("api/kelahiran")
    Call<KelahiranResponseModel> getKelahiranData();

    @GET("api/penduduk")
    Call<PendudukResponseModel> getPendudukData();

    @GET("api/kematian")
    Call<KematianResponseModel> getKematianData();

    @GET("api/pergi")
    Call<PergiResponseModel> getPergiData();

    @GET("api/datang")
    Call<DatangResponseModel> getDatangData();

    @GET("api/surat_kelahiran")
    Call<SuratKelahiranResponseModel> getSuratKelahiranData();

    @GET("api/surat_usaha")
    Call<SuratUsahaResponseModel> getSuratUsahaData();

}
