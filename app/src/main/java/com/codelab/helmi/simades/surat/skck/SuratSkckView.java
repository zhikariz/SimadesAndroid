package com.codelab.helmi.simades.surat.skck;

import com.codelab.helmi.simades.base.View;

import java.util.List;

public interface SuratSkckView extends View {
    void initView();
    void initPresenter();
    void setAdapter(List<SuratSkckData> suratSkckData);
    void swipeRefreshTrue();
    void swipeRefreshFalse();
}
