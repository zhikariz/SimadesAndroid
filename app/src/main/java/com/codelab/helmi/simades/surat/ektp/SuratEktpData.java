package com.codelab.helmi.simades.surat.ektp;

import com.google.gson.annotations.SerializedName;
@SuppressWarnings("unused")
public class SuratEktpData {
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
