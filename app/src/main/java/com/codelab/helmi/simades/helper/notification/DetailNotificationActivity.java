package com.codelab.helmi.simades.helper.notification;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.codelab.helmi.simades.R;
import com.codelab.helmi.simades.layanan.LayananFragment;

public class DetailNotificationActivity extends AppCompatActivity {
    Fragment fragment;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_notification);
        fragment = new LayananFragment();
        callFragment(fragment);
    }

    private void callFragment(Fragment fragment) {

//        fragmentTag = getSupportFragmentManager().findFragmentByTag(fragment.getClass().getSimpleName());
        fragmentManager = getSupportFragmentManager();

        fragmentManager.popBackStack();

        fragmentManager.beginTransaction()
                .replace(R.id.frame_container, fragment, fragment.getClass().getSimpleName())
                .commit();
    }
}
