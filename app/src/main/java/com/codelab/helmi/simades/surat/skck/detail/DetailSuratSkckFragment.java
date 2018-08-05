package com.codelab.helmi.simades.surat.skck.detail;


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
import com.codelab.helmi.simades.surat.skck.SuratSkckData;
import com.codelab.helmi.simades.surat.skck.SuratSkckFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailSuratSkckFragment extends Fragment implements DetailSuratSkckView, View.OnClickListener {

    public static String EXTRA_SURAT_SKCK;
    View view;
    DetailSuratSkckPresenter presenter;
    Bundle bundle;
    TextView tvKodeSuratSkck, tvNomorSuratSkck, tvStatusPersetujuanSuratSkck,tvTanggalSurat, tvNikPengaju, tvNamaPengaju, tvPejabat;
    Button btnSetujuiSuratSkck, btnBatalSetujuiSuratSkck;
    SuratSkckData suratSkckData;
    public DetailSuratSkckFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_detail_surat_skck, container, false);
        initPresenter();
        initView();
        onAttachView();
        tampilDataDetail();

        return view;
    }

    private void initView() {
        tvKodeSuratSkck = view.findViewById(R.id.tv_detail_surat_pengantar_skck_kode);
        tvNomorSuratSkck = view.findViewById(R.id.tv_detail_surat_pengantar_skck_nomor_surat);
        tvStatusPersetujuanSuratSkck = view.findViewById(R.id.tv_detail_surat_pengantar_skck_status_persetujuan);
        tvTanggalSurat = view.findViewById(R.id.tv_detail_surat_pengantar_skck_tgl_surat);
        tvNamaPengaju = view.findViewById(R.id.tv_detail_surat_pengantar_skck_nama_pengaju);
        tvNikPengaju = view.findViewById(R.id.tv_detail_surat_pengantar_skck_nik_pengaju);
        tvPejabat = view.findViewById(R.id.tv_detail_surat_pengantar_skck_nama_pejabat);

        btnSetujuiSuratSkck = view.findViewById(R.id.btn_detail_surat_pengantar_skck_setujui);
        btnSetujuiSuratSkck.setOnClickListener(this);

        btnBatalSetujuiSuratSkck = view.findViewById(R.id.btn_detail_surat_pengantar_skck_batalkan_persetujuan);
        btnBatalSetujuiSuratSkck.setOnClickListener(this);
    }

    private void initPresenter() {
        presenter = new DetailSuratSkckPresenter();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void tampilDataDetail() {
        bundle = this.getArguments();
        suratSkckData = bundle.getParcelable(EXTRA_SURAT_SKCK);

        tvKodeSuratSkck.setText(suratSkckData.getKd_surat());
        tvNomorSuratSkck.setText(suratSkckData.getNo_surat());
        tvStatusPersetujuanSuratSkck.setText(suratSkckData.getStatus_persetujuan());
        tvTanggalSurat.setText(suratSkckData.getTgl_surat());
        tvNamaPengaju.setText(suratSkckData.getNama_depan() + " " + suratSkckData.getNama_belakang());
        tvNikPengaju.setText(suratSkckData.getNik());
        tvPejabat.setText(suratSkckData.getNama_depan_user() + " " + suratSkckData.getNama_belakang_user());

        if(suratSkckData.getStatus_persetujuan().equals("Disetujui")){
            tvStatusPersetujuanSuratSkck.setTextColor(Color.parseColor("#008000"));
        }else if(suratSkckData.getStatus_persetujuan().equals("Belum disetujui")){
            tvStatusPersetujuanSuratSkck.setTextColor(Color.parseColor("#ff0000"));

        }

    }

    @Override
    public void onShowData(SuratSkckData suratSkckData) {

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
            case R.id.btn_detail_surat_pengantar_skck_setujui:
                presenter.putStatusPersetujuan(suratSkckData.getKd_surat(), "Disetujui");
                SuratSkckFragment.mBundleRecyclerViewState = null;
                try {
                    Thread.sleep(500);
                    getFragmentManager().popBackStack();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_detail_surat_pengantar_skck_batalkan_persetujuan:
                presenter.putStatusPersetujuan(suratSkckData.getKd_surat(), "Belum disetujui");
                SuratSkckFragment.mBundleRecyclerViewState = null;
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
