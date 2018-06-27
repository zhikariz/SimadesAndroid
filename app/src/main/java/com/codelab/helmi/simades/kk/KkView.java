package com.codelab.helmi.simades.kk;

import android.support.v7.widget.RecyclerView;

import com.codelab.helmi.simades.base.View;

import java.util.List;

public interface KkView extends View{
    void onShowData(KkData kkData);
    void initPresenter();
    void swipeRefreshTrue();
    void swipeRefreshFalse();
    void setDataList(List<KkData> mItems);
}
