package mx.erickchias.tuvive;

import java.util.Calendar;
import java.util.GregorianCalendar;

import android.os.Bundle;
import android.provider.CalendarContract;
import android.provider.CalendarContract.Events;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ViernesBandaActivity extends Activity {
	private String[] values;
	Bundle bundle;
	Calendar inicio; 
	Calendar fin;
	String txt_escenario;
	String name;
	DatabaseHandler db = new DatabaseHandler(this);
	String diaB;
	String schedule;
	String place;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_banda);
		
		final Button bt2 = (Button)findViewById(R.id.button2);
		 final Button bt3 = (Button)findViewById(R.id.button3); 
		 
		 bt2.setVisibility(View.GONE);
		 bt3.setVisibility(View.GONE);

		inicio = Calendar.getInstance();
		fin = Calendar.getInstance();
		
		bundle=getIntent().getExtras();
		 
		TextView dia = (TextView)findViewById(R.id.dia);
		TextView horario = (TextView)findViewById(R.id.horario);
		TextView escenario = (TextView)findViewById(R.id.escenario);
		 
		TextView ritmo = (TextView)findViewById(R.id.ritmo);
		TextView info = (TextView)findViewById(R.id.info);
		TextView mas = (TextView)findViewById(R.id.mas);
		 

		values=getResources().getStringArray(R.array.bandasViernes);
			 	
			 		String nombreBanda = values[Integer.parseInt(bundle.getString("pos"))];
					String[]s_values=nombreBanda.split("\\|");
					name=s_values[0].toString();
					
					int res = db.getBanda(name);
					 if(res > 0){
						 bt3.setVisibility(View.VISIBLE);
					 }else{
						 bt2.setVisibility(View.VISIBLE);
					 }
					
				
					super.setTitle(name);
			 		dia.setText(s_values[1].toString());
			 		horario.setText(s_values[2].toString()+"-"+s_values[3].toString());
			 		escenario.setText(s_values[4].toString());
			 		ritmo.setText(s_values[5].toString());
			 		info.setText(s_values[6].toString());
			 		mas.setText(s_values[7].toString());
		 		
					txt_escenario="Escenario: "+s_values[4].toString();
					place=s_values[4].toString();
			 		
			 		String start=s_values[2].toString();
	 				String end=s_values[3].toString();
	 				String[] array_start=start.split("\\:");
	 				String[] array_end=end.split("\\:");
	 				 diaB=s_values[1].toString();
	 				 schedule=s_values[2].toString()+"-"+s_values[3].toString();
	 				
	 					inicio.set(2013, 2, 15,Integer.parseInt(array_start[0].toString()),Integer.parseInt(array_start[1].toString()));
		 				fin.set(2013, 2, 15,Integer.parseInt(array_end[0].toString()),Integer.parseInt(array_end[1].toString()));
	 				
			 		
			 		
		 Button bt = (Button)findViewById(R.id.button1);
		 bt.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View arg0){
	            	Intent calIntent = new Intent(Intent.ACTION_INSERT);
	            	calIntent.setType("vnd.android.cursor.item/event");
	            	calIntent.putExtra(Events.TITLE, name);
	            	calIntent.putExtra(Events.EVENT_LOCATION, txt_escenario);
	            	calIntent.putExtra(Events.DESCRIPTION, "Presentación de "+name+" en el festival VL 2013.");
	            	calIntent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, false);
	            	calIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,inicio.getTimeInMillis());
	            	calIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,fin.getTimeInMillis());
	            	calIntent.putExtra(Events.ACCESS_LEVEL, Events.ACCESS_PRIVATE);
	            	calIntent.putExtra(Events.AVAILABILITY, Events.AVAILABILITY_BUSY);
	            	startActivity(calIntent);
	            }
	        });
		 
		 bt2.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View arg0){
	                db.addBanda(new Banda(name, diaB,schedule,place));
	                Toast.makeText(getApplicationContext(), "Banda agregada correctamente.", Toast.LENGTH_LONG).show();
	                bt2.setVisibility(View.GONE);
	                bt3.setVisibility(View.VISIBLE);
	          
	            }
	            
	        });
		 
		 bt3.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View arg0){
	                db.borraBanda(new Banda(name, diaB,schedule,place));
	                Toast.makeText(getApplicationContext(), "Banda borrada correctamente.", Toast.LENGTH_LONG).show();
	                bt3.setVisibility(View.GONE);
	                bt2.setVisibility(View.VISIBLE);
	            }
	            
	        });
		 
		 
		 
		 
	}

	

}
