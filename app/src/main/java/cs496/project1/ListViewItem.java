package cs496.project1;

import android.graphics.drawable.Drawable;

/**
 * Created by q on 2017-07-01.
 */

public class ListViewItem {
    private Drawable iconDrawable;
    private String nameStr;
    private String numberStr;

    public void setIcon(Drawable icon){
        iconDrawable = icon;
    }
    public void setName(String name){
        nameStr = name;
    }
    public void setNumber(String number){
        numberStr = number;
    }
    public Drawable getIcon(){
        return this.iconDrawable;
    }
    public String getName(){
        return this.nameStr;
    }
    public String getNumber(){
        return this.numberStr;
    }
}
