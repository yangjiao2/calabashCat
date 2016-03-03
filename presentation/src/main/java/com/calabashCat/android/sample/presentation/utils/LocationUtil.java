package com.calabashCat.android.sample.presentation.utils;


import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

public  class LocationUtil implements GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener, LocationListener {

    private static final String TAG = LocationUtil.class.getSimpleName();

    private static final String LOCATION_PERMISSION ="android.permission.ACCESS_FINE_LOCATION";

    private static final int MY_PERMISSIONS_REQUEST_CODE_ACCESS_FINE_LOCATION = 0;

    private final static int PLAY_SERVICES_RESOLUTION_REQUEST = 1000;

    private static Activity activity;

    private Location mLastLocation;

    // Google client to interact with Google API
    private GoogleApiClient mGoogleApiClient;

    private LocationRequest mLocationRequest;

    // Location updates intervals in sec
    private static int UPDATE_INTERVAL = 10000; // 10 sec
    private static int FATEST_INTERVAL = 5000; // 5 sec
    private static int DISPLACEMENT = 10; // 10 meters

    public static double latitude, longitude;

    // to construct the location Util, must clarify when in which actvity to initial location api.
    public LocationUtil (Activity activity) {
        this.activity = activity;
        if (checkPlayServices()) {
            buildGoogleApiClient();
            connectAPI();
            createLocationRequest();
            getLastLocation();
        }
    }

    public double getAltitude (){
        this.latitude = 37.422006;// hard code for test

        return latitude;
    }

    public double getLongitude (){
        this.longitude = -122.084095; // hard code for test
        return longitude;
    }

    private boolean checkPlayServices() {

        int resultCode= GoogleApiAvailability
                .getInstance()
                .isGooglePlayServicesAvailable(activity);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (GoogleApiAvailability.getInstance().isUserResolvableError(resultCode)) {
                GoogleApiAvailability.getInstance().getErrorDialog(activity, resultCode,
                        PLAY_SERVICES_RESOLUTION_REQUEST).show();
            } else {
                Toast.makeText(activity,
                        "This device is not supported.", Toast.LENGTH_LONG)
                        .show();
            }
            return false;
        }
        return true;
    }

    /**
     * Creating google api client object
     * */

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(activity)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API).build();

    }

    private void connectAPI (){
        if (mGoogleApiClient != null) {
            mGoogleApiClient.connect();
        }
    }

    protected void createLocationRequest() {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(UPDATE_INTERVAL);
        mLocationRequest.setFastestInterval(FATEST_INTERVAL);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mLocationRequest.setSmallestDisplacement(DISPLACEMENT);

        Log.i("System.out","createLocationRequest="+Boolean.toString(mLocationRequest != null));
    }

    private void getLastLocation(){

        if(checkLocationPermission()){
            Log.i("System.out","checkLocationPermission= "+Boolean.toString(checkLocationPermission()));
            mLastLocation = LocationServices.FusedLocationApi
                    .getLastLocation(mGoogleApiClient);
        }
        Log.i("System.out","mLastLocation= "+Boolean.toString(mLastLocation !=null));

        if(mLastLocation!= null){
            this.latitude = mLastLocation.getLatitude();
            this.longitude = mLastLocation.getLongitude();
        }
    }



@TargetApi(23)
    private boolean checkLocationPermission(){

        if(activity.checkSelfPermission(LOCATION_PERMISSION) != PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(activity,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    MY_PERMISSIONS_REQUEST_CODE_ACCESS_FINE_LOCATION);

            return activity.checkSelfPermission(LOCATION_PERMISSION) == PackageManager.PERMISSION_GRANTED;

        }else{

            Log.i("permission ", "already granted!");
            return true;
        }

    }

    @TargetApi(23)
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[],
                                           int[] grantResults) {

        if (requestCode == MY_PERMISSIONS_REQUEST_CODE_ACCESS_FINE_LOCATION) {
            if (grantResults.length > 0 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                 Log.i("Permission result"," ACCESS_FINE_LOCATION granted");
                return;
            } else {
                Log.i("Permission result", " ACCESS_FINE_LOCATION not granted!!");
            }
        } else {
            activity.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    public void onLocationChanged(Location location) {
        // Assign the new location
        mLastLocation = location;

        Toast.makeText(activity, "Location changed!",
                Toast.LENGTH_SHORT).show();

        // Displaying the new location on UI
        getLastLocation();
    }


    @Override
    public void onConnected(Bundle bundle) {
        // Once connected with google api, get the location
        getLastLocation();

        startLocationUpdates();
    }

    @Override
    public void onConnectionSuspended(int arg0) {
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnectionFailed(ConnectionResult result) {
        Log.i(TAG, "Connection failed: ConnectionResult.getErrorCode() = "
                + result.getErrorCode());
    }

    /**
     * Starting the location updates
     * */
    protected void startLocationUpdates() {
        if(checkLocationPermission())
            LocationServices.FusedLocationApi.requestLocationUpdates(
                    mGoogleApiClient, mLocationRequest, this);

    }

}
