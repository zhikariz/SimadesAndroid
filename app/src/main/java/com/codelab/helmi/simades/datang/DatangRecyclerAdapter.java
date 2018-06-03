package com.codelab.helmi.simades.datang;

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

public class DatangRecyclerAdapter extends RecyclerView.Adapter<DatangRecyclerAdapter.MyHolder> {

    List<DatangData> mList;
    Context ctx;

    public DatangRecyclerAdapter(Context ctx, List<DatangData> mList) {
        this.mList = mList;
        this.ctx = ctx;
    }


    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_datang, parent, false);
        MyHolder holder = new MyHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder holder, int position) {
        holder.nik_pendatang.setText(mList.get(position).getNik_pendatang());
        holder.alamat_asal.setText(mList.get(position).getAlamat_asal());
        holder.alasan.setText(mList.get(position).getAlasan());
        holder.pengikut.setText(mList.get(position).getPengikut());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ctx, "" + holder.nik_pendatang.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView nik_pendatang, alamat_asal, alasan, pengikut;
        DatangData datangData;

        public MyHolder(View v) {
            super(v);
            nik_pendatang = (TextView) v.findViewById(R.id.tvNikPendatang);
            alamat_asal = (TextView) v.findViewById(R.id.tv_alamat_asal);
            alasan = (TextView) v.findViewById(R.id.tv_alasan);
            pengikut = (TextView) v.findViewById(R.id.tv_pengikut);


        }
    }
}
