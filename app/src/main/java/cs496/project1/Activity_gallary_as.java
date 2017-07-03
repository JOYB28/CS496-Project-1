package cs496.project1;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.GridView;

/**
 * Created by q on 2017-07-03.
 */

public class Activity_gallary_as extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallary);

        GridView gridView;
        CityAdapter citiesAdapter;

        citiesAdapter = new CityAdapter();     // this.cities

        gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(citiesAdapter);


        citiesAdapter.addItem(ContextCompat.getDrawable(this, R.drawable.china), "China");
        citiesAdapter.addItem(ContextCompat.getDrawable(this, R.drawable.hongkong), "Hong Kong");
        citiesAdapter.addItem(ContextCompat.getDrawable(this, R.drawable.japan), "Japan");
        citiesAdapter.addItem(ContextCompat.getDrawable(this, R.drawable.russia), "Russia");
        citiesAdapter.addItem(ContextCompat.getDrawable(this, R.drawable.south_korea), "South Korea");
        citiesAdapter.addItem(ContextCompat.getDrawable(this, R.drawable.thailand), "Thailand");
        citiesAdapter.addItem(ContextCompat.getDrawable(this, R.drawable.turkey), "Turkey");
        citiesAdapter.addItem(ContextCompat.getDrawable(this, R.drawable.uae), "UAE");








    }
}
