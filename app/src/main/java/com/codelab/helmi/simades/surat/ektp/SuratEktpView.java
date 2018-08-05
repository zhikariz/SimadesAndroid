package com.codelab.helmi.simades.surat.ektp;

import com.codelab.helmi.simades.base.View;

import java.util.List;

public interface SuratEktpView extends View {
    void initView();
    void swipeRefreshTrue();
    void swipeRefreshFalse();
    void initPresenter();
    void setAdapter(List<SuratEktpData> suratEktpData);
}
