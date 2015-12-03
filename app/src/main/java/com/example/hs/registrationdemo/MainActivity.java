package com.example.hs.registrationdemo;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText etFirstName,etLastName,etDateOfBirth,etEmail,etPhone;
    TextView tvResult;
    private ImageButton btnCalendar;
    private Button btnSubmit;
    private Spinner spGender;
    private DatePicker datePicker;
    private Calendar calendar;
    private int year, month, day;
    String firstName,lastName,dateOfBirth,gender,email,phoneNumber;
    DataBaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFirstName = (EditText)findViewById(R.id.etFirstName);
        etLastName = (EditText)findViewById(R.id.etLastName);
        etDateOfBirth = (EditText)findViewById(R.id.etDateOfBirth);
        etEmail =(EditText)findViewById(R.id.etEmail);
        etPhone = (EditText)findViewById(R.id.etPhone);
        spGender = (Spinner)findViewById(R.id.spGender);
        tvResult = (TextView)findViewById(R.id.tvResult);

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);

        final String[] genderValue = {"Male","Female"};
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, genderValue);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spGender.setAdapter(dataAdapter);
        gender = spGender.getSelectedItem().toString();

    }


    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == 999) {
            return new DatePickerDialog(this, myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            // arg1 = year
            // arg2 = month
            // arg3 = day
            showDate(arg1, arg2+1, arg3);
        }
    };

    private void showDate(int year, int month, int day) {
        etDateOfBirth.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }


    public void setBtnSubmit(View v) {

        firstName = etFirstName.getText().toString();
        lastName = etLastName.getText().toString();
        dateOfBirth = etDateOfBirth.getText().toString();
        email = etEmail.getText().toString();
        phoneNumber = etPhone.getText().toString();
        db = new DataBaseHandler(this);
        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..");
        db.addContact(new Contact(firstName, lastName, dateOfBirth, gender, email, phoneNumber));
    }

    public void display(View v){
        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<Contact> contacts = db.getAllContacts();
        db = new DataBaseHandler(this);
        for (Contact cn : contacts) {
            String log = "Id: " + cn.getID() +"\n"+ " FirstName: " + cn.getFirstName()+"\n"
                    +  " LastName: " + cn.getLastName()+"\n" +  " Date of Birth: " + cn.getDateOfBirth()+"\n"
                    +  " Gender: " + cn.getGender()+"\n" +  " Email: " + cn.getEmail()+"\n"
                    +  " Phone: " + cn.getPhoneNumber();
            // Writing Contacts to log
            tvResult.setText(log);
        }
    }
}
