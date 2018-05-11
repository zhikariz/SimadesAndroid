package com.codelab.helmi.simades.penduduk;

import com.codelab.helmi.simades.base.Presenter;

public class PendudukPresenter implements Presenter<PendudukView> {

    private PendudukView pendudukView;

    @Override
    public void onAttach(PendudukView view) {
        pendudukView = view;
    }

    @Override
    public void onDetach() {
        pendudukView = null;
    }
}
