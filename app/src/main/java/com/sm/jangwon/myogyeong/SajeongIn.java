package com.sm.jangwon.myogyeong;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SajeongIn extends AppCompatActivity {

    int i = 0;

    ImageView sajeong_in_myojong;
    ImageView sajeong_in_myojong2;
    ImageView sajeong_in_myojong_sad;
    ImageView sajeong_in_myojong_sad2;

    ImageView sajeong_in_info_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 화면 가로 고정
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        // 상태바 제거
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_sajeong_in);

        // 전각 이름 배경 퇴장 애니메이션
        ImageView sajeong_in_title_bg = (ImageView) findViewById(R.id.sajeong_in_title_bg);
        Animation sajeong_in_title_bg_out_anim = AnimationUtils.loadAnimation(this, R.anim.building_name_out_anim);
        sajeong_in_title_bg.startAnimation(sajeong_in_title_bg_out_anim);

        // 전각 이름 퇴장 애니메이션
        TextView sajeong_in_title = (TextView) findViewById(R.id.sajeong_in_title);
        Animation sajeong_in_title_out_anim = AnimationUtils.loadAnimation(this, R.anim.building_name_out_anim);
        sajeong_in_title.startAnimation(sajeong_in_title_out_anim);

        // 묘종 등장 애니메이션
        sajeong_in_myojong = (ImageView) findViewById(R.id.sajeong_in_myojong);
        sajeong_in_myojong2 = (ImageView) findViewById(R.id.sajeong_in_myojong2);
        sajeong_in_myojong_sad = (ImageView) findViewById(R.id.sajeong_in_myojong_sad);
        sajeong_in_myojong_sad2 = (ImageView) findViewById(R.id.sajeong_in_myojong_sad2);
        Animation sajeong_in_myojong_anim = AnimationUtils.loadAnimation(this, R.anim.character_in_anim);
        sajeong_in_myojong.startAnimation(sajeong_in_myojong_anim);

        // 대화창 애니메이션
        ImageButton sajeong_in_dialog = (ImageButton) findViewById(R.id.sajeong_in_dialog);
        Animation sajeong_in_dialog_anim = AnimationUtils.loadAnimation(this, R.anim.dialog_in_anim);
        sajeong_in_dialog.startAnimation(sajeong_in_dialog_anim);

        // 이름표 애니메이션
        ImageView sajeong_in_nametag = (ImageView) findViewById(R.id.sajeong_in_nametag);
        Animation sajeong_in_nametag_anim = AnimationUtils.loadAnimation(this, R.anim.dialog_in_anim);
        sajeong_in_nametag.startAnimation(sajeong_in_nametag_anim);

        // 이름 애니메이션
        TextView sajeong_in_name = (TextView) findViewById(R.id.sajeong_in_name);
        Animation sajeong_in_name_anim = AnimationUtils.loadAnimation(this, R.anim.name_in_anim);
        sajeong_in_name.startAnimation(sajeong_in_name_anim);

        // 텍스트 애니메이션
        TextView sajeong_in_myojong_s1 = (TextView) findViewById(R.id.sajeong_in_myojong_s1);
        Animation sajeong_in_myojong_s1_anim = AnimationUtils.loadAnimation(this, R.anim.dialog_text_in_anim);
        sajeong_in_myojong_s1.startAnimation(sajeong_in_myojong_s1_anim);

        // 텍스트 전환
        changeView(i);
        sajeong_in_dialog.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                changeView(i);
                // 화면 전환
                if(i == 9) {
                    Intent sajeong_in_i = new Intent(getApplicationContext(), Sajeong.class);
                    startActivity(sajeong_in_i);
                }
            }
        });

    }

    // 텍스트 전환
    public void changeView(int index){
        TextView tv1 = (TextView) findViewById(R.id.sajeong_in_myojong_s1);
        TextView tv2 = (TextView) findViewById(R.id.sajeong_in_myojong_s2);
        TextView tv3 = (TextView) findViewById(R.id.sajeong_in_myojong_s3);
        TextView tv4 = (TextView) findViewById(R.id.sajeong_in_myojong_s4);
        TextView tv5 = (TextView) findViewById(R.id.sajeong_in_myojong_s5);
        TextView tv6 = (TextView) findViewById(R.id.sajeong_in_myojong_s6);
        TextView tv7 = (TextView) findViewById(R.id.sajeong_in_myojong_s7);

        // 전각 설명 아이콘
        sajeong_in_info_icon = (ImageView) findViewById(R.id.sajeong_in_info_icon);

        switch(index){
            case 0:
                tv1.setVisibility(View.VISIBLE);
                tv2.setVisibility(View.INVISIBLE);
                tv3.setVisibility(View.INVISIBLE);
                tv4.setVisibility(View.INVISIBLE);
                tv5.setVisibility(View.INVISIBLE);
                tv6.setVisibility(View.INVISIBLE);
                tv7.setVisibility(View.INVISIBLE);
                sajeong_in_myojong.setVisibility(View.VISIBLE);
                sajeong_in_myojong2.setVisibility(View.INVISIBLE);
                sajeong_in_myojong_sad.setVisibility(View.INVISIBLE);
                sajeong_in_myojong_sad2.setVisibility(View.INVISIBLE);
                sajeong_in_info_icon.setVisibility(View.INVISIBLE);
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
                sajeong_in_myojong.setVisibility(View.INVISIBLE);
                sajeong_in_myojong2.setVisibility(View.VISIBLE);
                sajeong_in_myojong_sad.setVisibility(View.INVISIBLE);
                sajeong_in_myojong_sad2.setVisibility(View.INVISIBLE);
                sajeong_in_info_icon.setVisibility(View.INVISIBLE);
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
                sajeong_in_myojong.setVisibility(View.INVISIBLE);
                sajeong_in_myojong2.setVisibility(View.INVISIBLE);
                sajeong_in_myojong_sad.setVisibility(View.VISIBLE);
                sajeong_in_myojong_sad2.setVisibility(View.INVISIBLE);
                sajeong_in_info_icon.setVisibility(View.INVISIBLE);
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
                sajeong_in_myojong.setVisibility(View.INVISIBLE);
                sajeong_in_myojong2.setVisibility(View.INVISIBLE);
                sajeong_in_myojong_sad.setVisibility(View.INVISIBLE);
                sajeong_in_myojong_sad2.setVisibility(View.VISIBLE);
                sajeong_in_info_icon.setVisibility(View.INVISIBLE);
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
                sajeong_in_myojong.setVisibility(View.INVISIBLE);
                sajeong_in_myojong2.setVisibility(View.INVISIBLE);
                sajeong_in_myojong_sad.setVisibility(View.VISIBLE);
                sajeong_in_myojong_sad2.setVisibility(View.INVISIBLE);
                sajeong_in_info_icon.setVisibility(View.INVISIBLE);
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
                sajeong_in_myojong.setVisibility(View.INVISIBLE);
                sajeong_in_myojong2.setVisibility(View.VISIBLE);
                sajeong_in_myojong_sad.setVisibility(View.INVISIBLE);
                sajeong_in_myojong_sad2.setVisibility(View.INVISIBLE);
                sajeong_in_info_icon.setVisibility(View.INVISIBLE);
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
                sajeong_in_myojong.setVisibility(View.INVISIBLE);
                sajeong_in_myojong2.setVisibility(View.VISIBLE);
                sajeong_in_myojong_sad.setVisibility(View.INVISIBLE);
                sajeong_in_myojong_sad2.setVisibility(View.INVISIBLE);
                sajeong_in_info_icon.setVisibility(View.VISIBLE);
                sajeong_in_info_icon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        CustomDialog building_info = new CustomDialog(SajeongIn.this);
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
                tv6.setVisibility(View.INVISIBLE);
                tv7.setVisibility(View.VISIBLE);
                sajeong_in_myojong.setVisibility(View.VISIBLE);
                sajeong_in_myojong2.setVisibility(View.INVISIBLE);
                sajeong_in_myojong_sad.setVisibility(View.INVISIBLE);
                sajeong_in_myojong_sad2.setVisibility(View.INVISIBLE);
                sajeong_in_info_icon.setVisibility(View.INVISIBLE);
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
                sajeong_in_myojong.setVisibility(View.VISIBLE);
                sajeong_in_myojong2.setVisibility(View.INVISIBLE);
                sajeong_in_myojong_sad.setVisibility(View.INVISIBLE);
                sajeong_in_myojong_sad2.setVisibility(View.INVISIBLE);
                sajeong_in_info_icon.setVisibility(View.INVISIBLE);
                i++;
                break;
        }
    }

    // 백(취소)키가 눌렸을 때 종료 여부를 묻는 다이얼로그 창
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if((keyCode == KeyEvent.KEYCODE_BACK)) {
            AlertDialog.Builder d = new AlertDialog.Builder(SajeongIn.this);
            d.setMessage("묘한 경복궁을 종료할까요?");

            d.setPositiveButton("예", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    SajeongIn.this.finish();
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
