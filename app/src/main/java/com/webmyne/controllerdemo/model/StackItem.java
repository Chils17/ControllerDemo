package com.webmyne.controllerdemo.model;

/**
 * Created by chiragpatel on 01-06-2017.
 */

public class StackItem {
    private String itemText;
    private String imageName;

    public StackItem(String text, String imageName) {
        this.imageName = imageName;
        this.itemText = text;
    }

    public String getImageName() {
        return imageName;
    }


    public String getItemText() {
        return itemText;
    }
}
