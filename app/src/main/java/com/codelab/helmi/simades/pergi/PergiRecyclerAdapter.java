package com.codelab.helmi.simades.pergi;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
import com.codelab.helmi.simades.pergi.detail.DetailPergiFragment;

import java.util.ArrayList;
import java.util.List;

public class PergiRecyclerAdapter extends RecyclerView.Adapter<PergiRecyclerAdapter.MyHolder> implements Filterable {

    List<PergiData> mList;
    List<PergiData> mFilterList;
    Context ctx;
    FragmentManager fragmentManager;

    public PergiRecyclerAdapter(Context ctx, List<PergiData> mList, FragmentManager fragmentManager) {
        this.mList = mList;
        this.mFilterList = mList;
        this.ctx = ctx;
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_pergi, parent, false);
        MyHolder holder = new MyHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder holder, final int position) {
        holder.nik_pergi.setText(mFilterList.get(position).getNikPergi());
        holder.alamat_tuju.setText(mFilterList.get(position).getAlamatTuju());
        if (mFilterList.get(position).getNamaBelakang() != null) {
            holder.nama.setText(mFilterList.get(position).getNamaDepan() + " " + mFilterList.get(position).getNamaBelakang());
        } else {
            holder.nama.setText(mFilterList.get(position).getNamaDepan());
        }
        holder.tgl_pergi.setText(mFilterList.get(position).getTglPergi());

        if (mFilterList.get(position).getJekel().equals("Laki-laki")) {
            Glide.with(this.ctx).load(R.drawable.ic_boy).into(holder.ivPergi);
        } else if (mFilterList.get(position).getJekel().equals("Perempuan")) {
            Glide.with(this.ctx).load(R.drawable.ic_girl).into(holder.ivPergi);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailPergiFragment detailPergiFragment = new DetailPergiFragment();
                PergiData pergiData = new PergiData();

                pergiData.setNikPergi(mFilterList.get(position).getNikPergi());
                pergiData.setNik(mFilterList.get(position).getNik());
                pergiData.setAlamatTuju(mFilterList.get(position).getAlamatTuju());
                pergiData.setAlasan(mFilterList.get(position).getAlasan());
                pergiData.setAnakKe(mFilterList.get(position).getAnakKe());
                pergiData.setJekel(mFilterList.get(position).getJekel());
                pergiData.setKodePos(mFilterList.get(position).getKodePos());
                pergiData.setNamaAyah(mFilterList.get(position).getNamaAyah());
                pergiData.setNamaBelakang(mFilterList.get(position).getNamaBelakang());
                pergiData.setNamaDepan(mFilterList.get(position).getNamaDepan());
                pergiData.setNamaIbu(mFilterList.get(position).getNamaIbu());
                pergiData.setNoKk(mFilterList.get(position).getNoKk());
                pergiData.setStatus(mFilterList.get(position).getStatus());
                pergiData.setTanggalLhr(mFilterList.get(position).getTanggalLhr());
                pergiData.setTempatLhr(mFilterList.get(position).getTempatLhr());
                pergiData.setTglMutasi(mFilterList.get(position).getTglMutasi());
                pergiData.setTglPergi(mFilterList.get(position).getTglPergi());
                pergiData.setUmur(mFilterList.get(position).getUmur());

                Bundle bundle = new Bundle();
                bundle.putParcelable(DetailPergiFragment.EXTRA_PERGI, pergiData);
                detailPergiFragment.setArguments(bundle);

                fragmentManager.beginTransaction()
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .replace(R.id.frame_container, detailPergiFragment, detailPergiFragment.getClass().getSimpleName())
                        .addToBackStack(detailPergiFragment.getClass().getSimpleName())
                        .commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mFilterList.size();
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
                    List<PergiData> filteredList = new ArrayList<>();
                    for (PergiData pergiData : mList) {
                        if (pergiData.getNikPergi().toLowerCase().contains(charString.toLowerCase()) || pergiData.getNamaDepan().toLowerCase().contains(charString.toLowerCase()) || pergiData.getAlamatTuju().toLowerCase().contains(charString.toLowerCase()) || pergiData.getTglPergi().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(pergiData);
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
                mFilterList = (List<PergiData>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView nik_pergi, alamat_tuju, nama, tgl_pergi;
        ImageView ivPergi;

        public MyHolder(View v) {
            super(v);
            ivPergi = v.findViewById(R.id.iv_pergi_gambar);
            nik_pergi = v.findViewById(R.id.tvNikPergi);
            alamat_tuju = v.findViewById(R.id.tvAlamatTujuan);
            nama = v.findViewById(R.id.tv_pergi_nama);
            tgl_pergi = v.findViewById(R.id.tvTglPergi);
        }
    }
}
