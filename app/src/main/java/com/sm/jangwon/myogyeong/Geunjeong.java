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

public class Geunjeong extends AppCompatActivity {

    int i = 0;

    ImageView geunjeong_taepyeong;
    ImageView geunjeong_taesaeng;
    ImageView geunjeong_taeyang;
    ImageView geunjeong_myojong_smile;
    ImageView geunjeong_myojong_smile2;

    TextView geunjeong_taepyeong_name;
    TextView geunjeong_taesaeng_name;
    TextView geunjeong_taeyang_name;
    TextView geunjeong_myojong_name;

    ImageView geunjeong_info_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 화면 가로 고정
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        // 상태바 제거
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_geunjeong);

        // 전각 이름 배경 퇴장 애니메이션
        ImageView geunjeong_title_bg = (ImageView) findViewById(R.id.geunjeong_title_bg);
        Animation geunjeong_title_bg_out_anim = AnimationUtils.loadAnimation(this, R.anim.building_name_out_anim);
        geunjeong_title_bg.startAnimation(geunjeong_title_bg_out_anim);

        // 전각 이름 퇴장 애니메이션
        TextView geunjeong_title = (TextView) findViewById(R.id.geunjeong_title);
        Animation geunjeong_title_out_anim = AnimationUtils.loadAnimation(this, R.anim.building_name_out_anim);
        geunjeong_title.startAnimation(geunjeong_title_out_anim);

        // 태평이 등장 애니메이션
        geunjeong_taepyeong = (ImageView) findViewById(R.id.geunjeong_taepyeong);
        Animation geunjeong_taepyeong_anim = AnimationUtils.loadAnimation(this, R.anim.character_in_anim);
        geunjeong_taepyeong.startAnimation(geunjeong_taepyeong_anim);

        geunjeong_taesaeng = (ImageView) findViewById(R.id.geunjeong_taesaeng);
        geunjeong_taeyang = (ImageView) findViewById(R.id.geunjeong_taeyang);
        geunjeong_myojong_smile = (ImageView) findViewById(R.id.geunjeong_myojong_smile);
        geunjeong_myojong_smile2 = (ImageView) findViewById(R.id.geunjeong_myojong_smile2);

        // 대화창 애니메이션
        ImageButton geunjeong_dialog = (ImageButton) findViewById(R.id.geunjeong_dialog);
        Animation geunjeong_dialog_anim = AnimationUtils.loadAnimation(this, R.anim.dialog_in_anim);
        geunjeong_dialog.startAnimation(geunjeong_dialog_anim);

        // 이름표 애니메이션
        ImageView geunjeong_nametag = (ImageView) findViewById(R.id.geunjeong_nametag);
        Animation geunjeong_nametag_anim = AnimationUtils.loadAnimation(this, R.anim.dialog_in_anim);
        geunjeong_nametag.startAnimation(geunjeong_nametag_anim);

        // 이름 애니메이션
        geunjeong_taepyeong_name = (TextView) findViewById(R.id.geunjeong_taepyeong_name);
        Animation geunjeong_taepyeong_name_anim = AnimationUtils.loadAnimation(this, R.anim.name_in_anim);
        geunjeong_taepyeong_name.startAnimation(geunjeong_taepyeong_name_anim);

        geunjeong_taesaeng_name = (TextView) findViewById(R.id.geunjeong_taesaeng_name);
        geunjeong_taeyang_name = (TextView) findViewById(R.id.geunjeong_taeyang_name);
        geunjeong_myojong_name = (TextView) findViewById(R.id.geunjeong_myojong_name);

        // 텍스트 애니메이션
        TextView geunjeong_cat1_s1 = (TextView) findViewById(R.id.geunjeong_taepyeong_s1);
        Animation geunjeong_cat1_s1_anim = AnimationUtils.loadAnimation(this, R.anim.dialog_text_in_anim);
        geunjeong_cat1_s1.startAnimation(geunjeong_cat1_s1_anim);

        // 텍스트 전환
        changeView(i);
        geunjeong_dialog.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                changeView(i);
                // 화면 전환
                if(i == 13) {
                    Intent geunjeong_i = new Intent(getApplicationContext(), Ending.class);
                    startActivity(geunjeong_i);
                }
            }
        });
    }

    // 텍스트 전환
    public void changeView(int index){
        TextView tv1 = (TextView) findViewById(R.id.geunjeong_taepyeong_s1);
        TextView tv2 = (TextView) findViewById(R.id.geunjeong_taepyeong_s2);
        TextView tv3 = (TextView) findViewById(R.id.geunjeong_taesaeng_s1);
        TextView tv4 = (TextView) findViewById(R.id.geunjeong_taesaeng_s2);
        TextView tv5 = (TextView) findViewById(R.id.geunjeong_taeyang_s1);
        TextView tv6 = (TextView) findViewById(R.id.geunjeong_taeyang_s2);
        TextView tv7 = (TextView) findViewById(R.id.geunjeong_myojong_s1);
        TextView tv8 = (TextView) findViewById(R.id.geunjeong_myojong_s2);
        TextView tv9 = (TextView) findViewById(R.id.geunjeong_myojong_s3);
        TextView tv10 = (TextView) findViewById(R.id.geunjeong_myojong_s4);

        // 전각 설명 아이콘
        geunjeong_info_icon = (ImageView) findViewById(R.id.geunjeong_info_icon);

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
                geunjeong_taepyeong.setVisibility(View.VISIBLE);
                geunjeong_taesaeng.setVisibility(View.INVISIBLE);
                geunjeong_taeyang.setVisibility(View.INVISIBLE);
                geunjeong_myojong_smile.setVisibility(View.INVISIBLE);
                geunjeong_myojong_smile2.setVisibility(View.INVISIBLE);
                geunjeong_taepyeong_name.setVisibility(View.VISIBLE);
                geunjeong_taesaeng_name.setVisibility(View.INVISIBLE);
                geunjeong_taeyang_name.setVisibility(View.INVISIBLE);
                geunjeong_myojong_name.setVisibility(View.INVISIBLE);
                geunjeong_info_icon.setVisibility(View.INVISIBLE);
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
                geunjeong_taepyeong.setVisibility(View.VISIBLE);
                geunjeong_taesaeng.setVisibility(View.INVISIBLE);
                geunjeong_taeyang.setVisibility(View.INVISIBLE);
                geunjeong_myojong_smile.setVisibility(View.INVISIBLE);
                geunjeong_myojong_smile2.setVisibility(View.INVISIBLE);
                geunjeong_taepyeong_name.setVisibility(View.VISIBLE);
                geunjeong_taesaeng_name.setVisibility(View.INVISIBLE);
                geunjeong_taeyang_name.setVisibility(View.INVISIBLE);
                geunjeong_myojong_name.setVisibility(View.INVISIBLE);
                geunjeong_info_icon.setVisibility(View.INVISIBLE);
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
                geunjeong_taepyeong.setVisibility(View.INVISIBLE);
                geunjeong_taesaeng.setVisibility(View.VISIBLE);
                geunjeong_taeyang.setVisibility(View.INVISIBLE);
                geunjeong_myojong_smile.setVisibility(View.INVISIBLE);
                geunjeong_myojong_smile2.setVisibility(View.INVISIBLE);
                geunjeong_taepyeong_name.setVisibility(View.INVISIBLE);
                geunjeong_taesaeng_name.setVisibility(View.VISIBLE);
                geunjeong_taeyang_name.setVisibility(View.INVISIBLE);
                geunjeong_myojong_name.setVisibility(View.INVISIBLE);
                geunjeong_info_icon.setVisibility(View.INVISIBLE);
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
                geunjeong_taepyeong.setVisibility(View.INVISIBLE);
                geunjeong_taesaeng.setVisibility(View.VISIBLE);
                geunjeong_taeyang.setVisibility(View.INVISIBLE);
                geunjeong_myojong_smile.setVisibility(View.INVISIBLE);
                geunjeong_myojong_smile2.setVisibility(View.INVISIBLE);
                geunjeong_taepyeong_name.setVisibility(View.INVISIBLE);
                geunjeong_taesaeng_name.setVisibility(View.VISIBLE);
                geunjeong_taeyang_name.setVisibility(View.INVISIBLE);
                geunjeong_myojong_name.setVisibility(View.INVISIBLE);
                geunjeong_info_icon.setVisibility(View.INVISIBLE);
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
                geunjeong_taepyeong.setVisibility(View.INVISIBLE);
                geunjeong_taesaeng.setVisibility(View.INVISIBLE);
                geunjeong_taeyang.setVisibility(View.VISIBLE);
                geunjeong_myojong_smile.setVisibility(View.INVISIBLE);
                geunjeong_myojong_smile2.setVisibility(View.INVISIBLE);
                geunjeong_taepyeong_name.setVisibility(View.INVISIBLE);
                geunjeong_taesaeng_name.setVisibility(View.INVISIBLE);
                geunjeong_taeyang_name.setVisibility(View.VISIBLE);
                geunjeong_myojong_name.setVisibility(View.INVISIBLE);
                geunjeong_info_icon.setVisibility(View.INVISIBLE);
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
                geunjeong_taepyeong.setVisibility(View.INVISIBLE);
                geunjeong_taesaeng.setVisibility(View.INVISIBLE);
                geunjeong_taeyang.setVisibility(View.VISIBLE);
                geunjeong_myojong_smile.setVisibility(View.INVISIBLE);
                geunjeong_myojong_smile2.setVisibility(View.INVISIBLE);
                geunjeong_taepyeong_name.setVisibility(View.INVISIBLE);
                geunjeong_taesaeng_name.setVisibility(View.INVISIBLE);
                geunjeong_taeyang_name.setVisibility(View.VISIBLE);
                geunjeong_myojong_name.setVisibility(View.INVISIBLE);
                geunjeong_info_icon.setVisibility(View.INVISIBLE);
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
                geunjeong_taepyeong.setVisibility(View.INVISIBLE);
                geunjeong_taesaeng.setVisibility(View.INVISIBLE);
                geunjeong_taeyang.setVisibility(View.VISIBLE);
                geunjeong_myojong_smile.setVisibility(View.INVISIBLE);
                geunjeong_myojong_smile2.setVisibility(View.INVISIBLE);
                geunjeong_taepyeong_name.setVisibility(View.INVISIBLE);
                geunjeong_taesaeng_name.setVisibility(View.INVISIBLE);
                geunjeong_taeyang_name.setVisibility(View.VISIBLE);
                geunjeong_myojong_name.setVisibility(View.INVISIBLE);
                geunjeong_info_icon.setVisibility(View.INVISIBLE);
                geunjeong_info_icon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        CustomDialog building_info = new CustomDialog(Geunjeong.this);
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
                tv8.setVisibility(View.INVISIBLE);
                tv9.setVisibility(View.INVISIBLE);
                tv10.setVisibility(View.INVISIBLE);
                geunjeong_taepyeong.setVisibility(View.INVISIBLE);
                geunjeong_taesaeng.setVisibility(View.INVISIBLE);
                geunjeong_taeyang.setVisibility(View.INVISIBLE);
                geunjeong_myojong_smile.setVisibility(View.VISIBLE);
                geunjeong_myojong_smile2.setVisibility(View.INVISIBLE);
                geunjeong_taepyeong_name.setVisibility(View.INVISIBLE);
                geunjeong_taesaeng_name.setVisibility(View.INVISIBLE);
                geunjeong_taeyang_name.setVisibility(View.INVISIBLE);
                geunjeong_myojong_name.setVisibility(View.VISIBLE);
                geunjeong_info_icon.setVisibility(View.INVISIBLE);
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
                geunjeong_taepyeong.setVisibility(View.INVISIBLE);
                geunjeong_taesaeng.setVisibility(View.INVISIBLE);
                geunjeong_taeyang.setVisibility(View.INVISIBLE);
                geunjeong_myojong_smile.setVisibility(View.INVISIBLE);
                geunjeong_myojong_smile2.setVisibility(View.VISIBLE);
                geunjeong_taepyeong_name.setVisibility(View.INVISIBLE);
                geunjeong_taesaeng_name.setVisibility(View.INVISIBLE);
                geunjeong_taeyang_name.setVisibility(View.INVISIBLE);
                geunjeong_myojong_name.setVisibility(View.VISIBLE);
                geunjeong_info_icon.setVisibility(View.INVISIBLE);
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
                geunjeong_taepyeong.setVisibility(View.INVISIBLE);
                geunjeong_taesaeng.setVisibility(View.INVISIBLE);
                geunjeong_taeyang.setVisibility(View.INVISIBLE);
                geunjeong_myojong_smile.setVisibility(View.INVISIBLE);
                geunjeong_myojong_smile2.setVisibility(View.VISIBLE);
                geunjeong_taepyeong_name.setVisibility(View.INVISIBLE);
                geunjeong_taesaeng_name.setVisibility(View.INVISIBLE);
                geunjeong_taeyang_name.setVisibility(View.INVISIBLE);
                geunjeong_myojong_name.setVisibility(View.VISIBLE);
                geunjeong_info_icon.setVisibility(View.INVISIBLE);
                i++;



                // 장원 급제 화면



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
                geunjeong_taepyeong.setVisibility(View.INVISIBLE);
                geunjeong_taesaeng.setVisibility(View.INVISIBLE);
                geunjeong_taeyang.setVisibility(View.INVISIBLE);
                geunjeong_myojong_smile.setVisibility(View.VISIBLE);
                geunjeong_myojong_smile2.setVisibility(View.INVISIBLE);
                geunjeong_taepyeong_name.setVisibility(View.INVISIBLE);
                geunjeong_taesaeng_name.setVisibility(View.INVISIBLE);
                geunjeong_taeyang_name.setVisibility(View.INVISIBLE);
                geunjeong_myojong_name.setVisibility(View.VISIBLE);
                geunjeong_info_icon.setVisibility(View.INVISIBLE);
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
                geunjeong_taepyeong.setVisibility(View.INVISIBLE);
                geunjeong_taesaeng.setVisibility(View.INVISIBLE);
                geunjeong_taeyang.setVisibility(View.INVISIBLE);
                geunjeong_myojong_smile.setVisibility(View.INVISIBLE);
                geunjeong_myojong_smile2.setVisibility(View.VISIBLE);
                geunjeong_taepyeong_name.setVisibility(View.INVISIBLE);
                geunjeong_taesaeng_name.setVisibility(View.INVISIBLE);
                geunjeong_taeyang_name.setVisibility(View.INVISIBLE);
                geunjeong_myojong_name.setVisibility(View.VISIBLE);
                geunjeong_info_icon.setVisibility(View.INVISIBLE);
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
                geunjeong_taepyeong.setVisibility(View.INVISIBLE);
                geunjeong_taesaeng.setVisibility(View.INVISIBLE);
                geunjeong_taeyang.setVisibility(View.INVISIBLE);
                geunjeong_myojong_smile.setVisibility(View.INVISIBLE);
                geunjeong_myojong_smile2.setVisibility(View.VISIBLE);
                geunjeong_taepyeong_name.setVisibility(View.INVISIBLE);
                geunjeong_taesaeng_name.setVisibility(View.INVISIBLE);
                geunjeong_taeyang_name.setVisibility(View.INVISIBLE);
                geunjeong_myojong_name.setVisibility(View.VISIBLE);
                geunjeong_info_icon.setVisibility(View.INVISIBLE);
                i++;
                break;
        }
    }

    // 백(취소)키가 눌렸을 때 종료 여부를 묻는 다이얼로그 창
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if((keyCode == KeyEvent.KEYCODE_BACK)) {
            AlertDialog.Builder d = new AlertDialog.Builder(Geunjeong.this);
            d.setMessage("묘한 경복궁을 종료할까요?");

            d.setPositiveButton("예", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Geunjeong.this.finish();
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
