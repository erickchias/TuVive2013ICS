package mx.erickchias.tuvive;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
 
public class DatabaseHandler extends SQLiteOpenHelper {
	 
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "bandas";
    private static final String TABLE_BANDS = "mis_bandas";
    static final String KEY_ID = "_id";
    static final String KEY_NAME = "name";
    static final String KEY_DAY = "day";
    static final String KEY_SCHEDULE = "schedule";
    static final String KEY_PLACE = "place";
 
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
 
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_BANDS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_DAY + " TEXT," + KEY_SCHEDULE + " TEXT," + KEY_PLACE + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }
 
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BANDS);
        onCreate(db);
    }
    
    void addBanda(Banda banda) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, banda.getName()); 
        values.put(KEY_DAY, banda.getDay());
        values.put(KEY_SCHEDULE, banda.getSchedule());
        values.put(KEY_PLACE, banda.getPlace()); 
        db.insert(TABLE_BANDS, null, values);
        db.close();
    }
 
    Banda getBanda(int id) {
    	SQLiteDatabase db = this.getReadableDatabase();
    	
        Cursor cursor = db.query(TABLE_BANDS, new String[] { KEY_ID,
                KEY_NAME, KEY_DAY, KEY_PLACE }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
 
        Banda banda = new Banda(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2),cursor.getString(3));
        return banda;
    }
    
    @SuppressWarnings("null")
	int getBanda(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_BANDS +" WHERE " + KEY_NAME +" = '" + name + "'";
        Cursor cursor = db.rawQuery(selectQuery, null);
       
        if(cursor != null){
         	return cursor.getCount();
        }else{
        	return cursor.getCount();
        }
    }
    
    public List<Banda> getAllBandas() {
        List<Banda> bandaList = new ArrayList<Banda>();
        String selectQuery = "SELECT  * FROM " + TABLE_BANDS;
 
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
 
        if (cursor.moveToFirst()) {
            do {
                Banda banda = new Banda();
                banda.setID(Integer.parseInt(cursor.getString(0)));
                banda.setName(cursor.getString(1));
                banda.setDay(cursor.getString(2));
                banda.setSchedule(cursor.getString(3));
                bandaList.add(banda);
            } while (cursor.moveToNext());
        }
 
        return bandaList;
    }
    
    public Cursor getTodasBandas() {
    	String selectQuery = "SELECT  * FROM " + TABLE_BANDS +" ORDER BY CASE "+ KEY_DAY +" WHEN 'Jueves' THEN 0 WHEN 'Viernes' THEN 1 WHEN 'Sábado' THEN 2 WHEN 'Domingo' THEN 3 END";
    	
    	
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
 
        if (cursor != null) {
        	   cursor.moveToFirst();
        	  }
        	  return cursor;
 
    }
    
    public int updateBanda(Banda banda) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, banda.getName());
        values.put(KEY_DAY, banda.getDay());
        values.put(KEY_SCHEDULE, banda.getSchedule());
        values.put(KEY_PLACE, banda.getPlace());
 
        return db.update(TABLE_BANDS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(banda.getID()) });
    }
 
    public void deleteBanda(Banda banda) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_BANDS, KEY_ID + " = ?",
                new String[] { String.valueOf(banda.getID()) });
        db.close();
    }
    
    public void borraBanda(Banda banda) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_BANDS, KEY_NAME + " = ?",
                new String[] { String.valueOf(banda.getName()) });
        db.close();
    }
 
    public int getBandasCount() {
        String countQuery = "SELECT  * FROM " + TABLE_BANDS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
 
        return cursor.getCount();
    }
    
}
