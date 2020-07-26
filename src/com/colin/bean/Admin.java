package com.colin.bean;

public class Admin {
    private String id;
    private String name;
    private String password;
    private String sex;
    private String location;
    private String telephone;
    private String code;

    public Admin() {
    }

    public Admin(String id, String name, String password, String sex, String location, String telephone) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.location = location;
        this.telephone = telephone;
    }

    public Admin(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public Admin(String id, String name, String password, String code) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.code = code;
    }

    public Admin(String id, String name, String password, String telephone, String code) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.telephone = telephone;
        this.code = code;
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
}
