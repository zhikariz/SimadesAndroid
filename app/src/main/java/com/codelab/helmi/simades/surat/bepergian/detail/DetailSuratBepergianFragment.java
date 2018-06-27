package com.codelab.helmi.simades.surat.bepergian.detail;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.codelab.helmi.simades.R;
import com.codelab.helmi.simades.surat.bepergian.SuratBepergianData;
import com.codelab.helmi.simades.surat.bepergian.SuratBepergianFragment;

public class DetailSuratBepergianFragment extends Fragment implements DetailSuratBepergianView, View.OnClickListener {

    public static String EXTRA_SURAT_BEPERGIAN = "extra_surat_bepergian";
    View view;
    DetailSuratBepergianPresenter presenter;
    Bundle bundle;
    TextView tvKodeSuratBepergian, tvNomorSuratBepergian, tvStatusPersetujuanSuratBepergian, tvTanggalSurat, tvNamaPengaju, tvNikPengaju, tvNamaPejabat;
    Button btnSetujuiSuratBepergian, btnBatalSetujuiSuratBepergian;
    SuratBepergianData suratBepergianData;

    public DetailSuratBepergianFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_detail_surat_bepergian, container, false);
        initPresenter();
        initView();
        onAttachView();
        tampilDataDetail();
        return view;
    }

    private void initView() {
        tvKodeSuratBepergian = view.findViewById(R.id.tv_detail_surat_bepergian_kode);
        tvNomorSuratBepergian = view.findViewById(R.id.tv_detail_surat_bepergian_nomor_surat);
        tvStatusPersetujuanSuratBepergian = view.findViewById(R.id.tv_detail_surat_bepergian_status_persetujuan);
        tvTanggalSurat = view.findViewById(R.id.tv_detail_surat_bepergian_tgl_surat);
        tvNamaPengaju = view.findViewById(R.id.tv_detail_surat_bepergian_nama_pengaju);
        tvNikPengaju = view.findViewById(R.id.tv_detail_surat_bepergian_nik_pengaju);
        tvNamaPejabat = view.findViewById(R.id.tv_detail_surat_bepergian_nama_pejabat);

        btnSetujuiSuratBepergian = view.findViewById(R.id.btn_detail_surat_bepergian_setujui);
        btnSetujuiSuratBepergian.setOnClickListener(this);
        btnBatalSetujuiSuratBepergian = view.findViewById(R.id.btn_detail_surat_bepergian_batalkan_persetujuan);
        btnBatalSetujuiSuratBepergian.setOnClickListener(this);
    }

    private void initPresenter() {
        presenter = new DetailSuratBepergianPresenter();

    }

    @Override
    public void tampilDataDetail() {
        bundle = this.getArguments();
        suratBepergianData = bundle.getParcelable(EXTRA_SURAT_BEPERGIAN);

        tvKodeSuratBepergian.setText(suratBepergianData.getKd_surat());
        tvNomorSuratBepergian.setText(suratBepergianData.getNo_surat());
        tvStatusPersetujuanSuratBepergian.setText(suratBepergianData.getStatus_persetujuan());
        tvTanggalSurat.setText(suratBepergianData.getTgl_surat());
        tvNamaPengaju.setText(suratBepergianData.getNama_depan() + " " + suratBepergianData.getNama_belakang());
        tvNikPengaju.setText(suratBepergianData.getNik());
        tvNamaPejabat.setText(suratBepergianData.getNama_depan_user() + " " + suratBepergianData.getNama_belakang_user());

        if(suratBepergianData.getStatus_persetujuan().equals("Disetujui")){
            tvStatusPersetujuanSuratBepergian.setTextColor(Color.parseColor("#008000"));
            btnBatalSetujuiSuratBepergian.setVisibility(View.VISIBLE);
            btnSetujuiSuratBepergian.setVisibility(View.GONE);
        }else if(suratBepergianData.getStatus_persetujuan().equals("Belum disetujui")){
            tvStatusPersetujuanSuratBepergian.setTextColor(Color.parseColor("#ff0000"));
            btnBatalSetujuiSuratBepergian.setVisibility(View.GONE);
            btnSetujuiSuratBepergian.setVisibility(View.VISIBLE);

        }
    }

    @Override
    public void onShowData(SuratBepergianData suratBepergianData) {

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
    public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_detail_surat_bepergian_setujui:
                    presenter.putStatusPersetujuan(suratBepergianData.getKd_surat(), "Disetujui");
                    SuratBepergianFragment.mBundleRecyclerViewState = null;
                    try {
                        Thread.sleep(500);
                        getFragmentManager().popBackStack();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case R.id.btn_detail_surat_bepergian_batalkan_persetujuan:
                    presenter.putStatusPersetujuan(suratBepergianData.getKd_surat(), "Belum disetujui");
                    SuratBepergianFragment.mBundleRecyclerViewState = null;
                    try {
                        Thread.sleep(500);
                        getFragmentManager().popBackStack();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }
    }
}
