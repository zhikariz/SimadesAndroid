package com.codelab.helmi.simades.surat.bepergian;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SuratBepergianResponseModel {
    @SerializedName("result")
    List<SuratBepergianData> result;
    @SerializedName("status")
    String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<SuratBepergianData> getResult() {
        return result;
    }

    public void setResult(List<SuratBepergianData> result) {
        this.result = result;
    }
}
