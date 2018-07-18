package com.codelab.helmi.simades.penduduk;

import com.codelab.helmi.simades.base.View;

import java.util.ArrayList;
import java.util.List;

public interface PendudukView extends View {
    void initView();
    void initPresenter();
    void swipeRefreshTrue();
    void swipeRefreshFalse();
    void setAdapter(List<PendudukData> pendudukData);
}
