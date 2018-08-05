package com.codelab.helmi.simades.profil;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class ProfilData {

    @SerializedName("id_desa")
    private String id_desa;
    @SerializedName("kode_desa")
    private String kode_desa;
    @SerializedName("nm_desa")
    private String nm_desa;
    @SerializedName("kecamatan")
    private String kecamatan;
    @SerializedName("kabupaten")
    private String kabupaten;
    @SerializedName("propinsi")
    private String propinsi;
    @SerializedName("nm_kepdes")
    private String nm_kepdes;
    @SerializedName("nip_kepdes")
    private String nip_kepdes;
    @SerializedName("alamat_desa")
    private String alamat_desa;
    @SerializedName("no_telp")
    private String no_telp;
    @SerializedName("kode_pos")
    private String kode_pos;
    @SerializedName("image")
    private String image;

    public ProfilData() {

    }

    public String getId_desa() {
        return id_desa;
    }

    public void setId_desa(String id_desa) {
        this.id_desa = id_desa;
    }

    public String getKode_desa() {
        return kode_desa;
    }

    public void setKode_desa(String kode_desa) {
        this.kode_desa = kode_desa;
    }

    public String getNm_desa() {
        return nm_desa;
    }

    public void setNm_desa(String nm_desa) {
        this.nm_desa = nm_desa;
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

    public String getNm_kepdes() {
        return nm_kepdes;
    }

    public void setNm_kepdes(String nm_kepdes) {
        this.nm_kepdes = nm_kepdes;
    }

    public String getNip_kepdes() {
        return nip_kepdes;
    }

    public void setNip_kepdes(String nip_kepdes) {
        this.nip_kepdes = nip_kepdes;
    }

    public String getAlamat_desa() {
        return alamat_desa;
    }

    public void setAlamat_desa(String alamat_desa) {
        this.alamat_desa = alamat_desa;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }

    public String getKode_pos() {
        return kode_pos;
    }

    public void setKode_pos(String kode_pos) {
        this.kode_pos = kode_pos;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


}
