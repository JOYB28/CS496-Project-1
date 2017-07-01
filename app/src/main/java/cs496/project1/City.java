package cs496.project1;

import android.graphics.drawable.Drawable;

/**
 * Created by q on 2017-07-01.
 */

public class City {
    private Drawable imageDrawable;
    private String nameStr;

    public void setImage(Drawable image){
        imageDrawable = image;
    }
    public void setName(String name){
        nameStr = name;
    }

    public Drawable getImage(){
        return this.imageDrawable;
    }
    public String getName(){
        return this.nameStr;
    }
}
