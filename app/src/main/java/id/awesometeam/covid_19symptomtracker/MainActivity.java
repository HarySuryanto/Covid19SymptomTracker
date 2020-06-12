package id.awesometeam.covid_19symptomtracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvSymptomInformation, tvDeveloperTitle;
    CardView cardVirusSpread, cardVirusPrevention, cardLinkToDeveloperList, cardDeveloperPict1, cardDeveloperPict2, cardDeveloperPict3, cardDeveloperPict4, cardDeveloperPict5;
    ImageView ivVirusSpread, ivVirusPrevention, ivSymptomFiver, ivSymptomCough, ivSymptomBreathe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSymptomInformation = findViewById(R.id.tvSymptomInformation);
        cardVirusSpread = findViewById(R.id.cardVirusSpread);
        cardVirusPrevention = findViewById(R.id.cardVirusPrevention);
        cardLinkToDeveloperList = findViewById(R.id.cardLinkToDeveloperList);

        ivVirusSpread = findViewById(R.id.ivVirusSpread);
        ivVirusPrevention = findViewById(R.id.ivVirusPrevention);
        ivSymptomFiver = findViewById(R.id.ivSymptomFiver);
        ivSymptomCough = findViewById(R.id.ivSymptomCough);
        ivSymptomBreathe = findViewById(R.id.ivSymptomBreathe);

        tvDeveloperTitle = findViewById(R.id.tvDeveloperTitle);
        cardDeveloperPict1 = findViewById(R.id.cardDeveloperPict1);
        cardDeveloperPict2 = findViewById(R.id.cardDeveloperPict2);
        cardDeveloperPict3 = findViewById(R.id.cardDeveloperPict3);
        cardDeveloperPict4 = findViewById(R.id.cardDeveloperPict4);
        cardDeveloperPict5 = findViewById(R.id.cardDeveloperPict5);

        cardVirusSpread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, InformationVirusSpreadActivity.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(MainActivity.this, (View) ivVirusSpread, "ivVirusSpread");
                startActivity(i, options.toBundle());
            }
        });

        cardVirusPrevention.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, InformationVirusPreventionActivity.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(MainActivity.this, (View) ivVirusPrevention, "ivVirusPrevention");
                startActivity(i, options.toBundle());
            }
        });

        tvSymptomInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, InformationSymptomActivity.class);

                Pair<View, String> p1 = Pair.create((View) ivSymptomFiver, "ivSymptomFiver");
                Pair<View, String> p2 = Pair.create((View) ivSymptomCough, "ivSymptomCough");
                Pair<View, String> p3 = Pair.create((View) ivSymptomBreathe, "ivSymptomBreathe");
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(MainActivity.this, (Pair<View, String>) p1, p2, p3);
                startActivity(i, options.toBundle());
            }
        });

        cardLinkToDeveloperList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, DeveloperListActivity.class);

                Pair<View, String> title = Pair.create((View) tvDeveloperTitle, "tvDeveloperTitle");
                Pair<View, String> p1 = Pair.create((View) cardDeveloperPict1, "cardDeveloperPict1");
                Pair<View, String> p2 = Pair.create((View) cardDeveloperPict2, "cardDeveloperPict2");
                Pair<View, String> p3 = Pair.create((View) cardDeveloperPict3, "cardDeveloperPict3");
                Pair<View, String> p4 = Pair.create((View) cardDeveloperPict4, "cardDeveloperPict4");
                Pair<View, String> p5 = Pair.create((View) cardDeveloperPict5, "cardDeveloperPict5");
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(MainActivity.this, (Pair<View, String>) title, p1, p2, p3, p4, p5);
                startActivity(i, options.toBundle());
            }
        });
    }

}