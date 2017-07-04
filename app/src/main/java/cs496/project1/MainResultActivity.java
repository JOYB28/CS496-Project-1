package cs496.project1;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class MainResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_result);

        ListView listview2;
        listview2 = (ListView) findViewById(R.id.listview2);
        ListView2Adapter adapter2 = new ListView2Adapter();
        listview2.setAdapter(adapter2);

        adapter2.addItem(ContextCompat.getDrawable(this, R.drawable.right), "1", "너가 쓴거", "정답");
        adapter2.addItem(ContextCompat.getDrawable(this, R.drawable.right), "2", "너가 쓴거", "정답");
        adapter2.addItem(ContextCompat.getDrawable(this, R.drawable.wrong), "3", "너가 쓴거", "정답");
        adapter2.addItem(ContextCompat.getDrawable(this, R.drawable.right), "4", "너가 쓴거", "정답");
        adapter2.addItem(ContextCompat.getDrawable(this, R.drawable.wrong), "5", "너가 쓴거", "정답");
        adapter2.addItem(ContextCompat.getDrawable(this, R.drawable.right), "6", "너가 쓴거", "정답");
        adapter2.addItem(ContextCompat.getDrawable(this, R.drawable.wrong), "7", "너가 쓴거", "정답");
        adapter2.addItem(ContextCompat.getDrawable(this, R.drawable.right), "8", "너가 쓴거", "정답");
        adapter2.addItem(ContextCompat.getDrawable(this, R.drawable.right), "9", "너가 쓴거", "정답");
        adapter2.addItem(ContextCompat.getDrawable(this, R.drawable.right), "10", "너가 쓴거", "정답");



    }
}
