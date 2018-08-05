package com.codelab.helmi.simades.surat.domisili;

import com.codelab.helmi.simades.base.View;

import java.util.List;

public interface SuratDomisiliView extends View {
    void swipeRefreshTrue();
    void swipeRefreshFalse();
    void initView();
    void initPresenter();
    void setAdapter(List<SuratDomisiliData> suratDomisiliData);
}
