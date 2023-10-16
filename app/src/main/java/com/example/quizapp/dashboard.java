package com.example.quizapp;

import static com.example.quizapp.MainActivity.questions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;


public class dashboard extends AppCompatActivity {


    CardView cardA, cardB, cardC, cardD;
    TextView qA, qB, qC, qD, cardQue,txt_btn_Exit;
    CountDownTimer countDownTimer;
    int timerValue = 300;
    Button btnNext;
    ProgressBar progressBar;
    int index = 0, countCorrect = 0, countWrong = 0;
    List<ModelClass> modelClassList;
    ModelClass modelClass;
    ImageView backbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Hook();
        modelClassList = questions;
        Collections.shuffle(modelClassList);
        modelClass = (ModelClass) questions.get(index);

        setAllData();

        btnNext.setClickable(false);
//        LayoutInflater inflater=getLayoutInflater();
//        View view=inflater.inflate(R.layout.time_out_btn_bg,null,false);
        Intent intent = new Intent(dashboard.this, MainActivity.class);

//        btn=view.findViewById(R.id.btn_tryagain);
        progressBar = findViewById(R.id.progrssBar);
        countDownTimer = new CountDownTimer(300000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timerValue = timerValue - 1;
                progressBar.setProgress(timerValue);

            }

            @Override
            public void onFinish() {
                Dialog dialog = new Dialog(dashboard.this);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.setContentView(R.layout.time_out_btn_bg);
                dialog.findViewById(R.id.btn_tryagain).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(intent);
                    }
                });
                dialog.show();
//                Dialog dialog=new Dialog(getApplicationContext(),R.style.Dialog);
//              dialog.setContentView(R.layout.time_out_btn_bg);
//                dialog.show();
//
//            Intent intent=new Intent(dashboard.this,MainActivity.class);
//                AlertDialog.Builder builder = new AlertDialog.Builder(dashboard.this);
////                builder.setTitle("Select Label");
//                builder.setView(R.layout.time_out_btn_bg);
//                AlertDialog alert = builder.create();
//
//                alert.setContentView(R.layout.time_out_btn_bg);
//                alert.findViewById(R.id.btn_tryagain).setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        startActivity(intent);
//                    }
//                });
////                getApplicationContext().setTheme(R.style.Dialog);
//                alert.show();


//                LayoutInflater inflater = this.getLayoutInflater();
//                alert.setContentView(R.layout.time_out_btn_bg);


            }
        }.start();

        txt_btn_Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(dashboard.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void setAllData() {
        cardQue.setText(modelClass.getQuestions());
        qA.setText(modelClass.getoA());
        qB.setText(modelClass.getoB());
        qC.setText(modelClass.getoC());
        qD.setText(modelClass.getoD());
    }

    private void Hook() {
        cardA = findViewById(R.id.card_1);
        cardB = findViewById(R.id.card_2);
        cardC = findViewById(R.id.card_3);
        cardD = findViewById(R.id.card_4);

        cardQue = findViewById(R.id.quiz_question);
        qA = findViewById(R.id.quiz_optionA);
        qB = findViewById(R.id.quiz_optionB);
        qC = findViewById(R.id.quiz_optionC);
        qD = findViewById(R.id.quiz_optionD);

        txt_btn_Exit=findViewById(R.id.txtExit);
        backbtn=findViewById(R.id.img_back);
        btnNext = findViewById(R.id.btn_next);

    }

    public void correct(CardView cardView) {

        cardView.setBackgroundColor(getResources().getColor(R.color.green));
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                countCorrect++;
                index++;
                modelClass = modelClassList.get(index);
                setAllData();
                resetColor();
              enableButton();
              btnNext.setClickable(false);

            }
        });

    }

    public void wrong(CardView card) {

        card.setBackgroundColor(getResources().getColor(R.color.red));

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countWrong++;
                if (index < modelClassList.size() - 1) {
                    index++;
                    modelClass = modelClassList.get(index);
                    setAllData();
                    resetColor();
                   enableButton();
                   btnNext.setClickable(false);
                } else {
                    gameWon();
                }
            }
        });

    }

    private void gameWon() {

        Intent intent = new Intent(dashboard.this, WonActivity.class);
        intent.putExtra("correct",countCorrect);
        intent.putExtra("totalQue",questions.size()-1);
        startActivity(intent);
    }

    public void enableButton() {
        cardA.setClickable(true);
        cardB.setClickable(true);
        cardC.setClickable(true);
        cardD.setClickable(true);
    }

    public void disableButton() {
        cardA.setClickable(false);
        cardB.setClickable(false);
        cardC.setClickable(false);
        cardD.setClickable(false);

    }

    public void resetColor() {
        cardA.setBackgroundColor(getResources().getColor(R.color.white));
        cardB.setBackgroundColor(getResources().getColor(R.color.white));
        cardC.setBackgroundColor(getResources().getColor(R.color.white));
        cardD.setBackgroundColor(getResources().getColor(R.color.white));
    }


    public void optionAClick(View view) {
        disableButton();
        btnNext.setClickable(true);

        if (modelClass.getoA().equals(modelClass.getAns())) {
            cardA.setBackgroundColor(getResources().getColor(R.color.green));
            if (index < modelClassList.size() - 1) {
               correct(cardA);
            } else {
                gameWon();
            }
        } else {
            wrong(cardA);
        }
    }

    public void optionBClick(View view) {
        disableButton();
        btnNext.setClickable(true);

        if (modelClass.getoB().equals(modelClass.getAns())) {
            cardB.setBackgroundColor(getResources().getColor(R.color.green));
            if (index < modelClassList.size() - 1) {
               correct(cardB);
            } else {
                gameWon();
            }
        } else {
            wrong(cardB);
        }
    }

    public void optionCClick(View view) {
        disableButton();
        btnNext.setClickable(true);


        if (modelClass.getoC().equals(modelClass.getAns())) {
            cardC.setBackgroundColor(getResources().getColor(R.color.green));
            if (index < modelClassList.size() - 1) {
               correct(cardC);
            } else {
                gameWon();
            }
        } else {
            wrong(cardC);
        }
    }

    public void optionDClick(View view) {
        disableButton();
        btnNext.setClickable(true);

        if (modelClass.getoD().equals(modelClass.getAns())) {
            cardD.setBackgroundColor(getResources().getColor(R.color.green));
            if (index < modelClassList.size() - 1) {
               correct(cardD);
            } else {
                gameWon();
            }
        } else {
            wrong(cardD);
        }
    }


}