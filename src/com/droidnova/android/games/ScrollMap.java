/**************************************************************************************
 * 
 * Copyright (C) 2015 Minikutty Joseph
 * 
 * [This program is licensed under the "MIT License"]
 * For license information, please refer the following link. Link is
 * https://github.com/Minikutty/Scrollmap/blob/master/License.md
 *
 *  **************************************************************************************/


package com.droidnova.android.games;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.Toast;


public class ScrollMap extends Activity {
    private static final String LOG_TAG = ScrollMap.class.getSimpleName();
    private CellMap _map;
    public static double latitude;
    public static double longitude;
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); // to hide the title
        _map = new CellMap(this);
        setContentView(_map); // on starting the app, loading cellmap as the context
        Log.d(LOG_TAG, "View added"); // log the debug informations
        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        LocationListener locationListner = new MyGPS();
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListner);
    }
    
    class MyGPS implements LocationListener {
    	
    	public void onLocationChanged(Location location) {
            // TODO Auto-generated method stub
            ScrollMap.latitude = location.getLatitude();
            ScrollMap.longitude = location.getLongitude();
            
            Toast.makeText(ScrollMap.this,
                    location.getLatitude() + " " + location.getLongitude(),
                    Toast.LENGTH_LONG).show();  // to show a message (latitude and logitude) on the bottom of the screen

        }

		public void onProviderDisabled(String provider) {
			// TODO Auto-generated method stub
			
		}

		public void onProviderEnabled(String provider) {
			// TODO Auto-generated method stub
			
		}

		public void onStatusChanged(String provider, int status, Bundle extras) {
			// TODO Auto-generated method stub
			
		}
    } 
}