package id.awesometeam.covid_19symptomtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class InformationVirusSpreadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_virus_spread);
    }
    
    @Override
    public void onBackPressed() {
        supportFinishAfterTransition();
    }
}