package com.codelab.helmi.simades.datang;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DatangResponseModel {
    @SerializedName("result")
    List<DatangData> result;

    public List<DatangData> getResult() {
        return result;
    }

    public void setResult(List<DatangData> result) {
        this.result = result;
    }
}
