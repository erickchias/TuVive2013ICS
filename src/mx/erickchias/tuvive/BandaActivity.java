package mx.erickchias.tuvive;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class BandaActivity extends Activity {
	private String[] values;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_banda);
		
		 Bundle bundle=getIntent().getExtras();
		 TextView banda = (TextView)findViewById(R.id.nombreBanda);
		 
		 switch(Integer.parseInt(bundle.getString("array"))){
		 case 0: values=getResources().getStringArray(R.array.bandasTodas);
		 break;
		 case 1: values=getResources().getStringArray(R.array.bandasJueves);
		 break;
		 case 2: values=getResources().getStringArray(R.array.bandasViernes);
		 break;
		 case 3: values=getResources().getStringArray(R.array.bandasSabado);
		 break;
		 case 4: values=getResources().getStringArray(R.array.bandasDomingo);
		 break;
		 }

		 
		 banda.setText(values[Integer.parseInt(bundle.getString("pos"))]);
		 
		 
		 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_banda, menu);
		return true;
	}

}
