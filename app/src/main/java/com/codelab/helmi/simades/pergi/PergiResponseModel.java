package com.codelab.helmi.simades.pergi;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class PergiResponseModel {

    @SerializedName("result")
    List<PergiData> result;

    public List<PergiData> getResult(){
        return result;
    }

    public void setResult(List<PergiData> result){
        this.result = result;
    }
}
