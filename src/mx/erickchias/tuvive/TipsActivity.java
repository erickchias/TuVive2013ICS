package mx.erickchias.tuvive;

import android.os.Bundle;
import android.app.Activity;
import android.webkit.WebView;

public class TipsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tips);
		
		 WebView web = (WebView)findViewById(R.id.webView);          
		 web.setBackgroundColor(0xF2F2F2);
	     web.loadData(getString(R.string.tips), "text/html", "utf-8");
	}
}
