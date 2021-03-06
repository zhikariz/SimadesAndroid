package com.codelab.helmi.simades.penduduk.detail;


import android.annotation.SuppressLint;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codelab.helmi.simades.R;
import com.codelab.helmi.simades.penduduk.PendudukData;

public class DetailPendudukFragment extends Fragment implements DetailPendudukView {

    public static String EXTRA_PENDUDUK = "extra_penduduk";
    DetailPendudukPresenter presenter;
    View view;
    TextView tvNik, tvNama, tvTglLahir, tvNamaAyah, tvNamaIbu, tvAnakKe, tvAgama, tvGoldar, tvHubKel, tvPekerjaan;
    TextView tvPendidikan, tvStatusKawin;
    ImageView ivPenduduk;
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
        ivPenduduk = view.findViewById(R.id.iv_detail_penduduk);
        tvNik = view.findViewById(R.id.tv_detail_penduduk_nik);
        tvNama = view.findViewById(R.id.tv_detail_penduduk_nama);
        tvTglLahir = view.findViewById(R.id.tv_detail_penduduk_tgl_lahir);
        tvNamaAyah = view.findViewById(R.id.tv_detail_penduduk_nama_ayah);
        tvNamaIbu = view.findViewById(R.id.tv_detail_penduduk_nama_ibu);
        tvAnakKe = view.findViewById(R.id.tv_detail_penduduk_anak_ke);
        tvAgama = view.findViewById(R.id.tv_detail_penduduk_agama);
        tvGoldar = view.findViewById(R.id.tv_detail_penduduk_goldar);
        tvHubKel = view.findViewById(R.id.tv_detail_penduduk_hubkel);
        tvPekerjaan = view.findViewById(R.id.tv_detail_penduduk_pekerjaan);
        tvPendidikan = view.findViewById(R.id.tv_detail_penduduk_pendidikan);
        tvStatusKawin = view.findViewById(R.id.tv_detail_penduduk_status_kawin);

    }

    private void initPresenter() {
        presenter = new DetailPendudukPresenter();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void tampilDataDetail() {
        bundle = this.getArguments();
        PendudukData pendudukData = bundle.getParcelable(EXTRA_PENDUDUK);
        tvNik.setText(pendudukData.getNik());
        if (pendudukData.getNama_depan() != null && pendudukData.getNama_belakang() != null) {
            tvNama.setText(pendudukData.getNama_depan() + " " + pendudukData.getNama_belakang());
        } else if (pendudukData.getNama_depan() != null && pendudukData.getNama_belakang() == null) {
            tvNama.setText(pendudukData.getNama_depan());
        }

        if (pendudukData.getJekel().equals("Laki-laki")) {
            Glide.with(this).load(R.drawable.ic_boy).into(ivPenduduk);
        } else if (pendudukData.getJekel().equals("Perempuan")) {
            Glide.with(this).load(R.drawable.ic_girl).into(ivPenduduk);
        }

        tvTglLahir.setText(pendudukData.getTempat_lhr() + ", " + pendudukData.getTanggal_lhr());
        tvNamaAyah.setText(pendudukData.getNama_ayah());
        tvNamaIbu.setText(pendudukData.getNama_ibu());
        tvAnakKe.setText(pendudukData.getAnak_ke());
        tvAgama.setText(pendudukData.getAgama());
        tvGoldar.setText(pendudukData.getGoldar());
        tvHubKel.setText(pendudukData.getHubkel());
        tvPekerjaan.setText(pendudukData.getKerja());
        tvPendidikan.setText(pendudukData.getPendidikan());
        tvStatusKawin.setText(pendudukData.getStkawin());


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
