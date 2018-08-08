package com.bbarg.bloodborneargentina.bbarg.Models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class hunters extends RealmObject {
    @PrimaryKey
    private int ID;

    private String name;
    private int position;
    private int points;
    private int lastPos;

    public hunters()
    {

    }

    public hunters(int ID, String name, int position, int points, int lastPos) {
        this.ID = ID;
        this.name = name;
        this.position = position;
        this.points = points;
        this.lastPos = lastPos;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getLastPos() {
        return lastPos;
    }

    public void setLastPos(int lastPos) {
        this.lastPos = lastPos;
    }
}
