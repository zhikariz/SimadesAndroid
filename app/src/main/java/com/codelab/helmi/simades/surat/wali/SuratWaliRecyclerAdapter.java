package com.codelab.helmi.simades.surat.wali;

import android.content.Context;
import android.graphics.Color;
import android.media.FaceDetector;
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
import com.codelab.helmi.simades.surat.wali.detail.DetailSuratWaliFragment;

import java.util.List;

public class SuratWaliRecyclerAdapter extends RecyclerView.Adapter<SuratWaliRecyclerAdapter.MyHolder> {
    Context ctx;
    List<SuratWaliData> mList;
    FragmentManager fragmentManager;

    public SuratWaliRecyclerAdapter(Context ctx, List<SuratWaliData> mList, FragmentManager fragmentManager) {
        this.ctx = ctx;
        this.mList = mList;
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_surat_wali, parent, false);
        MyHolder holder = new MyHolder(layout);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder holder, final int position) {
        holder.kode_surat.setText(mList.get(position).getKd_surat());
        holder.no_surat.setText(mList.get(position).getNo_surat());
        holder.tgl_surat.setText(mList.get(position).getTgl_surat());
        holder.status_persetujuan.setText(mList.get(position).getStatus_persetujuan());
        holder.pengaju.setText(mList.get(position).getNama_depan_wali()+mList.get(position).getNama_belakang_wali());
        if(mList.get(position).getStatus_persetujuan().equals("Belum disetujui")){
            holder.status_persetujuan.setTextColor(Color.parseColor("#ff0000"));
        } else if(mList.get(position).getStatus_persetujuan().equals("Disetujui")){
            holder.status_persetujuan.setTextColor(Color.parseColor("#008000"));
        }


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailSuratWaliFragment detailSuratWaliFragment = new DetailSuratWaliFragment();
                SuratWaliData suratWaliData = new SuratWaliData();

                suratWaliData.setKd_surat(mList.get(position).getKd_surat());
                suratWaliData.setNo_surat(mList.get(position).getNo_surat());
                suratWaliData.setTgl_surat(mList.get(position).getTgl_surat());
                suratWaliData.setStatus_persetujuan(mList.get(position).getStatus_persetujuan());
                suratWaliData.setNik(mList.get(position).getNik());
                suratWaliData.setNama_depan_wali(mList.get(position).getNama_depan_wali());
                suratWaliData.setNama_belakang_wali(mList.get(position).getNama_belakang_wali());
                suratWaliData.setNama_depan_user(mList.get(position).getNama_depan_user());
                suratWaliData.setNama_belakang_user(mList.get(position).getNama_belakang_user());

                Bundle bundle = new Bundle();
                bundle.putParcelable(DetailSuratWaliFragment.EXTRA_SURAT_WALI, suratWaliData);

                detailSuratWaliFragment.setArguments(bundle);
                fragmentManager.beginTransaction()
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .replace(R.id.frame_container, detailSuratWaliFragment, detailSuratWaliFragment.getClass().getSimpleName())
                        .addToBackStack(detailSuratWaliFragment.getClass().getSimpleName())
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
            kode_surat = v.findViewById(R.id.tv_kode_surat_wali);
            no_surat = v.findViewById(R.id.tv_nomor_surat_wali);
            tgl_surat = v.findViewById(R.id.tv_tanggal_surat_wali);
            status_persetujuan = v.findViewById(R.id.tv_status_persetujuan_surat_wali);
            pengaju = v.findViewById(R.id.tv_pengaju_surat_wali);
        }
    }


}
