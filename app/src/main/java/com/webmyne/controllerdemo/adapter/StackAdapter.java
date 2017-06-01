package com.webmyne.controllerdemo.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.webmyne.controllerdemo.R;
import com.webmyne.controllerdemo.model.StackItem;

import java.util.List;

/**
 * Created by chiragpatel on 01-06-2017.
 */

public class StackAdapter extends ArrayAdapter<StackItem> {
    private List<StackItem> items;
    private Context context;

    public StackAdapter(Context context, int textViewResourceId,List<StackItem> objects) {
        super(context, textViewResourceId, objects);
        this.items = objects;
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = layoutInflater.inflate(R.layout.stack_item, null);
        }
        StackItem stackItem = items.get(position);
        if (stackItem != null) {

            TextView textView = (TextView) itemView.findViewById(R.id.textView);

            ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);


            if (textView != null) {
                textView.setText(stackItem.getItemText());

                String imageName = stackItem.getImageName();

                int resId = this.getDrawableResIdByName(imageName);

                imageView.setImageResource(resId);
               // imageView.setBackgroundColor(Color.rgb(211, 204, 188));
            }

        }
        return itemView;
    }


    public int getDrawableResIdByName(String resName) {
        String pkgName = context.getPackageName();

        int resID = context.getResources().getIdentifier(resName, "drawable", pkgName);
        Log.i("MyLog", "Res Name: " + resName + "==> Res ID = " + resID);
        return resID;
    }
}
