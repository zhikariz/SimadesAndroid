package com.codelab.helmi.simades.surat;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
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

    LinearLayout lnKelahiran;
    LinearLayout lnUsaha;
    LinearLayout lnMeninggal;
    LinearLayout lnSkck;
    LinearLayout lnWali;
    LinearLayout lnBlmMenikah;
    LinearLayout lnIzinKeramaian;
    LinearLayout lnBepergian;
    LinearLayout lnKehilangan;
    LinearLayout lnTidakMampu;
    LinearLayout lnDomisili;
    LinearLayout lnEktp;

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
        lnKelahiran = view.findViewById(R.id.ln_kelahiran);
        ivKelahiran = view.findViewById(R.id.iv_kelahiran);

        lnUsaha = view.findViewById(R.id.ln_usaha);
        ivUsaha = view.findViewById(R.id.iv_usaha);

        lnMeninggal = view.findViewById(R.id.ln_meninggal);
        ivMeninggal = view.findViewById(R.id.iv_meninggal);

        lnSkck = view.findViewById(R.id.ln_skck);
        ivSkck = view.findViewById(R.id.iv_skck);

        lnWali = view.findViewById(R.id.ln_wali);
        ivWali = view.findViewById(R.id.iv_wali);

        lnBlmMenikah = view.findViewById(R.id.ln_blm_menikah);
        ivBlmMenikah = view.findViewById(R.id.iv_blm_menikah);

        lnIzinKeramaian = view.findViewById(R.id.ln_izin_keramaian);
        ivIzinKeramaian = view.findViewById(R.id.iv_izin_keramaian);

        lnBepergian = view.findViewById(R.id.ln_bepergian);
        ivBepergian = view.findViewById(R.id.iv_bepergian);

        lnKehilangan = view.findViewById(R.id.ln_kehilangan);
        ivKehilangan = view.findViewById(R.id.iv_kehilangan);

        lnTidakMampu = view.findViewById(R.id.ln_tidak_mampu);
        ivTidakMampu = view.findViewById(R.id.iv_tidak_mampu);

        lnDomisili = view.findViewById(R.id.ln_domisili);
        ivDomisili = view.findViewById(R.id.iv_domisili);

        lnEktp = view.findViewById(R.id.ln_ektp);
        ivEktp = view.findViewById(R.id.iv_ektp);

        Glide.with(this).load(R.drawable.ic_baby).into(ivKelahiran);
        Glide.with(this).load(R.drawable.ic_office).into(ivUsaha);
        Glide.with(this).load(R.drawable.ic_skull).into(ivMeninggal);
        Glide.with(this).load(R.drawable.ic_police_badge).into(ivSkck);
        Glide.with(this).load(R.drawable.ic_parents).into(ivWali);
        Glide.with(this).load(R.drawable.ic_ring).into(ivBlmMenikah);
        Glide.with(this).load(R.drawable.ic_speaker).into(ivIzinKeramaian);
        Glide.with(this).load(R.drawable.ic_plane).into(ivBepergian);
        Glide.with(this).load(R.drawable.ic_thief).into(ivKehilangan);
        Glide.with(this).load(R.drawable.ic_mailing).into(ivTidakMampu);
        Glide.with(this).load(R.drawable.ic_rumah).into(ivDomisili);
        Glide.with(this).load(R.drawable.ic_identity_card).into(ivEktp);

        lnKelahiran.setOnClickListener(this);
        lnUsaha.setOnClickListener(this);
        lnMeninggal.setOnClickListener(this);
        lnSkck.setOnClickListener(this);
        lnWali.setOnClickListener(this);
        lnBlmMenikah.setOnClickListener(this);
        lnIzinKeramaian.setOnClickListener(this);
        lnBepergian.setOnClickListener(this);
        lnKehilangan.setOnClickListener(this);
        lnTidakMampu.setOnClickListener(this);
        lnDomisili.setOnClickListener(this);
        lnEktp.setOnClickListener(this);
    }

    // untuk mengganti isi kontainer menu yang dipiih
    private void callFragment(Fragment fragment) {
        fragmentManager = getFragmentManager();
        fragmentManager.popBackStack();
        fragmentManager.beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .replace(R.id.frame_container, fragment, fragment.getClass().getSimpleName())
                .addToBackStack(fragment.getClass().getSimpleName())
                .commit();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ln_kelahiran:
                fragment = new SuratKelahiranFragment();
                callFragment(fragment);
                break;
            case R.id.ln_usaha:
                fragment = new SuratUsahaFragment();
                callFragment(fragment);
                break;
            case R.id.ln_meninggal:
                fragment = new SuratKematianFragment();
                callFragment(fragment);
                break;
            case R.id.ln_skck:
                fragment = new SuratSkckFragment();
                callFragment(fragment);
                break;
            case R.id.ln_wali:
                fragment = new SuratWaliFragment();
                callFragment(fragment);
                break;
            case R.id.ln_blm_menikah:
                fragment = new SuratBlmMenikahFragment();
                callFragment(fragment);
                break;
            case R.id.ln_izin_keramaian:
                fragment = new SuratKeramaianFragment();
                callFragment(fragment);
                break;
            case R.id.ln_bepergian:
                fragment = new SuratBepergianFragment();
                callFragment(fragment);
                break;
            case R.id.ln_kehilangan:
                fragment = new SuratKehilanganFragment();
                callFragment(fragment);
                break;
            case R.id.ln_tidak_mampu:
                fragment = new SuratTidakMampuFragment();
                callFragment(fragment);
                break;
            case R.id.ln_domisili:
                fragment = new SuratDomisiliFragment();
                callFragment(fragment);
                break;
            case R.id.ln_ektp:
                fragment = new SuratEktpFragment();
                callFragment(fragment);
                break;
        }
    }
}
