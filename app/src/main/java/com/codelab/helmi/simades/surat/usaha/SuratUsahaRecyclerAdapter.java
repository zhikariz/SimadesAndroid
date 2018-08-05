package com.codelab.helmi.simades.surat.usaha;

import android.annotation.SuppressLint;

import android.content.Context;
import android.graphics.Color;
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
import android.widget.TextView;
import android.widget.Toast;

import com.codelab.helmi.simades.R;
import com.codelab.helmi.simades.surat.usaha.detail.DetailSuratUsahaFragment;

import java.util.ArrayList;
import java.util.List;

public class SuratUsahaRecyclerAdapter extends RecyclerView.Adapter<SuratUsahaRecyclerAdapter.MyHolder> implements Filterable{

    List<SuratUsahaData> mList;
    Context ctx;
    FragmentManager fragmentManager;
    List<SuratUsahaData> mFilterList;

    public SuratUsahaRecyclerAdapter(Context ctx, List<SuratUsahaData> mList, FragmentManager fragmentManager) {
        this.mList = mList;
        this.mFilterList = mList;
        this.ctx = ctx;
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_surat_usaha, parent, false);
        MyHolder holder = new MyHolder(layout);
        return holder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull final MyHolder holder, final int position) {
        holder.kode_surat.setText(mFilterList.get(position).getKd_surat());
        holder.no_surat.setText(mFilterList.get(position).getNo_surat());
        holder.tgl_surat.setText(mFilterList.get(position).getTgl_surat());
        holder.status_persetujuan.setText(mFilterList.get(position).getStatus_persetujuan());
        holder.pengaju.setText(mFilterList.get(position).getNama_depan() + " "+ mFilterList.get(position).getNama_belakang());

        holder.pengaju.setText(mFilterList.get(position).getNama_depan() + " " + mFilterList.get(position).getNama_belakang());
        if (mFilterList.get(position).getStatus_persetujuan().equals("Belum disetujui")) {
            holder.status_persetujuan.setTextColor(Color.parseColor("#ff0000"));
        } else if (mFilterList.get(position).getStatus_persetujuan().equals("Disetujui")) {
            holder.status_persetujuan.setTextColor(Color.parseColor("#008000"));
        }


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailSuratUsahaFragment detailSuratUsahaFragment = new DetailSuratUsahaFragment();
                SuratUsahaData suratUsahaData = new SuratUsahaData();


                suratUsahaData.setKd_surat(mFilterList.get(position).getKd_surat());
                suratUsahaData.setNo_surat(mFilterList.get(position).getNo_surat());
                suratUsahaData.setTgl_surat(mFilterList.get(position).getTgl_surat());
                suratUsahaData.setWaktu(mFilterList.get(position).getWaktu());
                suratUsahaData.setStatus_persetujuan(mFilterList.get(position).getStatus_persetujuan());
                suratUsahaData.setNik(mFilterList.get(position).getNik());
                suratUsahaData.setNama_usaha(mFilterList.get(position).getNama_usaha());
                suratUsahaData.setKeperluan(mFilterList.get(position).getKeperluan());
                suratUsahaData.setTgl_mulai(mFilterList.get(position).getTgl_mulai());
                suratUsahaData.setTgl_akhir(mFilterList.get(position).getTgl_akhir());
                suratUsahaData.setNama_depan(mFilterList.get(position).getNama_depan());
                suratUsahaData.setNama_belakang(mFilterList.get(position).getNama_belakang());
                suratUsahaData.setNama_depan_user(mFilterList.get(position).getNama_depan_user());
                suratUsahaData.setNama_belakang_user(mFilterList.get(position).getNama_belakang_user());

                Bundle bundle = new Bundle();
                bundle.putParcelable(DetailSuratUsahaFragment.EXTRA_SURAT_USAHA, suratUsahaData);

                detailSuratUsahaFragment.setArguments(bundle);
                fragmentManager.beginTransaction()
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .replace(R.id.frame_container, detailSuratUsahaFragment,detailSuratUsahaFragment.getClass().getSimpleName())
                        .addToBackStack(detailSuratUsahaFragment.getClass().getSimpleName())
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
                if(charString.isEmpty())
                {
                    mFilterList = mList;
                } else {
                    List<SuratUsahaData> filteredList = new ArrayList<>();
                    for(SuratUsahaData suratUsahaData : mList){
                        if(suratUsahaData.getKd_surat().toLowerCase().contains(charString.toLowerCase()) || suratUsahaData.getNo_surat().toLowerCase().contains(charString.toLowerCase()) || suratUsahaData.getNama_depan().toLowerCase().contains(charString.toLowerCase()) || suratUsahaData.getStatus_persetujuan().toLowerCase().contains(charString.toLowerCase()) || suratUsahaData.getTgl_surat().toLowerCase().contains(charString.toLowerCase())){
                            filteredList.add(suratUsahaData);
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
                mFilterList = (List<SuratUsahaData>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView id_surat, kode_surat, no_surat, jenis_surat;
        TextView tgl_surat, waktu, status_persetujuan, pengaju;

        public MyHolder(View v) {
            super(v);
            kode_surat = v.findViewById(R.id.tv_kode_surat_usaha);
            no_surat = v.findViewById(R.id.tv_nomor_surat_usaha);
            tgl_surat = v.findViewById(R.id.tv_tanggal_surat_usaha);
            status_persetujuan = v.findViewById(R.id.tv_status_persetujuan_surat_usaha);
            pengaju = v.findViewById(R.id.tv_pengaju_surat_usaha);

        }
    }
}
