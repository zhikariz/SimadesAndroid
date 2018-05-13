package com.codelab.helmi.simades.kematian;

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


public class KematianRecyclerAdapter extends RecyclerView.Adapter<KematianRecyclerAdapter.MyHolder> {

    List<KematianData> mList;
    Context ctx;

    public KematianRecyclerAdapter(Context ctx, List<KematianData> mList){
        this.mList = mList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_kematian,parent, false);
        MyHolder holder = new MyHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder holder, int position) {
        holder.nik_meninggal.setText(mList.get(position).getNik_meninggal());
        holder.tgl_meninggal.setText(mList.get(position).getTgl_meninggal());
        holder.sebab.setText(mList.get(position).getSebab());
        holder.tpt_meninggal.setText(mList.get(position).getTpt_meninggal());
        holder.menerangkan.setText(mList.get(position).getMenerangkan());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ctx, ""+holder.nik_meninggal.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView nik_meninggal, tgl_meninggal, sebab, tpt_meninggal, menerangkan;
        KematianData kematianData;

        public MyHolder(View v){
            super(v);

            nik_meninggal = (TextView) v.findViewById(R.id.tvNikMeninggal);
            tgl_meninggal = (TextView) v.findViewById(R.id.tvTglMeninggal);
            sebab = (TextView) v.findViewById(R.id.tvSebab);
            tpt_meninggal = (TextView) v.findViewById(R.id.tvTempatMeninggal);
            menerangkan = (TextView) v.findViewById(R.id.tvMenerangkan);
        }
    }
}
