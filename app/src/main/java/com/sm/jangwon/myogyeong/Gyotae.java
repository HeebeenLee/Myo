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

public class Gyotae extends AppCompatActivity {

    int i = 0;

    ImageView gyotae_myohyeon;
    ImageView gyotae_myohyeon2;

    ImageView gyotae_cat1;
    ImageView gyotae_cat2_black;
    ImageView gyotae_cat2;
    ImageView gyotae_cat3_black;

    ImageView gyotae_info_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 화면 가로 고정
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        // 상태바 제거
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_gyotae);

        // 전각 이름 배경 퇴장 애니메이션
        ImageView gyotae_title_bg = (ImageView) findViewById(R.id.gyotae_title_bg);
        Animation gyotae_title_bg_out_anim = AnimationUtils.loadAnimation(this, R.anim.building_name_out_anim);
        gyotae_title_bg.startAnimation(gyotae_title_bg_out_anim);

        // 전각 이름 퇴장 애니메이션
        TextView gyotae_title = (TextView) findViewById(R.id.gyotae_title);
        Animation gyotae_title_out_anim = AnimationUtils.loadAnimation(this, R.anim.building_name_out_anim);
        gyotae_title.startAnimation(gyotae_title_out_anim);

        // 묘현왕후 등장 애니메이션
        gyotae_myohyeon = (ImageView) findViewById(R.id.gyotae_myohyeon);
        gyotae_myohyeon2 = (ImageView) findViewById(R.id.gyotae_myohyeon2);
        Animation gyotae_myohyeon_anim = AnimationUtils.loadAnimation(this, R.anim.character_in_anim);
        gyotae_myohyeon.startAnimation(gyotae_myohyeon_anim);

        // 대화창 애니메이션
        ImageButton gyotae_dialog = (ImageButton) findViewById(R.id.gyotae_dialog);
        Animation gyotae_dialog_anim = AnimationUtils.loadAnimation(this, R.anim.dialog_in_anim);
        gyotae_dialog.startAnimation(gyotae_dialog_anim);

        // 이름표 애니메이션
        ImageView gyotae_nametag = (ImageView) findViewById(R.id.gyotae_nametag);
        Animation gyotae_nametag_anim = AnimationUtils.loadAnimation(this, R.anim.dialog_in_anim);
        gyotae_nametag.startAnimation(gyotae_nametag_anim);

        // 이름 애니메이션
        TextView gyotae_name = (TextView) findViewById(R.id.gyotae_name);
        Animation gyotae_name_anim = AnimationUtils.loadAnimation(this, R.anim.name_in_anim);
        gyotae_name.startAnimation(gyotae_name_anim);

        // 텍스트 애니메이션
        TextView gyotae_myohyeon_s1 = (TextView) findViewById(R.id.gyotae_myohyeon_s1);
        Animation gyotae_myohyeon_s1_anim = AnimationUtils.loadAnimation(this, R.anim.dialog_text_in_anim);
        gyotae_myohyeon_s1.startAnimation(gyotae_myohyeon_s1_anim);

        // 보따리
        ImageButton gyotae_pack = (ImageButton) findViewById(R.id.gyotae_pack);
        Animation gyotae_pack_anim = AnimationUtils.loadAnimation(this, R.anim.character_in_anim);
        gyotae_pack.startAnimation(gyotae_pack_anim);
        gyotae_pack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent gyotae_menu_i = new Intent(getApplicationContext(), Menu.class);
                startActivity(gyotae_menu_i);
            }
        });

        // 고양이
        gyotae_cat1 = (ImageView) findViewById(R.id.gyotae_cat1);
        gyotae_cat2_black = (ImageView) findViewById(R.id.gyotae_cat2_black);
        gyotae_cat2 = (ImageView) findViewById(R.id.gyotae_cat2);
        gyotae_cat3_black = (ImageView) findViewById(R.id.gyotae_cat3_black);
        Animation gyotae_cat_anim = AnimationUtils.loadAnimation(this, R.anim.character_in_anim);
        gyotae_cat1.startAnimation(gyotae_cat_anim);
        gyotae_cat2_black.startAnimation(gyotae_cat_anim);
        gyotae_cat3_black.startAnimation(gyotae_cat_anim);

        // 텍스트 전환
        changeView(i);
        gyotae_dialog.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                changeView(i);
                // 퀴즈
                if(i == 10)  {
                    Intent go_quiz  = new Intent(getApplicationContext(), Quiz.class);
                    go_quiz.putExtra("count","1");
                    startActivityForResult(go_quiz, 3000);
                }

                // 화면 전환
                if(i == 16) {
                    Intent gyotae_i = new Intent(getApplicationContext(), Hyangwon.class);
                    startActivity(gyotae_i);
                }
            }
        });
    }

    // 텍스트 전환
    public void changeView(int index){
        TextView tv1 = (TextView) findViewById(R.id.gyotae_myohyeon_s1);
        TextView tv2 = (TextView) findViewById(R.id.gyotae_myohyeon_s2);
        TextView tv3 = (TextView) findViewById(R.id.gyotae_myohyeon_s3);
        TextView tv4 = (TextView) findViewById(R.id.gyotae_myohyeon_s4);
        TextView tv5 = (TextView) findViewById(R.id.gyotae_myohyeon_s5);
        TextView tv6 = (TextView) findViewById(R.id.gyotae_myohyeon_s6);
        TextView tv7 = (TextView) findViewById(R.id.gyotae_myohyeon_s7);
        TextView tv8 = (TextView) findViewById(R.id.gyotae_myohyeon_s8);
        TextView tv9 = (TextView) findViewById(R.id.gyotae_myohyeon_s9);
        TextView tv10 = (TextView) findViewById(R.id.gyotae_myohyeon_s10);
        TextView tv11 = (TextView) findViewById(R.id.gyotae_myohyeon_s11);
        TextView tv12 = (TextView) findViewById(R.id.gyotae_myohyeon_s12);

        // 전각 설명 아이콘
        gyotae_info_icon = (ImageView) findViewById(R.id.gyotae_info_icon);

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
                gyotae_myohyeon.setVisibility(View.VISIBLE);
                gyotae_myohyeon2.setVisibility(View.INVISIBLE);
                gyotae_cat2.setVisibility(View.INVISIBLE);
                gyotae_info_icon.setVisibility(View.INVISIBLE);
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
                gyotae_myohyeon.setVisibility(View.INVISIBLE);
                gyotae_myohyeon2.setVisibility(View.VISIBLE);
                gyotae_cat2.setVisibility(View.INVISIBLE);
                gyotae_info_icon.setVisibility(View.INVISIBLE);
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
                gyotae_myohyeon.setVisibility(View.VISIBLE);
                gyotae_myohyeon2.setVisibility(View.INVISIBLE);
                gyotae_cat2.setVisibility(View.INVISIBLE);
                gyotae_info_icon.setVisibility(View.INVISIBLE);
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
                gyotae_myohyeon.setVisibility(View.INVISIBLE);
                gyotae_myohyeon2.setVisibility(View.VISIBLE);
                gyotae_cat2.setVisibility(View.INVISIBLE);
                gyotae_info_icon.setVisibility(View.INVISIBLE);
                i++;
                break;
            case 4:
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
                gyotae_myohyeon.setVisibility(View.INVISIBLE);
                gyotae_myohyeon2.setVisibility(View.VISIBLE);
                gyotae_cat2.setVisibility(View.INVISIBLE);
                gyotae_info_icon.setVisibility(View.VISIBLE);
                gyotae_info_icon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        CustomDialog building_info = new CustomDialog(Gyotae.this);
                        building_info.callFunction();
                    }
                });
                i++;
                break;
            case 5:
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
                gyotae_myohyeon.setVisibility(View.VISIBLE);
                gyotae_myohyeon2.setVisibility(View.INVISIBLE);
                gyotae_cat2.setVisibility(View.INVISIBLE);
                gyotae_info_icon.setVisibility(View.INVISIBLE);
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
                tv8.setVisibility(View.INVISIBLE);
                tv9.setVisibility(View.INVISIBLE);
                tv10.setVisibility(View.INVISIBLE);
                tv11.setVisibility(View.INVISIBLE);
                tv12.setVisibility(View.INVISIBLE);
                gyotae_myohyeon.setVisibility(View.INVISIBLE);
                gyotae_myohyeon2.setVisibility(View.VISIBLE);
                gyotae_cat2.setVisibility(View.INVISIBLE);
                gyotae_info_icon.setVisibility(View.INVISIBLE);
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
                tv8.setVisibility(View.INVISIBLE);
                tv9.setVisibility(View.INVISIBLE);
                tv10.setVisibility(View.INVISIBLE);
                tv11.setVisibility(View.INVISIBLE);
                tv12.setVisibility(View.INVISIBLE);
                gyotae_myohyeon.setVisibility(View.VISIBLE);
                gyotae_myohyeon2.setVisibility(View.INVISIBLE);
                gyotae_cat2.setVisibility(View.INVISIBLE);
                gyotae_info_icon.setVisibility(View.INVISIBLE);
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
                tv8.setVisibility(View.VISIBLE);
                tv9.setVisibility(View.INVISIBLE);
                tv10.setVisibility(View.INVISIBLE);
                tv11.setVisibility(View.INVISIBLE);
                tv12.setVisibility(View.INVISIBLE);
                gyotae_myohyeon.setVisibility(View.INVISIBLE);
                gyotae_myohyeon2.setVisibility(View.VISIBLE);
                gyotae_cat2.setVisibility(View.INVISIBLE);
                gyotae_info_icon.setVisibility(View.INVISIBLE);
                i++;
                break;
            case 9:
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
                gyotae_myohyeon.setVisibility(View.INVISIBLE);
                gyotae_myohyeon2.setVisibility(View.VISIBLE);
                gyotae_cat2.setVisibility(View.INVISIBLE);
                gyotae_info_icon.setVisibility(View.INVISIBLE);
                i++;
                break;
            // 퀴즈 맞춘 후
            case 10:
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
                gyotae_myohyeon.setVisibility(View.VISIBLE);
                gyotae_myohyeon2.setVisibility(View.INVISIBLE);
                gyotae_cat2.setVisibility(View.INVISIBLE);
                gyotae_info_icon.setVisibility(View.INVISIBLE);
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
                tv10.setVisibility(View.VISIBLE);
                tv11.setVisibility(View.INVISIBLE);
                tv12.setVisibility(View.INVISIBLE);
                gyotae_myohyeon.setVisibility(View.INVISIBLE);
                gyotae_myohyeon2.setVisibility(View.VISIBLE);
                gyotae_cat2.setVisibility(View.INVISIBLE);
                gyotae_info_icon.setVisibility(View.INVISIBLE);
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
                tv10.setVisibility(View.VISIBLE);
                tv11.setVisibility(View.INVISIBLE);
                tv12.setVisibility(View.INVISIBLE);
                gyotae_myohyeon.setVisibility(View.INVISIBLE);
                gyotae_myohyeon2.setVisibility(View.VISIBLE);
                gyotae_cat2.setVisibility(View.INVISIBLE);
                gyotae_info_icon.setVisibility(View.INVISIBLE);



                // 고양이 획득 화면



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
                tv11.setVisibility(View.VISIBLE);
                tv12.setVisibility(View.INVISIBLE);
                gyotae_myohyeon.setVisibility(View.VISIBLE);
                gyotae_myohyeon2.setVisibility(View.INVISIBLE);
                gyotae_cat2.setVisibility(View.VISIBLE);
                gyotae_info_icon.setVisibility(View.INVISIBLE);
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
                tv12.setVisibility(View.VISIBLE);
                gyotae_myohyeon.setVisibility(View.INVISIBLE);
                gyotae_myohyeon2.setVisibility(View.VISIBLE);
                gyotae_cat2.setVisibility(View.VISIBLE);
                gyotae_info_icon.setVisibility(View.INVISIBLE);
                i++;
                break;
            case 15:
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
                gyotae_myohyeon.setVisibility(View.INVISIBLE);
                gyotae_myohyeon2.setVisibility(View.VISIBLE);
                gyotae_cat2.setVisibility(View.VISIBLE);
                gyotae_info_icon.setVisibility(View.INVISIBLE);
                i++;
                break;

        }
    }

    // 백(취소)키가 눌렸을 때 종료 여부를 묻는 다이얼로그 창
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if((keyCode == KeyEvent.KEYCODE_BACK)) {
            AlertDialog.Builder d = new AlertDialog.Builder(Gyotae.this);
            d.setMessage("묘한 경복궁을 종료할까요?");

            d.setPositiveButton("예", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Gyotae.this.finish();
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
