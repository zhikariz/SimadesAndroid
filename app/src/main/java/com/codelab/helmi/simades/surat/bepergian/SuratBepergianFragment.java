package com.codelab.helmi.simades.surat.bepergian;


import android.app.Fragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codelab.helmi.simades.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SuratBepergianFragment extends Fragment {


    public SuratBepergianFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_surat_bepergian, container, false);
    }

}
