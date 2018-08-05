package com.codelab.helmi.simades.datang;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class DatangData implements Parcelable {

    @SerializedName("nik_asal")
    private String nikAsal;

    @SerializedName("umur")
    private String umur;

    @SerializedName("pengikut")
    private String pengikut;

    @SerializedName("id_agama")
    private String idAgama;

    @SerializedName("nama_ibu")
    private String namaIbu;

    @SerializedName("tempat_lhr")
    private String tempatLhr;

    @SerializedName("id_pendidikan")
    private String idPendidikan;

    @SerializedName("nik")
    private String nik;

    @SerializedName("id_kerja")
    private String idKerja;

    @SerializedName("id_stskawin")
    private String idStskawin;

    @SerializedName("no_kk_asal")
    private String noKkAsal;

    @SerializedName("no_kk")
    private String noKk;

    @SerializedName("tanggal_lhr")
    private String tanggalLhr;

    @SerializedName("nama_depan")
    private String namaDepan;

    @SerializedName("nik_pendatang")
    private String nikPendatang;

    @SerializedName("id_hubkel")
    private String idHubkel;

    @SerializedName("nama_belakang")
    private String namaBelakang;

    @SerializedName("id_datang")
    private String idDatang;

    @SerializedName("alasan")
    private String alasan;

    @SerializedName("jekel")
    private String jekel;

    @SerializedName("tgl_mutasi")
    private String tglMutasi;

    @SerializedName("nama_ayah")
    private String namaAyah;

    @SerializedName("anak_ke")
    private String anakKe;

    @SerializedName("alamat_asal")
    private String alamatAsal;

    @SerializedName("id_goldar")
    private String idGoldar;

    @SerializedName("status")
    private String status;

    public void setNikAsal(String nikAsal) {
        this.nikAsal = nikAsal;
    }

    public String getNikAsal() {
        return nikAsal;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }

    public String getUmur() {
        return umur;
    }

    public void setPengikut(String pengikut) {
        this.pengikut = pengikut;
    }

    public String getPengikut() {
        return pengikut;
    }

    public void setIdAgama(String idAgama) {
        this.idAgama = idAgama;
    }

    public String getIdAgama() {
        return idAgama;
    }

    public void setNamaIbu(String namaIbu) {
        this.namaIbu = namaIbu;
    }

    public String getNamaIbu() {
        return namaIbu;
    }

    public void setTempatLhr(String tempatLhr) {
        this.tempatLhr = tempatLhr;
    }

    public String getTempatLhr() {
        return tempatLhr;
    }

    public void setIdPendidikan(String idPendidikan) {
        this.idPendidikan = idPendidikan;
    }

    public String getIdPendidikan() {
        return idPendidikan;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNik() {
        return nik;
    }

    public void setIdKerja(String idKerja) {
        this.idKerja = idKerja;
    }

    public String getIdKerja() {
        return idKerja;
    }

    public void setIdStskawin(String idStskawin) {
        this.idStskawin = idStskawin;
    }

    public String getIdStskawin() {
        return idStskawin;
    }

    public void setNoKkAsal(String noKkAsal) {
        this.noKkAsal = noKkAsal;
    }

    public String getNoKkAsal() {
        return noKkAsal;
    }

    public void setNoKk(String noKk) {
        this.noKk = noKk;
    }

    public String getNoKk() {
        return noKk;
    }

    public void setTanggalLhr(String tanggalLhr) {
        this.tanggalLhr = tanggalLhr;
    }

    public String getTanggalLhr() {
        return tanggalLhr;
    }

    public void setNamaDepan(String namaDepan) {
        this.namaDepan = namaDepan;
    }

    public String getNamaDepan() {
        return namaDepan;
    }

    public void setNikPendatang(String nikPendatang) {
        this.nikPendatang = nikPendatang;
    }

    public String getNikPendatang() {
        return nikPendatang;
    }

    public void setIdHubkel(String idHubkel) {
        this.idHubkel = idHubkel;
    }

    public String getIdHubkel() {
        return idHubkel;
    }

    public void setNamaBelakang(String namaBelakang) {
        this.namaBelakang = namaBelakang;
    }

    public String getNamaBelakang() {
        return namaBelakang;
    }

    public void setIdDatang(String idDatang) {
        this.idDatang = idDatang;
    }

    public String getIdDatang() {
        return idDatang;
    }

    public void setAlasan(String alasan) {
        this.alasan = alasan;
    }

    public String getAlasan() {
        return alasan;
    }

    public void setJekel(String jekel) {
        this.jekel = jekel;
    }

    public String getJekel() {
        return jekel;
    }

    public void setTglMutasi(String tglMutasi) {
        this.tglMutasi = tglMutasi;
    }

    public String getTglMutasi() {
        return tglMutasi;
    }

    public void setNamaAyah(String namaAyah) {
        this.namaAyah = namaAyah;
    }

    public String getNamaAyah() {
        return namaAyah;
    }

    public void setAnakKe(String anakKe) {
        this.anakKe = anakKe;
    }

    public String getAnakKe() {
        return anakKe;
    }

    public void setAlamatAsal(String alamatAsal) {
        this.alamatAsal = alamatAsal;
    }

    public String getAlamatAsal() {
        return alamatAsal;
    }

    public void setIdGoldar(String idGoldar) {
        this.idGoldar = idGoldar;
    }

    public String getIdGoldar() {
        return idGoldar;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return
                "DatangData{" +
                        "nik_asal = '" + nikAsal + '\'' +
                        ",umur = '" + umur + '\'' +
                        ",pengikut = '" + pengikut + '\'' +
                        ",id_agama = '" + idAgama + '\'' +
                        ",nama_ibu = '" + namaIbu + '\'' +
                        ",tempat_lhr = '" + tempatLhr + '\'' +
                        ",id_pendidikan = '" + idPendidikan + '\'' +
                        ",nik = '" + nik + '\'' +
                        ",id_kerja = '" + idKerja + '\'' +
                        ",id_stskawin = '" + idStskawin + '\'' +
                        ",no_kk_asal = '" + noKkAsal + '\'' +
                        ",no_kk = '" + noKk + '\'' +
                        ",tanggal_lhr = '" + tanggalLhr + '\'' +
                        ",nama_depan = '" + namaDepan + '\'' +
                        ",nik_pendatang = '" + nikPendatang + '\'' +
                        ",id_hubkel = '" + idHubkel + '\'' +
                        ",nama_belakang = '" + namaBelakang + '\'' +
                        ",id_datang = '" + idDatang + '\'' +
                        ",alasan = '" + alasan + '\'' +
                        ",jekel = '" + jekel + '\'' +
                        ",tgl_mutasi = '" + tglMutasi + '\'' +
                        ",nama_ayah = '" + namaAyah + '\'' +
                        ",anak_ke = '" + anakKe + '\'' +
                        ",alamat_asal = '" + alamatAsal + '\'' +
                        ",id_goldar = '" + idGoldar + '\'' +
                        ",status = '" + status + '\'' +
                        "}";
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nikAsal);
        dest.writeString(this.umur);
        dest.writeString(this.pengikut);
        dest.writeString(this.idAgama);
        dest.writeString(this.namaIbu);
        dest.writeString(this.tempatLhr);
        dest.writeString(this.idPendidikan);
        dest.writeString(this.nik);
        dest.writeString(this.idKerja);
        dest.writeString(this.idStskawin);
        dest.writeString(this.noKkAsal);
        dest.writeString(this.noKk);
        dest.writeString(this.tanggalLhr);
        dest.writeString(this.namaDepan);
        dest.writeString(this.nikPendatang);
        dest.writeString(this.idHubkel);
        dest.writeString(this.namaBelakang);
        dest.writeString(this.idDatang);
        dest.writeString(this.alasan);
        dest.writeString(this.jekel);
        dest.writeString(this.tglMutasi);
        dest.writeString(this.namaAyah);
        dest.writeString(this.anakKe);
        dest.writeString(this.alamatAsal);
        dest.writeString(this.idGoldar);
        dest.writeString(this.status);
    }

    public DatangData() {
    }

    protected DatangData(Parcel in) {
        this.nikAsal = in.readString();
        this.umur = in.readString();
        this.pengikut = in.readString();
        this.idAgama = in.readString();
        this.namaIbu = in.readString();
        this.tempatLhr = in.readString();
        this.idPendidikan = in.readString();
        this.nik = in.readString();
        this.idKerja = in.readString();
        this.idStskawin = in.readString();
        this.noKkAsal = in.readString();
        this.noKk = in.readString();
        this.tanggalLhr = in.readString();
        this.namaDepan = in.readString();
        this.nikPendatang = in.readString();
        this.idHubkel = in.readString();
        this.namaBelakang = in.readString();
        this.idDatang = in.readString();
        this.alasan = in.readString();
        this.jekel = in.readString();
        this.tglMutasi = in.readString();
        this.namaAyah = in.readString();
        this.anakKe = in.readString();
        this.alamatAsal = in.readString();
        this.idGoldar = in.readString();
        this.status = in.readString();
    }

    public static final Parcelable.Creator<DatangData> CREATOR = new Parcelable.Creator<DatangData>() {
        @Override
        public DatangData createFromParcel(Parcel source) {
            return new DatangData(source);
        }

        @Override
        public DatangData[] newArray(int size) {
            return new DatangData[size];
        }
    };
}