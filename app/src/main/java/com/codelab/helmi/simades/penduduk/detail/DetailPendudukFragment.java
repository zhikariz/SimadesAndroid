package com.codelab.helmi.simades.penduduk.detail;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codelab.helmi.simades.R;
import com.codelab.helmi.simades.penduduk.PendudukData;

public class DetailPendudukFragment extends Fragment implements DetailPendudukView {

    public static String EXTRA_PENDUDUK = "extra_penduduk";
    DetailPendudukPresenter presenter;
    View view;
    TextView tvTest;
    Bundle bundle;
    PendudukData pendudukData;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_detail_penduduk, container, false);

        initPresenter();
        initView();
        onAttachView();
        tampilDataDetail();
        getActivity().setTitle("Detail Penduduk");

        return view;
    }

    private void initView() {
        tvTest = (TextView) view.findViewById(R.id.tests);
    }

    private void initPresenter() {
        presenter = new DetailPendudukPresenter();
    }

    @Override
    public void tampilDataDetail() {
        bundle = this.getArguments();
        PendudukData pendudukData = bundle.getParcelable(EXTRA_PENDUDUK);
        tvTest.setText(pendudukData.getNama_depan());

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
    }
}
