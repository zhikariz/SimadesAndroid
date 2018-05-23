package com.codelab.helmi.simades.pergi;

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

public class PergiRecyclerAdapter extends RecyclerView.Adapter<PergiRecyclerAdapter.MyHolder>{

    List<PergiData> mList;
    Context ctx;

    public PergiRecyclerAdapter(Context ctx, List<PergiData> mList){
        this.mList = mList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_pergi,parent, false);
        MyHolder holder = new MyHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder holder, int position) {
        holder.nik_pergi.setText(mList.get(position).getNik_pergi());
        holder.alamat_tuju.setText(mList.get(position).getAlamat_tuju());
        holder.alasan.setText(mList.get(position).getAlasan());
        holder.tgl_pergi.setText(mList.get(position).getTgl_pergi());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ctx, ""+holder.nik_pergi.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount(){
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView nik_pergi, alamat_tuju, kode_pos,alasan, tgl_pergi;
        PergiData pergiData;
        public MyHolder(View v){
            super(v);

            nik_pergi = (TextView) v.findViewById(R.id.tvNikPergi);
            alamat_tuju = (TextView) v.findViewById(R.id.tvAlamatTujuan);
            alasan = (TextView) v.findViewById(R.id.tvAlasan);
            tgl_pergi = (TextView) v.findViewById(R.id.tvTglPergi);
        }
    }
}
