package com.codelab.helmi.simades.kk;


import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class KkResponseModel {
    @SerializedName("result")
    List<KkData> result;

    public List<KkData> getResult() {
        return result;
    }

    public void setResult(List<KkData> result) {
        this.result = result;
    }
}
