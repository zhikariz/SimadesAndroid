package com.codelab.helmi.simades.datang;

import com.codelab.helmi.simades.base.View;

import java.util.List;

public interface DatangView extends View {
    void swipeRefreshTrue();
    void swipeRefreshFalse();
    void setAdapter(List<DatangData> datangData);
}
