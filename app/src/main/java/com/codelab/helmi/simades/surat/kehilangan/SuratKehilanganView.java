package com.codelab.helmi.simades.surat.kehilangan;

import com.codelab.helmi.simades.base.View;

import java.util.List;

public interface SuratKehilanganView extends View {
    void setAdapter(List<SuratKehilanganData> suratKehilanganData);
    void swipeRefreshTrue();
    void swipeRefreshFalse();
    void initPresenter();
    void initView();
}
