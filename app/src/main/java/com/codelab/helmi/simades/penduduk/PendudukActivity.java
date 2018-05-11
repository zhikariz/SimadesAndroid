package com.codelab.helmi.simades.penduduk;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codelab.helmi.simades.R;

public class PendudukActivity extends Fragment implements  PendudukView{

    PendudukPresenter presenter;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.activity_penduduk, container, false);
        initPresenter();
        onAttachView();
        getActivity().setTitle("Penduduk");

        return view;

    }

    private void initPresenter() {
        presenter = new PendudukPresenter();
    }

    @Override
    public void onShowData(PendudukData pendudukData) {

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
