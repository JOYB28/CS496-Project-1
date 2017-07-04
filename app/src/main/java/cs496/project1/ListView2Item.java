package cs496.project1;

import android.graphics.drawable.Drawable;

/**
 * Created by q on 2017-07-04.
 */

public class ListView2Item {
    private Drawable iconDrawable;
    private String number;
    private String name;
    private String youranswer;
    private String answer;

    public void setIcon(Drawable icon){
        iconDrawable = icon;
    }
    public void setNumber(String number_1){
        number = number_1;
    }
    public void setName(String name_1){ name = name_1; }
    public void setYouranswer(String number){
        youranswer = number;
    }
    public void setAnswer(String number) { answer = number; }

    public Drawable getIcon(){
        return this.iconDrawable;
    }
    public String getNumber(){
        return this.number;
    }
    public String getName(){ return this.name; }
    public String getYouranswer() { return this.youranswer; }
    public String getAnswer() { return this.answer; }

}
