package com.codelab.helmi.simades.surat.kematian;

import com.codelab.helmi.simades.base.View;

import java.util.List;

public interface SuratKematianView extends View {
    void initView();
    void initPresenter();
    void setAdapter(List<SuratKematianData> suratKematianData);
    void swipeRefreshTrue();
    void swipeRefreshFalse();
}
