package cs496.project1;

import android.graphics.drawable.Drawable;

/**
 * Created by q on 2017-07-01.
 */

public class ListViewItem {
    private Drawable iconDrawable;
    private String nameStr;
    private String numberStr;
    private String number2Str;
    private String emailStr;
    private String addStr;

    public void setIcon(Drawable icon){
        iconDrawable = icon;
    }
    public void setName(String name){
        nameStr = name;
    }
    public void setNumber1(String number){
        numberStr = number;
    }
    public void setNumber2(String number) { number2Str = number; }
    public void setEmail(String email) { emailStr = email; }
    public void setAdd(String add) { addStr = add; }
    public Drawable getIcon(){
        return this.iconDrawable;
    }
    public String getName(){
        return this.nameStr;
    }
    public String getNumber1() { return this.numberStr; }
    public String getNumber2() { return this.number2Str; }
    public String getEmail() { return this.emailStr; }
    public String getAdd() { return this.addStr; }
}
