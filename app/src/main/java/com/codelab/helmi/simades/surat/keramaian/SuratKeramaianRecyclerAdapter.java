package com.codelab.helmi.simades.surat.keramaian;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.codelab.helmi.simades.R;
import com.codelab.helmi.simades.surat.keramaian.detail.DetailSuratKeramaianFragment;

import java.util.List;

public class SuratKeramaianRecyclerAdapter extends RecyclerView.Adapter<SuratKeramaianRecyclerAdapter.MyHolder> {

    Context ctx;
    List<SuratKeramaianData> mList;
    FragmentManager fragmentManager;

    public SuratKeramaianRecyclerAdapter(Context ctx, List<SuratKeramaianData> mList, FragmentManager fragmentManager) {
        this.ctx = ctx;
        this.mList = mList;
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_surat_keramaian, parent, false);
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
        holder.pengaju.setText(mList.get(position).getNama_depan() + " "+mList.get(position).getNama_belakang());
        if(mList.get(position).getStatus_persetujuan().equals("Belum disetujui")){
            holder.status_persetujuan.setTextColor(Color.parseColor("#ff0000"));
        } else if (mList.get(position).getStatus_persetujuan().equals("Disetujui")) {
            holder.status_persetujuan.setTextColor(Color.parseColor("#008000"));
        }


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailSuratKeramaianFragment detailSuratKeramaianFragment = new DetailSuratKeramaianFragment();
                SuratKeramaianData suratKeramaianData = new SuratKeramaianData();

                suratKeramaianData.setKd_surat(mList.get(position).getKd_surat());
                suratKeramaianData.setNo_surat(mList.get(position).getNo_surat());
                suratKeramaianData.setTgl_surat(mList.get(position).getTgl_surat());
                suratKeramaianData.setStatus_persetujuan(mList.get(position).getStatus_persetujuan());
                suratKeramaianData.setNik(mList.get(position).getNik());
                suratKeramaianData.setNama_depan(mList.get(position).getNama_depan());
                suratKeramaianData.setNama_belakang(mList.get(position).getNama_belakang());
                suratKeramaianData.setNama_depan_user(mList.get(position).getNama_depan_user());
                suratKeramaianData.setNama_belakang_user(mList.get(position).getNama_belakang_user());

                Bundle bundle = new Bundle();
                bundle.putParcelable(DetailSuratKeramaianFragment.EXTRA_SURAT_IZIN_KERAMAIAN, suratKeramaianData);

                detailSuratKeramaianFragment.setArguments(bundle);
                fragmentManager.beginTransaction()
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .replace(R.id.frame_container, detailSuratKeramaianFragment, detailSuratKeramaianFragment.getClass().getSimpleName())
                        .addToBackStack(detailSuratKeramaianFragment.getClass().getSimpleName())
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
            kode_surat = v.findViewById(R.id.tv_kode_surat_keramaian);
            no_surat = v.findViewById(R.id.tv_nomor_surat_keramaian);
            tgl_surat = v.findViewById(R.id.tv_tanggal_surat_keramaian);
            status_persetujuan = v.findViewById(R.id.tv_status_persetujuan_surat_keramaian);
            pengaju = v.findViewById(R.id.tv_pengaju_surat_keramaian);
        }
    }
}
