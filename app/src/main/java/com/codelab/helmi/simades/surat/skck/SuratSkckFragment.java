package com.codelab.helmi.simades.surat.skck;


import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codelab.helmi.simades.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SuratSkckFragment extends Fragment implements SuratSkckView, SwipeRefreshLayout.OnRefreshListener {

    private RecyclerView mRecycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mManager;
    View view;
    SuratSkckPresenter presenter;
    public static final String KEY_RECYCLER_STATE = "recycler_state";
    public static Bundle mBundleRecyclerViewState = null;
    private SwipeRefreshLayout swipeRefreshLayout;

    public SuratSkckFragment() {
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
        getActivity().setTitle("Surat Pengantar Skck");
        return view;
    }

    private void initView() {
        mRecycler = (RecyclerView) view.findViewById(R.id.recyclerTemp);
        mManager = new LinearLayoutManager(getActivity().getApplicationContext());
        mRecycler.setLayoutManager(mManager);
        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(this);
    }

    private void initPresenter() {
        presenter = new SuratSkckPresenter(mAdapter);
    }

    @Override
    public void onShowData(SuratSkckData suratSkckData) {

    }

    @Override
    public void onAttachView() {

        presenter.onAttach(this);
        presenter.showData(getActivity().getApplicationContext(), mRecycler,getFragmentManager());
    }

    @Override
    public void onDetachView() {
        presenter.onDetach();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        onDetachView();
        mBundleRecyclerViewState = null;
    }

    public void onResume() {
        super.onResume();

        if (mBundleRecyclerViewState != null) {
            Parcelable listState = mBundleRecyclerViewState.getParcelable(KEY_RECYCLER_STATE);
            mRecycler.getLayoutManager().onRestoreInstanceState(listState);
            mRecycler.setAdapter(mAdapter);
        } else {
            swipeRefreshTrue();
            mRecycler.removeAllViewsInLayout();
            presenter.showData(getActivity().getApplicationContext(), mRecycler, getFragmentManager());
        }
    }

    public void swipeRefreshTrue() {
        swipeRefreshLayout.setRefreshing(true);
    }

    public void swipeRefreshFalse() {
        swipeRefreshLayout.setRefreshing(false);
    }

    public void onRefresh() {
        swipeRefreshTrue();
        mRecycler.removeAllViewsInLayout();
        presenter.showData(getActivity().getApplicationContext(), mRecycler, getFragmentManager());
    }
}
