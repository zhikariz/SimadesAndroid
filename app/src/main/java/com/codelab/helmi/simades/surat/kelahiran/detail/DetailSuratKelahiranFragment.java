package com.codelab.helmi.simades.surat.kelahiran.detail;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codelab.helmi.simades.R;
import com.codelab.helmi.simades.penduduk.PendudukData;
import com.codelab.helmi.simades.surat.kelahiran.SuratKelahiranData;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailSuratKelahiranFragment extends Fragment implements DetailSuratKelahiranView {

    View view;
    DetailSuratKelahiranPresenter presenter;
    Bundle bundle;
    TextView tvKodeSuratKelahiran;

    public static String EXTRA_SURAT_KELAHIRAN = "extra_surat_kelahiran";

    public DetailSuratKelahiranFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_detail_surat_kelahiran, container, false);
        initPresenter();
        initView();
        onAttachView();
        tampilDataDetail();


        return view;
    }

    private void initView() {
        tvKodeSuratKelahiran = (TextView) view.findViewById(R.id.tv_detail_kode_surat_kelahiran);

    }

    private void initPresenter() {
        presenter = new DetailSuratKelahiranPresenter();
    }

    @Override
    public void tampilDataDetail() {
        bundle = this.getArguments();
        SuratKelahiranData suratKelahiranData= bundle.getParcelable(EXTRA_SURAT_KELAHIRAN);
        tvKodeSuratKelahiran.setText(suratKelahiranData.getKd_surat());
    }

    @Override
    public void onShowData(SuratKelahiranData suratKelahiranData) {

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
