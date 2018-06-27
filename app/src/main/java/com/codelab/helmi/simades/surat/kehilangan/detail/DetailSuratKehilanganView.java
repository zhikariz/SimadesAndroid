package com.codelab.helmi.simades.surat.kehilangan.detail;

import com.codelab.helmi.simades.base.View;
import com.codelab.helmi.simades.surat.kehilangan.SuratKehilanganData;

public interface DetailSuratKehilanganView extends View{
    void tampilDataDetail();
    void onShowData(SuratKehilanganData suratKehilanganData);
}
