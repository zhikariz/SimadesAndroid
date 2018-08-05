package com.codelab.helmi.simades.surat.kelahiran;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class SuratKelahiranResponseModel {
    @SerializedName("result")
    List<SuratKelahiranData> result;

    public List<SuratKelahiranData> getResult() {
        return result;
    }

    public void setResult(List<SuratKelahiranData> result) {
        this.result = result;
    }
}
