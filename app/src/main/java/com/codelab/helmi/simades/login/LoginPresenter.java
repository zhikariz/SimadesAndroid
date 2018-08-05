package com.codelab.helmi.simades.login;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.codelab.helmi.simades.helper.api.RestApi;
import com.codelab.helmi.simades.helper.api.RestServer;
import com.codelab.helmi.simades.helper.shared_preference.SharedPrefManager;
import com.codelab.helmi.simades.base.Presenter;
import com.codelab.helmi.simades.navigasi.NavigateActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter implements Presenter<LoginView> {
    LoginView loginView;
    Context context;
    SharedPrefManager sharedPrefManager;

    public LoginPresenter(Context context) {
        this.context = context;
    }

    @Override
    public void onAttach(LoginView view) {
        loginView = view;
    }

    @Override
    public void onDetach() {
        loginView = null;
    }

    public void login(String username, String password) {
        sharedPrefManager = new SharedPrefManager(context);
        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<LoginResponseModel> postLogin = api.postLogin(username, password);
        postLogin.enqueue(new Callback<LoginResponseModel>() {
            @Override
            public void onResponse(Call<LoginResponseModel> call, Response<LoginResponseModel> response) {
                try {
                    if (response.isSuccessful()) {
                        Toast.makeText(context, response.body().getResult().get(0).getStatus(), Toast.LENGTH_SHORT).show();
                        sharedPrefManager.saveSPString(SharedPrefManager.SP_USERNAME, response.body().getResult().get(0).getUsername());
                        sharedPrefManager.saveSPString(SharedPrefManager.SP_NAMA_USER, response.body().getResult().get(0).getNamaDepanUser() +" "+ response.body().getResult().get(0).getNamaBelakangUser());
                        sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN, true);
                        if(response.body().getResult().get(0).getStatus().equals("Login Berhasil")){
                            Intent i = new Intent(context, NavigateActivity.class);
                            context.startActivity(i);
                            ((LoginActivity) context).finish();
                        }


                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<LoginResponseModel> call, Throwable t) {

            }
        });
    }
}
