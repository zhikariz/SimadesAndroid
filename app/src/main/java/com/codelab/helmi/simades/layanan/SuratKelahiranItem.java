package com.codelab.helmi.simades.layanan;


import com.google.gson.annotations.SerializedName;


public class SuratKelahiranItem{

	@SerializedName("status_persetujuan")
	private String statusPersetujuan;

	@SerializedName("nik")
	private String nik;

	@SerializedName("nama_depan")
	private String namaDepan;

	@SerializedName("waktu")
	private String waktu;

	@SerializedName("kd_surat")
	private String kdSurat;

	@SerializedName("no_surat")
	private String noSurat;

	@SerializedName("tgl_surat")
	private String tglSurat;

	@SerializedName("nama_depan_user")
	private String namaDepanUser;

	@SerializedName("id_surat")
	private String idSurat;

	@SerializedName("nama_belakang")
	private String namaBelakang;

	@SerializedName("nama_belakang_user")
	private String namaBelakangUser;

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

	public void setNamaDepan(String namaDepan){
		this.namaDepan = namaDepan;
	}

	public String getNamaDepan(){
		return namaDepan;
	}

	public void setWaktu(String waktu){
		this.waktu = waktu;
	}

	public String getWaktu(){
		return waktu;
	}

	public void setKdSurat(String kdSurat){
		this.kdSurat = kdSurat;
	}

	public String getKdSurat(){
		return kdSurat;
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

	public void setNamaBelakangUser(String namaBelakangUser){
		this.namaBelakangUser = namaBelakangUser;
	}

	public String getNamaBelakangUser(){
		return namaBelakangUser;
	}

	@Override
 	public String toString(){
		return 
			"SuratKelahiranItem{" + 
			"status_persetujuan = '" + statusPersetujuan + '\'' + 
			",nik = '" + nik + '\'' + 
			",nama_depan = '" + namaDepan + '\'' + 
			",waktu = '" + waktu + '\'' + 
			",kd_surat = '" + kdSurat + '\'' + 
			",no_surat = '" + noSurat + '\'' + 
			",tgl_surat = '" + tglSurat + '\'' + 
			",nama_depan_user = '" + namaDepanUser + '\'' + 
			",id_surat = '" + idSurat + '\'' + 
			",nama_belakang = '" + namaBelakang + '\'' + 
			",nama_belakang_user = '" + namaBelakangUser + '\'' + 
			"}";
		}
}