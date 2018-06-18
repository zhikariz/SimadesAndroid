package com.codelab.helmi.simades.surat.skck;

import com.codelab.helmi.simades.base.View;

public interface SuratSkckView extends View {
    void onShowData(SuratSkckData suratSkckData);
    void swipeRefreshTrue();
    void swipeRefreshFalse();
}
