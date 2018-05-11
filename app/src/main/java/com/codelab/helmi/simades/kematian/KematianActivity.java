package com.codelab.helmi.simades.kematian;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codelab.helmi.simades.R;

public class KematianActivity extends Fragment implements KematianView {

    KematianPresenter presenter;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.activity_kematian, container, false);
        initPresenter();
        onAttachView();
        getActivity().setTitle("Kematian");

        return view;

    }

    private void initPresenter() {
        presenter = new KematianPresenter();
    }

    @Override
    public void onShowData(KematianData kematianData) {

    }

    @Override
    public void onAttachView() {
        presenter.onAttach(this);
    }

    @Override
    public void onDetachView() {
        presenter.onDetach();
    }

    @Override
    public void onDestroy() {
        onDetachView();
        super.onDestroy();
    }
}
