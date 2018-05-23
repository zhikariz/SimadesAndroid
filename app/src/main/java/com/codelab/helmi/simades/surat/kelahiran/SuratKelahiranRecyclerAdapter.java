package com.codelab.helmi.simades.surat.kelahiran;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codelab.helmi.simades.R;

import java.util.List;

public class SuratKelahiranRecyclerAdapter extends RecyclerView.Adapter<SuratKelahiranRecyclerAdapter.MyHolder>{

    List<SuratKelahiranData> mList;
    Context ctx;

    public SuratKelahiranRecyclerAdapter(Context ctx,List<SuratKelahiranData> mList) {
        this.mList = mList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_surat_kelahiran,parent,false);
        MyHolder holder = new MyHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        public MyHolder(View itemView) {
            super(itemView);
        }
    }
}
