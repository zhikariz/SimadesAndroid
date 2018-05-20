package com.codelab.helmi.simades.datang;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class DatangData {

    @SerializedName("id_datang")
    private String id_datang;
    @SerializedName("nik_pendatang")
    private String nik_pendatang;
    @SerializedName("nik_asal")
    private String nik_asal;
    @SerializedName("no_kk_asal")
    private String no_kk_asal;
    @SerializedName("alamat_asal")
    private String alamat_asal;
    @SerializedName("alasan")
    private String alasan;
    @SerializedName("pengikut")
    private String pengikut;

    public String getId_datang() {
        return id_datang;
    }

    public void setId_datang(String id_datang) {
        this.id_datang = id_datang;
    }

    public String getNik_pendatang() {
        return nik_pendatang;
    }

    public void setNik_pendatang(String nik_pendatang) {
        this.nik_pendatang = nik_pendatang;
    }

    public String getNik_asal() {
        return nik_asal;
    }

    public void setNik_asal(String nik_asal) {
        this.nik_asal = nik_asal;
    }

    public String getNo_kk_asal() {
        return no_kk_asal;
    }

    public void setNo_kk_asal(String no_kk_asal) {
        this.no_kk_asal = no_kk_asal;
    }

    public String getAlamat_asal() {
        return alamat_asal;
    }

    public void setAlamat_asal(String alamat_asal) {
        this.alamat_asal = alamat_asal;
    }

    public String getAlasan() {
        return alasan;
    }

    public void setAlasan(String alasan) {
        this.alasan = alasan;
    }

    public String getPengikut() {
        return pengikut;
    }

    public void setPengikut(String pengikut) {
        this.pengikut = pengikut;
    }
}
