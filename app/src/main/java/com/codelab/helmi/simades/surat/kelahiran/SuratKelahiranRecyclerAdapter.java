package com.codelab.helmi.simades.surat.kelahiran;

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

import com.codelab.helmi.simades.R;
import com.codelab.helmi.simades.surat.kelahiran.detail.DetailSuratKelahiranFragment;

import java.util.List;

public class SuratKelahiranRecyclerAdapter extends RecyclerView.Adapter<SuratKelahiranRecyclerAdapter.MyHolder> {

    List<SuratKelahiranData> mList;
    Context ctx;
    FragmentManager fragmentManager;

    public SuratKelahiranRecyclerAdapter(Context ctx, List<SuratKelahiranData> mList, FragmentManager fragmentManager) {
        this.mList = mList;
        this.ctx = ctx;
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_surat_kelahiran, parent, false);
        MyHolder holder = new MyHolder(layout);
        return holder;
    }

    @android.annotation.SuppressLint("SetTextI18n")@Override
    public void onBindViewHolder(@NonNull final MyHolder holder, final int position) {
        holder.kode_surat.setText(mList.get(position).getKd_surat());
        holder.no_surat.setText(mList.get(position).getNo_surat());
        holder.tgl_surat.setText(mList.get(position).getTgl_surat());
        holder.status_persetujuan.setText(mList.get(position).getStatus_persetujuan());
        holder.pengaju.setText(mList.get(position).getNama_depan() + mList.get(position).getNama_belakang());
        if (mList.get(position).getStatus_persetujuan().equals("Belum disetujui")) {
            holder.status_persetujuan.setTextColor(Color.parseColor("#ff0000"));
        } else if (mList.get(position).getStatus_persetujuan().equals("Disetujui")) {
            holder.status_persetujuan.setTextColor(Color.parseColor("#008000"));
        }


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailSuratKelahiranFragment detailSuratKelahiranFragment = new DetailSuratKelahiranFragment();
                SuratKelahiranData suratKelahiranData = new SuratKelahiranData();

                suratKelahiranData.setKd_surat(mList.get(position).getKd_surat());
                suratKelahiranData.setNo_surat(mList.get(position).getNo_surat());
                suratKelahiranData.setTgl_surat(mList.get(position).getTgl_surat());
                suratKelahiranData.setWaktu(mList.get(position).getWaktu());
                suratKelahiranData.setStatus_persetujuan(mList.get(position).getStatus_persetujuan());
                suratKelahiranData.setNik(mList.get(position).getNik());
                suratKelahiranData.setNama_depan(mList.get(position).getNama_depan());
                suratKelahiranData.setNama_belakang(mList.get(position).getNama_belakang());
                suratKelahiranData.setNama_depan_user(mList.get(position).getNama_depan_user());
                suratKelahiranData.setNama_belakang_user(mList.get(position).getNama_belakang_user());

                Bundle bundle = new Bundle();
                bundle.putParcelable(DetailSuratKelahiranFragment.EXTRA_SURAT_KELAHIRAN, suratKelahiranData);

                detailSuratKelahiranFragment.setArguments(bundle);
                fragmentManager.beginTransaction()
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .replace(R.id.frame_container, detailSuratKelahiranFragment, detailSuratKelahiranFragment.getClass().getSimpleName())
                        .addToBackStack(detailSuratKelahiranFragment.getClass().getSimpleName())
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
            kode_surat = v.findViewById(R.id.tv_kode_surat_kelahiran);
            no_surat = v.findViewById(R.id.tv_nomor_surat_kelahiran);
            tgl_surat = v.findViewById(R.id.tv_tanggal_surat_kelahiran);
            status_persetujuan = v.findViewById(R.id.tv_status_persetujuan_surat_kelahiran);
            pengaju = v.findViewById(R.id.tv_pengaju_surat_kelahiran);


        }
    }
}
