package com.codelab.helmi.simades.surat.kehilangan;

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
import com.codelab.helmi.simades.surat.kehilangan.detail.DetailSuratKehilanganFragment;

import java.util.ArrayList;
import java.util.List;

public class SuratKehilanganRecyclerAdapter extends RecyclerView.Adapter<SuratKehilanganRecyclerAdapter.MyHolder>  implements Filterable{

    Context ctx;
    List<SuratKehilanganData> mList;
    List<SuratKehilanganData> mFilterList;
    FragmentManager fragmentManager;

    public SuratKehilanganRecyclerAdapter(Context ctx, List<SuratKehilanganData> mList, FragmentManager fragmentManager) {
        this.ctx = ctx;
        this.mFilterList = mList;
        this.mList = mList;
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_surat_kehilangan, parent, false);
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
                DetailSuratKehilanganFragment detailSuratKehilanganFragment = new DetailSuratKehilanganFragment();
                SuratKehilanganData suratKehilanganData = new SuratKehilanganData();

                suratKehilanganData.setKd_surat(mFilterList.get(position).getKd_surat());
                suratKehilanganData.setNo_surat(mFilterList.get(position).getNo_surat());
                suratKehilanganData.setTgl_surat(mFilterList.get(position).getTgl_surat());
                suratKehilanganData.setStatus_persetujuan(mFilterList.get(position).getStatus_persetujuan());
                suratKehilanganData.setNik(mFilterList.get(position).getNik());
                suratKehilanganData.setNama_depan(mFilterList.get(position).getNama_depan());
                suratKehilanganData.setNama_belakang(mFilterList.get(position).getNama_belakang());
                suratKehilanganData.setNama_depan_user(mFilterList.get(position).getNama_depan_user());
                suratKehilanganData.setNama_belakang_user(mFilterList.get(position).getNama_belakang_user());

                Bundle bundle = new Bundle();
                bundle.putParcelable(DetailSuratKehilanganFragment.EXTRA_SURAT_KEHILANGAN, suratKehilanganData);

                detailSuratKehilanganFragment.setArguments(bundle);
                fragmentManager.beginTransaction()
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .replace(R.id.frame_container, detailSuratKehilanganFragment, detailSuratKehilanganFragment.getClass().getSimpleName())
                        .addToBackStack(detailSuratKehilanganFragment.getClass().getSimpleName())
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
                if(charString.isEmpty())
                {
                    mFilterList = mList;
                }else
                {
                    List<SuratKehilanganData> filteredList = new ArrayList<>();
                    for(SuratKehilanganData suratKehilanganData : mList)
                    {
                        if(suratKehilanganData.getKd_surat().toLowerCase().contains(charString.toLowerCase()) || suratKehilanganData.getNo_surat().toLowerCase().contains(charString.toLowerCase()) || suratKehilanganData.getNama_depan().toLowerCase().contains(charString.toLowerCase()) || suratKehilanganData.getStatus_persetujuan().toLowerCase().contains(charString.toLowerCase()) || suratKehilanganData.getTgl_surat().toLowerCase().contains(charString.toLowerCase())){
                            filteredList.add(suratKehilanganData);
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
                mFilterList = (List<SuratKehilanganData>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView id_surat, kode_surat, no_surat, jenis_surat;
        TextView tgl_surat, waktu, status_persetujuan, pengaju;

        public MyHolder(View v) {
            super(v);
            kode_surat = v.findViewById(R.id.tv_kode_surat_kehilangan);
            no_surat = v.findViewById(R.id.tv_nomor_surat_kehilangan);
            tgl_surat = v.findViewById(R.id.tv_tanggal_surat_kehilangan);
            status_persetujuan = v.findViewById(R.id.tv_status_persetujuan_surat_kehilangan);
            pengaju = v.findViewById(R.id.tv_pengaju_surat_kehilangan);
        }
    }
}
