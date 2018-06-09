package com.codelab.helmi.simades.pergi;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codelab.helmi.simades.R;

public class PergiActivity extends Fragment implements PergiView {

    PergiPresenter presenter;
    View view;
    private RecyclerView mRecycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mManager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.recycle_content, container, false);
        initPresenter();
        initView();
        onAttachView();
        getActivity().setTitle("Pergi");

        return view;

    }

    private void initView() {
        mRecycler = (RecyclerView) view.findViewById(R.id.recyclerTemp);
        mManager = new LinearLayoutManager(getActivity().getApplicationContext());
        mRecycler.setLayoutManager(mManager);
    }

    private void initPresenter() {
        presenter = new PergiPresenter(mAdapter);
    }

    @Override
    public void onShowData(PergiData pergiData) {

    }

    @Override
    public void onAttachView() {
        presenter.onAttach(this);
        presenter.showData(getActivity().getApplicationContext(), mRecycler);
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
