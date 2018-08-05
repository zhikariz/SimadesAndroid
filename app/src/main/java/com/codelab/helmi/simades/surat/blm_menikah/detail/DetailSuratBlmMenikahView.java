package com.codelab.helmi.simades.surat.blm_menikah.detail;

import com.codelab.helmi.simades.base.View;
import com.codelab.helmi.simades.surat.blm_menikah.SuratBlmMenikahData;

public interface DetailSuratBlmMenikahView extends View{
    void tampilDataDetail();
    void onShowData(SuratBlmMenikahData suratBlmMenikahData);
}
