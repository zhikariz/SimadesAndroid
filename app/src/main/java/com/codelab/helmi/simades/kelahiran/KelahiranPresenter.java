package com.codelab.helmi.simades.kelahiran;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.codelab.helmi.simades.api.RestApi;
import com.codelab.helmi.simades.api.RestServer;
import com.codelab.helmi.simades.base.Presenter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KelahiranPresenter implements Presenter<KelahiranView> {

    private KelahiranView kelahiranView;
    public List<KelahiranData> mItems = new ArrayList<>();
    Context context;

    public KelahiranPresenter(Context context) {
        this.context = context;
    }

    @Override
    public void onAttach(KelahiranView view) {
        kelahiranView = view;
    }

    @Override
    public void onDetach() {
        kelahiranView = null;
    }

    public void showData() {
        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<KelahiranResponseModel> getData = api.getKelahiranData();
        getData.enqueue(new Callback<KelahiranResponseModel>() {
            @Override
            public void onResponse(Call<KelahiranResponseModel> call, Response<KelahiranResponseModel> response) {
                try {
                    if (response.isSuccessful()) {
                        mItems = response.body().getResult();
                        kelahiranView.setAdapter(mItems);
                        kelahiranView.swipeRefreshFalse();
                    } else {
                        switch (response.code()) {
                            case 404:
                                Toast.makeText(context, "404 Not Found", Toast.LENGTH_SHORT).show();
                                break;
                            case 500:
                                Toast.makeText(context, "500 Internal Server Error", Toast.LENGTH_SHORT).show();
                                break;
                            default:
                                Toast.makeText(context, "Unknown Error", Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    kelahiranView.swipeRefreshFalse();
                }
            }

            @Override
            public void onFailure(Call<KelahiranResponseModel> call, Throwable t) {
                kelahiranView.swipeRefreshFalse();
            }
        });
    }
}
