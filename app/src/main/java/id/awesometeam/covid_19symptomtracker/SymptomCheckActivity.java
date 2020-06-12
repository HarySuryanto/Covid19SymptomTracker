package id.awesometeam.covid_19symptomtracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityOptionsCompat;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static id.awesometeam.covid_19symptomtracker.DataHelper.TABLE_NAME;

public class SymptomCheckActivity extends AppCompatActivity {

    TextView tvResult;
    Button btnResult, btnSave;
    ImageView ivSymptomHistory;
    CardView cardResult, cardLinkToSymptomHistory;

    DataHelper dbHelper = new DataHelper(this);

    String demam, batuk_kering, sesak_napas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptom_check);

        tvResult = findViewById(R.id.tvResult);
        btnSave = findViewById(R.id.btnSave);
        btnResult = findViewById(R.id.btnResult);
        ivSymptomHistory = findViewById(R.id.ivSymptomHistory);
        cardResult = findViewById(R.id.cardResult);
        cardLinkToSymptomHistory = findViewById(R.id.cardLinkToSymptomHistory);

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
                    btnSave.setVisibility(View.VISIBLE);
                }
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Save the data to database
                dbHelper.insert(demam, batuk_kering, sesak_napas, dbHelper.getDatetime());
                Toast.makeText(getApplicationContext(), "Data disimpan", Toast.LENGTH_SHORT).show();
            }
        });

        ivSymptomHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SymptomCheckActivity.this, SymptomHistoryActivity.class));
            }
        });

        cardLinkToSymptomHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SymptomCheckActivity.this, SymptomHistoryActivity.class));
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