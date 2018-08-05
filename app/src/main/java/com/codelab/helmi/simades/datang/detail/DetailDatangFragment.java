package com.codelab.helmi.simades.datang.detail;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codelab.helmi.simades.R;
import com.codelab.helmi.simades.datang.DatangData;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailDatangFragment extends Fragment implements DetailDatangView {

    View view;
    public static String EXTRA_DATANG = "extra_datang";
    DetailDatangPresenter presenter;
    Bundle bundle;
    DatangData datangData;
    private ImageView ivDetailDatangGambar;
    private TextView tvDetailDatangNikPendatang;
    private TextView tvDetailKelahiranNikAsal;
    private TextView tvDetailDatangNoKkAsal;
    private TextView tvDetailDatangNama;
    private TextView tvDetailDatangAlamatAsal;
    private TextView tvDetailDatangAlasan;
    private TextView tvDetailDatangPengikut;
    private TextView tvDetailDatangUmur;
    private TextView tvDetailDatangTtl;
    private TextView tvDetailDatangNamaAyah;
    private TextView tvDetailDatangNamaIbu;


    public DetailDatangFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_detail_datang, container, false);
        initView();
        initPresenter();
        onAttachView();
        tampilDataDetail();
        getActivity().setTitle("Detail Datang");
        return view;
    }

    @Override
    public void tampilDataDetail() {
        bundle = this.getArguments();
        datangData = bundle.getParcelable(EXTRA_DATANG);

        if(datangData.getJekel().equals("Laki-laki")){
            Glide.with(this).load(R.drawable.ic_boy).into(ivDetailDatangGambar);
        }else{
            Glide.with(this).load(R.drawable.ic_girl).into(ivDetailDatangGambar);
        }

        tvDetailDatangNikPendatang.setText(datangData.getNikPendatang());
        tvDetailKelahiranNikAsal.setText(datangData.getNikAsal());
        tvDetailDatangNoKkAsal.setText(datangData.getNoKkAsal());
        if(datangData.getNamaBelakang() != null) {
            tvDetailDatangNama.setText(datangData.getNamaDepan() + " " + datangData.getNamaBelakang());
        }else{
            tvDetailDatangNama.setText(datangData.getNamaDepan());
        }

        tvDetailDatangAlamatAsal.setText(datangData.getAlamatAsal());
        tvDetailDatangAlasan.setText(datangData.getAlasan());
        tvDetailDatangPengikut.setText(datangData.getPengikut());
        tvDetailDatangUmur.setText(datangData.getUmur());
        tvDetailDatangTtl.setText(datangData.getTempatLhr()+", "+datangData.getTanggalLhr());
        tvDetailDatangNamaAyah.setText(datangData.getNamaAyah());
        tvDetailDatangNamaIbu.setText(datangData.getNamaIbu());
    }

    @Override
    public void initView() {
        ivDetailDatangGambar = view.findViewById(R.id.iv_detail_datang_gambar);
        tvDetailDatangNikPendatang = view.findViewById(R.id.tv_detail_datang_nik_pendatang);
        tvDetailKelahiranNikAsal = view.findViewById(R.id.tv_detail_kelahiran_nik_asal);
        tvDetailDatangNoKkAsal = view.findViewById(R.id.tv_detail_datang_no_kk_asal);
        tvDetailDatangNama = view.findViewById(R.id.tv_detail_datang_nama);
        tvDetailDatangAlamatAsal = view.findViewById(R.id.tv_detail_datang_alamat_asal);
        tvDetailDatangAlasan = view.findViewById(R.id.tv_detail_datang_alasan);
        tvDetailDatangPengikut = view.findViewById(R.id.tv_detail_datang_pengikut);
        tvDetailDatangUmur = view.findViewById(R.id.tv_detail_datang_umur);
        tvDetailDatangTtl = view.findViewById(R.id.tv_detail_datang_ttl);
        tvDetailDatangNamaAyah = view.findViewById(R.id.tv_detail_datang_nama_ayah);
        tvDetailDatangNamaIbu = view.findViewById(R.id.tv_detail_datang_nama_ibu);
    }

    @Override
    public void initPresenter() {
        presenter = new DetailDatangPresenter();
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
