package com.codelab.helmi.simades.pergi;

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

public class PergiPresenter implements Presenter<PergiView> {

    private PergiView pergiView;
    private Context context;
    private List<PergiData> mItems = new ArrayList<>();

    public PergiPresenter(Context context) {
        this.context = context;
    }

    @Override
    public void onAttach(PergiView view) {
        pergiView = view;
    }

    @Override
    public void onDetach() {
        pergiView = null;
    }

    public void showData() {
        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<PergiResponseModel> getData = api.getPergiData();
        getData.enqueue(new Callback<PergiResponseModel>() {
            @Override
            public void onResponse(Call<PergiResponseModel> call, Response<PergiResponseModel> response) {
                try {
                    if (response.isSuccessful()) {
                        mItems = response.body().getResult();
                        pergiView.setAdapter(mItems);
                        pergiView.swipeRefreshFalse();

                    } else {
                        switch (response.code()) {
                            case 404:
                                Toast.makeText(context, "404 Not Found", Toast.LENGTH_SHORT).show();
                                pergiView.swipeRefreshFalse();
                                break;
                            case 500:
                                Toast.makeText(context, "500 Internal Server Error", Toast.LENGTH_SHORT).show();
                                pergiView.swipeRefreshFalse();
                                break;
                            default:
                                Toast.makeText(context, "Unknown Error", Toast.LENGTH_SHORT).show();
                                pergiView.swipeRefreshFalse();
                                break;
                        }
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    pergiView.swipeRefreshFalse();
                }
            }

            @Override
            public void onFailure(Call<PergiResponseModel> call, Throwable t) {
                pergiView.swipeRefreshFalse();
            }
        });

    }
}
