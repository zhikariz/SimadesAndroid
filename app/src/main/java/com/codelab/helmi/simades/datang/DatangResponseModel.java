package com.codelab.helmi.simades.datang;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class DatangResponseModel {

	@SerializedName("result")
	private List<DatangData> result;

	@SerializedName("kode")
	private int kode;

	public void setResult(List<DatangData> result){
		this.result = result;
	}

	public List<DatangData> getResult(){
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
			"DatangResponseModel{" +
			"result = '" + result + '\'' + 
			",kode = '" + kode + '\'' + 
			"}";
		}
}