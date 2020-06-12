package id.awesometeam.covid_19symptomtracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static id.awesometeam.covid_19symptomtracker.DataHelper.TABLE_NAME;

public class SymptomHistoryEditActivity extends AppCompatActivity {

    TextView tvResult;
    Button btnResult, btnUpdate;
    ImageView ivSymptomHistory;
    CardView cardResult;

    RadioGroup rgDemam, rgBatukKering, rgSesakNapas;

    protected Cursor cursor;
    DataHelper dbHelper = new DataHelper(this);

    String demam, batuk_kering, sesak_napas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptom_history_edit);

        tvResult = findViewById(R.id.tvResult);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnResult = findViewById(R.id.btnResult);
        ivSymptomHistory = findViewById(R.id.ivSymptomHistory);
        cardResult = findViewById(R.id.cardResult);

        rgDemam = findViewById(R.id.rgDemam);
        rgBatukKering = findViewById(R.id.rgBatukKering);
        rgSesakNapas = findViewById(R.id.rgSesakNapas);

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM " + DataHelper.TABLE_NAME + " WHERE id='" + getIntent().getStringExtra("id") + "' LIMIT 1", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);

            boolean demam_bool;
            if (cursor.getString(1).equals("true")) {
                demam_bool = true;
                demam = "true";
                rgDemam.check(R.id.rbDemamTrue);
            } else {
                demam_bool = false;
                demam = "false";
                rgDemam.check(R.id.rbDemamFalse);
            }

            boolean batuk_kering_bool;
            if (cursor.getString(2).equals("true")) {
                batuk_kering_bool = true;
                batuk_kering = "true";
                rgBatukKering.check(R.id.rbBatukKeringTrue);
            } else {
                batuk_kering_bool = false;
                batuk_kering = "false";
                rgBatukKering.check(R.id.rbBatukKeringFalse);
            }

            boolean sesak_napas_bool;
            if (cursor.getString(3).equals("true")) {
                sesak_napas_bool = true;
                sesak_napas = "true";
                rgSesakNapas.check(R.id.rbSesakNapasTrue);
            } else {
                sesak_napas_bool = false;
                sesak_napas = "false";
                rgSesakNapas.check(R.id.rbSesakNapasFalse);
            }

            int demam_score = (demam_bool) ? dbHelper.DEMAM_SCORE : 0;
            int batuk_kering_score = (batuk_kering_bool) ? dbHelper.BATUK_KERING_SCORE : 0;
            int sesak_napas_score = (sesak_napas_bool) ? dbHelper.SESAK_NAPAS_SCORE : 0;

            int result = demam_score + batuk_kering_score + sesak_napas_score;

            tvResult.setText((result + "%"));
        }

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (demam == null || batuk_kering == null || sesak_napas == null) {
                    Toast.makeText(getApplicationContext(), "Mohon jawab semua pertanyaan.", Toast.LENGTH_LONG).show();
                } else {
                    int demam_score = (demam.equals("true")) ? dbHelper.DEMAM_SCORE : 0;
                    int batuk_kering_score = (batuk_kering.equals("true")) ? dbHelper.BATUK_KERING_SCORE : 0;
                    int sesak_napas_score = (sesak_napas.equals("true")) ? dbHelper.SESAK_NAPAS_SCORE : 0;

                    int result = demam_score + batuk_kering_score + sesak_napas_score;

                    tvResult.setText((result + "%"));

                    cardResult.setVisibility(View.VISIBLE);
                    btnUpdate.setVisibility(View.VISIBLE);
                }
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Save the data to database
                dbHelper.update(getIntent().getStringExtra("id"), demam, batuk_kering, sesak_napas);
                Toast.makeText(getApplicationContext(), "Data diubah", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        ivSymptomHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SymptomHistoryEditActivity.this, SymptomHistoryActivity.class));
            }
        });
    }

    // setDemam
    public void setDemam(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.rbDemamTrue:
                if (checked) {
                    demam = "true";
                }
                break;
            case R.id.rbDemamFalse:
                if (checked) {
                    demam = "false";
                }
                break;
        }
    }

    // setBatukKering
    public void setBatukKering(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.rbBatukKeringTrue:
                if (checked) {
                    batuk_kering = "true";
                }
                break;
            case R.id.rbBatukKeringFalse:
                if (checked) {
                    batuk_kering = "false";
                }
                break;
        }
    }

    // setSesakNapas
    public void setSesakNapas(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.rbSesakNapasTrue:
                if (checked) {
                    sesak_napas = "true";
                }
                break;
            case R.id.rbSesakNapasFalse:
                if (checked) {
                    sesak_napas = "false";
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {
        supportFinishAfterTransition();
    }
}