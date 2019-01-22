package com.sm.jangwon.myogyeong;

import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class Ending extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 화면 가로 고정
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        // 상태바 제거
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_ending);

        // 크레딧 애니메이션
        LinearLayout ending_credit = (LinearLayout) findViewById(R.id.ending_layout);
        Animation ending_credit_anim = AnimationUtils.loadAnimation(this, R.anim.ending_anim);
        ending_credit.startAnimation(ending_credit_anim);

        // 다음에도 부탁하네 애니메이션
        ConstraintLayout next_time = (ConstraintLayout) findViewById(R.id.ending_layout2);
        Animation next_time_anim = AnimationUtils.loadAnimation(this, R.anim.ending_next_anim);
        next_time.startAnimation(next_time_anim);
    }

    // 백(취소)키가 눌렸을 때 종료 여부를 묻는 다이얼로그 창
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            AlertDialog.Builder d = new AlertDialog.Builder(Ending.this);
            d.setMessage("묘한 경복궁을 종료할까요?");

            d.setPositiveButton("예", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    onStop();
                    ActivityCompat.finishAffinity(Ending.this);
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
