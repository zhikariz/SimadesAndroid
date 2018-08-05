package com.codelab.helmi.simades.datang;

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

public class DatangPresenter implements Presenter<DatangView> {

    Context context;
    private DatangView datangView;

    public List<DatangData> mItems = new ArrayList<>();

    public DatangPresenter(Context context) {
        this.context = context;
    }

    @Override
    public void onAttach(DatangView view) {
        datangView = view;
    }

    @Override
    public void onDetach() {
        datangView = null;
    }

    public void showData() {
        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<DatangResponseModel> getData = api.getDatangData();
        getData.enqueue(new Callback<DatangResponseModel>() {
            @Override
            public void onResponse(Call<DatangResponseModel> call, Response<DatangResponseModel> response) {
                try {
                    if (response.isSuccessful()) {
                        mItems = response.body().getResult();
                        datangView.setAdapter(mItems);
                        datangView.swipeRefreshFalse();
                    } else {
                        switch (response.code()) {
                            case 404:
                                Toast.makeText(context, "404 Not Found", Toast.LENGTH_SHORT).show();
                                datangView.swipeRefreshFalse();
                                break;
                            case 500:
                                Toast.makeText(context, "500 Internal Server Error", Toast.LENGTH_SHORT).show();
                                datangView.swipeRefreshFalse();
                                break;
                            default:
                                Toast.makeText(context, "Unknown Error", Toast.LENGTH_SHORT).show();
                                datangView.swipeRefreshFalse();
                                break;
                        }
                    }
                } catch (Exception e){
                    e.printStackTrace();
                    datangView.swipeRefreshFalse();
                }
            }

            @Override
            public void onFailure(Call<DatangResponseModel> call, Throwable t) {
                datangView.swipeRefreshFalse();
            }
        });

    }
}
