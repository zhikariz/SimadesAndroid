package com.codelab.helmi.simades.surat.keramaian;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SuratKeramaianResponseModel {
    @SerializedName("result")
    List<SuratKeramaianData> result;

    public List<SuratKeramaianData> getResult() {
        return result;
    }

    public void setResult(List<SuratKeramaianData> result) {
        this.result = result;
    }
}
