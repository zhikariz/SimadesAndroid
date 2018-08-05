package com.codelab.helmi.simades.pergi.detail;

import com.codelab.helmi.simades.base.Presenter;

public class DetailPergiPresenter implements Presenter<DetailPergiView> {
    DetailPergiView detailPergiView;

    @Override
    public void onAttach(DetailPergiView view) {
        detailPergiView = view;

    }

    @Override
    public void onDetach() {
        detailPergiView = null;

    }
}
