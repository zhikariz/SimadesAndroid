package com.codelab.helmi.simades.surat.kelahiran.detail;


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
import com.codelab.helmi.simades.surat.kelahiran.SuratKelahiranData;
import com.codelab.helmi.simades.surat.kelahiran.SuratKelahiranFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailSuratKelahiranFragment extends Fragment implements DetailSuratKelahiranView, View.OnClickListener {

    public static String EXTRA_SURAT_KELAHIRAN = "extra_surat_kelahiran";
    View view;
    DetailSuratKelahiranPresenter presenter;
    Bundle bundle;
    TextView tvKodeSuratKelahiran, tvNomorSuratKelahiran, tvStatusPersetujuanSuratKelahiran, tvTanggalSurat, tvNikPengaju, tvNamaPengaju, tvPejabat;

    Button btnSetujuiSuratKelahiran, btnBatalSetujuiSuratKelahiran;
    SuratKelahiranData suratKelahiranData;

    public DetailSuratKelahiranFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_detail_surat_kelahiran, container, false);
        initPresenter();
        initView();
        onAttachView();
        tampilDataDetail();


        return view;
    }

    private void initView() {
        tvKodeSuratKelahiran = view.findViewById(R.id.tv_detail_surat_kelahiran_kode);
        tvNomorSuratKelahiran = view.findViewById(R.id.tv_detail_surat_kelahiran_nomor_surat);
        tvStatusPersetujuanSuratKelahiran = view.findViewById(R.id.tv_detail_surat_kelahiran_status_persetujuan);
        tvTanggalSurat = view.findViewById(R.id.tv_detail_surat_kelahiran_tgl_surat);
        tvNamaPengaju = view.findViewById(R.id.tv_detail_surat_kelahiran_nama_pengaju);
        tvNikPengaju = view.findViewById(R.id.tv_detail_surat_kelahiran_nik_pengaju);
        tvPejabat = view.findViewById(R.id.tv_detail_surat_kelahiran_nama_pejabat);

        btnSetujuiSuratKelahiran = view.findViewById(R.id.btn_detail_surat_kelahiran_setujui);
        btnSetujuiSuratKelahiran.setOnClickListener(this);
        btnBatalSetujuiSuratKelahiran = view.findViewById(R.id.btn_detail_surat_kelahiran_batalkan_persetujuan);
        btnBatalSetujuiSuratKelahiran.setOnClickListener(this);

    }

    private void initPresenter() {
        presenter = new DetailSuratKelahiranPresenter();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void tampilDataDetail() {
        bundle = this.getArguments();
        suratKelahiranData = bundle.getParcelable(EXTRA_SURAT_KELAHIRAN);

        tvKodeSuratKelahiran.setText(suratKelahiranData.getKd_surat());
        tvNomorSuratKelahiran.setText(suratKelahiranData.getNo_surat());
        tvStatusPersetujuanSuratKelahiran.setText(suratKelahiranData.getStatus_persetujuan());
        tvTanggalSurat.setText(suratKelahiranData.getTgl_surat());
        tvNamaPengaju.setText(suratKelahiranData.getNama_depan() + " " + suratKelahiranData.getNama_belakang());
        tvNikPengaju.setText(suratKelahiranData.getNik());
        tvPejabat.setText(suratKelahiranData.getNama_depan_user() + " " + suratKelahiranData.getNama_belakang_user());

        if (suratKelahiranData.getStatus_persetujuan().equals("Disetujui")) {
            tvStatusPersetujuanSuratKelahiran.setTextColor(Color.parseColor("#008000"));
        } else if (suratKelahiranData.getStatus_persetujuan().equals("Belum disetujui")) {
            tvStatusPersetujuanSuratKelahiran.setTextColor(Color.parseColor("#ff0000"));
        }
    }

    @Override
    public void onShowData(SuratKelahiranData suratKelahiranData) {

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
        switch (v.getId()) {
            case R.id.btn_detail_surat_kelahiran_setujui:
                presenter.putStatusPersetujuan(suratKelahiranData.getKd_surat(), "Disetujui");
                SuratKelahiranFragment.mBundleRecyclerViewState = null;
                try {
                    Thread.sleep(500);
                    getFragmentManager().popBackStack();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                break;
            case R.id.btn_detail_surat_kelahiran_batalkan_persetujuan:
                presenter.putStatusPersetujuan(suratKelahiranData.getKd_surat(), "Belum disetujui");
                SuratKelahiranFragment.mBundleRecyclerViewState = null;
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
