package com.codelab.helmi.simades.surat.domisili.detail;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.codelab.helmi.simades.R;
import com.codelab.helmi.simades.surat.domisili.SuratDomisiliData;
import com.codelab.helmi.simades.surat.domisili.SuratDomisiliFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailSuratDomisiliFragment extends Fragment implements DetailSuratDomisiliView, View.OnClickListener {

    public static String EXTRA_SURAT_DOMISILI = "extra_surat_domisili";
    View view;
    DetailSuratDomisiliPresenter presenter;
    TextView tvKodeSuratDomisili, tvNomorSuratDomisili, tvStatusPersetujuanSuratDomisili, tvTanggalSurat, tvNamaPengaju, tvNikPengaju, tvNamaPejabat;
    Button btnSetujuiSuratDomisili, btnBatalSetujuiSuratDomisili;
    SuratDomisiliData suratDomisiliData;
    Bundle bundle;

    public DetailSuratDomisiliFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_detail_surat_domisili, container, false);
        initPresenter();
        initView();
        onAttachView();
        tampilDataDetail();
        return view;
    }

    private void initView() {
        tvKodeSuratDomisili = view.findViewById(R.id.tv_detail_surat_domisili_kode);
        tvNomorSuratDomisili = view.findViewById(R.id.tv_detail_surat_domisili_nomor_surat);
        tvStatusPersetujuanSuratDomisili = view.findViewById(R.id.tv_detail_surat_domisili_status_persetujuan);
        tvTanggalSurat = view.findViewById(R.id.tv_detail_surat_domisili_tgl_surat);
        tvNamaPengaju = view.findViewById(R.id.tv_detail_surat_domisili_nama_pengaju);
        tvNikPengaju = view.findViewById(R.id.tv_detail_surat_domisili_nik_pengaju);
        tvNamaPejabat = view.findViewById(R.id.tv_detail_surat_domisili_nama_pejabat);

        btnSetujuiSuratDomisili = view.findViewById(R.id.btn_detail_surat_domisili_setujui);
        btnSetujuiSuratDomisili.setOnClickListener(this);
        btnBatalSetujuiSuratDomisili = view.findViewById(R.id.btn_detail_surat_domisili_batalkan_persetujuan);
        btnBatalSetujuiSuratDomisili.setOnClickListener(this);

    }

    private void initPresenter() {
        presenter = new DetailSuratDomisiliPresenter();

    }

    @Override
    public void onShowData(SuratDomisiliData suratDomisiliData) {

    }

    @Override
    public void tampilDataDetail() {
        bundle = this.getArguments();
        suratDomisiliData  = bundle.getParcelable(EXTRA_SURAT_DOMISILI);

        tvKodeSuratDomisili.setText(suratDomisiliData.getKd_surat());
        tvNomorSuratDomisili.setText(suratDomisiliData.getNo_surat());
        tvStatusPersetujuanSuratDomisili.setText(suratDomisiliData.getStatus_persetujuan());
        tvTanggalSurat.setText(suratDomisiliData.getTgl_surat());
        tvNamaPengaju.setText(suratDomisiliData.getNama_depan() + " " + suratDomisiliData.getNama_belakang());
        tvNikPengaju.setText(suratDomisiliData.getNik());
        tvNamaPejabat.setText(suratDomisiliData.getNama_depan_user() + " " + suratDomisiliData.getNama_belakang_user());

        if(suratDomisiliData.getStatus_persetujuan().equals("Disetujui")){
            tvStatusPersetujuanSuratDomisili.setTextColor(Color.parseColor("#008000"));
            btnBatalSetujuiSuratDomisili.setVisibility(View.VISIBLE);
            btnSetujuiSuratDomisili.setVisibility(View.GONE);

        }else if(suratDomisiliData.getStatus_persetujuan().equals("Belum disetujui")){
            tvStatusPersetujuanSuratDomisili.setTextColor(Color.parseColor("#ff0000"));
            btnBatalSetujuiSuratDomisili.setVisibility(View.GONE);
            btnSetujuiSuratDomisili.setVisibility(View.VISIBLE);

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
            case R.id.btn_detail_surat_domisili_setujui:
                presenter.putStatusPersetujuan(suratDomisiliData.getKd_surat(), "Disetujui");
                SuratDomisiliFragment.mBundleRecyclerViewState = null;
                try {
                    Thread.sleep(500);
                    getFragmentManager().popBackStack();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_detail_surat_domisili_batalkan_persetujuan:
                presenter.putStatusPersetujuan(suratDomisiliData.getKd_surat(), "Belum disetujui");
                SuratDomisiliFragment.mBundleRecyclerViewState = null;
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
