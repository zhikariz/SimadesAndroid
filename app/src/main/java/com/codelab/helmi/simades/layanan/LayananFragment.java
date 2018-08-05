package com.codelab.helmi.simades.layanan;


import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.codelab.helmi.simades.R;
import com.codelab.helmi.simades.helper.api.RestApi;
import com.codelab.helmi.simades.helper.api.RestServer;
import com.codelab.helmi.simades.kelahiran.KelahiranData;
import com.codelab.helmi.simades.kelahiran.detail.DetailKelahiranFragment;
import com.codelab.helmi.simades.surat.bepergian.SuratBepergianData;
import com.codelab.helmi.simades.surat.bepergian.detail.DetailSuratBepergianFragment;
import com.codelab.helmi.simades.surat.blm_menikah.SuratBlmMenikahData;
import com.codelab.helmi.simades.surat.blm_menikah.detail.DetailSuratBlmMenikahFragment;
import com.codelab.helmi.simades.surat.domisili.SuratDomisiliData;
import com.codelab.helmi.simades.surat.domisili.detail.DetailSuratDomisiliFragment;
import com.codelab.helmi.simades.surat.ektp.SuratEktpData;
import com.codelab.helmi.simades.surat.ektp.detail.DetailSuratEktpFragment;
import com.codelab.helmi.simades.surat.kehilangan.SuratKehilanganData;
import com.codelab.helmi.simades.surat.kehilangan.detail.DetailSuratKehilanganFragment;
import com.codelab.helmi.simades.surat.kelahiran.SuratKelahiranData;
import com.codelab.helmi.simades.surat.kelahiran.SuratKelahiranResponseModel;
import com.codelab.helmi.simades.surat.kelahiran.detail.DetailSuratKelahiranFragment;
import com.codelab.helmi.simades.surat.kematian.SuratKematianData;
import com.codelab.helmi.simades.surat.kematian.detail.DetailSuratKematianFragment;
import com.codelab.helmi.simades.surat.keramaian.SuratKeramaianData;
import com.codelab.helmi.simades.surat.keramaian.detail.DetailSuratKeramaianFragment;
import com.codelab.helmi.simades.surat.skck.SuratSkckData;
import com.codelab.helmi.simades.surat.skck.detail.DetailSuratSkckFragment;
import com.codelab.helmi.simades.surat.tidak_mampu.SuratTidakMampuData;
import com.codelab.helmi.simades.surat.tidak_mampu.detail.DetailSuratTidakMampuFragment;
import com.codelab.helmi.simades.surat.usaha.SuratUsahaData;
import com.codelab.helmi.simades.surat.usaha.detail.DetailSuratUsahaFragment;
import com.codelab.helmi.simades.surat.wali.SuratWaliData;
import com.codelab.helmi.simades.surat.wali.detail.DetailSuratWaliFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class LayananFragment extends Fragment {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, Result> listDataChild;
    View view;
    FragmentManager fragmentManager;
    public static final String KEY_RECYCLER_STATE = "recycler_state";
    public static Bundle mBundleRecyclerViewState = null;


    public LayananFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_layanan, container, false);
        getActivity().setTitle("Layanan");

        // get the listview
        expListView = view.findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();
        loadData();



        // Listview Group click listener
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getActivity(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getActivity(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                fragmentManager = getFragmentManager();
                if (groupPosition == 0) {
                    DetailSuratKelahiranFragment detailSuratKelahiranFragment = new DetailSuratKelahiranFragment();
                    SuratKelahiranData suratKelahiranData = new SuratKelahiranData();

                    suratKelahiranData.setKd_surat(listDataChild.get(listDataHeader.get(groupPosition)).getSuratKelahiran().get(childPosition).getKdSurat());
                    suratKelahiranData.setNo_surat(listDataChild.get(listDataHeader.get(groupPosition)).getSuratKelahiran().get(childPosition).getNoSurat());
                    suratKelahiranData.setTgl_surat(listDataChild.get(listDataHeader.get(groupPosition)).getSuratKelahiran().get(childPosition).getTglSurat());
                    suratKelahiranData.setWaktu(listDataChild.get(listDataHeader.get(groupPosition)).getSuratKelahiran().get(childPosition).getWaktu());
                    suratKelahiranData.setStatus_persetujuan(listDataChild.get(listDataHeader.get(groupPosition)).getSuratKelahiran().get(childPosition).getStatusPersetujuan());
                    suratKelahiranData.setNik(listDataChild.get(listDataHeader.get(groupPosition)).getSuratKelahiran().get(childPosition).getNik());
                    suratKelahiranData.setNama_depan(listDataChild.get(listDataHeader.get(groupPosition)).getSuratKelahiran().get(childPosition).getNamaDepan());
                    suratKelahiranData.setNama_belakang(listDataChild.get(listDataHeader.get(groupPosition)).getSuratKelahiran().get(childPosition).getNamaBelakang());
                    suratKelahiranData.setNama_depan_user(listDataChild.get(listDataHeader.get(groupPosition)).getSuratKelahiran().get(childPosition).getNamaDepanUser());
                    suratKelahiranData.setNama_belakang_user(listDataChild.get(listDataHeader.get(groupPosition)).getSuratKelahiran().get(childPosition).getNamaBelakangUser());

                    Bundle bundle = new Bundle();
                    bundle.putParcelable(DetailSuratKelahiranFragment.EXTRA_SURAT_KELAHIRAN, suratKelahiranData);

                    detailSuratKelahiranFragment.setArguments(bundle);

                    fragmentManager.beginTransaction()
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                            .replace(R.id.frame_container, detailSuratKelahiranFragment, detailSuratKelahiranFragment.getClass().getSimpleName())
                            .addToBackStack(detailSuratKelahiranFragment.getClass().getSimpleName())
                            .commit();


                } else if (groupPosition == 1) {
                    DetailSuratUsahaFragment detailSuratUsahaFragment = new DetailSuratUsahaFragment();
                    SuratUsahaData suratUsahaData = new SuratUsahaData();

                    suratUsahaData.setKd_surat(listDataChild.get(listDataHeader.get(groupPosition)).getSuratUsaha().get(childPosition).getKdSurat());
                    suratUsahaData.setNo_surat(listDataChild.get(listDataHeader.get(groupPosition)).getSuratUsaha().get(childPosition).getNoSurat());
                    suratUsahaData.setTgl_surat(listDataChild.get(listDataHeader.get(groupPosition)).getSuratUsaha().get(childPosition).getTglSurat());
                    suratUsahaData.setWaktu(listDataChild.get(listDataHeader.get(groupPosition)).getSuratUsaha().get(childPosition).getWaktu());
                    suratUsahaData.setStatus_persetujuan(listDataChild.get(listDataHeader.get(groupPosition)).getSuratUsaha().get(childPosition).getStatusPersetujuan());
                    suratUsahaData.setNik(listDataChild.get(listDataHeader.get(groupPosition)).getSuratUsaha().get(childPosition).getNik());
                    suratUsahaData.setNama_usaha(listDataChild.get(listDataHeader.get(groupPosition)).getSuratUsaha().get(childPosition).getNamaUsaha());
                    suratUsahaData.setKeperluan(listDataChild.get(listDataHeader.get(groupPosition)).getSuratUsaha().get(childPosition).getKeperluan());
                    suratUsahaData.setTgl_mulai(listDataChild.get(listDataHeader.get(groupPosition)).getSuratUsaha().get(childPosition).getTglMulai());
                    suratUsahaData.setTgl_akhir(listDataChild.get(listDataHeader.get(groupPosition)).getSuratUsaha().get(childPosition).getTglAkhir());
                    suratUsahaData.setNama_depan(listDataChild.get(listDataHeader.get(groupPosition)).getSuratUsaha().get(childPosition).getNamaDepan());
                    suratUsahaData.setNama_belakang(listDataChild.get(listDataHeader.get(groupPosition)).getSuratUsaha().get(childPosition).getNamaBelakang());
                    suratUsahaData.setNama_depan_user(listDataChild.get(listDataHeader.get(groupPosition)).getSuratUsaha().get(childPosition).getNamaDepanUser());
                    suratUsahaData.setNama_belakang_user(listDataChild.get(listDataHeader.get(groupPosition)).getSuratUsaha().get(childPosition).getNamaBelakangUser());

                    Bundle bundle = new Bundle();
                    bundle.putParcelable(DetailSuratUsahaFragment.EXTRA_SURAT_USAHA, suratUsahaData);

                    detailSuratUsahaFragment.setArguments(bundle);
                    fragmentManager.beginTransaction()
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                            .replace(R.id.frame_container, detailSuratUsahaFragment, detailSuratUsahaFragment.getClass().getSimpleName())
                            .addToBackStack(detailSuratUsahaFragment.getClass().getSimpleName())
                            .commit();
                } else if (groupPosition == 2) {

                    DetailSuratKematianFragment detailSuratKematianFragment = new DetailSuratKematianFragment();
                    SuratKematianData suratKematianData = new SuratKematianData();

                    suratKematianData.setKd_surat(listDataChild.get(listDataHeader.get(groupPosition)).getSuratKematian().get(childPosition).getKdSurat());
                    suratKematianData.setNo_surat(listDataChild.get(listDataHeader.get(groupPosition)).getSuratKematian().get(childPosition).getNoSurat());
                    suratKematianData.setTgl_surat(listDataChild.get(listDataHeader.get(groupPosition)).getSuratKematian().get(childPosition).getTglSurat());
                    suratKematianData.setStatus_persetujuan(listDataChild.get(listDataHeader.get(groupPosition)).getSuratKematian().get(childPosition).getStatusPersetujuan());
                    suratKematianData.setNik(listDataChild.get(listDataHeader.get(groupPosition)).getSuratKematian().get(childPosition).getNik());
                    suratKematianData.setNama_depan_pengaju(listDataChild.get(listDataHeader.get(groupPosition)).getSuratKematian().get(childPosition).getNamaDepanPengaju());
                    suratKematianData.setNama_belakang_pengaju(listDataChild.get(listDataHeader.get(groupPosition)).getSuratKematian().get(childPosition).getNamaBelakangPengaju());
                    suratKematianData.setNama_depan_user(listDataChild.get(listDataHeader.get(groupPosition)).getSuratKematian().get(childPosition).getNamaDepanUser());
                    suratKematianData.setNama_belakang_user(listDataChild.get(listDataHeader.get(groupPosition)).getSuratKematian().get(childPosition).getNamaBelakangUser());

                    Bundle bundle = new Bundle();
                    bundle.putParcelable(DetailSuratKematianFragment.EXTRA_SURAT_KEMATIAN, suratKematianData);

                    detailSuratKematianFragment.setArguments(bundle);
                    fragmentManager.beginTransaction()
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                            .replace(R.id.frame_container, detailSuratKematianFragment, detailSuratKematianFragment.getClass().getSimpleName())
                            .addToBackStack(detailSuratKematianFragment.getClass().getSimpleName())
                            .commit();

                } else if (groupPosition == 3) {
                    DetailSuratSkckFragment detailSuratSkckFragment = new DetailSuratSkckFragment();
                    SuratSkckData suratSkckData = new SuratSkckData();

                    suratSkckData.setKd_surat(listDataChild.get(listDataHeader.get(groupPosition)).getSuratPengantarSkck().get(childPosition).getKdSurat());
                    suratSkckData.setNo_surat(listDataChild.get(listDataHeader.get(groupPosition)).getSuratPengantarSkck().get(childPosition).getNoSurat());
                    suratSkckData.setTgl_surat(listDataChild.get(listDataHeader.get(groupPosition)).getSuratPengantarSkck().get(childPosition).getTglSurat());
                    suratSkckData.setStatus_persetujuan(listDataChild.get(listDataHeader.get(groupPosition)).getSuratPengantarSkck().get(childPosition).getStatusPersetujuan());
                    suratSkckData.setNik(listDataChild.get(listDataHeader.get(groupPosition)).getSuratPengantarSkck().get(childPosition).getNik());
                    suratSkckData.setNama_depan(listDataChild.get(listDataHeader.get(groupPosition)).getSuratPengantarSkck().get(childPosition).getNamaDepan());
                    suratSkckData.setNama_belakang(listDataChild.get(listDataHeader.get(groupPosition)).getSuratPengantarSkck().get(childPosition).getNamaBelakang());
                    suratSkckData.setNama_depan_user(listDataChild.get(listDataHeader.get(groupPosition)).getSuratPengantarSkck().get(childPosition).getNamaDepanUser());
                    suratSkckData.setNama_belakang_user(listDataChild.get(listDataHeader.get(groupPosition)).getSuratPengantarSkck().get(childPosition).getNamaBelakangUser());

                    Bundle bundle = new Bundle();
                    bundle.putParcelable(DetailSuratSkckFragment.EXTRA_SURAT_SKCK, suratSkckData);

                    detailSuratSkckFragment.setArguments(bundle);
                    fragmentManager.beginTransaction()
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                            .replace(R.id.frame_container, detailSuratSkckFragment, detailSuratSkckFragment.getClass().getSimpleName())
                            .addToBackStack(detailSuratSkckFragment.getClass().getSimpleName())
                            .commit();

                } else if (groupPosition == 4) {
                    DetailSuratWaliFragment detailSuratWaliFragment = new DetailSuratWaliFragment();
                    SuratWaliData suratWaliData = new SuratWaliData();

                    suratWaliData.setKd_surat(listDataChild.get(listDataHeader.get(groupPosition)).getSuratWali().get(childPosition).getKdSurat());
                    suratWaliData.setNo_surat(listDataChild.get(listDataHeader.get(groupPosition)).getSuratWali().get(childPosition).getNoSurat());
                    suratWaliData.setTgl_surat(listDataChild.get(listDataHeader.get(groupPosition)).getSuratWali().get(childPosition).getTglSurat());
                    suratWaliData.setStatus_persetujuan(listDataChild.get(listDataHeader.get(groupPosition)).getSuratWali().get(childPosition).getStatusPersetujuan());
                    suratWaliData.setNik(listDataChild.get(listDataHeader.get(groupPosition)).getSuratWali().get(childPosition).getNik());
                    suratWaliData.setNama_depan_wali(listDataChild.get(listDataHeader.get(groupPosition)).getSuratWali().get(childPosition).getNamaDepanWali());
                    suratWaliData.setNama_belakang_wali(listDataChild.get(listDataHeader.get(groupPosition)).getSuratWali().get(childPosition).getNamaBelakangWali());
                    suratWaliData.setNama_depan_user(listDataChild.get(listDataHeader.get(groupPosition)).getSuratWali().get(childPosition).getNamaDepanUser());
                    suratWaliData.setNama_belakang_user(listDataChild.get(listDataHeader.get(groupPosition)).getSuratWali().get(childPosition).getNamaBelakangUser());

                    Bundle bundle = new Bundle();
                    bundle.putParcelable(DetailSuratWaliFragment.EXTRA_SURAT_WALI, suratWaliData);

                    detailSuratWaliFragment.setArguments(bundle);
                    fragmentManager.beginTransaction()
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                            .replace(R.id.frame_container, detailSuratWaliFragment, detailSuratWaliFragment.getClass().getSimpleName())
                            .addToBackStack(detailSuratWaliFragment.getClass().getSimpleName())
                            .commit();

                } else if (groupPosition == 5) {
                    DetailSuratBlmMenikahFragment detailSuratBlmMenikahFragment = new DetailSuratBlmMenikahFragment();
                    SuratBlmMenikahData suratBlmMenikahData = new SuratBlmMenikahData();

                    suratBlmMenikahData.setKd_surat(listDataChild.get(listDataHeader.get(groupPosition)).getSuratBlmMenikah().get(childPosition).getKdSurat());
                    suratBlmMenikahData.setNo_surat(listDataChild.get(listDataHeader.get(groupPosition)).getSuratBlmMenikah().get(childPosition).getNoSurat());
                    suratBlmMenikahData.setTgl_surat(listDataChild.get(listDataHeader.get(groupPosition)).getSuratBlmMenikah().get(childPosition).getTglSurat());
                    suratBlmMenikahData.setStatus_persetujuan(listDataChild.get(listDataHeader.get(groupPosition)).getSuratBlmMenikah().get(childPosition).getStatusPersetujuan());
                    suratBlmMenikahData.setNik(listDataChild.get(listDataHeader.get(groupPosition)).getSuratBlmMenikah().get(childPosition).getNik());
                    suratBlmMenikahData.setNama_depan(listDataChild.get(listDataHeader.get(groupPosition)).getSuratBlmMenikah().get(childPosition).getNamaDepan());
                    suratBlmMenikahData.setNama_belakang(listDataChild.get(listDataHeader.get(groupPosition)).getSuratBlmMenikah().get(childPosition).getNamaBelakang());
                    suratBlmMenikahData.setNama_depan_user(listDataChild.get(listDataHeader.get(groupPosition)).getSuratBlmMenikah().get(childPosition).getNamaDepanUser());
                    suratBlmMenikahData.setNama_belakang_user(listDataChild.get(listDataHeader.get(groupPosition)).getSuratBlmMenikah().get(childPosition).getNamaBelakangUser());

                    Bundle bundle = new Bundle();
                    bundle.putParcelable(DetailSuratBlmMenikahFragment.EXTRA_SURAT_BLM_MENIKAH, suratBlmMenikahData);

                    detailSuratBlmMenikahFragment.setArguments(bundle);
                    fragmentManager.beginTransaction()
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                            .replace(R.id.frame_container, detailSuratBlmMenikahFragment, detailSuratBlmMenikahFragment.getClass().getSimpleName())
                            .addToBackStack(detailSuratBlmMenikahFragment.getClass().getSimpleName())
                            .commit();
                } else if (groupPosition == 6) {
                    DetailSuratKeramaianFragment detailSuratKeramaianFragment = new DetailSuratKeramaianFragment();
                    SuratKeramaianData suratKeramaianData = new SuratKeramaianData();

                    suratKeramaianData.setKd_surat(listDataChild.get(listDataHeader.get(groupPosition)).getSuratIzinKeramaian().get(childPosition).getKdSurat());
                    suratKeramaianData.setNo_surat(listDataChild.get(listDataHeader.get(groupPosition)).getSuratIzinKeramaian().get(childPosition).getNoSurat());
                    suratKeramaianData.setTgl_surat(listDataChild.get(listDataHeader.get(groupPosition)).getSuratIzinKeramaian().get(childPosition).getTglSurat());
                    suratKeramaianData.setStatus_persetujuan(listDataChild.get(listDataHeader.get(groupPosition)).getSuratIzinKeramaian().get(childPosition).getStatusPersetujuan());
                    suratKeramaianData.setNik(listDataChild.get(listDataHeader.get(groupPosition)).getSuratIzinKeramaian().get(childPosition).getNik());
                    suratKeramaianData.setNama_depan(listDataChild.get(listDataHeader.get(groupPosition)).getSuratIzinKeramaian().get(childPosition).getNamaDepan());
                    suratKeramaianData.setNama_belakang(listDataChild.get(listDataHeader.get(groupPosition)).getSuratIzinKeramaian().get(childPosition).getNamaBelakang());
                    suratKeramaianData.setNama_depan_user(listDataChild.get(listDataHeader.get(groupPosition)).getSuratIzinKeramaian().get(childPosition).getNamaDepanUser());
                    suratKeramaianData.setNama_belakang_user(listDataChild.get(listDataHeader.get(groupPosition)).getSuratIzinKeramaian().get(childPosition).getNamaBelakangUser());

                    Bundle bundle = new Bundle();
                    bundle.putParcelable(DetailSuratKeramaianFragment.EXTRA_SURAT_IZIN_KERAMAIAN, suratKeramaianData);

                    detailSuratKeramaianFragment.setArguments(bundle);
                    fragmentManager.beginTransaction()
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                            .replace(R.id.frame_container, detailSuratKeramaianFragment, detailSuratKeramaianFragment.getClass().getSimpleName())
                            .addToBackStack(detailSuratKeramaianFragment.getClass().getSimpleName())
                            .commit();

                } else if (groupPosition == 7) {
                    DetailSuratBepergianFragment detailSuratBepergianFragment = new DetailSuratBepergianFragment();
                    SuratBepergianData suratBepergianData = new SuratBepergianData();

                    suratBepergianData.setKd_surat(listDataChild.get(listDataHeader.get(groupPosition)).getSuratBepergian().get(childPosition).getKdSurat());
                    suratBepergianData.setNo_surat(listDataChild.get(listDataHeader.get(groupPosition)).getSuratBepergian().get(childPosition).getNoSurat());
                    suratBepergianData.setTgl_surat(listDataChild.get(listDataHeader.get(groupPosition)).getSuratBepergian().get(childPosition).getTglSurat());
                    suratBepergianData.setStatus_persetujuan(listDataChild.get(listDataHeader.get(groupPosition)).getSuratBepergian().get(childPosition).getStatusPersetujuan());
                    suratBepergianData.setNik(listDataChild.get(listDataHeader.get(groupPosition)).getSuratBepergian().get(childPosition).getNik());
                    suratBepergianData.setNama_depan(listDataChild.get(listDataHeader.get(groupPosition)).getSuratBepergian().get(childPosition).getNamaDepan());
                    suratBepergianData.setNama_belakang(listDataChild.get(listDataHeader.get(groupPosition)).getSuratBepergian().get(childPosition).getNamaBelakang());
                    suratBepergianData.setNama_depan_user(listDataChild.get(listDataHeader.get(groupPosition)).getSuratBepergian().get(childPosition).getNamaDepanUser());
                    suratBepergianData.setNama_belakang_user(listDataChild.get(listDataHeader.get(groupPosition)).getSuratBepergian().get(childPosition).getNamaBelakangUser());

                    Bundle bundle = new Bundle();
                    bundle.putParcelable(DetailSuratBepergianFragment.EXTRA_SURAT_BEPERGIAN, suratBepergianData);

                    detailSuratBepergianFragment.setArguments(bundle);
                    fragmentManager.beginTransaction()
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                            .replace(R.id.frame_container, detailSuratBepergianFragment, detailSuratBepergianFragment.getClass().getSimpleName())
                            .addToBackStack(detailSuratBepergianFragment.getClass().getSimpleName())
                            .commit();

                } else if (groupPosition == 8) {

                    DetailSuratKehilanganFragment detailSuratKehilanganFragment = new DetailSuratKehilanganFragment();
                    SuratKehilanganData suratKehilanganData = new SuratKehilanganData();

                    suratKehilanganData.setKd_surat(listDataChild.get(listDataHeader.get(groupPosition)).getSuratKehilangan().get(childPosition).getKdSurat());
                    suratKehilanganData.setNo_surat(listDataChild.get(listDataHeader.get(groupPosition)).getSuratKehilangan().get(childPosition).getNoSurat());
                    suratKehilanganData.setTgl_surat(listDataChild.get(listDataHeader.get(groupPosition)).getSuratKehilangan().get(childPosition).getTglSurat());
                    suratKehilanganData.setStatus_persetujuan(listDataChild.get(listDataHeader.get(groupPosition)).getSuratKehilangan().get(childPosition).getStatusPersetujuan());
                    suratKehilanganData.setNik(listDataChild.get(listDataHeader.get(groupPosition)).getSuratKehilangan().get(childPosition).getNik());
                    suratKehilanganData.setNama_depan(listDataChild.get(listDataHeader.get(groupPosition)).getSuratKehilangan().get(childPosition).getNamaDepan());
                    suratKehilanganData.setNama_belakang(listDataChild.get(listDataHeader.get(groupPosition)).getSuratKehilangan().get(childPosition).getNamaBelakang());
                    suratKehilanganData.setNama_depan_user(listDataChild.get(listDataHeader.get(groupPosition)).getSuratKehilangan().get(childPosition).getNamaDepanUser());
                    suratKehilanganData.setNama_belakang_user(listDataChild.get(listDataHeader.get(groupPosition)).getSuratKehilangan().get(childPosition).getNamaBelakangUser());

                    Bundle bundle = new Bundle();
                    bundle.putParcelable(DetailSuratKehilanganFragment.EXTRA_SURAT_KEHILANGAN, suratKehilanganData);

                    detailSuratKehilanganFragment.setArguments(bundle);
                    fragmentManager.beginTransaction()
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                            .replace(R.id.frame_container, detailSuratKehilanganFragment, detailSuratKehilanganFragment.getClass().getSimpleName())
                            .addToBackStack(detailSuratKehilanganFragment.getClass().getSimpleName())
                            .commit();

                } else if (groupPosition == 9) {

                    DetailSuratTidakMampuFragment detailSuratTidakMampuFragment = new DetailSuratTidakMampuFragment();
                    SuratTidakMampuData suratTidakMampuData = new SuratTidakMampuData();

                    suratTidakMampuData.setKd_surat(listDataChild.get(listDataHeader.get(groupPosition)).getSuratTidakMampu().get(childPosition).getKdSurat());
                    suratTidakMampuData.setNo_surat(listDataChild.get(listDataHeader.get(groupPosition)).getSuratTidakMampu().get(childPosition).getNoSurat());
                    suratTidakMampuData.setTgl_surat(listDataChild.get(listDataHeader.get(groupPosition)).getSuratTidakMampu().get(childPosition).getTglSurat());
                    suratTidakMampuData.setStatus_persetujuan(listDataChild.get(listDataHeader.get(groupPosition)).getSuratTidakMampu().get(childPosition).getStatusPersetujuan());
                    suratTidakMampuData.setNik(listDataChild.get(listDataHeader.get(groupPosition)).getSuratTidakMampu().get(childPosition).getNik());
                    suratTidakMampuData.setNama_depan(listDataChild.get(listDataHeader.get(groupPosition)).getSuratTidakMampu().get(childPosition).getNamaDepan());
                    suratTidakMampuData.setNama_belakang(listDataChild.get(listDataHeader.get(groupPosition)).getSuratTidakMampu().get(childPosition).getNamaBelakang());
                    suratTidakMampuData.setNama_depan_user(listDataChild.get(listDataHeader.get(groupPosition)).getSuratTidakMampu().get(childPosition).getNamaDepanUser());
                    suratTidakMampuData.setNama_belakang_user(listDataChild.get(listDataHeader.get(groupPosition)).getSuratTidakMampu().get(childPosition).getNamaBelakangUser());

                    Bundle bundle = new Bundle();
                    bundle.putParcelable(DetailSuratTidakMampuFragment.EXTRA_SURAT_TIDAK_MAMPU, suratTidakMampuData);

                    detailSuratTidakMampuFragment.setArguments(bundle);
                    fragmentManager.beginTransaction()
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                            .replace(R.id.frame_container, detailSuratTidakMampuFragment, detailSuratTidakMampuFragment.getClass().getSimpleName())
                            .addToBackStack(detailSuratTidakMampuFragment.getClass().getSimpleName())
                            .commit();

                } else if (groupPosition == 10) {

                    DetailSuratDomisiliFragment detailSuratDomisiliFragment = new DetailSuratDomisiliFragment();
                    SuratDomisiliData suratDomisiliData = new SuratDomisiliData();

                    suratDomisiliData.setKd_surat(listDataChild.get(listDataHeader.get(groupPosition)).getSuratDomisili().get(childPosition).getKdSurat());
                    suratDomisiliData.setNo_surat(listDataChild.get(listDataHeader.get(groupPosition)).getSuratDomisili().get(childPosition).getNoSurat());
                    suratDomisiliData.setTgl_surat(listDataChild.get(listDataHeader.get(groupPosition)).getSuratDomisili().get(childPosition).getTglSurat());
                    suratDomisiliData.setStatus_persetujuan(listDataChild.get(listDataHeader.get(groupPosition)).getSuratDomisili().get(childPosition).getStatusPersetujuan());
                    suratDomisiliData.setNik(listDataChild.get(listDataHeader.get(groupPosition)).getSuratDomisili().get(childPosition).getNik());
                    suratDomisiliData.setNama_depan(listDataChild.get(listDataHeader.get(groupPosition)).getSuratDomisili().get(childPosition).getNamaDepan());
                    suratDomisiliData.setNama_belakang(listDataChild.get(listDataHeader.get(groupPosition)).getSuratDomisili().get(childPosition).getNamaBelakang());
                    suratDomisiliData.setNama_depan_user(listDataChild.get(listDataHeader.get(groupPosition)).getSuratDomisili().get(childPosition).getNamaDepanUser());
                    suratDomisiliData.setNama_belakang_user(listDataChild.get(listDataHeader.get(groupPosition)).getSuratDomisili().get(childPosition).getNamaBelakangUser());

                    Bundle bundle = new Bundle();
                    bundle.putParcelable(DetailSuratDomisiliFragment.EXTRA_SURAT_DOMISILI, suratDomisiliData);
                    detailSuratDomisiliFragment.setArguments(bundle);

                    fragmentManager.beginTransaction()
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                            .replace(R.id.frame_container, detailSuratDomisiliFragment, detailSuratDomisiliFragment.getClass().getSimpleName())
                            .addToBackStack(detailSuratDomisiliFragment.getClass().getSimpleName())
                            .commit();

                } else if (groupPosition == 11) {

                    DetailSuratEktpFragment detailSuratEktpFragment = new DetailSuratEktpFragment();
                    SuratEktpData suratEktpData = new SuratEktpData();

                    suratEktpData.setKd_surat(listDataChild.get(listDataHeader.get(groupPosition)).getSuratPengantarEktp().get(childPosition).getKdSurat());
                    suratEktpData.setNo_surat(listDataChild.get(listDataHeader.get(groupPosition)).getSuratPengantarEktp().get(childPosition).getNoSurat());
                    suratEktpData.setTgl_surat(listDataChild.get(listDataHeader.get(groupPosition)).getSuratPengantarEktp().get(childPosition).getTglSurat());
                    suratEktpData.setStatus_persetujuan(listDataChild.get(listDataHeader.get(groupPosition)).getSuratPengantarEktp().get(childPosition).getStatusPersetujuan());
                    suratEktpData.setNik(listDataChild.get(listDataHeader.get(groupPosition)).getSuratPengantarEktp().get(childPosition).getNik());
                    suratEktpData.setNama_depan(listDataChild.get(listDataHeader.get(groupPosition)).getSuratPengantarEktp().get(childPosition).getNamaDepan());
                    suratEktpData.setNama_belakang(listDataChild.get(listDataHeader.get(groupPosition)).getSuratPengantarEktp().get(childPosition).getNamaBelakang());
                    suratEktpData.setNama_depan_user(listDataChild.get(listDataHeader.get(groupPosition)).getSuratPengantarEktp().get(childPosition).getNamaDepanUser());
                    suratEktpData.setNama_belakang_user(listDataChild.get(listDataHeader.get(groupPosition)).getSuratPengantarEktp().get(childPosition).getNamaBelakangUser());

                    Bundle bundle = new Bundle();
                    bundle.putParcelable(DetailSuratEktpFragment.EXTRA_SURAT_PENGANTAR_EKTP, suratEktpData);
                    detailSuratEktpFragment.setArguments(bundle);
                    fragmentManager.beginTransaction()
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                            .replace(R.id.frame_container, detailSuratEktpFragment, detailSuratEktpFragment.getClass().getSimpleName())
                            .addToBackStack(detailSuratEktpFragment.getClass().getSimpleName())
                            .commit();

                }

                return false;
            }
        });


        return view;
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, Result>();

        listDataHeader.add("Surat Kelahiran");
        listDataHeader.add("Surat Usaha");
        listDataHeader.add("Surat Kematian");
        listDataHeader.add("Surat Pengantar SKCK");
        listDataHeader.add("Surat Wali");
        listDataHeader.add("Surat Blm Menikah");
        listDataHeader.add("Surat Izin Keramaian");
        listDataHeader.add("Surat Bepergian");
        listDataHeader.add("Surat Kehilangan");
        listDataHeader.add("Surat Tidak Mampu");
        listDataHeader.add("Surat Domisili");
        listDataHeader.add("Surat Pengantar Ektp");


