package com.colin.bean;

public class User {
    private String id;
    private String name;
    private String password;
    private String sex;
    private String location;
    private String telephone;
    private String code;
    private int firstscore;
    private int fourthscore;
    private String avatar;

    public User() {
    }

    public User(String id, String name, String password, String sex, String location, String telephone) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.location = location;
        this.telephone = telephone;
    }

    public User(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }



    public User(String id, String name, String password, String telephone) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.telephone = telephone;
    }

    public User(String id, String name, String password, String sex, String location, String telephone, String code, int firstscore, int fourthscore) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.location = location;
        this.telephone = telephone;
        this.code = code;
        this.firstscore = firstscore;
        this.fourthscore = fourthscore;
    }



    public User(String id, String name, String password, String sex, String location, String telephone, String code, int firstscore, int fourthscore, String avatar) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.location = location;
        this.telephone = telephone;
        this.code = code;
        this.firstscore = firstscore;
        this.fourthscore = fourthscore;
        this.avatar = avatar;
    }

    public User(String id, String name, String password, String sex, String location, String telephone, String avatar) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.location = location;
        this.telephone = telephone;
        this.avatar = avatar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getFirstscore() {
        return firstscore;
    }

    public void setFirstscore(int firstscore) {
        this.firstscore = firstscore;
    }

    public int getFourthscore() {
        return fourthscore;
    }

    public void setFourthscore(int fourthscore) {
        this.fourthscore = fourthscore;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
