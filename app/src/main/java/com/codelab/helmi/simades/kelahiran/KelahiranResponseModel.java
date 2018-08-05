package com.codelab.helmi.simades.kelahiran;


import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class KelahiranResponseModel {
    @SerializedName("result")
    List<KelahiranData> result;

    public List<KelahiranData> getResult() {
        return result;
    }

    public void setResult(List<KelahiranData> result) {
        this.result = result;
    }
}
