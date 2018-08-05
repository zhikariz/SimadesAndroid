package com.codelab.helmi.simades.kk;


import android.annotation.SuppressLint;
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

import com.bumptech.glide.Glide;
import com.codelab.helmi.simades.R;
import com.codelab.helmi.simades.penduduk.ShowPendudukFragment;

import java.util.ArrayList;
import java.util.List;


public class KkRecyclerAdapter extends RecyclerView.Adapter<KkRecyclerAdapter.MyHolder> implements Filterable {


    List<KkData> mList;
    List<KkData> mFilterList;
    Context ctx;
    FragmentManager fragmentManager;


    public KkRecyclerAdapter(Context ctx, List<KkData> mList, FragmentManager fragmentManager) {
        this.mList = mList;
        this.ctx = ctx;
        this.fragmentManager = fragmentManager;
        this.mFilterList = mList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_kk, parent, false);
        MyHolder holder = new MyHolder(layout);
        return holder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, final int position) {
        holder.no_kk.setText(mFilterList.get(position).getNo_kk());
        holder.alamat.setText(mFilterList.get(position).getAlamat());
        holder.tvRtRw.setText(mFilterList.get(position).getRt() + " / " + mFilterList.get(position).getRw());
        Glide.with(this.ctx).load(R.drawable.ic_collaboration).into(holder.ivKK);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowPendudukFragment showPendudukFragment = new ShowPendudukFragment();
                Bundle bundle = new Bundle();
                bundle.putString(showPendudukFragment.EXTRA_NO_KK, mFilterList.get(position).getNo_kk());
                showPendudukFragment.setArguments(bundle);
                fragmentManager.beginTransaction()
                        .replace(R.id.frame_container, showPendudukFragment, showPendudukFragment.getClass().getSimpleName())
                        .addToBackStack(showPendudukFragment.getClass().getSimpleName())
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
                    List<KkData> filteredList = new ArrayList<>();
                    for (KkData kkData : mList) {
                        if (kkData.getNo_kk().toLowerCase().contains(charString.toLowerCase()) || kkData.getAlamat().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(kkData);
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
                mFilterList = (List<KkData>) results.values;
                notifyDataSetChanged();

            }
        };
    }


    public class MyHolder extends RecyclerView.ViewHolder {
        TextView no_kk, alamat, tvRtRw;
        ImageView ivKK;


        public MyHolder(View v) {
            super(v);
            ivKK = v.findViewById(R.id.iv_kk);
            no_kk = v.findViewById(R.id.tv_no_kk);
            alamat = v.findViewById(R.id.tv_alamat);
            tvRtRw = v.findViewById(R.id.tv_rt_rw);


        }

    }
}
