package com.sm.jangwon.myogyeong;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.media.MediaPlayer;
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

public class MainActivity extends AppCompatActivity {

    int result;

    public static final String GAME_PREFERENCES = "GamePrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 화면 가로 고정
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        // 상태바 제거
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        /* // 위치 권한
        // targetSdkVersion 23 이상에서만 작동
        TedPermission.with(this)
                .setPermissionListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted() {
                        Toast.makeText(MainActivity.this, "권한 허가", Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onPermissionDenied(ArrayList<String> deniedPermissions) {
                        Toast.makeText(MainActivity.this, "권한 거부", Toast.LENGTH_SHORT).show();
                    }
                })
                .setRationaleMessage("지도에 현재 위치를 표시하기 위해 위치 권한이 필요합니다.")
                .setPermissions(Manifest.permission.ACCESS_FINE_LOCATION)
                .setPermissions(Manifest.permission.ACCESS_COARSE_LOCATION)
                .check(); */

        // 중간 저장 후 화면 전환
        SharedPreferences prefb = getSharedPreferences(GAME_PREFERENCES, MODE_PRIVATE);
        result = prefb.getInt("goTo", 0);

        // 배경 효과음 위한 사운드풀
        final SoundPool main_bgm = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
        final int meow = main_bgm.load(this, R.raw.meow, 1);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.gunbam);

        // 고양이 쓰다듬기
        final ImageButton pat_cat = (ImageButton) findViewById(R.id.cat1_main);
        pat_cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 노래 멈춤
                mp.release();

                // 고양이 울음소리
                main_bgm.play(meow, 1, 1, 1, 0, 1);

                // 화면 전환
                SharedPreferences prefb = getSharedPreferences(GAME_PREFERENCES, MODE_PRIVATE);
                result = prefb.getInt("goTO", 0);
                changingActivity(result);
            }
        });

        // 타이틀 애니메이션
        ImageView title = (ImageView) findViewById(R.id.title);
        Animation title_anim = AnimationUtils.loadAnimation(this, R.anim.main_title_anim);
        title_anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                // 앱 시작 시 노래 재생
                mp.start();
            }

            @Override
            public void onAnimationEnd(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        title.startAnimation(title_anim);

        // 고양이 애니메이션
        Animation cat_anim = AnimationUtils.loadAnimation(this, R.anim.main_cat_anim);
        cat_anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Animation cat_anim_move = AnimationUtils.loadAnimation(MainActivity.this, R.anim.main_cat_anim_move);
                pat_cat.startAnimation(cat_anim_move);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        pat_cat.startAnimation(cat_anim);

        // 쓰다듬어 주세요 애니메이션
        TextView pat = (TextView) findViewById(R.id.patme);
        Animation pat_anim = AnimationUtils.loadAnimation(this, R.anim.main_pat_anim);
        pat.startAnimation(pat_anim);
    }

    // 화면 전환
    public void changingActivity(int result) {
        switch (result) {
            case 0:
                Intent main_i = new Intent(getApplicationContext(), Intro.class);
                startActivity(main_i);
                this.finish();
                break;
            case 1:
                Intent sajeong_in_i = new Intent(getApplicationContext(), SajeongIn.class);
                startActivity(sajeong_in_i);
                this.finish();
                break;
            case 2:
                Intent sajeong_i = new Intent(getApplicationContext(), Sajeong.class);
                startActivity(sajeong_i);
                this.finish();
                break;
            case 3:
                Intent jaseon_i = new Intent(getApplicationContext(), Jaseon.class);
                startActivity(jaseon_i);
                this.finish();
                break;
            case 4:
                Intent naeso_ju = new Intent(getApplicationContext(), Naesoju.class);
                startActivity(naeso_ju);
                this.finish();
                break;
            case 5:
                Intent gyotae_i = new Intent(getApplicationContext(), Gyotae.class);
                startActivity(gyotae_i);
                this.finish();
                break;
            case 6:
                Intent hyangwon_i = new Intent(getApplicationContext(), Hyangwon.class);
                startActivity(hyangwon_i);
                this.finish();
                break;
            case 7:
                Intent sujeong_i = new Intent(getApplicationContext(), Sujeong.class);
                startActivity(sujeong_i);
                this.finish();
                break;
            case 8:
                Intent geunjeong_i = new Intent(getApplicationContext(), Geunjeong.class);
                startActivity(geunjeong_i);
                this.finish();
                break;
        }
    }

    // 백(취소)키가 눌렸을 때 종료 여부를 묻는 다이얼로그 창
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            AlertDialog.Builder d = new AlertDialog.Builder(MainActivity.this);
            d.setMessage("묘한 경복궁을 종료할까요?");

            d.setPositiveButton("예", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    onStop();
                    ActivityCompat.finishAffinity(MainActivity.this);
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
