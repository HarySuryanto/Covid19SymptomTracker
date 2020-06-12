package id.awesometeam.covid_19symptomtracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DeveloperListActivity extends AppCompatActivity {

    CardView cardLinkToDeveloper1, cardLinkToDeveloper2, cardLinkToDeveloper3, cardLinkToDeveloper4, cardLinkToDeveloper5;
    CardView cardDeveloperPict1, cardDeveloperPict2, cardDeveloperPict3, cardDeveloperPict4, cardDeveloperPict5;
    TextView tvDeveloperName1, tvDeveloperName2, tvDeveloperName3, tvDeveloperName4, tvDeveloperName5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer_list);

        cardLinkToDeveloper1 = findViewById(R.id.cardLinkToDeveloper1);
        cardLinkToDeveloper2 = findViewById(R.id.cardLinkToDeveloper2);
        cardLinkToDeveloper3 = findViewById(R.id.cardLinkToDeveloper3);
        cardLinkToDeveloper4 = findViewById(R.id.cardLinkToDeveloper4);
        cardLinkToDeveloper5 = findViewById(R.id.cardLinkToDeveloper5);

        cardDeveloperPict1 = findViewById(R.id.cardDeveloperPict1);
        cardDeveloperPict2 = findViewById(R.id.cardDeveloperPict2);
        cardDeveloperPict3 = findViewById(R.id.cardDeveloperPict3);
        cardDeveloperPict4 = findViewById(R.id.cardDeveloperPict4);
        cardDeveloperPict5 = findViewById(R.id.cardDeveloperPict5);

        tvDeveloperName1 = findViewById(R.id.tvDeveloperName1);
        tvDeveloperName2 = findViewById(R.id.tvDeveloperName2);
        tvDeveloperName3 = findViewById(R.id.tvDeveloperName3);
        tvDeveloperName4 = findViewById(R.id.tvDeveloperName4);
        tvDeveloperName5 = findViewById(R.id.tvDeveloperName5);

        cardLinkToDeveloper1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DeveloperListActivity.this, DeveloperAgryActivity.class);

                Pair<View, String> p1 = Pair.create((View) cardDeveloperPict1, "cardDeveloperPict1");
                Pair<View, String> p2 = Pair.create((View) tvDeveloperName1, "tvDeveloperName1");
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(DeveloperListActivity.this, (Pair<View, String>) p1, p2);
                startActivity(i, options.toBundle());
            }
        });

        cardLinkToDeveloper2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DeveloperListActivity.this, DeveloperAzyActivity.class);

                Pair<View, String> p3 = Pair.create((View) cardDeveloperPict2, "cardDeveloperPict2");
                Pair<View, String> p4 = Pair.create((View) tvDeveloperName2, "tvDeveloperName2");
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(DeveloperListActivity.this, (Pair<View, String>) p3, p4);
                startActivity(i, options.toBundle());
            }
        });

        cardLinkToDeveloper3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DeveloperListActivity.this, DeveloperBayuActivity.class);

                Pair<View, String> p1 = Pair.create((View) cardDeveloperPict3, "cardDeveloperPict3");
                Pair<View, String> p2 = Pair.create((View) tvDeveloperName3, "tvDeveloperName3");
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(DeveloperListActivity.this, (Pair<View, String>) p1, p2);
                startActivity(i, options.toBundle());
            }
        });

        cardLinkToDeveloper4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DeveloperListActivity.this, DeveloperFandiActivity.class);

                Pair<View, String> p1 = Pair.create((View) cardDeveloperPict4, "cardDeveloperPict4");
                Pair<View, String> p2 = Pair.create((View) tvDeveloperName4, "tvDeveloperName4");
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(DeveloperListActivity.this, (Pair<View, String>) p1, p2);
                startActivity(i, options.toBundle());
            }
        });

        cardLinkToDeveloper5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DeveloperListActivity.this, DeveloperHaryActivity.class);

                Pair<View, String> p1 = Pair.create((View) cardDeveloperPict5, "cardDeveloperPict5");
                Pair<View, String> p2 = Pair.create((View) tvDeveloperName5, "tvDeveloperName5");
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(DeveloperListActivity.this, (Pair<View, String>) p1, p2);
                startActivity(i, options.toBundle());
            }
        });
    }
}