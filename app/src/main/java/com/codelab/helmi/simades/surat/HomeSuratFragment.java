package com.codelab.helmi.simades.surat;


import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.codelab.helmi.simades.R;
import com.codelab.helmi.simades.surat.bepergian.SuratBepergianFragment;
import com.codelab.helmi.simades.surat.blm_menikah.SuratBlmMenikahFragment;
import com.codelab.helmi.simades.surat.domisili.SuratDomisiliFragment;
import com.codelab.helmi.simades.surat.ektp.SuratEktpFragment;
import com.codelab.helmi.simades.surat.kehilangan.SuratKehilanganFragment;
import com.codelab.helmi.simades.surat.kelahiran.SuratKelahiranFragment;
import com.codelab.helmi.simades.surat.kematian.SuratKematianFragment;
import com.codelab.helmi.simades.surat.keramaian.SuratKeramaianFragment;
import com.codelab.helmi.simades.surat.skck.SuratSkckFragment;
import com.codelab.helmi.simades.surat.tidak_mampu.SuratTidakMampuFragment;
import com.codelab.helmi.simades.surat.usaha.SuratUsahaFragment;
import com.codelab.helmi.simades.surat.wali.SuratWaliFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeSuratFragment extends Fragment implements View.OnClickListener {

    FragmentManager fragmentManager;
    ImageView ivKelahiran;
    ImageView ivUsaha;
    ImageView ivMeninggal;
    ImageView ivSkck;
    ImageView ivWali;
    ImageView ivBlmMenikah;
    ImageView ivIzinKeramaian;
    ImageView ivBepergian;
    ImageView ivKehilangan;
    ImageView ivTidakMampu;
    ImageView ivDomisili;
    ImageView ivEktp;
    View view;
    Fragment fragment = null;

    public HomeSuratFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home_surat, container, false);
        getActivity().setTitle("Pengajuan Surat");
        initView();
        return view;
    }

    public void initView() {
        ivKelahiran = (ImageView) view.findViewById(R.id.iv_kelahiran);
        ivUsaha = (ImageView) view.findViewById(R.id.iv_usaha);
        ivMeninggal = (ImageView) view.findViewById(R.id.iv_meninggal);
        ivSkck = (ImageView) view.findViewById(R.id.iv_skck);
        ivWali = (ImageView) view.findViewById(R.id.iv_wali);
        ivBlmMenikah = (ImageView) view.findViewById(R.id.iv_blm_menikah);
        ivIzinKeramaian = (ImageView) view.findViewById(R.id.iv_izin_keramaian);
        ivBepergian = (ImageView) view.findViewById(R.id.iv_bepergian);
        ivKehilangan = (ImageView) view.findViewById(R.id.iv_kehilangan);
        ivTidakMampu = (ImageView) view.findViewById(R.id.iv_tidak_mampu);
        ivDomisili = (ImageView) view.findViewById(R.id.iv_domisili);
        ivEktp = (ImageView) view.findViewById(R.id.iv_ektp);

        ivKelahiran.setOnClickListener(this);
        ivUsaha.setOnClickListener(this);
        ivMeninggal.setOnClickListener(this);
        ivSkck.setOnClickListener(this);
        ivWali.setOnClickListener(this);
        ivBlmMenikah.setOnClickListener(this);
        ivIzinKeramaian.setOnClickListener(this);
        ivBepergian.setOnClickListener(this);
        ivKehilangan.setOnClickListener(this);
        ivTidakMampu.setOnClickListener(this);
        ivDomisili.setOnClickListener(this);
        ivEktp.setOnClickListener(this);
    }

    // untuk mengganti isi kontainer menu yang dipiih
    private void callFragment(Fragment fragment) {
        fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frame_container, fragment, fragment.getClass().getSimpleName())
                .addToBackStack(fragment.getClass().getSimpleName())
                .commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_kelahiran:
                fragment = new SuratKelahiranFragment();
                callFragment(fragment);
                break;
            case R.id.iv_usaha:
                fragment = new SuratUsahaFragment();
                callFragment(fragment);
                break;
            case R.id.iv_meninggal:
                fragment = new SuratKematianFragment();
                callFragment(fragment);
                break;
            case R.id.iv_skck:
                fragment = new SuratSkckFragment();
                callFragment(fragment);
                break;
            case R.id.iv_wali:
                fragment = new SuratWaliFragment();
                callFragment(fragment);
                break;
            case R.id.iv_blm_menikah:
                fragment = new SuratBlmMenikahFragment();
                callFragment(fragment);
                break;
            case R.id.iv_izin_keramaian:
                fragment = new SuratKeramaianFragment();
                callFragment(fragment);
                break;
            case R.id.iv_bepergian:
                fragment = new SuratBepergianFragment();
                callFragment(fragment);
                break;
            case R.id.iv_kehilangan:
                fragment = new SuratKehilanganFragment();
                callFragment(fragment);
                break;
            case R.id.iv_tidak_mampu:
                fragment = new SuratTidakMampuFragment();
                callFragment(fragment);
                break;
            case R.id.iv_domisili:
                fragment = new SuratDomisiliFragment();
                callFragment(fragment);
                break;
            case R.id.iv_ektp:
                fragment = new SuratEktpFragment();
                callFragment(fragment);
                break;
        }
    }
}
