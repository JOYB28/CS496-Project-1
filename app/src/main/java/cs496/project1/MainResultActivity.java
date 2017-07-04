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


        adapter2.addItem(ContextCompat.getDrawable(this, R.drawable.right), "1","이름", "너가 쓴거", "정답");
        adapter2.addItem(ContextCompat.getDrawable(this, R.drawable.right), "2","이름", "너가 쓴거", "정답");
        adapter2.addItem(ContextCompat.getDrawable(this, R.drawable.wrong), "3","이름", "너가 쓴거", "정답");
        adapter2.addItem(ContextCompat.getDrawable(this, R.drawable.right), "4","이름", "너가 쓴거", "정답");
        adapter2.addItem(ContextCompat.getDrawable(this, R.drawable.wrong), "5", "이름","너가 쓴거", "정답");
        adapter2.addItem(ContextCompat.getDrawable(this, R.drawable.right), "6","이름", "너가 쓴거", "정답");
        adapter2.addItem(ContextCompat.getDrawable(this, R.drawable.wrong), "7", "이름","너가 쓴거", "정답");
        adapter2.addItem(ContextCompat.getDrawable(this, R.drawable.right), "8","이름", "너가 쓴거", "정답");
        adapter2.addItem(ContextCompat.getDrawable(this, R.drawable.right), "9", "이름","너가 쓴거", "정답");
        adapter2.addItem(ContextCompat.getDrawable(this, R.drawable.right), "10","이름", "너가 쓴거", "정답");



    }
}
