package com.codelab.helmi.simades.surat.kematian;

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
import com.codelab.helmi.simades.surat.kematian.detail.DetailSuratKematianFragment;

import java.util.ArrayList;
import java.util.List;

public class SuratKematianRecyclerAdapter extends RecyclerView.Adapter<SuratKematianRecyclerAdapter.MyHolder> implements Filterable {
    List<SuratKematianData> mList;
    List<SuratKematianData> mFilterList;
    Context ctx;
    FragmentManager fragmentManager;

    public SuratKematianRecyclerAdapter(Context ctx, List<SuratKematianData> mList, FragmentManager fragmentManager) {
        this.mList = mList;
        this.ctx = ctx;
        this.fragmentManager = fragmentManager;
        this.mFilterList = mList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_surat_kematian, parent, false);
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
        holder.pengaju.setText(mFilterList.get(position).getNama_depan_pengaju() + mFilterList.get(position).getNama_belakang_pengaju());

        if(mFilterList.get(position).getStatus_persetujuan().equals("Belum disetujui")){
            holder.status_persetujuan.setTextColor(Color.parseColor("#ff0000"));
        }else if(mFilterList.get(position).getStatus_persetujuan().equals("Disetujui")){
            holder.status_persetujuan.setTextColor(Color.parseColor("#008000"));
        }



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailSuratKematianFragment detailSuratKematianFragment = new DetailSuratKematianFragment();
                SuratKematianData suratKematianData = new SuratKematianData();

                suratKematianData.setKd_surat(mFilterList.get(position).getKd_surat());
                suratKematianData.setNo_surat(mFilterList.get(position).getNo_surat());
                suratKematianData.setTgl_surat(mFilterList.get(position).getTgl_surat());
                suratKematianData.setWaktu(mFilterList.get(position).getWaktu());
                suratKematianData.setStatus_persetujuan(mFilterList.get(position).getStatus_persetujuan());
                suratKematianData.setNik(mFilterList.get(position).getNik());
                suratKematianData.setNama_depan_pengaju(mFilterList.get(position).getNama_depan_pengaju());
                suratKematianData.setNama_belakang_pengaju(mFilterList.get(position).getNama_belakang_pengaju());
                suratKematianData.setNama_depan_user(mFilterList.get(position).getNama_depan_user());
                suratKematianData.setNama_belakang_user(mFilterList.get(position).getNama_belakang_user());

                Bundle bundle = new Bundle();
                bundle.putParcelable(DetailSuratKematianFragment.EXTRA_SURAT_KEMATIAN, suratKematianData);

                detailSuratKematianFragment.setArguments(bundle);
                fragmentManager.beginTransaction()
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .replace(R.id.frame_container, detailSuratKematianFragment, detailSuratKematianFragment.getClass().getSimpleName())
                        .addToBackStack(detailSuratKematianFragment.getClass().getSimpleName())
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
                }
                else
                {
                    List<SuratKematianData> filteredList = new ArrayList<>();
                    for(SuratKematianData suratKematianData : mList)
                    {
                        if(suratKematianData.getKd_surat().toLowerCase().contains(charString.toLowerCase()) || suratKematianData.getNo_surat().toLowerCase().contains(charString.toLowerCase()) || suratKematianData.getNama_depan_pengaju().toLowerCase().contains(charString.toLowerCase()) || suratKematianData.getStatus_persetujuan().toLowerCase().contains(charString.toLowerCase()) || suratKematianData.getTgl_surat().toLowerCase().contains(charString.toLowerCase())){
                            filteredList.add(suratKematianData);
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
                mFilterList = (List<SuratKematianData>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView id_surat, kode_surat, no_surat, jenis_surat;
        TextView tgl_surat, waktu, status_persetujuan, pengaju;

        public MyHolder(View v) {
            super(v);

            kode_surat = v.findViewById(R.id.tv_kode_surat_meninggal);
            no_surat = v.findViewById(R.id.tv_nomor_surat_meninggal);
            tgl_surat = v.findViewById(R.id.tv_tanggal_surat_meninggal);
            status_persetujuan = v.findViewById(R.id.tv_status_persetujuan_surat_meninggal);
            pengaju = v.findViewById(R.id.tv_pengaju_surat_meninggal);

        }
    }
}
