package com.codelab.helmi.simades.api;

import com.codelab.helmi.simades.datang.DatangResponseModel;
import com.codelab.helmi.simades.kelahiran.KelahiranResponseModel;
import com.codelab.helmi.simades.kematian.KematianResponseModel;
import com.codelab.helmi.simades.kk.KkResponseModel;
import com.codelab.helmi.simades.penduduk.ShowPendudukResponseModel;
import com.codelab.helmi.simades.pergi.PergiResponseModel;
import com.codelab.helmi.simades.profil.ProfilResponseModel;
import com.codelab.helmi.simades.surat.bepergian.SuratBepergianResponseModel;
import com.codelab.helmi.simades.surat.blm_menikah.SuratBlmMenikahResponseModel;
import com.codelab.helmi.simades.surat.domisili.SuratDomisiliResponseModel;
import com.codelab.helmi.simades.surat.ektp.SuratEktpResponseModel;
import com.codelab.helmi.simades.surat.kehilangan.SuratKehilanganResponseModel;
import com.codelab.helmi.simades.surat.kelahiran.SuratKelahiranResponseModel;
import com.codelab.helmi.simades.surat.kematian.SuratKematianResponseModel;
import com.codelab.helmi.simades.surat.keramaian.SuratKeramaianResponseModel;
import com.codelab.helmi.simades.surat.skck.SuratSkckResponseModel;
import com.codelab.helmi.simades.surat.tidak_mampu.SuratTidakMampuResponseModel;
import com.codelab.helmi.simades.surat.usaha.SuratUsahaResponseModel;
import com.codelab.helmi.simades.surat.wali.SuratWaliResponseModel;
import com.codelab.helmi.simades.user.UserResponseModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PUT;
import retrofit2.http.Query;

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

    @GET("api/kk")
    Call<KkResponseModel> getKkData();

    @GET("api/penduduk")
    Call<ShowPendudukResponseModel> getPendudukData(@Query("no_kk") String id);

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

    @GET("api/surat_kematian")
    Call<SuratKematianResponseModel> getSuratKematianData();

    @GET("api/surat_pengantar_skck")
    Call<SuratSkckResponseModel> getSuratPengantarSkckData();

    @GET("api/surat_wali")
    Call<SuratWaliResponseModel> getSuratWaliData();

    @GET("api/surat_blm_menikah")
    Call<SuratBlmMenikahResponseModel> getSuratBlmMenikahData();

    @GET("api/surat_izin_keramaian")
    Call<SuratKeramaianResponseModel> getSuratIzinKeramaianData();

    @GET("api/surat_bepergian")
    Call<SuratBepergianResponseModel> getSuratBepergianData();

    @GET("api/surat_kehilangan")
    Call<SuratKehilanganResponseModel> getSuratKehilanganData();

    @GET("api/surat_tidak_mampu")
    Call<SuratTidakMampuResponseModel> getSuratTidakMampuData();

    @GET("api/surat_domisili")
    Call<SuratDomisiliResponseModel> getSuratDomisiliData();

    @GET("api/surat_pengantar_ektp")
    Call<SuratEktpResponseModel> getSuratPengantarEktpData();

    @PUT("api/surat_kelahiran")
    @FormUrlEncoded
    Call<SuratKelahiranResponseModel> putSuratKelahiran(@Field("kd_surat") String kd_surat,
                                                        @Field("status_persetujuan") String status_persetujuan);

    @PUT("api/surat_usaha")
    @FormUrlEncoded
    Call<SuratUsahaResponseModel> putSuratUsaha(@Field("kd_surat") String kd_surat,
                                                @Field("status_persetujuan") String status_persetujuan);

    @PUT("api/surat_kematian")
    @FormUrlEncoded
    Call<SuratKematianResponseModel> putSuratKematian(@Field("kd_surat") String kd_surat,
                                                      @Field("status_persetujuan") String status_persetujuan);

    @PUT("api/surat_pengantar_skck")
    @FormUrlEncoded
    Call<SuratSkckResponseModel> putSuratPengantarSkck(@Field("kd_surat") String kd_surat,
                                                       @Field("status_persetujuan") String status_persetujuan);

    @PUT("api/surat_wali")
    @FormUrlEncoded
    Call<SuratWaliResponseModel> putSuratWali(@Field("kd_surat") String kd_surat,
                                              @Field("status_persetujuan") String status_persetujuan);

    @PUT("api/surat_blm_menikah")
    @FormUrlEncoded
    Call<SuratBlmMenikahResponseModel> putSuratBlmMenikah(@Field("kd_surat") String kd_surat,
                                                          @Field("status_persetujuan") String status_persetujuan);

    @PUT("api/surat_izin_keramaian")
    @FormUrlEncoded
    Call<SuratKeramaianResponseModel> putSuratIzinKeramaian(@Field("kd_surat") String kd_surat,
                                                            @Field("status_persetujuan") String status_persetujuan);

    @PUT("api/surat_bepergian")
    @FormUrlEncoded
    Call<SuratBepergianResponseModel> putSuratBepergian(@Field("kd_surat") String kd_surat,
                                                        @Field("status_persetujuan") String status_persetujuan);

    @PUT("api/surat_kehilangan")
    @FormUrlEncoded
    Call<SuratKehilanganResponseModel> putSuratKehilangan(@Field("kd_surat") String kd_surat,
                                                          @Field("status_persetujuan") String status_persetujuan);

    @PUT("api/surat_tidak_mampu")
    @FormUrlEncoded
    Call<SuratTidakMampuResponseModel> putSuratTidakMampu(@Field("kd_surat") String kd_surat,
                                                          @Field("status_persetujuan") String status_persetujuan);

    @PUT("api/surat_domisili")
    @FormUrlEncoded
    Call<SuratDomisiliResponseModel> putSuratDomisili(@Field("kd_surat") String kd_surat,
                                                      @Field("status_persetujuan") String status_persetujuan);

    @PUT("api/surat_pengantar_ektp")
    @FormUrlEncoded
    Call<SuratEktpResponseModel> putSuratPengantarEktp(@Field("kd_surat") String kd_surat,
                                                       @Field("status_persetujuan") String status_persetujuan);

}
