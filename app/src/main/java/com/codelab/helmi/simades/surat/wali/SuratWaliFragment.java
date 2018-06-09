package com.codelab.helmi.simades.surat.wali;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codelab.helmi.simades.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SuratWaliFragment extends Fragment implements SuratWaliView {
    View view;
    private RecyclerView mRecycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mManager;
    SuratWaliPresenter presenter;

    public SuratWaliFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.recycle_content, container, false);
        initPresenter();
        initView();
        onAttachView();
        getActivity().setTitle("Surat Wali");
        return view;
    }

    private void initView() {
        mRecycler = (RecyclerView) view.findViewById(R.id.recyclerTemp);
        mManager = new LinearLayoutManager(getActivity().getApplicationContext());
        mRecycler.setLayoutManager(mManager);
    }

    private void initPresenter() {
        presenter = new SuratWaliPresenter(mAdapter);
    }

    @Override
    public void onShowData(SuratWaliData suratWaliData) {

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
        super.onDestroy();
        onDetachView();
    }
}
