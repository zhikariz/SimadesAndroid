package com.codelab.helmi.simades.base;

public interface Presenter<T extends View> {
    void onAttach(T view);

    void onDetach();
}
