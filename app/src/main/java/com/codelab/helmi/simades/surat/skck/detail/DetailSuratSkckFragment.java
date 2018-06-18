package com.codelab.helmi.simades.surat.skck.detail;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codelab.helmi.simades.R;
import com.codelab.helmi.simades.surat.skck.SuratSkckData;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailSuratSkckFragment extends Fragment implements DetailSuratSkckView {

    public static String EXTRA_SURAT_SKCK;
    View view;
    DetailSuratSkckPresenter presenter;
    Bundle bundle;
    TextView tvKodeSuratSkck;

    public DetailSuratSkckFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_surat_skck, container, false);
    }

    @Override
    public void tampilDataDetail() {

    }

    @Override
    public void onShowData(SuratSkckData suratSkckData) {

    }

    @Override
    public void onAttachView() {
    }

    @Override
    public void onDetachView() {

    }
}
