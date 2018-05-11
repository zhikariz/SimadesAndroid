package com.codelab.helmi.simades.user;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codelab.helmi.simades.R;

public class UserActivity extends Fragment implements UserView {

    UserPresenter presenter;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.activity_user, container, false);
        initPresenter();
        onAttachView();
        getActivity().setTitle("User");

        return view;

    }

    private void initPresenter() {
        presenter = new UserPresenter();
    }

    @Override
    public void onShowData(UserData userData) {

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
