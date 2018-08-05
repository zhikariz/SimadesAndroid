package com.codelab.helmi.simades.surat.tidak_mampu;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SuratTidakMampuResponseModel {
    @SerializedName("result")
    List<SuratTidakMampuData> result;

    public List<SuratTidakMampuData> getResult() {
        return result;
    }

    public void setResult(List<SuratTidakMampuData> result) {
        this.result = result;
    }
}
