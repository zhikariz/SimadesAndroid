package com.codelab.helmi.simades.surat.skck;



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

public class SuratSkckPresenter implements Presenter<SuratSkckView> {

    private SuratSkckView suratSkckView;
    public List<SuratSkckData> mItems = new ArrayList<>();
    Context context;

    public SuratSkckPresenter(Context context) {
        this.context = context;
    }

    @Override
    public void onAttach(SuratSkckView view) {
        suratSkckView = view;
    }

    @Override
    public void onDetach() {
        suratSkckView = null;
    }

    public void showData() {
        final SuratSkckData suratSkckData = new SuratSkckData();
        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<SuratSkckResponseModel> getData = api.getSuratPengantarSkckData();
        getData.enqueue(new Callback<SuratSkckResponseModel>() {
            @Override
            public void onResponse(Call<SuratSkckResponseModel> call, Response<SuratSkckResponseModel> response) {
                if (response.isSuccessful()) {
                    mItems = response.body().getResult();
                    suratSkckView.setAdapter(mItems);
                    suratSkckView.swipeRefreshFalse();
                }else{
                    switch (response.code()) {
                        case 404:
                            Toast.makeText(context, "404 Not Found", Toast.LENGTH_SHORT).show();
                            suratSkckView.swipeRefreshFalse();
                            break;
                        case 500:
                            Toast.makeText(context, "500 Internal Server Error", Toast.LENGTH_SHORT).show();
                            suratSkckView.swipeRefreshFalse();
                            break;
                        default:
                            Toast.makeText(context, "Unknown Error", Toast.LENGTH_SHORT).show();
                            suratSkckView.swipeRefreshFalse();
                            break;
                    }
                }
            }

            @Override
            public void onFailure(Call<SuratSkckResponseModel> call, Throwable t) {
                suratSkckView.swipeRefreshFalse();
            }
        });
    }
}
