package com.codelab.helmi.simades.kematian.detail;

import com.codelab.helmi.simades.base.Presenter;

public class DetailKematianPresenter implements Presenter<DetailKematianView> {

    private DetailKematianView detailKematianView;

    @Override
    public void onAttach(DetailKematianView view) {
        detailKematianView = view;
    }

    @Override
    public void onDetach() {
        detailKematianView = null;
    }
}
