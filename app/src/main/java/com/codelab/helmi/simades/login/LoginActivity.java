package com.codelab.helmi.simades.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.codelab.helmi.simades.R;
import com.codelab.helmi.simades.api.RestServer;

public class LoginActivity extends AppCompatActivity {
    ImageView ivLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ivLogin = findViewById(R.id.iv_login);
        Glide.with(this).load(RestServer.getBase_url() + "uploads/image/Logo_karanganyar3.png").into(ivLogin);
    }
}
