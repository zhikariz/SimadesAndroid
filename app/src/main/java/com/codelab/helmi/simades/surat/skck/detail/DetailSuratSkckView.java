package com.codelab.helmi.simades.surat.skck.detail;

import com.codelab.helmi.simades.base.View;
import com.codelab.helmi.simades.surat.skck.SuratSkckData;

public interface DetailSuratSkckView extends View {
    void tampilDataDetail();
    void onShowData(SuratSkckData suratSkckData);
}
