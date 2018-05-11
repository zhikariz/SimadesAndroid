package com.codelab.helmi.simades.kematian;

import com.codelab.helmi.simades.base.Presenter;

public class KematianPresenter implements Presenter<KematianView>{

    KematianView kematianView;

    @Override
    public void onAttach(KematianView view) {
        kematianView = view;
    }

    @Override
    public void onDetach() {
        kematianView = null;
    }
}
