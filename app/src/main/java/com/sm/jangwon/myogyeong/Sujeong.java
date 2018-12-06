package com.sm.jangwon.myogyeong;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Sujeong extends AppCompatActivity {

    int i = 0;

    ImageView sujeong_naesi;
    ImageView sujeong_naesi2;

    ImageView sujeong_cat1;
    ImageView sujeong_cat2;
    ImageView sujeong_cat3;

    ImageView sujeong_info_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 화면 가로 고정
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        // 상태바 제거
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_sujeong);

        // 전각 이름 배경 퇴장 애니메이션
        ImageView sujeong_title_bg = (ImageView) findViewById(R.id.sujeong_title_bg);
        Animation sujeong_title_bg_out_anim = AnimationUtils.loadAnimation(this, R.anim.building_name_out_anim);
        sujeong_title_bg.startAnimation(sujeong_title_bg_out_anim);

        // 전각 이름 퇴장 애니메이션
        TextView sujeong_title = (TextView) findViewById(R.id.sujeong_title);
        Animation sujeong_title_out_anim = AnimationUtils.loadAnimation(this, R.anim.building_name_out_anim);
        sujeong_title.startAnimation(sujeong_title_out_anim);

        // 내시 등장 애니메이션
        sujeong_naesi = (ImageView) findViewById(R.id.sujeong_naesi);
        sujeong_naesi2 = (ImageView) findViewById(R.id.sujeong_naesi2);
        Animation sujeong_naesi_anim = AnimationUtils.loadAnimation(this, R.anim.character_in_anim);
        sujeong_naesi.startAnimation(sujeong_naesi_anim);

        // 대화창 애니메이션
        ImageButton sujeong_dialog = (ImageButton) findViewById(R.id.sujeong_dialog);
        Animation sujeong_dialog_anim = AnimationUtils.loadAnimation(this, R.anim.dialog_in_anim);
        sujeong_dialog.startAnimation(sujeong_dialog_anim);

        // 이름표 애니메이션
        ImageView sujeong_nametag = (ImageView) findViewById(R.id.sujeong_nametag);
        Animation sujeong_nametag_anim = AnimationUtils.loadAnimation(this, R.anim.dialog_in_anim);
        sujeong_nametag.startAnimation(sujeong_nametag_anim);

        // 이름 애니메이션
        TextView sujeong_name = (TextView) findViewById(R.id.sujeong_name);
        Animation sujeong_name_anim = AnimationUtils.loadAnimation(this, R.anim.name_in_anim);
        sujeong_name.startAnimation(sujeong_name_anim);

        // 텍스트 애니메이션
        TextView sujeong_naesi_s1 = (TextView) findViewById(R.id.sujeong_naesi_s1);
        Animation sujeong_naesi_s1_anim = AnimationUtils.loadAnimation(this, R.anim.dialog_text_in_anim);
        sujeong_naesi_s1.startAnimation(sujeong_naesi_s1_anim);

        // 보따리
        ImageButton sujeong_pack = (ImageButton) findViewById(R.id.sujeong_pack);
        Animation sujeong_pack_anim = AnimationUtils.loadAnimation(this, R.anim.character_in_anim);
        sujeong_pack.startAnimation(sujeong_pack_anim);
        sujeong_pack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent sujeong_menu_i = new Intent(getApplicationContext(), Menu.class);
                startActivity(sujeong_menu_i);
            }
        });

        // 고양이
        sujeong_cat1 = (ImageView) findViewById(R.id.sujeong_cat1);
        sujeong_cat2 = (ImageView) findViewById(R.id.sujeong_cat2);
        sujeong_cat3 = (ImageView) findViewById(R.id.sujeong_cat3);
        Animation sujeong_cat_anim = AnimationUtils.loadAnimation(this, R.anim.character_in_anim);
        sujeong_cat1.startAnimation(sujeong_cat_anim);
        sujeong_cat2.startAnimation(sujeong_cat_anim);
        sujeong_cat3.startAnimation(sujeong_cat_anim);

        // 텍스트 전환
        changeView(i);
        sujeong_dialog.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                changeView(i);
                // 퀴즈
                if(i == 8)  {
                    Intent go_quiz  = new Intent(getApplicationContext(), Quiz.class);
                    go_quiz.putExtra("count","1");
                    startActivityForResult(go_quiz, 3000);
                }

                // 화면 전환
                if(i == 10) {
                    Intent sujeong_i = new Intent(getApplicationContext(), Geunjeong.class);
                    startActivity(sujeong_i);
                }
            }
        });
    }

    // 텍스트 전환
    public void changeView(int index){
        TextView tv1 = (TextView) findViewById(R.id.sujeong_naesi_s1);
        TextView tv2 = (TextView) findViewById(R.id.sujeong_naesi_s2);
        TextView tv3 = (TextView) findViewById(R.id.sujeong_naesi_s3);
        TextView tv4 = (TextView) findViewById(R.id.sujeong_naesi_s4);
        TextView tv5 = (TextView) findViewById(R.id.sujeong_naesi_s5);
        TextView tv6 = (TextView) findViewById(R.id.sujeong_naesi_s6);
        TextView tv7 = (TextView) findViewById(R.id.sujeong_naesi_s7);

        // 전각 설명 아이콘
        sujeong_info_icon = (ImageView) findViewById(R.id.sujeong_info_icon);

        switch(index) {
            case 0:
                tv1.setVisibility(View.VISIBLE);
                tv2.setVisibility(View.INVISIBLE);
                tv3.setVisibility(View.INVISIBLE);
                tv4.setVisibility(View.INVISIBLE);
                tv5.setVisibility(View.INVISIBLE);
                tv6.setVisibility(View.INVISIBLE);
                tv7.setVisibility(View.INVISIBLE);
                sujeong_naesi.setVisibility(View.VISIBLE);
                sujeong_naesi2.setVisibility(View.INVISIBLE);
                sujeong_info_icon.setVisibility(View.INVISIBLE);
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
                sujeong_naesi.setVisibility(View.INVISIBLE);
                sujeong_naesi2.setVisibility(View.VISIBLE);
                sujeong_info_icon.setVisibility(View.INVISIBLE);
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
                sujeong_naesi.setVisibility(View.VISIBLE);
                sujeong_naesi2.setVisibility(View.INVISIBLE);
                sujeong_info_icon.setVisibility(View.INVISIBLE);
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
                sujeong_naesi.setVisibility(View.INVISIBLE);
                sujeong_naesi2.setVisibility(View.VISIBLE);
                sujeong_info_icon.setVisibility(View.INVISIBLE);
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
                sujeong_naesi.setVisibility(View.VISIBLE);
                sujeong_naesi2.setVisibility(View.INVISIBLE);
                sujeong_info_icon.setVisibility(View.INVISIBLE);
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
                sujeong_naesi.setVisibility(View.INVISIBLE);
                sujeong_naesi2.setVisibility(View.VISIBLE);
                sujeong_info_icon.setVisibility(View.INVISIBLE);
                i++;
                break;
            case 6:
                tv1.setVisibility(View.INVISIBLE);
                tv2.setVisibility(View.INVISIBLE);
                tv3.setVisibility(View.INVISIBLE);
                tv4.setVisibility(View.INVISIBLE);
                tv5.setVisibility(View.INVISIBLE);
                tv6.setVisibility(View.VISIBLE);
                tv7.setVisibility(View.INVISIBLE);
                sujeong_naesi.setVisibility(View.INVISIBLE);
                sujeong_naesi2.setVisibility(View.VISIBLE);
                sujeong_info_icon.setVisibility(View.VISIBLE);
                sujeong_info_icon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        CustomDialog building_info = new CustomDialog(Sujeong.this);
                        building_info.callFunction();
                    }
                });
                i++;
                break;
            case 7:
                tv1.setVisibility(View.INVISIBLE);
                tv2.setVisibility(View.INVISIBLE);
                tv3.setVisibility(View.INVISIBLE);
                tv4.setVisibility(View.INVISIBLE);
                tv5.setVisibility(View.INVISIBLE);
                tv6.setVisibility(View.VISIBLE);
                tv7.setVisibility(View.INVISIBLE);
                sujeong_naesi.setVisibility(View.INVISIBLE);
                sujeong_naesi2.setVisibility(View.VISIBLE);
                sujeong_info_icon.setVisibility(View.INVISIBLE);
                i++;
                break;
            // 퀴즈 맞춘 후
            case 8:
                tv1.setVisibility(View.INVISIBLE);
                tv2.setVisibility(View.INVISIBLE);
                tv3.setVisibility(View.INVISIBLE);
                tv4.setVisibility(View.INVISIBLE);
                tv5.setVisibility(View.INVISIBLE);
                tv6.setVisibility(View.INVISIBLE);
                tv7.setVisibility(View.VISIBLE);
                sujeong_naesi.setVisibility(View.VISIBLE);
                sujeong_naesi2.setVisibility(View.INVISIBLE);
                sujeong_info_icon.setVisibility(View.INVISIBLE);
                i++;
                break;
            case 9:
                tv1.setVisibility(View.INVISIBLE);
                tv2.setVisibility(View.INVISIBLE);
                tv3.setVisibility(View.INVISIBLE);
                tv4.setVisibility(View.INVISIBLE);
                tv5.setVisibility(View.INVISIBLE);
                tv6.setVisibility(View.INVISIBLE);
                tv7.setVisibility(View.VISIBLE);
                sujeong_naesi.setVisibility(View.VISIBLE);
                sujeong_naesi2.setVisibility(View.INVISIBLE);
                sujeong_info_icon.setVisibility(View.INVISIBLE);
                i++;
                break;
        }
    }

    // 백(취소)키가 눌렸을 때 종료 여부를 묻는 다이얼로그 창
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if((keyCode == KeyEvent.KEYCODE_BACK)) {
            AlertDialog.Builder d = new AlertDialog.Builder(Sujeong.this);
            d.setMessage("묘한 경복궁을 종료할까요?");

            d.setPositiveButton("예", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Sujeong.this.finish();
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
