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

public class Naesoju extends AppCompatActivity {

    int i = 0;

    ImageView naesoju_sanggung;
    ImageView naesoju_sanggung2;
    ImageView naesoju_sanggung_smile;
    ImageView naesoju_sanggung_smile2;

    ImageView naesoju_cat1;
    ImageView naesoju_cat2_black;
    ImageView naesoju_cat3_black;

    ImageView naesoju_info_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 화면 가로 고정
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        // 상태바 제거
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_naesoju);

        // 전각 이름 배경 퇴장 애니메이션
        ImageView naesoju_title_bg = (ImageView) findViewById(R.id.naesoju_title_bg);
        Animation naesoju_title_bg_out_anim = AnimationUtils.loadAnimation(this, R.anim.building_name_out_anim);
        naesoju_title_bg.startAnimation(naesoju_title_bg_out_anim);

        // 전각 이름 퇴장 애니메이션
        TextView naesoju_title = (TextView) findViewById(R.id.naesoju_title);
        Animation naesoju_title_out_anim = AnimationUtils.loadAnimation(this, R.anim.building_name_out_anim);
        naesoju_title.startAnimation(naesoju_title_out_anim);

        // 상궁 등장 애니메이션
        naesoju_sanggung = (ImageView) findViewById(R.id.naesoju_sanggung);
        naesoju_sanggung2 = (ImageView) findViewById(R.id.naesoju_sanggung2);
        naesoju_sanggung_smile = (ImageView) findViewById(R.id.naesoju_sanggung_smile);
        naesoju_sanggung_smile2 = (ImageView) findViewById(R.id.naesoju_sanggung_smile2);
        Animation naesoju_sanggung_anim = AnimationUtils.loadAnimation(this, R.anim.character_in_anim);
        naesoju_sanggung.startAnimation(naesoju_sanggung_anim);

        // 대화창 애니메이션
        ImageButton naesoju_dialog = (ImageButton) findViewById(R.id.naesoju_dialog);
        Animation naesoju_dialog_anim = AnimationUtils.loadAnimation(this, R.anim.dialog_in_anim);
        naesoju_dialog.startAnimation(naesoju_dialog_anim);

        // 이름표 애니메이션
        ImageView naesoju_nametag = (ImageView) findViewById(R.id.naesoju_nametag);
        Animation naesoju_nametag_anim = AnimationUtils.loadAnimation(this, R.anim.dialog_in_anim);
        naesoju_nametag.startAnimation(naesoju_nametag_anim);

        // 이름 애니메이션
        TextView naesoju_name = (TextView) findViewById(R.id.naesoju_name);
        Animation naesoju_name_anim = AnimationUtils.loadAnimation(this, R.anim.name_in_anim);
        naesoju_name.startAnimation(naesoju_name_anim);

        // 텍스트 애니메이션
        TextView naesoju_sanggung_s1 = (TextView) findViewById(R.id.naesoju_sanggung_s1);
        Animation naesoju_sanggung_s1_anim = AnimationUtils.loadAnimation(this, R.anim.dialog_text_in_anim);
        naesoju_sanggung_s1.startAnimation(naesoju_sanggung_s1_anim);

        // 보따리
        ImageButton naesoju_pack = (ImageButton) findViewById(R.id.naesoju_pack);
        Animation naesoju_pack_anim = AnimationUtils.loadAnimation(this, R.anim.character_in_anim);
        naesoju_pack.startAnimation(naesoju_pack_anim);
        naesoju_pack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent naesoju_menu_i = new Intent(getApplicationContext(), Menu.class);
                startActivity(naesoju_menu_i);
            }
        });

        // 고양이
        naesoju_cat1 = (ImageView) findViewById(R.id.naesoju_cat1);
        naesoju_cat2_black = (ImageView) findViewById(R.id.naesoju_cat2_black);
        naesoju_cat3_black = (ImageView) findViewById(R.id.naesoju_cat3_black);
        Animation naesoju_cat_anim = AnimationUtils.loadAnimation(this, R.anim.character_in_anim);
        naesoju_cat1.startAnimation(naesoju_cat_anim);
        naesoju_cat2_black.startAnimation(naesoju_cat_anim);
        naesoju_cat3_black.startAnimation(naesoju_cat_anim);

        // 텍스트 전환
        changeView(i);
        naesoju_dialog.setOnClickListener(new View.OnClickListener(){
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
                if(i == 12) {
                    Intent naesoju_i = new Intent(getApplicationContext(), Gyotae.class);
                    startActivity(naesoju_i);
                }
            }
        });
    }

    // 텍스트 전환
    public void changeView(int index){
        TextView tv1 = (TextView) findViewById(R.id.naesoju_sanggung_s1);
        TextView tv2 = (TextView) findViewById(R.id.naesoju_sanggung_s2);
        TextView tv3 = (TextView) findViewById(R.id.naesoju_sanggung_s3);
        TextView tv4 = (TextView) findViewById(R.id.naesoju_sanggung_s4);
        TextView tv5 = (TextView) findViewById(R.id.naesoju_sanggung_s5);
        TextView tv6 = (TextView) findViewById(R.id.naesoju_sanggung_s6);
        TextView tv7 = (TextView) findViewById(R.id.naesoju_sanggung_s7);
        TextView tv8 = (TextView) findViewById(R.id.naesoju_sanggung_s8);
        TextView tv9 = (TextView) findViewById(R.id.naesoju_sanggung_s9);

        // 전각 설명 아이콘
        naesoju_info_icon = (ImageView) findViewById(R.id.naesoju_info_icon);

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
                naesoju_sanggung.setVisibility(View.VISIBLE);
                naesoju_sanggung2.setVisibility(View.INVISIBLE);
                naesoju_sanggung_smile.setVisibility(View.INVISIBLE);
                naesoju_sanggung_smile2.setVisibility(View.INVISIBLE);
                naesoju_info_icon.setVisibility(View.INVISIBLE);
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
                naesoju_sanggung.setVisibility(View.INVISIBLE);
                naesoju_sanggung2.setVisibility(View.VISIBLE);
                naesoju_sanggung_smile.setVisibility(View.INVISIBLE);
                naesoju_sanggung_smile2.setVisibility(View.INVISIBLE);
                naesoju_info_icon.setVisibility(View.INVISIBLE);
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
                naesoju_sanggung.setVisibility(View.VISIBLE);
                naesoju_sanggung2.setVisibility(View.INVISIBLE);
                naesoju_sanggung_smile.setVisibility(View.INVISIBLE);
                naesoju_sanggung_smile2.setVisibility(View.INVISIBLE);
                naesoju_info_icon.setVisibility(View.INVISIBLE);
                i++;
                break;
            case 3:
                tv1.setVisibility(View.INVISIBLE);
                tv2.setVisibility(View.INVISIBLE);
                tv3.setVisibility(View.VISIBLE);
                tv4.setVisibility(View.INVISIBLE);
                tv5.setVisibility(View.INVISIBLE);
                tv6.setVisibility(View.INVISIBLE);
                tv7.setVisibility(View.INVISIBLE);
                tv8.setVisibility(View.INVISIBLE);
                tv9.setVisibility(View.INVISIBLE);
                naesoju_sanggung.setVisibility(View.VISIBLE);
                naesoju_sanggung2.setVisibility(View.INVISIBLE);
                naesoju_sanggung_smile.setVisibility(View.INVISIBLE);
                naesoju_sanggung_smile2.setVisibility(View.INVISIBLE);
                naesoju_info_icon.setVisibility(View.VISIBLE);
                naesoju_info_icon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        CustomDialog building_info = new CustomDialog(Naesoju.this);
                        building_info.callFunction();
                    }
                });
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
                naesoju_sanggung.setVisibility(View.INVISIBLE);
                naesoju_sanggung2.setVisibility(View.VISIBLE);
                naesoju_sanggung_smile.setVisibility(View.INVISIBLE);
                naesoju_sanggung_smile2.setVisibility(View.INVISIBLE);
                naesoju_info_icon.setVisibility(View.INVISIBLE);
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
                naesoju_sanggung.setVisibility(View.VISIBLE);
                naesoju_sanggung2.setVisibility(View.INVISIBLE);
                naesoju_sanggung_smile.setVisibility(View.INVISIBLE);
                naesoju_sanggung_smile2.setVisibility(View.INVISIBLE);
                naesoju_info_icon.setVisibility(View.INVISIBLE);
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
                naesoju_sanggung.setVisibility(View.INVISIBLE);
                naesoju_sanggung2.setVisibility(View.VISIBLE);
                naesoju_sanggung_smile.setVisibility(View.INVISIBLE);
                naesoju_sanggung_smile2.setVisibility(View.INVISIBLE);
                naesoju_info_icon.setVisibility(View.INVISIBLE);
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
                tv8.setVisibility(View.INVISIBLE);
                tv9.setVisibility(View.INVISIBLE);
                naesoju_sanggung.setVisibility(View.INVISIBLE);
                naesoju_sanggung2.setVisibility(View.VISIBLE);
                naesoju_sanggung_smile.setVisibility(View.INVISIBLE);
                naesoju_sanggung_smile2.setVisibility(View.INVISIBLE);
                naesoju_info_icon.setVisibility(View.INVISIBLE);
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
                tv8.setVisibility(View.INVISIBLE);
                tv9.setVisibility(View.INVISIBLE);
                naesoju_sanggung.setVisibility(View.INVISIBLE);
                naesoju_sanggung2.setVisibility(View.INVISIBLE);
                naesoju_sanggung_smile.setVisibility(View.VISIBLE);
                naesoju_sanggung_smile2.setVisibility(View.INVISIBLE);
                naesoju_info_icon.setVisibility(View.INVISIBLE);
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
                naesoju_sanggung.setVisibility(View.INVISIBLE);
                naesoju_sanggung2.setVisibility(View.INVISIBLE);
                naesoju_sanggung_smile.setVisibility(View.INVISIBLE);
                naesoju_sanggung_smile2.setVisibility(View.VISIBLE);
                naesoju_info_icon.setVisibility(View.INVISIBLE);
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
                tv9.setVisibility(View.VISIBLE);
                naesoju_sanggung.setVisibility(View.INVISIBLE);
                naesoju_sanggung2.setVisibility(View.INVISIBLE);
                naesoju_sanggung_smile.setVisibility(View.VISIBLE);
                naesoju_sanggung_smile2.setVisibility(View.INVISIBLE);
                naesoju_info_icon.setVisibility(View.INVISIBLE);
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
                tv9.setVisibility(View.VISIBLE);
                naesoju_sanggung.setVisibility(View.INVISIBLE);
                naesoju_sanggung2.setVisibility(View.INVISIBLE);
                naesoju_sanggung_smile.setVisibility(View.VISIBLE);
                naesoju_sanggung_smile2.setVisibility(View.INVISIBLE);
                naesoju_info_icon.setVisibility(View.INVISIBLE);
                i++;
                break;
        }
    }

    // 백(취소)키가 눌렸을 때 종료 여부를 묻는 다이얼로그 창
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if((keyCode == KeyEvent.KEYCODE_BACK)) {
            AlertDialog.Builder d = new AlertDialog.Builder(Naesoju.this);
            d.setMessage("묘한 경복궁을 종료할까요?");

            d.setPositiveButton("예", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Naesoju.this.finish();
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
