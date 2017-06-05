package com.webmyne.controllerdemo.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.webmyne.controllerdemo.R;
import com.webmyne.controllerdemo.model.User;

import java.util.ArrayList;

/**
 * Created by chiragpatel on 02-06-2017.
 */

public class AutoCompleteAdapter extends ArrayAdapter<User> {

    private ArrayList<User> userArrayList, tempCustomer, suggestions;

    public AutoCompleteAdapter(Context context, ArrayList<User> data) {
        super(context, android.R.layout.simple_list_item_1, data);
        this.userArrayList = data;
        this.tempCustomer = new ArrayList<User>(data);
        this.suggestions = new ArrayList<User>(data);
        Log.e("tag", "suggestions: " + suggestions);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        User customer = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.hint_completion_layout, parent, false);
        }
        TextView txtCustomer = (TextView) convertView.findViewById(R.id.tvHintCompletion);
        ImageView ivCustomerImage = (ImageView) convertView.findViewById(R.id.imgView);
        if (txtCustomer != null)
            txtCustomer.setText(customer.getName() + " ");
        if (ivCustomerImage != null && customer.getFlag() != 0)
            ivCustomerImage.setImageResource(customer.getFlag());

        if (position % 2 == 0)
            convertView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPurple));
        else
            convertView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorOrange));

        return convertView;
    }

    @Override
    public Filter getFilter() {
        return myFilter;
    }

    Filter myFilter = new Filter() {
        @Override
        public CharSequence convertResultToString(Object resultValue) {
            User customer = (User) resultValue;
            Log.e("tag", "customer.getName(): " + customer.getName());
            return customer.getName() + " ";
        }

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            Log.e("tag", "constraint: " + constraint);
            if (constraint != null) {
                suggestions.clear();
                for (User people : tempCustomer) {
                    if (people.getName().toLowerCase().contains(constraint.toString().toLowerCase())) {

                        suggestions.add(people);
                    }
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = suggestions;
                filterResults.count = suggestions.size();

                return filterResults;
            } else {
                return new FilterResults();
            }
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            Log.e("tag", "constraint 2 : " + constraint);
            ArrayList<User> c = (ArrayList<User>) results.values;
            if (results != null && results.count > 0) {
                clear();
                for (User user : c) {
                    add(user);
                    notifyDataSetChanged();
                }
            }
        }
    };
}
