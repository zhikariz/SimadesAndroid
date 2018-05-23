package com.codelab.helmi.simades.profil;


import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.codelab.helmi.simades.R;
import com.codelab.helmi.simades.api.RestServer;


public class ShowProfilActivity extends Fragment implements ProfilView {

    ProfilPresenter presenter;
    EditText kode_desa, nm_desa, kecamatan, kabupaten, provinsi, nm_kepdes, nip_kepdes, alamat_desa, no_telp, kode_pos;
    ImageView image;
    Button btnEditProfilDesa;
    View view;
    FragmentManager fragmentManager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.fragment_profil_desa, container, false);

        initPresenter();

        initView();
        btnListener();
        onAttachView();

        getActivity().setTitle("Profil Desa");


        return view;


    }

    private void btnListener() {
        btnEditProfilDesa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.frame_container, new EditProfilFragment())
                        .addToBackStack(null)
                        .commit();

            }
        });
    }


    private void initPresenter() {
        presenter = new ProfilPresenter();

    }


    public void initView() {
        kode_desa = view.findViewById(R.id.edtIdDesa);
        nm_desa = view.findViewById(R.id.edtNamaDesa);
        kecamatan = view.findViewById(R.id.edtKecamatan);
        kabupaten = view.findViewById(R.id.edtKabupaten);
        provinsi = view.findViewById(R.id.edtProvinsi);
        nm_kepdes = view.findViewById(R.id.edtNamaKepdes);
        nip_kepdes = view.findViewById(R.id.edtNipKades);
        alamat_desa = view.findViewById(R.id.edtAlamat);
        no_telp = view.findViewById(R.id.edtNoTelp);
        kode_pos = view.findViewById(R.id.edtKodePos);
        image = view.findViewById(R.id.ivGambar);
        btnEditProfilDesa = view.findViewById(R.id.btnEditProfilDesa);
    }

    @Override
    public void onAttachView() {
        presenter.onAttach(this);
        presenter.showData();
    }

    @Override
    public void onShowData(ProfilData profilData) {
        RestServer api = new RestServer();
        kode_desa.setText(profilData.getKode_desa());
        nm_desa.setText(profilData.getNm_desa());
        kecamatan.setText(profilData.getKecamatan());
        kabupaten.setText(profilData.getKabupaten());
        provinsi.setText(profilData.getPropinsi());
        nm_kepdes.setText(profilData.getNm_kepdes());
        nip_kepdes.setText(profilData.getNip_kepdes());
        alamat_desa.setText(profilData.getAlamat_desa());
        no_telp.setText(profilData.getNo_telp());
        kode_pos.setText(profilData.getKode_pos());
        Glide.with(this).load(api.getBase_url() + "uploads/image/" + profilData.getImage()).into(image);


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
