package cs496.project1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
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


        gridView.setOnItemClickListener(new OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                //Toast.makeText(getApplicationContext(), "FFFF"+position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), Activity_2.class);
                startActivity(intent);
            }

        });

        //Button btn = new Button


    }


}
