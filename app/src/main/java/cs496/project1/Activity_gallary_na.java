package cs496.project1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

/**
 * Created by q on 2017-07-03.
 */

public class Activity_gallary_na extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallary_sa);

        GridView gridView;
        CityAdapter citiesAdapter;

        citiesAdapter = new CityAdapter();     // this.cities

        gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(citiesAdapter);



        citiesAdapter.addItem(ContextCompat.getDrawable(this, R.drawable.canada), "Canada");
        citiesAdapter.addItem(ContextCompat.getDrawable(this, R.drawable.unitedstates), "United States");
        citiesAdapter.addItem(ContextCompat.getDrawable(this, R.drawable.greenland), "Greenland");
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                City a = (City)adapterView.getAdapter().getItem(i);
                String name = a.getName();
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.kr/search?q="+name)));
            }
        });
    }
}
