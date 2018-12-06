package com.sm.jangwon.myogyeong;

import android.app.Dialog;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class BuildingInfo extends Dialog {
    //Button close_btn;
    private String title;
    private String contents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_building_info);


        //

        setContentView(R.layout.activity_building_info);

        TextView sajeong_in_building_info_title = (TextView) findViewById(R.id.sajeong_in_building_info_title);
        TextView sajeong_in_building_info = (TextView) findViewById(R.id.sajeong_in_building_info);
        Button close_btn = (Button) findViewById(R.id.close_btn);

        sajeong_in_building_info_title.setText(title);
        sajeong_in_building_info.setText(contents);
    }

    public BuildingInfo(Context context, String title, String content, View.OnClickListener singleListener) {
        super(context, android.R.style.Theme_Translucent_NoTitleBar);
        this.title = title;
        this.contents = content;
        //this.mLeftClickListener = singleListener;
    }


/*
    public BuildingInfo(View.OnClickListener context) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_building_info);
        close_btn = (Button) findViewById(R.id.close_btn);
        close_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }

}*/
}