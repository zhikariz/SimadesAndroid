package com.codelab.helmi.simades.kk;

import com.codelab.helmi.simades.base.View;
import java.util.List;

public interface KkView extends View{
    void initPresenter();
    void swipeRefreshTrue();
    void swipeRefreshFalse();
    void setAdapter(List<KkData> kkData);
}
