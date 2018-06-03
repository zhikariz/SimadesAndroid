package com.codelab.helmi.simades.surat.kelahiran;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class SuratKelahiranData implements Parcelable {

    @SerializedName("id_surat")
    private String id_surat;
    @SerializedName("kd_surat")
    private String kd_surat;
    @SerializedName("no_surat")
    private String no_surat;
    @SerializedName("jenis_surat")
    private String jenis_surat;
    @SerializedName("tgl_surat")
    private String tgl_surat;
    @SerializedName("waktu")
    private String waktu;
    @SerializedName("status_persetujuan")
    private String status_persetujuan;
    @SerializedName("nik")
    private String nik;
    @SerializedName("nik_ayah")
    private String nik_ayah;
    @SerializedName("nik_ibu")
    private String nik_ibu;
    @SerializedName("nama_saksi1")
    private String nama_saksi1;
    @SerializedName("nama_saksi2")
    private String nama_saksi2;
    @SerializedName("id_user_ttd")
    private String id_user_ttd;
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
    @SerializedName("id_agama")
    private String id_agama;
    @SerializedName("id_goldar")
    private String id_goldar;
    @SerializedName("id_stskawin")
    private String id_stskawin;
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
    @SerializedName("id_kerja")
    private String id_kerja;
    @SerializedName("id_hubkel")
    private String id_hubkel;
    @SerializedName("id_pendidikan")
    private String id_pendidikan;
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
    @SerializedName("dusun")
    private String dusun;


    public String getId_surat() {
        return id_surat;
    }

    public void setId_surat(String id_surat) {
        this.id_surat = id_surat;
    }

    public String getKd_surat() {
        return kd_surat;
    }

    public void setKd_surat(String kd_surat) {
        this.kd_surat = kd_surat;
    }

    public String getNo_surat() {
        return no_surat;
    }

    public void setNo_surat(String no_surat) {
        this.no_surat = no_surat;
    }

    public String getJenis_surat() {
        return jenis_surat;
    }

    public void setJenis_surat(String jenis_surat) {
        this.jenis_surat = jenis_surat;
    }

    public String getTgl_surat() {
        return tgl_surat;
    }

    public void setTgl_surat(String tgl_surat) {
        this.tgl_surat = tgl_surat;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getStatus_persetujuan() {
        return status_persetujuan;
    }

    public void setStatus_persetujuan(String status_persetujuan) {
        this.status_persetujuan = status_persetujuan;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
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

    public String getNama_saksi1() {
        return nama_saksi1;
    }

    public void setNama_saksi1(String nama_saksi1) {
        this.nama_saksi1 = nama_saksi1;
    }

    public String getNama_saksi2() {
        return nama_saksi2;
    }

    public void setNama_saksi2(String nama_saksi2) {
        this.nama_saksi2 = nama_saksi2;
    }

    public String getId_user_ttd() {
        return id_user_ttd;
    }

    public void setId_user_ttd(String id_user_ttd) {
        this.id_user_ttd = id_user_ttd;
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

    public String getId_agama() {
        return id_agama;
    }

    public void setId_agama(String id_agama) {
        this.id_agama = id_agama;
    }

    public String getId_goldar() {
        return id_goldar;
    }

    public void setId_goldar(String id_goldar) {
        this.id_goldar = id_goldar;
    }

    public String getId_stskawin() {
        return id_stskawin;
    }

    public void setId_stskawin(String id_stskawin) {
        this.id_stskawin = id_stskawin;
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

    public String getId_kerja() {
        return id_kerja;
    }

    public void setId_kerja(String id_kerja) {
        this.id_kerja = id_kerja;
    }

    public String getId_hubkel() {
        return id_hubkel;
    }

    public void setId_hubkel(String id_hubkel) {
        this.id_hubkel = id_hubkel;
    }

    public String getId_pendidikan() {
        return id_pendidikan;
    }

    public void setId_pendidikan(String id_pendidikan) {
        this.id_pendidikan = id_pendidikan;
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
        dest.writeString(this.id_surat);
        dest.writeString(this.kd_surat);
        dest.writeString(this.no_surat);
        dest.writeString(this.jenis_surat);
        dest.writeString(this.tgl_surat);
        dest.writeString(this.waktu);
        dest.writeString(this.status_persetujuan);
        dest.writeString(this.nik);
        dest.writeString(this.nik_ayah);
        dest.writeString(this.nik_ibu);
        dest.writeString(this.nama_saksi1);
        dest.writeString(this.nama_saksi2);
        dest.writeString(this.id_user_ttd);
        dest.writeString(this.no_kk);
        dest.writeString(this.nama_depan);
        dest.writeString(this.nama_belakang);
        dest.writeString(this.jekel);
        dest.writeString(this.umur);
        dest.writeString(this.id_agama);
        dest.writeString(this.id_goldar);
        dest.writeString(this.id_stskawin);
        dest.writeString(this.tempat_lhr);
        dest.writeString(this.tanggal_lhr);
        dest.writeString(this.nama_ayah);
        dest.writeString(this.nama_ibu);
        dest.writeString(this.anak_ke);
        dest.writeString(this.id_kerja);
        dest.writeString(this.id_hubkel);
        dest.writeString(this.id_pendidikan);
        dest.writeString(this.status);
        dest.writeString(this.tgl_mutasi);
        dest.writeString(this.agama);
        dest.writeString(this.goldar);
        dest.writeString(this.hubkel);
        dest.writeString(this.kerja);
        dest.writeString(this.pendidikan);
        dest.writeString(this.stkawin);
        dest.writeString(this.alamat);
        dest.writeString(this.id_dusun);
        dest.writeString(this.rt);
        dest.writeString(this.rw);
        dest.writeString(this.kelurahan);
        dest.writeString(this.kecamatan);
        dest.writeString(this.kabupaten);
        dest.writeString(this.propinsi);
        dest.writeString(this.dusun);
    }

    public SuratKelahiranData() {
    }

    protected SuratKelahiranData(Parcel in) {
        this.id_surat = in.readString();
        this.kd_surat = in.readString();
        this.no_surat = in.readString();
        this.jenis_surat = in.readString();
        this.tgl_surat = in.readString();
        this.waktu = in.readString();
        this.status_persetujuan = in.readString();
        this.nik = in.readString();
        this.nik_ayah = in.readString();
        this.nik_ibu = in.readString();
        this.nama_saksi1 = in.readString();
        this.nama_saksi2 = in.readString();
        this.id_user_ttd = in.readString();
        this.no_kk = in.readString();
        this.nama_depan = in.readString();
        this.nama_belakang = in.readString();
        this.jekel = in.readString();
        this.umur = in.readString();
        this.id_agama = in.readString();
        this.id_goldar = in.readString();
        this.id_stskawin = in.readString();
        this.tempat_lhr = in.readString();
        this.tanggal_lhr = in.readString();
        this.nama_ayah = in.readString();
        this.nama_ibu = in.readString();
        this.anak_ke = in.readString();
        this.id_kerja = in.readString();
        this.id_hubkel = in.readString();
        this.id_pendidikan = in.readString();
        this.status = in.readString();
        this.tgl_mutasi = in.readString();
        this.agama = in.readString();
        this.goldar = in.readString();
        this.hubkel = in.readString();
        this.kerja = in.readString();
        this.pendidikan = in.readString();
        this.stkawin = in.readString();
        this.alamat = in.readString();
        this.id_dusun = in.readString();
        this.rt = in.readString();
        this.rw = in.readString();
        this.kelurahan = in.readString();
        this.kecamatan = in.readString();
        this.kabupaten = in.readString();
        this.propinsi = in.readString();
        this.dusun = in.readString();
    }

    public static final Parcelable.Creator<SuratKelahiranData> CREATOR = new Parcelable.Creator<SuratKelahiranData>() {
        @Override
        public SuratKelahiranData createFromParcel(Parcel source) {
            return new SuratKelahiranData(source);
        }

        @Override
        public SuratKelahiranData[] newArray(int size) {
            return new SuratKelahiranData[size];
        }
    };
}
