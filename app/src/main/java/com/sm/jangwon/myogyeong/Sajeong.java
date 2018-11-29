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

public class Sajeong extends AppCompatActivity {

    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 화면 가로 고정
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        // 상태바 제거
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_sajeong);

        // 김내관 등장 애니메이션
        ImageView sajeong_naesi = (ImageView) findViewById(R.id.sajeong_naesi);
        Animation sajeong_naesi_anim = AnimationUtils.loadAnimation(this, R.anim.character_in_anim);
        sajeong_naesi.startAnimation(sajeong_naesi_anim);

        // 대화창 애니메이션
        ImageButton sajeong_dialog = (ImageButton) findViewById(R.id.sajeong_dialog);
        Animation sajeong_dialog_anim = AnimationUtils.loadAnimation(this, R.anim.dialog_in_anim);
        sajeong_dialog.startAnimation(sajeong_dialog_anim);

        // 이름표 애니메이션
        ImageView sajeong_nametag = (ImageView) findViewById(R.id.sajeong_nametag);
        Animation sajeong_nametag_anim = AnimationUtils.loadAnimation(this, R.anim.dialog_in_anim);
        sajeong_nametag.startAnimation(sajeong_nametag_anim);

        // 이름 애니메이션
        TextView sajeong_name = (TextView) findViewById(R.id.sajeong_name);
        Animation sajeong_name_anim = AnimationUtils.loadAnimation(this, R.anim.dialog_in_anim);
        sajeong_name.startAnimation(sajeong_name_anim);

        // 보따리
        ImageButton sajeong_pack = (ImageButton) findViewById(R.id.sajeong_pack);
        sajeong_pack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent sajeong_menu_i = new Intent(getApplicationContext(), Menu.class);
                startActivity(sajeong_menu_i);
            }
        });

        // 텍스트 애니메이션
        TextView sajeong_naesi_s1 = (TextView) findViewById(R.id.sajeong_naesi_s1);
        Animation sajeong_naesi_s1_anim = AnimationUtils.loadAnimation(this, R.anim.dialog_text_in_anim);
        sajeong_naesi_s1.startAnimation(sajeong_naesi_s1_anim);

        // 텍스트 전환
        changeView(i);
        sajeong_dialog.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                changeView(i);
                if(i == 8) {
                    Intent sajeong_i = new Intent(getApplicationContext(), Jaseon.class);
                    startActivity(sajeong_i);
                }
            }
        });
    }

    // 텍스트 전환
    public void changeView(int index){
        TextView tv1 = (TextView) findViewById(R.id.sajeong_naesi_s1);
        TextView tv2 = (TextView) findViewById(R.id.sajeong_naesi_s2);
        TextView tv3 = (TextView) findViewById(R.id.sajeong_naesi_s3);
        TextView tv4 = (TextView) findViewById(R.id.sajeong_naesi_s4);
        TextView tv5 = (TextView) findViewById(R.id.sajeong_naesi_s5);
        TextView tv6 = (TextView) findViewById(R.id.sajeong_naesi_s6);
        TextView tv7 = (TextView) findViewById(R.id.sajeong_naesi_s7);

        switch(index){
            case 0:
                tv1.setVisibility(View.VISIBLE);
                tv2.setVisibility(View.INVISIBLE);
                tv3.setVisibility(View.INVISIBLE);
                tv4.setVisibility(View.INVISIBLE);
                tv5.setVisibility(View.INVISIBLE);
                tv6.setVisibility(View.INVISIBLE);
                tv7.setVisibility(View.INVISIBLE);
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
                i++;
                break;
            case 7:
                tv1.setVisibility(View.INVISIBLE);
                tv2.setVisibility(View.INVISIBLE);
                tv3.setVisibility(View.INVISIBLE);
                tv4.setVisibility(View.INVISIBLE);
                tv5.setVisibility(View.INVISIBLE);
                tv6.setVisibility(View.INVISIBLE);
                tv7.setVisibility(View.VISIBLE);
                i++;
                break;
        }
    }

}
