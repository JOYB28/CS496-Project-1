package cs496.project1;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class MainResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_result);

        Bundle extras = getIntent().getExtras();

        ListView listview2;
        listview2 = (ListView) findViewById(R.id.listview2);
        ListView2Adapter adapter2 = new ListView2Adapter();
        listview2.setAdapter(adapter2);
        Drawable d;

        for (int i = 0; i<10; i++) {
            if (extras.getBoolean("problem"+(i+1)+"correct")) {
                d = ContextCompat.getDrawable(this, R.drawable.right);
            }
            else {
                d = ContextCompat.getDrawable(this, R.drawable.wrong);
            }
            adapter2.addItem(d, Integer.toString(i+1), extras.getString("problem"+(i+1)+"sel"), extras.getString("problem"+(i+1)+"right"));
        }

    }
}
