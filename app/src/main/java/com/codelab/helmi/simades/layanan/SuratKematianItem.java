package com.codelab.helmi.simades.layanan;


import com.google.gson.annotations.SerializedName;


public class SuratKematianItem{

	@SerializedName("alamat_saksi1")
	private String alamatSaksi1;

	@SerializedName("nik_meninggal")
	private String nikMeninggal;

	@SerializedName("alamat_saksi2")
	private String alamatSaksi2;

	@SerializedName("umur_saksi1")
	private String umurSaksi1;

	@SerializedName("umur_saksi2")
	private String umurSaksi2;

	@SerializedName("tgl_meninggal")
	private String tglMeninggal;

	@SerializedName("kd_surat")
	private String kdSurat;

	@SerializedName("hari_meninggal")
	private String hariMeninggal;

	@SerializedName("nama_depan_pengaju")
	private String namaDepanPengaju;

	@SerializedName("id_surat")
	private String idSurat;

	@SerializedName("nama_depan_meninggal")
	private String namaDepanMeninggal;

	@SerializedName("status_persetujuan")
	private String statusPersetujuan;

	@SerializedName("nik")
	private String nik;

	@SerializedName("sebab_meninggal")
	private String sebabMeninggal;

	@SerializedName("nama_saksi1")
	private String namaSaksi1;

	@SerializedName("nama_saksi2")
	private String namaSaksi2;

	@SerializedName("nama_belakang_pengaju")
	private String namaBelakangPengaju;

	@SerializedName("no_surat")
	private String noSurat;

	@SerializedName("tgl_surat")
	private String tglSurat;

	@SerializedName("nama_depan_user")
	private String namaDepanUser;

	@SerializedName("nama_belakang_meninggal")
	private String namaBelakangMeninggal;

	@SerializedName("nama_belakang_user")
	private String namaBelakangUser;

	public void setAlamatSaksi1(String alamatSaksi1){
		this.alamatSaksi1 = alamatSaksi1;
	}

	public String getAlamatSaksi1(){
		return alamatSaksi1;
	}

	public void setNikMeninggal(String nikMeninggal){
		this.nikMeninggal = nikMeninggal;
	}

	public String getNikMeninggal(){
		return nikMeninggal;
	}

	public void setAlamatSaksi2(String alamatSaksi2){
		this.alamatSaksi2 = alamatSaksi2;
	}

	public String getAlamatSaksi2(){
		return alamatSaksi2;
	}

	public void setUmurSaksi1(String umurSaksi1){
		this.umurSaksi1 = umurSaksi1;
	}

	public String getUmurSaksi1(){
		return umurSaksi1;
	}

	public void setUmurSaksi2(String umurSaksi2){
		this.umurSaksi2 = umurSaksi2;
	}

	public String getUmurSaksi2(){
		return umurSaksi2;
	}

	public void setTglMeninggal(String tglMeninggal){
		this.tglMeninggal = tglMeninggal;
	}

	public String getTglMeninggal(){
		return tglMeninggal;
	}

	public void setKdSurat(String kdSurat){
		this.kdSurat = kdSurat;
	}

	public String getKdSurat(){
		return kdSurat;
	}

	public void setHariMeninggal(String hariMeninggal){
		this.hariMeninggal = hariMeninggal;
	}

	public String getHariMeninggal(){
		return hariMeninggal;
	}

	public void setNamaDepanPengaju(String namaDepanPengaju){
		this.namaDepanPengaju = namaDepanPengaju;
	}

	public String getNamaDepanPengaju(){
		return namaDepanPengaju;
	}

	public void setIdSurat(String idSurat){
		this.idSurat = idSurat;
	}

	public String getIdSurat(){
		return idSurat;
	}

	public void setNamaDepanMeninggal(String namaDepanMeninggal){
		this.namaDepanMeninggal = namaDepanMeninggal;
	}

	public String getNamaDepanMeninggal(){
		return namaDepanMeninggal;
	}

	public void setStatusPersetujuan(String statusPersetujuan){
		this.statusPersetujuan = statusPersetujuan;
	}

	public String getStatusPersetujuan(){
		return statusPersetujuan;
	}

	public void setNik(String nik){
		this.nik = nik;
	}

	public String getNik(){
		return nik;
	}

	public void setSebabMeninggal(String sebabMeninggal){
		this.sebabMeninggal = sebabMeninggal;
	}

	public String getSebabMeninggal(){
		return sebabMeninggal;
	}

	public void setNamaSaksi1(String namaSaksi1){
		this.namaSaksi1 = namaSaksi1;
	}

	public String getNamaSaksi1(){
		return namaSaksi1;
	}

	public void setNamaSaksi2(String namaSaksi2){
		this.namaSaksi2 = namaSaksi2;
	}

	public String getNamaSaksi2(){
		return namaSaksi2;
	}

	public void setNamaBelakangPengaju(String namaBelakangPengaju){
		this.namaBelakangPengaju = namaBelakangPengaju;
	}

	public String getNamaBelakangPengaju(){
		return namaBelakangPengaju;
	}

	public void setNoSurat(String noSurat){
		this.noSurat = noSurat;
	}

	public String getNoSurat(){
		return noSurat;
	}

	public void setTglSurat(String tglSurat){
		this.tglSurat = tglSurat;
	}

	public String getTglSurat(){
		return tglSurat;
	}

	public void setNamaDepanUser(String namaDepanUser){
		this.namaDepanUser = namaDepanUser;
	}

	public String getNamaDepanUser(){
		return namaDepanUser;
	}

	public void setNamaBelakangMeninggal(String namaBelakangMeninggal){
		this.namaBelakangMeninggal = namaBelakangMeninggal;
	}

	public String getNamaBelakangMeninggal(){
		return namaBelakangMeninggal;
	}

	public void setNamaBelakangUser(String namaBelakangUser){
		this.namaBelakangUser = namaBelakangUser;
	}

	public String getNamaBelakangUser(){
		return namaBelakangUser;
	}

	@Override
 	public String toString(){
		return 
			"SuratKematianItem{" + 
			"alamat_saksi1 = '" + alamatSaksi1 + '\'' + 
			",nik_meninggal = '" + nikMeninggal + '\'' + 
			",alamat_saksi2 = '" + alamatSaksi2 + '\'' + 
			",umur_saksi1 = '" + umurSaksi1 + '\'' + 
			",umur_saksi2 = '" + umurSaksi2 + '\'' + 
			",tgl_meninggal = '" + tglMeninggal + '\'' + 
			",kd_surat = '" + kdSurat + '\'' + 
			",hari_meninggal = '" + hariMeninggal + '\'' + 
			",nama_depan_pengaju = '" + namaDepanPengaju + '\'' + 
			",id_surat = '" + idSurat + '\'' + 
			",nama_depan_meninggal = '" + namaDepanMeninggal + '\'' + 
			",status_persetujuan = '" + statusPersetujuan + '\'' + 
			",nik = '" + nik + '\'' + 
			",sebab_meninggal = '" + sebabMeninggal + '\'' + 
			",nama_saksi1 = '" + namaSaksi1 + '\'' + 
			",nama_saksi2 = '" + namaSaksi2 + '\'' + 
			",nama_belakang_pengaju = '" + namaBelakangPengaju + '\'' + 
			",no_surat = '" + noSurat + '\'' + 
			",tgl_surat = '" + tglSurat + '\'' + 
			",nama_depan_user = '" + namaDepanUser + '\'' + 
			",nama_belakang_meninggal = '" + namaBelakangMeninggal + '\'' + 
			",nama_belakang_user = '" + namaBelakangUser + '\'' + 
			"}";
		}
}