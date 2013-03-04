package mx.erickchias.tuvive;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
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
		   public void onItemClick(AdapterView<?> listView, View view, int position, long id) {
			   Cursor cursor = (Cursor) listView.getItemAtPosition(position);
			   final String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
			   
			   AlertDialog.Builder myAlertDialog = new AlertDialog.Builder(MisBandas.this);
			   myAlertDialog.setTitle("Eliminar banda");
			   myAlertDialog.setMessage("¿Deseas borrar a '"+name+"' de Mis Bandas?");
			   myAlertDialog.setPositiveButton("Si", new DialogInterface.OnClickListener() {
				   public void onClick(DialogInterface arg0, int arg1) {
					   dbHelper.borraBanda(name);
					   displayListView();
					   Toast.makeText(getApplicationContext(), "Banda borrada correctamente.", Toast.LENGTH_LONG).show();
				   }
			   });
			   myAlertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
				   public void onClick(DialogInterface arg0, int arg1) {
				   }
			   });
			   myAlertDialog.show();
			   
			   
		   }
		  });
	 }

}
