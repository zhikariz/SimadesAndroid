package com.codelab.helmi.simades.layanan;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.codelab.helmi.simades.R;

import java.util.HashMap;
import java.util.List;

public class ExpandableListAdapter extends BaseExpandableListAdapter {
    private Context _context;
    private List<String> _listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<String, Result> _listDataChild;
    int ukuran = 0;
    ExpandableListView expandableListView;

    public ExpandableListAdapter(Context context, List<String> listDataHeader, HashMap<String, Result> listChildData, ExpandableListView expandableListView) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
        this.expandableListView = expandableListView;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        String data = null;
        if (groupPosition == 0) {
            data = _listDataChild.get(this._listDataHeader.get(groupPosition)).getSuratKelahiran().get(childPosition).getKdSurat();
        } else if (groupPosition == 1) {
            data = _listDataChild.get(this._listDataHeader.get(groupPosition)).getSuratUsaha().get(childPosition).getKdSurat();
        } else if (groupPosition == 2) {
            data = _listDataChild.get(this._listDataHeader.get(groupPosition)).getSuratKematian().get(childPosition).getKdSurat();
        } else if (groupPosition == 3) {
            data = _listDataChild.get(this._listDataHeader.get(groupPosition)).getSuratPengantarSkck().get(childPosition).getKdSurat();
        } else if (groupPosition == 4) {
            data = _listDataChild.get(this._listDataHeader.get(groupPosition)).getSuratWali().get(childPosition).getKdSurat();
        } else if (groupPosition == 5) {
            data = _listDataChild.get(this._listDataHeader.get(groupPosition)).getSuratBlmMenikah().get(childPosition).getKdSurat();
        } else if (groupPosition == 6) {
            data = _listDataChild.get(this._listDataHeader.get(groupPosition)).getSuratIzinKeramaian().get(childPosition).getKdSurat();
        } else if (groupPosition == 7) {
            data = _listDataChild.get(this._listDataHeader.get(groupPosition)).getSuratBepergian().get(childPosition).getKdSurat();
        } else if (groupPosition == 8) {
            data = _listDataChild.get(this._listDataHeader.get(groupPosition)).getSuratKehilangan().get(childPosition).getKdSurat();
        } else if (groupPosition == 9) {
            data = _listDataChild.get(this._listDataHeader.get(groupPosition)).getSuratTidakMampu().get(childPosition).getKdSurat();
        } else if (groupPosition == 10) {
            data = _listDataChild.get(this._listDataHeader.get(groupPosition)).getSuratDomisili().get(childPosition).getKdSurat();
        } else if (groupPosition == 11) {
            data = _listDataChild.get(this._listDataHeader.get(groupPosition)).getSuratPengantarEktp().get(childPosition).getKdSurat();
        }
        return data;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        String childText = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_item, null);
        }

        TextView txtListChild = convertView.findViewById(R.id.lblListItem);

        txtListChild.setText(childText);

        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {

        if (groupPosition == 0) {
            ukuran = this._listDataChild.get(this._listDataHeader.get(groupPosition)).getSuratKelahiran().size();
        } else if (groupPosition == 1) {
            ukuran = this._listDataChild.get(this._listDataHeader.get(groupPosition)).getSuratUsaha().size();
        } else if (groupPosition == 2) {
            ukuran = this._listDataChild.get(this._listDataHeader.get(groupPosition)).getSuratKematian().size();
        } else if(groupPosition == 3) {
            ukuran = this._listDataChild.get(this._listDataHeader.get(groupPosition)).getSuratPengantarSkck().size();
        } else if(groupPosition == 4) {
            ukuran = this._listDataChild.get(this._listDataHeader.get(groupPosition)).getSuratWali().size();
        } else if(groupPosition == 5) {
            ukuran = this._listDataChild.get(this._listDataHeader.get(groupPosition)).getSuratBlmMenikah().size();
        } else if(groupPosition == 6) {
            ukuran = this._listDataChild.get(this._listDataHeader.get(groupPosition)).getSuratIzinKeramaian().size();
        } else if(groupPosition == 7) {
            ukuran = this._listDataChild.get(this._listDataHeader.get(groupPosition)).getSuratBepergian().size();
        } else if(groupPosition == 8) {
            ukuran = this._listDataChild.get(this._listDataHeader.get(groupPosition)).getSuratKehilangan().size();
        } else if(groupPosition == 9) {
            ukuran = this._listDataChild.get(this._listDataHeader.get(groupPosition)).getSuratTidakMampu().size();
        } else if(groupPosition == 10) {
            ukuran = this._listDataChild.get(this._listDataHeader.get(groupPosition)).getSuratDomisili().size();
        } else if(groupPosition == 11) {
            ukuran = this._listDataChild.get(this._listDataHeader.get(groupPosition)).getSuratPengantarEktp().size();
        }
        return ukuran;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group, null);

        }

        TextView lblListHeader = convertView.findViewById(R.id.lblListHeader);
        TextView lblJumlah = convertView.findViewById(R.id.lblJumlah);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);
        if(groupPosition == 0){
            lblJumlah.setText(Integer.toString(this._listDataChild.get(this._listDataHeader.get(groupPosition)).getSuratKelahiran().size()));
        }else if(groupPosition == 1){
            lblJumlah.setText(Integer.toString(this._listDataChild.get(this._listDataHeader.get(groupPosition)).getSuratUsaha().size()));
        }else if(groupPosition == 2){
            lblJumlah.setText(Integer.toString(this._listDataChild.get(this._listDataHeader.get(groupPosition)).getSuratKematian().size()));
        }else if(groupPosition == 3){
            lblJumlah.setText(Integer.toString(this._listDataChild.get(this._listDataHeader.get(groupPosition)).getSuratPengantarSkck().size()));
        }else if(groupPosition == 4){
            lblJumlah.setText(Integer.toString(this._listDataChild.get(this._listDataHeader.get(groupPosition)).getSuratWali().size()));
        }else if(groupPosition == 5){
            lblJumlah.setText(Integer.toString(this._listDataChild.get(this._listDataHeader.get(groupPosition)).getSuratBlmMenikah().size()));
        }else if(groupPosition == 6){
            lblJumlah.setText(Integer.toString(this._listDataChild.get(this._listDataHeader.get(groupPosition)).getSuratIzinKeramaian().size()));
        }else if(groupPosition == 7){
            lblJumlah.setText(Integer.toString(this._listDataChild.get(this._listDataHeader.get(groupPosition)).getSuratBepergian().size()));
        }else if(groupPosition == 8){
            lblJumlah.setText(Integer.toString(this._listDataChild.get(this._listDataHeader.get(groupPosition)).getSuratKehilangan().size()));
        }else if(groupPosition == 9){
            lblJumlah.setText(Integer.toString(this._listDataChild.get(this._listDataHeader.get(groupPosition)).getSuratTidakMampu().size()));
        }else if(groupPosition == 10){
            lblJumlah.setText(Integer.toString(this._listDataChild.get(this._listDataHeader.get(groupPosition)).getSuratDomisili().size()));
        }else if(groupPosition == 11){
            lblJumlah.setText(Integer.toString(this._listDataChild.get(this._listDataHeader.get(groupPosition)).getSuratPengantarEktp().size()));
        }



        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
