package com.codelab.helmi.simades.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.codelab.helmi.simades.R;
import com.codelab.helmi.simades.helper.api.RestServer;
import com.codelab.helmi.simades.helper.shared_preference.SharedPrefManager;
import com.codelab.helmi.simades.navigasi.NavigateActivity;
import com.google.firebase.messaging.FirebaseMessaging;

public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener {

    ImageView ivLogin;
    LoginPresenter presenter;
    private EditText edtUsername;
    private EditText edtPassword;
    private Button btnLogin;
    SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        initPresenter();
        onAttachView();
        FirebaseMessaging.getInstance().subscribeToTopic("android");

        sharedPrefManager = new SharedPrefManager(this);
        if(sharedPrefManager.getSPSudahLogin())
        {
            startActivity(new Intent(this, NavigateActivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
            finish();
        }


        Glide.with(this).load(RestServer.getBase_url() + "uploads/image/Logo_karanganyar3.png").into(ivLogin);
    }


    public void initPresenter()
    {
        presenter = new LoginPresenter(this);
    }

    @Override
    public void onAttachView() {
        presenter.onAttach(this);
    }

    @Override
    public void onDetachView() {
        presenter.onDetach();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        onDetachView();
    }

    private void initView() {
        ivLogin = findViewById(R.id.iv_login);
        edtUsername = findViewById(R.id.edt_username);
        edtPassword = findViewById(R.id.edt_password);
        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.btn_login:
                    presenter.login(edtUsername.getText().toString(), edtPassword.getText().toString());

                    break;
            }
    }
}
