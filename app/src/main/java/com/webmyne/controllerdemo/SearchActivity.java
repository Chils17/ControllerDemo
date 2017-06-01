package com.webmyne.controllerdemo;

import android.content.DialogInterface;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.webmyne.controllerdemo.adapter.EmployeeAdapter;
import com.webmyne.controllerdemo.helper.DatabaseHandler;
import com.webmyne.controllerdemo.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private RecyclerView recyclerview;
    private ArrayList<Employee> employeeList;
    private EmployeeAdapter employeeAdapter;
    private SearchView mSearchView;
    private TextView emptyView;
    private FloatingActionButton fab;
    private DatabaseHandler mDatabase;
    private String department;
    private String gender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        init();
    }

    private void init() {
        mSearchView = (SearchView) findViewById(R.id.search_view);
        recyclerview = (RecyclerView) findViewById(R.id.recycler_view);
        emptyView = (TextView) findViewById(R.id.empty_view);
        fab = (FloatingActionButton) findViewById(R.id.fab);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setHasFixedSize(true);

        mDatabase = new DatabaseHandler(this);

        //setEmployeeList();


        List<Employee> allEmployee = mDatabase.listEmployee();

        if (allEmployee.size() > 0) {
            recyclerview.setVisibility(View.VISIBLE);
            employeeAdapter = new EmployeeAdapter(this, allEmployee);
            recyclerview.setAdapter(employeeAdapter);
        } else {
            recyclerview.setVisibility(View.GONE);
            Toast.makeText(this, "There is no product in the database. Start adding now", Toast.LENGTH_LONG).show();
        }

        //employeeAdapter = new EmployeeAdapter(this, employeeList);
        //recyclerview.setAdapter(employeeAdapter);

        setupSearchView();

        clickListener();
    }

    private void clickListener() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // add new quick task
                addTaskDialog();
            }
        });
    }

    private void addTaskDialog() {

        LayoutInflater inflater = LayoutInflater.from(this);
        View subView = inflater.inflate(R.layout.add_emplyee_layout, null);

        final EditText edtName = (EditText) subView.findViewById(R.id.edtName);

        final RadioGroup radioGroupGender = (RadioGroup) subView.findViewById(R.id.radioGroupGender);

        RadioButton radMale = (RadioButton) subView.findViewById(R.id.radioMan);
        RadioButton radFemale = (RadioButton) subView.findViewById(R.id.radioFemale);

        final EditText edtEmail = (EditText) subView.findViewById(R.id.edtEmail);
        final EditText edtMobile = (EditText) subView.findViewById(R.id.edtMobile);
        final EditText edtSalary = (EditText) subView.findViewById(R.id.edtSalary);
        final EditText edtTax = (EditText) subView.findViewById(R.id.edtTax);
        final EditText edtAddress = (EditText) subView.findViewById(R.id.edtAddress);
        final Spinner spinDepartment = (Spinner) subView.findViewById(R.id.spinDepartment);


        final Button btnOK = (Button) subView.findViewById(R.id.btn_ok);
        final Button btnCancel = (Button) subView.findViewById(R.id.btn_cancel);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Add new Employee");
        builder.setView(subView);
        builder.setCancelable(false);

        final AlertDialog dialog = builder.create();

        dialog.show();

        radioGroupGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int checkedId) {
                int radioButtonId = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton) radioGroup.findViewById(radioButtonId);
                gender = radioButton.getText().toString();
            }
        });


        spinDepartment.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                department = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnOK.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                String email = edtEmail.getText().toString();
                String mobile = edtMobile.getText().toString();
                String salary = edtSalary.getText().toString();
                String tax = edtTax.getText().toString();
                String address = edtAddress.getText().toString();

                //String department = spinDepartment.toString();

                if (!name.isEmpty() && !gender.isEmpty() && !email.isEmpty() && !mobile.isEmpty() && !salary.isEmpty() && !tax.isEmpty() && !address.isEmpty() && !department.isEmpty()) {
                    Employee employee = new Employee(name, gender, email, mobile, salary, tax, address, department);
                    mDatabase.addProduct(employee);
                    //refresh the activity
                    finish();
                    startActivity(getIntent());
                    dialog.dismiss();

                } else {
                    Toast.makeText(SearchActivity.this, "Fields are empty....!", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }


    /*private void setEmployeeList() {
        employeeList = new ArrayList<>();

        employeeList.add(new Employee("Chirag", "ckp17291@gmail.com", "C1234YGA", "10000", "12%", "1345-Abrama, Navsari", "Navsari"));
        employeeList.add(new Employee("Krishna", "ksn@gmail.com", "k1234YGA", "25000", "5%", "981-monal, madhay", "Madhyaprdesh"));
        employeeList.add(new Employee("Sagar", "sgr@gmail.com", "B1234YGA", "15000", "11%", "345-godhra, Godhra", "Godhra"));
        employeeList.add(new Employee("Anis", "ans@gmail.com", "D1234YGA", "12000", "10%", "135-shusan, vadodara", "Baroda"));
        employeeList.add(new Employee("Ishan", "isn@gmail.com", "E1234YGA", "19000", "9%", "451-makarpura, baroda", "vadodara"));
        employeeList.add(new Employee("Vatsal", "vatsal@gmail.com", "F1234YGA", "11000", "8%", "545-subhanpura, baroda", "baroda"));
        employeeList.add(new Employee("Gulam", "glm@gmail.com", "H1234YGA", "16000", "7%", "234-sakri, baroda", "baroda"));
        employeeList.add(new Employee("Mehul", "mhl@gmail.com", "L1234YGA", "14000", "8%", "675-vedch, bharuch", "bharuch"));
        employeeList.add(new Employee("Shailesh", "shls@gmail.com", "N1234YGA", "20000", "9%", "932-sayla, Surendranagar", "Surendranagar"));
        employeeList.add(new Employee("Ankur", "akr@gmail.com", "Q1234YGA", "21000", "3%", "132-todi, Navsari", "Navsari"));

    }*/

    private void setupSearchView() {
        mSearchView.setIconifiedByDefault(false);
        mSearchView.setOnQueryTextListener(this);
        mSearchView.setQueryHint("Searching");
    }

    public boolean onQueryTextChange(String newText) {

        employeeAdapter.filter(newText);

        Log.e("tag", "employeeAdapter.getItemCount(): " + employeeAdapter.getItemCount());

        if (employeeAdapter.getItemCount() == 0) {
            recyclerview.setVisibility(View.GONE);
            emptyView.setVisibility(View.VISIBLE);
        } else {
            recyclerview.setVisibility(View.VISIBLE);
            emptyView.setVisibility(View.GONE);
        }

        return true;
    }


    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mDatabase != null) {
            mDatabase.close();
        }
    }

}
