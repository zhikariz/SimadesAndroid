package com.codelab.helmi.simades.penduduk;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codelab.helmi.simades.R;
import com.codelab.helmi.simades.penduduk.detail.DetailPendudukFragment;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ShowPendudukRecyclerAdapter extends RecyclerView.Adapter<ShowPendudukRecyclerAdapter.MyHolder> implements Filterable {
    List<PendudukData> mList = new ArrayList<>();
    List<PendudukData> mFilterList = new ArrayList<>();
    Context ctx;
    FragmentManager fragmentManager;

    public ShowPendudukRecyclerAdapter(Context ctx, List<PendudukData> mList, FragmentManager fragmentManager) {
        this.mList = mList;
        this.ctx = ctx;
        this.fragmentManager = fragmentManager;
        this.mFilterList = mList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_penduduk, parent, false);
        MyHolder holder = new MyHolder(layout);
        return holder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, final int position) {
        holder.nik.setText(mFilterList.get(position).getNik());
        if (mFilterList.get(position).getNama_depan() != null && mFilterList.get(position).getNama_belakang() != null) {
            holder.nama.setText(mFilterList.get(position).getNama_depan() + " " + mFilterList.get(position).getNama_belakang());
        } else if (mFilterList.get(position).getNama_depan() != null && mFilterList.get(position).getNama_belakang() == null) {
            holder.nama.setText(mFilterList.get(position).getNama_depan());
        }

        holder.umur.setText(mFilterList.get(position).getUmur());

        if (mFilterList.get(position).getJekel().equals("Laki-laki")) {
            Glide.with(this.ctx).load(R.drawable.ic_boy).into(holder.ivPenduduk);
        } else if (mFilterList.get(position).getJekel().equals("Perempuan")) {
            Glide.with(this.ctx).load(R.drawable.ic_girl).into(holder.ivPenduduk);
        }


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailPendudukFragment detailPendudukFragment = new DetailPendudukFragment();
                PendudukData pendudukData = new PendudukData();

                pendudukData.setNik(mFilterList.get(position).getNik());
                pendudukData.setNo_kk(mFilterList.get(position).getNo_kk());
                pendudukData.setNama_depan(mFilterList.get(position).getNama_depan());
                pendudukData.setNama_belakang(mFilterList.get(position).getNama_belakang());
                pendudukData.setJekel(mFilterList.get(position).getJekel());
                pendudukData.setUmur(mFilterList.get(position).getUmur());
                pendudukData.setTempat_lhr(mFilterList.get(position).getTempat_lhr());
                pendudukData.setTanggal_lhr(mFilterList.get(position).getTanggal_lhr());
                pendudukData.setNama_ayah(mFilterList.get(position).getNama_ayah());
                pendudukData.setNama_ibu(mFilterList.get(position).getNama_ibu());
                pendudukData.setAnak_ke(mFilterList.get(position).getAnak_ke());
                pendudukData.setStatus(mFilterList.get(position).getStatus());
                pendudukData.setTgl_mutasi(mFilterList.get(position).getTgl_mutasi());
                pendudukData.setAgama(mFilterList.get(position).getAgama());
                pendudukData.setGoldar(mFilterList.get(position).getGoldar());
                pendudukData.setHubkel(mFilterList.get(position).getHubkel());
                pendudukData.setKerja(mFilterList.get(position).getKerja());
                pendudukData.setPendidikan(mFilterList.get(position).getPendidikan());
                pendudukData.setStkawin(mFilterList.get(position).getStkawin());
                pendudukData.setAlamat(mFilterList.get(position).getAlamat());
                pendudukData.setRt(mFilterList.get(position).getRt());
                pendudukData.setRw(mFilterList.get(position).getRw());
                pendudukData.setKelurahan(mFilterList.get(position).getKelurahan());
                pendudukData.setKecamatan(mFilterList.get(position).getKecamatan());
                pendudukData.setKabupaten(mFilterList.get(position).getKabupaten());
                pendudukData.setPropinsi(mFilterList.get(position).getPropinsi());
                pendudukData.setDusun(mFilterList.get(position).getDusun());

                Bundle bundle = new Bundle();
                bundle.putParcelable(DetailPendudukFragment.EXTRA_PENDUDUK, pendudukData);

                detailPendudukFragment.setArguments(bundle);
                fragmentManager.beginTransaction()
                        .replace(R.id.frame_container, detailPendudukFragment, detailPendudukFragment.getClass().getSimpleName())
                        .addToBackStack(detailPendudukFragment.getClass().getSimpleName())
                        .commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return  mFilterList.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charString = constraint.toString();

                if (charString.isEmpty()) {
                    mFilterList = mList;
                } else {
                    List<PendudukData> filteredList = new ArrayList<>();
                    for (PendudukData pendudukData : mList) {
                        if (pendudukData.getNik().toLowerCase().contains(charString.toLowerCase()) || pendudukData.getNama_depan().toLowerCase().contains(charString.toLowerCase()) || pendudukData.getNama_belakang().toLowerCase().contains(charString.toLowerCase()) || pendudukData.getUmur().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(pendudukData);
                        }
                    }
                    mFilterList = filteredList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = mFilterList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                mFilterList = (List<PendudukData>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView nik, nama, umur;
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
