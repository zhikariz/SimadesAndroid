package com.codelab.helmi.simades.penduduk;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.codelab.helmi.simades.R;


import java.util.List;


public class PendudukRecyclerAdapter extends RecyclerView.Adapter<PendudukRecyclerAdapter.MyHolder> {


    List<PendudukData> mList ;
    Context ctx;

    public PendudukRecyclerAdapter(Context ctx, List<PendudukData> mList) {
        this.mList = mList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_penduduk,parent, false);
        MyHolder holder = new MyHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final PendudukRecyclerAdapter.MyHolder holder, int position) {
        holder.nik.setText(mList.get(position).getNik());
        holder.nokk.setText(mList.get(position).getNo_kk());
        holder.nama.setText(mList.get(position).getNama_depan() + " " + mList.get(position).getNama_belakang());
        holder.jekel.setText(mList.get(position).getJekel());
        holder.umur.setText(mList.get(position).getUmur());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ctx, ""+holder.nama.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView nik, nokk, nama, jekel, umur;
        PendudukData pendudukData;
        public MyHolder(View v)
        {
            super(v);

            nik = (TextView) v.findViewById(R.id.tvNik);
            nokk = (TextView) v.findViewById(R.id.tvNoKK);
            nama = (TextView) v.findViewById(R.id.tvNamaPenduduk);
            jekel = (TextView) v.findViewById(R.id.tvJekel);
            umur = (TextView) v.findViewById(R.id.tvUmur);


        }

    }
}
