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
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class JuevesBandaActivity extends Activity {
	private String[] values;
	Bundle bundle;
	Calendar inicio; 
	Calendar fin;
	String txt_escenario;
	String name;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_banda);

		inicio = Calendar.getInstance();
		fin = Calendar.getInstance();
		
		bundle=getIntent().getExtras();
		 
		TextView dia = (TextView)findViewById(R.id.dia);
		TextView horario = (TextView)findViewById(R.id.horario);
		TextView escenario = (TextView)findViewById(R.id.escenario);
		 
		TextView ritmo = (TextView)findViewById(R.id.ritmo);
		TextView info = (TextView)findViewById(R.id.info);
		TextView mas = (TextView)findViewById(R.id.mas);
		 

		values=getResources().getStringArray(R.array.bandasJueves);
			 		String nombreBanda = values[Integer.parseInt(bundle.getString("pos"))];
					String[]s_values=nombreBanda.split("\\|");
					name=s_values[0].toString();
				
					super.setTitle(name);
			 		dia.setText(s_values[1].toString());
			 		horario.setText(s_values[2].toString()+"-"+s_values[3].toString());
			 		escenario.setText(s_values[4].toString());
			 		ritmo.setText(s_values[5].toString());
			 		info.setText(s_values[6].toString());
			 		mas.setText(s_values[7].toString());
		 		
					txt_escenario="Escenario: "+s_values[4].toString();
			 		
			 		String start=s_values[2].toString();
	 				String end=s_values[3].toString();
	 				String[] array_start=start.split("\\:");
	 				String[] array_end=end.split("\\:");
	 				
	 				
	 					inicio.set(2013, 2, 14,Integer.parseInt(array_start[0].toString()),Integer.parseInt(array_start[1].toString()));
		 				fin.set(2013, 2, 14,Integer.parseInt(array_end[0].toString()),Integer.parseInt(array_end[1].toString()));	
			 		
			 		
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
		 
		 
		 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_banda, menu);
		return true;
	}

}
