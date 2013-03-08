package mx.erickchias.tuvive;

import java.util.Calendar;

import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract.Events;
import android.provider.CalendarContract.Reminders;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.text.format.Time;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DomingoBandaActivity extends Activity {
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
		 

		values=getResources().getStringArray(R.array.bandasDomingo);
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
		inicio.set(2013, 2, 17,Integer.parseInt(array_start[0].toString()),Integer.parseInt(array_start[1].toString()));
		fin.set(2013, 2, 17,Integer.parseInt(array_end[0].toString()),Integer.parseInt(array_end[1].toString()));
	 		 		
		Button bt = (Button)findViewById(R.id.button1);
		bt.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0){
				ContentResolver cr = getContentResolver();
                ContentValues values = new ContentValues();
                values.put(Events.DTSTART,inicio.getTimeInMillis());
                values.put(Events.DTEND, fin.getTimeInMillis());
                values.put(Events.TITLE, name);
                values.put(Events.DESCRIPTION, "Presentación de "+name+" en el festival VL 2013.");
                values.put(Events.CALENDAR_ID, 1);
                values.put(Events.EVENT_TIMEZONE, Time.getCurrentTimezone());
                values.put(Events.EVENT_LOCATION, txt_escenario);  
                values.put(Events.ALL_DAY, false);
                values.put(Events.STATUS, 1);
                values.put(Events.HAS_ALARM, 1);
                Uri uri = cr.insert(Events.CONTENT_URI, values);

                values = new ContentValues();
                values.put("event_id", Long.parseLong(uri.getLastPathSegment()));
                values.put("method", 4);
                values.put("minutes", 15);
                cr.insert(Reminders.CONTENT_URI, values);
                
                Toast.makeText(getApplicationContext(), "Recordatorio agregado correctamente.", Toast.LENGTH_LONG).show();
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
