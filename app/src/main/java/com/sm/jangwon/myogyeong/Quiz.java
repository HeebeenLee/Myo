package com.sm.jangwon.myogyeong;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

public class Quiz extends AppCompatActivity {
    int count;
    TextView jaseon; TextView naesoju; TextView qyotae; TextView hyangwon; TextView sujeong;
    ImageButton r_btn; ImageButton w_btn; ImageButton goNext;
    Intent intent;
    Intent come_ja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 화면 가로 고정
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        // 상태바 제거
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_quiz);

        /*Intent fromIn = getIntent();
        count = Integer.parseInt(fromIn.getStringExtra("count"));*/
        count=1;

        r_btn =(ImageButton)findViewById(R.id.right_btn);
        w_btn =(ImageButton)findViewById(R.id.wrong_btn);
        jaseon = (TextView)findViewById(R.id.jaseon_quiz_q);
        naesoju= (TextView)findViewById(R.id.naesoju_quiz_q);
        qyotae = (TextView)findViewById(R.id.qyotae_quiz_q);
        hyangwon = (TextView)findViewById(R.id.hyangwon_quiz_q);
        sujeong = (TextView)findViewById(R.id.sujeong_quiz_q);
        goNext = (ImageButton) findViewById(R.id.nextgo);
        goNext.setVisibility(View.INVISIBLE);
        showing_quiz(count);
    }

    public void showing_quiz(int i){
        switch(i){
            case 1:
                intent = new Intent(this, QuizPop.class);
                jaseon.setVisibility(View.VISIBLE);
                naesoju.setVisibility(View.INVISIBLE);
                qyotae.setVisibility(View.INVISIBLE);
                hyangwon.setVisibility(View.INVISIBLE);
                sujeong.setVisibility(View.INVISIBLE);

                r_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        intent.putExtra("data","틀렸어^^");
                        startActivityForResult(intent,1);
                    }
                });
                w_btn.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        intent.putExtra("data","X\n자선당은 세자가 공부하는 장소이다.");
                        startActivityForResult(intent,1);
                        come_ja = new Intent();
                        setResult(RESULT_OK,come_ja);
                        finish();
                    }
                });

                break;
            case 2:
                jaseon.setVisibility(View.INVISIBLE);
                naesoju.setVisibility(View.VISIBLE);
                qyotae.setVisibility(View.INVISIBLE);
                hyangwon.setVisibility(View.INVISIBLE);
                sujeong.setVisibility(View.INVISIBLE);
                break;
            case 3:
                jaseon.setVisibility(View.INVISIBLE);
                naesoju.setVisibility(View.INVISIBLE);
                qyotae.setVisibility(View.VISIBLE);
                hyangwon.setVisibility(View.INVISIBLE);
                sujeong.setVisibility(View.INVISIBLE);
                break;
            case 4:
                jaseon.setVisibility(View.INVISIBLE);
                naesoju.setVisibility(View.INVISIBLE);
                qyotae.setVisibility(View.INVISIBLE);
                hyangwon.setVisibility(View.VISIBLE);
                sujeong.setVisibility(View.INVISIBLE);
                break;
            case 5:
                jaseon.setVisibility(View.INVISIBLE);
                naesoju.setVisibility(View.INVISIBLE);
                qyotae.setVisibility(View.INVISIBLE);
                hyangwon.setVisibility(View.INVISIBLE);
                sujeong.setVisibility(View.VISIBLE);
                break;

        }

    }

}