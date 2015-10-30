package shugal.com.msanjeevani;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by abhishek on 31/10/15.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "Sanjeevani";

    // Table Names
    private static final String KEY_ID = "id";
    private static final String TABLE_DOCTORS = "doctors";
    private static final String TABLE_APPOINTMENTS = "appointments";
    private static final String TABLE_HOSPITALS = "hospitals";



    // DOCTOR TABLE
    private static final String KEY_DOCTOR = "doctor";
    private static final String KEY_HOSPITAL = "hospital";


    // APPOINTMENT TABLE
    private static final String KEY_NAME = "name";
    private static final String KEY_AGE = "age";
    private static final String KEY_GENDER = "sex";
    // hospital
    // doctor
    private static final String KEY_DATE = "date";
    private static final String KEY_TIME = "time";


    // Hospital Database
    //hospital name
    private static final String KEY_ADDRESS = "date";
    private static final String KEY_PHONE = "phone";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table if not exists " + TABLE_DOCTORS + "(" +
                KEY_ID + " integer primary key autoincrement, " +
                KEY_DOCTOR + " string, " +
                KEY_HOSPITAL + " string);";

        db.execSQL(query);

        query = "create table if not exists " + TABLE_APPOINTMENTS + "(" +
                KEY_ID + " integer primary key autoincrement, " +
                KEY_NAME + " string, " +
                KEY_AGE + " int, " +
                KEY_GENDER + " string, " +
                KEY_HOSPITAL + " string, " +
                KEY_DOCTOR + " string, " +
                KEY_DATE + " string, " +
                KEY_TIME + " string);";

        db.execSQL(query);

        /*query = "create table if not exists " + TABLE_APPOINTMENTS + "(" +
                KEY_ID + " integer primary key autoincrement, " +
                KEY_HOSPITAL + " string, " +
                KEY_ADDRESS + " string, " +
                KEY_PHONE + " string);";

        db.execSQL(query);*/

        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_APPOINTMENTS);
        db.execSQL("drop table if exists " + TABLE_DOCTORS);
        db.execSQL("drop table if exists " + TABLE_HOSPITALS);
        onCreate(db);
        db.close();
    }


    public void addAppointment(AppointmentData data) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, data.getPatient_name());
        values.put(KEY_AGE, data.getAge());
        values.put(KEY_GENDER, data.getGender());
        values.put(KEY_HOSPITAL, data.getHospital());
        values.put(KEY_DOCTOR, data.getDoctor());
        values.put(KEY_DATE, data.getDate());
        values.put(KEY_TIME, data.getTime());
        db.insert(TABLE_APPOINTMENTS, null, values);

        db.close();
    }

    public ArrayList<AppointmentData> showAppointments() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<AppointmentData> tdata = new ArrayList<>();
        String query = "Select * from " + TABLE_APPOINTMENTS + " order by id desc";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                AppointmentData data = new AppointmentData();
                data.setId(Integer.parseInt(cursor.getString(0)));
                data.setPatient_name(cursor.getString(1));
                data.setAge(Integer.parseInt(cursor.getString(2)));
                data.setGender(cursor.getString(3));
                data.setHospital(cursor.getString(4));
                data.setDoctor(cursor.getString(5));
                data.setDate(cursor.getString(6));
                data.setTime(cursor.getString(7));
                tdata.add(data);
            } while (cursor.moveToNext());
        }

        db.close();
        return tdata;
    }

    public boolean isAppointmentListEmpty() {
        SQLiteDatabase db = this.getReadableDatabase();
        String count = "SELECT count(*) FROM " + TABLE_APPOINTMENTS;
        Cursor mcursor = db.rawQuery(count, null);
        mcursor.moveToFirst();
        int icount = mcursor.getInt(0);

        if (icount > 0) {
            db.close();
            return false;
        } else {
            db.close();
            return true;
        }
    }






















    public void deleteFirstValues() {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_APPOINTMENTS, KEY_ID + " = ?",
                new String[]{String.valueOf(1)});

        db.delete(TABLE_DOCTORS, KEY_ID + " = ?",
                new String[]{String.valueOf(1)});

        db.delete(TABLE_HOSPITALS, KEY_ID + " = ?",
                new String[]{String.valueOf(1)});
        db.close();
    }
}
