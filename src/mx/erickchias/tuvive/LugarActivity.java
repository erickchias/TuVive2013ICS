package mx.erickchias.tuvive;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

public class LugarActivity extends android.support.v4.app.FragmentActivity {

	@SuppressWarnings("static-access")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lugar);
		GoogleMap map = ((SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
		
		LatLng foro = new LatLng(19.4051145,-99.0956126);
		CameraPosition camPos = new CameraPosition.Builder()
		        .target(foro)   
		        .zoom(17)       
		        .bearing(-45)    
		        .build();
		 
		CameraUpdate camUpd3=CameraUpdateFactory.newCameraPosition(camPos);
		 
		map.setMapType(map.MAP_TYPE_HYBRID);
		map.animateCamera(camUpd3);
		
		
		map.addMarker(new MarkerOptions()
        .position(new LatLng(19.404977,-99.09507))
        .title("Escenario Indio")
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.festival)));
		
		map.addMarker(new MarkerOptions()
        .position(new LatLng(19.408134,-99.094899))
        .title("Escenario Unión Indio")
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.festival)));
		
		map.addMarker(new MarkerOptions()
        .position(new LatLng(19.404228108573566,-99.09239888191223))
        .title("Carpa Danup")
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.festival)));
		
		map.addMarker(new MarkerOptions()
        .position(new LatLng(19.404177511474405,-99.09655094146729))
        .title("Carpa Intolerante")
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.festival)));
		
		map.addMarker(new MarkerOptions()
        .position(new LatLng(19.405887684701234,-99.09340739250183))
        .title("Carpa Ambulante")
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.festival)));
		
		map.addMarker(new MarkerOptions()
        .position(new LatLng(19.40547785192711,-99.09267783164978))
        .title("Carpa Cabo San Roque")
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.festival)));
		
		map.addMarker(new MarkerOptions()
        .position(new LatLng(19.405057898754002,-99.09224331378937))
        .title("Carpa Sonidero Doritos")
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.festival)));
		
		map.addMarker(new MarkerOptions()
        .position(new LatLng(19.40376261466774,-99.09507036209106))
        .title("Tianguis del Chopo")
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.market)));
		
		map.addMarker(new MarkerOptions()
        .position(new LatLng(19.40362094234505,-99.09306943416595))
        .title("WC")
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.wc)));
		
		map.addMarker(new MarkerOptions()
        .position(new LatLng(19.404054813443615,-99.09531980752945))
        .title("WC")
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.wc)));
		
		map.addMarker(new MarkerOptions()
        .position(new LatLng(19.404731548852716,-99.09600645303726))
        .title("WC")
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.wc)));
		
		map.addMarker(new MarkerOptions()
        .position(new LatLng(19.404832742690598,-99.0961566567421))
        .title("WC")
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.wc)));
		
		map.addMarker(new MarkerOptions()
        .position(new LatLng(19.405515799449585,-99.09596890211105))
        .title("WC")
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.wc)));
		
		map.addMarker(new MarkerOptions()
        .position(new LatLng(19.40580673016103,-99.09652948379517))
        .title("WC")
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.wc)));

		map.addMarker(new MarkerOptions()
        .position(new LatLng(19.40606477261745,-99.09585356712341))
        .title("WC")
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.wc)));
		
		map.addMarker(new MarkerOptions()
        .position(new LatLng(19.407719270404286,-99.09533858299255))
        .title("WC")
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.wc)));
		
		map.addMarker(new MarkerOptions()
        .position(new LatLng(19.40648472319085,-99.09438908100128))
        .title("WC")
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.wc)));
		
		map.addMarker(new MarkerOptions()
        .position(new LatLng(19.403403373894935,-99.0930962562561))
        .title("Información")
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.information)));
		
		map.addMarker(new MarkerOptions()
        .position(new LatLng(19.405811789820977,-99.09206092357635))
        .title("Información")
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.information)));
		
		map.addMarker(new MarkerOptions()
        .position(new LatLng(19.403909346586175,-99.09282267093658))
        .title("Comida")
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.fastfood)));
		
		map.addMarker(new MarkerOptions()
        .position(new LatLng(19.404612646012747,-99.09283876419067))
        .title("Comida")
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.fastfood)));
		
		map.addMarker(new MarkerOptions()
        .position(new LatLng(19.40547279225678,-99.09217357635498))
        .title("Comida")
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.fastfood)));
		
		map.addMarker(new MarkerOptions()
        .position(new LatLng(19.405981288338122,-99.09359246492386))
        .title("Comida")
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.fastfood)));
		
		map.addMarker(new MarkerOptions()
        .position(new LatLng(19.406140667379674,-99.09505158662796))
        .title("Comida")
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.fastfood)));
		
		map.addMarker(new MarkerOptions()
        .position(new LatLng(19.40761554856048,-99.09458756446838))
        .title("Comida")
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.fastfood)));
		
		map.addMarker(new MarkerOptions()
        .position(new LatLng(19.404625295255187,-99.09686744213104))
        .title("Comida")
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.fastfood)));
		
		map.addMarker(new MarkerOptions()
        .position(new LatLng(19.40355010613743,-99.0939062833786))
        .title("Comida")
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.fastfood)));
		
		map.addMarker(new MarkerOptions()
        .position(new LatLng(19.404167392052702,-99.09287631511688))
        .title("Recolección de vasos")
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.recycle)));
		
		map.addMarker(new MarkerOptions()
        .position(new LatLng(19.404152212918945,-99.09503817558289))
        .title("Recolección de vasos")
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.recycle)));		
		
		map.addMarker(new MarkerOptions()
        .position(new LatLng(19.405214748861177,-99.09665018320084))
        .title("Recolección de vasos")
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.recycle)));	
		
		map.addMarker(new MarkerOptions()
        .position(new LatLng(19.40653531957229,-99.09493625164032))
        .title("Recolección de vasos")
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.recycle)));
		
		map.addMarker(new MarkerOptions()
        .position(new LatLng(19.40387898826908,-99.09488797187805))
        .title("Merch Oficial")
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.kiosk)));
		
		map.addMarker(new MarkerOptions()
        .position(new LatLng(19.406095130526584,-99.0942844748497))
        .title("Merch Oficial")
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.kiosk)));
		
		map.addMarker(new MarkerOptions()
        .position(new LatLng(19.406130548080082,-99.09479141235352))
        .title("Merchandise")
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.kiosk)));
		
		map.addMarker(new MarkerOptions()
        .position(new LatLng(19.40636835145383,-99.09339666366577))
        .title("Feria de disqueras independientes")
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.kiosk)));
		
		map.addMarker(new MarkerOptions()
        .position(new LatLng(19.406373411096297,-99.09382581710815))
        .title("Tatuajes y peluqueria")
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.kiosk)));
		
		map.addMarker(new MarkerOptions()
        .position(new LatLng(19.406117898954726,-99.09463852643967))
        .title("Firma de autografos")
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.kiosk)));
		
		map.addMarker(new MarkerOptions()
        .position(new LatLng(19.405887684701234,-99.09299433231354))
        .title("Cajeros")
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.kiosk)));
		
		map.addMarker(new MarkerOptions()
        .position(new LatLng(19.405093316533357,-99.09673869609833))
        .title("Cajeros")
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.firstaid)));
				
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_lugar, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
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
