package com.codelab.helmi.simades.surat.kelahiran.detail;

import com.codelab.helmi.simades.base.Presenter;

public class DetailSuratKelahiranPresenter implements Presenter<DetailSuratKelahiranView> {

    DetailSuratKelahiranView detailSuratKelahiranView;

    @Override
    public void onAttach(DetailSuratKelahiranView view) {
        detailSuratKelahiranView = view;
    }

    @Override
    public void onDetach() {
        detailSuratKelahiranView = null;
    }
}
