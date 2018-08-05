package com.codelab.helmi.simades.surat.blm_menikah.detail;


import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.codelab.helmi.simades.R;
import com.codelab.helmi.simades.surat.blm_menikah.SuratBlmMenikahData;
import com.codelab.helmi.simades.surat.blm_menikah.SuratBlmMenikahFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailSuratBlmMenikahFragment extends Fragment implements DetailSuratBlmMenikahView, View.OnClickListener {


    public static String EXTRA_SURAT_BLM_MENIKAH = "extra_surat_blm_menikah";
    View view;
    DetailSuratBlmMenikahPresenter presenter;
    Bundle bundle;
    TextView tvKodeSuratBlmMenikah, tvNomorSuratBlmMenikah, tvStatusPersetujuanSuratBlmMenikah, tvTanggalSurat, tvNikPengaju, tvNamaPengaju, tvNamaPejabat;

    Button btnSetujuiSuratBlmMenikah, btnBatalSetujuiSuratBlmMenikah;
    SuratBlmMenikahData suratBlmMenikahData;

    public DetailSuratBlmMenikahFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_detail_surat_blm_menikah, container, false);
        initPresenter();
        initView();
        onAttachView();
        tampilDataDetail();

        return view;
    }

    private void initView() {
        tvKodeSuratBlmMenikah = view.findViewById(R.id.tv_detail_surat_blm_menikah_kode);
        tvNomorSuratBlmMenikah = view.findViewById(R.id.tv_detail_surat_blm_menikah_nomor_surat);
        tvStatusPersetujuanSuratBlmMenikah = view.findViewById(R.id.tv_detail_surat_blm_menikah_status_persetujuan);
        tvTanggalSurat = view.findViewById(R.id.tv_detail_surat_blm_menikah_tgl_surat);
        tvNamaPengaju = view.findViewById(R.id.tv_detail_surat_blm_menikah_nama_pengaju);
        tvNikPengaju = view.findViewById(R.id.tv_detail_surat_blm_menikah_nik_pengaju);
        tvNamaPejabat = view.findViewById(R.id.tv_detail_surat_blm_menikah_nama_pejabat);

        btnSetujuiSuratBlmMenikah = view.findViewById(R.id.btn_detail_surat_blm_menikah_setujui);
        btnSetujuiSuratBlmMenikah.setOnClickListener(this);
        btnBatalSetujuiSuratBlmMenikah = view.findViewById(R.id.btn_detail_surat_blm_menikah_batalkan_persetujuan);
        btnBatalSetujuiSuratBlmMenikah.setOnClickListener(this);

    }

    private void initPresenter() {
        presenter = new DetailSuratBlmMenikahPresenter();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void tampilDataDetail() {
        bundle = this.getArguments();
        suratBlmMenikahData = bundle.getParcelable(EXTRA_SURAT_BLM_MENIKAH);

        tvKodeSuratBlmMenikah.setText(suratBlmMenikahData.getKd_surat());
        tvNomorSuratBlmMenikah.setText(suratBlmMenikahData.getNo_surat());
        tvStatusPersetujuanSuratBlmMenikah.setText(suratBlmMenikahData.getStatus_persetujuan());
        tvTanggalSurat.setText(suratBlmMenikahData.getTgl_surat());
        tvNamaPengaju.setText(suratBlmMenikahData.getNama_depan() + " "+suratBlmMenikahData.getNama_belakang());
        tvNikPengaju.setText(suratBlmMenikahData.getNik());
        tvNamaPejabat.setText(suratBlmMenikahData.getNama_depan_user() + " " + suratBlmMenikahData.getNama_belakang_user());

        if(suratBlmMenikahData.getStatus_persetujuan().equals("Disetujui")){
            tvStatusPersetujuanSuratBlmMenikah.setTextColor(Color.parseColor("#008000"));
        }else if(suratBlmMenikahData.getStatus_persetujuan().equals("Belum disetujui")){
            tvStatusPersetujuanSuratBlmMenikah.setTextColor(Color.parseColor("#ff0000"));
        }


    }

    @Override
    public void onShowData(SuratBlmMenikahData suratBlmMenikahData) {

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
            case R.id.btn_detail_surat_blm_menikah_setujui:
                presenter.putStatusPersetujuan(suratBlmMenikahData.getKd_surat(), "Disetujui");
                SuratBlmMenikahFragment.mBundleRecyclerViewState = null;
                try {
                    Thread.sleep(500);
                    getFragmentManager().popBackStack();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_detail_surat_blm_menikah_batalkan_persetujuan:
                presenter.putStatusPersetujuan(suratBlmMenikahData.getKd_surat(), "Belum disetujui");
                SuratBlmMenikahFragment.mBundleRecyclerViewState = null;
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
