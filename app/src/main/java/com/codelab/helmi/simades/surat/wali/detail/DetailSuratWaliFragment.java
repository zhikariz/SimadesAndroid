package com.codelab.helmi.simades.surat.wali.detail;


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
import com.codelab.helmi.simades.surat.wali.SuratWaliData;
import com.codelab.helmi.simades.surat.wali.SuratWaliFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailSuratWaliFragment extends Fragment implements DetailSuratWaliView, View.OnClickListener {


    public static String EXTRA_SURAT_WALI = "extra_surat_wali";
    View view;
    DetailSuratWaliPresenter presenter;
    Bundle bundle;
    TextView tvKodeSuratWali, tvNomorSuratWali, tvStatusPersetujuanSuratWali, tvTanggalSurat, tvNikPengaju,tvNamaPengaju, tvNamaPejabat;
    Button btnSetujuiSuratWali, btnBatalSetujuiSuratWali;
    SuratWaliData suratWaliData;

    public DetailSuratWaliFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_detail_surat_wali, container, false);
        initPresenter();
        initView();
        onAttachView();
        tampilDataDetail();

        return view;
    }

    private void initView() {
        tvKodeSuratWali = view.findViewById(R.id.tv_detail_surat_wali_kode);
        tvNomorSuratWali = view.findViewById(R.id.tv_detail_surat_wali_nomor_surat);
        tvStatusPersetujuanSuratWali = view.findViewById(R.id.tv_detail_surat_wali_status_persetujuan);
        tvTanggalSurat = view.findViewById(R.id.tv_detail_surat_wali_tgl_surat);
        tvNamaPengaju = view.findViewById(R.id.tv_detail_surat_wali_nama_pengaju);
        tvNikPengaju = view.findViewById(R.id.tv_detail_surat_wali_nik_pengaju);
        tvNamaPejabat = view.findViewById(R.id.tv_detail_surat_wali_nama_pejabat);

        btnSetujuiSuratWali = view.findViewById(R.id.btn_detail_surat_wali_setujui);
        btnSetujuiSuratWali.setOnClickListener(this);
        btnBatalSetujuiSuratWali = view.findViewById(R.id.btn_detail_surat_wali_batalkan_persetujuan);
        btnBatalSetujuiSuratWali.setOnClickListener(this);

    }

    private void initPresenter() {
        presenter = new DetailSuratWaliPresenter();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void tampilDataDetail() {
        bundle = this.getArguments();
        suratWaliData = bundle.getParcelable(EXTRA_SURAT_WALI);

        tvKodeSuratWali.setText(suratWaliData.getKd_surat());
        tvNomorSuratWali.setText(suratWaliData.getNo_surat());
        tvStatusPersetujuanSuratWali.setText(suratWaliData.getStatus_persetujuan());
        tvTanggalSurat.setText(suratWaliData.getTgl_surat());
        tvNamaPengaju.setText(suratWaliData.getNama_depan_wali() + " " + suratWaliData.getNama_belakang_wali());
        tvNikPengaju.setText(suratWaliData.getNik());
        tvNamaPejabat.setText(suratWaliData.getNama_depan_user() + " " + suratWaliData.getNama_belakang_user());

        if(suratWaliData.getStatus_persetujuan().equals("Disetujui")){
            tvStatusPersetujuanSuratWali.setTextColor(Color.parseColor("#008000"));
            btnBatalSetujuiSuratWali.setVisibility(View.VISIBLE);
            btnSetujuiSuratWali.setVisibility(View.GONE);
        }else if(suratWaliData.getStatus_persetujuan().equals("Belum disetujui")){
            tvStatusPersetujuanSuratWali.setTextColor(Color.parseColor("#ff0000"));
            btnBatalSetujuiSuratWali.setVisibility(View.GONE);
            btnSetujuiSuratWali.setVisibility(View.VISIBLE);

        }




    }

    @Override
    public void onShowData(SuratWaliData suratWaliData) {

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
            case R.id.btn_detail_surat_wali_setujui:
                presenter.putStatusPersetujuan(suratWaliData.getKd_surat(), "Disetujui");
                SuratWaliFragment.mBundleRecyclerViewState = null;
                try {
                    Thread.sleep(500);
                    getFragmentManager().popBackStack();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_detail_surat_wali_batalkan_persetujuan:
                presenter.putStatusPersetujuan(suratWaliData.getKd_surat(), "Belum disetujui");
                SuratWaliFragment.mBundleRecyclerViewState = null;
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
