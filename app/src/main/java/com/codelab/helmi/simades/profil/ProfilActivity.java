package com.codelab.helmi.simades.profil;


import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.codelab.helmi.simades.R;
import com.codelab.helmi.simades.api.RestApi;
import com.codelab.helmi.simades.api.RestServer;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ProfilActivity extends Fragment implements ProfilView {

    ProfilPresenter presenter;
    EditText kode_desa, nm_desa, kecamatan, kabupaten, provinsi, nm_kepdes, nip_kepdes, alamat_desa, no_telp, kode_pos;
    ImageView image;
    View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.profil_desa, container, false);

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
        Picasso.get().load(api.getBase_url()+"/uploads/image/"+profilData.getImage()).into(image);
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
