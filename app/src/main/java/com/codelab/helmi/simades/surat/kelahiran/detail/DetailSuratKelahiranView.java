package com.codelab.helmi.simades.surat.kelahiran.detail;

import com.codelab.helmi.simades.base.View;
import com.codelab.helmi.simades.surat.kelahiran.SuratKelahiranData;

public interface DetailSuratKelahiranView extends View{
    void tampilDataDetail();
    void onShowData(SuratKelahiranData suratKelahiranData);
}
