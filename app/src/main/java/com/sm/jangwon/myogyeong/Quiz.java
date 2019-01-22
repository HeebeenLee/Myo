package com.sm.jangwon.myogyeong;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

public class Quiz extends AppCompatActivity {

    int count;
    int right_sound;
    int wrong_sound;

    ImageButton right_btn;
    ImageButton wrong_btn;

    TextView jaseon_quiz;
    TextView naesoju_quiz;
    TextView qyotae_quiz;
    TextView hyangwon_quiz;
    TextView sujeong_quiz;

    Intent goQ;
    Intent comeQ;

    SoundPool quiz_bgm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 화면 가로 고정
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        // 상태바 제거
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_quiz);

        Intent fromIn = getIntent();
        count = Integer.parseInt(fromIn.getStringExtra("count"));

        right_btn = (ImageButton) findViewById(R.id.right_btn);
        wrong_btn = (ImageButton) findViewById(R.id.wrong_btn);

        jaseon_quiz = (TextView) findViewById(R.id.jaseon_quiz_q);
        naesoju_quiz = (TextView) findViewById(R.id.naesoju_quiz_q);
        qyotae_quiz = (TextView) findViewById(R.id.qyotae_quiz_q);
        hyangwon_quiz = (TextView) findViewById(R.id.hyangwon_quiz_q);
        sujeong_quiz = (TextView) findViewById(R.id.sujeong_quiz_q);

        // 효과음 위한 사운드풀
        quiz_bgm = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
        right_sound = quiz_bgm.load(this, R.raw.correct, 1);
        wrong_sound = quiz_bgm.load(this, R.raw.wrong, 1);

        showing_quiz(count);
    }

    public void showing_quiz(int i) {
        switch(i) {
            // 자선당
            case 1:
                goQ = new Intent(this, QuizPop.class);
                jaseon_quiz.setVisibility(View.VISIBLE);
                naesoju_quiz.setVisibility(View.INVISIBLE);
                qyotae_quiz.setVisibility(View.INVISIBLE);
                hyangwon_quiz.setVisibility(View.INVISIBLE);
                sujeong_quiz.setVisibility(View.INVISIBLE);

                right_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        goQ.putExtra("data","다시 생각해 보세요.");
                        // 효과음
                        quiz_bgm.play(wrong_sound, 1, 1, 1, 0, 1);
                        startActivityForResult(goQ ,1);
                    }
                });
                wrong_btn.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        goQ.putExtra("data","정답입니다!\n(자선당은 세자가 공부하는 장소이다.)");
                        // 효과음
                        quiz_bgm.play(right_sound, 1, 1, 1, 0, 1);
                        startActivityForResult(goQ ,1);
                        comeQ = new Intent();
                        setResult(RESULT_OK,comeQ);
                        finish();
                    }
                });
                break;
            // 내소주방
            case 2:
                goQ = new Intent(this, QuizPop.class);
                jaseon_quiz.setVisibility(View.INVISIBLE);
                naesoju_quiz.setVisibility(View.VISIBLE);
                qyotae_quiz.setVisibility(View.INVISIBLE);
                hyangwon_quiz.setVisibility(View.INVISIBLE);
                sujeong_quiz.setVisibility(View.INVISIBLE);

                right_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        goQ.putExtra("data","다시 생각해 보세요.");
                        // 효과음
                        quiz_bgm.play(wrong_sound, 1, 1, 1, 0, 1);
                        startActivityForResult(goQ,1);
                    }
                });
                wrong_btn.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        goQ.putExtra("data","정답입니다!\n(외소주방에서 잔치음식을 준비하고\n내소주방은 수라를 주로 다룬다.)");
                        // 효과음
                        quiz_bgm.play(right_sound, 1, 1, 1, 0, 1);
                        startActivityForResult(goQ,1);
                        comeQ = new Intent();
                        setResult(RESULT_OK,comeQ);
                        finish();
                    }
                });
                break;
            // 교태전
            case 3:
                goQ = new Intent(this, QuizPop.class);
                jaseon_quiz.setVisibility(View.INVISIBLE);
                naesoju_quiz.setVisibility(View.INVISIBLE);
                qyotae_quiz.setVisibility(View.VISIBLE);
                hyangwon_quiz.setVisibility(View.INVISIBLE);
                sujeong_quiz.setVisibility(View.INVISIBLE);

                right_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        goQ.putExtra("data","정답입니다!");
                        // 효과음
                        quiz_bgm.play(right_sound, 1, 1, 1, 0, 1);
                        startActivityForResult(goQ ,1);
                        comeQ = new Intent();
                        setResult(RESULT_OK,comeQ);
                        finish();
                    }
                });
                wrong_btn.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        goQ.putExtra("data","다시 생각해 보세요.");
                        // 효과음
                        quiz_bgm.play(wrong_sound, 1, 1, 1, 0, 1);
                        startActivityForResult(goQ ,1);
                    }
                });
                break;
            // 향원정
            case 4:
                goQ = new Intent(this, QuizPop.class);
                jaseon_quiz.setVisibility(View.INVISIBLE);
                naesoju_quiz.setVisibility(View.INVISIBLE);
                qyotae_quiz.setVisibility(View.INVISIBLE);
                hyangwon_quiz.setVisibility(View.VISIBLE);
                sujeong_quiz.setVisibility(View.INVISIBLE);

                right_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        goQ.putExtra("data","다시 생각해 보세요.");
                        // 효과음
                        quiz_bgm.play(wrong_sound, 1, 1, 1, 0, 1);
                        startActivityForResult(goQ ,1);
                    }
                });
                wrong_btn.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        goQ.putExtra("data","정답입니다!\n(온돌이 깔린 1층이 겨울나기에 더 좋다.)");
                        // 효과음
                        quiz_bgm.play(right_sound, 1, 1, 1, 0, 1);
                        startActivityForResult(goQ ,1);
                        comeQ = new Intent();
                        setResult(RESULT_OK,comeQ);
                        finish();
                    }
                });
                break;
            // 수정전
            case 5:
                goQ = new Intent(this, QuizPop.class);
                jaseon_quiz.setVisibility(View.INVISIBLE);
                naesoju_quiz.setVisibility(View.INVISIBLE);
                qyotae_quiz.setVisibility(View.INVISIBLE);
                hyangwon_quiz.setVisibility(View.INVISIBLE);
                sujeong_quiz.setVisibility(View.VISIBLE);

                right_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        goQ.putExtra("data","정답입니다!");
                        // 효과음
                        quiz_bgm.play(right_sound, 1, 1, 1, 0, 1);
                        startActivityForResult(goQ ,1);
                        comeQ = new Intent();
                        setResult(RESULT_OK,comeQ);
                        finish();
                    }
                });
                wrong_btn.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        goQ.putExtra("data","다시 생각해 보세요.");
                        // 효과음
                        quiz_bgm.play(wrong_sound, 1, 1, 1, 0, 1);
                        startActivityForResult(goQ ,1);
                    }
                });
                break;
        }
    }

    // 백(취소)키가 눌렸을 때 종료 여부를 묻는 다이얼로그 창
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if((keyCode == KeyEvent.KEYCODE_BACK)) {
            AlertDialog.Builder d = new AlertDialog.Builder(Quiz.this);
            d.setMessage("묘한 경복궁을 종료할까요?");

            d.setPositiveButton("예", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    onStop();
                    ActivityCompat.finishAffinity(Quiz.this);
                    System.runFinalization();
                    System.exit(0);
                }
            });
            d.setNegativeButton("아니요", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            d.show();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}