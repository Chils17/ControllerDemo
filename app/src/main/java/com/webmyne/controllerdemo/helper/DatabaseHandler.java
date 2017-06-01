package com.webmyne.controllerdemo.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.webmyne.controllerdemo.model.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chiragpatel on 30-05-2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "contactsManager";

    // Contacts table name
    private static final String TABLE_CONTACTS = "employee";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_GENDER = "gender";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_MOBILE = "mobile";
    private static final String KEY_SALARY = "salary";
    private static final String KEY_TAX = "tax";
    private static final String KEY_ADDRESS = "address";
    private static final String KEY_DEPARTMENT = "department";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_NAME + " TEXT,"
                + KEY_GENDER + " TEXT,"
                + KEY_EMAIL + " TEXT,"
                + KEY_MOBILE + " TEXT,"
                + KEY_SALARY + " TEXT,"
                + KEY_TAX + " TEXT,"
                + KEY_ADDRESS + " TEXT,"
                + KEY_DEPARTMENT + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        // Create tables again
        onCreate(db);
    }

    //show list in recycler view
    public List<Employee> listEmployee() {
        String sql = "select * from " + TABLE_CONTACTS;
        SQLiteDatabase db = this.getReadableDatabase();
        List<Employee> employeeList = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                int id = Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);
                String gender = cursor.getString(2);
                String email = cursor.getString(3);
                String mobile = cursor.getString(4);
                String salary = cursor.getString(5);
                String tax = cursor.getString(6);
                String address = cursor.getString(7);
                String department = cursor.getString(8);
                //String department = cursor.getString(cursor.getColumnIndexOrThrow("employee"));

                employeeList.add(new Employee(id, name, gender, email, mobile, salary, tax, address, department));

            } while (cursor.moveToNext());
        }
        cursor.close();
        return employeeList;
    }

    //insert employee
    public void addProduct(Employee employee) {
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, employee.getName());
        values.put(KEY_GENDER, employee.getGender());
        values.put(KEY_EMAIL, employee.getEmail());
        values.put(KEY_MOBILE, employee.getMobile());
        values.put(KEY_SALARY, employee.getSalary());
        values.put(KEY_TAX, employee.getTax());
        values.put(KEY_ADDRESS, employee.getAddress());
        values.put(KEY_DEPARTMENT, employee.getDepartment());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_CONTACTS, null, values);
    }
}
