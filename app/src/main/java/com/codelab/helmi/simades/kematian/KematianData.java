package com.codelab.helmi.simades.kematian;

@SuppressWarnings("unused")
public class KematianData {
    private String id_mati;
    private String nik_meninggal;
    private String tgl_meninggal;
    private String sebab;
    private String tpt_meninggal;
    private String menerangkan;

    public String getId_mati() {
        return id_mati;
    }

    public void setId_mati(String id_mati) {
        this.id_mati = id_mati;
    }

    public String getNik_meninggal() {
        return nik_meninggal;
    }

    public void setNik_meninggal(String nik_meninggal) {
        this.nik_meninggal = nik_meninggal;
    }

    public String getTgl_meninggal() {
        return tgl_meninggal;
    }

    public void setTgl_meninggal(String tgl_meninggal) {
        this.tgl_meninggal = tgl_meninggal;
    }

    public String getSebab() {
        return sebab;
    }

    public void setSebab(String sebab) {
        this.sebab = sebab;
    }

    public String getTpt_meninggal() {
        return tpt_meninggal;
    }

    public void setTpt_meninggal(String tpt_meninggal) {
        this.tpt_meninggal = tpt_meninggal;
    }

    public String getMenerangkan() {
        return menerangkan;
    }

    public void setMenerangkan(String menerangkan) {
        this.menerangkan = menerangkan;
    }
}
