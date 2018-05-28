package com.codelab.helmi.simades.surat.domisili;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SuratDomisiliResponseModel {
    @SerializedName("result")
    List<SuratDomisiliData> result;

    public List<SuratDomisiliData> getResult() {
        return result;
    }

    public void setResult(List<SuratDomisiliData> result) {
        this.result = result;
    }
}
