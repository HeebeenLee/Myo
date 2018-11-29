package com.sm.jangwon.myogyeong;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Jaseon extends AppCompatActivity {

    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 화면 가로 고정
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        // 상태바 제거
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_jaseon);

        // 세자 등장 애니메이션
        ImageView jaseon_seja = (ImageView) findViewById(R.id.jaseon_seja);
        Animation jaseon_seja_anim = AnimationUtils.loadAnimation(this, R.anim.character_in_anim);
        jaseon_seja.startAnimation(jaseon_seja_anim);

        // 대화창 애니메이션
        ImageButton jaseon_dialog = (ImageButton) findViewById(R.id.jaseon_dialog);
        Animation jaseon_dialog_anim = AnimationUtils.loadAnimation(this, R.anim.dialog_in_anim);
        jaseon_dialog.startAnimation(jaseon_dialog_anim);

        // 이름표 애니메이션
        ImageView jaseon_nametag = (ImageView) findViewById(R.id.jaseon_nametag);
        Animation jaseon_nametag_anim = AnimationUtils.loadAnimation(this, R.anim.dialog_in_anim);
        jaseon_nametag.startAnimation(jaseon_nametag_anim);

        // 이름 애니메이션
        TextView jaseon_name = (TextView) findViewById(R.id.jaseon_name);
        Animation jaseon_name_anim = AnimationUtils.loadAnimation(this, R.anim.dialog_in_anim);
        jaseon_name.startAnimation(jaseon_name_anim);

        // 텍스트 애니메이션
        TextView jaseon_seja_s1 = (TextView) findViewById(R.id.jaseon_seja_s1);
        Animation jaseon_seja_s1_anim = AnimationUtils.loadAnimation(this, R.anim.dialog_text_in_anim);
        jaseon_seja_s1.startAnimation(jaseon_seja_s1_anim);

        // 텍스트 전환
        changeView(i);
        jaseon_dialog.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                changeView(i);
                if(i == 15) {
                    Intent jaseon_i = new Intent(getApplicationContext(), Naesoju.class);
                    startActivity(jaseon_i);
                }
            }
        });
    }

    // 텍스트 전환
    public void changeView(int index){
        TextView tv1 = (TextView) findViewById(R.id.jaseon_seja_s1);
        TextView tv2 = (TextView) findViewById(R.id.jaseon_seja_s2);
        TextView tv3 = (TextView) findViewById(R.id.jaseon_seja_s3);
        TextView tv4 = (TextView) findViewById(R.id.jaseon_seja_s4);
        TextView tv5 = (TextView) findViewById(R.id.jaseon_seja_s5);
        TextView tv6 = (TextView) findViewById(R.id.jaseon_seja_s6);
        TextView tv7 = (TextView) findViewById(R.id.jaseon_seja_s7);
        TextView tv8 = (TextView) findViewById(R.id.jaseon_seja_s8);
        TextView tv9 = (TextView) findViewById(R.id.jaseon_seja_s9);
        TextView tv10 = (TextView) findViewById(R.id.jaseon_seja_s10);
        TextView tv11 = (TextView) findViewById(R.id.jaseon_seja_s11);
        TextView tv12 = (TextView) findViewById(R.id.jaseon_seja_s12);
        TextView tv13 = (TextView) findViewById(R.id.jaseon_seja_s13);
        TextView tv14 = (TextView) findViewById(R.id.jaseon_seja_s14);

        switch(index) {
            case 0:
                tv1.setVisibility(View.VISIBLE);
                tv2.setVisibility(View.INVISIBLE);
                tv3.setVisibility(View.INVISIBLE);
                tv4.setVisibility(View.INVISIBLE);
                tv5.setVisibility(View.INVISIBLE);
                tv6.setVisibility(View.INVISIBLE);
                tv7.setVisibility(View.INVISIBLE);
                tv8.setVisibility(View.INVISIBLE);
                tv9.setVisibility(View.INVISIBLE);
                tv10.setVisibility(View.INVISIBLE);
                tv11.setVisibility(View.INVISIBLE);
                tv12.setVisibility(View.INVISIBLE);
                tv13.setVisibility(View.INVISIBLE);
                tv14.setVisibility(View.INVISIBLE);
                i++;
                break;
            case 1:
                tv1.setVisibility(View.INVISIBLE);
                tv2.setVisibility(View.VISIBLE);
                tv3.setVisibility(View.INVISIBLE);
                tv4.setVisibility(View.INVISIBLE);
                tv5.setVisibility(View.INVISIBLE);
                tv6.setVisibility(View.INVISIBLE);
                tv7.setVisibility(View.INVISIBLE);
                tv8.setVisibility(View.INVISIBLE);
                tv9.setVisibility(View.INVISIBLE);
                tv10.setVisibility(View.INVISIBLE);
                tv11.setVisibility(View.INVISIBLE);
                tv12.setVisibility(View.INVISIBLE);
                tv13.setVisibility(View.INVISIBLE);
                tv14.setVisibility(View.INVISIBLE);
                i++;
                break;
            case 2:
                tv1.setVisibility(View.INVISIBLE);
                tv2.setVisibility(View.INVISIBLE);
                tv3.setVisibility(View.VISIBLE);
                tv4.setVisibility(View.INVISIBLE);
                tv5.setVisibility(View.INVISIBLE);
                tv6.setVisibility(View.INVISIBLE);
                tv7.setVisibility(View.INVISIBLE);
                tv8.setVisibility(View.INVISIBLE);
                tv9.setVisibility(View.INVISIBLE);
                tv10.setVisibility(View.INVISIBLE);
                tv11.setVisibility(View.INVISIBLE);
                tv12.setVisibility(View.INVISIBLE);
                tv13.setVisibility(View.INVISIBLE);
                tv14.setVisibility(View.INVISIBLE);
                i++;
                break;
            case 3:
                tv1.setVisibility(View.INVISIBLE);
                tv2.setVisibility(View.INVISIBLE);
                tv3.setVisibility(View.INVISIBLE);
                tv4.setVisibility(View.VISIBLE);
                tv5.setVisibility(View.INVISIBLE);
                tv6.setVisibility(View.INVISIBLE);
                tv7.setVisibility(View.INVISIBLE);
                tv8.setVisibility(View.INVISIBLE);
                tv9.setVisibility(View.INVISIBLE);
                tv10.setVisibility(View.INVISIBLE);
                tv11.setVisibility(View.INVISIBLE);
                tv12.setVisibility(View.INVISIBLE);
                tv13.setVisibility(View.INVISIBLE);
                tv14.setVisibility(View.INVISIBLE);
                i++;
                break;
            case 4:
                tv1.setVisibility(View.INVISIBLE);
                tv2.setVisibility(View.INVISIBLE);
                tv3.setVisibility(View.INVISIBLE);
                tv4.setVisibility(View.INVISIBLE);
                tv5.setVisibility(View.VISIBLE);
                tv6.setVisibility(View.INVISIBLE);
                tv7.setVisibility(View.INVISIBLE);
                tv8.setVisibility(View.INVISIBLE);
                tv9.setVisibility(View.INVISIBLE);
                tv10.setVisibility(View.INVISIBLE);
                tv11.setVisibility(View.INVISIBLE);
                tv12.setVisibility(View.INVISIBLE);
                tv13.setVisibility(View.INVISIBLE);
                tv14.setVisibility(View.INVISIBLE);
                i++;
                break;
            case 5:
                tv1.setVisibility(View.INVISIBLE);
                tv2.setVisibility(View.INVISIBLE);
                tv3.setVisibility(View.INVISIBLE);
                tv4.setVisibility(View.INVISIBLE);
                tv5.setVisibility(View.INVISIBLE);
                tv6.setVisibility(View.VISIBLE);
                tv7.setVisibility(View.INVISIBLE);
                tv8.setVisibility(View.INVISIBLE);
                tv9.setVisibility(View.INVISIBLE);
                tv10.setVisibility(View.INVISIBLE);
                tv11.setVisibility(View.INVISIBLE);
                tv12.setVisibility(View.INVISIBLE);
                tv13.setVisibility(View.INVISIBLE);
                tv14.setVisibility(View.INVISIBLE);
                i++;
                break;
            case 6:
                tv1.setVisibility(View.INVISIBLE);
                tv2.setVisibility(View.INVISIBLE);
                tv3.setVisibility(View.INVISIBLE);
                tv4.setVisibility(View.INVISIBLE);
                tv5.setVisibility(View.INVISIBLE);
                tv6.setVisibility(View.INVISIBLE);
                tv7.setVisibility(View.VISIBLE);
                tv8.setVisibility(View.INVISIBLE);
                tv9.setVisibility(View.INVISIBLE);
                tv10.setVisibility(View.INVISIBLE);
                tv11.setVisibility(View.INVISIBLE);
                tv12.setVisibility(View.INVISIBLE);
                tv13.setVisibility(View.INVISIBLE);
                tv14.setVisibility(View.INVISIBLE);
                i++;
                break;
            case 7:
                tv1.setVisibility(View.INVISIBLE);
                tv2.setVisibility(View.INVISIBLE);
                tv3.setVisibility(View.INVISIBLE);
                tv4.setVisibility(View.INVISIBLE);
                tv5.setVisibility(View.INVISIBLE);
                tv6.setVisibility(View.INVISIBLE);
                tv7.setVisibility(View.INVISIBLE);
                tv8.setVisibility(View.VISIBLE);
                tv9.setVisibility(View.INVISIBLE);
                tv10.setVisibility(View.INVISIBLE);
                tv11.setVisibility(View.INVISIBLE);
                tv12.setVisibility(View.INVISIBLE);
                tv13.setVisibility(View.INVISIBLE);
                tv14.setVisibility(View.INVISIBLE);
                i++;
                break;
            case 8:
                tv1.setVisibility(View.INVISIBLE);
                tv2.setVisibility(View.INVISIBLE);
                tv3.setVisibility(View.INVISIBLE);
                tv4.setVisibility(View.INVISIBLE);
                tv5.setVisibility(View.INVISIBLE);
                tv6.setVisibility(View.INVISIBLE);
                tv7.setVisibility(View.INVISIBLE);
                tv8.setVisibility(View.INVISIBLE);
                tv9.setVisibility(View.VISIBLE);
                tv10.setVisibility(View.INVISIBLE);
                tv11.setVisibility(View.INVISIBLE);
                tv12.setVisibility(View.INVISIBLE);
                tv13.setVisibility(View.INVISIBLE);
                tv14.setVisibility(View.INVISIBLE);
                i++;
                break;
            // 퀴즈 맞춘 후
            case 9:
                tv1.setVisibility(View.INVISIBLE);
                tv2.setVisibility(View.INVISIBLE);
                tv3.setVisibility(View.INVISIBLE);
                tv4.setVisibility(View.INVISIBLE);
                tv5.setVisibility(View.INVISIBLE);
                tv6.setVisibility(View.INVISIBLE);
                tv7.setVisibility(View.INVISIBLE);
                tv8.setVisibility(View.INVISIBLE);
                tv9.setVisibility(View.INVISIBLE);
                tv10.setVisibility(View.VISIBLE);
                tv11.setVisibility(View.INVISIBLE);
                tv12.setVisibility(View.INVISIBLE);
                tv13.setVisibility(View.INVISIBLE);
                tv14.setVisibility(View.INVISIBLE);
                i++;
                break;
            case 10:
                tv1.setVisibility(View.INVISIBLE);
                tv2.setVisibility(View.INVISIBLE);
                tv3.setVisibility(View.INVISIBLE);
                tv4.setVisibility(View.INVISIBLE);
                tv5.setVisibility(View.INVISIBLE);
                tv6.setVisibility(View.INVISIBLE);
                tv7.setVisibility(View.INVISIBLE);
                tv8.setVisibility(View.INVISIBLE);
                tv9.setVisibility(View.INVISIBLE);
                tv10.setVisibility(View.INVISIBLE);
                tv11.setVisibility(View.VISIBLE);
                tv12.setVisibility(View.INVISIBLE);
                tv13.setVisibility(View.INVISIBLE);
                tv14.setVisibility(View.INVISIBLE);
                i++;
                break;
            case 11:
                tv1.setVisibility(View.INVISIBLE);
                tv2.setVisibility(View.INVISIBLE);
                tv3.setVisibility(View.INVISIBLE);
                tv4.setVisibility(View.INVISIBLE);
                tv5.setVisibility(View.INVISIBLE);
                tv6.setVisibility(View.INVISIBLE);
                tv7.setVisibility(View.INVISIBLE);
                tv8.setVisibility(View.INVISIBLE);
                tv9.setVisibility(View.INVISIBLE);
                tv10.setVisibility(View.INVISIBLE);
                tv11.setVisibility(View.INVISIBLE);
                tv12.setVisibility(View.VISIBLE);
                tv13.setVisibility(View.INVISIBLE);
                tv14.setVisibility(View.INVISIBLE);
                i++;
                break;
            case 12:
                tv1.setVisibility(View.INVISIBLE);
                tv2.setVisibility(View.INVISIBLE);
                tv3.setVisibility(View.INVISIBLE);
                tv4.setVisibility(View.INVISIBLE);
                tv5.setVisibility(View.INVISIBLE);
                tv6.setVisibility(View.INVISIBLE);
                tv7.setVisibility(View.INVISIBLE);
                tv8.setVisibility(View.INVISIBLE);
                tv9.setVisibility(View.INVISIBLE);
                tv10.setVisibility(View.INVISIBLE);
                tv11.setVisibility(View.INVISIBLE);
                tv12.setVisibility(View.INVISIBLE);
                tv13.setVisibility(View.VISIBLE);
                tv14.setVisibility(View.INVISIBLE);
                i++;
                break;
            case 13:
                tv1.setVisibility(View.INVISIBLE);
                tv2.setVisibility(View.INVISIBLE);
                tv3.setVisibility(View.INVISIBLE);
                tv4.setVisibility(View.INVISIBLE);
                tv5.setVisibility(View.INVISIBLE);
                tv6.setVisibility(View.INVISIBLE);
                tv7.setVisibility(View.INVISIBLE);
                tv8.setVisibility(View.INVISIBLE);
                tv9.setVisibility(View.INVISIBLE);
                tv10.setVisibility(View.INVISIBLE);
                tv11.setVisibility(View.INVISIBLE);
                tv12.setVisibility(View.INVISIBLE);
                tv13.setVisibility(View.INVISIBLE);
                tv14.setVisibility(View.VISIBLE);
                i++;
                break;
            case 14:
                tv1.setVisibility(View.INVISIBLE);
                tv2.setVisibility(View.INVISIBLE);
                tv3.setVisibility(View.INVISIBLE);
                tv4.setVisibility(View.INVISIBLE);
                tv5.setVisibility(View.INVISIBLE);
                tv6.setVisibility(View.INVISIBLE);
                tv7.setVisibility(View.INVISIBLE);
                tv8.setVisibility(View.INVISIBLE);
                tv9.setVisibility(View.INVISIBLE);
                tv10.setVisibility(View.INVISIBLE);
                tv11.setVisibility(View.INVISIBLE);
                tv12.setVisibility(View.INVISIBLE);
                tv13.setVisibility(View.INVISIBLE);
                tv14.setVisibility(View.VISIBLE);
                i++;
                break;
        }
    }

}
