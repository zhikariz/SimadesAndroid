package com.codelab.helmi.simades.layanan;

import com.google.gson.annotations.SerializedName;

public class SuratTidakMampuItem{

	@SerializedName("sekolah")
	private String sekolah;

	@SerializedName("nama_depan")
	private String namaDepan;

	@SerializedName("nama_depan_wali")
	private String namaDepanWali;

	@SerializedName("kd_surat")
	private String kdSurat;

	@SerializedName("jurusan")
	private String jurusan;

	@SerializedName("id_surat")
	private String idSurat;

	@SerializedName("nama_belakang")
	private String namaBelakang;

	@SerializedName("nik_wali")
	private String nikWali;

	@SerializedName("status_persetujuan")
	private String statusPersetujuan;

	@SerializedName("nik")
	private String nik;

	@SerializedName("nama_belakang_wali")
	private Object namaBelakangWali;

	@SerializedName("kelas")
	private String kelas;

	@SerializedName("no_surat")
	private String noSurat;

	@SerializedName("tgl_surat")
	private String tglSurat;

	@SerializedName("nama_depan_user")
	private String namaDepanUser;

	@SerializedName("nama_belakang_user")
	private String namaBelakangUser;

	public void setSekolah(String sekolah){
		this.sekolah = sekolah;
	}

	public String getSekolah(){
		return sekolah;
	}

	public void setNamaDepan(String namaDepan){
		this.namaDepan = namaDepan;
	}

	public String getNamaDepan(){
		return namaDepan;
	}

	public void setNamaDepanWali(String namaDepanWali){
		this.namaDepanWali = namaDepanWali;
	}

	public String getNamaDepanWali(){
		return namaDepanWali;
	}

	public void setKdSurat(String kdSurat){
		this.kdSurat = kdSurat;
	}

	public String getKdSurat(){
		return kdSurat;
	}

	public void setJurusan(String jurusan){
		this.jurusan = jurusan;
	}

	public String getJurusan(){
		return jurusan;
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

	public void setNikWali(String nikWali){
		this.nikWali = nikWali;
	}

	public String getNikWali(){
		return nikWali;
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

	public void setNamaBelakangWali(Object namaBelakangWali){
		this.namaBelakangWali = namaBelakangWali;
	}

	public Object getNamaBelakangWali(){
		return namaBelakangWali;
	}

	public void setKelas(String kelas){
		this.kelas = kelas;
	}

	public String getKelas(){
		return kelas;
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
			"SuratTidakMampuItem{" + 
			"sekolah = '" + sekolah + '\'' + 
			",nama_depan = '" + namaDepan + '\'' + 
			",nama_depan_wali = '" + namaDepanWali + '\'' + 
			",kd_surat = '" + kdSurat + '\'' + 
			",jurusan = '" + jurusan + '\'' + 
			",id_surat = '" + idSurat + '\'' + 
			",nama_belakang = '" + namaBelakang + '\'' + 
			",nik_wali = '" + nikWali + '\'' + 
			",status_persetujuan = '" + statusPersetujuan + '\'' + 
			",nik = '" + nik + '\'' + 
			",nama_belakang_wali = '" + namaBelakangWali + '\'' + 
			",kelas = '" + kelas + '\'' + 
			",no_surat = '" + noSurat + '\'' + 
			",tgl_surat = '" + tglSurat + '\'' + 
			",nama_depan_user = '" + namaDepanUser + '\'' + 
			",nama_belakang_user = '" + namaBelakangUser + '\'' + 
			"}";
		}
}