//        listDataChild.put(listDataHeader.get(0));

    }

    private void loadData() {
        RestApi api = RestServer.getClient().create(RestApi.class);
        Call<LayananResponseModel> getData = api.getLayananData();
        getData.enqueue(new Callback<LayananResponseModel>() {
            @Override
            public void onResponse(Call<LayananResponseModel> call, Response<LayananResponseModel> response) {

                listDataChild.put(listDataHeader.get(0), response.body().getResult());
                listDataChild.put(listDataHeader.get(1), response.body().getResult());
                listDataChild.put(listDataHeader.get(2), response.body().getResult());
                listDataChild.put(listDataHeader.get(3), response.body().getResult());
                listDataChild.put(listDataHeader.get(4), response.body().getResult());
                listDataChild.put(listDataHeader.get(5), response.body().getResult());
                listDataChild.put(listDataHeader.get(6), response.body().getResult());
                listDataChild.put(listDataHeader.get(7), response.body().getResult());
                listDataChild.put(listDataHeader.get(8), response.body().getResult());
                listDataChild.put(listDataHeader.get(9), response.body().getResult());
                listDataChild.put(listDataHeader.get(10), response.body().getResult());
                listDataChild.put(listDataHeader.get(11), response.body().getResult());
                setAdapter(listDataChild);


            }

            @Override
            public void onFailure(Call<LayananResponseModel> call, Throwable t) {

            }
        });

    }

    public void setAdapter(HashMap<String, Result> listDataChild){
        listAdapter = new ExpandableListAdapter(getActivity(), listDataHeader, listDataChild, expListView);

        // setting list adapter
        expListView.setAdapter(listAdapter);
    }
}
