package com.codelab.helmi.simades.surat.kelahiran;

import com.codelab.helmi.simades.base.View;

import java.util.List;

public interface SuratKelahiranView extends View {
    void initView();
    void initPresenter();
    void setAdapter(List<SuratKelahiranData> suratKelahiranData);
    void swipeRefreshTrue();
    void swipeRefreshFalse();
}
