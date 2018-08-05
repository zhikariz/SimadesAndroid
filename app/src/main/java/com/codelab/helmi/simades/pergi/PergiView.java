package com.codelab.helmi.simades.pergi;

import com.codelab.helmi.simades.base.View;

import java.util.List;

public interface PergiView extends View {
    void swipeRefreshTrue();
    void swipeRefreshFalse();
    void initView();
    void initPresenter();
    void setAdapter(List<PergiData> pergiData);
}
