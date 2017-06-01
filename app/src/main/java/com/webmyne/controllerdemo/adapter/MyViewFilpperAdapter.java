package com.webmyne.controllerdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.webmyne.controllerdemo.R;

/**
 * Created by chiragpatel on 01-06-2017.
 */

public class MyViewFilpperAdapter extends BaseAdapter {
    Context context;
    int flags[];
    String[] countryNames;
    LayoutInflater inflter;

    public MyViewFilpperAdapter(Context context, int[] flags, String[] countryNames) {
        this.context = context;
        this.flags = flags;
        this.countryNames = countryNames;
        inflter = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return flags.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.custom_view_flipper, null);
        ImageView icon = (ImageView) view.findViewById(R.id.imageView);
        TextView names = (TextView) view.findViewById(R.id.txtFlipper);
        icon.setImageResource(flags[i]);
        names.setText(countryNames[i]);
        return view;
    }
}
