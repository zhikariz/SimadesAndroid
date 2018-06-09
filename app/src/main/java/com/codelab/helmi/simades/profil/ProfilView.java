package com.codelab.helmi.simades.profil;

import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.codelab.helmi.simades.base.View;

public interface ProfilView extends View {
    void onShowData(ProfilData profilData);
    void onEditData(ProfilData profilData);
}
