package com.codelab.helmi.simades.layanan;

import com.google.gson.annotations.SerializedName;


public class SuratDomisiliItem{

	@SerializedName("tgl_akhir")
	private String tglAkhir;

	@SerializedName("nama_depan")
	private String namaDepan;

	@SerializedName("keperluan")
	private String keperluan;

	@SerializedName("kd_surat")
	private String kdSurat;

	@SerializedName("tgl_mulai")
	private String tglMulai;

	@SerializedName("id_surat")
	private String idSurat;

	@SerializedName("nama_belakang")
	private String namaBelakang;

	@SerializedName("status_persetujuan")
	private String statusPersetujuan;

	@SerializedName("nik")
	private String nik;

	@SerializedName("no_surat")
	private String noSurat;

	@SerializedName("tgl_surat")
	private String tglSurat;

	@SerializedName("nama_depan_user")
	private String namaDepanUser;

	@SerializedName("nama_belakang_user")
	private String namaBelakangUser;

	public void setTglAkhir(String tglAkhir){
		this.tglAkhir = tglAkhir;
	}

	public String getTglAkhir(){
		return tglAkhir;
	}

	public void setNamaDepan(String namaDepan){
		this.namaDepan = namaDepan;
	}

	public String getNamaDepan(){
		return namaDepan;
	}

	public void setKeperluan(String keperluan){
		this.keperluan = keperluan;
	}

	public String getKeperluan(){
		return keperluan;
	}

	public void setKdSurat(String kdSurat){
		this.kdSurat = kdSurat;
	}

	public String getKdSurat(){
		return kdSurat;
	}

	public void setTglMulai(String tglMulai){
		this.tglMulai = tglMulai;
	}

	public String getTglMulai(){
		return tglMulai;
	}

	public void setIdSurat(String idSurat){
		this.idSurat = idSurat;
	}

	public String getIdSurat(){
		return idSurat;
	}

	public void setNamaBelakang(String namaBelakang){
		this.namaBelakang = namaBelakang;
	}

	public String getNamaBelakang(){
		return namaBelakang;
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

	public void setNamaBelakangUser(String namaBelakangUser){
		this.namaBelakangUser = namaBelakangUser;
	}

	public String getNamaBelakangUser(){
		return namaBelakangUser;
	}

	@Override
 	public String toString(){
		return 
			"SuratDomisiliItem{" + 
			"tgl_akhir = '" + tglAkhir + '\'' + 
			",nama_depan = '" + namaDepan + '\'' + 
			",keperluan = '" + keperluan + '\'' + 
			",kd_surat = '" + kdSurat + '\'' + 
			",tgl_mulai = '" + tglMulai + '\'' + 
			",id_surat = '" + idSurat + '\'' + 
			",nama_belakang = '" + namaBelakang + '\'' + 
			",status_persetujuan = '" + statusPersetujuan + '\'' + 
			",nik = '" + nik + '\'' + 
			",no_surat = '" + noSurat + '\'' + 
			",tgl_surat = '" + tglSurat + '\'' + 
			",nama_depan_user = '" + namaDepanUser + '\'' + 
			",nama_belakang_user = '" + namaBelakangUser + '\'' + 
			"}";
		}
}