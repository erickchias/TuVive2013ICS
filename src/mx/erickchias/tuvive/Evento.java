package mx.erickchias.tuvive;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class Evento extends Fragment {
	MenuItem mItem;
	@Override
	public View onCreateView(LayoutInflater li,ViewGroup vg,Bundle bun){
		View view = li.inflate(R.layout.info_evento, vg, false);
        
        setHasOptionsMenu(true);
        return view;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        mItem = menu.add("Boletos");
       // mItem.setIcon(android.R.drawable.ic_menu_info_details);
        mItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        Intent info = new Intent(getActivity(), InfoActivity.class );
        mItem.setIntent(info);
        
        mItem =menu.add("Lugar");
       // mItem.setIcon(android.R.drawable.ic_menu_compass);
        mItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        Intent lugar = new Intent(getActivity(), LugarActivity.class );
        mItem.setIntent(lugar);
        
        mItem =menu.add("Tips");
        //mItem.setIcon(android.R.drawable.ic_menu_view);
        mItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        Intent tips = new Intent(getActivity(), LugarActivity.class );
        mItem.setIntent(tips);
        
        
    }
	
}
