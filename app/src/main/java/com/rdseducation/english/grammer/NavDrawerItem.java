package com.rdseducation.english.grammer;

/**
 * Created by revinfotech on 12/19/2017.
 */

public class NavDrawerItem {

    private boolean showNotify;
    private String title;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    private int image;


    public NavDrawerItem() {

    }

    public NavDrawerItem(boolean showNotify, String title, int imagetitle) {
        this.showNotify = showNotify;
        this.title = title;
        this.image = imagetitle;
    }

    public boolean isShowNotify() {
        return showNotify;
    }

    public void setShowNotify(boolean showNotify) {
        this.showNotify = showNotify;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
