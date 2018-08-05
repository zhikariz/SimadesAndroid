package com.codelab.helmi.simades.surat.keramaian.detail;

import com.codelab.helmi.simades.base.View;
import com.codelab.helmi.simades.surat.keramaian.SuratKeramaianData;

public interface DetailSuratKeramaianView extends View {
    void tampilDataDetail();
    void onShowData(SuratKeramaianData suratKeramaianData);
}
