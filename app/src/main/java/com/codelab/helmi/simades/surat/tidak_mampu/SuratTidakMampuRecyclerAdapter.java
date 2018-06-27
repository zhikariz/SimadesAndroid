package com.codelab.helmi.simades.surat.tidak_mampu;

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
import com.codelab.helmi.simades.surat.tidak_mampu.detail.DetailSuratTidakMampuFragment;

import java.util.List;

public class SuratTidakMampuRecyclerAdapter extends RecyclerView.Adapter<SuratTidakMampuRecyclerAdapter.MyHolder> {
    Context ctx;
    List<SuratTidakMampuData> mList;
    FragmentManager fragmentManager;

    public SuratTidakMampuRecyclerAdapter(Context ctx, List<SuratTidakMampuData> mList, FragmentManager fragmentManager) {
        this.ctx = ctx;
        this.mList = mList;
        this.fragmentManager = fragmentManager;

    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_surat_tidak_mampu, parent, false);
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
                DetailSuratTidakMampuFragment detailSuratTidakMampuFragment = new DetailSuratTidakMampuFragment();
                SuratTidakMampuData suratTidakMampuData = new SuratTidakMampuData();

                suratTidakMampuData.setKd_surat(mList.get(position).getKd_surat());
                suratTidakMampuData.setNo_surat(mList.get(position).getNo_surat());
                suratTidakMampuData.setTgl_surat(mList.get(position).getTgl_surat());
                suratTidakMampuData.setStatus_persetujuan(mList.get(position).getStatus_persetujuan());
                suratTidakMampuData.setNik(mList.get(position).getNik());
                suratTidakMampuData.setNama_depan(mList.get(position).getNama_depan());
                suratTidakMampuData.setNama_belakang(mList.get(position).getNama_belakang());
                suratTidakMampuData.setNama_depan_user(mList.get(position).getNama_depan_user());
                suratTidakMampuData.setNama_belakang_user(mList.get(position).getNama_belakang_user());

                Bundle bundle = new Bundle();
                bundle.putParcelable(DetailSuratTidakMampuFragment.EXTRA_SURAT_TIDAK_MAMPU, suratTidakMampuData);

                detailSuratTidakMampuFragment.setArguments(bundle);
                fragmentManager.beginTransaction()
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .replace(R.id.frame_container, detailSuratTidakMampuFragment, detailSuratTidakMampuFragment.getClass().getSimpleName())
                        .addToBackStack(detailSuratTidakMampuFragment.getClass().getSimpleName())
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
            kode_surat = v.findViewById(R.id.tv_kode_surat_tidak_mampu);
            no_surat = v.findViewById(R.id.tv_nomor_surat_tidak_mampu);
            tgl_surat = v.findViewById(R.id.tv_tanggal_surat_tidak_mampu);
            status_persetujuan = v.findViewById(R.id.tv_status_persetujuan_surat_tidak_mampu);
            pengaju = v.findViewById(R.id.tv_pengaju_surat_tidak_mampu);
        }
    }
}

