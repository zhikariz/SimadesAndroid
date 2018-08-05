package com.codelab.helmi.simades.layanan;


import com.google.gson.annotations.SerializedName;


public class SuratKehilanganItem{

	@SerializedName("barang")
	private String barang;

	@SerializedName("nama_depan")
	private String namaDepan;

	@SerializedName("tgl_hilang")
	private String tglHilang;

	@SerializedName("kd_surat")
	private String kdSurat;

	@SerializedName("id_surat")
	private String idSurat;

	@SerializedName("nama_belakang")
	private String namaBelakang;

	@SerializedName("status_persetujuan")
	private String statusPersetujuan;

	@SerializedName("nik")
	private String nik;

	@SerializedName("sebab")
	private String sebab;

	@SerializedName("tpt_hilang")
	private String tptHilang;

	@SerializedName("no_surat")
	private String noSurat;

	@SerializedName("tgl_surat")
	private String tglSurat;

	@SerializedName("nama_depan_user")
	private String namaDepanUser;

	@SerializedName("nama_belakang_user")
	private String namaBelakangUser;

	public void setBarang(String barang){
		this.barang = barang;
	}

	public String getBarang(){
		return barang;
	}

	public void setNamaDepan(String namaDepan){
		this.namaDepan = namaDepan;
	}

	public String getNamaDepan(){
		return namaDepan;
	}

	public void setTglHilang(String tglHilang){
		this.tglHilang = tglHilang;
	}

	public String getTglHilang(){
		return tglHilang;
	}

	public void setKdSurat(String kdSurat){
		this.kdSurat = kdSurat;
	}

	public String getKdSurat(){
		return kdSurat;
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

	public void setSebab(String sebab){
		this.sebab = sebab;
	}

	public String getSebab(){
		return sebab;
	}

	public void setTptHilang(String tptHilang){
		this.tptHilang = tptHilang;
	}

	public String getTptHilang(){
		return tptHilang;
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
			"SuratKehilanganItem{" + 
			"barang = '" + barang + '\'' + 
			",nama_depan = '" + namaDepan + '\'' + 
			",tgl_hilang = '" + tglHilang + '\'' + 
			",kd_surat = '" + kdSurat + '\'' + 
			",id_surat = '" + idSurat + '\'' + 
			",nama_belakang = '" + namaBelakang + '\'' + 
			",status_persetujuan = '" + statusPersetujuan + '\'' + 
			",nik = '" + nik + '\'' + 
			",sebab = '" + sebab + '\'' + 
			",tpt_hilang = '" + tptHilang + '\'' + 
			",no_surat = '" + noSurat + '\'' + 
			",tgl_surat = '" + tglSurat + '\'' + 
			",nama_depan_user = '" + namaDepanUser + '\'' + 
			",nama_belakang_user = '" + namaBelakangUser + '\'' + 
			"}";
		}
}