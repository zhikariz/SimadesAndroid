package com.codelab.helmi.simades.surat.blm_menikah;

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
import com.codelab.helmi.simades.surat.blm_menikah.detail.DetailSuratBlmMenikahFragment;

import java.util.ArrayList;
import java.util.List;

public class SuratBlmMenikahRecyclerAdapter extends RecyclerView.Adapter<SuratBlmMenikahRecyclerAdapter.MyHolder>  implements Filterable{

    Context ctx;
    List<SuratBlmMenikahData> mList;
    List<SuratBlmMenikahData> mFilterList;
    FragmentManager fragmentManager;

    public SuratBlmMenikahRecyclerAdapter(Context ctx, List<SuratBlmMenikahData> mList, FragmentManager fragmentManager) {
        this.mFilterList = mList;
        this.ctx = ctx;
        this.mList = mList;
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_surat_blm_menikah, parent, false);
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
                DetailSuratBlmMenikahFragment detailSuratBlmMenikahFragment = new DetailSuratBlmMenikahFragment();
                SuratBlmMenikahData suratBlmMenikahData = new SuratBlmMenikahData();

                suratBlmMenikahData.setKd_surat(mFilterList.get(position).getKd_surat());
                suratBlmMenikahData.setNo_surat(mFilterList.get(position).getNo_surat());
                suratBlmMenikahData.setTgl_surat(mFilterList.get(position).getTgl_surat());
                suratBlmMenikahData.setStatus_persetujuan(mFilterList.get(position).getStatus_persetujuan());
                suratBlmMenikahData.setNik(mFilterList.get(position).getNik());
                suratBlmMenikahData.setNama_depan(mFilterList.get(position).getNama_depan());
                suratBlmMenikahData.setNama_belakang(mFilterList.get(position).getNama_belakang());
                suratBlmMenikahData.setNama_depan_user(mFilterList.get(position).getNama_depan_user());
                suratBlmMenikahData.setNama_belakang_user(mFilterList.get(position).getNama_belakang_user());

                Bundle bundle = new Bundle();
                bundle.putParcelable(DetailSuratBlmMenikahFragment.EXTRA_SURAT_BLM_MENIKAH, suratBlmMenikahData);

                detailSuratBlmMenikahFragment.setArguments(bundle);
                fragmentManager.beginTransaction()
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .replace(R.id.frame_container, detailSuratBlmMenikahFragment, detailSuratBlmMenikahFragment.getClass().getSimpleName())
                        .addToBackStack(detailSuratBlmMenikahFragment.getClass().getSimpleName())
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
                if(charString.isEmpty()){
                    mFilterList = mList;
                }else{
                    List<SuratBlmMenikahData> filteredList = new ArrayList<>();
                    for(SuratBlmMenikahData suratBlmMenikahData : mList)
                    {
                        if(suratBlmMenikahData.getKd_surat().toLowerCase().contains(charString.toLowerCase()) || suratBlmMenikahData.getNo_surat().toLowerCase().contains(charString.toLowerCase()) || suratBlmMenikahData.getNama_depan().toLowerCase().contains(charString.toLowerCase()) || suratBlmMenikahData.getStatus_persetujuan().toLowerCase().contains(charString.toLowerCase()) || suratBlmMenikahData.getTgl_surat().toLowerCase().contains(charString.toLowerCase())){
                            filteredList.add(suratBlmMenikahData);
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
                mFilterList = (List<SuratBlmMenikahData>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView kode_surat, no_surat;
        TextView tgl_surat, status_persetujuan, pengaju;

        public MyHolder(View v) {
            super(v);
            kode_surat = v.findViewById(R.id.tv_kode_surat_blm_menikah);
            no_surat = v.findViewById(R.id.tv_nomor_surat_blm_menikah);
            tgl_surat = v.findViewById(R.id.tv_tanggal_surat_blm_menikah);
            status_persetujuan = v.findViewById(R.id.tv_status_persetujuan_surat_blm_menikah);
            pengaju = v.findViewById(R.id.tv_pengaju_surat_blm_menikah);
        }
    }
}
