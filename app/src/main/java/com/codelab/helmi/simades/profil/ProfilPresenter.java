package com.codelab.helmi.simades.profil;

import com.codelab.helmi.simades.base.Presenter;

public class ProfilPresenter implements Presenter<ProfilView> {

    private ProfilView pView;

    @Override
    public void onAttach(ProfilView view) {
        pView = view;
    }

    @Override
    public void onDetach() {
        pView = null;
    }

    public void showData() {
        // Set ProfilData
        final ProfilData profilData = new ProfilData();
        profilData.setText("Hello from Profil Data!");

        // Show Fragment with ProfilData
        pView.onShowData(profilData);
    }
}
