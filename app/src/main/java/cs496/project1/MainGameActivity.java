package cs496.project1;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

public class MainGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);



        GridView gridView;
        City2Adapter citiesAdapter;

        citiesAdapter = new City2Adapter();

        gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(citiesAdapter);
        citiesAdapter.addItem(ContextCompat.getDrawable(this, R.drawable.algeria), "Algeria");
        citiesAdapter.addItem(ContextCompat.getDrawable(this, R.drawable.france), "France");
        citiesAdapter.addItem(ContextCompat.getDrawable(this, R.drawable.south_korea), "South Korea");
        citiesAdapter.addItem(ContextCompat.getDrawable(this, R.drawable.bolivia), "Bolivia");


    }
}
