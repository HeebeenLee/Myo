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

public class Hyangwon extends AppCompatActivity {

    int i = 0;

    ImageView hyangwon_taeyang;
    ImageView hyangwon_cat1;
    ImageView hyangwon_cat2;
    ImageView hyangwon_cat3_black;
    ImageView hyangwon_cat3;
    ImageView hyangwon_info_icon;

    Intent building_info;
    Intent find_cat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 화면 가로 고정
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        // 상태바 제거
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_hyangwon);

        // 전각 이름 배경 퇴장 애니메이션
        ImageView hyangwon_title_bg = (ImageView) findViewById(R.id.hyangwon_title_bg);
        Animation hyangwon_title_bg_out_anim = AnimationUtils.loadAnimation(this, R.anim.building_name_out_anim);
        hyangwon_title_bg.startAnimation(hyangwon_title_bg_out_anim);

        // 전각 이름 퇴장 애니메이션
        TextView hyangwon_title = (TextView) findViewById(R.id.hyangwon_title);
        Animation hyangwon_title_out_anim = AnimationUtils.loadAnimation(this, R.anim.building_name_out_anim);
        hyangwon_title.startAnimation(hyangwon_title_out_anim);

        // 태양이 등장 애니메이션
        hyangwon_taeyang = (ImageView) findViewById(R.id.hyangwon_taeyang);
        Animation hyangwon_taeyang_anim = AnimationUtils.loadAnimation(this, R.anim.character_in_anim);
        hyangwon_taeyang.startAnimation(hyangwon_taeyang_anim);

        // 대화창 애니메이션
        ImageButton hyangwon_dialog = (ImageButton) findViewById(R.id.hyangwon_dialog);
        Animation hyangwon_dialog_anim = AnimationUtils.loadAnimation(this, R.anim.dialog_in_anim);
        hyangwon_dialog.startAnimation(hyangwon_dialog_anim);

        // 이름표 애니메이션
        ImageView hyangwon_nametag = (ImageView) findViewById(R.id.hyangwon_nametag);
        Animation hyangwon_nametag_anim = AnimationUtils.loadAnimation(this, R.anim.dialog_in_anim);
        hyangwon_nametag.startAnimation(hyangwon_nametag_anim);

        // 이름 애니메이션
        TextView hyangwon_name = (TextView) findViewById(R.id.hyangwon_name);
        Animation hyangwon_name_anim = AnimationUtils.loadAnimation(this, R.anim.name_in_anim);
        hyangwon_name.startAnimation(hyangwon_name_anim);

        // 텍스트 애니메이션
        TextView hyangwon_taeyang_s1 = (TextView) findViewById(R.id.hyangwon_taeyang_s1);
        Animation hyangwon_taeyang_s1_anim = AnimationUtils.loadAnimation(this, R.anim.dialog_text_in_anim);
        hyangwon_taeyang_s1.startAnimation(hyangwon_taeyang_s1_anim);

        // 보따리
        ImageButton hyangwon_pack = (ImageButton) findViewById(R.id.hyangwon_pack);
        Animation hyangwon_pack_anim = AnimationUtils.loadAnimation(this, R.anim.character_in_anim);
        hyangwon_pack.startAnimation(hyangwon_pack_anim);
        hyangwon_pack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent hyangwon_menu_i = new Intent(getApplicationContext(), Menu.class);
                startActivity(hyangwon_menu_i);
            }
        });

        // 고양이
        hyangwon_cat1 = (ImageView) findViewById(R.id.hyangwon_cat1);
        hyangwon_cat2 = (ImageView) findViewById(R.id.hyangwon_cat2);
        hyangwon_cat3_black = (ImageView) findViewById(R.id.hyangwon_cat3_black);
        hyangwon_cat3 = (ImageView) findViewById(R.id.hyangwon_cat3);
        Animation hyangwon_cat_anim = AnimationUtils.loadAnimation(this, R.anim.character_in_anim);
        hyangwon_cat1.startAnimation(hyangwon_cat_anim);
        hyangwon_cat2.startAnimation(hyangwon_cat_anim);
        hyangwon_cat3_black.startAnimation(hyangwon_cat_anim);

        // 책장 넘기는 소리 위한 사운드풀
        final SoundPool dialog_bgm = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
        final int dialog_sound = dialog_bgm.load(this, R.raw.dialog_sound, 1);

        // 텍스트 전환
        changeView(i);
        hyangwon_dialog.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                changeView(i);
                // 퀴즈
                if(i == 10)  {
                    Intent go_quiz  = new Intent(getApplicationContext(), Quiz.class);
                    go_quiz.putExtra("count","4");
                    startActivityForResult(go_quiz, 3000);
                }

                // 화면 전환
                if(i == 13) {
                    Intent hyangwon_i = new Intent(getApplicationContext(), Menu.class);
                    startActivity(hyangwon_i);
                    // 책장 넘기는 소리
                    dialog_bgm.play(dialog_sound, 1, 1, 1, 0, 1);
                }
            }
        });
    }

    // 텍스트 전환
    public void changeView(int index){
        TextView tv1 = (TextView) findViewById(R.id.hyangwon_taeyang_s1);
        TextView tv2 = (TextView) findViewById(R.id.hyangwon_taeyang_s2);
        TextView tv3 = (TextView) findViewById(R.id.hyangwon_taeyang_s3);
        TextView tv4 = (TextView) findViewById(R.id.hyangwon_taeyang_s4);
        TextView tv5 = (TextView) findViewById(R.id.hyangwon_taeyang_s5);
        TextView tv6 = (TextView) findViewById(R.id.hyangwon_taeyang_s6);
        TextView tv7 = (TextView) findViewById(R.id.hyangwon_taeyang_s7);
        TextView tv8 = (TextView) findViewById(R.id.hyangwon_taeyang_s8);
        TextView tv9 = (TextView) findViewById(R.id.hyangwon_taeyang_s9);

        // 전각 설명 아이콘
        hyangwon_info_icon = (ImageView) findViewById(R.id.hyangwon_info_icon);

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
                hyangwon_cat3.setVisibility(View.INVISIBLE);
                hyangwon_info_icon.setVisibility(View.INVISIBLE);
                i++;
                break;
            case 1:
                tv1.setVisibility(View.VISIBLE);
                tv2.setVisibility(View.INVISIBLE);
                tv3.setVisibility(View.INVISIBLE);
                tv4.setVisibility(View.INVISIBLE);
                tv5.setVisibility(View.INVISIBLE);
                tv6.setVisibility(View.INVISIBLE);
                tv7.setVisibility(View.INVISIBLE);
                tv8.setVisibility(View.INVISIBLE);
                tv9.setVisibility(View.INVISIBLE);
                hyangwon_cat3.setVisibility(View.INVISIBLE);
                hyangwon_info_icon.setVisibility(View.INVISIBLE);
                // 고양이 획득
                find_cat = new Intent(this, FindCat.class);
                find_cat.putExtra("where","3");
                startActivityForResult(find_cat,1);
                i++;
                break;
            case 2:
                tv1.setVisibility(View.INVISIBLE);
                tv2.setVisibility(View.VISIBLE);
                tv3.setVisibility(View.INVISIBLE);
                tv4.setVisibility(View.INVISIBLE);
                tv5.setVisibility(View.INVISIBLE);
                tv6.setVisibility(View.INVISIBLE);
                tv7.setVisibility(View.INVISIBLE);
                tv8.setVisibility(View.INVISIBLE);
                tv9.setVisibility(View.INVISIBLE);
                hyangwon_cat3.setVisibility(View.VISIBLE);
                hyangwon_info_icon.setVisibility(View.INVISIBLE);
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
                hyangwon_cat3.setVisibility(View.VISIBLE);
                hyangwon_info_icon.setVisibility(View.INVISIBLE);
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
                hyangwon_cat3.setVisibility(View.VISIBLE);
                hyangwon_info_icon.setVisibility(View.INVISIBLE);
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
                hyangwon_cat3.setVisibility(View.VISIBLE);
                hyangwon_info_icon.setVisibility(View.INVISIBLE);
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
                hyangwon_cat3.setVisibility(View.VISIBLE);
                hyangwon_info_icon.setVisibility(View.INVISIBLE);
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
                hyangwon_cat3.setVisibility(View.VISIBLE);
                hyangwon_info_icon.setVisibility(View.INVISIBLE);
                i++;
                break;
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
                hyangwon_cat3.setVisibility(View.VISIBLE);
                hyangwon_info_icon.setVisibility(View.VISIBLE);
                // 향원정 설명
                building_info = new Intent(this, CustomDialog.class);
                hyangwon_info_icon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        building_info.putExtra("count","5");
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
                tv7.setVisibility(View.VISIBLE);
                tv8.setVisibility(View.INVISIBLE);
                tv9.setVisibility(View.INVISIBLE);
                hyangwon_cat3.setVisibility(View.VISIBLE);
                hyangwon_info_icon.setVisibility(View.INVISIBLE);
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
                tv8.setVisibility(View.VISIBLE);
                tv9.setVisibility(View.INVISIBLE);
                hyangwon_cat3.setVisibility(View.VISIBLE);
                hyangwon_info_icon.setVisibility(View.INVISIBLE);
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
                hyangwon_cat3.setVisibility(View.VISIBLE);
                hyangwon_info_icon.setVisibility(View.INVISIBLE);
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
                tv9.setVisibility(View.VISIBLE);
                hyangwon_cat3.setVisibility(View.VISIBLE);
                hyangwon_info_icon.setVisibility(View.INVISIBLE);
                i++;
                break;
        }
    }

    // 중간 저장
    public void onStop() {
        super.onStop();
        SharedPreferences settings = this.getApplicationContext().getSharedPreferences(GAME_PREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = settings.edit();
        prefEditor.putInt("goTO", 6);
        prefEditor.commit();
    }

    // 백(취소)키가 눌렸을 때 종료 여부를 묻는 다이얼로그 창
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if((keyCode == KeyEvent.KEYCODE_BACK)) {
            AlertDialog.Builder d = new AlertDialog.Builder(Hyangwon.this);
            d.setMessage("묘한 경복궁을 종료할까요?");

            d.setPositiveButton("예", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    onStop();
                    ActivityCompat.finishAffinity(Hyangwon.this);
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
