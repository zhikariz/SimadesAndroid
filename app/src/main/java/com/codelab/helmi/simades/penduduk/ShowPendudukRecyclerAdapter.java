package com.codelab.helmi.simades.penduduk;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.codelab.helmi.simades.R;
import com.codelab.helmi.simades.penduduk.detail.DetailPendudukFragment;

import java.util.List;

public class ShowPendudukRecyclerAdapter extends RecyclerView.Adapter<ShowPendudukRecyclerAdapter.MyHolder> {
    List<PendudukData> mList;
    Context ctx;
    FragmentManager fragmentManager;

    public ShowPendudukRecyclerAdapter(Context ctx, List<PendudukData> mList, FragmentManager fragmentManager) {
        this.mList = mList;
        this.ctx = ctx;
        this.fragmentManager = fragmentManager;

    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_penduduk, parent, false);
        MyHolder holder = new MyHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ShowPendudukRecyclerAdapter.MyHolder holder, final int position) {
        holder.nik.setText(mList.get(position).getNik());
        if (mList.get(position).getNama_depan() != null && mList.get(position).getNama_belakang() != null) {
            holder.nama.setText(mList.get(position).getNama_depan() + " " + mList.get(position).getNama_belakang());
        } else if (mList.get(position).getNama_depan() != null && mList.get(position).getNama_belakang() == null) {
            holder.nama.setText(mList.get(position).getNama_depan());
        }

        holder.umur.setText(mList.get(position).getUmur());

        if(mList.get(position).getJekel().equals("Laki-laki")){
            Glide.with(this.ctx).load(R.drawable.ic_boy).into(holder.ivPenduduk);
        }else if(mList.get(position).getJekel().equals("Perempuan")){
            Glide.with(this.ctx).load(R.drawable.ic_girl).into(holder.ivPenduduk);
        }


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailPendudukFragment detailPendudukFragment = new DetailPendudukFragment();

                PendudukData pendudukData = new PendudukData();
                pendudukData.setNik(mList.get(position).getNik());
                pendudukData.setNo_kk(mList.get(position).getNo_kk());
                pendudukData.setNama_depan(mList.get(position).getNama_depan());
                pendudukData.setNama_belakang(mList.get(position).getNama_belakang());
                pendudukData.setJekel(mList.get(position).getJekel());
                pendudukData.setUmur(mList.get(position).getUmur());
                pendudukData.setTempat_lhr(mList.get(position).getTempat_lhr());
                pendudukData.setTanggal_lhr(mList.get(position).getTanggal_lhr());
                pendudukData.setNama_ayah(mList.get(position).getNama_ayah());
                pendudukData.setNama_ibu(mList.get(position).getNama_ibu());
                pendudukData.setAnak_ke(mList.get(position).getAnak_ke());
                pendudukData.setStatus(mList.get(position).getStatus());
                pendudukData.setTgl_mutasi(mList.get(position).getTgl_mutasi());
                pendudukData.setAgama(mList.get(position).getAgama());
                pendudukData.setGoldar(mList.get(position).getGoldar());
                pendudukData.setHubkel(mList.get(position).getHubkel());
                pendudukData.setKerja(mList.get(position).getKerja());
                pendudukData.setPendidikan(mList.get(position).getPendidikan());
                pendudukData.setStkawin(mList.get(position).getStkawin());
                pendudukData.setAlamat(mList.get(position).getAlamat());
                pendudukData.setRt(mList.get(position).getRt());
                pendudukData.setRw(mList.get(position).getRw());
                pendudukData.setKelurahan(mList.get(position).getKelurahan());
                pendudukData.setKecamatan(mList.get(position).getKecamatan());
                pendudukData.setKabupaten(mList.get(position).getKabupaten());
                pendudukData.setPropinsi(mList.get(position).getPropinsi());
                pendudukData.setDusun(mList.get(position).getDusun());

                Bundle bundle = new Bundle();
                bundle.putParcelable(DetailPendudukFragment.EXTRA_PENDUDUK, pendudukData);

                detailPendudukFragment.setArguments(bundle);
                fragmentManager.beginTransaction()
                        .replace(R.id.frame_container, detailPendudukFragment, detailPendudukFragment.getClass().getSimpleName())
                        .addToBackStack(detailPendudukFragment.getClass().getSimpleName())
                        .commit();

//                Toast.makeText(ctx, "" + holder.nama.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView nik, nokk, nama, jekel, umur;
        PendudukData pendudukData;
        ImageView ivPenduduk;

        public MyHolder(View v) {
            super(v);

            nik = v.findViewById(R.id.tvNik);
            nama = v.findViewById(R.id.tvNamaPenduduk);
            umur = v.findViewById(R.id.tvUmur);
            ivPenduduk = v.findViewById(R.id.iv_penduduk);


        }

    }
}
