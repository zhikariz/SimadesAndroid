package com.codelab.helmi.simades.surat.ektp.detail;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.codelab.helmi.simades.R;
import com.codelab.helmi.simades.surat.ektp.SuratEktpData;
import com.codelab.helmi.simades.surat.ektp.SuratEktpFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailSuratEktpFragment extends Fragment  implements  DetailSuratEktpView, View.OnClickListener {

    public static String EXTRA_SURAT_PENGANTAR_EKTP = "extra_surat_pengantar_ektp";
    View view;
    DetailSuratEktpPresenter presenter;
    Bundle bundle;
    TextView tvKodeSuratPengantarEktp, tvNomorSuratPengantarEktp, tvStatusPersetujuanSuratPengantarEktp, tvTanggalSurat, tvNikPengaju, tvNamaPengaju, tvNamaPejabat;
    Button btnSetujuiSuratPengantarEktp, btnBatalSetujuiSuratPengantarEktp;
    SuratEktpData suratEktpData;

    public DetailSuratEktpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_detail_surat_ektp, container, false);
        initPresenter();
        initView();
        onAttachView();
        tampilDataDetail();

        return view;
    }

    private void initView() {
        tvKodeSuratPengantarEktp = view.findViewById(R.id.tv_detail_surat_pengantar_ektp_kode);
        tvNomorSuratPengantarEktp = view.findViewById(R.id.tv_detail_surat_pengantar_ektp_nomor_surat);
        tvStatusPersetujuanSuratPengantarEktp = view.findViewById(R.id.tv_detail_surat_pengantar_ektp_status_persetujuan);
        tvTanggalSurat = view.findViewById(R.id.tv_detail_surat_pengantar_ektp_tgl_surat);
        tvNamaPengaju = view.findViewById(R.id.tv_detail_surat_pengantar_ektp_nama_pengaju);
        tvNikPengaju = view.findViewById(R.id.tv_detail_surat_pengantar_ektp_nik_pengaju);
        tvNamaPejabat = view.findViewById(R.id.tv_detail_surat_pengantar_ektp_nama_pejabat);

        btnSetujuiSuratPengantarEktp = view.findViewById(R.id.btn_detail_surat_pengantar_ektp_setujui);
        btnSetujuiSuratPengantarEktp.setOnClickListener(this);
        btnBatalSetujuiSuratPengantarEktp  = view.findViewById(R.id.btn_detail_surat_pengantar_ektp_batalkan_persetujuan);
        btnBatalSetujuiSuratPengantarEktp.setOnClickListener(this);
    }

    private void initPresenter() {
        presenter = new DetailSuratEktpPresenter();

    }

    @Override
    public void tampilDataDetail() {
        bundle = this.getArguments();
        suratEktpData = bundle.getParcelable(EXTRA_SURAT_PENGANTAR_EKTP);

        tvKodeSuratPengantarEktp.setText(suratEktpData.getKd_surat());
        tvNomorSuratPengantarEktp.setText(suratEktpData.getNo_surat());
        tvStatusPersetujuanSuratPengantarEktp.setText(suratEktpData.getStatus_persetujuan());
        tvTanggalSurat.setText(suratEktpData.getTgl_surat());
        tvNamaPengaju.setText(suratEktpData.getNama_depan() + " " + suratEktpData.getNama_belakang());
        tvNikPengaju.setText(suratEktpData.getNik());
        tvNamaPejabat.setText(suratEktpData.getNama_depan_user() + " " + suratEktpData.getNama_belakang_user());

        if(suratEktpData.getStatus_persetujuan().equals("Disetujui")){
            tvStatusPersetujuanSuratPengantarEktp.setTextColor(Color.parseColor("#008000"));
            btnBatalSetujuiSuratPengantarEktp.setVisibility(View.VISIBLE);
            btnSetujuiSuratPengantarEktp.setVisibility(View.GONE);
        } else if(suratEktpData.getStatus_persetujuan().equals("Belum disetujui")){
            tvStatusPersetujuanSuratPengantarEktp.setTextColor(Color.parseColor("#ff0000"));
            btnBatalSetujuiSuratPengantarEktp.setVisibility(View.GONE);
            btnSetujuiSuratPengantarEktp.setVisibility(View.VISIBLE);

        }

    }

    @Override
    public void onShowData(SuratEktpData suratEktpData) {

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
            case R.id.btn_detail_surat_pengantar_ektp_setujui:
                presenter.putStatusPersetujuan(suratEktpData.getKd_surat(), "Disetujui");
                SuratEktpFragment.mBundleRecyclerViewState = null;
                try {
                    Thread.sleep(500);
                    getFragmentManager().popBackStack();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_detail_surat_pengantar_ektp_batalkan_persetujuan:
                presenter.putStatusPersetujuan(suratEktpData.getKd_surat(), "Belum disetujui");
                SuratEktpFragment.mBundleRecyclerViewState = null;
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
