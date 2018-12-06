package com.sm.jangwon.myogyeong;

import android.Manifest;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

public class Map extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback, MapView.CurrentLocationEventListener {

    private final int MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 101;
    private MapView mapView;

    Button my_location_btn;

    double lat = 37.578305;
    double lon = 126.977358;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 화면 가로 고정
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        // 상태바 제거
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_map);

        coveringMap();
    }

    public void coveringMap() {
        mapView = new MapView(this);
        mapView.setDaumMapApiKey("9a364676ed791a769bb00c9a40c1f9df");
        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view);
        mapViewContainer.addView(mapView);

        my_location_btn = (Button) findViewById(R.id.my_location_btn);

        MapPoint mapPoint = MapPoint.mapPointWithGeoCoord(lat, lon);
        mapView.setMapCenterPoint(mapPoint, true);

        my_location_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // 상태 받아오기
                if (!checkBefore()) {
                    checkPer();
                } else {
                    findinglocation();
                }
            }
        });
    }

    public boolean checkBefore() {
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION);
        int permissionCheck2 = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);

        return permissionCheck==PackageManager.PERMISSION_GRANTED && permissionCheck2==PackageManager.PERMISSION_GRANTED;
    }

    public void checkPer() {
        /* if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                || ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) { // 거부한 적 있을 때 */
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},101);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},101);
        /* } else { // 거부한 적 없을 때
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},101);
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},101);
        } */
    }

    public void findinglocation() {
        mapView.setCurrentLocationTrackingMode(MapView.CurrentLocationTrackingMode.TrackingModeOnWithHeading);
        mapView.setCurrentLocationEventListener(this);

        MapPOIItem.ImageOffset offImageAnchorPointOffset = new MapPOIItem.ImageOffset(15, 15);

        mapView.setCustomCurrentLocationMarkerImage(R.drawable.map_pin, offImageAnchorPointOffset);
        mapView.setShowCurrentLocationMarker(true);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                findinglocation();
            } else {
                onDestroy();
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

}
