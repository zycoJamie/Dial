package com.android.zycojamie.callphone;

/**
 * Created by zckya on 2017/5/8.
 */

public class Contacts {
    private String name;
    private String number;
    public Contacts(String name,String number){
        this.name=name;
        this.number=number;
    }
    public String getName(){
        return name;
    }
    public String getNumber(){
        return number;
    }
}
