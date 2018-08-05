package com.codelab.helmi.simades.datang;

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
import com.codelab.helmi.simades.datang.detail.DetailDatangFragment;

import java.util.ArrayList;
import java.util.List;

public class DatangRecyclerAdapter extends RecyclerView.Adapter<DatangRecyclerAdapter.MyHolder> implements Filterable {

    List<DatangData> mList;
    List<DatangData> mFilterList;
    Context ctx;
    FragmentManager fragmentManager;

    public DatangRecyclerAdapter(Context ctx, List<DatangData> mList, FragmentManager fragmentManager) {
        this.mFilterList = mList;
        this.mList = mList;
        this.ctx = ctx;
        this.fragmentManager = fragmentManager;
    }


    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_datang, parent, false);
        MyHolder holder = new MyHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, final int position) {
        holder.nik_pendatang.setText(mFilterList.get(position).getNikPendatang());
        holder.alamat_asal.setText(mFilterList.get(position).getAlamatAsal());
        if(mFilterList.get(position).getNamaBelakang() != null){
            holder.nama.setText(mFilterList.get(position).getNamaDepan() + " " + mFilterList.get(position).getNamaBelakang());
        }else {
            holder.nama.setText(mFilterList.get(position).getNamaDepan());
        }

        holder.pengikut.setText(mFilterList.get(position).getPengikut());

        if (mFilterList.get(position).getJekel().equals("Laki-laki")) {
            Glide.with(this.ctx).load(R.drawable.ic_boy).into(holder.ivDatang);
        } else if (mFilterList.get(position).getJekel().equals("Perempuan")) {
            Glide.with(this.ctx).load(R.drawable.ic_girl).into(holder.ivDatang);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailDatangFragment detailDatangFragment = new DetailDatangFragment();
                DatangData datangData = new DatangData();

                datangData.setNikPendatang(mFilterList.get(position).getNikPendatang());
                datangData.setNikAsal(mFilterList.get(position).getNikAsal());
                datangData.setNoKkAsal(mFilterList.get(position).getNoKkAsal());
                datangData.setAlamatAsal(mFilterList.get(position).getAlamatAsal());
                datangData.setAlasan(mFilterList.get(position).getAlasan());
                datangData.setPengikut(mFilterList.get(position).getPengikut());
                datangData.setNoKk(mFilterList.get(position).getNoKk());
                datangData.setNamaDepan(mFilterList.get(position).getNamaDepan());
                datangData.setNamaBelakang(mFilterList.get(position).getNamaBelakang());
                datangData.setJekel(mFilterList.get(position).getJekel());
                datangData.setUmur(mFilterList.get(position).getUmur());
                datangData.setTempatLhr(mFilterList.get(position).getTempatLhr());
                datangData.setTanggalLhr(mFilterList.get(position).getTanggalLhr());
                datangData.setNamaAyah(mFilterList.get(position).getNamaAyah());
                datangData.setNamaIbu(mFilterList.get(position).getNamaIbu());
                datangData.setAnakKe(mFilterList.get(position).getAnakKe());

                Bundle bundle = new Bundle();
                bundle.putParcelable(DetailDatangFragment.EXTRA_DATANG, datangData);
                detailDatangFragment.setArguments(bundle);

                fragmentManager.beginTransaction()
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .replace(R.id.frame_container, detailDatangFragment, detailDatangFragment.getClass().getSimpleName())
                        .addToBackStack(detailDatangFragment.getClass().getSimpleName())
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
                    List<DatangData> filteredList = new ArrayList<>();
                    for (DatangData datangData : mList) {
                        if (datangData.getNikPendatang().toLowerCase().contains(charString.toLowerCase()) || datangData.getNamaDepan().toLowerCase().contains(charString.toLowerCase()) || datangData.getAlamatAsal().toLowerCase().contains(charString.toLowerCase()) || datangData.getPengikut().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(datangData);
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
                mFilterList = (List<DatangData>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView nik_pendatang, alamat_asal, nama, pengikut;
        ImageView ivDatang;

        public MyHolder(View v) {
            super(v);
            ivDatang = v.findViewById(R.id.iv_datang_gambar);
            nik_pendatang = v.findViewById(R.id.tvNikPendatang);
            alamat_asal = v.findViewById(R.id.tv_alamat_asal);
            nama = v.findViewById(R.id.tv_datang_nama);
            pengikut = v.findViewById(R.id.tv_pengikut);


        }
    }
}
