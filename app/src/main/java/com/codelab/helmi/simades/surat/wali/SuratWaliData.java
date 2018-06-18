package com.codelab.helmi.simades.surat.wali;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class SuratWaliData implements Parcelable {

    @SerializedName("id_surat")
    private String id_surat;
    @SerializedName("kd_surat")
    private String kd_surat;
    @SerializedName("no_surat")
    private String no_surat;
    @SerializedName("tgl_surat")
    private String tgl_surat;
    @SerializedName("status_persetujuan")
    private String status_persetujuan;
    @SerializedName("nik")
    private String nik;
    @SerializedName("nik_perempuan")
    private String nik_perempuan;
    @SerializedName("nik_laki")
    private String nik_laki;
    @SerializedName("alasan")
    private String alasan;
    @SerializedName("nama_depan_wali")
    private String nama_depan_wali;
    @SerializedName("nama_belakang_wali")
    private String nama_belakang_wali;
    @SerializedName("nama_depan_perempuan")
    private String nama_depan_perempuan;
    @SerializedName("nama_belakang_perempuan")
    private String nama_belakang_perempuan;
    @SerializedName("nama_depan_laki")
    private String nama_depan_laki;
    @SerializedName("nama_belakang_laki")
    private String nama_belakang_laki;
    @SerializedName("nama_depan_user")
    private String nama_depan_user;
    @SerializedName("nama_belakang_user")
    private String nama_belakang_user;

    public String getId_surat() {
        return id_surat;
    }

    public void setId_surat(String id_surat) {
        this.id_surat = id_surat;
    }

    public String getKd_surat() {
        return kd_surat;
    }

    public void setKd_surat(String kd_surat) {
        this.kd_surat = kd_surat;
    }

    public String getNo_surat() {
        return no_surat;
    }

    public void setNo_surat(String no_surat) {
        this.no_surat = no_surat;
    }

    public String getTgl_surat() {
        return tgl_surat;
    }

    public void setTgl_surat(String tgl_surat) {
        this.tgl_surat = tgl_surat;
    }

    public String getStatus_persetujuan() {
        return status_persetujuan;
    }

    public void setStatus_persetujuan(String status_persetujuan) {
        this.status_persetujuan = status_persetujuan;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNik_perempuan() {
        return nik_perempuan;
    }

    public void setNik_perempuan(String nik_perempuan) {
        this.nik_perempuan = nik_perempuan;
    }

    public String getNik_laki() {
        return nik_laki;
    }

    public void setNik_laki(String nik_laki) {
        this.nik_laki = nik_laki;
    }

    public String getAlasan() {
        return alasan;
    }

    public void setAlasan(String alasan) {
        this.alasan = alasan;
    }

    public String getNama_depan_wali() {
        return nama_depan_wali;
    }

    public void setNama_depan_wali(String nama_depan_wali) {
        this.nama_depan_wali = nama_depan_wali;
    }

    public String getNama_belakang_wali() {
        return nama_belakang_wali;
    }

    public void setNama_belakang_wali(String nama_belakang_wali) {
        this.nama_belakang_wali = nama_belakang_wali;
    }

    public String getNama_depan_perempuan() {
        return nama_depan_perempuan;
    }

    public void setNama_depan_perempuan(String nama_depan_perempuan) {
        this.nama_depan_perempuan = nama_depan_perempuan;
    }

    public String getNama_belakang_perempuan() {
        return nama_belakang_perempuan;
    }

    public void setNama_belakang_perempuan(String nama_belakang_perempuan) {
        this.nama_belakang_perempuan = nama_belakang_perempuan;
    }

    public String getNama_depan_laki() {
        return nama_depan_laki;
    }

    public void setNama_depan_laki(String nama_depan_laki) {
        this.nama_depan_laki = nama_depan_laki;
    }

    public String getNama_belakang_laki() {
        return nama_belakang_laki;
    }

    public void setNama_belakang_laki(String nama_belakang_laki) {
        this.nama_belakang_laki = nama_belakang_laki;
    }

    public String getNama_depan_user() {
        return nama_depan_user;
    }

    public void setNama_depan_user(String nama_depan_user) {
        this.nama_depan_user = nama_depan_user;
    }

    public String getNama_belakang_user() {
        return nama_belakang_user;
    }

    public void setNama_belakang_user(String nama_belakang_user) {
        this.nama_belakang_user = nama_belakang_user;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id_surat);
        dest.writeString(this.kd_surat);
        dest.writeString(this.no_surat);
        dest.writeString(this.tgl_surat);
        dest.writeString(this.status_persetujuan);
        dest.writeString(this.nik);
        dest.writeString(this.nik_perempuan);
        dest.writeString(this.nik_laki);
        dest.writeString(this.alasan);
        dest.writeString(this.nama_depan_wali);
        dest.writeString(this.nama_belakang_wali);
        dest.writeString(this.nama_depan_perempuan);
        dest.writeString(this.nama_belakang_perempuan);
        dest.writeString(this.nama_depan_laki);
        dest.writeString(this.nama_belakang_laki);
        dest.writeString(this.nama_depan_user);
        dest.writeString(this.nama_belakang_user);
    }

    public SuratWaliData() {
    }

    protected SuratWaliData(Parcel in) {
        this.id_surat = in.readString();
        this.kd_surat = in.readString();
        this.no_surat = in.readString();
        this.tgl_surat = in.readString();
        this.status_persetujuan = in.readString();
        this.nik = in.readString();
        this.nik_perempuan = in.readString();
        this.nik_laki = in.readString();
        this.alasan = in.readString();
        this.nama_depan_wali = in.readString();
        this.nama_belakang_wali = in.readString();
        this.nama_depan_perempuan = in.readString();
        this.nama_belakang_perempuan = in.readString();
        this.nama_depan_laki = in.readString();
        this.nama_belakang_laki = in.readString();
        this.nama_depan_user = in.readString();
        this.nama_belakang_user = in.readString();
    }

    public static final Parcelable.Creator<SuratWaliData> CREATOR = new Parcelable.Creator<SuratWaliData>() {
        @Override
        public SuratWaliData createFromParcel(Parcel source) {
            return new SuratWaliData(source);
        }

        @Override
        public SuratWaliData[] newArray(int size) {
            return new SuratWaliData[size];
        }
    };
}
