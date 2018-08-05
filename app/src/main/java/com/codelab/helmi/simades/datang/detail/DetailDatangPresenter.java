package com.codelab.helmi.simades.datang.detail;

import com.codelab.helmi.simades.base.Presenter;

public class DetailDatangPresenter implements Presenter<DetailDatangView> {

    DetailDatangView detailDatangView;

    @Override
    public void onAttach(DetailDatangView view) {
        detailDatangView = view;
    }

    @Override
    public void onDetach() {
        detailDatangView = null;
    }
}
