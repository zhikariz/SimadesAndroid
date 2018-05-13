package com.codelab.helmi.simades.navigasi;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.codelab.helmi.simades.HomeActivity;
import com.codelab.helmi.simades.R;
import com.codelab.helmi.simades.datang.DatangActivity;
import com.codelab.helmi.simades.kelahiran.KelahiranActivity;
import com.codelab.helmi.simades.kematian.KematianActivity;
import com.codelab.helmi.simades.penduduk.PendudukActivity;
import com.codelab.helmi.simades.pergi.PergiActivity;
import com.codelab.helmi.simades.profil.ProfilActivity;
import com.codelab.helmi.simades.user.UserActivity;

public class NavigateActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,NavigateView {

    NavigatePresenter presenter;
    Toolbar toolbar;
    DrawerLayout drawer;
    NavigationView navigationView;
    FragmentManager fragmentManager;
    Fragment fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPresenter();
        setNavigasi();
        // tampilan default awal ketika aplikasii dijalankan
        if (savedInstanceState == null) {
            fragment = new HomeActivity();
            callFragment(fragment);
        }

    }

    private void initPresenter() {
        presenter = new NavigatePresenter();
    }

    @Override
    public void onBackPressed() {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void setNavigasi(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        // Untuk memanggil layout dari menu yang dipilih
        if (id == R.id.profil) {
            fragment = new ProfilActivity();
            callFragment(fragment);
        }else if (id == R.id.home) {
            fragment = new HomeActivity();
            callFragment(fragment);
        } else if (id == R.id.penduduk) {
            fragment = new PendudukActivity();
            callFragment(fragment);
        } else if (id == R.id.kelahiran) {
            fragment = new KelahiranActivity();
            callFragment(fragment);
        } else if (id == R.id.kematian) {
            fragment = new KematianActivity();
            callFragment(fragment);
        } else if (id == R.id.datang) {
            fragment = new DatangActivity();
            callFragment(fragment);
        } else if (id == R.id.pergi) {
            fragment = new PergiActivity();
            callFragment(fragment);
        } else if( id == R.id.user ){
            fragment = new UserActivity();
            callFragment(fragment);
        }

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    // untuk mengganti isi kontainer menu yang dipiih
    private void callFragment(Fragment fragment) {
        fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frame_container, fragment)
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
