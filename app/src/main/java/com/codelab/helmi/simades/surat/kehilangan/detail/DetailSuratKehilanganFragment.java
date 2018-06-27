package com.codelab.helmi.simades.surat.kehilangan.detail;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.codelab.helmi.simades.R;
import com.codelab.helmi.simades.surat.kehilangan.SuratKehilanganData;
import com.codelab.helmi.simades.surat.kehilangan.SuratKehilanganFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailSuratKehilanganFragment extends Fragment implements DetailSuratKehilanganView, View.OnClickListener {

    public static String EXTRA_SURAT_KEHILANGAN = "extra_surat_kehilangan";
    View view;
    DetailSuratKehilanganPresenter presenter;
    Bundle bundle;
    TextView tvkodeSuratkehilangan, tvNomorSuratKehilangan, tvStatusPersetujuanSuratKehilangan,tvTanggalSurat, tvNamaPengaju, tvNikPengaju, tvNamaPejabat;
    Button btnSetujuiSuratKehilangan, btnBatalSetujuiSuratKehilangan;
    SuratKehilanganData suratKehilanganData;

    public DetailSuratKehilanganFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_detail_surat_kehilangan, container, false);
        initPresenter();
        initView();
        onAttachView();
        tampilDataDetail();
        return view;
    }

    private void initView() {
        tvkodeSuratkehilangan = view.findViewById(R.id.tv_detail_surat_kehilangan_kode);
        tvNomorSuratKehilangan  = view.findViewById(R.id.tv_detail_surat_kehilangan_nomor_surat);
        tvStatusPersetujuanSuratKehilangan = view.findViewById(R.id.tv_detail_surat_kehilangan_status_persetujuan);
        tvTanggalSurat = view.findViewById(R.id.tv_detail_surat_kehilangan_tgl_surat);
        tvNamaPengaju = view.findViewById(R.id.tv_detail_surat_kehilangan_nama_pengaju);
        tvNikPengaju = view.findViewById(R.id.tv_detail_surat_kehilangan_nik_pengaju);
        tvNamaPejabat = view.findViewById(R.id.tv_detail_surat_kehilangan_nama_pejabat);

        btnSetujuiSuratKehilangan = view.findViewById(R.id.btn_detail_surat_kehilangan_setujui);
        btnSetujuiSuratKehilangan.setOnClickListener(this);
        btnBatalSetujuiSuratKehilangan = view.findViewById(R.id.btn_detail_surat_kehilangan_batalkan_persetujuan);
        btnBatalSetujuiSuratKehilangan.setOnClickListener(this);
    }

    private void initPresenter() {
        presenter = new DetailSuratKehilanganPresenter();

    }

    @Override
    public void tampilDataDetail() {
        bundle = this.getArguments();
        suratKehilanganData = bundle.getParcelable(EXTRA_SURAT_KEHILANGAN);

        tvkodeSuratkehilangan.setText(suratKehilanganData.getKd_surat());
        tvNomorSuratKehilangan.setText(suratKehilanganData.getNo_surat());
        tvStatusPersetujuanSuratKehilangan.setText(suratKehilanganData.getStatus_persetujuan());
        tvTanggalSurat.setText(suratKehilanganData.getTgl_surat());
        tvNamaPengaju.setText(suratKehilanganData.getNama_depan() + " " + suratKehilanganData.getNama_belakang());
        tvNikPengaju.setText(suratKehilanganData.getNik());
        tvNamaPejabat.setText(suratKehilanganData.getNama_depan_user() + " " + suratKehilanganData.getNama_belakang_user());

        if(suratKehilanganData.getStatus_persetujuan().equals("Disetujui")){
            tvStatusPersetujuanSuratKehilangan.setTextColor(Color.parseColor("#008000"));
            btnBatalSetujuiSuratKehilangan.setVisibility(View.VISIBLE);
            btnSetujuiSuratKehilangan.setVisibility(View.GONE);
        } else if(suratKehilanganData.getStatus_persetujuan().equals("Belum disetujui")){
            tvStatusPersetujuanSuratKehilangan.setTextColor(Color.parseColor("#ff0000"));
            btnBatalSetujuiSuratKehilangan.setVisibility(View.GONE);
            btnSetujuiSuratKehilangan.setVisibility(View.VISIBLE);

        }


    }

    @Override
    public void onShowData(SuratKehilanganData suratKehilanganData) {

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
            case R.id.btn_detail_surat_kehilangan_setujui:
                presenter.putStatusPersetujuan(suratKehilanganData.getKd_surat(), "Disetujui");
                SuratKehilanganFragment.mBundleRecyclerViewState = null;
                try {
                    Thread.sleep(500);
                    getFragmentManager().popBackStack();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_detail_surat_kehilangan_batalkan_persetujuan:
                presenter.putStatusPersetujuan(suratKehilanganData.getKd_surat(), "Belum disetujui");
                SuratKehilanganFragment.mBundleRecyclerViewState = null;
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
