package com.bbarg.bloodborneargentina.bbarg.Models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class LoreModel extends RealmObject{
    @PrimaryKey
    private int ID;

    @Required
    private String title;
    private String loreBody;
    private String imageUri;
    private int imageRes;

    public LoreModel(int ID, String title, String loreBody, String imageUri) {
        this.ID = ID;
        this.title = title;
        this.loreBody = loreBody;
        this.imageUri = imageUri;
    }

    public LoreModel() {
        this.ID = 0;
        this.title = "";
        this.loreBody = "";
        this.imageUri = "";
    }

    public LoreModel(int ID, String title, String loreBody, int imageRes) {
        this.ID = ID;
        this.title = title;
        this.loreBody = loreBody;
        this.imageRes = imageRes;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLoreBody() {
        return loreBody;
    }

    public void setLoreBody(String loreBody) {
        this.loreBody = loreBody;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }
}
