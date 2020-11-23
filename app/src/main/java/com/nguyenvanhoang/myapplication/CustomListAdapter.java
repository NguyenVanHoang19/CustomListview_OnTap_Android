package com.nguyenvanhoang.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private List<Contry> contryList;

    public CustomListAdapter(Context context, List<Contry> contryList) {
        this.context = context;
        this.contryList = contryList;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return contryList.size();
    }

    @Override
    public Object getItem(int i) {
        return contryList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHodel hodel;
        if(view == null){
            view = layoutInflater.inflate(R.layout.item_dong_contry,null);
            hodel = new ViewHodel();
            hodel.flagView = (ImageView) view.findViewById(R.id.imgViewContry);
            hodel.nameView = (TextView) view.findViewById(R.id.tvName);
            hodel.populationView = (TextView) view.findViewById(R.id.tvPopulation);
            view.setTag(hodel);
        }
        else{
            hodel = (ViewHodel) view.getTag();
        }
        Contry contry =  this.contryList.get(i);
        hodel.nameView.setText(contry.getName());
        hodel.populationView.setText("Population: "+contry.getPopulation());
        int imgId = this.getMimapResId(contry.getFlag());
        hodel.flagView.setImageResource(imgId);
        return view ;
    }
    public int getMimapResId(String resName){
        String pkgName = context.getPackageName();
        int resID = context.getResources().getIdentifier(resName,"mipmap",pkgName);
        Log.i("Custom listview","Res Name: " + resName + "==> Res Id = " +  resID);
        return resID;
    }
    static class  ViewHodel{
        ImageView flagView;
        TextView nameView;
        TextView populationView;
    }
}
