package com.codelab.helmi.simades.layanan;


import com.google.gson.annotations.SerializedName;


public class LayananResponseModel{

	@SerializedName("result")
	private Result result;

	@SerializedName("kode")
	private int kode;

	public void setResult(Result result){
		this.result = result;
	}

	public Result getResult(){
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
			"LayananResponseModel{" + 
			"result = '" + result + '\'' + 
			",kode = '" + kode + '\'' + 
			"}";
		}
}