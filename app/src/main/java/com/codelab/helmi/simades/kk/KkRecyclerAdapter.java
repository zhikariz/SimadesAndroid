package com.codelab.helmi.simades.kk;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.LauncherActivity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codelab.helmi.simades.R;
import com.codelab.helmi.simades.penduduk.PendudukData;
import com.codelab.helmi.simades.penduduk.ShowPendudukFragment;

import java.util.List;


public class KkRecyclerAdapter extends RecyclerView.Adapter<KkRecyclerAdapter.MyHolder> {


    List<KkData> mList,filterList;
    Context ctx;
    FragmentManager fragmentManager;


    public KkRecyclerAdapter(Context ctx, List<KkData> mList, FragmentManager fragmentManager) {
        this.mList = mList;
        this.ctx = ctx;
        this.fragmentManager = fragmentManager;
        this.filterList = mList;
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
    public void onBindViewHolder(@NonNull final KkRecyclerAdapter.MyHolder holder, final int position) {
        holder.no_kk.setText(mList.get(position).getNo_kk());
        holder.alamat.setText(mList.get(position).getAlamat());
        holder.tvRtRw.setText(mList.get(position).getRt() + " / " + mList.get(position).getRw());
        Glide.with(this.ctx).load(R.drawable.ic_collaboration).into(holder.ivKK);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowPendudukFragment showPendudukFragment = new ShowPendudukFragment();
                Bundle bundle = new Bundle();
                bundle.putString(showPendudukFragment.EXTRA_NO_KK, mList.get(position).getNo_kk());
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
        return mList.size();
    }


    public class MyHolder extends RecyclerView.ViewHolder {
        TextView no_kk, alamat, id_dusun, tvRtRw, rw, kelurahan, kecamatan, kabupaten, propinsi;
        PendudukData pendudukData;
        ImageView ivKK;


        public MyHolder(View v) {
            super(v);
            ivKK = (ImageView) v.findViewById(R.id.iv_kk);
            no_kk = (TextView) v.findViewById(R.id.tv_no_kk);
            alamat = (TextView) v.findViewById(R.id.tv_alamat);
            tvRtRw = (TextView) v.findViewById(R.id.tv_rt_rw);


        }

    }
}
