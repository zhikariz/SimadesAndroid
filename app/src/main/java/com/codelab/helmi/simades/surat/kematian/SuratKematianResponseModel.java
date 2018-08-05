package com.codelab.helmi.simades.surat.kematian;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SuratKematianResponseModel {
    @SerializedName("result")
    List<SuratKematianData> result;

    public List<SuratKematianData> getResult() {
        return result;
    }

    public void setResult(List<SuratKematianData> result) {
        this.result = result;
    }
}
