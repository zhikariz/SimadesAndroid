package com.codelab.helmi.simades.profil;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class ProfilResponseModel {

    @SerializedName("result")
    List<ProfilData> result;
    @SerializedName("kode")
    private int kode;


    public List<ProfilData> getResult() {
        return result;
    }

    public void setResult(List<ProfilData> result) {
        this.result = result;
    }


    public int getKode() {
        return kode;
    }

    public void setSuccess(int kode) {
        this.kode = kode;
    }


}
