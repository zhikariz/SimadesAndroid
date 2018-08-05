package com.codelab.helmi.simades.surat.tidak_mampu;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class SuratTidakMampuData implements Parcelable {
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
    @SerializedName("nik_wali")
    private String nik_wali;
    @SerializedName("nik")
    private String nik;
    @SerializedName("sekolah")
    private String sekolah;
    @SerializedName("kelas")
    private String kelas;
    @SerializedName("jurusan")
    private String jurusan;
    @SerializedName("nama_depan")
    private String nama_depan;
    @SerializedName("nama_belakang")
    private String nama_belakang;
    @SerializedName("nama_depan_wali")
    private String nama_depan_wali;
    @SerializedName("nama_belakang_wali")
    private String nama_belakang_wali;
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

    public String getNik_wali() {
        return nik_wali;
    }

    public void setNik_wali(String nik_wali) {
        this.nik_wali = nik_wali;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getSekolah() {
        return sekolah;
    }

    public void setSekolah(String sekolah) {
        this.sekolah = sekolah;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
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
        dest.writeString(this.nik_wali);
        dest.writeString(this.nik);
        dest.writeString(this.sekolah);
        dest.writeString(this.kelas);
        dest.writeString(this.jurusan);
        dest.writeString(this.nama_depan);
        dest.writeString(this.nama_belakang);
        dest.writeString(this.nama_depan_wali);
        dest.writeString(this.nama_belakang_wali);
        dest.writeString(this.nama_depan_user);
        dest.writeString(this.nama_belakang_user);
    }

    public SuratTidakMampuData() {
    }

    protected SuratTidakMampuData(Parcel in) {
        this.id_surat = in.readString();
        this.kd_surat = in.readString();
        this.no_surat = in.readString();
        this.tgl_surat = in.readString();
        this.status_persetujuan = in.readString();
        this.nik_wali = in.readString();
        this.nik = in.readString();
        this.sekolah = in.readString();
        this.kelas = in.readString();
        this.jurusan = in.readString();
        this.nama_depan = in.readString();
        this.nama_belakang = in.readString();
        this.nama_depan_wali = in.readString();
        this.nama_belakang_wali = in.readString();
        this.nama_depan_user = in.readString();
        this.nama_belakang_user = in.readString();
    }

    public static final Parcelable.Creator<SuratTidakMampuData> CREATOR = new Parcelable.Creator<SuratTidakMampuData>() {
        @Override
        public SuratTidakMampuData createFromParcel(Parcel source) {
            return new SuratTidakMampuData(source);
        }

        @Override
        public SuratTidakMampuData[] newArray(int size) {
            return new SuratTidakMampuData[size];
        }
    };
}
