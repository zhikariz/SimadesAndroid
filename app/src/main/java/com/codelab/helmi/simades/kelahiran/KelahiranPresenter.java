package com.codelab.helmi.simades.kelahiran;

import com.codelab.helmi.simades.base.Presenter;

public class KelahiranPresenter implements Presenter<KelahiranView> {

    private KelahiranView kelahiranView;

    @Override
    public void onAttach(KelahiranView view) {
        kelahiranView = view;
    }

    @Override
    public void onDetach() {
        kelahiranView = null;
    }
}
