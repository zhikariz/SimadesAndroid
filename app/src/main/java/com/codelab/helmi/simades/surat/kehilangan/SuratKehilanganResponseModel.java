package com.codelab.helmi.simades.surat.kehilangan;

import com.codelab.helmi.simades.surat.kelahiran.SuratKelahiranData;
import com.google.gson.annotations.SerializedName;

import java.util.List;
@SuppressWarnings("unused")
public class SuratKehilanganResponseModel {
    @SerializedName("result")
    List<SuratKehilanganData> result;

    public List<SuratKehilanganData> getResult() {
        return result;
    }

    public void setResult(List<SuratKehilanganData> result) {
        this.result = result;
    }
}
