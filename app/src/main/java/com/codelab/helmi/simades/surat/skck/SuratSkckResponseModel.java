package com.codelab.helmi.simades.surat.skck;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SuratSkckResponseModel {
    @SerializedName("result")
    List<SuratSkckData> result;

    public List<SuratSkckData> getResult() {
        return result;
    }

    public void setResult(List<SuratSkckData> result) {
        this.result = result;
    }
}
