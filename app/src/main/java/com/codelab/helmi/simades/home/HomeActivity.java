package com.codelab.helmi.simades.home;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.codelab.helmi.simades.R;
import com.codelab.helmi.simades.helper.api.RestApi;
import com.codelab.helmi.simades.helper.api.RestServer;
import com.codelab.helmi.simades.datang.DatangFragment;
import com.codelab.helmi.simades.kelahiran.KelahiranFragment;
import com.codelab.helmi.simades.kematian.KematianFragment;
import com.codelab.helmi.simades.kk.ShowKkFragment;
import com.codelab.helmi.simades.pergi.PergiFragment;
import com.codelab.helmi.simades.profil.ProfilResponseModel;
import com.codelab.helmi.simades.surat.HomeSuratFragment;
import com.glide.slider.library.Animations.DescriptionAnimation;
import com.glide.slider.library.SliderLayout;
import com.glide.slider.library.SliderTypes.BaseSliderView;
import com.glide.slider.library.SliderTypes.TextSliderView;
import com.glide.slider.library.Tricks.ViewPagerEx;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeActivity extends Fragment implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener, View.OnClickListener {
    View view;
    private SliderLayout mSlider;
    ArrayList<String> listUrl = new ArrayList<>();
    ArrayList<String> listName = new ArrayList<>();
    RequestOptions requestOptions = new RequestOptions();
    LinearLayout lnPenduduk, lnPengajuanSurat, lnKelahiran, lnKematian, lnDatang, lnPergi;
    ImageView ivPenduduk, ivPengajuanSurat, ivKelahiran, ivKematian, ivDatang, ivPergi;
    TextView tvInformasi;
    FragmentManager fragmentManager;
    Fragment fragment;
    RestApi api = RestServer.getClient().create(RestApi.class);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.fragment_home, container, false);
        getActivity().setTitle("Beranda");
        initView();
        loadData();
        initSlider();
        implSlider();

        return view;

    }

    private void loadData() {
        Call<ProfilResponseModel> getData = api.getProfilData();
        getData.enqueue(new Callback<ProfilResponseModel>() {
            @Override
            public void onResponse(Call<ProfilResponseModel> call, Response<ProfilResponseModel> response) {
                try
                {
                    if(response.isSuccessful()){
                        tvInformasi.setText("Sistem Informasi Desa\n"+response.body().getResult().get(0).getNm_desa());
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ProfilResponseModel> call, Throwable t) {

            }
        });
    }

    private void implSlider() {
        for (int i = 0; i < listUrl.size(); i++) {
            TextSliderView sliderView = new TextSliderView(getActivity().getApplicationContext());
            sliderView
                    .image(listUrl.get(i))
                    .description(listName.get(i))
                    .setRequestOption(requestOptions)
                    .setBackgroundColor(Color.WHITE)
                    .setProgressBarVisible(true)
                    .setOnSliderClickListener(this);

            sliderView.bundle(new Bundle());
            sliderView.getBundle().putString("extra", listName.get(i));
            mSlider.addSlider(sliderView);

        }
        mSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mSlider.setCustomAnimation(new DescriptionAnimation());
        mSlider.setDuration(4000);
        mSlider.addOnPageChangeListener(this);
    }

    @SuppressLint("CheckResult")
    private void initSlider() {
        listUrl.add("https://4.bp.blogspot.com/-OhFf0JaFouA/V4xYnHgrSxI/AAAAAAAAHp0/sk8AgxptolkcRuIPYFckoAHP3cyfHehDQCLcB/s1600/20160718-RKP-desa.jpg");
        listName.add("Desa 1");

        listUrl.add("http://www.tanahnusantara.com/wp-content/uploads/2017/10/Misteri-Desa-Tanpa-Kasur-Di-Sleman.jpg");
        listName.add("Desa 2");

        requestOptions.centerCrop();

    }

    private void initView() {
        mSlider = view.findViewById(R.id.slider);

        lnPenduduk = view.findViewById(R.id.ln_home_penduduk);
        lnPengajuanSurat = view.findViewById(R.id.ln_home_pengajuan_surat);
        lnKelahiran = view.findViewById(R.id.ln_home_kelahiran);
        lnKematian = view.findViewById(R.id.ln_home_kematian);
        lnDatang = view.findViewById(R.id.ln_home_datang);
        lnPergi = view.findViewById(R.id.ln_home_pergi);
        tvInformasi = view.findViewById(R.id.informasi_desa);

        ivPenduduk = view.findViewById(R.id.iv_home_penduduk);
        ivPengajuanSurat = view.findViewById(R.id.iv_home_pengajuan_surat);
        ivKelahiran = view.findViewById(R.id.iv_home_kelahiran);
        ivKematian = view.findViewById(R.id.iv_home_kematian);
        ivDatang = view.findViewById(R.id.iv_home_datang);
        ivPergi = view.findViewById(R.id.iv_home_pergi);

        Glide.with(this).load(R.drawable.ic_penduduk).into(ivPenduduk);
        Glide.with(this).load(R.drawable.ic_notepad).into(ivPengajuanSurat);
        Glide.with(this).load(R.drawable.ic_baby).into(ivKelahiran);
        Glide.with(this).load(R.drawable.ic_tomb).into(ivKematian);
        Glide.with(this).load(R.drawable.ic_landing).into(ivDatang);
        Glide.with(this).load(R.drawable.ic_take_off).into(ivPergi);

        lnPenduduk.setOnClickListener(this);
        lnPengajuanSurat.setOnClickListener(this);
        lnKelahiran.setOnClickListener(this);
        lnKematian.setOnClickListener(this);
        lnDatang.setOnClickListener(this);
        lnPergi.setOnClickListener(this);
    }


    @Override
    public void onStop() {
        super.onStop();
        mSlider.stopAutoCycle();
    }

    @Override
    public void onSliderClick(BaseSliderView baseSliderView) {
        Toast.makeText(getActivity(), baseSliderView.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ln_home_penduduk:
                fragment = new ShowKkFragment();
                callFragment(fragment);
                break;
            case R.id.ln_home_pengajuan_surat:
                fragment = new HomeSuratFragment();
                callFragment(fragment);
                break;
            case R.id.ln_home_kelahiran:
                fragment = new KelahiranFragment();
                callFragment(fragment);
                break;
            case R.id.ln_home_kematian:
                fragment = new KematianFragment();
                callFragment(fragment);
                break;
            case R.id.ln_home_datang:
                fragment = new DatangFragment();
                callFragment(fragment);
                break;
            case R.id.ln_home_pergi:
                fragment = new PergiFragment();
                callFragment(fragment);
                break;

        }
    }

    private void callFragment(Fragment fragment) {
        fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .replace(R.id.frame_container, fragment, fragment.getClass().getSimpleName())
                .addToBackStack(fragment.getClass().getSimpleName())
                .commit();
    }


}
