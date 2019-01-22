package com.sm.jangwon.myogyeong;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class FindCat extends AppCompatActivity {

    int where;

    TextView cat_msg;
    ImageView find_cat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 화면 가로 고정
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        // 상태바 제거
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_find_cat);

        // 효과음 위한 미디어플레이어
        final MediaPlayer yay = MediaPlayer.create(this, R.raw.yay);

        // 고양이 애니메이션
        find_cat = (ImageView) findViewById(R.id.which_cat);
        Animation find_cat_anim = AnimationUtils.loadAnimation(this, R.anim.find_cat_anim);
        find_cat_anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                // 효과음 재생
                yay.start();
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Animation find_cat_anim_move = AnimationUtils.loadAnimation(FindCat.this, R.anim.find_cat_move_anim);
                find_cat.startAnimation(find_cat_anim_move);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        find_cat.startAnimation(find_cat_anim);

        // 발견 글씨 애니메이션
        cat_msg = (TextView) findViewById(R.id.cat_msg);
        Animation cat_msg_anim = AnimationUtils.loadAnimation(this, R.anim.find_cat_txt_anim);
        cat_msg.startAnimation(cat_msg_anim);

        // 고양이 바꾸기
        Intent fromIn = getIntent();
        where = Integer.parseInt(fromIn.getStringExtra("where"));

        switch(where) {
            // 자선당
            case 1:
                find_cat.setImageResource(R.drawable.cat1);
                cat_msg.setText("태평이 발견!");
                break;
            // 교태전
            case 2:
                find_cat.setImageResource(R.drawable.cat2);
                cat_msg.setText("태생이 발견!");
                break;
            // 향원정
            case 3:
                find_cat.setImageResource(R.drawable.cat3);
                cat_msg.setText("태양이 발견!");
                break;
        }
    }

    public void mOnClose(View v) {
        // 데이터 전달
        Intent intent = new Intent();
        intent.putExtra("result", "Close Popup");
        setResult(RESULT_OK, intent);

        // 액티비티(팝업) 닫기
        this.finish();
        overridePendingTransition(0, 0);
    }

    // 백(취소)키가 눌렸을 때 종료 여부를 묻는 다이얼로그 창
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if((keyCode == KeyEvent.KEYCODE_BACK)) {
            AlertDialog.Builder d = new AlertDialog.Builder(FindCat.this);
            d.setMessage("묘한 경복궁을 종료할까요?");

            d.setPositiveButton("예", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    onStop();
                    ActivityCompat.finishAffinity(FindCat.this);
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