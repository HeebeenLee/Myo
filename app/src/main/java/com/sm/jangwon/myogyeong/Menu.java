package com.sm.jangwon.myogyeong;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 화면 가로 고정
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        // 상태바 제거
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_menu);

        ImageButton map_btn = (ImageButton) findViewById(R.id.map_btn);
        //ImageButton order_btn = (ImageButton) findViewById(R.id.order_btn);

        map_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent menu_map_i = new Intent(getApplicationContext(), Map.class);
                startActivity(menu_map_i);
            }
        });
/*
        order_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent menu_list_i = new Intent(getApplicationContext(), List.class);
                startActivity(menu_list_i);
            }
        });*/
    }

}
