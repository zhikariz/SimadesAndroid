package com.codelab.helmi.simades.surat.kelahiran;

import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.codelab.helmi.simades.R;
import com.codelab.helmi.simades.surat.kelahiran.detail.DetailSuratKelahiranFragment;

import java.util.List;

public class SuratKelahiranRecyclerAdapter extends RecyclerView.Adapter<SuratKelahiranRecyclerAdapter.MyHolder> {

    List<SuratKelahiranData> mList;
    Context ctx;
    FragmentManager fragmentManager;

    public SuratKelahiranRecyclerAdapter(Context ctx, List<SuratKelahiranData> mList, FragmentManager fragmentManager) {
        this.mList = mList;
        this.ctx = ctx;
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_surat_kelahiran, parent, false);
        MyHolder holder = new MyHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder holder, final int position) {
        holder.kode_surat.setText(mList.get(position).getKd_surat());
        holder.no_surat.setText(mList.get(position).getNo_surat());
        holder.tgl_surat.setText(mList.get(position).getTgl_surat());
        holder.status_persetujuan.setText(mList.get(position).getStatus_persetujuan());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailSuratKelahiranFragment detailSuratKelahiranFragment = new DetailSuratKelahiranFragment();
                SuratKelahiranData suratKelahiranData = new SuratKelahiranData();

                suratKelahiranData.setKd_surat(mList.get(position).getKd_surat());
                suratKelahiranData.setNo_surat(mList.get(position).getNo_surat());
                suratKelahiranData.setTgl_surat(mList.get(position).getTgl_surat());
                suratKelahiranData.setWaktu(mList.get(position).getWaktu());
                suratKelahiranData.setStatus_persetujuan(mList.get(position).getStatus_persetujuan());
                suratKelahiranData.setNik(mList.get(position).getNik());
                suratKelahiranData.setNik_ayah(mList.get(position).getNik_ayah());
                suratKelahiranData.setNik_ibu(mList.get(position).getNik_ibu());
                suratKelahiranData.setNama_saksi1(mList.get(position).getNama_saksi1());
                suratKelahiranData.setNama_saksi2(mList.get(position).getNama_saksi2());
                suratKelahiranData.setId_user_ttd(mList.get(position).getId_user_ttd());
                suratKelahiranData.setNo_kk(mList.get(position).getNo_kk());
                suratKelahiranData.setNama_depan(mList.get(position).getNama_depan());
                suratKelahiranData.setNama_belakang(mList.get(position).getNama_belakang());
                suratKelahiranData.setJekel(mList.get(position).getJekel());
                suratKelahiranData.setUmur(mList.get(position).getUmur());
                suratKelahiranData.setTempat_lhr(mList.get(position).getTempat_lhr());
                suratKelahiranData.setTanggal_lhr(mList.get(position).getTanggal_lhr());
                suratKelahiranData.setNama_ayah(mList.get(position).getNama_ayah());
                suratKelahiranData.setNama_ibu(mList.get(position).getNama_ibu());
                suratKelahiranData.setAnak_ke(mList.get(position).getAnak_ke());
                suratKelahiranData.setStatus(mList.get(position).getStatus());
                suratKelahiranData.setTgl_mutasi(mList.get(position).getTgl_mutasi());
                suratKelahiranData.setAgama(mList.get(position).getAgama());
                suratKelahiranData.setGoldar(mList.get(position).getGoldar());
                suratKelahiranData.setHubkel(mList.get(position).getHubkel());
                suratKelahiranData.setKerja(mList.get(position).getKerja());
                suratKelahiranData.setPendidikan(mList.get(position).getPendidikan());
                suratKelahiranData.setStkawin(mList.get(position).getStkawin());
                suratKelahiranData.setAlamat(mList.get(position).getAlamat());
                suratKelahiranData.setRt(mList.get(position).getRt());
                suratKelahiranData.setRw(mList.get(position).getRw());
                suratKelahiranData.setKelurahan(mList.get(position).getKelurahan());
                suratKelahiranData.setKecamatan(mList.get(position).getKecamatan());
                suratKelahiranData.setKabupaten(mList.get(position).getKabupaten());
                suratKelahiranData.setPropinsi(mList.get(position).getPropinsi());
                suratKelahiranData.setDusun(mList.get(position).getDusun());

                Bundle bundle = new Bundle();
                bundle.putParcelable(DetailSuratKelahiranFragment.EXTRA_SURAT_KELAHIRAN, suratKelahiranData);

                detailSuratKelahiranFragment.setArguments(bundle);
                fragmentManager.beginTransaction()
                        .replace(R.id.frame_container, detailSuratKelahiranFragment, detailSuratKelahiranFragment.getClass().getSimpleName())
                        .addToBackStack(null)
                        .commit();


                Toast.makeText(ctx, "" + holder.no_surat.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView id_surat, kode_surat, no_surat, jenis_surat;
        TextView tgl_surat, waktu, status_persetujuan;

        public MyHolder(View v) {
            super(v);

            kode_surat = v.findViewById(R.id.tv_kode_surat_kelahiran);
            no_surat = v.findViewById(R.id.tv_nomor_surat_kelahiran);
            tgl_surat = v.findViewById(R.id.tv_tanggal_surat_kelahiran);
            status_persetujuan = v.findViewById(R.id.tv_status_persetujauan_surat_kelahiran);

        }
    }
}
