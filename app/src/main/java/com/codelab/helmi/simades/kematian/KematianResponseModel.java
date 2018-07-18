package com.codelab.helmi.simades.kematian;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class KematianResponseModel {

	@SerializedName("result")
	private List<KematianData> result;

	@SerializedName("kode")
	private int kode;

	public void setResult(List<KematianData> result){
		this.result = result;
	}

	public List<KematianData> getResult(){
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
			"KematianResponseModel{" +
			"result = '" + result + '\'' + 
			",kode = '" + kode + '\'' + 
			"}";
		}
}