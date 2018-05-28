package com.codelab.helmi.simades.penduduk;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codelab.helmi.simades.R;

public class ShowPendudukFragment extends Fragment implements PendudukView {
    PendudukPresenter presenter;
    View view;
    private RecyclerView mRecycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mManager;
    public static String EXTRA_NIK = "extra_nik";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.recycle_content, container, false);
        initPresenter();
        initView();
        onAttachView();
        getActivity().setTitle("Penduduk");

        return view;

    }

    private void initView() {
        mRecycler = (RecyclerView) view.findViewById(R.id.recyclerTemp);
        mManager = new LinearLayoutManager(getActivity().getApplicationContext());
        mRecycler.setLayoutManager(mManager);
    }

    private void initPresenter() {
        presenter = new PendudukPresenter(mAdapter);
    }

    @Override
    public void onShowData(PendudukData pendudukData) {

    }

    @Override
    public void onAttachView() {
        presenter.onAttach(this);
        presenter.showData(getActivity().getApplicationContext(), mRecycler, getArguments().getString(EXTRA_NIK));

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