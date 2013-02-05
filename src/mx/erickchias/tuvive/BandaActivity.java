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

public class BandaActivity extends Activity {
	private String[] values;
	Bundle bundle;
	Calendar inicio; 
	Calendar fin;
	String escenario;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_banda);
		
		
		
		inicio = Calendar.getInstance();
		fin = Calendar.getInstance();
		
		 bundle=getIntent().getExtras();
		 TextView banda = (TextView)findViewById(R.id.textView2);
		 TextView dia = (TextView)findViewById(R.id.textView1);
		 TextView ritmo = (TextView)findViewById(R.id.textView3);
		 TextView info = (TextView)findViewById(R.id.textView4);
		 TextView mas = (TextView)findViewById(R.id.textView5);
		 
		 
		 escenario="Foro Sol - Rojo";
		 switch(Integer.parseInt(bundle.getString("array"))){
		 case 0: values=getResources().getStringArray(R.array.bandasTodas);
		 		String[] jueves =getResources().getStringArray(R.array.bandasJueves);
		 		String[] viernes =getResources().getStringArray(R.array.bandasViernes);
		 		String[] sabado =getResources().getStringArray(R.array.bandasSabado);
		 		String[] domingo =getResources().getStringArray(R.array.bandasDomingo);
		 		
		 		String nombreBanda = values[Integer.parseInt(bundle.getString("pos"))];
				String[]s_values=nombreBanda.split("\\|");
				String name=s_values[0].toString();
				
		 		super.setTitle(name);
		 		dia.setText(s_values[1].toString());
		 		ritmo.setText(s_values[2].toString());
		 		info.setText(s_values[3].toString());
		 		mas.setText(s_values[4].toString());
		 		
		 		for(int i=0;i<jueves.length;i++){
		 			if(nombreBanda.equals(jueves[i].toString())){
		 				inicio.set(2013, 2, 14,7,30);
		 				fin.set(2013, 2, 14,8,30);
		 			}else{
				 		for(int j=0;j<viernes.length;j++){
				 			if(nombreBanda.equals(viernes[j].toString())){
				 				inicio.set(2013, 2, 15,7,30);
				 				fin.set(2013, 2, 15,8,30);
				 			}else{
				 				for(int k=0;k<sabado.length;k++){
						 			if(nombreBanda.equals(sabado[k].toString())){
						 				inicio.set(2013, 2, 16,7,30);
						 				fin.set(2013, 2, 16,8,30);
						 			}else{
						 				for(int l=0;l<domingo.length;l++){
								 			if(nombreBanda.equals(domingo[l].toString())){
								 				inicio.set(2013, 2, 17,7,30);
								 				fin.set(2013, 2, 17,8,30);
								 			}
								 		}
						 			}
						 		}
				 			}
				 		}
		 			}
		 		}
		 break;
		 case 1: values=getResources().getStringArray(R.array.bandasJueves);
		 inicio.set(2013, 2, 14,7,30);
			fin.set(2013, 2, 14,8,30);
		 		
		 break;
		 case 2: values=getResources().getStringArray(R.array.bandasViernes);
		 inicio.set(2013, 2, 15,7,30);
			fin.set(2013, 2, 15,8,30);
		 break;
		 case 3: values=getResources().getStringArray(R.array.bandasSabado);
		  		nombreBanda = values[Integer.parseInt(bundle.getString("pos"))];
		  		s_values=nombreBanda.split("\\|");
		  		name=s_values[0].toString();
			
	 		super.setTitle(name);
	 		dia.setText(s_values[1].toString());
	 		ritmo.setText(s_values[2].toString());
	 		info.setText(s_values[3].toString());
	 		mas.setText(s_values[4].toString());
		 inicio.set(2013, 2, 16,7,30);
			fin.set(2013, 2, 16,8,30);
		 break;
		 case 4: values=getResources().getStringArray(R.array.bandasDomingo);
		 inicio.set(2013, 2, 17,7,30);
			fin.set(2013, 2, 17,8,30);
		 break;
		 }

		 
		 //banda.setText(values[Integer.parseInt(bundle.getString("pos"))]);
		 Button bt = (Button)findViewById(R.id.button1);
		 bt.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View arg0){
	            	Intent calIntent = new Intent(Intent.ACTION_INSERT);
	            	calIntent.setType("vnd.android.cursor.item/event");
	            	calIntent.putExtra(Events.TITLE, values[Integer.parseInt(bundle.getString("pos"))]);
	            	calIntent.putExtra(Events.EVENT_LOCATION, escenario);
	            	calIntent.putExtra(Events.DESCRIPTION, "");
	            	
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
