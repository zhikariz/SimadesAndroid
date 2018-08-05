package com.codelab.helmi.simades.login;

import com.google.gson.annotations.SerializedName;

public class LoginData {

	@SerializedName("id_jabatan")
	private String idJabatan;

	@SerializedName("id_memiliki")
	private String idMemiliki;

	@SerializedName("password")
	private String password;

	@SerializedName("nip")
	private String nip;

	@SerializedName("nama_depan_user")
	private String namaDepanUser;

	@SerializedName("id_user")
	private String idUser;

	@SerializedName("nama_belakang_user")
	private String namaBelakangUser;

	@SerializedName("aktif")
	private String aktif;

	@SerializedName("username")
	private String username;

	@SerializedName("status")
	private String status;

	public void setIdJabatan(String idJabatan){
		this.idJabatan = idJabatan;
	}

	public String getIdJabatan(){
		return idJabatan;
	}

	public void setIdMemiliki(String idMemiliki){
		this.idMemiliki = idMemiliki;
	}

	public String getIdMemiliki(){
		return idMemiliki;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setNip(String nip){
		this.nip = nip;
	}

	public String getNip(){
		return nip;
	}

	public void setNamaDepanUser(String namaDepanUser){
		this.namaDepanUser = namaDepanUser;
	}

	public String getNamaDepanUser(){
		return namaDepanUser;
	}

	public void setIdUser(String idUser){
		this.idUser = idUser;
	}

	public String getIdUser(){
		return idUser;
	}

	public void setNamaBelakangUser(String namaBelakangUser){
		this.namaBelakangUser = namaBelakangUser;
	}

	public String getNamaBelakangUser(){
		return namaBelakangUser;
	}

	public void setAktif(String aktif){
		this.aktif = aktif;
	}

	public String getAktif(){
		return aktif;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"LoginData{" +
			"id_jabatan = '" + idJabatan + '\'' + 
			",id_memiliki = '" + idMemiliki + '\'' + 
			",password = '" + password + '\'' + 
			",nip = '" + nip + '\'' + 
			",nama_depan_user = '" + namaDepanUser + '\'' + 
			",id_user = '" + idUser + '\'' + 
			",nama_belakang_user = '" + namaBelakangUser + '\'' + 
			",aktif = '" + aktif + '\'' + 
			",username = '" + username + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}