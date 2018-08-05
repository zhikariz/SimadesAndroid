package com.codelab.helmi.simades.layanan;

import com.google.gson.annotations.SerializedName;

public class SuratWaliItem {

    @SerializedName("nama_depan_wali")
    private String namaDepanWali;

    @SerializedName("nama_belakang_laki")
    private String namaBelakangLaki;

    @SerializedName("kd_surat")
    private String kdSurat;

    @SerializedName("id_surat")
    private String idSurat;

    @SerializedName("alasan")
    private String alasan;

    @SerializedName("status_persetujuan")
    private String statusPersetujuan;

    @SerializedName("nik")
    private String nik;

    @SerializedName("nik_laki")
    private String nikLaki;

    @SerializedName("nama_belakang_wali")
    private String namaBelakangWali;

    @SerializedName("nama_depan_perempuan")
    private String namaDepanPerempuan;

    @SerializedName("nik_perempuan")
    private String nikPerempuan;

    @SerializedName("nama_depan_laki")
    private String namaDepanLaki;

    @SerializedName("nama_belakang_perempuan")
    private String namaBelakangPerempuan;

    @SerializedName("no_surat")
    private String noSurat;

    @SerializedName("tgl_surat")
    private String tglSurat;

    @SerializedName("nama_depan_user")
    private String namaDepanUser;

    @SerializedName("nama_belakang_user")
    private String namaBelakangUser;

    public void setNamaDepanWali(String namaDepanWali) {
        this.namaDepanWali = namaDepanWali;
    }

    public String getNamaDepanWali() {
        return namaDepanWali;
    }

    public void setNamaBelakangLaki(String namaBelakangLaki) {
        this.namaBelakangLaki = namaBelakangLaki;
    }

    public String getNamaBelakangLaki() {
        return namaBelakangLaki;
    }

    public void setKdSurat(String kdSurat) {
        this.kdSurat = kdSurat;
    }

    public String getKdSurat() {
        return kdSurat;
    }

    public void setIdSurat(String idSurat) {
        this.idSurat = idSurat;
    }

    public String getIdSurat() {
        return idSurat;
    }

    public void setAlasan(String alasan) {
        this.alasan = alasan;
    }

    public String getAlasan() {
        return alasan;
    }

    public void setStatusPersetujuan(String statusPersetujuan) {
        this.statusPersetujuan = statusPersetujuan;
    }

    public String getStatusPersetujuan() {
        return statusPersetujuan;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNik() {
        return nik;
    }

    public void setNikLaki(String nikLaki) {
        this.nikLaki = nikLaki;
    }

    public String getNikLaki() {
        return nikLaki;
    }

    public void setNamaBelakangWali(String namaBelakangWali) {
        this.namaBelakangWali = namaBelakangWali;
    }

    public String getNamaBelakangWali() {
        return namaBelakangWali;
    }

    public void setNamaDepanPerempuan(String namaDepanPerempuan) {
        this.namaDepanPerempuan = namaDepanPerempuan;
    }

    public String getNamaDepanPerempuan() {
        return namaDepanPerempuan;
    }

    public void setNikPerempuan(String nikPerempuan) {
        this.nikPerempuan = nikPerempuan;
    }

    public String getNikPerempuan() {
        return nikPerempuan;
    }

    public void setNamaDepanLaki(String namaDepanLaki) {
        this.namaDepanLaki = namaDepanLaki;
    }

    public String getNamaDepanLaki() {
        return namaDepanLaki;
    }

    public void setNamaBelakangPerempuan(String namaBelakangPerempuan) {
        this.namaBelakangPerempuan = namaBelakangPerempuan;
    }

    public String getNamaBelakangPerempuan() {
        return namaBelakangPerempuan;
    }

    public void setNoSurat(String noSurat) {
        this.noSurat = noSurat;
    }

    public String getNoSurat() {
        return noSurat;
    }

    public void setTglSurat(String tglSurat) {
        this.tglSurat = tglSurat;
    }

    public String getTglSurat() {
        return tglSurat;
    }

    public void setNamaDepanUser(String namaDepanUser) {
        this.namaDepanUser = namaDepanUser;
    }

    public String getNamaDepanUser() {
        return namaDepanUser;
    }

    public void setNamaBelakangUser(String namaBelakangUser) {
        this.namaBelakangUser = namaBelakangUser;
    }

    public String getNamaBelakangUser() {
        return namaBelakangUser;
    }

    @Override
    public String toString() {
        return
                "SuratWaliItem{" +
                        "nama_depan_wali = '" + namaDepanWali + '\'' +
                        ",nama_belakang_laki = '" + namaBelakangLaki + '\'' +
                        ",kd_surat = '" + kdSurat + '\'' +
                        ",id_surat = '" + idSurat + '\'' +
                        ",alasan = '" + alasan + '\'' +
                        ",status_persetujuan = '" + statusPersetujuan + '\'' +
                        ",nik = '" + nik + '\'' +
                        ",nik_laki = '" + nikLaki + '\'' +
                        ",nama_belakang_wali = '" + namaBelakangWali + '\'' +
                        ",nama_depan_perempuan = '" + namaDepanPerempuan + '\'' +
                        ",nik_perempuan = '" + nikPerempuan + '\'' +
                        ",nama_depan_laki = '" + namaDepanLaki + '\'' +
                        ",nama_belakang_perempuan = '" + namaBelakangPerempuan + '\'' +
                        ",no_surat = '" + noSurat + '\'' +
                        ",tgl_surat = '" + tglSurat + '\'' +
                        ",nama_depan_user = '" + namaDepanUser + '\'' +
                        ",nama_belakang_user = '" + namaBelakangUser + '\'' +
                        "}";
    }
}