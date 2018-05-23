package com.codelab.helmi.simades.kelahiran;

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

public class KelahiranRecyclerAdapter extends RecyclerView.Adapter<KelahiranRecyclerAdapter.MyHolder> {

    List<KelahiranData> mList ;
    Context ctx;

    public KelahiranRecyclerAdapter(Context ctx, List<KelahiranData> mList) {
        this.mList = mList;
        this.ctx = ctx;
    }


    @NonNull
    @Override
    public KelahiranRecyclerAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_kelahiran,parent, false);
        MyHolder holder = new MyHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final KelahiranRecyclerAdapter.MyHolder holder, int position) {
        holder.nis.setText(mList.get(position).getNis_bayi());
        holder.nama.setText(mList.get(position).getNama_depan_bayi() + " " + mList.get(position).getNama_belakang_bayi());
        holder.tgllahir.setText(mList.get(position).getTgl_lahir());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ctx, ""+holder.nama.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView nis, nama, tgllahir;
        KelahiranData kelahiranData;
        public MyHolder(View v)
        {
            super(v);

            nis = (TextView) v.findViewById(R.id.tvNisBayi);
            nama = (TextView) v.findViewById(R.id.tvNamaBayi);
            tgllahir = (TextView) v.findViewById(R.id.tvTTLBayi);


        }

    }
}
