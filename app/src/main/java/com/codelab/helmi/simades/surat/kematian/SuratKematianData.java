package com.codelab.helmi.simades.surat.kematian;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class SuratKematianData implements Parcelable {

    @SerializedName("id_surat")
    private String id_surat;
    @SerializedName("kd_surat")
    private String kd_surat;
    @SerializedName("no_surat")
    private String no_surat;
    @SerializedName("tgl_surat")
    private String tgl_surat;
    @SerializedName("waktu")
    private String waktu;
    @SerializedName("status_persetujuan")
    private String status_persetujuan;
    @SerializedName("nik")
    private String nik;
    @SerializedName("nik_meninggal")
    private String nik_meninggal;
    @SerializedName("nama_saksi1")
    private String nama_saksi1;
    @SerializedName("umur_saksi1")
    private String umur_saksi1;
    @SerializedName("alamat_saksi1")
    private String alamat_saksi1;
    @SerializedName("nama_saksi2")
    private String nama_saksi2;
    @SerializedName("umur_saksi2")
    private String umur_saksi2;
    @SerializedName("alamat_saksi2")
    private String alamat_saksi2;
    @SerializedName("hari_meninggal")
    private String hari_meninggal;
    @SerializedName("tgl_meninggal")
    private String tgl_meninggal;
    @SerializedName("sebab_meninggal")
    private String sebab_meninggal;
    @SerializedName("nama_depan_pengaju")
    private String nama_depan_pengaju;
    @SerializedName("nama_belakang_pengaju")
    private String nama_belakang_pengaju;
    @SerializedName("nama_depan_meninggal")
    private String nama_depan_meninggal;
    @SerializedName("nama_belakang_meninggal")
    private String nama_belakang_meninggal;
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

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
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

    public String getNik_meninggal() {
        return nik_meninggal;
    }

    public void setNik_meninggal(String nik_meninggal) {
        this.nik_meninggal = nik_meninggal;
    }

    public String getNama_saksi1() {
        return nama_saksi1;
    }

    public void setNama_saksi1(String nama_saksi1) {
        this.nama_saksi1 = nama_saksi1;
    }

    public String getUmur_saksi1() {
        return umur_saksi1;
    }

    public void setUmur_saksi1(String umur_saksi1) {
        this.umur_saksi1 = umur_saksi1;
    }

    public String getAlamat_saksi1() {
        return alamat_saksi1;
    }

    public void setAlamat_saksi1(String alamat_saksi1) {
        this.alamat_saksi1 = alamat_saksi1;
    }

    public String getNama_saksi2() {
        return nama_saksi2;
    }

    public void setNama_saksi2(String nama_saksi2) {
        this.nama_saksi2 = nama_saksi2;
    }

    public String getUmur_saksi2() {
        return umur_saksi2;
    }

    public void setUmur_saksi2(String umur_saksi2) {
        this.umur_saksi2 = umur_saksi2;
    }

    public String getAlamat_saksi2() {
        return alamat_saksi2;
    }

    public void setAlamat_saksi2(String alamat_saksi2) {
        this.alamat_saksi2 = alamat_saksi2;
    }

    public String getHari_meninggal() {
        return hari_meninggal;
    }

    public void setHari_meninggal(String hari_meninggal) {
        this.hari_meninggal = hari_meninggal;
    }

    public String getTgl_meninggal() {
        return tgl_meninggal;
    }

    public void setTgl_meninggal(String tgl_meninggal) {
        this.tgl_meninggal = tgl_meninggal;
    }

    public String getSebab_meninggal() {
        return sebab_meninggal;
    }

    public void setSebab_meninggal(String sebab_meninggal) {
        this.sebab_meninggal = sebab_meninggal;
    }

    public String getNama_depan_pengaju() {
        return nama_depan_pengaju;
    }

    public void setNama_depan_pengaju(String nama_depan_pengaju) {
        this.nama_depan_pengaju = nama_depan_pengaju;
    }

    public String getNama_belakang_pengaju() {
        return nama_belakang_pengaju;
    }

    public void setNama_belakang_pengaju(String nama_belakang_pengaju) {
        this.nama_belakang_pengaju = nama_belakang_pengaju;
    }

    public String getNama_depan_meninggal() {
        return nama_depan_meninggal;
    }

    public void setNama_depan_meninggal(String nama_depan_meninggal) {
        this.nama_depan_meninggal = nama_depan_meninggal;
    }

    public String getNama_belakang_meninggal() {
        return nama_belakang_meninggal;
    }

    public void setNama_belakang_meninggal(String nama_belakang_meninggal) {
        this.nama_belakang_meninggal = nama_belakang_meninggal;
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
        dest.writeString(this.waktu);
        dest.writeString(this.status_persetujuan);
        dest.writeString(this.nik);
        dest.writeString(this.nik_meninggal);
        dest.writeString(this.nama_saksi1);
        dest.writeString(this.umur_saksi1);
        dest.writeString(this.alamat_saksi1);
        dest.writeString(this.nama_saksi2);
        dest.writeString(this.umur_saksi2);
        dest.writeString(this.alamat_saksi2);
        dest.writeString(this.hari_meninggal);
        dest.writeString(this.tgl_meninggal);
        dest.writeString(this.sebab_meninggal);
        dest.writeString(this.nama_depan_pengaju);
        dest.writeString(this.nama_belakang_pengaju);
        dest.writeString(this.nama_depan_meninggal);
        dest.writeString(this.nama_belakang_meninggal);
        dest.writeString(this.nama_depan_user);
        dest.writeString(this.nama_belakang_user);
    }

    public SuratKematianData() {
    }

    protected SuratKematianData(Parcel in) {
        this.id_surat = in.readString();
        this.kd_surat = in.readString();
        this.no_surat = in.readString();
        this.tgl_surat = in.readString();
        this.waktu = in.readString();
        this.status_persetujuan = in.readString();
        this.nik = in.readString();
        this.nik_meninggal = in.readString();
        this.nama_saksi1 = in.readString();
        this.umur_saksi1 = in.readString();
        this.alamat_saksi1 = in.readString();
        this.nama_saksi2 = in.readString();
        this.umur_saksi2 = in.readString();
        this.alamat_saksi2 = in.readString();
        this.hari_meninggal = in.readString();
        this.tgl_meninggal = in.readString();
        this.sebab_meninggal = in.readString();
        this.nama_depan_pengaju = in.readString();
        this.nama_belakang_pengaju = in.readString();
        this.nama_depan_meninggal = in.readString();
        this.nama_belakang_meninggal = in.readString();
        this.nama_depan_user = in.readString();
        this.nama_belakang_user = in.readString();
    }

    public static final Parcelable.Creator<SuratKematianData> CREATOR = new Parcelable.Creator<SuratKematianData>() {
        @Override
        public SuratKematianData createFromParcel(Parcel source) {
            return new SuratKematianData(source);
        }

        @Override
        public SuratKematianData[] newArray(int size) {
            return new SuratKematianData[size];
        }
    };
}
