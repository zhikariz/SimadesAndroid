package com.codelab.helmi.simades.kk;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codelab.helmi.simades.R;
import com.codelab.helmi.simades.kk.KkData;
import com.codelab.helmi.simades.kk.KkPresenter;
import com.codelab.helmi.simades.kk.KkView;

public class ShowKkFragment extends Fragment implements KkView {

    KkPresenter presenter;
    View view;
    private RecyclerView mRecycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.recycle_content, container, false);
        initPresenter();
        onAttachView();
        getActivity().setTitle("Penduduk");

        return view;

    }

    @Override
    public void initPresenter() {
        presenter = new KkPresenter(mAdapter);
    }

    @Override
    public void onShowData(KkData kkData) {

    }

    @Override
    public void onAttachView() {
        presenter.onAttach(this);

        mRecycler = (RecyclerView) view.findViewById(R.id.recyclerTemp);
        mManager = new LinearLayoutManager(getActivity().getApplicationContext());
        mRecycler.setLayoutManager(mManager);

        presenter.showData(getActivity().getApplicationContext(), mRecycler, getFragmentManager());



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
