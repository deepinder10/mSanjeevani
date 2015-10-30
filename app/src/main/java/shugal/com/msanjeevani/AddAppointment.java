package shugal.com.msanjeevani;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class AddAppointment extends AppCompatActivity {

    TextInputLayout nameLayout, ageLayout, dateLayout, timeLayout;
    EditText nameTxt, ageTxt, dateTxt, timeTxt;
    Spinner hospitalSpinner, doctorSpinner;

    final int TIME_DIALOG = 0, DATE_DIALOG = 1;


    Calendar calender = Calendar.getInstance();
    //String date = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_appointment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Add Appointment");

        nameLayout = (TextInputLayout) findViewById(R.id.nameLayout);
        ageLayout = (TextInputLayout) findViewById(R.id.ageLayout);
        dateLayout = (TextInputLayout) findViewById(R.id.dateLayout);
        timeLayout = (TextInputLayout) findViewById(R.id.timeLayout);

        nameTxt = (EditText) findViewById(R.id.nameTxt);
        ageTxt = (EditText) findViewById(R.id.ageTxt);
        dateTxt = (EditText) findViewById(R.id.dateTxt);
        timeTxt = (EditText) findViewById(R.id.timeTxt);

        hospitalSpinner = (Spinner) findViewById(R.id.hospitalSpinner);
        doctorSpinner = (Spinner) findViewById(R.id.doctorSpinner);

        nameTxt.addTextChangedListener(new MyTextWatcher(nameTxt));
        ageTxt.addTextChangedListener(new MyTextWatcher(ageTxt));
        dateTxt.addTextChangedListener(new MyTextWatcher(dateTxt));
        timeTxt.addTextChangedListener(new MyTextWatcher(timeTxt));

    }

    public void launchDatePicker(View view) {
        showDialog(DATE_DIALOG);
    }

    public void launchTimePicker(View view) {
        showDialog(TIME_DIALOG);
    }

    public void addApointment(View view) {
        if (!validateName()) {
            return;
        }

        if (!validateAge()) {
            return;
        }

        if (!validateDate()) {
            return;
        }

        if (!validateTime()) {
            return;
        }

        //DatabaseHelper db = new DatabaseHelper(this);
        //data.setLecture_number(Integer.parseInt(lectureNumber.getText().toString()));
        //db.addTimetableSlot(data);
        //db.close();
        launchStatusDialog();
        finish();
    }

    @Override
    public Dialog onCreateDialog(int id) {

        if (id == DATE_DIALOG) {
            return new DatePickerDialog(this,
                    dPickerListener,
                    calender.get(Calendar.YEAR),
                    calender.get(Calendar.MONTH)+1,
                    calender.get(Calendar.DAY_OF_MONTH));

        } else if (id == TIME_DIALOG) {
            return new TimePickerDialog(this,
                    mTimeSetListener, calender.get(Calendar.HOUR), calender.get(Calendar.MINUTE), false);
        }

        return null;
    }

    private String makeDate(int day_of_month, int month, int year) {
        String date = day_of_month + " " + makeMonth(month) + " " + year;
        return date;
    }

    private String makeMonth(int month) {
        String mMonth = "";
        if (month == 1) {
            mMonth = "January";
        } else if (month == 2) {
            mMonth = "February";
        } else if (month == 3) {
            mMonth = "March";
        } else if (month == 4){
            mMonth = "April";
        } else if (month == 5) {
            mMonth = "May";
        } else if (month == 6) {
            mMonth = "June";
        } else if (month == 7) {
            mMonth = "July";
        } else if (month == 8) {
            mMonth = "August";
        } else if (month == 9) {
            mMonth = "September";
        } else if (month == 10) {
            mMonth = "October";
        } else if (month == 11) {
            mMonth = "November";
        } else if (month == 12) {
            mMonth = "December";
        }

        return mMonth;
    }

    private void launchStatusDialog() {
        Toast.makeText(getApplicationContext(), "HHH", Toast.LENGTH_SHORT).show();
    }

    private boolean validateTime() {
        if (timeTxt.getText().toString().trim().isEmpty()) {
            timeLayout.setError("Please Enter a time");
            requestFocus(timeTxt);
            return false;
        } else {
            timeLayout.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateDate() {
        if (dateTxt.getText().toString().trim().isEmpty()) {
            dateLayout.setError("Please Enter Date");
            requestFocus(dateTxt);
            return false;
        } else {
            dateLayout.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateAge() {
        if (ageTxt.getText().toString().trim().isEmpty()) {
            ageLayout.setError("Please Enter your Age");
            requestFocus(ageTxt);
            return false;
        } else {
            ageLayout.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateName() {
        if (nameTxt.getText().toString().trim().isEmpty()) {
            nameLayout.setError("Please Enter your Name");
            requestFocus(nameTxt);
            return false;
        } else {
            nameLayout.setErrorEnabled(false);
        }

        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.nameTxt:
                    validateName();
                    break;
                case R.id.ageTxt:
                    validateAge();
                    break;

                case R.id.dateTxt:
                    validateDate();
                    break;
                case R.id.timeTxt:
                    validateTime();
                    break;
            }
        }
    }

    private DatePickerDialog.OnDateSetListener dPickerListener = new DatePickerDialog.OnDateSetListener() {


        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

            String message = makeDate(dayOfMonth, (monthOfYear+1), year);
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
            dateTxt.setText(message);

        }
    };

    private TimePickerDialog.OnTimeSetListener mTimeSetListener =
            new TimePickerDialog.OnTimeSetListener() {
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    String message = pad(hourOfDay) + ":" + pad(minute);
                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                    timeTxt.setText(message);
                }
            };

    private static String pad(int c) {
        if (c >= 10)
            return String.valueOf(c);
        else
            return "0" + String.valueOf(c);
    }
}
