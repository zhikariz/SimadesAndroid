package com.codelab.helmi.simades.pergi;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class PergiData {

    @SerializedName("id_pergi")
    private String id_pergi;
    @SerializedName("nik_pergi")
    private String nik_pergi;
    @SerializedName("alamat_tuju")
    private String alamat_tuju;
    @SerializedName("kode_pos")
    private String kode_pos;
    @SerializedName("alasan")
    private String alasan;
    @SerializedName("tgl_pergi")
    private String tgl_pergi;

    public String getId_pergi() {
        return id_pergi;
    }

    public void setId_pergi(String id_pergi) {
        this.id_pergi = id_pergi;
    }

    public String getNik_pergi() {
        return nik_pergi;
    }

    public void setNik_pergi(String nik_pergi) {
        this.nik_pergi = nik_pergi;
    }

    public String getAlamat_tuju() {
        return alamat_tuju;
    }

    public void setAlamat_tuju(String alamat_tuju) {
        this.alamat_tuju = alamat_tuju;
    }

    public String getKode_pos() {
        return kode_pos;
    }

    public void setKode_pos(String kode_pos) {
        this.kode_pos = kode_pos;
    }

    public String getAlasan() {
        return alasan;
    }

    public void setAlasan(String alasan) {
        this.alasan = alasan;
    }

    public String getTgl_pergi() {
        return tgl_pergi;
    }

    public void setTgl_pergi(String tgl_pergi) {
        this.tgl_pergi = tgl_pergi;
    }
}
