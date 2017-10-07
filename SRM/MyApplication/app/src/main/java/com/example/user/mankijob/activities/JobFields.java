package com.example.user.mankijob.activities;

/**
 * Created by USER on 03-10-2017.
 */

public class JobFields {

    //String code = null;
    String name = null;
    boolean selected = false;

    public JobFields (String name, boolean selected) {
        super();
        //this.code = code;
        this.name = name;
        this.selected = selected;
    }

    /*public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }*/
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return selected;
    }
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

}
