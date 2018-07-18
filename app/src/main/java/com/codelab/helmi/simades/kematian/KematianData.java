package com.codelab.helmi.simades.kematian;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class KematianData implements Parcelable {

    public static final Parcelable.Creator<KematianData> CREATOR = new Parcelable.Creator<KematianData>() {
        @Override
        public KematianData createFromParcel(Parcel source) {
            return new KematianData(source);
        }

        @Override
        public KematianData[] newArray(int size) {
            return new KematianData[size];
        }
    };
    @SerializedName("nik_meninggal")
    private String nikMeninggal;
    @SerializedName("umur")
    private String umur;
    @SerializedName("id_agama")
    private String idAgama;
    @SerializedName("nama_ibu")
    private String namaIbu;
    @SerializedName("tgl_meninggal")
    private String tglMeninggal;
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
    @SerializedName("no_kk")
    private String noKk;
    @SerializedName("tanggal_lhr")
    private String tanggalLhr;
    @SerializedName("menerangkan")
    private String menerangkan;
    @SerializedName("nama_depan")
    private String namaDepan;
    @SerializedName("id_hubkel")
    private String idHubkel;
    @SerializedName("id_mati")
    private String idMati;
    @SerializedName("nama_belakang")
    private String namaBelakang;
    @SerializedName("sebab")
    private String sebab;
    @SerializedName("jekel")
    private String jekel;
    @SerializedName("tpt_meninggal")
    private String tptMeninggal;
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

    public KematianData() {
    }

    protected KematianData(Parcel in) {
        this.nikMeninggal = in.readString();
        this.umur = in.readString();
        this.idAgama = in.readString();
        this.namaIbu = in.readString();
        this.tglMeninggal = in.readString();
        this.tempatLhr = in.readString();
        this.idPendidikan = in.readString();
        this.nik = in.readString();
        this.idKerja = in.readString();
        this.idStskawin = in.readString();
        this.noKk = in.readString();
        this.tanggalLhr = in.readString();
        this.menerangkan = in.readString();
        this.namaDepan = in.readString();
        this.idHubkel = in.readString();
        this.idMati = in.readString();
        this.namaBelakang = in.readString();
        this.sebab = in.readString();
        this.jekel = in.readString();
        this.tptMeninggal = in.readString();
        this.tglMutasi = in.readString();
        this.namaAyah = in.readString();
        this.anakKe = in.readString();
        this.idGoldar = in.readString();
        this.status = in.readString();
    }

    public String getNikMeninggal() {
        return nikMeninggal;
    }

    public void setNikMeninggal(String nikMeninggal) {
        this.nikMeninggal = nikMeninggal;
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

    public String getTglMeninggal() {
        return tglMeninggal;
    }

    public void setTglMeninggal(String tglMeninggal) {
        this.tglMeninggal = tglMeninggal;
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

    public String getMenerangkan() {
        return menerangkan;
    }

    public void setMenerangkan(String menerangkan) {
        this.menerangkan = menerangkan;
    }

    public String getNamaDepan() {
        return namaDepan;
    }

    public void setNamaDepan(String namaDepan) {
        this.namaDepan = namaDepan;
    }

    public String getIdHubkel() {
        return idHubkel;
    }

    public void setIdHubkel(String idHubkel) {
        this.idHubkel = idHubkel;
    }

    public String getIdMati() {
        return idMati;
    }

    public void setIdMati(String idMati) {
        this.idMati = idMati;
    }

    public String getNamaBelakang() {
        return namaBelakang;
    }

    public void setNamaBelakang(String namaBelakang) {
        this.namaBelakang = namaBelakang;
    }

    public String getSebab() {
        return sebab;
    }

    public void setSebab(String sebab) {
        this.sebab = sebab;
    }

    public String getJekel() {
        return jekel;
    }

    public void setJekel(String jekel) {
        this.jekel = jekel;
    }

    public String getTptMeninggal() {
        return tptMeninggal;
    }

    public void setTptMeninggal(String tptMeninggal) {
        this.tptMeninggal = tptMeninggal;
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
                "KematianData{" +
                        "nik_meninggal = '" + nikMeninggal + '\'' +
                        ",umur = '" + umur + '\'' +
                        ",id_agama = '" + idAgama + '\'' +
                        ",nama_ibu = '" + namaIbu + '\'' +
                        ",tgl_meninggal = '" + tglMeninggal + '\'' +
                        ",tempat_lhr = '" + tempatLhr + '\'' +
                        ",id_pendidikan = '" + idPendidikan + '\'' +
                        ",nik = '" + nik + '\'' +
                        ",id_kerja = '" + idKerja + '\'' +
                        ",id_stskawin = '" + idStskawin + '\'' +
                        ",no_kk = '" + noKk + '\'' +
                        ",tanggal_lhr = '" + tanggalLhr + '\'' +
                        ",menerangkan = '" + menerangkan + '\'' +
                        ",nama_depan = '" + namaDepan + '\'' +
                        ",id_hubkel = '" + idHubkel + '\'' +
                        ",id_mati = '" + idMati + '\'' +
                        ",nama_belakang = '" + namaBelakang + '\'' +
                        ",sebab = '" + sebab + '\'' +
                        ",jekel = '" + jekel + '\'' +
                        ",tpt_meninggal = '" + tptMeninggal + '\'' +
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
        dest.writeString(this.nikMeninggal);
        dest.writeString(this.umur);
        dest.writeString(this.idAgama);
        dest.writeString(this.namaIbu);
        dest.writeString(this.tglMeninggal);
        dest.writeString(this.tempatLhr);
        dest.writeString(this.idPendidikan);
        dest.writeString(this.nik);
        dest.writeString(this.idKerja);
        dest.writeString(this.idStskawin);
        dest.writeString(this.noKk);
        dest.writeString(this.tanggalLhr);
        dest.writeString(this.menerangkan);
        dest.writeString(this.namaDepan);
        dest.writeString(this.idHubkel);
        dest.writeString(this.idMati);
        dest.writeString(this.namaBelakang);
        dest.writeString(this.sebab);
        dest.writeString(this.jekel);
        dest.writeString(this.tptMeninggal);
        dest.writeString(this.tglMutasi);
        dest.writeString(this.namaAyah);
        dest.writeString(this.anakKe);
        dest.writeString(this.idGoldar);
        dest.writeString(this.status);
    }
}