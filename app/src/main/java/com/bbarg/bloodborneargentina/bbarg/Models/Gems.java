package com.bbarg.bloodborneargentina.bbarg.Models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Gems extends RealmObject {
    @PrimaryKey
    private int ID;
    @Required
    private String name;
    private String type1;
    private String attribute1;
    private int effect1;
    private String type2;
    private String attribute2;
    private int effect2;
    private String type3;
    private String attribute3;
    private int effect3;
}
