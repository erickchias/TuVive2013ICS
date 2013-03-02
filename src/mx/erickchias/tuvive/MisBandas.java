package mx.erickchias.tuvive;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class MisBandas extends Activity {
	private DatabaseHandler dbHelper;
	 private SimpleCursorAdapter dataAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mis_bandas);
		
		dbHelper = new DatabaseHandler(this);
		//dbHelper.open();
		displayListView();
	}
	
	 private void displayListView() {
		 
		 
		  Cursor cursor = dbHelper.getTodasBandas();
		 
		  // The desired columns to be bound
		  String[] columns = new String[] {
		    DatabaseHandler.KEY_NAME,
		    DatabaseHandler.KEY_DAY,
		    DatabaseHandler.KEY_SCHEDULE,
		    DatabaseHandler.KEY_PLACE,
		    
		  };
		 
		  // the XML defined views which the data will be bound to
		  int[] to = new int[] { 
		    R.id.bandaN,
		    R.id.diaB,
		    R.id.horaB,
		    R.id.lugarB,
		  };
		 
		  // create the adapter using the cursor pointing to the desired data 
		  //as well as the layout information
		  dataAdapter = new SimpleCursorAdapter(
		    this, R.layout.row, 
		    cursor, 
		    columns, 
		    to,
		    0);
		 
		  ListView listView = (ListView) findViewById(R.id.listView1);
		  // Assign adapter to ListView
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
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mis_bandas, menu);
		return true;
	}

}
