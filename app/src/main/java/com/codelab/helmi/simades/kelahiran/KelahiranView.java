package com.codelab.helmi.simades.kelahiran;

import com.codelab.helmi.simades.base.View;

import java.util.List;

public interface KelahiranView extends View {

    void swipeRefreshTrue();
    void swipeRefreshFalse();
    void setAdapter(List<KelahiranData> kelahiranData);
}
