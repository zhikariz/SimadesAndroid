package com.codelab.helmi.simades.kematian.detail;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codelab.helmi.simades.R;
import com.codelab.helmi.simades.kematian.KematianData;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailKematianFragment extends Fragment implements DetailKematianView {

    View view;
    public static String EXTRA_KEMATIAN = "extra_kematian";
    private ImageView ivDetailKematianGambar;
    private TextView tvDetailKematianNikMeninggal;
    private TextView tvDetailKematianNama;
    private TextView tvDetailKematianTglMeninggal;
    private TextView tvDetailKematianSebabMeninggal;
    private TextView tvDetailKematianTempatMeninggal;
    private TextView tvDetailKematianMenerangkan;
    private TextView tvDetailKematianUmur;
    private TextView tvDetailKematianTtl;
    private TextView tvDetailKematianNamaAyah;
    private TextView tvDetailKematianNamaIbu;
    private TextView tvDetailKematianAnakKe;
    DetailKematianPresenter presenter;
    Bundle bundle;
    KematianData kematianData;


    public DetailKematianFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_detail_kematian, container, false);
        initView();
        initPresenter();
        tampilDataDetail();

        return view;
    }

    private void initPresenter() {
        presenter = new DetailKematianPresenter();
    }

    private void initView() {
        ivDetailKematianGambar = view.findViewById(R.id.iv_detail_kematian_gambar);
        tvDetailKematianNikMeninggal = view.findViewById(R.id.tv_detail_kematian_nik_meninggal);
        tvDetailKematianNama = view.findViewById(R.id.tv_detail_kematian_nama);
        tvDetailKematianTglMeninggal = view.findViewById(R.id.tv_detail_kematian_tgl_meninggal);
        tvDetailKematianSebabMeninggal = view.findViewById(R.id.tv_detail_kematian_sebab_meninggal);
        tvDetailKematianTempatMeninggal = view.findViewById(R.id.tv_detail_kematian_tempat_meninggal);
        tvDetailKematianMenerangkan = view.findViewById(R.id.tv_detail_kematian_menerangkan);
        tvDetailKematianUmur = view.findViewById(R.id.tv_detail_kematian_umur);
        tvDetailKematianTtl = view.findViewById(R.id.tv_detail_kematian_ttl);
        tvDetailKematianNamaAyah = view.findViewById(R.id.tv_detail_kematian_nama_ayah);
        tvDetailKematianNamaIbu = view.findViewById(R.id.tv_detail_kematian_nama_ibu);
        tvDetailKematianAnakKe = view.findViewById(R.id.tv_detail_kematian_anak_ke);
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
    public void tampilDataDetail() {
        bundle = this.getArguments();
        kematianData = bundle.getParcelable(EXTRA_KEMATIAN);

        if(kematianData.getJekel().equals("Laki-laki")){
            Glide.with(this).load(R.drawable.ic_baby_boy).into(ivDetailKematianGambar);
        } else {
            Glide.with(this).load(R.drawable.ic_baby_girl).into(ivDetailKematianGambar);
        }

        tvDetailKematianNikMeninggal.setText(kematianData.getNikMeninggal());
        if(kematianData.getNamaBelakang() == null){
            tvDetailKematianNama.setText(kematianData.getNamaDepan());
        }else{
            tvDetailKematianNama.setText(kematianData.getNamaDepan() + " " + kematianData.getNamaBelakang());
        }

        tvDetailKematianTglMeninggal.setText(kematianData.getTglMeninggal());
        tvDetailKematianSebabMeninggal.setText(kematianData.getSebab());
        tvDetailKematianTempatMeninggal.setText(kematianData.getTptMeninggal());
        tvDetailKematianMenerangkan.setText(kematianData.getMenerangkan());
        tvDetailKematianUmur.setText(kematianData.getUmur());
        tvDetailKematianTtl.setText(kematianData.getTempatLhr()+", "+kematianData.getTanggalLhr());
        tvDetailKematianNamaAyah.setText(kematianData.getNamaAyah());
        tvDetailKematianNamaIbu.setText(kematianData.getNamaIbu());
        tvDetailKematianAnakKe.setText(kematianData.getAnakKe());

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        onDetachView();
    }
}
