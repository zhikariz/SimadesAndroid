package com.codelab.helmi.simades.surat.ektp;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SuratEktpResponseModel {
    @SerializedName("result")
    List<SuratEktpData> result;

    public List<SuratEktpData> getResult() {
        return result;
    }

    public void setResult(List<SuratEktpData> result) {
        this.result = result;
    }
}
