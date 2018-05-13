package com.codelab.helmi.simades.penduduk;


import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class PendudukResponseModel {
    @SerializedName("result")
    List<PendudukData> result;

    public List<PendudukData> getResult() {
        return result;
    }

    public void setResult(List<PendudukData> result) {
        this.result = result;
    }
}
