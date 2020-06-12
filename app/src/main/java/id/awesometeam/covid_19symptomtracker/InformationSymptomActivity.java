package id.awesometeam.covid_19symptomtracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityOptionsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class InformationSymptomActivity extends AppCompatActivity {

    CardView cardSymptomCheck;
    ImageView ivSymptomCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_symptom);

        cardSymptomCheck = findViewById(R.id.cardSymptomCheck);
        ivSymptomCheck = findViewById(R.id.ivSymptomCheck);

        cardSymptomCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(InformationSymptomActivity.this, SymptomCheckActivity.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(InformationSymptomActivity.this, (View) ivSymptomCheck, "ivSymptomCheck");
                startActivity(i, options.toBundle());
            }
        });
    }

    @Override
    public void onBackPressed() {
        supportFinishAfterTransition();
    }
}