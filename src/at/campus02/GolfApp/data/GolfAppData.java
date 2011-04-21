package at.campus02.GolfApp.data;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class GolfAppData extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "golfApp.db";
	private static final int DATABASE_VERSION = 1;

	public GolfAppData(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String createGolfCourse = "CREATE TABLE golfcourse (id INTEGER PRIMARY KEY, name TEXT NOT NULL, desc TEXT)";
		db.execSQL(createGolfCourse);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
	}

	public void insertGolfCourse(int courseId, String name, String description) {
		SQLiteDatabase db = getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put("id", courseId);
		values.put("name", name);
		values.put("desc", description);

		db.insertOrThrow("golfcourse", null, values);
	}

	public Cursor allCourses(Activity activity) {

		String[] columns = { "id", "name", "desc" };

		SQLiteDatabase db = getReadableDatabase();
		Cursor cursor = db.query("golfcourse", columns, null, null, null, null,
				"id");

		return cursor;
	}
}