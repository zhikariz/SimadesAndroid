package com.codelab.helmi.simades.surat.kematian.detail;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.codelab.helmi.simades.R;
import com.codelab.helmi.simades.surat.kematian.SuratKematianData;
import com.codelab.helmi.simades.surat.kematian.SuratKematianFragment;
import com.codelab.helmi.simades.surat.usaha.SuratUsahaFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailSuratKematianFragment extends Fragment implements DetailSuratKematianView, View.OnClickListener {

    public static String EXTRA_SURAT_KEMATIAN = "extra_surat_kematian";
    View view;
    DetailSuratKematianPresenter presenter;
    Bundle bundle;
    SuratKematianData suratKematianData;
    TextView tvKodeSuratKematian, tvNomorSuratKematian,tvStatusPersetujuanSuratKematian,tvTanggalSurat, tvNikPengaju, tvNamaPengaju, tvPejabat;
    Button btnSetujuiSuratKematian, btnBatalSetujuiSuratKematian;

    public DetailSuratKematianFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_detail_surat_kematian, container, false);
        initPresenter();
        initView();
        onAttachView();
        tampilDataDetail();

        return view;
    }

    private void initView() {
        tvKodeSuratKematian = view.findViewById(R.id.tv_detail_surat_kematian_kode);
        tvNomorSuratKematian = view.findViewById(R.id.tv_detail_surat_kematian_nomor_surat);
        tvStatusPersetujuanSuratKematian = view.findViewById(R.id.tv_detail_surat_kematian_status_persetujuan);
        tvTanggalSurat = view.findViewById(R.id.tv_detail_surat_kematian_tgl_surat);
        tvNamaPengaju = view.findViewById(R.id.tv_detail_surat_kematian_nama_pengaju);
        tvNikPengaju = view.findViewById(R.id.tv_detail_surat_kematian_nik_pengaju);
        tvPejabat = view.findViewById(R.id.tv_detail_surat_kematian_nama_pejabat);

        btnSetujuiSuratKematian = view.findViewById(R.id.btn_detail_surat_kematian_setujui);
        btnSetujuiSuratKematian.setOnClickListener(this);

        btnBatalSetujuiSuratKematian = view.findViewById(R.id.btn_detail_surat_kematian_batalkan_persetujuan);
        btnBatalSetujuiSuratKematian.setOnClickListener(this);

    }

    private void initPresenter() {
        presenter = new DetailSuratKematianPresenter();
    }

    @Override
    public void tampilDataDetail() {
        bundle = this.getArguments();
        suratKematianData = bundle.getParcelable(EXTRA_SURAT_KEMATIAN);

        tvKodeSuratKematian.setText(suratKematianData.getKd_surat());
        tvNomorSuratKematian.setText(suratKematianData.getNo_surat());
        tvStatusPersetujuanSuratKematian.setText(suratKematianData.getStatus_persetujuan());
        tvTanggalSurat.setText(suratKematianData.getTgl_surat());
        tvNamaPengaju.setText(suratKematianData.getNama_depan_pengaju() + suratKematianData.getNama_belakang_pengaju());
        tvNikPengaju.setText(suratKematianData.getNik());
        tvPejabat.setText(suratKematianData.getNama_depan_user() + suratKematianData.getNama_belakang_user());

        if(suratKematianData.getStatus_persetujuan().equals("Disetujui")){
            tvStatusPersetujuanSuratKematian.setTextColor(Color.parseColor("#008000"));
        }else if(suratKematianData.getStatus_persetujuan().equals("Belum disetujui")){
            tvStatusPersetujuanSuratKematian.setTextColor(Color.parseColor("#ff0000"));
        }


    }

    @Override
    public void onShowData(SuratKematianData suratKematianData) {

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
            case R.id.btn_detail_surat_kematian_setujui:
                presenter.putStatusPersetujuan(suratKematianData.getKd_surat(), "Disetujui");
                SuratKematianFragment.mBundleRecyclerViewState = null;
                try {
                    Thread.sleep(500);
                    getFragmentManager().popBackStack();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_detail_surat_kematian_batalkan_persetujuan:
                presenter.putStatusPersetujuan(suratKematianData.getKd_surat(), "Belum disetujui");
                SuratKematianFragment.mBundleRecyclerViewState = null;
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
