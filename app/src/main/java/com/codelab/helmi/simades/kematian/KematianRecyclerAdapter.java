package com.codelab.helmi.simades.kematian;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.codelab.helmi.simades.R;
import com.codelab.helmi.simades.kematian.detail.DetailKematianFragment;

import java.util.ArrayList;
import java.util.List;


public class KematianRecyclerAdapter extends RecyclerView.Adapter<KematianRecyclerAdapter.MyHolder> implements Filterable{

    List<KematianData> mList;
    List<KematianData> mFilterList;
    Context ctx;
    FragmentManager fragmentManager;

    public KematianRecyclerAdapter(Context ctx, List<KematianData> mList, FragmentManager fragmentManager) {
        this.mFilterList = mList;
        this.mList = mList;
        this.ctx = ctx;
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_kematian, parent, false);
        MyHolder holder = new MyHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder holder, final int position) {
        if (mFilterList.get(position).getJekel().equals("Laki-laki")) {
            Glide.with(this.ctx).load(R.drawable.ic_baby_boy).into(holder.ivGambar);
        } else if (mFilterList.get(position).getJekel().equals("Perempuan")) {
            Glide.with(this.ctx).load(R.drawable.ic_baby_girl).into(holder.ivGambar);
        }
        if (mFilterList.get(position).getNamaBelakang() != null) {
            holder.nama_meninggal.setText(mFilterList.get(position).getNamaDepan() + " " + mFilterList.get(position).getNamaBelakang());
        } else {
            holder.nama_meninggal.setText(mFilterList.get(position).getNamaDepan());
        }

        holder.nik_meninggal.setText(mFilterList.get(position).getNikMeninggal());
        holder.tgl_meninggal.setText(mFilterList.get(position).getTglMeninggal());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailKematianFragment detailKematianFragment = new DetailKematianFragment();
                KematianData kematianData = new KematianData();

                kematianData.setNikMeninggal(mFilterList.get(position).getNikMeninggal());
                kematianData.setTglMeninggal(mFilterList.get(position).getTglMeninggal());
                kematianData.setSebab(mFilterList.get(position).getSebab());
                kematianData.setTptMeninggal(mFilterList.get(position).getTptMeninggal());
                kematianData.setMenerangkan(mFilterList.get(position).getMenerangkan());
                kematianData.setNoKk(mFilterList.get(position).getNoKk());
                kematianData.setNamaDepan(mFilterList.get(position).getNamaDepan());
                kematianData.setNamaBelakang(mFilterList.get(position).getNamaBelakang());
                kematianData.setJekel(mFilterList.get(position).getJekel());
                kematianData.setUmur(mFilterList.get(position).getUmur());
                kematianData.setTempatLhr(mFilterList.get(position).getTempatLhr());
                kematianData.setTanggalLhr(mFilterList.get(position).getTanggalLhr());
                kematianData.setNamaAyah(mFilterList.get(position).getNamaAyah());
                kematianData.setNamaIbu(mFilterList.get(position).getNamaIbu());
                kematianData.setAnakKe(mFilterList.get(position).getAnakKe());

                Bundle bundle = new Bundle();
                bundle.putParcelable(DetailKematianFragment.EXTRA_KEMATIAN, kematianData);
                detailKematianFragment.setArguments(bundle);

                fragmentManager.beginTransaction()
                        .replace(R.id.frame_container,detailKematianFragment,detailKematianFragment.getClass().getSimpleName())
                        .addToBackStack(detailKematianFragment.getClass().getSimpleName())
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
                    List<KematianData> filteredList = new ArrayList<>();
                    for (KematianData kematianData : mList) {
                        if (kematianData.getNikMeninggal().toLowerCase().contains(charString.toLowerCase()) || kematianData.getNamaDepan().toLowerCase().contains(charString.toLowerCase()) || kematianData.getTglMeninggal().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(kematianData);
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
                mFilterList = (List<KematianData>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView nik_meninggal, tgl_meninggal, nama_meninggal;
        ImageView ivGambar;

        public MyHolder(View v) {
            super(v);
            ivGambar = v.findViewById(R.id.iv_kematian_gambar);
            nama_meninggal = v.findViewById(R.id.tv_kematian_nama);
            nik_meninggal = v.findViewById(R.id.tvNikMeninggal);
            tgl_meninggal = v.findViewById(R.id.tvTglMeninggal);
        }
    }
}
