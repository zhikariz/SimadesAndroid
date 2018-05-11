package com.codelab.helmi.simades.pergi;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codelab.helmi.simades.R;

public class PergiActivity extends Fragment implements PergiView {

    PergiPresenter presenter;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.activity_pergi, container, false);
        initPresenter();
        onAttachView();
        getActivity().setTitle("Pergi");

        return view;

    }

    private void initPresenter() {
        presenter = new PergiPresenter();
    }

    @Override
    public void onShowData(PergiData pergiData) {

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
