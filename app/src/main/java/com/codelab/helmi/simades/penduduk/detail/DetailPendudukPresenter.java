package com.codelab.helmi.simades.penduduk.detail;

import com.codelab.helmi.simades.base.Presenter;

public class DetailPendudukPresenter implements Presenter<DetailPendudukView> {
    DetailPendudukView detailPendudukView;

    @Override
    public void onAttach(DetailPendudukView view) {
        detailPendudukView = view;
    }

    @Override
    public void onDetach() {
        detailPendudukView = null;
    }

}
