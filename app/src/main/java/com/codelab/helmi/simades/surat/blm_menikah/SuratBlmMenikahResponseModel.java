package com.codelab.helmi.simades.surat.blm_menikah;

import com.codelab.helmi.simades.surat.usaha.SuratUsahaData;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SuratBlmMenikahResponseModel {

    @SerializedName("result")
    List<SuratBlmMenikahData> result;

    public List<SuratBlmMenikahData> getResult() {
        return result;
    }

    public void setResult(List<SuratBlmMenikahData> result) {
        this.result = result;
    }
}
