package com.codelab.helmi.simades.surat.usaha.detail;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.codelab.helmi.simades.R;
import com.codelab.helmi.simades.surat.usaha.SuratUsahaData;
import com.codelab.helmi.simades.surat.usaha.SuratUsahaFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailSuratUsahaFragment extends Fragment implements DetailSuratUsahaView, View.OnClickListener {

    View view;
    DetailSuratUsahaPresenter presenter;
    Bundle bundle;
    public static String EXTRA_SURAT_USAHA = "extra_surat_usaha";
    Button btnSetujuiSuratUsaha, btnBatalSetujuiSuratUsaha;
    TextView tvKodeSuratUsaha, tvNomorSuratUsaha, tvStatusPersetujuanSuratUsaha, tvTanggalSurat, tvNikPengaju, tvPengaju, tvPejabat, tvNamaUsaha, tvKeperluan, tvTanggalAkhir, tvTanggalMulai;
    SuratUsahaData suratUsahaData;


    public DetailSuratUsahaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_detail_surat_usaha, container, false);
        initPresenter();
        initView();
        onAttachView();
        tampilDataDetail();

        return view;
    }

    private void initView() {
        tvKodeSuratUsaha = view.findViewById(R.id.tv_detail_surat_usaha_kode);
        tvNomorSuratUsaha = view.findViewById(R.id.tv_detail_surat_usaha_nomor_surat);
        tvStatusPersetujuanSuratUsaha = view.findViewById(R.id.tv_detail_surat_usaha_status_persetujuan);
        tvTanggalSurat = view.findViewById(R.id.tv_detail_surat_usaha_tgl_surat);
        tvPengaju = view.findViewById(R.id.tv_detail_surat_usaha_nama_pengaju);
        tvNikPengaju = view.findViewById(R.id.tv_detail_surat_usaha_nik_pengaju);
        tvPejabat = view.findViewById(R.id.tv_detail_surat_usaha_nama_pejabat);
        tvNamaUsaha = view.findViewById(R.id.tv_detail_surat_usaha_nama_usaha);
        tvKeperluan = view.findViewById(R.id.tv_detail_surat_usaha_keperluan);
        tvTanggalMulai = view.findViewById(R.id.tv_detail_surat_usaha_tgl_mulai);
        tvTanggalAkhir = view.findViewById(R.id.tv_detail_surat_usaha_tgl_akhir);

        btnSetujuiSuratUsaha = view.findViewById(R.id.btn_detail_surat_usaha_setujui);
        btnSetujuiSuratUsaha.setOnClickListener(this);
        btnBatalSetujuiSuratUsaha = view.findViewById(R.id.btn_detail_surat_usaha_batalkan_persetujuan);
        btnBatalSetujuiSuratUsaha.setOnClickListener(this);



    }

    private void initPresenter() {
        presenter = new DetailSuratUsahaPresenter();
    }

    @Override
    public void tampilDataDetail() {
        bundle = this.getArguments();
        suratUsahaData = bundle.getParcelable(EXTRA_SURAT_USAHA);

        tvKodeSuratUsaha.setText(suratUsahaData.getKd_surat());
        tvNomorSuratUsaha.setText(suratUsahaData.getNo_surat());
        tvStatusPersetujuanSuratUsaha.setText(suratUsahaData.getStatus_persetujuan());
        tvTanggalSurat.setText(suratUsahaData.getTgl_surat());
        tvPengaju.setText(suratUsahaData.getNama_depan() +" "+ suratUsahaData.getNama_belakang());
        tvNikPengaju.setText(suratUsahaData.getNik());
        tvPejabat.setText(suratUsahaData.getNama_depan_user() +" "+ suratUsahaData.getNama_belakang_user());
        tvNamaUsaha.setText(suratUsahaData.getNama_usaha());
        tvKeperluan.setText(suratUsahaData.getKeperluan());
        tvTanggalMulai.setText(suratUsahaData.getTgl_mulai());
        tvTanggalAkhir.setText(suratUsahaData.getTgl_akhir());

        if(suratUsahaData.getStatus_persetujuan().equals("Disetujui")){
            tvStatusPersetujuanSuratUsaha.setTextColor(Color.parseColor("#008000"));
        }else if(suratUsahaData.getStatus_persetujuan().equals("Belum disetujui")){
            tvStatusPersetujuanSuratUsaha.setTextColor(Color.parseColor("#ff0000"));
        }


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
            case R.id.btn_detail_surat_usaha_setujui:
                presenter.putStatusPersetujuan(suratUsahaData.getKd_surat(), "Disetujui");
                SuratUsahaFragment.mBundleRecyclerViewState = null;
                try {
                    Thread.sleep(500);
                    getFragmentManager().popBackStack();
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
            case R.id.btn_detail_surat_usaha_batalkan_persetujuan:
                presenter.putStatusPersetujuan(suratUsahaData.getKd_surat(), "Belum disetujui");
                SuratUsahaFragment.mBundleRecyclerViewState = null;
                try {
                    Thread.sleep(500);
                    getFragmentManager().popBackStack();
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
        }

    }
}
