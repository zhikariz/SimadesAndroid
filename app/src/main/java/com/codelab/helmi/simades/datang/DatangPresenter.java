package com.codelab.helmi.simades.datang;

import com.codelab.helmi.simades.base.Presenter;

public class DatangPresenter implements Presenter<DatangView> {

    DatangView datangView;

    @Override
    public void onAttach(DatangView view) {
        datangView = view;
    }

    @Override
    public void onDetach() {
        datangView = null;
    }
}
