package com.codelab.helmi.simades.surat.domisili;

import com.codelab.helmi.simades.base.View;

public interface SuratDomisiliView extends View {
    void onShowData(SuratDomisiliData suratDomisiliData);
    void swipeRefreshTrue();
    void swipeRefreshFalse();
}
