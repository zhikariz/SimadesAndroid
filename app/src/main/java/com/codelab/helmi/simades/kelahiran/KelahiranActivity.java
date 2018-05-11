package com.codelab.helmi.simades.kelahiran;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codelab.helmi.simades.R;

public class KelahiranActivity extends Fragment implements KelahiranView{

    KelahiranPresenter presenter;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.activity_kelahiran, container, false);
        initPresenter();
        onAttachView();
        getActivity().setTitle("Kelahiran");

        return view;

    }

    private void initPresenter() {
        presenter = new KelahiranPresenter();
    }


    @Override
    public void onShowData(KelahiranData kelahiranData) {

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
