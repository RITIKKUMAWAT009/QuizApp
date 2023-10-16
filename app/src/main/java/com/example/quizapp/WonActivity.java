package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.intuit.sdp.BuildConfig;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;

public class WonActivity extends AppCompatActivity {

    CircularProgressBar circularProgressBar;
    TextView txtResult;
    LinearLayout shareScore;
    int correct, totalQue;
    ImageView imgBack;
    TextView imgExit;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_won);
        correct = getIntent().getIntExtra("correct", 0);
        totalQue = getIntent().getIntExtra("totalQue", 0);


        circularProgressBar = findViewById(R.id.circularProgressBar);
        imgBack = findViewById(R.id.img_back);
        imgExit = findViewById(R.id.txtExit);
        shareScore = findViewById(R.id.sharebtn);

        txtResult = findViewById(R.id.txtResult1);
        circularProgressBar.setProgress(correct);

        txtResult.setText(correct + "/" + totalQue);
        shareScore.setOnClickListener(v -> {
            try {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name");
                String shareMessage = "\n I got " + correct + " Out of " + totalQue + " You can also Try";
                shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.LIBRARY_PACKAGE_NAME + "\n\n";
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                startActivity(Intent.createChooser(shareIntent, "choose one"));
            } catch (Exception e) {
                //e.toString();
            }
        });

        imgExit.setOnClickListener(v -> System.exit(0));

        imgBack.setOnClickListener(v -> {
            Intent intent=new Intent(WonActivity.this,MainActivity.class);
            startActivity(intent);
        });
    }
}