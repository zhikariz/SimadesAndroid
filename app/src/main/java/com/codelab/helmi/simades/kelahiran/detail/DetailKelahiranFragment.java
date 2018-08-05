package com.codelab.helmi.simades.kelahiran.detail;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codelab.helmi.simades.R;
import com.codelab.helmi.simades.kelahiran.KelahiranData;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailKelahiranFragment extends Fragment implements DetailKelahiranView {

    View view;
    DetailKelahiranPresenter presenter;
    public static String EXTRA_KELAHIRAN = "extra_kelahiran";
    Bundle bundle;
    KelahiranData kelahiranData;
    ImageView ivDetailKelahiran;
    TextView tvNisBayi, tvNamaBayi, tvTTL, tvBeratBayi, tvAnakKe, tvWaktuLahir, tvPanjangBayi, tvNikAyah, tvNamaAyah, tvNikIbu;
    TextView tvNamaIbu, tvNikSaksi1, tvNamaSaksi1, tvNikSaksi2, tvNamaSaksi2;

    public DetailKelahiranFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_detail_kelahiran, container, false);

        initPresenter();
        initView();
        onAttachView();
        tampilDataDetail();
        getActivity().setTitle("Detail Kelahiran");

        return view;
    }

    private void initPresenter() {
        presenter = new DetailKelahiranPresenter();
    }

    private void initView() {
        ivDetailKelahiran = view.findViewById(R.id.iv_detail_kelahiran_gambar);
        tvNisBayi = view.findViewById(R.id.tv_detail_kelahiran_nis_bayi);
        tvNamaBayi = view.findViewById(R.id.tv_detail_kelahiran_nama);
        tvTTL = view.findViewById(R.id.tv_detail_kelahiran_tgl_lahir);
        tvBeratBayi = view.findViewById(R.id.tv_detail_kelahiran_berat_bayi);
        tvAnakKe = view.findViewById(R.id.tv_detail_kelahiran_anak_ke);
        tvWaktuLahir = view.findViewById(R.id.tv_detail_kelahiran_waktu_lahir);
        tvPanjangBayi = view.findViewById(R.id.tv_detail_kelahiran_pjg_bayi);
        tvNikAyah = view.findViewById(R.id.tv_detail_kelahiran_nik_ayah);
        tvNamaAyah = view.findViewById(R.id.tv_detail_kelahiran_nama_ayah);
        tvNikIbu = view.findViewById(R.id.tv_detail_kelahiran_nik_ibu);
        tvNamaIbu = view.findViewById(R.id.tv_detail_kelahiran_nama_ibu);
        tvNikSaksi1 = view.findViewById(R.id.tv_detail_kelahiran_nik_saksi1);
        tvNamaSaksi1 = view.findViewById(R.id.tv_detail_kelahiran_nama_saksi1);
        tvNikSaksi2 = view.findViewById(R.id.tv_detail_kelahiran_nik_saksi2);
        tvNamaSaksi2 = view.findViewById(R.id.tv_detail_kelahiran_nama_saksi2);

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void tampilDataDetail() {
        bundle = this.getArguments();
        kelahiranData = bundle.getParcelable(EXTRA_KELAHIRAN);

        if (kelahiranData.getJekel().equals("Laki-laki")) {
            Glide.with(this).load(R.drawable.ic_baby_boy).into(ivDetailKelahiran);
        } else {
            Glide.with(this).load(R.drawable.ic_baby_girl).into(ivDetailKelahiran);
        }

        tvNisBayi.setText(kelahiranData.getNis_bayi());
        tvNamaBayi.setText(kelahiranData.getNama_depan_bayi() + " " + kelahiranData.getNama_belakang_bayi());
        tvTTL.setText(kelahiranData.getTpt_lahir() + ", " + kelahiranData.getTgl_lahir());
        tvBeratBayi.setText(kelahiranData.getBerat_bayi());
        tvAnakKe.setText(kelahiranData.getAnak_ke());
        tvWaktuLahir.setText(kelahiranData.getWaktu());
        tvPanjangBayi.setText(kelahiranData.getPanjang_bayi());
        tvNikAyah.setText(kelahiranData.getNik_ayah());
        if(kelahiranData.getNama_belakang_ayah() != null){
            tvNamaAyah.setText(kelahiranData.getNama_depan_ayah() + " " + kelahiranData.getNama_belakang_ayah());
        }else{
            tvNamaAyah.setText(kelahiranData.getNama_depan_ayah());
        }

        tvNikIbu.setText(kelahiranData.getNik_ibu());
        if (kelahiranData.getNama_belakang_ibu() != null) {
            tvNamaIbu.setText(kelahiranData.getNama_depan_ibu() + " " + kelahiranData.getNama_belakang_ibu());
        }else{
            tvNamaIbu.setText(kelahiranData.getNama_depan_ibu());
        }
        tvNikSaksi1.setText(kelahiranData.getNik_saksi1());
        if(kelahiranData.getNama_belakang_saksi1() != null){
            tvNamaSaksi1.setText(kelahiranData.getNama_depan_saksi1() + " " + kelahiranData.getNama_belakang_saksi1());
        }else{
            tvNamaSaksi1.setText(kelahiranData.getNama_depan_saksi1());
        }

        tvNikSaksi2.setText(kelahiranData.getNik_saksi2());
        if(kelahiranData.getNama_belakang_saksi2() != null) {
            tvNamaSaksi2.setText(kelahiranData.getNama_depan_saksi2() + " " + kelahiranData.getNama_belakang_saksi2());
        }else{
            tvNamaSaksi2.setText(kelahiranData.getNama_depan_saksi2());
        }


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
