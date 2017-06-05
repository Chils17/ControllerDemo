package com.webmyne.controllerdemo.model;

/**
 * Created by chiragpatel on 02-06-2017.
 */

public class User {
    private int id;
    private String name;
    private int flag;

    public User(int id, String name, int flag) {
        this.id = id;
        this.name = name;
        this.flag = flag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return  this.name + " ";
    }
}
