package id.awesometeam.covid_19symptomtracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.os.Bundle;

public class InformationVirusPreventionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_virus_prevention);
    }

    @Override
    public void onBackPressed() {
        supportFinishAfterTransition();
    }
}