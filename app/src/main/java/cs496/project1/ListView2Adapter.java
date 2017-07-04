package cs496.project1;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by q on 2017-07-04.
 */
//기존의 listviewadapter copy 후 결과에 맞게 바꾼것

public class ListView2Adapter extends BaseAdapter {
    // Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    private ArrayList<ListView2Item> listViewItem2List = new ArrayList<ListView2Item>() ;

    // ListViewAdapter의 생성자
    public ListView2Adapter() {

    }

    // Adapter에 사용되는 데이터의 개수를 리턴. : 필수 구현

    public int getCount() {
        return listViewItem2List.size() ;
    }

    // position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. : 필수 구현

    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview2_item2, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        ImageView iconImageView = (ImageView) convertView.findViewById(R.id.imageView1) ;
        TextView number = (TextView) convertView.findViewById(R.id.textView1) ;
        TextView youranswer = (TextView) convertView.findViewById(R.id.textView2) ;
        TextView answer = (TextView) convertView.findViewById(R.id.textView3);

        // Data Set(listViewItem2List)에서 position에 위치한 데이터 참조 획득
        ListView2Item listView2Item = listViewItem2List.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        iconImageView.setImageDrawable(listView2Item.getIcon());
        number.setText(listView2Item.getNumber());
        youranswer.setText(listView2Item.getYouranswer());
        answer.setText(listView2Item.getAnswer());

        return convertView;
    }

    // 지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현

    public long getItemId(int position) {
        return position ;
    }

    // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현

    public Object getItem(int position) {
        return listViewItem2List.get(position) ;
    }

    // 아이템 데이터 추가를 위한 함수
    public void addItem(Drawable icon, String number, String youranswer, String answer) {
        ListView2Item item = new ListView2Item();

        item.setIcon(icon);
        item.setNumber(number);
        item.setYouranswer(youranswer);
        item.setAnswer(answer);

        listViewItem2List.add(item);
    }
}
