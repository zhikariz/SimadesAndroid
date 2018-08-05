package com.codelab.helmi.simades.surat.tidak_mampu.detail;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.codelab.helmi.simades.R;
import com.codelab.helmi.simades.surat.tidak_mampu.SuratTidakMampuData;
import com.codelab.helmi.simades.surat.tidak_mampu.SuratTidakMampuFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailSuratTidakMampuFragment extends Fragment implements DetailSuratTidakMampuView, View.OnClickListener {

    public static String EXTRA_SURAT_TIDAK_MAMPU = "extra_surat_tidak_mampu";
    View view;
    DetailSuratTidakMampuPresenter presenter;
    Bundle bundle;
    TextView tvKodeSuratTidakMampu, tvNomorSuratTidakMampu, tvStatusPersetujuanSuratTidakMampu, tvTanggalSurat, tvNamaPengaju, tvNikPengaju, tvNamaPejabat;
    Button btnSetujuiSuratTidakMampu, btnBatalSetujuiSuratTidakMampu;
    SuratTidakMampuData suratTidakMampuData;

    public DetailSuratTidakMampuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_detail_surat_tidak_mampu, container, false);
        initPresenter();
        initView();
        onAttachView();
        tampilDataDetail();
        return view;
    }

    private void initView() {
        tvKodeSuratTidakMampu = view.findViewById(R.id.tv_detail_surat_tidak_mampu_kode);
        tvNomorSuratTidakMampu  = view.findViewById(R.id.tv_detail_surat_tidak_mampu_nomor_surat);
        tvStatusPersetujuanSuratTidakMampu = view.findViewById(R.id.tv_detail_surat_tidak_mampu_status_persetujuan);
        tvTanggalSurat = view.findViewById(R.id.tv_detail_surat_tidak_mampu_tgl_surat);
        tvNamaPengaju = view.findViewById(R.id.tv_detail_surat_tidak_mampu_nama_pengaju);
        tvNikPengaju = view.findViewById(R.id.tv_detail_surat_tidak_mampu_nik_pengaju);
        tvNamaPejabat = view.findViewById(R.id.tv_detail_surat_tidak_mampu_nama_pejabat);

        btnSetujuiSuratTidakMampu = view.findViewById(R.id.btn_detail_surat_tidak_mampu_setujui);
        btnSetujuiSuratTidakMampu.setOnClickListener(this);
        btnBatalSetujuiSuratTidakMampu = view.findViewById(R.id.btn_detail_surat_tidak_mampu_batalkan_persetujuan);
        btnBatalSetujuiSuratTidakMampu.setOnClickListener(this);
    }

    private void initPresenter() {
        presenter = new DetailSuratTidakMampuPresenter();
    }

    @Override
    public void tampilDataDetail() {
        bundle = this.getArguments();
        suratTidakMampuData = bundle.getParcelable(EXTRA_SURAT_TIDAK_MAMPU);

        tvKodeSuratTidakMampu.setText(suratTidakMampuData.getKd_surat());
        tvNomorSuratTidakMampu.setText(suratTidakMampuData.getNo_surat());
        tvStatusPersetujuanSuratTidakMampu.setText(suratTidakMampuData.getStatus_persetujuan());
        tvTanggalSurat.setText(suratTidakMampuData.getTgl_surat());
        tvNamaPengaju.setText(suratTidakMampuData.getNama_depan() + " " + suratTidakMampuData.getNama_belakang());
        tvNikPengaju.setText(suratTidakMampuData.getNik());
        tvNamaPejabat.setText(suratTidakMampuData.getNama_depan_user() + " " + suratTidakMampuData.getNama_belakang_user());

        if(suratTidakMampuData.getStatus_persetujuan().equals("Disetujui")){
            tvStatusPersetujuanSuratTidakMampu.setTextColor(Color.parseColor("#008000"));
        } else if(suratTidakMampuData.getStatus_persetujuan().equals("Belum disetujui")){
            tvStatusPersetujuanSuratTidakMampu.setTextColor(Color.parseColor("#ff0000"));

        }

    }

    @Override
    public void onShowData(SuratTidakMampuData suratTidakMampuData) {

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
            case R.id.btn_detail_surat_tidak_mampu_setujui:
                presenter.putStatusPersetujuan(suratTidakMampuData.getKd_surat(), "Disetujui");
                SuratTidakMampuFragment.mBundleRecyclerViewState = null;
                try {
                    Thread.sleep(500);
                    getFragmentManager().popBackStack();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_detail_surat_tidak_mampu_batalkan_persetujuan:
                presenter.putStatusPersetujuan(suratTidakMampuData.getKd_surat(), "Belum disetujui");
                SuratTidakMampuFragment.mBundleRecyclerViewState = null;
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
