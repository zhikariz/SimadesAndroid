package com.codelab.helmi.simades.surat.usaha;

import com.codelab.helmi.simades.base.View;

import java.util.List;

public interface SuratUsahaView extends View {
    void initView();
    void initPresenter();
    void setAdapter(List<SuratUsahaData> suratUsahaData);
    void swipeRefreshTrue();
    void swipeRefreshFalse();
}
