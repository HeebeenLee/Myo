package com.sm.jangwon.myogyeong;

import android.bluetooth.BluetoothAdapter;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.minew.beacon.BeaconValueIndex;
import com.minew.beacon.BluetoothState;
import com.minew.beacon.MinewBeacon;
import com.minew.beacon.MinewBeaconManager;
import com.minew.beacon.MinewBeaconManagerListener;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class BuildingList extends AppCompatActivity {

    private static final int REQUEST_ENABLE_BT = 2;
    int state;
    int i;

    private MinewBeaconManager mMinewBeaconManager;
    private ImageView mStart_scan1;
    private ImageView mStart_scan2;

    Intent goCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 화면 가로 고정
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        // 상태바 제거
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_building_list);

        mStart_scan1 = (ImageView) findViewById(R.id.stamp);
        mStart_scan2 = (ImageView) findViewById(R.id.stamp2);

        initManager();
        checkBluetooth();

        mStart_scan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initListener();
            }
        });
        mStart_scan2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initListener();
            }
        });
        findViewById(R.id.stamp3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initListener();
            }
        });
        findViewById(R.id.stamp4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initListener();
            }
        });
        findViewById(R.id.stamp5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initListener();
            }
        });
        findViewById(R.id.stamp6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initListener();
            }
        });
    }

    public void setDataAndUi(List<MinewBeacon> minewBeacons) {
        mMinewBeaconManager.stopScan();
        i = 0;
        boolean check = true;
        while (check) {
            for (MinewBeacon minewBeacon : minewBeacons) {
                Log.e("리스트출력", minewBeacon.getBeaconValue(BeaconValueIndex.MinewBeaconValueIndex_Name).getStringValue());
                if (minewBeacon.getBeaconValue(BeaconValueIndex.MinewBeaconValueIndex_Name).getStringValue().equals("jaseon16887")) {
                    i = 1;
                    break;
                } else if (minewBeacon.getBeaconValue(BeaconValueIndex.MinewBeaconValueIndex_Name).getStringValue().equals("naesoju16886")) {
                    i = 2;
                    break;
                } else if (minewBeacon.getBeaconValue(BeaconValueIndex.MinewBeaconValueIndex_Name).getStringValue().equals("gyotae16895")) {
                    i = 3;
                    break;
                } else if (minewBeacon.getBeaconValue(BeaconValueIndex.MinewBeaconValueIndex_Name).getStringValue().equals("hyangwon19453")) {
                    i = 4;
                    break;
                } else if (minewBeacon.getBeaconValue(BeaconValueIndex.MinewBeaconValueIndex_Name).getStringValue().equals("sujeong19413")) {
                    i = 5;
                    break;
                } else if (minewBeacon.getBeaconValue(BeaconValueIndex.MinewBeaconValueIndex_Name).getStringValue().equals("geunjeong19406")) {
                    i = 6;
                    break;
                }
            }
            check = false;
        }

        if (i == 0) {
            failingCheck();
        } else {
            goCheck = new Intent(this, Check.class);
            Bitmap sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.check);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            sendBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
            byte[] byteArray = stream.toByteArray();
            goCheck.putExtra("image", byteArray);
            startActivityForResult(goCheck, 1);
        }
    }

    public void failingCheck() {
        Intent failCheck = new Intent(this, Check.class);
        Bitmap fail_sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.check_fail);
        ByteArrayOutputStream fail_stream = new ByteArrayOutputStream();
        fail_sendBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fail_stream);
        byte[] fail_byteArray = fail_stream.toByteArray();
        failCheck.putExtra("image", fail_byteArray);
        startActivityForResult(failCheck, 1);
    }

    public void toNext(int i) {
        switch (i) {
            case 1:
                Intent ja = new Intent(this, Jaseon.class);
                finish();
                startActivity(ja);
                break;
            case 2:
                Intent nae = new Intent(this, Naesoju.class);
                finish();
                startActivity(nae);
                break;
            case 3:
                Intent gyo = new Intent(this, Gyotae.class);
                finish();
                startActivity(gyo);
                break;
            case 4:
                Intent hyang = new Intent(this, Hyangwon.class);
                finish();
                startActivity(hyang);
                break;
            case 5:
                Intent su = new Intent(this, Sujeong.class);
                finish();
                startActivity(su);
                break;
            case 6:
                Intent geun = new Intent(this, Geunjeong.class);
                finish();
                startActivity(geun);
                break;
        }
    }

    private void initManager() {
        mMinewBeaconManager = MinewBeaconManager.getInstance(this);
    }

    private void checkBluetooth() {
        BluetoothState bluetoothState = mMinewBeaconManager.checkBluetoothState();
        switch (bluetoothState) {
            case BluetoothStateNotSupported:
                Toast.makeText(this, "블루투스를 지원하지 않습니다.", Toast.LENGTH_SHORT).show();
                finish();
                break;
            case BluetoothStatePowerOff:
                showBLEDialog();
                break;
            case BluetoothStatePowerOn:
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMinewBeaconManager.stopScan();
    }

    private void initListener() {
        state = 0;
        if (mMinewBeaconManager != null) {
            BluetoothState bluetoothState = mMinewBeaconManager.checkBluetoothState();
            switch (bluetoothState) {
                case BluetoothStateNotSupported:
                    finish();
                    break;
                case BluetoothStatePowerOff:
                    showBLEDialog();
                    return;
                case BluetoothStatePowerOn:
                    break;
            }
        }
        try {
            mMinewBeaconManager.startScan();
        } catch (Exception e) {
            e.printStackTrace();
        }

        mMinewBeaconManager.setDeviceManagerDelegateListener(new MinewBeaconManagerListener() {
            @Override
            public void onAppearBeacons(List<MinewBeacon> minewBeacons) {
                setDataAndUi(minewBeacons);
            }

            @Override
            public void onDisappearBeacons(List<MinewBeacon> minewBeacons) {
                setDataAndUi(minewBeacons);
            }

            @Override
            public void onRangeBeacons(final List<MinewBeacon> minewBeacons) {
                //Collections.sort(minewBeacons, comp);
                Log.e("tag", state + "");
                if (state == 0) {
                }
            }

            @Override
            public void onUpdateState(BluetoothState state) {
                switch (state) {
                    case BluetoothStatePowerOn:
                        Toast.makeText(getApplicationContext(), "BluetoothStatePowerOn", Toast.LENGTH_SHORT).show();
                        break;
                    case BluetoothStatePowerOff:
                        Toast.makeText(getApplicationContext(), "BluetoothStatePowerOff", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    private void showBLEDialog() {
        Intent enableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        startActivityForResult(enableIntent, REQUEST_ENABLE_BT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_ENABLE_BT:
                break;
            case 1:
                toNext(i);
        }
    }

    public void mOnClose(View v) {
        // 데이터 전달하기
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
            AlertDialog.Builder d = new AlertDialog.Builder(BuildingList.this);
            d.setMessage("묘한 경복궁을 종료할까요?");

            d.setPositiveButton("예", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    onStop();
                    ActivityCompat.finishAffinity(BuildingList.this);
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