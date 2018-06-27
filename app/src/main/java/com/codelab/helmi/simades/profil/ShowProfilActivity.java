package com.codelab.helmi.simades.profil;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codelab.helmi.simades.R;
import com.codelab.helmi.simades.api.RestServer;


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
        presenter.showData(getActivity().getApplicationContext());
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onShowData(ProfilData profilData) {
        Glide.with(view.getContext()).load(RestServer.getBase_url() + "uploads/image/" + profilData.getImage()).into(image);
        tvKabupaten.setText("Pemerintah Kabupaten "+profilData.getKabupaten());
        tvKecamatan.setText("Kecamatan "+profilData.getKecamatan());
        tvDesa.setText("Desa "+profilData.getNm_desa());
        tvAlamat.setText(profilData.getAlamat_desa() + " Telp. "+profilData.getNo_telp()+" Kode Pos "+profilData.getKode_pos());
        tvNipKepdes.setText("Nip Kepala Desa : "+profilData.getNip_kepdes());
        tvNamaKepdes.setText("Nama Kepala Desa : "+profilData.getNm_kepdes());


    }

    @Override
    public void onEditData(ProfilData profilData) {

    }


    @Override
    public void onDetachView() {
        presenter.onDetach();
    }

    @Override
    public void onDestroy() {
        onDetachView();
        super.onDestroy();
    }
}
