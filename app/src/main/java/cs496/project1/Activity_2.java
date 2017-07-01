package cs496.project1;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TabHost;


public class Activity_2 extends AppCompatActivity {

    static final String[] LIST_MENU = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N"};
    //static final City[] cities = {};

    //references to our images
    private Integer[]   mThumbIds = {R.drawable.amsterdam, R.drawable.beijing, R.drawable.istanbul, R.drawable.london
            ,R.drawable.newyork, R.drawable.paris, R.drawable.praha, R.drawable.seoul, R.drawable.rome, R.drawable.tokyo};


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
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, LIST_MENU);

        ListView listview = (ListView) findViewById(R.id.listview1);
        listview.setAdapter(adapter);

/////
        ListView listview2;
        ListViewAdapter adapter2;

        adapter2 = new ListViewAdapter();

        listview2 = (ListView) findViewById(R.id.listview2);
        listview2.setAdapter(adapter2);

        //아이템 추가
        adapter2.addItem(ContextCompat.getDrawable(this, R.drawable.female), "AAA", "010-0000-0000");
        adapter2.addItem(ContextCompat.getDrawable(this, R.drawable.male), "BBB", "010-0000-0000");
        adapter2.addItem(ContextCompat.getDrawable(this, R.drawable.female), "CCC", "010-0000-0000");
        adapter2.addItem(ContextCompat.getDrawable(this, R.drawable.male), "DDD", "010-0000-0000");
        adapter2.addItem(ContextCompat.getDrawable(this, R.drawable.male), "EEE", "010-0000-0000");
        adapter2.addItem(ContextCompat.getDrawable(this, R.drawable.male), "FFF", "010-0000-0000");
        adapter2.addItem(ContextCompat.getDrawable(this, R.drawable.male), "GGG", "010-0000-0000");


        listview2.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                // get item
                ListViewItem item = (ListViewItem) parent.getItemAtPosition(position) ;

                String nameStr = item.getName() ;
                String numberStr = item.getNumber() ;
                Drawable iconDrawable = item.getIcon() ;

                //해보기
                //do something with click
            }
        });


        //gridView  해보기
        //setContentView(R.layout.layout_tab_1);

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

    }




}