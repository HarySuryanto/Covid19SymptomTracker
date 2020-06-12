package id.awesometeam.covid_19symptomtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DetailSymptomHistoryActivity extends AppCompatActivity {

    TextView tvDemam, tvBatukKering, tvSesakNapas, tvResult, tvDatetime;

    protected Cursor cursor;
    DataHelper dbHelper = new DataHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_symptom_history);

        tvDemam = findViewById(R.id.tvDemam);
        tvBatukKering = findViewById(R.id.tvBatukKering);
        tvSesakNapas = findViewById(R.id.tvSesakNapas);
        tvResult = findViewById(R.id.tvResult);
        tvDatetime = findViewById(R.id.tvDatetime);

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM " + DataHelper.TABLE_NAME + " WHERE id='" + getIntent().getStringExtra("id") + "' LIMIT 1", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);

            tvDemam.setText(cursor.getString(1).equals("true") ? "YA" : "TIDAK");
            tvBatukKering.setText(cursor.getString(2).equals("true") ? "YA" : "TIDAK");
            tvSesakNapas.setText(cursor.getString(3).equals("true") ? "YA" : "TIDAK");
            tvDatetime.setText(cursor.getString(4));

            int demam_score = (cursor.getString(1).equals("true")) ? dbHelper.DEMAM_SCORE : 0;
            int batuk_kering_score = (cursor.getString(2).equals("true")) ? dbHelper.BATUK_KERING_SCORE : 0;
            int sesak_napas_score = (cursor.getString(3).equals("true")) ? dbHelper.SESAK_NAPAS_SCORE : 0;

            int result = demam_score + batuk_kering_score + sesak_napas_score;

            tvResult.setText((result + "%"));
        }
    }
}