package id.awesometeam.covid_19symptomtracker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "database.db";
    private static final int DATABASE_VERSION = 4;

    public static final String TABLE_NAME = "symptom";

    public static final int DEMAM_SCORE = 25;
    public static final int BATUK_KERING_SCORE = 40;
    public static final int SESAK_NAPAS_SCORE = 35;

    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        String sql = "CREATE TABLE " + TABLE_NAME + "(" +
                "id integer primary key, " +
                "demam text null, " +
                "batuk_kering text null, " +
                "sesak_napas text null, " +
                "datetime text null)";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public static String getDatetime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        return dtf.format(now);
    }

    public void insert(String demam, String batuk_kering, String sesak_napas, String datetime) {
        SQLiteDatabase database = this.getWritableDatabase();

        String queryValues = "INSERT INTO " + TABLE_NAME + "(demam, batuk_kering, sesak_napas, datetime) " +
                "VALUES ('" + demam + "', '" + batuk_kering + "', '" + sesak_napas + "', '" + datetime + "')";

        Log.e("insert sqlite ", "" + queryValues);
        database.execSQL(queryValues);
        database.close();
    }

    public void update(String id, String deman, String batuk_kering, String sesak_napas) {
        SQLiteDatabase database = this.getWritableDatabase();

        String updateQuery = "UPDATE " + TABLE_NAME + " SET"
                + " demam ='" + deman + "', "
                + " batuk_kering = '" + batuk_kering + "', "
                + " sesak_napas = '" + sesak_napas + "'"
                + " WHERE id = '" + id + "'";

        Log.e("update sqlite ", updateQuery);
        database.execSQL(updateQuery);
        database.close();
    }

    public void delete(String id) {
        SQLiteDatabase database = this.getWritableDatabase();

        String updateQuery = "DELETE FROM " + TABLE_NAME + " WHERE id='" + id + "'";
        Log.e("update sqlite ", updateQuery);
        database.execSQL(updateQuery);
        database.close();
    }

    public void insertDummyData() {
        insert("true", "true", "true", getDatetime());
        insert("true", "true", "false", getDatetime());
        insert("true", "false", "true", getDatetime());
        insert("false", "false", "false", getDatetime());
        insert("false", "true", "true", getDatetime());
        insert("false", "true", "false", getDatetime());
    }
}
