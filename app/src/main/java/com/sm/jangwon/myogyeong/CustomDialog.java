package com.sm.jangwon.myogyeong;

import android.app.Dialog;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class CustomDialog {

    private Context context;

    public void callFunction() {
        final Dialog dlg = new Dialog(context);

        dlg.setContentView(R.layout.custom_dialog);

        dlg.show();

        final TextView building_info_title = (TextView) dlg.findViewById(R.id.building_info_title);
        final TextView building_info = (TextView) dlg.findViewById(R.id.building_info);
        final Button close_btn = (Button) dlg.findViewById(R.id.close_btn);

        close_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dlg.dismiss();
            }
        });
    }

    public CustomDialog(Context context) {
        this.context = context;
    }

}