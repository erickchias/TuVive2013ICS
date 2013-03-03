package mx.erickchias.tuvive;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Bandas extends ListFragment {
	MenuItem mItem;
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		String[] values =getResources().getStringArray(R.array.bandasTodas);
		String[] names=new String[values.length];
		for(int i=0;i<values.length;i++){
			String txt=values[i].toString();
			String[]s_values=txt.split("\\|");
			names[i]=s_values[0].toString();
		 }
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,names);
		setListAdapter(adapter);
		setHasOptionsMenu(true);
    }

	 public void onListItemClick(ListView l, View v, int position, long id) {
		 Intent verBanda = new Intent(getActivity(), BandaActivity.class );
		 verBanda.putExtra("array", String.valueOf(0));
		 verBanda.putExtra("pos", String.valueOf(position));
		 startActivity(verBanda);
	  }
	
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        mItem = menu.add("Por día");
        mItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        Intent info = new Intent(getActivity(), PorDiaActivity.class );
        mItem.setIntent(info);
        
        mItem =menu.add("Mis bandas");
        mItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        Intent lugar = new Intent(getActivity(), MisBandas.class );
        mItem.setIntent(lugar);
    }
	
}
