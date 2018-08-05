package com.codelab.helmi.simades.pergi.detail;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codelab.helmi.simades.R;
import com.codelab.helmi.simades.pergi.PergiData;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailPergiFragment extends Fragment implements DetailPergiView {
    View view;
    DetailPergiPresenter presenter;
    public static String EXTRA_PERGI = "extra_pergi";
    private ImageView ivDetailPergiGambar;
    private TextView tvDetailPergiNikPergi;
    private TextView tvDetailPergiNama;
    private TextView tvDetailPergiAlamatTujuan;
    private TextView tvDetailPergiKodePos;
    private TextView tvDetailPergiAlasan;
    private TextView tvDetailPergiTglPergi;
    private TextView tvDetailPergiTtl;
    private TextView tvDetailPergiUmur;
    private TextView tvDetailPergiNamaAyah;
    private TextView tvDetailPergiNamaIbu;
    Bundle bundle;
    PergiData pergiData;


    public DetailPergiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_detail_pergi, container, false);
        initView();
        initPresenter();
        onAttachView();
        tampilDataDetail();
        getActivity().setTitle("Detail Pergi");
        return view;
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

    @Override
    public void initView() {
        ivDetailPergiGambar = view.findViewById(R.id.iv_detail_pergi_gambar);
        tvDetailPergiNikPergi = view.findViewById(R.id.tv_detail_pergi_nik_pergi);
        tvDetailPergiNama = view.findViewById(R.id.tv_detail_pergi_nama);
        tvDetailPergiAlamatTujuan = view.findViewById(R.id.tv_detail_pergi_alamat_tujuan);
        tvDetailPergiKodePos = view.findViewById(R.id.tv_detail_pergi_kode_pos);
        tvDetailPergiAlasan = view.findViewById(R.id.tv_detail_pergi_alasan);
        tvDetailPergiTglPergi = view.findViewById(R.id.tv_detail_pergi_tgl_pergi);
        tvDetailPergiTtl = view.findViewById(R.id.tv_detail_pergi_ttl);
        tvDetailPergiUmur = view.findViewById(R.id.tv_detail_pergi_umur);
        tvDetailPergiNamaAyah = view.findViewById(R.id.tv_detail_pergi_nama_ayah);
        tvDetailPergiNamaIbu = view.findViewById(R.id.tv_detail_pergi_nama_ibu);
    }

    @Override
    public void initPresenter() {
        presenter = new DetailPergiPresenter();
    }

    @Override
    public void tampilDataDetail() {
        bundle = this.getArguments();
        pergiData = bundle.getParcelable(EXTRA_PERGI);

        if (pergiData.getJekel().equals("Laki-laki")) {
            Glide.with(this).load(R.drawable.ic_boy).into(ivDetailPergiGambar);
        } else {
            Glide.with(this).load(R.drawable.ic_girl).into(ivDetailPergiGambar);
        }

        tvDetailPergiNikPergi.setText(pergiData.getNikPergi());
        if (pergiData.getNamaBelakang() != null) {
            tvDetailPergiNama.setText(pergiData.getNamaDepan() + " " + pergiData.getNamaBelakang());
        } else {
            tvDetailPergiNama.setText(pergiData.getNamaDepan());
        }
        tvDetailPergiAlamatTujuan.setText(pergiData.getAlamatTuju());
        tvDetailPergiKodePos.setText(pergiData.getKodePos());
        tvDetailPergiAlasan.setText(pergiData.getAlasan());
        tvDetailPergiTglPergi.setText(pergiData.getTglPergi());
        tvDetailPergiTtl.setText(pergiData.getTempatLhr() + ", " + pergiData.getTanggalLhr());
        tvDetailPergiUmur.setText(pergiData.getUmur());
        tvDetailPergiNamaAyah.setText(pergiData.getNamaAyah());
        tvDetailPergiNamaIbu.setText(pergiData.getNamaIbu());

    }
}
