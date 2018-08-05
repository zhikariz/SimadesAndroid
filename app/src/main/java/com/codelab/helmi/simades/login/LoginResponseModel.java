package com.codelab.helmi.simades.login;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class LoginResponseModel{

	@SerializedName("result")
	private List<LoginData> result;

	@SerializedName("kode")
	private int kode;

	public void setResult(List<LoginData> result){
		this.result = result;
	}

	public List<LoginData> getResult(){
		return result;
	}

	public void setKode(int kode){
		this.kode = kode;
	}

	public int getKode(){
		return kode;
	}

	@Override
 	public String toString(){
		return 
			"LoginResponseModel{" + 
			"result = '" + result + '\'' + 
			",kode = '" + kode + '\'' + 
			"}";
		}
}