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

import com.codelab.helmi.simades.R;
import com.codelab.helmi.simades.profil.ProfilActivity;
import com.codelab.helmi.simades.profil.ProfilPresenter;

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
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // tampilan default awal ketika aplikasii dijalankan
        if (savedInstanceState == null) {
            fragment = new ProfilActivity();
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        // Untuk memanggil layout dari menu yang dipilih
       /* if (id == R.id.nav_camera) {
            fragment = new Import();
            callFragment(fragment);
        } else if (id == R.id.nav_gallery) {
            fragment = new Gallery();
            callFragment(fragment);
        } else if (id == R.id.nav_slideshow) {
            fragment = new SlideShow();
            callFragment(fragment);
        } else if (id == R.id.nav_manage) {
            fragment = new Tools();
            callFragment(fragment);
        } else if (id == R.id.nav_share) {
            fragment = new Share();
            callFragment(fragment);
        } else if (id == R.id.nav_send) {
            fragment = new Send();
            callFragment(fragment);
        }*/

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
