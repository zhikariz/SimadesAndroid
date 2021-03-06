package com.codelab.helmi.simades.pergi;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class PergiData implements Parcelable {

    public static final Parcelable.Creator<PergiData> CREATOR = new Parcelable.Creator<PergiData>() {
        @Override
        public PergiData createFromParcel(Parcel source) {
            return new PergiData(source);
        }

        @Override
        public PergiData[] newArray(int size) {
            return new PergiData[size];
        }
    };
    @SerializedName("umur")
    private String umur;
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
    @SerializedName("id_pergi")
    private String idPergi;
    @SerializedName("no_kk")
    private String noKk;
    @SerializedName("tanggal_lhr")
    private String tanggalLhr;
    @SerializedName("nama_depan")
    private String namaDepan;
    @SerializedName("nik_pergi")
    private String nikPergi;
    @SerializedName("kode_pos")
    private String kodePos;
    @SerializedName("tgl_pergi")
    private String tglPergi;
    @SerializedName("id_hubkel")
    private String idHubkel;
    @SerializedName("nama_belakang")
    private String namaBelakang;
    @SerializedName("alasan")
    private String alasan;
    @SerializedName("alamat_tuju")
    private String alamatTuju;
    @SerializedName("jekel")
    private String jekel;
    @SerializedName("tgl_mutasi")
    private String tglMutasi;
    @SerializedName("nama_ayah")
    private String namaAyah;
    @SerializedName("anak_ke")
    private String anakKe;
    @SerializedName("id_goldar")
    private String idGoldar;
    @SerializedName("status")
    private String status;

    public PergiData() {
    }

    protected PergiData(Parcel in) {
        this.umur = in.readString();
        this.idAgama = in.readString();
        this.namaIbu = in.readString();
        this.tempatLhr = in.readString();
        this.idPendidikan = in.readString();
        this.nik = in.readString();
        this.idKerja = in.readString();
        this.idStskawin = in.readString();
        this.idPergi = in.readString();
        this.noKk = in.readString();
        this.tanggalLhr = in.readString();
        this.namaDepan = in.readString();
        this.nikPergi = in.readString();
        this.kodePos = in.readString();
        this.tglPergi = in.readString();
        this.idHubkel = in.readString();
        this.namaBelakang = in.readString();
        this.alasan = in.readString();
        this.alamatTuju = in.readString();
        this.jekel = in.readString();
        this.tglMutasi = in.readString();
        this.namaAyah = in.readString();
        this.anakKe = in.readString();
        this.idGoldar = in.readString();
        this.status = in.readString();
    }

    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }

    public String getIdAgama() {
        return idAgama;
    }

    public void setIdAgama(String idAgama) {
        this.idAgama = idAgama;
    }

    public String getNamaIbu() {
        return namaIbu;
    }

    public void setNamaIbu(String namaIbu) {
        this.namaIbu = namaIbu;
    }

    public String getTempatLhr() {
        return tempatLhr;
    }

    public void setTempatLhr(String tempatLhr) {
        this.tempatLhr = tempatLhr;
    }

    public String getIdPendidikan() {
        return idPendidikan;
    }

    public void setIdPendidikan(String idPendidikan) {
        this.idPendidikan = idPendidikan;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getIdKerja() {
        return idKerja;
    }

    public void setIdKerja(String idKerja) {
        this.idKerja = idKerja;
    }

    public String getIdStskawin() {
        return idStskawin;
    }

    public void setIdStskawin(String idStskawin) {
        this.idStskawin = idStskawin;
    }

    public String getIdPergi() {
        return idPergi;
    }

    public void setIdPergi(String idPergi) {
        this.idPergi = idPergi;
    }

    public String getNoKk() {
        return noKk;
    }

    public void setNoKk(String noKk) {
        this.noKk = noKk;
    }

    public String getTanggalLhr() {
        return tanggalLhr;
    }

    public void setTanggalLhr(String tanggalLhr) {
        this.tanggalLhr = tanggalLhr;
    }

    public String getNamaDepan() {
        return namaDepan;
    }

    public void setNamaDepan(String namaDepan) {
        this.namaDepan = namaDepan;
    }

    public String getNikPergi() {
        return nikPergi;
    }

    public void setNikPergi(String nikPergi) {
        this.nikPergi = nikPergi;
    }

    public String getKodePos() {
        return kodePos;
    }

    public void setKodePos(String kodePos) {
        this.kodePos = kodePos;
    }

    public String getTglPergi() {
        return tglPergi;
    }

    public void setTglPergi(String tglPergi) {
        this.tglPergi = tglPergi;
    }

    public String getIdHubkel() {
        return idHubkel;
    }

    public void setIdHubkel(String idHubkel) {
        this.idHubkel = idHubkel;
    }

    public String getNamaBelakang() {
        return namaBelakang;
    }

    public void setNamaBelakang(String namaBelakang) {
        this.namaBelakang = namaBelakang;
    }

    public String getAlasan() {
        return alasan;
    }

    public void setAlasan(String alasan) {
        this.alasan = alasan;
    }

    public String getAlamatTuju() {
        return alamatTuju;
    }

    public void setAlamatTuju(String alamatTuju) {
        this.alamatTuju = alamatTuju;
    }

    public String getJekel() {
        return jekel;
    }

    public void setJekel(String jekel) {
        this.jekel = jekel;
    }

    public String getTglMutasi() {
        return tglMutasi;
    }

    public void setTglMutasi(String tglMutasi) {
        this.tglMutasi = tglMutasi;
    }

    public String getNamaAyah() {
        return namaAyah;
    }

    public void setNamaAyah(String namaAyah) {
        this.namaAyah = namaAyah;
    }

    public String getAnakKe() {
        return anakKe;
    }

    public void setAnakKe(String anakKe) {
        this.anakKe = anakKe;
    }

    public String getIdGoldar() {
        return idGoldar;
    }

    public void setIdGoldar(String idGoldar) {
        this.idGoldar = idGoldar;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return
                "PergiData{" +
                        "umur = '" + umur + '\'' +
                        ",id_agama = '" + idAgama + '\'' +
                        ",nama_ibu = '" + namaIbu + '\'' +
                        ",tempat_lhr = '" + tempatLhr + '\'' +
                        ",id_pendidikan = '" + idPendidikan + '\'' +
                        ",nik = '" + nik + '\'' +
                        ",id_kerja = '" + idKerja + '\'' +
                        ",id_stskawin = '" + idStskawin + '\'' +
                        ",id_pergi = '" + idPergi + '\'' +
                        ",no_kk = '" + noKk + '\'' +
                        ",tanggal_lhr = '" + tanggalLhr + '\'' +
                        ",nama_depan = '" + namaDepan + '\'' +
                        ",nik_pergi = '" + nikPergi + '\'' +
                        ",kode_pos = '" + kodePos + '\'' +
                        ",tgl_pergi = '" + tglPergi + '\'' +
                        ",id_hubkel = '" + idHubkel + '\'' +
                        ",nama_belakang = '" + namaBelakang + '\'' +
                        ",alasan = '" + alasan + '\'' +
                        ",alamat_tuju = '" + alamatTuju + '\'' +
                        ",jekel = '" + jekel + '\'' +
                        ",tgl_mutasi = '" + tglMutasi + '\'' +
                        ",nama_ayah = '" + namaAyah + '\'' +
                        ",anak_ke = '" + anakKe + '\'' +
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
        dest.writeString(this.umur);
        dest.writeString(this.idAgama);
        dest.writeString(this.namaIbu);
        dest.writeString(this.tempatLhr);
        dest.writeString(this.idPendidikan);
        dest.writeString(this.nik);
        dest.writeString(this.idKerja);
        dest.writeString(this.idStskawin);
        dest.writeString(this.idPergi);
        dest.writeString(this.noKk);
        dest.writeString(this.tanggalLhr);
        dest.writeString(this.namaDepan);
        dest.writeString(this.nikPergi);
        dest.writeString(this.kodePos);
        dest.writeString(this.tglPergi);
        dest.writeString(this.idHubkel);
        dest.writeString(this.namaBelakang);
        dest.writeString(this.alasan);
        dest.writeString(this.alamatTuju);
        dest.writeString(this.jekel);
        dest.writeString(this.tglMutasi);
        dest.writeString(this.namaAyah);
        dest.writeString(this.anakKe);
        dest.writeString(this.idGoldar);
        dest.writeString(this.status);
    }
}