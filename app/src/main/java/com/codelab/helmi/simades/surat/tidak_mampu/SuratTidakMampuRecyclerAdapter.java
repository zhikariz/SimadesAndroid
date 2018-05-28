package com.codelab.helmi.simades.surat.tidak_mampu;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.codelab.helmi.simades.R;
import com.codelab.helmi.simades.api.RestApi;

import java.util.List;

public class SuratTidakMampuRecyclerAdapter extends RecyclerView.Adapter<SuratTidakMampuRecyclerAdapter.MyHolder>{
    Context ctx;
    List<SuratTidakMampuData> mList;

    public SuratTidakMampuRecyclerAdapter(Context ctx, List<SuratTidakMampuData> mList) {
        this.ctx = ctx;
        this.mList = mList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_surat_tidak_mampu,parent,false);
        MyHolder holder = new MyHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder holder, int position) {
        holder.kode_surat.setText(mList.get(position).getKd_surat());
        holder.no_surat.setText(mList.get(position).getNo_surat());
        holder.tgl_surat.setText(mList.get(position).getTgl_surat());
        holder.status_persetujuan.setText(mList.get(position).getStatus_persetujuan());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ctx, ""+holder.no_surat.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        TextView id_surat, kode_surat, no_surat, jenis_surat;
        TextView tgl_surat, waktu, status_persetujuan;

        public MyHolder(View v) {
            super(v);
            kode_surat = v.findViewById(R.id.tv_kode_surat_tidak_mampu);
            no_surat = v.findViewById(R.id.tv_nomor_surat_tidak_mampu);
            tgl_surat = v.findViewById(R.id.tv_tanggal_surat_tidak_mampu);
            status_persetujuan = v.findViewById(R.id.tv_status_persetujuan_surat_tidak_mampu);
        }
    }
}