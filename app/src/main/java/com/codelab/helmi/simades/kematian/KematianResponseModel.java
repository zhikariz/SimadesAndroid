package com.codelab.helmi.simades.kematian;


import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class KematianResponseModel {
    @SerializedName("result")
    List<KematianData> result;

    public List<KematianData> getResult() {
        return result;
    }

    public void setResult(List<KematianData> result) {
        this.result = result;
    }
}
