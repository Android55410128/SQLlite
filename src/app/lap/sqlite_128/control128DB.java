package app.lap.sqlite_128;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class control128DB extends SQLiteOpenHelper {
	private static final String DATABASE_NAME = "mydata128";
	private static final String TABLE_MEMBER = "members";
	private static final int DATABASE_VERSION = 1;

	public control128DB(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE " + TABLE_MEMBER
				+ "(MemberID INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ " Name TEXT(100)," + " Phone INTEGER(100),"
				+ " Age TEXT(100)," + " Birthday TEXT(100),"
				+ " City TEXT(100)," + " Study TEXT(100),"
				+ " Facebook TEXT(100)," + " Email TEXT(100));");

		Log.d("CREATE TABLE", "Create Table Successfully");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTE " + TABLE_MEMBER);
		onCreate(db);

	}

	public long InsertData(String strName, String strTel, String strAge,
			String strBirthday, String strCity, String strStudy,
			String strFacebook, String strEmail) {
		try {
			SQLiteDatabase db;
			db = this.getWritableDatabase();
			ContentValues values = new ContentValues();
			values.put("Nickname", strName);
			values.put("Phone", strTel);
			values.put("Age", strAge);
			values.put("Birthday", strBirthday);
			values.put("City", strCity);
			values.put("Study", strStudy);
			values.put("Facebook", strFacebook);
			values.put("Email", strEmail);

			long l = db.insert(TABLE_MEMBER, null, values);
			db.close();
			return l;

		} catch (Exception e) {
			return -1;

		}
	}

	// Select All Data
	public ArrayList<HashMap<String, String>> selectAllData(){
		try {
			ArrayList<HashMap<String, String>> arrayList  = new ArrayList<HashMap<String,String>>();
			HashMap<String, String> map;
			SQLiteDatabase db;
			db = this.getReadableDatabase();
			
			String strSQL = "SELECT * FROM " + TABLE_MEMBER;
			Cursor cursor = db.rawQuery(strSQL, null);
			if(cursor != null){
				if(cursor.moveToFirst()){
					do{
						map = new HashMap<String, String>();
						map.put("MemberID", cursor.getString(0));
						map.put("Phone", cursor.getString(1));
						map.put("Nickname", cursor.getString(2));
						map.put("Arg", cursor.getString(3));
						map.put("Birthday", cursor.getString(4));
						map.put("City", cursor.getString(5));
						map.put("Study", cursor.getString(6));
						map.put("Facebook", cursor.getString(7));
						map.put("Email", cursor.getString(8));
						arrayList.add(map);
						
					}while(cursor.moveToFirst());
				}
			}
		cursor.close();
		db.close();
		return arrayList;
		
			
		}catch (Exception e){
			
		return null;
		}
		
	}

	

	
}