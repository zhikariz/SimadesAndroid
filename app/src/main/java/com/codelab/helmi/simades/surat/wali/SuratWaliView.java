package com.codelab.helmi.simades.surat.wali;

import com.codelab.helmi.simades.base.View;

import java.util.List;

public interface SuratWaliView extends View {
    void initView();
    void initPresenter();
    void setAdapter(List<SuratWaliData> suratWaliData);
    void swipeRefreshTrue();
    void swipeRefreshFalse();
}
