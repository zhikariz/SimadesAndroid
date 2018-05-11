package com.codelab.helmi.simades.user;

import com.codelab.helmi.simades.base.Presenter;

public class UserPresenter implements Presenter<UserView> {

    UserView userView;

    @Override
    public void onAttach(UserView view) {
        userView = view;
    }

    @Override
    public void onDetach() {
        userView = null;
    }
}
