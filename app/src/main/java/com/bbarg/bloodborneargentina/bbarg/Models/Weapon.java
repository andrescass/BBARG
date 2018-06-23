package com.bbarg.bloodborneargentina.bbarg.Models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Weapon extends RealmObject {
    @PrimaryKey
    private int ID;
    @Required
    private String name;
    private int physATK;
    private int bloodATK;
    private int arkATK;
    private int fireATK;
    private int boltATK;
    private int weaponLevel;
    private Gems gem1;
    private Gems gem2;
    private Gems gem3;
    private boolean leftHand; // Left = true, Right = false



    public Weapon(String name, int physATK, int bloodATK, int arkATK, int fireATK, int boltATK, boolean leftHand) {
        this.name = name;
        this.physATK = physATK;
        this.bloodATK = bloodATK;
        this.arkATK = arkATK;
        this.fireATK = fireATK;
        this.boltATK = boltATK;
        this.leftHand = leftHand;
    }

    public Weapon() {
    }

    public Weapon(String name, int physATK, int bloodATK, int arkATK, int fireATK, int boltATK, int weaponLevel, Gems gem1, Gems gem2, Gems gem3, boolean leftHand) {
        this.name = name;
        this.physATK = physATK;
        this.bloodATK = bloodATK;
        this.arkATK = arkATK;
        this.fireATK = fireATK;
        this.boltATK = boltATK;
        this.weaponLevel = weaponLevel;
        this.gem1 = gem1;
        this.gem2 = gem2;
        this.gem3 = gem3;
        this.leftHand = leftHand;
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

    public int getPhysATK() {
        return physATK;
    }

    public void setPhysATK(int physATK) {
        this.physATK = physATK;
    }

    public int getBloodATK() {
        return bloodATK;
    }

    public void setBloodATK(int bloodATK) {
        this.bloodATK = bloodATK;
    }

    public int getArkATK() {
        return arkATK;
    }

    public void setArkATK(int arkATK) {
        this.arkATK = arkATK;
    }

    public int getFireATK() {
        return fireATK;
    }

    public void setFireATK(int fireATK) {
        this.fireATK = fireATK;
    }

    public int getBoltATK() {
        return boltATK;
    }

    public void setBoltATK(int boltATK) {
        this.boltATK = boltATK;
    }

    public int getWeaponLevel() {
        return weaponLevel;
    }

    public void setWeaponLevel(int weaponLevel) {
        this.weaponLevel = weaponLevel;
    }

    public Gems getGem1() {
        return gem1;
    }

    public void setGem1(Gems gem1) {
        this.gem1 = gem1;
    }

    public Gems getGem2() {
        return gem2;
    }

    public void setGem2(Gems gem2) {
        this.gem2 = gem2;
    }

    public Gems getGem3() {
        return gem3;
    }

    public void setGem3(Gems gem3) {
        this.gem3 = gem3;
    }

    public boolean isLeftHand() {
        return leftHand;
    }

    public void setLeftHand(boolean leftHand) {
        this.leftHand = leftHand;
    }
}
