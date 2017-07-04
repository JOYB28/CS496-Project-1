package cs496.project1;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.GridView;

/**
 * Created by q on 2017-07-03.
 */

public class Activity_gallary_af extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallary);

        GridView gridView;
        CityAdapter citiesAdapter;

        citiesAdapter = new CityAdapter();     // this.cities

        gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(citiesAdapter);

        citiesAdapter.addItem(ContextCompat.getDrawable(this, R.drawable.algeria), "Algeria");
        citiesAdapter.addItem(ContextCompat.getDrawable(this, R.drawable.ethiopia), "Ethiopia");
        citiesAdapter.addItem(ContextCompat.getDrawable(this, R.drawable.egypt), "Egypt");

        citiesAdapter.addItem(ContextCompat.getDrawable(this, R.drawable.southafrica), "Republic of South Africa");

    }

}
