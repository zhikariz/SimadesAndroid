package com.codelab.helmi.simades.user;

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

public class UserRecyclerAdapter extends RecyclerView.Adapter<UserRecyclerAdapter.MyHolder> {
    List<UserData> mList ;
    Context ctx;

    public UserRecyclerAdapter(Context ctx, List<UserData> mList) {
        this.mList = mList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public UserRecyclerAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_user,parent, false);
        MyHolder holder = new MyHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final UserRecyclerAdapter.MyHolder holder, final int position) {
        holder.nama.setText(mList.get(position).getNama_depan_user()+" "+mList.get(position).getNama_belakang_user());
        holder.username.setText(mList.get(position).getUsername());
        holder.status.setText(mList.get(position).getAktif());

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
        TextView nama, username, status;
        UserData userData;
        public MyHolder(View v)
        {
            super(v);

            nama  = (TextView) v.findViewById(R.id.tvNama);
            username = (TextView) v.findViewById(R.id.tvUsername);
            status = (TextView) v.findViewById(R.id.tvStatus);


        }

    }
}
