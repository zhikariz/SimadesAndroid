package com.codelab.helmi.simades.surat.wali;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SuratWaliResponseModel {

    @SerializedName("result")
    List<SuratWaliData> result;

    public List<SuratWaliData> getResult() {
        return result;
    }

    public void setResult(List<SuratWaliData> result) {
        this.result = result;
    }
}
