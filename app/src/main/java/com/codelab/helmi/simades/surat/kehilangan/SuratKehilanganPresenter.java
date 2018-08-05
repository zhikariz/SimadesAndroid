package com.codelab.helmi.simades.surat.kehilangan;

import android.content.Context;
import android.widget.Toast;

import com.codelab.helmi.simades.helper.api.RestApi;
import com.codelab.helmi.simades.helper.api.RestServer;
import com.codelab.helmi.simades.base.Presenter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SuratKehilanganPresenter implements Presenter<SuratKehilanganView> {
    private SuratKehilanganView suratKehilanganView;
    public List<SuratKehilanganData> mItems = new ArrayList<>();
    private Context context;

    public SuratKehilanganPresenter(Context context) {
        this.context = context;
    }

    @Override
    public void onAttach(SuratKehilanganView view) {
        suratKehilanganView = view;
    }

    @Override
    public void onDetach() {
        suratKehilanganView = null;
    }

    public void showData() {
        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<SuratKehilanganResponseModel> getData = api.getSuratKehilanganData();
        getData.enqueue(new Callback<SuratKehilanganResponseModel>() {
            @Override
            public void onResponse(Call<SuratKehilanganResponseModel> call, Response<SuratKehilanganResponseModel> response) {
                try {
                    if (response.isSuccessful()) {
                        mItems = response.body().getResult();
                        suratKehilanganView.setAdapter(mItems);
                        suratKehilanganView.swipeRefreshFalse();
                    } else {
                        switch (response.code()) {
                            case 404:
                                Toast.makeText(context, "404 Not Found", Toast.LENGTH_SHORT).show();
                                suratKehilanganView.swipeRefreshFalse();
                                break;
                            case 500:
                                Toast.makeText(context, "500 Internal Server Error", Toast.LENGTH_SHORT).show();
                                suratKehilanganView.swipeRefreshFalse();
                                break;
                            default:
                                Toast.makeText(context, "Unknown Error", Toast.LENGTH_SHORT).show();
                                suratKehilanganView.swipeRefreshFalse();
                                break;
                        }
                    }
                } catch (Exception e)
                {
                    e.printStackTrace();
                    suratKehilanganView.swipeRefreshFalse();
                }
            }

            @Override
            public void onFailure(Call<SuratKehilanganResponseModel> call, Throwable t) {
                suratKehilanganView.swipeRefreshFalse();

            }
        });
    }
}
