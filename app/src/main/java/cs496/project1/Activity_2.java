package cs496.project1;

import android.Manifest;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Activity_2 extends AppCompatActivity {
    // Request code for READ_CONTACTS. It can be any number > 0.
    private static final int PERMISSIONS_REQUEST_READ_CONTACTS = 1;
    private static final int PERMISSIONS_REQUEST_CALL_PHONE = 2;
    private static final int EDIT_CONTACT_REQUEST = 3;
    String lastsharedsound;

    static final String[] LIST_MENU = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N"};
    //static final City[] cities = {};

    //references to our images
    /*private Integer[]   mThumbIds = {R.drawable.amsterdam, R.drawable.beijing, R.drawable.istanbul, R.drawable.london
            ,R.drawable.newyork, R.drawable.paris, R.drawable.praha, R.drawable.seoul, R.drawable.rome, R.drawable.tokyo};
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        /*Button button1 = (Button) findViewById(R.id.button);

        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(Activity_2.this, MainActivity.class);
                startActivity(intent);
            }
        });*/

//////
        /*
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, LIST_MENU);

        ListView listview = (ListView) findViewById(R.id.listview1);
        listview.setAdapter(adapter);
        */

/////
        //contacts
        showContacts();

        //gridView  해보기
        //setContentView(R.layout.layout_tab_1);

/*
        GridView gridView;
        CityAdapter citiesAdapter;

        citiesAdapter = new CityAdapter();     // this.cities

        gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(citiesAdapter);


        citiesAdapter.addItem(ContextCompat.getDrawable(this, R.drawable.amsterdam), "AMSTERDAM");
        citiesAdapter.addItem(ContextCompat.getDrawable(this, R.drawable.beijing), "BEIJING");
        citiesAdapter.addItem(ContextCompat.getDrawable(this, R.drawable.istanbul), "ISTANBUL");
        citiesAdapter.addItem(ContextCompat.getDrawable(this, R.drawable.london), "LONDON");
        citiesAdapter.addItem(ContextCompat.getDrawable(this, R.drawable.newyork), "NEW YORK");
        citiesAdapter.addItem(ContextCompat.getDrawable(this, R.drawable.paris), "PARIS");
        citiesAdapter.addItem(ContextCompat.getDrawable(this, R.drawable.praha), "PRAHA");
        citiesAdapter.addItem(ContextCompat.getDrawable(this, R.drawable.rome), "ROME");
        citiesAdapter.addItem(ContextCompat.getDrawable(this, R.drawable.seoul), "SEOUL");
        citiesAdapter.addItem(ContextCompat.getDrawable(this, R.drawable.tokyo), "TOKYO");
*/

        //tab 구현
        TabHost tabHost1 = (TabHost) findViewById(R.id.tabHost1);
        tabHost1.setup();


        TabHost.TabSpec ts1 = tabHost1.newTabSpec("Tab Spec 1");
        ts1.setContent(R.id.content1);
        ts1.setIndicator("TAB1");
        tabHost1.addTab(ts1);


        TabHost.TabSpec ts2 = tabHost1.newTabSpec("Tab Spec 2");
        ts2.setContent(R.id.content2);
        ts2.setIndicator("TAB2");

        tabHost1.addTab(ts2);


        TabHost.TabSpec ts3 = tabHost1.newTabSpec("Tab Spec 3");
        ts3.setContent(R.id.content3);
        ts3.setIndicator("TAB3");
        tabHost1.addTab(ts3);

        //버튼
        ImageButton button4 = (ImageButton) findViewById(R.id.button);

        button4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(Activity_2.this, MainGallaryActivity.class);
                startActivity(intent);
            }
        });

        //tab3 시작화면
        ImageButton button5 = (ImageButton) findViewById(R.id.button2);

        button5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(Activity_2.this, MainGameActivity.class);
                startActivity(intent);
            }
        });


    }
    private void showContacts() {
        // Check the SDK version and whether the permission is already granted or not.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.READ_CONTACTS}, PERMISSIONS_REQUEST_READ_CONTACTS);
            //After this point you wait for callback in onRequestPermissionsResult(int, String[], int[]) overriden method
        } else {
            // Android version is lesser than 6.0 or the permission is already granted.
            ListView listview2;
            listview2 = (ListView) findViewById(R.id.listview2);
            ListViewAdapter adapter2 = new ListViewAdapter();
            listview2.setAdapter(adapter2);

            //ArrayList<String> contactList = new ArrayList<String>();
            String phoneNumber;
            String email = "Email: N/A";
            final Uri CONTENT_URI = ContactsContract.Contacts.CONTENT_URI;
            String _ID = ContactsContract.Contacts._ID;
            final String DISPLAY_NAME = ContactsContract.Contacts.DISPLAY_NAME;
            String HAS_PHONE_NUMBER = ContactsContract.Contacts.HAS_PHONE_NUMBER;
            Uri PhoneCONTENT_URI = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
            String Phone_CONTACT_ID = ContactsContract.CommonDataKinds.Phone.CONTACT_ID;
            String NUMBER = ContactsContract.CommonDataKinds.Phone.NUMBER;
            Uri EmailCONTENT_URI = ContactsContract.CommonDataKinds.Email.CONTENT_URI;
            String EmailCONTACT_ID = ContactsContract.CommonDataKinds.Email.CONTACT_ID;
            String DATA = ContactsContract.CommonDataKinds.Email.DATA;
            String TYPE = ContactsContract.CommonDataKinds.Phone.TYPE;
            //StringBuffer output;

            ContentResolver contentResolver = getContentResolver();
            String sortOrder = DISPLAY_NAME + " COLLATE LOCALIZED ASC";
            Cursor cursor = contentResolver.query(CONTENT_URI, null, null, null, sortOrder);
            // Iterate every contact in the phone
            if (cursor.getCount() > 0) {
                while (cursor.moveToNext()) {
                    String contact_id = cursor.getString(cursor.getColumnIndex(_ID));
                    String address = "Address: N/A";
                    String name = cursor.getString(cursor.getColumnIndex(DISPLAY_NAME));
                    int hasPhoneNumber = Integer.parseInt(cursor.getString(cursor.getColumnIndex(HAS_PHONE_NUMBER)));
                    if (hasPhoneNumber > 0) {
                        //output.append("\n First Name:" + name);
                        ArrayList<String> numbers = new ArrayList<>();
                        List<Integer> types = new ArrayList<>();
                        ArrayList<String> stringtypes = new ArrayList<>();
                        //This is to read multiple phone numbers associated with the same contact
                        Cursor phoneCursor = contentResolver.query(PhoneCONTENT_URI, null, Phone_CONTACT_ID + " = ?", new String[]{contact_id}, null);
                        while (phoneCursor.moveToNext()) {
                            phoneNumber = phoneCursor.getString(phoneCursor.getColumnIndex(NUMBER));
                            int type = phoneCursor.getInt(phoneCursor.getColumnIndex(TYPE));
                            String stringType = getResources().getString(ContactsContract.CommonDataKinds.Phone.getTypeLabelResource(type));
                            //output.append("\n Phone number:" + phoneNumber);
                            numbers.add(phoneNumber);
                            types.add(type);
                            stringtypes.add(stringType);
                        }
                        phoneCursor.close();

                        // Read every email id associated with the contact
                        Cursor emailCursor = contentResolver.query(EmailCONTENT_URI, null, EmailCONTACT_ID + " = ?", new String[]{contact_id}, null);

                        if (emailCursor.getCount() > 0) {
                            while (emailCursor.moveToNext()) {
                                email = emailCursor.getString(emailCursor.getColumnIndex(DATA));
                                //output.append("\n Email:" + email);
                            }
                            emailCursor.close();
                        }

                        //Address?
                        Cursor addressCursor = contentResolver.query(ContactsContract.CommonDataKinds.StructuredPostal.CONTENT_URI, null, ContactsContract.Data.CONTACT_ID + "= ?",new String[]{contact_id},null);
                        if (addressCursor.getCount() > 0) {
                            addressCursor.moveToNext();
                            address = addressCursor.getString(addressCursor.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.FORMATTED_ADDRESS));
                        }

                        if(numbers.size() > 1 && types.get(0) > types.get(1)) {
                            Collections.swap(numbers, 0, 1);
                            Collections.swap(stringtypes,0,1);
                        }

                        if (numbers.size() > 1) {
                            adapter2.addItem(ContextCompat.getDrawable(this, R.drawable.male), name, stringtypes.get(0) + ": " + numbers.get(0), stringtypes.get(1) + ": " + numbers.get(1), "Email: "+email, "Address: " + address);
                        }
                        else {
                            adapter2.addItem(ContextCompat.getDrawable(this, R.drawable.male), name, stringtypes.get(0) + ": " + numbers.get(0), "Phone No. 2: N/A", email, "Address: " + address);
                        }
                    }
                        // Add the contact to the ArrayList
                        //contactList.add(output.toString());
                }
            }
            cursor.close();
            //아이템 추가


            listview2.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView parent, View v, int position, long id) {
                    // get item
                    ListViewItem item = (ListViewItem) parent.getItemAtPosition(position) ;

                    final String nameStr = item.getName() ;
                    final String numberStr = item.getNumber1() ;
                    Drawable iconDrawable = item.getIcon() ;

                    //해보기
                    //do something with click
                    new AlertDialog.Builder(findViewById(R.id.listview2).getContext()).setMessage("Edit or call?").setPositiveButton("Call", new DialogInterface.OnClickListener() {
                        public void onClick(final DialogInterface dialog, final int id) {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, PERMISSIONS_REQUEST_CALL_PHONE);
                            }
                            //After this point you wait for callback in onRequestPermissionsResult(int, String[], int[]) overriden method
                            else {
                                callPhone(numberStr);
                            }
                        }
                    }).setNegativeButton("Edit", new DialogInterface.OnClickListener() {
                        public void onClick(final DialogInterface dialog, final int id) {
                            /*Uri uri = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_FILTER_URI,Uri.encode(nameStr));
                            Cursor contact = getContentResolver().query(uri, new String[] {ContactsContract.PhoneLookup._ID},null,null,null);
                            contact.moveToNext();
                            String nid = contact.getString(contact.getColumnIndex((ContactsContract.Contacts._ID)));
                            Intent editIntent = new Intent(Intent.ACTION_EDIT);
                            editIntent.setDataAndType(Uri.parse(ContactsContract.Contacts.CONTENT_LOOKUP_URI + "/" + nid), ContactsContract.Contacts.CONTENT_ITEM_TYPE);
                            startActivity(editIntent);*/
                            Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
                            Cursor cursor = getContentResolver().query(uri, null, ContactsContract.Contacts.DISPLAY_NAME + " = ?", new String[]{nameStr}, null);
                            cursor.moveToNext();
                            long idContact = cursor.getLong(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.CONTACT_ID));
                            Intent i = new Intent(Intent.ACTION_EDIT);
                            Uri contactUri = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, idContact);
                            i.setData(contactUri);
                            i.putExtra("finishActivityOnSaveCompleted", true);
                            startActivityForResult(i, EDIT_CONTACT_REQUEST);
                        }
                    }).show();
                }
            });
        }
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode, Intent data) {
        if (requestCode == EDIT_CONTACT_REQUEST) {
            if (resultCode == RESULT_OK) {
                showContacts();
            }
        }
    }

    private void callPhone(String numberStr) {
        lastsharedsound = numberStr;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, PERMISSIONS_REQUEST_CALL_PHONE);
        }
        //After this point you wait for callback in onRequestPermissionsResult(int, String[], int[]) overridden method
        else {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:" + numberStr));
            startActivity(callIntent);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        switch (requestCode) {
            case  PERMISSIONS_REQUEST_READ_CONTACTS: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission is granted
                    showContacts();
                } else {
                    Toast.makeText(this, "Names need permission to be displayed.", Toast.LENGTH_SHORT).show();
                }
        }
            case PERMISSIONS_REQUEST_CALL_PHONE: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission is granted
                    callPhone(lastsharedsound);
                } else {
                    Toast.makeText(this, "Numbers need permission to be called.", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}