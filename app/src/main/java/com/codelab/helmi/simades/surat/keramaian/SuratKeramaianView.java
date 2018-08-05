package com.codelab.helmi.simades.surat.keramaian;

import com.codelab.helmi.simades.base.View;

import java.util.List;

public interface SuratKeramaianView extends View {
    void initView();
    void initPresenter();
    void setAdapter(List<SuratKeramaianData> suratKeramaianData);
    void swipeRefreshTrue();
    void swipeRefreshFalse();
}
