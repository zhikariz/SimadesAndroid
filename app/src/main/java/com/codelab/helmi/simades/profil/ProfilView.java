package com.codelab.helmi.simades.profil;

import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.codelab.helmi.simades.base.View;

import java.util.List;

public interface ProfilView extends View {
    void onShowData(List<ProfilData> profilData);
}
