package com.codelab.helmi.simades.surat.bepergian;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class SuratBepergianData implements Parcelable {
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
    @SerializedName("tempat_tujuan")
    private String tempat_tujuan;
    @SerializedName("keperluan")
    private String keperluan;
    @SerializedName("nama_depan")
    private String nama_depan;
    @SerializedName("nama_belakang")
    private String nama_belakang;
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

    public String getTempat_tujuan() {
        return tempat_tujuan;
    }

    public void setTempat_tujuan(String tempat_tujuan) {
        this.tempat_tujuan = tempat_tujuan;
    }

    public String getKeperluan() {
        return keperluan;
    }

    public void setKeperluan(String keperluan) {
        this.keperluan = keperluan;
    }

    public String getNama_depan() {
        return nama_depan;
    }

    public void setNama_depan(String nama_depan) {
        this.nama_depan = nama_depan;
    }

    public String getNama_belakang() {
        return nama_belakang;
    }

    public void setNama_belakang(String nama_belakang) {
        this.nama_belakang = nama_belakang;
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
        dest.writeString(this.tempat_tujuan);
        dest.writeString(this.keperluan);
        dest.writeString(this.nama_depan);
        dest.writeString(this.nama_belakang);
        dest.writeString(this.nama_depan_user);
        dest.writeString(this.nama_belakang_user);
    }

    public SuratBepergianData() {
    }

    protected SuratBepergianData(Parcel in) {
        this.id_surat = in.readString();
        this.kd_surat = in.readString();
        this.no_surat = in.readString();
        this.tgl_surat = in.readString();
        this.status_persetujuan = in.readString();
        this.nik = in.readString();
        this.tempat_tujuan = in.readString();
        this.keperluan = in.readString();
        this.nama_depan = in.readString();
        this.nama_belakang = in.readString();
        this.nama_depan_user = in.readString();
        this.nama_belakang_user = in.readString();
    }

    public static final Parcelable.Creator<SuratBepergianData> CREATOR = new Parcelable.Creator<SuratBepergianData>() {
        @Override
        public SuratBepergianData createFromParcel(Parcel source) {
            return new SuratBepergianData(source);
        }

        @Override
        public SuratBepergianData[] newArray(int size) {
            return new SuratBepergianData[size];
        }
    };
}
