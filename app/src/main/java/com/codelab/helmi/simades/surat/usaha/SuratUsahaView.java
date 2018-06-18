package com.codelab.helmi.simades.surat.usaha;

import com.codelab.helmi.simades.base.View;

public interface SuratUsahaView extends View {
    void onShowData(SuratUsahaData suratUsahaData);
    void swipeRefreshTrue();
    void swipeRefreshFalse();
}
