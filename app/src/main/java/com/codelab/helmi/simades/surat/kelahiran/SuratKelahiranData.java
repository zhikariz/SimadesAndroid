package com.codelab.helmi.simades.surat.kelahiran;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class SuratKelahiranData {

    @SerializedName("id_surat")
    private String id_surat;
    @SerializedName("kd_surat")
    private String kd_surat;
    @SerializedName("no_surat")
    private String no_surat;
    @SerializedName("jenis_surat")
    private String jenis_surat;
    @SerializedName("tgl_surat")
    private String tgl_surat;
    @SerializedName("waktu")
    private String waktu;
    @SerializedName("status_persetujuan")
    private String status_persetujuan;
    @SerializedName("nik")
    private String nik;
    @SerializedName("nik_ayah")
    private String nik_ayah;
    @SerializedName("nik_ibu")
    private String nik_ibu;
    @SerializedName("id_user_ttd")
    private String id_user_ttd;
    @SerializedName("no_kk")
    private String no_kk;
    @SerializedName("nama_depan")
    private String nama_depan;
    @SerializedName("nama_belakang")
    private String nama_belakang;
    @SerializedName("jekel")
    private String jekel;
    @SerializedName("umur")
    private String umur;
    @SerializedName("id_agama")
    private String id_agama;
    @SerializedName("id_goldar")
    private String id_goldar;
    @SerializedName("id_stskawin")
    private String id_stskawin;
    @SerializedName("tempat_lhr")
    private String tempat_lhr;
    @SerializedName("tangaal_lhr")
    private String tanggal_lhr;
    @SerializedName("nama_ayah")
    private String nama_ayah;
    @SerializedName("nama_ibu")
    private String nama_ibu;
    @SerializedName("anak_ke")
    private String anak_ke;
    @SerializedName("id_kerja")
    private String id_kerja;
    @SerializedName("id_hubkel")
    private String id_hubkel;
    @SerializedName("id_pendidikan")
    private String id_pendidikan;
    @SerializedName("status")
    private String status;
    @SerializedName("tgl_mutasi")
    private String tgl_mutasi;



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

    public String getJenis_surat() {
        return jenis_surat;
    }

    public void setJenis_surat(String jenis_surat) {
        this.jenis_surat = jenis_surat;
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
}
