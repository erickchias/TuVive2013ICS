package mx.erickchias.tuvive;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

public class LugarActivity extends android.support.v4.app.FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lugar);
		GoogleMap map = ((SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
		
		LatLng foro = new LatLng(19.4051145,-99.0956126);
		CameraPosition camPos = new CameraPosition.Builder()
		        .target(foro)   
		        .zoom(15)       
		        .bearing(90)    
		        .tilt(90)
		        .build();
		 
		CameraUpdate camUpd3 =
		    CameraUpdateFactory.newCameraPosition(camPos);
		 
		map.setMapType(map.MAP_TYPE_HYBRID);
		map.animateCamera(camUpd3);
		
		//CameraUpdate camUpd1 =CameraUpdateFactory.newLatLng(new LatLng(37.0625,-95.677068));
		//map.moveCamera(camUpd1);
				
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_lugar, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	        case R.id.menu_about:
	        	Intent acerca = new Intent(this, AcercaActivity.class );
	        	startActivity(acerca);
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}	

}
