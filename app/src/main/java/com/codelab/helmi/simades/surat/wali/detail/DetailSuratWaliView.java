package com.codelab.helmi.simades.surat.wali.detail;

import com.codelab.helmi.simades.base.View;
import com.codelab.helmi.simades.surat.wali.SuratWaliData;

public interface DetailSuratWaliView extends View {
    void tampilDataDetail();
    void onShowData(SuratWaliData suratWaliData);
}
