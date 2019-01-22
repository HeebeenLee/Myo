package com.sm.jangwon.myogyeong;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import static com.sm.jangwon.myogyeong.MainActivity.GAME_PREFERENCES;

public class Jaseon extends AppCompatActivity {

    int i = 0;

    ImageView jaseon_seja;
    ImageView jaseon_seja2;
    ImageView jaseon_cat1_black;
    ImageView jaseon_cat1;
    ImageView jaseon_cat2_black;
    ImageView jaseon_cat3_black;
    ImageView jaseon_info_icon;

    Intent building_info;
    Intent find_cat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 화면 가로 고정
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        // 상태바 제거
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_jaseon);

        // 전각 이름 배경 퇴장 애니메이션
        ImageView jaseon_title_bg = (ImageView) findViewById(R.id.jaseon_title_bg);
        Animation jaseon_title_bg_out_anim = AnimationUtils.loadAnimation(this, R.anim.building_name_out_anim);
        jaseon_title_bg.startAnimation(jaseon_title_bg_out_anim);

        // 전각 이름 퇴장 애니메이션
        TextView jaseon_title = (TextView) findViewById(R.id.jaseon_title);
        Animation jaseon_title_out_anim = AnimationUtils.loadAnimation(this, R.anim.building_name_out_anim);
        jaseon_title.startAnimation(jaseon_title_out_anim);

        // 세자 등장 애니메이션
        jaseon_seja = (ImageView) findViewById(R.id.jaseon_seja);
        jaseon_seja2 = (ImageView) findViewById(R.id.jaseon_seja2);
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
        Animation jaseon_name_anim = AnimationUtils.loadAnimation(this, R.anim.name_in_anim);
        jaseon_name.startAnimation(jaseon_name_anim);

        // 텍스트 애니메이션
        TextView jaseon_seja_s1 = (TextView) findViewById(R.id.jaseon_seja_s1);
        Animation jaseon_seja_s1_anim = AnimationUtils.loadAnimation(this, R.anim.dialog_text_in_anim);
        jaseon_seja_s1.startAnimation(jaseon_seja_s1_anim);

        // 보따리
        ImageButton jaseon_pack = (ImageButton) findViewById(R.id.jaseon_pack);
        Animation jaseon_pack_anim = AnimationUtils.loadAnimation(this, R.anim.character_in_anim);
        jaseon_pack.startAnimation(jaseon_pack_anim);
        jaseon_pack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent jaseon_menu_i = new Intent(getApplicationContext(), Menu.class);
                startActivity(jaseon_menu_i);
            }
        });

        // 고양이
        jaseon_cat1_black = (ImageView) findViewById(R.id.jaseon_cat1_black);
        jaseon_cat1 = (ImageView) findViewById(R.id.jaseon_cat1);
        jaseon_cat2_black = (ImageView) findViewById(R.id.jaseon_cat2_black);
        jaseon_cat3_black = (ImageView) findViewById(R.id.jaseon_cat3_black);
        Animation jaseon_cat_anim = AnimationUtils.loadAnimation(this, R.anim.character_in_anim);
        jaseon_cat1_black.startAnimation(jaseon_cat_anim);
        jaseon_cat2_black.startAnimation(jaseon_cat_anim);
        jaseon_cat3_black.startAnimation(jaseon_cat_anim);

        // 책장 넘기는 소리 위한 사운드풀
        final SoundPool dialog_bgm = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
        final int dialog_sound = dialog_bgm.load(this, R.raw.dialog_sound, 1);

        // 텍스트 전환
        changeView(i);
        jaseon_dialog.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                changeView(i);
                // 퀴즈
                if(i == 11)  {
                    Intent go_quiz  = new Intent(getApplicationContext(), Quiz.class);
                    go_quiz.putExtra("count","1");
                    startActivityForResult(go_quiz, 3000);
                }

                // 화면 전환
                if(i == 18) {
                    Intent jaseon_i = new Intent(getApplicationContext(), Menu.class);
                    startActivity(jaseon_i);
                    // 책장 넘기는 소리
                    dialog_bgm.play(dialog_sound, 1, 1, 1, 0, 1);
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

        // 전각 설명 아이콘
        jaseon_info_icon = (ImageView) findViewById(R.id.jaseon_info_icon);

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
                jaseon_seja.setVisibility(View.VISIBLE);
                jaseon_seja2.setVisibility(View.INVISIBLE);
                jaseon_cat1.setVisibility(View.INVISIBLE);
                jaseon_info_icon.setVisibility(View.INVISIBLE);
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
                jaseon_seja.setVisibility(View.INVISIBLE);
                jaseon_seja2.setVisibility(View.VISIBLE);
                jaseon_cat1.setVisibility(View.INVISIBLE);
                jaseon_info_icon.setVisibility(View.INVISIBLE);
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
                jaseon_seja.setVisibility(View.VISIBLE);
                jaseon_seja2.setVisibility(View.INVISIBLE);
                jaseon_cat1.setVisibility(View.INVISIBLE);
                jaseon_info_icon.setVisibility(View.INVISIBLE);
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
                jaseon_seja.setVisibility(View.INVISIBLE);
                jaseon_seja2.setVisibility(View.VISIBLE);
                jaseon_cat1.setVisibility(View.INVISIBLE);
                jaseon_info_icon.setVisibility(View.INVISIBLE);
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
                jaseon_seja.setVisibility(View.VISIBLE);
                jaseon_seja2.setVisibility(View.INVISIBLE);
                jaseon_cat1.setVisibility(View.INVISIBLE);
                jaseon_info_icon.setVisibility(View.INVISIBLE);
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
                jaseon_seja.setVisibility(View.INVISIBLE);
                jaseon_seja2.setVisibility(View.VISIBLE);
                jaseon_cat1.setVisibility(View.INVISIBLE);
                jaseon_info_icon.setVisibility(View.INVISIBLE);
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
                jaseon_seja.setVisibility(View.VISIBLE);
                jaseon_seja2.setVisibility(View.INVISIBLE);
                jaseon_cat1.setVisibility(View.INVISIBLE);
                jaseon_info_icon.setVisibility(View.INVISIBLE);
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
                jaseon_seja.setVisibility(View.INVISIBLE);
                jaseon_seja2.setVisibility(View.VISIBLE);
                jaseon_cat1.setVisibility(View.INVISIBLE);
                jaseon_info_icon.setVisibility(View.INVISIBLE);
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
                tv13.setVisibility(View.INVISIBLE);
                tv14.setVisibility(View.INVISIBLE);
                jaseon_seja.setVisibility(View.INVISIBLE);
                jaseon_seja2.setVisibility(View.VISIBLE);
                jaseon_cat1.setVisibility(View.INVISIBLE);
                jaseon_info_icon.setVisibility(View.VISIBLE);
                // 자선당 설명
                building_info = new Intent(this, CustomDialog.class);
                jaseon_info_icon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        building_info.putExtra("count","2");
                        startActivityForResult(building_info,1);
                    }
                });
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
                tv8.setVisibility(View.INVISIBLE);
                tv9.setVisibility(View.VISIBLE);
                tv10.setVisibility(View.INVISIBLE);
                tv11.setVisibility(View.INVISIBLE);
                tv12.setVisibility(View.INVISIBLE);
                tv13.setVisibility(View.INVISIBLE);
                tv14.setVisibility(View.INVISIBLE);
                jaseon_seja.setVisibility(View.VISIBLE);
                jaseon_seja2.setVisibility(View.INVISIBLE);
                jaseon_cat1.setVisibility(View.INVISIBLE);
                jaseon_info_icon.setVisibility(View.INVISIBLE);
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
                tv10.setVisibility(View.INVISIBLE);
                tv11.setVisibility(View.INVISIBLE);
                tv12.setVisibility(View.INVISIBLE);
                tv13.setVisibility(View.INVISIBLE);
                tv14.setVisibility(View.INVISIBLE);
                jaseon_seja.setVisibility(View.VISIBLE);
                jaseon_seja2.setVisibility(View.INVISIBLE);
                jaseon_cat1.setVisibility(View.INVISIBLE);
                jaseon_info_icon.setVisibility(View.INVISIBLE);
                i++;
                break;
            // 퀴즈 맞춘 후
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
                tv13.setVisibility(View.INVISIBLE);
                tv14.setVisibility(View.INVISIBLE);
                jaseon_seja.setVisibility(View.INVISIBLE);
                jaseon_seja2.setVisibility(View.VISIBLE);
                jaseon_cat1.setVisibility(View.INVISIBLE);
                jaseon_info_icon.setVisibility(View.INVISIBLE);
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
                tv11.setVisibility(View.VISIBLE);
                tv12.setVisibility(View.INVISIBLE);
                tv13.setVisibility(View.INVISIBLE);
                tv14.setVisibility(View.INVISIBLE);
                jaseon_seja.setVisibility(View.VISIBLE);
                jaseon_seja2.setVisibility(View.INVISIBLE);
                jaseon_cat1.setVisibility(View.INVISIBLE);
                jaseon_info_icon.setVisibility(View.INVISIBLE);
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
                tv13.setVisibility(View.INVISIBLE);
                tv14.setVisibility(View.INVISIBLE);
                jaseon_seja.setVisibility(View.VISIBLE);
                jaseon_seja2.setVisibility(View.INVISIBLE);
                jaseon_cat1.setVisibility(View.INVISIBLE);
                jaseon_info_icon.setVisibility(View.INVISIBLE);
                // 고양이 획득
                find_cat = new Intent(this, FindCat.class);
                find_cat.putExtra("where","1");
                startActivityForResult(find_cat,1);
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
                tv13.setVisibility(View.INVISIBLE);
                tv14.setVisibility(View.INVISIBLE);
                jaseon_seja.setVisibility(View.INVISIBLE);
                jaseon_seja2.setVisibility(View.VISIBLE);
                jaseon_cat1.setVisibility(View.VISIBLE);
                jaseon_info_icon.setVisibility(View.INVISIBLE);
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
                tv12.setVisibility(View.INVISIBLE);
                tv13.setVisibility(View.VISIBLE);
                tv14.setVisibility(View.INVISIBLE);
                jaseon_seja.setVisibility(View.VISIBLE);
                jaseon_seja2.setVisibility(View.INVISIBLE);
                jaseon_cat1.setVisibility(View.VISIBLE);
                jaseon_info_icon.setVisibility(View.INVISIBLE);
                i++;
                break;
            case 16:
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
                jaseon_seja.setVisibility(View.INVISIBLE);
                jaseon_seja2.setVisibility(View.VISIBLE);
                jaseon_cat1.setVisibility(View.VISIBLE);
                jaseon_info_icon.setVisibility(View.INVISIBLE);
                i++;
                break;
            case 17:
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
                jaseon_seja.setVisibility(View.INVISIBLE);
                jaseon_seja2.setVisibility(View.VISIBLE);
                jaseon_cat1.setVisibility(View.VISIBLE);
                jaseon_info_icon.setVisibility(View.INVISIBLE);
                i++;
                break;
        }
    }

    // 중간 저장
    public void onStop() {
        super.onStop();
        SharedPreferences settings = this.getApplicationContext().getSharedPreferences(GAME_PREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = settings.edit();
        prefEditor.putInt("goTO", 3);
        prefEditor.commit();
    }

    // 백(취소)키가 눌렸을 때 종료 여부를 묻는 다이얼로그 창
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if((keyCode == KeyEvent.KEYCODE_BACK)) {
            AlertDialog.Builder d = new AlertDialog.Builder(Jaseon.this);
            d.setMessage("묘한 경복궁을 종료할까요?");

            d.setPositiveButton("예", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    onStop();
                    ActivityCompat.finishAffinity(Jaseon.this);
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
