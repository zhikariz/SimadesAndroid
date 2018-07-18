package com.codelab.helmi.simades.kelahiran;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class KelahiranData implements Parcelable {

    public static final Parcelable.Creator<KelahiranData> CREATOR = new Parcelable.Creator<KelahiranData>() {
        @Override
        public KelahiranData createFromParcel(Parcel source) {
            return new KelahiranData(source);
        }

        @Override
        public KelahiranData[] newArray(int size) {
            return new KelahiranData[size];
        }
    };
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
    @SerializedName("nama_depan_ayah")
    private String nama_depan_ayah;
    @SerializedName("nama_belakang_ayah")
    private String nama_belakang_ayah;
    @SerializedName("nik_ibu")
    private String nik_ibu;
    @SerializedName("nama_depan_ibu")
    private String nama_depan_ibu;
    @SerializedName("nama_belakang_ibu")
    private String nama_belakang_ibu;
    @SerializedName("nik_saksi1")
    private String nik_saksi1;
    @SerializedName("nama_depan_saksi1")
    private String nama_depan_saksi1;
    @SerializedName("nama_belakang_saksi1")
    private String nama_belakang_saksi1;
    @SerializedName("nik_saksi2")
    private String nik_saksi2;
    @SerializedName("nama_depan_saksi2")
    private String nama_depan_saksi2;
    @SerializedName("nama_belakang_saksi2")
    private String nama_belakang_saksi2;

    public KelahiranData() {
    }

    protected KelahiranData(Parcel in) {
        this.id_lahir = in.readString();
        this.nis_bayi = in.readString();
        this.nama_depan_bayi = in.readString();
        this.nama_belakang_bayi = in.readString();
        this.tgl_lahir = in.readString();
        this.tpt_lahir = in.readString();
        this.jekel = in.readString();
        this.berat_bayi = in.readString();
        this.anak_ke = in.readString();
        this.waktu = in.readString();
        this.panjang_bayi = in.readString();
        this.nik_ayah = in.readString();
        this.nama_depan_ayah = in.readString();
        this.nama_belakang_ayah = in.readString();
        this.nik_ibu = in.readString();
        this.nama_depan_ibu = in.readString();
        this.nama_belakang_ibu = in.readString();
        this.nik_saksi1 = in.readString();
        this.nama_depan_saksi1 = in.readString();
        this.nama_belakang_saksi1 = in.readString();
        this.nik_saksi2 = in.readString();
        this.nama_depan_saksi2 = in.readString();
        this.nama_belakang_saksi2 = in.readString();
    }

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

    public String getNama_depan_ayah() {
        return nama_depan_ayah;
    }

    public void setNama_depan_ayah(String nama_depan_ayah) {
        this.nama_depan_ayah = nama_depan_ayah;
    }

    public String getNama_belakang_ayah() {
        return nama_belakang_ayah;
    }

    public void setNama_belakang_ayah(String nama_belakang_ayah) {
        this.nama_belakang_ayah = nama_belakang_ayah;
    }

    public String getNik_ibu() {
        return nik_ibu;
    }

    public void setNik_ibu(String nik_ibu) {
        this.nik_ibu = nik_ibu;
    }

    public String getNama_depan_ibu() {
        return nama_depan_ibu;
    }

    public void setNama_depan_ibu(String nama_depan_ibu) {
        this.nama_depan_ibu = nama_depan_ibu;
    }

    public String getNama_belakang_ibu() {
        return nama_belakang_ibu;
    }

    public void setNama_belakang_ibu(String nama_belakang_ibu) {
        this.nama_belakang_ibu = nama_belakang_ibu;
    }

    public String getNik_saksi1() {
        return nik_saksi1;
    }

    public void setNik_saksi1(String nik_saksi1) {
        this.nik_saksi1 = nik_saksi1;
    }

    public String getNama_depan_saksi1() {
        return nama_depan_saksi1;
    }

    public void setNama_depan_saksi1(String nama_depan_saksi1) {
        this.nama_depan_saksi1 = nama_depan_saksi1;
    }

    public String getNama_belakang_saksi1() {
        return nama_belakang_saksi1;
    }

    public void setNama_belakang_saksi1(String nama_belakang_saksi1) {
        this.nama_belakang_saksi1 = nama_belakang_saksi1;
    }

    public String getNik_saksi2() {
        return nik_saksi2;
    }

    public void setNik_saksi2(String nik_saksi2) {
        this.nik_saksi2 = nik_saksi2;
    }

    public String getNama_depan_saksi2() {
        return nama_depan_saksi2;
    }

    public void setNama_depan_saksi2(String nama_depan_saksi2) {
        this.nama_depan_saksi2 = nama_depan_saksi2;
    }

    public String getNama_belakang_saksi2() {
        return nama_belakang_saksi2;
    }

    public void setNama_belakang_saksi2(String nama_belakang_saksi2) {
        this.nama_belakang_saksi2 = nama_belakang_saksi2;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id_lahir);
        dest.writeString(this.nis_bayi);
        dest.writeString(this.nama_depan_bayi);
        dest.writeString(this.nama_belakang_bayi);
        dest.writeString(this.tgl_lahir);
        dest.writeString(this.tpt_lahir);
        dest.writeString(this.jekel);
        dest.writeString(this.berat_bayi);
        dest.writeString(this.anak_ke);
        dest.writeString(this.waktu);
        dest.writeString(this.panjang_bayi);
        dest.writeString(this.nik_ayah);
        dest.writeString(this.nama_depan_ayah);
        dest.writeString(this.nama_belakang_ayah);
        dest.writeString(this.nik_ibu);
        dest.writeString(this.nama_depan_ibu);
        dest.writeString(this.nama_belakang_ibu);
        dest.writeString(this.nik_saksi1);
        dest.writeString(this.nama_depan_saksi1);
        dest.writeString(this.nama_belakang_saksi1);
        dest.writeString(this.nik_saksi2);
        dest.writeString(this.nama_depan_saksi2);
        dest.writeString(this.nama_belakang_saksi2);
    }
}
