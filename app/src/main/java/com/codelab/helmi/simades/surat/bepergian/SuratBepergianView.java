package com.codelab.helmi.simades.surat.bepergian;

import com.codelab.helmi.simades.base.View;

import java.util.List;

public interface SuratBepergianView extends View {
    void swipeRefreshTrue();
    void swipeRefreshFalse();
    void setAdapter(List<SuratBepergianData> suratBepergianData);
    void initView();
    void initPresenter();
}
