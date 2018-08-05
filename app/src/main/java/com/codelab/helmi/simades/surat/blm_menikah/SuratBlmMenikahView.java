package com.codelab.helmi.simades.surat.blm_menikah;

import com.codelab.helmi.simades.base.View;

import java.util.List;

public interface SuratBlmMenikahView extends View {
    void swipeRefreshTrue();
    void swipeRefreshFalse();
    void setAdapter(List<SuratBlmMenikahData> suratBlmMenikahData);
    void initView();
    void initPresenter();
}
