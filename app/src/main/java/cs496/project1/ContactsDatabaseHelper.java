package cs496.project1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ContactsDatabaseHelper extends SQLiteOpenHelper{
    public static final String TABLE_NAME = "Contacts";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_NUMBER = "Phone Number";

    private static final String DATABASE_NAME = "contacts.db";
    private static final int DATABASE_VERSION = 1;

    //Creating the database of contacts
    private static final String DATABASE_CREATE = "create table " + TABLE_NAME + "( " + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_NAME + " text not null," +
            COLUMN_NUMBER + " text not null);";

    public ContactsDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(ContactsDatabaseHelper.class.getName(), "Upgrading database from version " + oldVersion
                + " to " + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}

