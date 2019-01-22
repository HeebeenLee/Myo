package com.sm.jangwon.myogyeong;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CustomDialog extends AppCompatActivity {

    int count;

    TextView building_title;
    TextView building_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 화면 가로 고정
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        // 상태바 제거
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.custom_dialog);

        RelativeLayout info_bg = (RelativeLayout) findViewById(R.id.info_bg);
        building_title = (TextView) findViewById(R.id.building_title);
        building_info = (TextView) findViewById(R.id.building_info);
        Intent fromIn = getIntent();
        count = Integer.parseInt(fromIn.getStringExtra("count"));

        // 건물 설명
        switch(count) {
            case 1:
                info_bg.setBackgroundResource(R.drawable.sajeong_in);
                building_title.setText("사정전");
                building_info.setText(getResources().getString(R.string.sajeong_info));
                break;
            case 2:
                info_bg.setBackgroundResource(R.drawable.jaseon);
                building_title.setText("자선당");
                building_info.setText(getResources().getString(R.string.jaseon_info));
                break;
            case 3:
                info_bg.setBackgroundResource(R.drawable.naesoju);
                building_title.setText("내소주방");
                building_info.setText(getResources().getString(R.string.naesoju_info));
                break;
            case 4:
                info_bg.setBackgroundResource(R.drawable.gyotae);
                building_title.setText("교태전");
                building_info.setText(getResources().getString(R.string.gyotae_info));
                break;
            case 5:
                info_bg.setBackgroundResource(R.drawable.hyangwon);
                building_title.setText("향원정");
                building_info.setText(getResources().getString(R.string.hyangwon_info));
                break;
            case 6:
                info_bg.setBackgroundResource(R.drawable.sujeong);
                building_title.setText("수정전");
                building_info.setText(getResources().getString(R.string.sujeong_info));
                break;
            case 7:
                info_bg.setBackgroundResource(R.drawable.geunjeong);
                building_title.setText("근정전");
                building_info.setText(getResources().getString(R.string.geunjeong_info));
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

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // 바깥 레이어 클릭 시 안 닫히게
        if(event.getAction()==MotionEvent.ACTION_OUTSIDE) {
            return false;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        // 안드로이드 백 버튼 막기
        return;
    }

}