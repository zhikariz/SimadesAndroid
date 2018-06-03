package com.codelab.helmi.simades.penduduk;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class PendudukData implements Parcelable {

    @SerializedName("nik")
    private String nik;
    @SerializedName("no_kk")
    private String no_kk;
    @SerializedName("nama_depan")
    private String nama_depan;
    @SerializedName("nama_belakang")
    private String nama_belakang;
    @SerializedName("jekel")
    private String jekel;
    @SerializedName("umur")
    private String umur;
    @SerializedName("tempat_lhr")
    private String tempat_lhr;
    @SerializedName("tanggal_lhr")
    private String tanggal_lhr;
    @SerializedName("nama_ayah")
    private String nama_ayah;
    @SerializedName("nama_ibu")
    private String nama_ibu;
    @SerializedName("anak_ke")
    private String anak_ke;
    @SerializedName("status")
    private String status;
    @SerializedName("tgl_mutasi")
    private String tgl_mutasi;
    @SerializedName("agama")
    private String agama;
    @SerializedName("goldar")
    private String goldar;
    @SerializedName("hubkel")
    private String hubkel;
    @SerializedName("kerja")
    private String kerja;
    @SerializedName("pendidikan")
    private String pendidikan;
    @SerializedName("stkawin")
    private String stkawin;
    @SerializedName("alamat")
    private String alamat;
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
    @SerializedName("dusun")
    private String dusun;


    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNo_kk() {
        return no_kk;
    }

    public void setNo_kk(String no_kk) {
        this.no_kk = no_kk;
    }

    public String getNama_depan() {
        return nama_depan;
    }

    public void setNama_depan(String nama_depan) {
        this.nama_depan = nama_depan;
    }

    public String getNama_belakang() {
        return nama_belakang;
    }

    public void setNama_belakang(String nama_belakang) {
        this.nama_belakang = nama_belakang;
    }

    public String getJekel() {
        return jekel;
    }

    public void setJekel(String jekel) {
        this.jekel = jekel;
    }

    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }

    public String getTempat_lhr() {
        return tempat_lhr;
    }

    public void setTempat_lhr(String tempat_lhr) {
        this.tempat_lhr = tempat_lhr;
    }

    public String getTanggal_lhr() {
        return tanggal_lhr;
    }

    public void setTanggal_lhr(String tanggal_lhr) {
        this.tanggal_lhr = tanggal_lhr;
    }

    public String getNama_ayah() {
        return nama_ayah;
    }

    public void setNama_ayah(String nama_ayah) {
        this.nama_ayah = nama_ayah;
    }

    public String getNama_ibu() {
        return nama_ibu;
    }

    public void setNama_ibu(String nama_ibu) {
        this.nama_ibu = nama_ibu;
    }

    public String getAnak_ke() {
        return anak_ke;
    }

    public void setAnak_ke(String anak_ke) {
        this.anak_ke = anak_ke;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTgl_mutasi() {
        return tgl_mutasi;
    }

    public void setTgl_mutasi(String tgl_mutasi) {
        this.tgl_mutasi = tgl_mutasi;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getGoldar() {
        return goldar;
    }

    public void setGoldar(String goldar) {
        this.goldar = goldar;
    }

    public String getHubkel() {
        return hubkel;
    }

    public void setHubkel(String hubkel) {
        this.hubkel = hubkel;
    }

    public String getKerja() {
        return kerja;
    }

    public void setKerja(String kerja) {
        this.kerja = kerja;
    }

    public String getPendidikan() {
        return pendidikan;
    }

    public void setPendidikan(String pendidikan) {
        this.pendidikan = pendidikan;
    }

    public String getStkawin() {
        return stkawin;
    }

    public void setStkawin(String stkawin) {
        this.stkawin = stkawin;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
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

    public String getDusun() {
        return dusun;
    }

    public void setDusun(String dusun) {
        this.dusun = dusun;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nik);
        dest.writeString(this.no_kk);
        dest.writeString(this.nama_depan);
        dest.writeString(this.nama_belakang);
        dest.writeString(this.jekel);
        dest.writeString(this.umur);
        dest.writeString(this.tempat_lhr);
        dest.writeString(this.tanggal_lhr);
        dest.writeString(this.nama_ayah);
        dest.writeString(this.nama_ibu);
        dest.writeString(this.anak_ke);
        dest.writeString(this.status);
        dest.writeString(this.tgl_mutasi);
        dest.writeString(this.agama);
        dest.writeString(this.goldar);
        dest.writeString(this.hubkel);
        dest.writeString(this.kerja);
        dest.writeString(this.pendidikan);
        dest.writeString(this.stkawin);
        dest.writeString(this.alamat);
        dest.writeString(this.rt);
        dest.writeString(this.rw);
        dest.writeString(this.kelurahan);
        dest.writeString(this.kecamatan);
        dest.writeString(this.kabupaten);
        dest.writeString(this.propinsi);
        dest.writeString(this.dusun);
    }

    public PendudukData() {
    }

    protected PendudukData(Parcel in) {
        this.nik = in.readString();
        this.no_kk = in.readString();
        this.nama_depan = in.readString();
        this.nama_belakang = in.readString();
        this.jekel = in.readString();
        this.umur = in.readString();
        this.tempat_lhr = in.readString();
        this.tanggal_lhr = in.readString();
        this.nama_ayah = in.readString();
        this.nama_ibu = in.readString();
        this.anak_ke = in.readString();
        this.status = in.readString();
        this.tgl_mutasi = in.readString();
        this.agama = in.readString();
        this.goldar = in.readString();
        this.hubkel = in.readString();
        this.kerja = in.readString();
        this.pendidikan = in.readString();
        this.stkawin = in.readString();
        this.alamat = in.readString();
        this.rt = in.readString();
        this.rw = in.readString();
        this.kelurahan = in.readString();
        this.kecamatan = in.readString();
        this.kabupaten = in.readString();
        this.propinsi = in.readString();
        this.dusun = in.readString();
    }

    public static final Parcelable.Creator<PendudukData> CREATOR = new Parcelable.Creator<PendudukData>() {
        @Override
        public PendudukData createFromParcel(Parcel source) {
            return new PendudukData(source);
        }

        @Override
        public PendudukData[] newArray(int size) {
            return new PendudukData[size];
        }
    };
}
