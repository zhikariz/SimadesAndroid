package com.codelab.helmi.simades.surat.domisili.detail;

import com.codelab.helmi.simades.base.View;
import com.codelab.helmi.simades.surat.domisili.SuratDomisiliData;

public interface DetailSuratDomisiliView extends View{
    void onShowData(SuratDomisiliData suratDomisiliData);
    void tampilDataDetail();
}
