package mx.erickchias.tuvive;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Domingo extends ListFragment {
	MenuItem mItem;
	/*@Override
	public View onCreateView(LayoutInflater li,ViewGroup vg,Bundle bun){
		View view = li.inflate(R.layout.bandas, vg, false);*/
	@Override
	  public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated(savedInstanceState);
        
	    String[] values =getResources().getStringArray(R.array.bandasDomingo);
		 String[] names=new String[values.length];
		 for(int i=0;i<values.length;i++){
			 String txt=values[i].toString();
			 String[]s_values=txt.split("\\|");
			 names[i]=s_values[0].toString();
		 }
			    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
			        android.R.layout.simple_list_item_1	,names);
			    setListAdapter(adapter);
			    
        setHasOptionsMenu(true);
       // return view;
    }

	 public void onListItemClick(ListView l, View v, int position, long id) {
	    // Do something with the data
		 //Log.i("the Item clicked is at position : ",  String.valueOf(position).toString());
		 Intent verBanda = new Intent(getActivity(), DomingoBandaActivity.class );
		 verBanda.putExtra("pos", String.valueOf(position));
		 startActivity(verBanda);

	  }
	
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
      
        mItem =menu.add("Mis bandas");
        // mItem.setIcon(android.R.drawable.ic_menu_compass);
         mItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
         Intent lugar = new Intent(getActivity(), MisBandas.class );
         mItem.setIntent(lugar);
        
        /*mItem =menu.add("Tips");
        //mItem.setIcon(android.R.drawable.ic_menu_view);
        mItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        Intent tips = new Intent(getActivity(), LugarActivity.class );
        mItem.setIntent(tips);*/
        
        
    }
	
}
