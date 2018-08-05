package com.codelab.helmi.simades.surat.ektp;

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

import com.codelab.helmi.simades.R;
import com.codelab.helmi.simades.surat.ektp.detail.DetailSuratEktpFragment;

import java.util.ArrayList;
import java.util.List;

public class SuratEktpRecyclerAdapter extends RecyclerView.Adapter<SuratEktpRecyclerAdapter.MyHolder> implements Filterable {

    Context ctx;
    List<SuratEktpData> mList;
    List<SuratEktpData> mFilteredList;
    FragmentManager fragmentManager;

    public SuratEktpRecyclerAdapter(Context ctx, List<SuratEktpData> mList, FragmentManager fragmentManager) {
        this.ctx = ctx;
        this.mList = mList;
        this.fragmentManager = fragmentManager;
        this.mFilteredList = mList;

    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_surat_ektp, parent, false);
        MyHolder holder = new MyHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder holder, final int position) {
        holder.kode_surat.setText(mFilteredList.get(position).getKd_surat());
        holder.no_surat.setText(mFilteredList.get(position).getNo_surat());
        holder.tgl_surat.setText(mFilteredList.get(position).getTgl_surat());
        holder.status_persetujuan.setText(mFilteredList.get(position).getStatus_persetujuan());
        holder.pengaju.setText(mFilteredList.get(position).getNama_depan() + " " + mFilteredList.get(position).getNama_belakang());
        if (mFilteredList.get(position).getStatus_persetujuan().equals("Belum disetujui")) {
            holder.status_persetujuan.setTextColor(Color.parseColor("#ff0000"));
        } else if (mFilteredList.get(position).getStatus_persetujuan().equals("Disetujui")) {
            holder.status_persetujuan.setTextColor(Color.parseColor("#008000"));
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DetailSuratEktpFragment detailSuratEktpFragment = new DetailSuratEktpFragment();
                SuratEktpData suratEktpData = new SuratEktpData();

                suratEktpData.setKd_surat(mFilteredList.get(position).getKd_surat());
                suratEktpData.setNo_surat(mFilteredList.get(position).getNo_surat());
                suratEktpData.setTgl_surat(mFilteredList.get(position).getTgl_surat());
                suratEktpData.setStatus_persetujuan(mFilteredList.get(position).getStatus_persetujuan());
                suratEktpData.setNik(mFilteredList.get(position).getNik());
                suratEktpData.setNama_depan(mFilteredList.get(position).getNama_depan());
                suratEktpData.setNama_belakang(mFilteredList.get(position).getNama_belakang());
                suratEktpData.setNama_depan_user(mFilteredList.get(position).getNama_depan_user());
                suratEktpData.setNama_belakang_user(mFilteredList.get(position).getNama_belakang_user());

                Bundle bundle = new Bundle();
                bundle.putParcelable(DetailSuratEktpFragment.EXTRA_SURAT_PENGANTAR_EKTP, suratEktpData);
                detailSuratEktpFragment.setArguments(bundle);
                fragmentManager.beginTransaction()
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .replace(R.id.frame_container, detailSuratEktpFragment, detailSuratEktpFragment.getClass().getSimpleName())
                        .addToBackStack(detailSuratEktpFragment.getClass().getSimpleName())
                        .commit();

//                Toast.makeText(ctx, "" + holder.no_surat.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mFilteredList.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charString = constraint.toString();
                if (charString.isEmpty()) {
                    mFilteredList = mList;
                } else {
                    List<SuratEktpData> filteredList = new ArrayList<>();
                    for (SuratEktpData suratEktpData : mList) {
                        if (suratEktpData.getKd_surat().toLowerCase().contains(charString.toLowerCase()) || suratEktpData.getNo_surat().toLowerCase().contains(charString.toLowerCase()) || suratEktpData.getNama_depan().toLowerCase().contains(charString.toLowerCase()) || suratEktpData.getStatus_persetujuan().toLowerCase().contains(charString.toLowerCase()) || suratEktpData.getTgl_surat().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(suratEktpData);
                        }
                    }
                    mFilteredList = filteredList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = mFilteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                mFilteredList = (List<SuratEktpData>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView id_surat, kode_surat, no_surat, jenis_surat;
        TextView tgl_surat, waktu, status_persetujuan, pengaju;

        public MyHolder(View v) {
            super(v);
            kode_surat = v.findViewById(R.id.tv_kode_surat_pengantar_ektp);
            no_surat = v.findViewById(R.id.tv_nomor_surat_pengantar_ektp);
            tgl_surat = v.findViewById(R.id.tv_tanggal_surat_pengantar_ektp);
            status_persetujuan = v.findViewById(R.id.tv_status_persetujuan_surat_pengantar_ektp);
            pengaju = v.findViewById(R.id.tv_pengaju_surat_pengantar_ektp);
        }
    }
}
