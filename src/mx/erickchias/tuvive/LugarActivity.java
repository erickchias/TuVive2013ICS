package mx.erickchias.tuvive;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class LugarActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lugar);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_lugar, menu);
		return true;
	}

}
