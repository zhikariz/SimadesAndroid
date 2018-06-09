package com.codelab.helmi.simades.kk;


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

public class ShowKkFragment extends Fragment implements KkView, SwipeRefreshLayout.OnRefreshListener {

    KkPresenter presenter;
    View view;
    private RecyclerView mRecycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mManager;
    private final String KEY_RECYCLER_STATE = "recycler_state";
    private static Bundle mBundleRecyclerViewState;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.recycle_content, container, false);
        initPresenter();
        initView();
        onAttachView();
        getActivity().setTitle("Kartu Keluarga");



        return view;

    }

    private void initView() {
        mRecycler = (RecyclerView) view.findViewById(R.id.recyclerTemp);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_layout);
    }

    @Override
    public void initPresenter() {
        presenter = new KkPresenter(mAdapter);
    }

    @Override
    public void swipeRefreshTrue() {
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void swipeRefreshFalse() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onShowData(KkData kkData) {

    }

    @Override
    public void onAttachView() {
        presenter.onAttach(this);
        mManager = new LinearLayoutManager(getActivity().getApplicationContext());
        mRecycler.setLayoutManager(mManager);
        swipeRefreshLayout.setOnRefreshListener(this);


    }

    @Override
    public void onDetachView() {
        presenter.onDetach();
    }

    @Override
    public void onDestroy() {
        onDetachView();
        super.onDestroy();
        mBundleRecyclerViewState = null;
    }

    @Override
    public void onPause() {
        super.onPause();

        mBundleRecyclerViewState = new Bundle();
        Parcelable listState = mRecycler.getLayoutManager().onSaveInstanceState();
        mBundleRecyclerViewState.putParcelable(KEY_RECYCLER_STATE, listState);
        mAdapter = mRecycler.getAdapter();
    }


    @Override
    public void onResume() {
        super.onResume();

//        // restore RecyclerView state
        if (mBundleRecyclerViewState != null) {
            Parcelable listState = mBundleRecyclerViewState.getParcelable(KEY_RECYCLER_STATE);
            mRecycler.getLayoutManager().onRestoreInstanceState(listState);
            mRecycler.setAdapter(mAdapter);
        } else {
            swipeRefreshTrue();
            presenter.showData(getActivity().getApplicationContext(), mRecycler, getFragmentManager());
        }
    }

    @Override
    public void onRefresh() {
        swipeRefreshTrue();
        mRecycler.removeAllViewsInLayout();
        presenter.showData(getActivity().getApplicationContext(), mRecycler, getFragmentManager());
    }
}
