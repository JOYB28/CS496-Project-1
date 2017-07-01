package cs496.project1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.provider.Contacts;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by q on 2017-07-01.
 */

public class ContactsDataSource {
    private SQLiteDatabase database;
    private ContactsDatabaseHelper helper;
    private String[] allColumns = {ContactsDatabaseHelper.COLUMN_ID, ContactsDatabaseHelper.COLUMN_NAME,
            ContactsDatabaseHelper.COLUMN_NUMBER};

    public ContactsDataSource(Context context) {
        helper = new ContactsDatabaseHelper(context);
    }

    public void open() throws SQLException {
        database = helper.getWritableDatabase();
    }

    public void close() {
        helper.close();
    }

    public Contact createContact(String name, String number) {
        ContentValues values = new ContentValues();
        values.put(ContactsDatabaseHelper.COLUMN_NAME, name);
        values.put(ContactsDatabaseHelper.COLUMN_NUMBER, number);
        long insertId = database.insert(ContactsDatabaseHelper.TABLE_NAME, null, values);
        Cursor cursor = database.query(ContactsDatabaseHelper.TABLE_NAME, allColumns, ContactsDatabaseHelper.COLUMN_ID + " = "
                + insertId, null, null, null, null);
        cursor.moveToFirst();
        Contact newContact = cursorToContact(cursor);
        cursor.close();
        return newContact;
    }

    public void deleteContact(Contact contact) {
        long id = contact.getId();
        System.out.println("Comment deleted with id: " + id);
        database.delete(ContactsDatabaseHelper.TABLE_NAME, ContactsDatabaseHelper.COLUMN_ID + "="
                + id, null);
    }

    public List<Contact> getAllContacts() {
        List<Contact> contacts = new ArrayList<Contact>();

        Cursor cursor= database.query(ContactsDatabaseHelper.TABLE_NAME, allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Contact contact = cursorToContact(cursor);
            contacts.add(contact);
            cursor.moveToNext();
        }
        cursor.close();
        return contacts;
    }

    private Contact cursorToContact(Cursor cursor) {
        Contact contact = new Contact();
        contact.setId(cursor.getLong(0));
        contact.setName(cursor.getString(1));
        contact.setNumber(cursor.getString(2));
        return contact;
    }
}

