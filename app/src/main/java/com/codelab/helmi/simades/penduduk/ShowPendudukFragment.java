package com.codelab.helmi.simades.penduduk;


import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codelab.helmi.simades.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ShowPendudukFragment extends Fragment implements PendudukView, SwipeRefreshLayout.OnRefreshListener, SearchView.OnQueryTextListener, View.OnClickListener {
    public static String EXTRA_NO_KK = "extra_no_kk";
    private static Bundle mBundleRecyclerViewState;
    private final String KEY_RECYCLER_STATE = "recycler_state";
    ShowPendudukPresenter presenter;
    View view;
    SearchView searchView;
    ShowPendudukRecyclerAdapter mAdapter;
    private RecyclerView mRecycler;
    private RecyclerView.LayoutManager mManager;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.recycle_content, container, false);
        initPresenter();
        initView();
        onAttachView();
        getActivity().setTitle("Anggota Keluarga");
        return view;

    }

    @Override
    public void initView() {
        mRecycler = view.findViewById(R.id.recyclerTemp);
        mManager = new LinearLayoutManager(getActivity().getApplicationContext());
        mRecycler.setLayoutManager(mManager);
        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh_layout);
        searchView = view.findViewById(R.id.search_view);
    }

    @Override
    public void initPresenter() {
        presenter = new ShowPendudukPresenter(getActivity());
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
    public void setAdapter(List<PendudukData> pendudukData) {
        mAdapter = new ShowPendudukRecyclerAdapter(getActivity(), pendudukData, getFragmentManager());
        mRecycler.setAdapter(mAdapter);
    }

    @Override
    public void onAttachView() {
        presenter.onAttach(this);
        swipeRefreshLayout.setOnRefreshListener(this);
        searchView.setOnQueryTextListener(this);
        searchView.setOnClickListener(this);
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
    }

    @Override
    public void onResume() {
        super.onResume();

        if (mBundleRecyclerViewState != null) {
            Parcelable listState = mBundleRecyclerViewState.getParcelable(KEY_RECYCLER_STATE);
            mRecycler.getLayoutManager().onRestoreInstanceState(listState);
            mRecycler.setAdapter(mAdapter);
        } else {
            swipeRefreshTrue();
            presenter.showData(getArguments().getString(EXTRA_NO_KK));
        }
    }

    @Override
    public void onRefresh() {
        swipeRefreshTrue();
        mRecycler.removeAllViewsInLayout();
        presenter.showData(getArguments().getString(EXTRA_NO_KK));
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        mAdapter.getFilter().filter(newText);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.search_view:
                searchView.setIconified(false);
                break;
        }
    }
}
