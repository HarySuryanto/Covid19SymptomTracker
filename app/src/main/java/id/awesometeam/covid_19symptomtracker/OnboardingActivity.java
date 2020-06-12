package id.awesometeam.covid_19symptomtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.hololo.tutorial.library.Step;
import com.hololo.tutorial.library.TutorialActivity;

public class OnboardingActivity extends TutorialActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // First slide
        addFragment(new Step.Builder().setTitle("Hai! Selamat datang di Covid-19 Symptom Tracker")
                .setContent("Ketahui, cegah, dan jaga terus kondisimu bersama kami.")
                .setBackgroundColor(Color.parseColor("#473F97")) // int background color
                .setDrawable(R.drawable.ic_virus) // int top drawable
                .build());

        // Second slide
        addFragment(new Step.Builder().setTitle("Perbanyak Wawasan Mengenai Gejala")
                .setContent("Ketahui gejalanya, cegah penyebarannya.")
                .setBackgroundColor(Color.parseColor("#473F97")) // int background color
                .setDrawable(R.drawable.ic_fever) // int top drawable
                .build());

        // Third slide
        addFragment(new Step.Builder().setTitle("Cari Tahu Bagaimana Virus Menyebar")
                .setContent("Ketahuilah bagaimana virus menyebar agar kita tahu cara mencegah penyebarannya.")
                .setBackgroundColor(Color.parseColor("#473F97")) // int background color
                .setDrawable(R.drawable.ic_coronavirus_spread) // int top drawable
                .build());

        // Fourth slide
        addFragment(new Step.Builder().setTitle("Mari Hidup Sehat")
                .setContent("Dapatkan tips-tips hidup sehat untuk hidup yang lebih baik.")
                .setBackgroundColor(Color.parseColor("#473F97")) // int background color
                .setDrawable(R.drawable.ic_coronavirus_protection) // int top drawable
                .build());

        // Fifth slide
        addFragment(new Step.Builder().setTitle("Cek Gejala")
                .setContent("Bagimana jika kita terinspeksi namun tidak mengetahuinya? Ayo cek kesehatanmu.")
                .setBackgroundColor(Color.parseColor("#473F97")) // int background color
                .setDrawable(R.drawable.ic_doctor) // int top drawable
                .build());

        // Sixth slide
        addFragment(new Step.Builder().setTitle("Riwayat Gejala")
                .setContent("Pantau terus kondisi kesehatanmu, agar kamu dapat hidup sehat.")
                .setBackgroundColor(Color.parseColor("#473F97")) // int background color
                .setDrawable(R.drawable.ic_conditions) // int top drawable
                .build());

    }

    @Override
    public void finishTutorial() {
        startActivity(new Intent(OnboardingActivity.this, MainActivity.class));

        // Close Onboarding
        finish();
    }

}