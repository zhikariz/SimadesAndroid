package com.codelab.helmi.simades.login;

import com.codelab.helmi.simades.base.Presenter;

public class LoginPresenter implements Presenter<LoginView> {
    LoginView loginView;
    @Override
    public void onAttach(LoginView view) {
        loginView = view;
    }

    @Override
    public void onDetach() {
        loginView = null;
    }
}
