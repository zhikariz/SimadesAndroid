package com.codelab.helmi.simades.kelahiran;

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
import com.codelab.helmi.simades.kelahiran.detail.DetailKelahiranFragment;

import java.util.ArrayList;
import java.util.List;

public class KelahiranRecyclerAdapter extends RecyclerView.Adapter<KelahiranRecyclerAdapter.MyHolder> implements Filterable {

    List<KelahiranData> mList;
    List<KelahiranData> mFilterList;
    Context ctx;
    FragmentManager fragmentManager;

    public KelahiranRecyclerAdapter(Context ctx, List<KelahiranData> mList, FragmentManager fragmentManager) {
        this.mList = mList;
        this.ctx = ctx;
        this.mFilterList = mList;
        this.fragmentManager = fragmentManager;
    }


    @NonNull
    @Override
    public KelahiranRecyclerAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_kelahiran, parent, false);
        MyHolder holder = new MyHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, final int position) {
        holder.nis.setText(mFilterList.get(position).getNis_bayi());
        holder.nama.setText(mFilterList.get(position).getNama_depan_bayi() + " " + mFilterList.get(position).getNama_belakang_bayi());
        holder.tgllahir.setText(mFilterList.get(position).getTgl_lahir());
        if (mFilterList.get(position).getJekel().equals("Laki-laki")) {
            Glide.with(this.ctx).load(R.drawable.ic_baby_boy).into(holder.ivKelahiran);
        } else if (mFilterList.get(position).getJekel().equals("Perempuan")) {
            Glide.with(this.ctx).load(R.drawable.ic_baby_girl).into(holder.ivKelahiran);
        }


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailKelahiranFragment detailKelahiranFragment = new DetailKelahiranFragment();
                KelahiranData kelahiranData = new KelahiranData();

                kelahiranData.setId_lahir(mFilterList.get(position).getId_lahir());
                kelahiranData.setNis_bayi(mFilterList.get(position).getNis_bayi());
                kelahiranData.setNama_depan_bayi(mFilterList.get(position).getNama_depan_bayi());
                kelahiranData.setNama_belakang_bayi(mFilterList.get(position).getNama_belakang_bayi());
                kelahiranData.setTgl_lahir(mFilterList.get(position).getTgl_lahir());
                kelahiranData.setTpt_lahir(mFilterList.get(position).getTpt_lahir());
                kelahiranData.setJekel(mFilterList.get(position).getJekel());
                kelahiranData.setBerat_bayi(mFilterList.get(position).getBerat_bayi());
                kelahiranData.setAnak_ke(mFilterList.get(position).getAnak_ke());
                kelahiranData.setWaktu(mFilterList.get(position).getWaktu());
                kelahiranData.setPanjang_bayi(mFilterList.get(position).getPanjang_bayi());
                kelahiranData.setNik_ayah(mFilterList.get(position).getNik_ayah());
                kelahiranData.setNama_depan_ayah(mFilterList.get(position).getNama_depan_ayah());
                kelahiranData.setNama_belakang_ayah(mFilterList.get(position).getNama_belakang_ayah());
                kelahiranData.setNik_ibu(mFilterList.get(position).getNik_ibu());
                kelahiranData.setNama_depan_ibu(mFilterList.get(position).getNama_depan_ibu());
                kelahiranData.setNama_belakang_ibu(mFilterList.get(position).getNama_belakang_ibu());
                kelahiranData.setNik_saksi1(mFilterList.get(position).getNik_saksi1());
                kelahiranData.setNama_depan_saksi1(mFilterList.get(position).getNama_depan_saksi1());
                kelahiranData.setNama_belakang_saksi1(mFilterList.get(position).getNama_belakang_saksi1());
                kelahiranData.setNik_saksi2(mFilterList.get(position).getNik_saksi2());
                kelahiranData.setNama_depan_saksi2(mFilterList.get(position).getNama_depan_saksi2());
                kelahiranData.setNama_belakang_saksi2(mFilterList.get(position).getNama_belakang_saksi2());

                Bundle bundle = new Bundle();
                bundle.putParcelable(DetailKelahiranFragment.EXTRA_KELAHIRAN, kelahiranData);

                detailKelahiranFragment.setArguments(bundle);
                fragmentManager.beginTransaction()
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .replace(R.id.frame_container, detailKelahiranFragment, detailKelahiranFragment.getClass().getSimpleName())
                        .addToBackStack(detailKelahiranFragment.getClass().getSimpleName())
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
                    List<KelahiranData> filteredList = new ArrayList<>();
                    for (KelahiranData kelahiranData : mList) {
                        if (kelahiranData.getNis_bayi().toLowerCase().contains(charString.toLowerCase()) || kelahiranData.getNama_depan_bayi().toLowerCase().contains(charString.toLowerCase()) || kelahiranData.getNama_belakang_bayi().toLowerCase().contains(charString.toLowerCase()) || kelahiranData.getTgl_lahir().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(kelahiranData);
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
                mFilterList = (List<KelahiranData>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView nis, nama, tgllahir;
        ImageView ivKelahiran;

        public MyHolder(View v) {
            super(v);

            nis = v.findViewById(R.id.tvNisBayi);
            nama = v.findViewById(R.id.tvNamaBayi);
            tgllahir = v.findViewById(R.id.tvTTLBayi);
            ivKelahiran = v.findViewById(R.id.iv_kelahiran_kelahiran);


        }

    }
}
