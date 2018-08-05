package com.codelab.helmi.simades.profil;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codelab.helmi.simades.R;
import com.codelab.helmi.simades.helper.api.RestServer;

import java.util.List;


public class ShowProfilActivity extends Fragment implements ProfilView {

    ProfilPresenter presenter;
    TextView tvKabupaten, tvKecamatan, tvDesa, tvAlamat, tvNamaKepdes, tvNipKepdes;
    ImageView image;
    View view;
    FragmentManager fragmentManager;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.fragment_profil_desa, container, false);
        initPresenter();
        initView();
        onAttachView();
        presenter.showData(getActivity());
        getActivity().setTitle("Profil Desa");
        return view;


    }


    private void initPresenter() {
        presenter = new ProfilPresenter();
    }


    public void initView() {
        tvKabupaten = view.findViewById(R.id.tv_kabupaten);
        tvKecamatan = view.findViewById(R.id.tv_kecamatan);
        tvDesa = view.findViewById(R.id.tv_desa);
        tvAlamat = view.findViewById(R.id.tv_alamat);
        tvNipKepdes = view.findViewById(R.id.tv_nip_kepala_desa);
        tvNamaKepdes = view.findViewById(R.id.tv_nama_kepala_desa);
        image = view.findViewById(R.id.ivGambar);
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

    @SuppressLint("SetTextI18n")
    @Override
    public void onShowData(List<ProfilData> profilData) {
        Glide.with(this).load(RestServer.getBase_url() + "uploads/image/" + profilData.get(0).getImage()).into(image);
        tvKabupaten.setText("Pemerintah Kabupaten "+profilData.get(0).getKabupaten());
        tvKecamatan.setText("Kecamatan "+profilData.get(0).getKecamatan());
        tvDesa.setText("Desa "+profilData.get(0).getNm_desa());
        tvAlamat.setText(profilData.get(0).getAlamat_desa() + " Telp. "+profilData.get(0).getNo_telp()+" Kode Pos "+profilData.get(0).getKode_pos());
        tvNipKepdes.setText("Nip Kepala Desa : "+profilData.get(0).getNip_kepdes());
        tvNamaKepdes.setText("Nama Kepala Desa : "+profilData.get(0).getNm_kepdes());
    }
}
