package com.codelab.helmi.simades.kk;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class KkData {
    @SerializedName("no_kk")
    private String no_kk;
    @SerializedName("alamat")
    private String alamat;
    @SerializedName("id_dusun")
    private String id_dusun;
    @SerializedName("rt")
    private String rt;
    @SerializedName("rw")
    private String rw;
    @SerializedName("kelurahan")
    private String kelurahan;
    @SerializedName("kecamatan")
    private String kecamatan;
    @SerializedName("kabupaten")
    private String kabupaten;
    @SerializedName("propinsi")
    private String propinsi;

    public String getNo_kk() {
        return no_kk;
    }

    public void setNo_kk(String no_kk) {
        this.no_kk = no_kk;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getId_dusun() {
        return id_dusun;
    }

    public void setId_dusun(String id_dusun) {
        this.id_dusun = id_dusun;
    }

    public String getRt() {
        return rt;
    }

    public void setRt(String rt) {
        this.rt = rt;
    }

    public String getRw() {
        return rw;
    }

    public void setRw(String rw) {
        this.rw = rw;
    }

    public String getKelurahan() {
        return kelurahan;
    }

    public void setKelurahan(String kelurahan) {
        this.kelurahan = kelurahan;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getKabupaten() {
        return kabupaten;
    }

    public void setKabupaten(String kabupaten) {
        this.kabupaten = kabupaten;
    }

    public String getPropinsi() {
        return propinsi;
    }

    public void setPropinsi(String propinsi) {
        this.propinsi = propinsi;
    }
}
