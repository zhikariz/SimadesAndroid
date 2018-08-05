package com.codelab.helmi.simades.kematian;

import com.codelab.helmi.simades.base.View;

import java.util.List;

public interface KematianView extends View {
    void setAdapter(List<KematianData> kematianData);
    void swipeRefreshTrue();
    void swipeRefreshFalse();
    void initView();
    void initPresenter();
}
