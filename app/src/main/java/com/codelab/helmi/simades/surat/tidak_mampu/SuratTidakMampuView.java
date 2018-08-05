package com.codelab.helmi.simades.surat.tidak_mampu;

import com.codelab.helmi.simades.base.View;

import java.util.List;

public interface SuratTidakMampuView extends View {
    void initView();
    void initPresenter();
    void setAdapter(List<SuratTidakMampuData> suratTidakMampuData);
    void swipeRefreshTrue();
    void swipeRefreshFalse();
}
