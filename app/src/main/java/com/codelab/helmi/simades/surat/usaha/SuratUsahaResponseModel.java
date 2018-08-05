package com.codelab.helmi.simades.surat.usaha;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SuratUsahaResponseModel {

    @SerializedName("result")
    List<SuratUsahaData> result;

    public List<SuratUsahaData> getResult() {
        return result;
    }

    public void setResult(List<SuratUsahaData> result) {
        this.result = result;
    }
}
