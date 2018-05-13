package com.codelab.helmi.simades.kelahiran;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class KelahiranData {

    @SerializedName("id_lahir")
    private String id_lahir;
    @SerializedName("nis_bayi")
    private String nis_bayi;
    @SerializedName("nama_depan_bayi")
    private String nama_depan_bayi;
    @SerializedName("nama_belakang_bayi")
    private String nama_belakang_bayi;
    @SerializedName("tgl_lahir")
    private String tgl_lahir;
    @SerializedName("tpt_lahir")
    private String tpt_lahir;
    @SerializedName("jekel")
    private String jekel;
    @SerializedName("berat_bayi")
    private String berat_bayi;
    @SerializedName("anak_ke")
    private String anak_ke;
    @SerializedName("waktu")
    private String waktu;
    @SerializedName("panjang_bayi")
    private String panjang_bayi;
    @SerializedName("nik_ayah")
    private String nik_ayah;
    @SerializedName("nik_ibu")
    private String nik_ibu;
    @SerializedName("nik_saksi1")
    private String nik_saksi1;
    @SerializedName("nik_saksi2")
    private String nik_saksi2;

    public String getId_lahir() {
        return id_lahir;
    }

    public void setId_lahir(String id_lahir) {
        this.id_lahir = id_lahir;
    }

    public String getNis_bayi() {
        return nis_bayi;
    }

    public void setNis_bayi(String nis_bayi) {
        this.nis_bayi = nis_bayi;
    }

    public String getNama_depan_bayi() {
        return nama_depan_bayi;
    }

    public void setNama_depan_bayi(String nama_depan_bayi) {
        this.nama_depan_bayi = nama_depan_bayi;
    }

    public String getNama_belakang_bayi() {
        return nama_belakang_bayi;
    }

    public void setNama_belakang_bayi(String nama_belakang_bayi) {
        this.nama_belakang_bayi = nama_belakang_bayi;
    }

    public String getTgl_lahir() {
        return tgl_lahir;
    }

    public void setTgl_lahir(String tgl_lahir) {
        this.tgl_lahir = tgl_lahir;
    }

    public String getTpt_lahir() {
        return tpt_lahir;
    }

    public void setTpt_lahir(String tpt_lahir) {
        this.tpt_lahir = tpt_lahir;
    }

    public String getJekel() {
        return jekel;
    }

    public void setJekel(String jekel) {
        this.jekel = jekel;
    }

    public String getBerat_bayi() {
        return berat_bayi;
    }

    public void setBerat_bayi(String berat_bayi) {
        this.berat_bayi = berat_bayi;
    }

    public String getAnak_ke() {
        return anak_ke;
    }

    public void setAnak_ke(String anak_ke) {
        this.anak_ke = anak_ke;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getPanjang_bayi() {
        return panjang_bayi;
    }

    public void setPanjang_bayi(String panjang_bayi) {
        this.panjang_bayi = panjang_bayi;
    }

    public String getNik_ayah() {
        return nik_ayah;
    }

    public void setNik_ayah(String nik_ayah) {
        this.nik_ayah = nik_ayah;
    }

    public String getNik_ibu() {
        return nik_ibu;
    }

    public void setNik_ibu(String nik_ibu) {
        this.nik_ibu = nik_ibu;
    }

    public String getNik_saksi1() {
        return nik_saksi1;
    }

    public void setNik_saksi1(String nik_saksi1) {
        this.nik_saksi1 = nik_saksi1;
    }

    public String getNik_saksi2() {
        return nik_saksi2;
    }

    public void setNik_saksi2(String nik_saksi2) {
        this.nik_saksi2 = nik_saksi2;
    }

}
