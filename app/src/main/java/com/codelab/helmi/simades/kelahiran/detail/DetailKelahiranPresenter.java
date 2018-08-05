package com.codelab.helmi.simades.kelahiran.detail;

import com.codelab.helmi.simades.base.Presenter;

public class DetailKelahiranPresenter implements Presenter<DetailKelahiranView> {
    DetailKelahiranView detailKelahiranView;

    @Override
    public void onAttach(DetailKelahiranView view) {
        detailKelahiranView = view;
    }

    @Override
    public void onDetach() {
        detailKelahiranView = null;

    }
}
