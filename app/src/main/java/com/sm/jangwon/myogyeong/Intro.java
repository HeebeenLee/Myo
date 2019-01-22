package com.sm.jangwon.myogyeong;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class Intro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 화면 가로 고정
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        // 상태바 제거
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_intro);

        // 인트로 애니메이션
        TextView intro_txt1 = (TextView) findViewById(R.id.intro_txt1);
        Animation intro_anim1 = AnimationUtils.loadAnimation(this, R.anim.intro_anim);
        intro_txt1.startAnimation(intro_anim1);

        TextView intro_txt2 = (TextView) findViewById(R.id.intro_txt2);
        Animation intro_anim2 = AnimationUtils.loadAnimation(this, R.anim.intro_anim2);
        intro_txt2.startAnimation(intro_anim2);

        // 효과음 위한 사운드풀
        final SoundPool dialog_bgm = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
        final int dialog_sound = dialog_bgm.load(this, R.raw.start, 1);

        // 화면 자동 전환
        Handler myHandler = new Handler();
        myHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intro_i = new Intent(Intro.this, SajeongIn.class);
                startActivity(intro_i);
                Intro.this.finish();
                // 디롱 소리
                dialog_bgm.play(dialog_sound, 1, 1, 1, 0, 1);
            }
        }, 11000);
    }

    // 백(취소)키가 눌렸을 때 종료 여부를 묻는 다이얼로그 창
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if((keyCode == KeyEvent.KEYCODE_BACK)) {
            AlertDialog.Builder d = new AlertDialog.Builder(Intro.this);
            d.setMessage("묘한 경복궁을 종료할까요?");

            d.setPositiveButton("예", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    onStop();
                    ActivityCompat.finishAffinity(Intro.this);
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
