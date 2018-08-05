package com.codelab.helmi.simades.surat.domisili;

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
import com.codelab.helmi.simades.surat.domisili.detail.DetailSuratDomisiliFragment;

import java.util.ArrayList;
import java.util.List;

public class SuratDomisiliRecyclerAdapter extends RecyclerView.Adapter<SuratDomisiliRecyclerAdapter.MyHolder> implements Filterable {
    Context ctx;
    List<SuratDomisiliData> mList;
    FragmentManager fragmentManager;
    List<SuratDomisiliData> mFilterList;

    public SuratDomisiliRecyclerAdapter(Context ctx, List<SuratDomisiliData> mList, FragmentManager fragmentManager) {
        this.mFilterList = mList;
        this.ctx = ctx;
        this.mList = mList;
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_surat_domisili, parent, false);
        MyHolder holder = new MyHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder holder, final int position) {
        holder.kode_surat.setText(mFilterList.get(position).getKd_surat());
        holder.no_surat.setText(mFilterList.get(position).getNo_surat());
        holder.tgl_surat.setText(mFilterList.get(position).getTgl_surat());
        holder.status_persetujuan.setText(mFilterList.get(position).getStatus_persetujuan());
        holder.pengaju.setText(mFilterList.get(position).getNama_depan() + " " + mFilterList.get(position).getNama_belakang());
        if (mFilterList.get(position).getStatus_persetujuan().equals("Belum disetujui")) {
            holder.status_persetujuan.setTextColor(Color.parseColor("#ff0000"));
        } else if (mFilterList.get(position).getStatus_persetujuan().equals("Disetujui")) {
            holder.status_persetujuan.setTextColor(Color.parseColor("#008000"));
        }


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailSuratDomisiliFragment detailSuratDomisiliFragment = new DetailSuratDomisiliFragment();
                SuratDomisiliData suratDomisiliData = new SuratDomisiliData();

                suratDomisiliData.setKd_surat(mFilterList.get(position).getKd_surat());
                suratDomisiliData.setNo_surat(mFilterList.get(position).getNo_surat());
                suratDomisiliData.setTgl_surat(mFilterList.get(position).getTgl_surat());
                suratDomisiliData.setStatus_persetujuan(mFilterList.get(position).getStatus_persetujuan());
                suratDomisiliData.setNik(mFilterList.get(position).getNik());
                suratDomisiliData.setNama_depan(mFilterList.get(position).getNama_depan());
                suratDomisiliData.setNama_belakang(mFilterList.get(position).getNama_belakang());
                suratDomisiliData.setNama_depan_user(mFilterList.get(position).getNama_depan_user());
                suratDomisiliData.setNama_belakang_user(mFilterList.get(position).getNama_belakang_user());

                Bundle bundle = new Bundle();
                bundle.putParcelable(DetailSuratDomisiliFragment.EXTRA_SURAT_DOMISILI, suratDomisiliData);
                detailSuratDomisiliFragment.setArguments(bundle);

                fragmentManager.beginTransaction()
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .replace(R.id.frame_container, detailSuratDomisiliFragment, detailSuratDomisiliFragment.getClass().getSimpleName())
                        .addToBackStack(detailSuratDomisiliFragment.getClass().getSimpleName())
                        .commit();

//                Toast.makeText(ctx, "" + holder.no_surat.getText().toString(), Toast.LENGTH_SHORT).show();
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
                    List<SuratDomisiliData> filteredList = new ArrayList<>();
                    for (SuratDomisiliData suratDomisiliData : mList) {
                        if (suratDomisiliData.getKd_surat().toLowerCase().contains(charString.toLowerCase()) || suratDomisiliData.getNo_surat().toLowerCase().contains(charString.toLowerCase()) || suratDomisiliData.getNama_depan().toLowerCase().contains(charString.toLowerCase()) || suratDomisiliData.getStatus_persetujuan().toLowerCase().contains(charString.toLowerCase()) || suratDomisiliData.getTgl_surat().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(suratDomisiliData);
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
                mFilterList = (List<SuratDomisiliData>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView id_surat, kode_surat, no_surat, jenis_surat;
        TextView tgl_surat, waktu, status_persetujuan, pengaju;

        public MyHolder(View v) {
            super(v);
            kode_surat = v.findViewById(R.id.tv_kode_surat_domisili);
            no_surat = v.findViewById(R.id.tv_nomor_surat_domisili);
            tgl_surat = v.findViewById(R.id.tv_tanggal_surat_domisili);
            status_persetujuan = v.findViewById(R.id.tv_status_persetujuan_surat_domisili);
            pengaju = v.findViewById(R.id.tv_pengaju_surat_domisili);
        }
    }
}
