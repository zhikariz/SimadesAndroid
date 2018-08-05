package com.codelab.helmi.simades.surat.skck;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.ContactsContract;
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
import com.codelab.helmi.simades.surat.skck.detail.DetailSuratSkckFragment;

import java.util.ArrayList;
import java.util.List;

public class SuratSkckRecyclerAdapter extends RecyclerView.Adapter<SuratSkckRecyclerAdapter.MyHolder> implements Filterable{

    List<SuratSkckData> mList;
    List<SuratSkckData> mFilterList;
    Context ctx;
    FragmentManager fragmentManager;

    public SuratSkckRecyclerAdapter(Context ctx, List<SuratSkckData> mList,FragmentManager fragmentManager) {
        this.mFilterList = mList;
        this.mList = mList;
        this.ctx = ctx;
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_surat_skck, parent, false);
        MyHolder holder = new MyHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder holder, final int position) {
        holder.kode_surat.setText(mFilterList.get(position).getKd_surat());
        holder.no_surat.setText(mFilterList.get(position).getNo_surat());
        holder.tgl_surat.setText(mFilterList.get(position).getTgl_surat());
        holder.status_persetujuan.setText(mFilterList.get(position).getStatus_persetujuan());
        holder.pengaju.setText(mFilterList.get(position).getNama_depan() + mFilterList.get(position).getNama_belakang());
        if (mFilterList.get(position).getStatus_persetujuan().equals("Belum disetujui")) {
            holder.status_persetujuan.setTextColor(Color.parseColor("#ff0000"));
        } else if (mFilterList.get(position).getStatus_persetujuan().equals("Disetujui")) {
            holder.status_persetujuan.setTextColor(Color.parseColor("#008000"));
        }


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailSuratSkckFragment detailSuratSkckFragment = new DetailSuratSkckFragment();
                SuratSkckData suratSkckData = new SuratSkckData();

                suratSkckData.setKd_surat(mFilterList.get(position).getKd_surat());
                suratSkckData.setNo_surat(mFilterList.get(position).getNo_surat());
                suratSkckData.setTgl_surat(mFilterList.get(position).getTgl_surat());

                suratSkckData.setStatus_persetujuan(mFilterList.get(position).getStatus_persetujuan());
                suratSkckData.setNik(mFilterList.get(position).getNik());
                suratSkckData.setNama_depan(mFilterList.get(position).getNama_depan());
                suratSkckData.setNama_belakang(mFilterList.get(position).getNama_belakang());
                suratSkckData.setNama_depan_user(mFilterList.get(position).getNama_depan_user());
                suratSkckData.setNama_belakang_user(mFilterList.get(position).getNama_belakang_user());

                Bundle bundle = new Bundle();
                bundle.putParcelable(DetailSuratSkckFragment.EXTRA_SURAT_SKCK, suratSkckData);

                detailSuratSkckFragment.setArguments(bundle);
                fragmentManager.beginTransaction()
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .replace(R.id.frame_container, detailSuratSkckFragment, detailSuratSkckFragment.getClass().getSimpleName())
                        .addToBackStack(detailSuratSkckFragment.getClass().getSimpleName())
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
                } else {
                    List<SuratSkckData> filteredList = new ArrayList<>();
                    for(SuratSkckData suratSkckData : mList)
                    {
                        if(suratSkckData.getKd_surat().toLowerCase().contains(charString.toLowerCase()) || suratSkckData.getNo_surat().toLowerCase().contains(charString.toLowerCase()) || suratSkckData.getNama_depan().toLowerCase().contains(charString.toLowerCase()) || suratSkckData.getStatus_persetujuan().toLowerCase().contains(charString.toLowerCase()) || suratSkckData.getTgl_surat().toLowerCase().contains(charString.toLowerCase())){
                            filteredList.add(suratSkckData);
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
                mFilterList = (List<SuratSkckData>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView id_surat, kode_surat, no_surat, jenis_surat;
        TextView tgl_surat, waktu, status_persetujuan, pengaju;

        public MyHolder(View v) {
            super(v);
            kode_surat = v.findViewById(R.id.tv_kode_surat_pengantar_skck);
            no_surat = v.findViewById(R.id.tv_nomor_surat_pengantar_skck);
            tgl_surat = v.findViewById(R.id.tv_tanggal_surat_pengantar_skck);
            status_persetujuan = v.findViewById(R.id.tv_status_persetujuan_surat_pengantar_skck);
            pengaju = v.findViewById(R.id.tv_pengaju_surat_pengantar_skck);
        }
    }
}
