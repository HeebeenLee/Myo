package com.sm.jangwon.myogyeong;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

public class Map extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback, MapView.CurrentLocationEventListener {

    private final int MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 101;

    double lat = 37.578305;
    double lon = 126.977358;

    private MapView mapView;
    Button my_location_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 화면 가로 고정
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        // 상태바 제거
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_map);

        // 권한 대신 토스트 메시지
        Toast.makeText(Map.this, "지도에 현재 위치를 표시하기 위해 GPS를 켜 주세요.", Toast.LENGTH_SHORT).show();

        coveringMap();
    }

    public void coveringMap() {
        mapView = new MapView(this);
        mapView.setDaumMapApiKey("9a364676ed791a769bb00c9a40c1f9df");
        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view);
        mapViewContainer.addView(mapView);

        // 초기 위치를 경복궁으로 지정
        MapPoint mapPoint = MapPoint.mapPointWithGeoCoord(lat, lon);
        mapView.setMapCenterPoint(mapPoint, true);

        // 현재 위치 버튼
        my_location_btn = (Button) findViewById(R.id.my_location_btn);
        my_location_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // 위치 권한 없음
                if (!checkBefore()) {
                    checkPer();
                }
                // 위치 권한 있음
                else {
                    findinglocation();
                }
            }
        });
    }

    public boolean checkBefore() {
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION);
        int permissionCheck2 = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);

        return permissionCheck == PackageManager.PERMISSION_GRANTED && permissionCheck2 == PackageManager.PERMISSION_GRANTED;
    }

    public void checkPer() {
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},101);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},101);
    }

    public void findinglocation() {
        mapView.setCurrentLocationTrackingMode(MapView.CurrentLocationTrackingMode.TrackingModeOnWithHeading);
        mapView.setCurrentLocationEventListener(this);

        // 마커
        MapPOIItem.ImageOffset trackingImageAnchorPointOffset = new MapPOIItem.ImageOffset(28, 28); // 좌하단(0,0) 기준 앵커포인트 오프셋
        mapView.setCustomCurrentLocationMarkerTrackingImage(R.drawable.map_pin, trackingImageAnchorPointOffset);
        mapView.setShowCurrentLocationMarker(true);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                findinglocation();
            } else {
            }
            return;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mapView.setCurrentLocationTrackingMode(MapView.CurrentLocationTrackingMode.TrackingModeOff);
        mapView.setShowCurrentLocationMarker(false);
    }

    @Override
    public void onCurrentLocationUpdate(MapView mapView, MapPoint mapPoint, float v) {
    }

    @Override
    public void onCurrentLocationDeviceHeadingUpdate(MapView mapView, float v) {
    }

    @Override
    public void onCurrentLocationUpdateFailed(MapView mapView) {
    }

    @Override
    public void onCurrentLocationUpdateCancelled(MapView mapView) {
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
            AlertDialog.Builder d = new AlertDialog.Builder(Map.this);
            d.setMessage("묘한 경복궁을 종료할까요?");

            d.setPositiveButton("예", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    onStop();
                    ActivityCompat.finishAffinity(Map.this);
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
