package com.codelab.helmi.simades.surat.usaha;

import android.annotation.SuppressLint;

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
import android.widget.TextView;
import android.widget.Toast;

import com.codelab.helmi.simades.R;
import com.codelab.helmi.simades.surat.usaha.detail.DetailSuratUsahaFragment;

import java.util.List;

public class SuratUsahaRecyclerAdapter extends RecyclerView.Adapter<SuratUsahaRecyclerAdapter.MyHolder> {

    List<SuratUsahaData> mList;
    Context ctx;
    FragmentManager fragmentManager;

    public SuratUsahaRecyclerAdapter(Context ctx, List<SuratUsahaData> mList, FragmentManager fragmentManager) {
        this.mList = mList;
        this.ctx = ctx;
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_surat_usaha, parent, false);
        MyHolder holder = new MyHolder(layout);
        return holder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull final MyHolder holder, final int position) {
        holder.kode_surat.setText(mList.get(position).getKd_surat());
        holder.no_surat.setText(mList.get(position).getNo_surat());
        holder.tgl_surat.setText(mList.get(position).getTgl_surat());
        holder.status_persetujuan.setText(mList.get(position).getStatus_persetujuan());
        holder.pengaju.setText(mList.get(position).getNama_depan() + " "+ mList.get(position).getNama_belakang());

        holder.pengaju.setText(mList.get(position).getNama_depan() + " " + mList.get(position).getNama_belakang());
        if (mList.get(position).getStatus_persetujuan().equals("Belum disetujui")) {
            holder.status_persetujuan.setTextColor(Color.parseColor("#ff0000"));
        } else if (mList.get(position).getStatus_persetujuan().equals("Disetujui")) {
            holder.status_persetujuan.setTextColor(Color.parseColor("#008000"));
        }


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailSuratUsahaFragment detailSuratUsahaFragment = new DetailSuratUsahaFragment();
                SuratUsahaData suratUsahaData = new SuratUsahaData();


                suratUsahaData.setKd_surat(mList.get(position).getKd_surat());
                suratUsahaData.setNo_surat(mList.get(position).getNo_surat());
                suratUsahaData.setTgl_surat(mList.get(position).getTgl_surat());
                suratUsahaData.setWaktu(mList.get(position).getWaktu());
                suratUsahaData.setStatus_persetujuan(mList.get(position).getStatus_persetujuan());
                suratUsahaData.setNik(mList.get(position).getNik());
                suratUsahaData.setNama_usaha(mList.get(position).getNama_usaha());
                suratUsahaData.setKeperluan(mList.get(position).getKeperluan());
                suratUsahaData.setTgl_mulai(mList.get(position).getTgl_mulai());
                suratUsahaData.setTgl_akhir(mList.get(position).getTgl_akhir());
                suratUsahaData.setNama_depan(mList.get(position).getNama_depan());
                suratUsahaData.setNama_belakang(mList.get(position).getNama_belakang());
                suratUsahaData.setNama_depan_user(mList.get(position).getNama_depan_user());
                suratUsahaData.setNama_belakang_user(mList.get(position).getNama_belakang_user());

                Bundle bundle = new Bundle();
                bundle.putParcelable(DetailSuratUsahaFragment.EXTRA_SURAT_USAHA, suratUsahaData);

                detailSuratUsahaFragment.setArguments(bundle);
                fragmentManager.beginTransaction()
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .replace(R.id.frame_container, detailSuratUsahaFragment,detailSuratUsahaFragment.getClass().getSimpleName())
                        .addToBackStack(detailSuratUsahaFragment.getClass().getSimpleName())
                        .commit();




//                Toast.makeText(ctx, "" + holder.no_surat.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView id_surat, kode_surat, no_surat, jenis_surat;
        TextView tgl_surat, waktu, status_persetujuan, pengaju;

        public MyHolder(View v) {
            super(v);
            kode_surat = v.findViewById(R.id.tv_kode_surat_usaha);
            no_surat = v.findViewById(R.id.tv_nomor_surat_usaha);
            tgl_surat = v.findViewById(R.id.tv_tanggal_surat_usaha);
            status_persetujuan = v.findViewById(R.id.tv_status_persetujuan_surat_usaha);
            pengaju = v.findViewById(R.id.tv_pengaju_surat_usaha);

        }
    }
}
