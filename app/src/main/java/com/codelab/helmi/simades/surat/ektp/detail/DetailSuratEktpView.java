package com.codelab.helmi.simades.surat.ektp.detail;

import com.codelab.helmi.simades.base.View;
import com.codelab.helmi.simades.surat.ektp.SuratEktpData;

public interface DetailSuratEktpView extends View{
    void tampilDataDetail();
    void onShowData(SuratEktpData suratEktpData);
}
