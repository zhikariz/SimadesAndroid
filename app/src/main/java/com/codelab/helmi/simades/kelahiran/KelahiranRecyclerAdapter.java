package com.codelab.helmi.simades.kelahiran;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.codelab.helmi.simades.R;
import com.codelab.helmi.simades.kelahiran.detail.DetailKelahiranFragment;

import java.util.List;

public class KelahiranRecyclerAdapter extends RecyclerView.Adapter<KelahiranRecyclerAdapter.MyHolder> {

    List<KelahiranData> mList;
    Context ctx;
    FragmentManager fragmentManager;

    public KelahiranRecyclerAdapter(Context ctx, List<KelahiranData> mList, FragmentManager fragmentManager) {
        this.mList = mList;
        this.ctx = ctx;
        this.fragmentManager = fragmentManager;
    }


    @NonNull
    @Override
    public KelahiranRecyclerAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_kelahiran, parent, false);
        MyHolder holder = new MyHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final KelahiranRecyclerAdapter.MyHolder holder, final int position) {
        holder.nis.setText(mList.get(position).getNis_bayi());
        holder.nama.setText(mList.get(position).getNama_depan_bayi() + " " + mList.get(position).getNama_belakang_bayi());
        holder.tgllahir.setText(mList.get(position).getTgl_lahir());
        if(mList.get(position).getJekel().equals("Laki-laki")) {
            Glide.with(this.ctx).load(R.drawable.ic_baby_boy).into(holder.ivKelahiran);
        }else if(mList.get(position).getJekel().equals("Perempuan")){
            Glide.with(this.ctx).load(R.drawable.ic_baby_girl).into(holder.ivKelahiran);
        }



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailKelahiranFragment detailKelahiranFragment = new DetailKelahiranFragment();
                KelahiranData kelahiranData = new KelahiranData();

                kelahiranData.setId_lahir(mList.get(position).getId_lahir());
                kelahiranData.setNis_bayi(mList.get(position).getNis_bayi());
                kelahiranData.setNama_depan_bayi(mList.get(position).getNama_depan_bayi());
                kelahiranData.setNama_belakang_bayi(mList.get(position).getNama_belakang_bayi());
                kelahiranData.setTgl_lahir(mList.get(position).getTgl_lahir());
                kelahiranData.setTpt_lahir(mList.get(position).getTpt_lahir());
                kelahiranData.setJekel(mList.get(position).getJekel());
                kelahiranData.setBerat_bayi(mList.get(position).getBerat_bayi());
                kelahiranData.setAnak_ke(mList.get(position).getAnak_ke());
                kelahiranData.setWaktu(mList.get(position).getWaktu());
                kelahiranData.setPanjang_bayi(mList.get(position).getPanjang_bayi());
                kelahiranData.setNik_ayah(mList.get(position).getNik_ayah());
                kelahiranData.setNama_depan_ayah(mList.get(position).getNama_depan_ayah());
                kelahiranData.setNama_belakang_ayah(mList.get(position).getNama_belakang_ayah());
                kelahiranData.setNik_ibu(mList.get(position).getNik_ibu());
                kelahiranData.setNama_depan_ibu(mList.get(position).getNama_depan_ibu());
                kelahiranData.setNama_belakang_ibu(mList.get(position).getNama_belakang_ibu());
                kelahiranData.setNik_saksi1(mList.get(position).getNik_saksi1());
                kelahiranData.setNama_depan_saksi1(mList.get(position).getNama_depan_saksi1());
                kelahiranData.setNama_belakang_saksi1(mList.get(position).getNama_belakang_saksi1());
                kelahiranData.setNik_saksi2(mList.get(position).getNik_saksi2());
                kelahiranData.setNama_depan_saksi2(mList.get(position).getNama_depan_saksi2());
                kelahiranData.setNama_belakang_saksi2(mList.get(position).getNama_belakang_saksi2());

                Bundle bundle = new Bundle();
                bundle.putParcelable(DetailKelahiranFragment.EXTRA_KELAHIRAN, kelahiranData);

                detailKelahiranFragment.setArguments(bundle);
                fragmentManager.beginTransaction()
                        .replace(R.id.frame_container, detailKelahiranFragment, detailKelahiranFragment.getClass().getSimpleName())
                        .addToBackStack(detailKelahiranFragment.getClass().getSimpleName())
                        .commit();


//                Toast.makeText(ctx, "" + holder.nama.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView nis, nama, tgllahir;
        ImageView ivKelahiran;
        KelahiranData kelahiranData;

        public MyHolder(View v) {
            super(v);

            nis = (TextView) v.findViewById(R.id.tvNisBayi);
            nama = (TextView) v.findViewById(R.id.tvNamaBayi);
            tgllahir = (TextView) v.findViewById(R.id.tvTTLBayi);
            ivKelahiran = (ImageView) v.findViewById(R.id.iv_kelahiran_kelahiran);


        }

    }
}
