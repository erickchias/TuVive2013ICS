package mx.erickchias.tuvive;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class LugarActivity extends android.support.v4.app.FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lugar);
		GoogleMap map = ((SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
		 CameraUpdate camUpd1 =
				    CameraUpdateFactory.newLatLng(new LatLng(40.41, -3.69));
				 
				map.moveCamera(camUpd1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_lugar, menu);
		return true;
	}

}
