package com.codelab.helmi.simades.pergi;

import com.codelab.helmi.simades.base.Presenter;

public class PergiPresenter implements Presenter<PergiView> {

    PergiView pergiView;

    @Override
    public void onAttach(PergiView view) {
        pergiView = view;
    }

    @Override
    public void onDetach() {
        pergiView = null;
    }
}
