package com.codelab.helmi.simades.surat.kehilangan;



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

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SuratKehilanganFragment extends Fragment implements SuratKehilanganView, SwipeRefreshLayout.OnRefreshListener, SearchView.OnQueryTextListener, View.OnClickListener {

    private RecyclerView mRecycler;
    SuratKehilanganRecyclerAdapter mAdapter;
    private RecyclerView.LayoutManager mManager;
    View view;
    SuratKehilanganPresenter presenter;
    public static final String KEY_RECYCLER_STATE = "recycler_state";
    public static Bundle mBundleRecyclerViewState = null;
    private SwipeRefreshLayout swipeRefreshLayout;
    private SearchView searchView;


    public SuratKehilanganFragment() {
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
        getActivity().setTitle("Surat Kehilangan");
        return view;
    }

    @Override
    public void initView() {
        mRecycler = view.findViewById(R.id.recyclerTemp);
        mManager = new LinearLayoutManager(getActivity().getApplicationContext());
        mRecycler.setLayoutManager(mManager);
        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(this);
        searchView = view.findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(this);
        searchView.setOnClickListener(this);
    }

    @Override
    public void initPresenter() {
        presenter = new SuratKehilanganPresenter(getActivity());
    }


    @Override
    public void setAdapter(List<SuratKehilanganData> suratKehilanganData) {
        mAdapter = new SuratKehilanganRecyclerAdapter(getActivity(), suratKehilanganData, getFragmentManager());
        mRecycler.setAdapter(mAdapter);
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
    public void onAttachView() {
        presenter.onAttach(this);
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
            mRecycler.removeAllViewsInLayout();
            presenter.showData();
        }
    }

    @Override
    public void onRefresh() {
        swipeRefreshTrue();
        mRecycler.removeAllViewsInLayout();
        presenter.showData();

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
        switch (v.getId())
        {
            case R.id.search_view:
                searchView.setIconified(false);
                break;
        }
    }
}
