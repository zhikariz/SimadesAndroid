package com.codelab.helmi.simades.navigasi;

import com.codelab.helmi.simades.base.Presenter;
import com.codelab.helmi.simades.profil.ProfilView;

public class NavigatePresenter implements Presenter<NavigateView> {

    private NavigateView nView;
    @Override
    public void onAttach(NavigateView view) {
        nView = view;
    }

    @Override
    public void onDetach() {
        nView = null;
    }


}
