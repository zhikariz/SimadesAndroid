package com.codelab.helmi.simades.pergi;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class PergiResponseModel{

	@SerializedName("result")
	private List<PergiData> result;

	@SerializedName("kode")
	private int kode;

	public void setResult(List<PergiData> result){
		this.result = result;
	}

	public List<PergiData> getResult(){
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
			"PergiResponseModel{" + 
			"result = '" + result + '\'' + 
			",kode = '" + kode + '\'' + 
			"}";
		}
}