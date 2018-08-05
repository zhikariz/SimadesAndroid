package com.codelab.helmi.simades.navigasi;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.codelab.helmi.simades.helper.shared_preference.SharedPrefManager;
import com.codelab.helmi.simades.home.HomeActivity;
import com.codelab.helmi.simades.R;
import com.codelab.helmi.simades.datang.DatangFragment;
import com.codelab.helmi.simades.kelahiran.KelahiranFragment;
import com.codelab.helmi.simades.kematian.KematianFragment;
import com.codelab.helmi.simades.kk.ShowKkFragment;
import com.codelab.helmi.simades.layanan.LayananFragment;
import com.codelab.helmi.simades.login.LoginActivity;
import com.codelab.helmi.simades.pergi.PergiFragment;
import com.codelab.helmi.simades.profil.ShowProfilActivity;
import com.codelab.helmi.simades.surat.HomeSuratFragment;
import com.google.firebase.messaging.FirebaseMessaging;

public class NavigateActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, NavigateView {

    NavigatePresenter presenter;
    Toolbar toolbar;
    DrawerLayout drawer;
    NavigationView navigationView;
    FragmentManager fragmentManager;
    Fragment fragment = null;
    SharedPrefManager sharedPrefManager;
    TextView tvNama;
//    Fragment fragmentTag = null;
//    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigate);
        initPresenter();
        setNavigasi();
        // tampilan default awal ketika aplikasii dijalankan

        if(savedInstanceState == null) {
            fragment = new HomeActivity();
            callFragment(fragment);
        }




//        FirebaseMessaging.getInstance().subscribeToTopic("android");

    }

    private void initPresenter() {
        presenter = new NavigatePresenter();
    }

    @Override
    public void onBackPressed() {
        drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
//            if (doubleBackToExitPressedOnce) {
//                super.onBackPressed();
//                return;
//            }
//
//            this.doubleBackToExitPressedOnce = true;
//            Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();
//
//            new Handler().postDelayed(new Runnable() {
//
//                @Override
//                public void run() {
//                    doubleBackToExitPressedOnce=false;
//                }
//            }, 2000);
        }
    }

    public void setNavigasi() {
        sharedPrefManager = new SharedPrefManager(this);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        tvNama = navigationView.getHeaderView(0).findViewById(R.id.tv_navigate_nama_user);

        tvNama.setText(sharedPrefManager.getSpNamaUser());
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        // Untuk memanggil layout dari menu yang dipilih
        if (id == R.id.profil) {
            fragment = new ShowProfilActivity();
            callFragment(fragment);
        } else if (id == R.id.home) {
            fragment = new HomeActivity();
            callFragment(fragment);
        } else if (id == R.id.penduduk) {
            fragment = new ShowKkFragment();
            callFragment(fragment);
        } else if (id == R.id.kelahiran) {
            fragment = new KelahiranFragment();
            callFragment(fragment);
        } else if (id == R.id.kematian) {
            fragment = new KematianFragment();
            callFragment(fragment);
        } else if (id == R.id.datang) {
            fragment = new DatangFragment();
            callFragment(fragment);
        } else if (id == R.id.pergi) {
            fragment = new PergiFragment();
            callFragment(fragment);
        } else if(id == R.id.layanan) {
            fragment = new LayananFragment();
            callFragment(fragment);
//        } else if (id == R.id.user) {
//            fragment = new UserActivity();
//            callFragment(fragment);
        } else if (id == R.id.pengajuan_surat) {
            fragment = new HomeSuratFragment();
            callFragment(fragment);
        } else if(id == R.id.logout)
        {

            sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN, false);
            Toast.makeText(this, "Berhasil Logout !", Toast.LENGTH_SHORT).show();
            finish();
            startActivity(new Intent(this, LoginActivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));

        }

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    // untuk mengganti isi kontainer menu yang dipiih
    private void callFragment(Fragment fragment) {

//        fragmentTag = getSupportFragmentManager().findFragmentByTag(fragment.getClass().getSimpleName());
        fragmentManager = getSupportFragmentManager();

        fragmentManager.popBackStack();

        fragmentManager.beginTransaction()
                .replace(R.id.frame_container, fragment, fragment.getClass().getSimpleName())
                .commit();
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
        onDetachView();
        super.onDestroy();
    }

    @Override
    public void onShowFragment() {

    }




}
