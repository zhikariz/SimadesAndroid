package com.codelab.helmi.simades.surat.tidak_mampu.detail;

import com.codelab.helmi.simades.base.View;
import com.codelab.helmi.simades.surat.tidak_mampu.SuratTidakMampuData;

public interface DetailSuratTidakMampuView extends View{
    void tampilDataDetail();
    void onShowData(SuratTidakMampuData suratTidakMampuData);
}
