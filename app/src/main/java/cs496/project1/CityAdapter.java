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
 * Created by q on 2017-07-01.
 */


public class CityAdapter extends BaseAdapter {
    //추가된 데이터 저장하는 arraylist
    private ArrayList<City> cities = new ArrayList<City>();

    //생성자
    public CityAdapter(){

    }

    public int getCount(){
        return cities.size();
    }

    public long getItemId(int position){
        return position;
    }

    public Object getItem(int position){
        return cities.get(position);
    }

    //listviewadapter보면서 바꿔가면서 해봄
    //create a new ImageView for each item referenced by the adapter
    public View getView(int position, View convertView, ViewGroup parent){
        final int pos = position;
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.city_grid, parent, false);
        }
        ImageView cityImageView = (ImageView) convertView.findViewById(R.id.image_city);
        TextView nameTextView = (TextView) convertView.findViewById(R.id.text_name);

        //data set(cities)에서 포지션에 위치한 데이터 참조 획득
        City data = cities.get(position);

        cityImageView.setImageDrawable(data.getImage());
        nameTextView.setText(data.getName());

        return convertView;
    }

    public void addItem(Drawable image, String name){
        City city = new City();

        city.setImage(image);
        city.setName(name);

        cities.add(city);
    }
}
/*
public class CityAdapter extends BaseAdapter {
    private Context mContext;

    // Constructor
    public CityAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(500, 333));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            //imageView.setPadding(1, 1, 1, 1);
        }
        else
        {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    // Keep all Images in array
    public Integer[] mThumbIds = {
            R.drawable.amsterdam, R.drawable.beijing,
            R.drawable.istanbul, R.drawable.london,
            R.drawable.newyork,R.drawable.paris,
            R.drawable.praha, R.drawable.rome,
            R.drawable.seoul, R.drawable.tokyo

    };
}*/
