package cs496.project1;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.GridView;

/**
 * Created by q on 2017-07-03.
 */

public class Activity_gallary_sa extends Activity{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallary_sa);

        GridView gridView;
        CityAdapter citiesAdapter;

        citiesAdapter = new CityAdapter();     // this.cities

        gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(citiesAdapter);


        citiesAdapter.addItem(ContextCompat.getDrawable(this, R.drawable.argentina), "Argentina");
        citiesAdapter.addItem(ContextCompat.getDrawable(this, R.drawable.bolivia), "Bolivia");
        citiesAdapter.addItem(ContextCompat.getDrawable(this, R.drawable.brazil), "Brazil");
        citiesAdapter.addItem(ContextCompat.getDrawable(this, R.drawable.chile), "Chile");
        citiesAdapter.addItem(ContextCompat.getDrawable(this, R.drawable.peru), "Peru");

    }


}
