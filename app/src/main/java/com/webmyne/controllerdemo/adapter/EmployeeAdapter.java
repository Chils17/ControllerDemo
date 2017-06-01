package com.webmyne.controllerdemo.adapter;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.webmyne.controllerdemo.model.Employee;
import com.webmyne.controllerdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chiragpatel on 29-05-2017.
 */

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmploViewHolder> {

    private List<Employee> employeeList, filterList;
    private Context context;

    public EmployeeAdapter(Context context, List<Employee> employeeList) {
        this.employeeList = employeeList;
        this.context = context;
        this.filterList = new ArrayList<Employee>();
        this.filterList.addAll(employeeList);
    }

    @Override
    public EmploViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_row, parent, false);
        return new EmploViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EmploViewHolder holder, int position) {
        holder.setValues(filterList.get(position));
    }

    @Override
    public int getItemCount() {
        return filterList.size();
    }

    public void setDataList(List<Employee> data) {
        employeeList = new ArrayList<>();
        employeeList = data;
        employeeList.addAll(data);
        notifyDataSetChanged();
    }


    public void filter(final String text) {

        filterList.clear();

        if (TextUtils.isEmpty(text)) {

            filterList.addAll(employeeList);

        } else {

            Log.e("tag", "text:" + text);

            for (Employee employee : employeeList) {
                if (employee.getName().toLowerCase().contains(text.toLowerCase()) ||
                        employee.getGender().toLowerCase().contains(text.toLowerCase()) ||
                        employee.getEmail().toLowerCase().contains(text.toLowerCase()) ||
                        employee.getMobile().toLowerCase().contains(text.toLowerCase()) ||
                        employee.getSalary().toLowerCase().contains(text.toLowerCase()) ||
                        employee.getTax().toLowerCase().contains(text.toLowerCase()) ||
                        employee.getAddress().toLowerCase().contains(text.toLowerCase()) ||
                        employee.getDepartment().toLowerCase().contains(text.toLowerCase())) {

                    filterList.add(employee);
                }
            }
        }

        notifyDataSetChanged();

    }

    public class EmploViewHolder extends RecyclerView.ViewHolder {
        private TextView txtName;
        private TextView txtGender;
        private TextView txtEmail;
        private TextView txtMobile;
        private TextView txtSalary;
        private TextView txtTax;
        private TextView txtAddress;
        private TextView txtDepartment;

        public EmploViewHolder(View itemView) {
            super(itemView);

            txtName = (TextView) itemView.findViewById(R.id.txtName);
            txtGender = (TextView) itemView.findViewById(R.id.txtGender);
            txtEmail = (TextView) itemView.findViewById(R.id.txtEmail);
            txtMobile = (TextView) itemView.findViewById(R.id.txtMobile);
            txtSalary = (TextView) itemView.findViewById(R.id.txtSalary);
            txtTax = (TextView) itemView.findViewById(R.id.txtTax);
            txtAddress = (TextView) itemView.findViewById(R.id.txtAddress);
            txtDepartment = (TextView) itemView.findViewById(R.id.txtDepartment);
        }

        public void setValues(Employee employee) {
            Log.e("data", employee.getName());
            txtName.setText(employee.getName());
            txtGender.setText(employee.getGender());
            txtEmail.setText(employee.getEmail());
            txtMobile.setText(employee.getMobile());
            txtSalary.setText(employee.getSalary());
            txtTax.setText(employee.getTax());
            txtAddress.setText(employee.getAddress());
            txtDepartment.setText(employee.getDepartment());

            txtEmail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                    sendIntent.setType("plain/text");
                    sendIntent.setData(Uri.parse("from@gmail.com"));
                    sendIntent.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");
                    sendIntent.putExtra(Intent.EXTRA_EMAIL, new String[] { "to@gmail.com" });
                    sendIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                    sendIntent.putExtra(Intent.EXTRA_TEXT, "Description");
                    context.startActivity(sendIntent);

                    /*Intent sendIntent = new Intent(Intent.ACTION_SEND);
                    sendIntent.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");
                    sendIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"email@gmail.com"});
                    sendIntent.setData(Uri.parse("email@gmail.com"));
                    sendIntent.putExtra(Intent.EXTRA_SUBJECT, "enter subject");
                    sendIntent.setType("plain/text");
                    sendIntent.putExtra(Intent.EXTRA_TEXT, "Insert text");
                    context.startActivity(sendIntent);*/
                }
            });

            txtMobile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:+" + txtMobile.getText().toString().trim()));
                    if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }
                    context.startActivity(callIntent);
                }
            });

        }
    }
}
