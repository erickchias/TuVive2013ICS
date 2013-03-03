package mx.erickchias.tuvive;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MisBandas extends Activity {
	private DatabaseHandler dbHelper;
	 private SimpleCursorAdapter dataAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mis_bandas);
		
		dbHelper = new DatabaseHandler(this);
		displayListView();
	}
	
	 private void displayListView() {
		  Cursor cursor = dbHelper.getTodasBandas();
		 
		  String[] columns = new String[] {
		    DatabaseHandler.KEY_NAME,
		    DatabaseHandler.KEY_DAY,
		    DatabaseHandler.KEY_SCHEDULE,
		    DatabaseHandler.KEY_PLACE,
		  };
		 
		  int[] to = new int[]{ R.id.bandaN, R.id.diaB, R.id.horaB, R.id.lugarB,};
		 
		  dataAdapter = new SimpleCursorAdapter(this, R.layout.row, cursor, columns, to, 0);
		 
		  ListView listView = (ListView) findViewById(R.id.listView1);
		  listView.setAdapter(dataAdapter);
		 
		 
		  listView.setOnItemClickListener(new OnItemClickListener() {
		   @Override
		   public void onItemClick(AdapterView<?> listView, View view, 
		     int position, long id) {
		 /*  // Get the cursor, positioned to the corresponding row in the result set
		   Cursor cursor = (Cursor) listView.getItemAtPosition(position);
		 
		   // Get the state's capital from this row in the database.
		   String countryCode = 
		    cursor.getString(cursor.getColumnIndexOrThrow("id"));
		   Toast.makeText(getApplicationContext(),
		     countryCode, Toast.LENGTH_SHORT).show();*/
		 
		   }
		  });
	 }

}
