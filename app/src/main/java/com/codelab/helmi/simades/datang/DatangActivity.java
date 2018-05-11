package com.codelab.helmi.simades.datang;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codelab.helmi.simades.R;

public class DatangActivity extends Fragment implements DatangView {

    DatangPresenter presenter;
    View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.activity_datang, container, false);
        initPresenter();
        onAttachView();
        getActivity().setTitle("Datang");

        return view;

    }

    private void initPresenter() {
        presenter = new DatangPresenter();
    }


    @Override
    public void onShowData(DatangData datangData) {

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
