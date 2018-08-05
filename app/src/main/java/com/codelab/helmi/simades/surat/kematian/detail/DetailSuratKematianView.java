package com.codelab.helmi.simades.surat.kematian.detail;

import com.codelab.helmi.simades.base.View;
import com.codelab.helmi.simades.surat.kematian.SuratKematianData;

public interface DetailSuratKematianView extends View{
    void tampilDataDetail();
    void onShowData(SuratKematianData suratKematianData);
}
