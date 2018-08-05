package com.codelab.helmi.simades.surat.keramaian.detail;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.codelab.helmi.simades.R;
import com.codelab.helmi.simades.surat.keramaian.SuratKeramaianData;
import com.codelab.helmi.simades.surat.keramaian.SuratKeramaianFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailSuratKeramaianFragment extends Fragment implements DetailSuratKeramaianView, View.OnClickListener {

    public static String EXTRA_SURAT_IZIN_KERAMAIAN = "extra_surat_izin_keramaian";
    View view;
    DetailSuratKeramaianPresenter presenter;
    Bundle bundle;
    TextView tvKodeSuratKeramaian, tvNomorSuratKeramaian, tvStatusPersetujuanSuratKeramaian, tvTanggalSurat, tvNikPengaju, tvNamaPengaju, tvNamaPejabat;
    Button btnSetujuiSuratKeramaian, btnBatalSetujuiSuratKeramaian;
    SuratKeramaianData suratKeramaianData;

    public DetailSuratKeramaianFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_detail_surat_keramaian, container, false);
        initPresenter();
        initView();
        onAttachView();
        tampilDataDetail();
        return view;
    }

    private void initView() {
        tvKodeSuratKeramaian = view.findViewById(R.id.tv_detail_surat_izin_keramaian_kode);
        tvNomorSuratKeramaian = view.findViewById(R.id.tv_detail_surat_izin_keramaian_nomor_surat);
        tvStatusPersetujuanSuratKeramaian = view.findViewById(R.id.tv_detail_surat_izin_keramaian_status_persetujuan);
        tvTanggalSurat = view.findViewById(R.id.tv_detail_surat_izin_keramaian_tgl_surat);
        tvNamaPengaju = view.findViewById(R.id.tv_detail_surat_izin_keramaian_nama_pengaju);
        tvNikPengaju = view.findViewById(R.id.tv_detail_surat_izin_keramaian_nik_pengaju);
        tvNamaPejabat = view.findViewById(R.id.tv_detail_surat_izin_keramaian_nama_pejabat);

        btnSetujuiSuratKeramaian = view.findViewById(R.id.btn_detail_surat_izin_keramaian_setujui);
        btnSetujuiSuratKeramaian.setOnClickListener(this);
        btnBatalSetujuiSuratKeramaian = view.findViewById(R.id.btn_detail_surat_izin_keramaian_batalkan_persetujuan);
        btnBatalSetujuiSuratKeramaian.setOnClickListener(this);


    }

    private void initPresenter() {
        presenter = new DetailSuratKeramaianPresenter();

    }

    @Override
    public void tampilDataDetail() {
        bundle = this.getArguments();
        suratKeramaianData = bundle.getParcelable(EXTRA_SURAT_IZIN_KERAMAIAN);

        tvKodeSuratKeramaian.setText(suratKeramaianData.getKd_surat());
        tvNomorSuratKeramaian.setText(suratKeramaianData.getNo_surat());
        tvStatusPersetujuanSuratKeramaian.setText(suratKeramaianData.getStatus_persetujuan());
        tvTanggalSurat.setText(suratKeramaianData.getTgl_surat());
        tvNamaPengaju.setText(suratKeramaianData.getNama_depan() + " " + suratKeramaianData.getNama_belakang());
        tvNikPengaju.setText(suratKeramaianData.getNik());
        tvNamaPejabat.setText(suratKeramaianData.getNama_depan_user() + " " + suratKeramaianData.getNama_belakang_user());

        if(suratKeramaianData.getStatus_persetujuan().equals("Disetujui")){
            tvStatusPersetujuanSuratKeramaian.setTextColor(Color.parseColor("#008000"));

        } else if(suratKeramaianData.getStatus_persetujuan().equals("Belum disetujui")){
            tvStatusPersetujuanSuratKeramaian.setTextColor(Color.parseColor("#ff0000"));
        }

    }

    @Override
    public void onShowData(SuratKeramaianData suratKeramaianData) {

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
            case R.id.btn_detail_surat_izin_keramaian_setujui:
                presenter.putStatusPersetujuan(suratKeramaianData.getKd_surat(), "Disetujui");
                SuratKeramaianFragment.mBundleRecyclerViewState = null;
                try {
                    Thread.sleep(500);
                    getFragmentManager().popBackStack();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_detail_surat_izin_keramaian_batalkan_persetujuan:
                presenter.putStatusPersetujuan(suratKeramaianData.getKd_surat(), "Belum disetujui");
                SuratKeramaianFragment.mBundleRecyclerViewState = null;
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
