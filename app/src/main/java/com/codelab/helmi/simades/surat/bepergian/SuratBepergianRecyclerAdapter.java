package com.codelab.helmi.simades.surat.bepergian;

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
import com.codelab.helmi.simades.surat.bepergian.detail.DetailSuratBepergianFragment;

import java.util.List;

public class SuratBepergianRecyclerAdapter extends RecyclerView.Adapter<SuratBepergianRecyclerAdapter.MyHolder> {

    Context ctx;
    List<SuratBepergianData> mList;
    FragmentManager fragmentManager;

    public SuratBepergianRecyclerAdapter(Context ctx, List<SuratBepergianData> mList, FragmentManager fragmentManager) {
        this.ctx = ctx;
        this.mList = mList;
        this.fragmentManager = fragmentManager;
    }


    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_surat_bepergian, parent, false);
        MyHolder holder = new MyHolder(layout);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder holder, final int position) {
        holder.kode_surat.setText(mList.get(position).getKd_surat());
        holder.no_surat.setText(mList.get(position).getNo_surat());
        holder.tgl_surat.setText(mList.get(position).getTgl_surat());
        holder.status_persetujuan.setText(mList.get(position).getStatus_persetujuan());
        holder.pengaju.setText(mList.get(position).getNama_depan() + " " + mList.get(position).getNama_belakang());
        if (mList.get(position).getStatus_persetujuan().equals("Belum disetujui")) {
            holder.status_persetujuan.setTextColor(Color.parseColor("#ff0000"));
        } else if (mList.get(position).getStatus_persetujuan().equals("Disetujui")) {
            holder.status_persetujuan.setTextColor(Color.parseColor("#008000"));
        }


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailSuratBepergianFragment detailSuratBepergianFragment = new DetailSuratBepergianFragment();
                SuratBepergianData suratBepergianData = new SuratBepergianData();

                suratBepergianData.setKd_surat(mList.get(position).getKd_surat());
                suratBepergianData.setNo_surat(mList.get(position).getNo_surat());
                suratBepergianData.setTgl_surat(mList.get(position).getTgl_surat());
                suratBepergianData.setStatus_persetujuan(mList.get(position).getStatus_persetujuan());
                suratBepergianData.setNik(mList.get(position).getNik());
                suratBepergianData.setNama_depan(mList.get(position).getNama_depan());
                suratBepergianData.setNama_belakang(mList.get(position).getNama_belakang());
                suratBepergianData.setNama_depan_user(mList.get(position).getNama_depan_user());
                suratBepergianData.setNama_belakang_user(mList.get(position).getNama_belakang_user());

                Bundle bundle = new Bundle();
                bundle.putParcelable(DetailSuratBepergianFragment.EXTRA_SURAT_BEPERGIAN, suratBepergianData);

                detailSuratBepergianFragment.setArguments(bundle);
                fragmentManager.beginTransaction()
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .replace(R.id.frame_container, detailSuratBepergianFragment, detailSuratBepergianFragment.getClass().getSimpleName())
                        .addToBackStack(detailSuratBepergianFragment.getClass().getSimpleName())
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
        TextView tgl_surat, waktu, status_persetujuan,pengaju;

        public MyHolder(View v) {
            super(v);
            kode_surat = v.findViewById(R.id.tv_kode_surat_bepergian);
            no_surat = v.findViewById(R.id.tv_nomor_surat_bepergian);
            tgl_surat = v.findViewById(R.id.tv_tanggal_surat_bepergian);
            status_persetujuan = v.findViewById(R.id.tv_status_persetujuan_surat_bepergian);
            pengaju = v.findViewById(R.id.tv_pengaju_surat_bepergian);
        }
    }
}
