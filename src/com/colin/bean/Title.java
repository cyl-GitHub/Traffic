package com.colin.bean;

public class Title {
    private Integer id;//题目编号
    private String content;//题目内容
    private String key1;//选项1
    private String key2;//选项2
    private String key3;//选项3
    private String key4;//选项4
    private String key;//正确选项
    private String keyNow;//当前选择
    private Integer multiple;//是否多选
    private String picture;//图片地址
    private String video;//视频地址
    private Integer score;//分值
    private Integer score1;//得分
    private String class1;//分类一(科目)
    private String class2;//分类二(题目类型)
    private String class3;//分类三(车型)
    private String analysis;//题目解析
    private Boolean collection;
    private String admin;//管理员id
    private Integer wrongcount;
    private Integer rightcount;
    private float rate;


    public Title() {
    }

    public Title(String content, String key1, String key2, String key3, String key4, String key, Integer multiple, Integer score, String class1, String class2, String admin) {
        this.content = content;
        this.key1 = key1;
        this.key2 = key2;
        this.key3 = key3;
        this.key4 = key4;
        this.key = key;
        this.multiple = multiple;
        this.score = score;
        this.class1 = class1;
        this.class2 = class2;
        this.admin = admin;
    }

    public Title(Integer id, String content, String key1, String key2, String key3, String key4, String key, Integer multiple, Integer score, String class1, String class2, String analysis) {
        this.id = id;
        this.content = content;
        this.key1 = key1;
        this.key2 = key2;
        this.key3 = key3;
        this.key4 = key4;
        this.key = key;
        this.multiple = multiple;
        this.score = score;
        this.class1 = class1;
        this.class2 = class2;
        this.analysis = analysis;
    }

    public Title(Integer id, String content, String key1, String key2, String key3, String key4, String key, String keyNow, Integer multiple, String picture, String video, Integer score, Integer score1, String class1, String class2, String class3, String analysis, String admin) {
        this.id = id;
        this.content = content;
        this.key1 = key1;
        this.key2 = key2;
        this.key3 = key3;
        this.key4 = key4;
        this.key = key;
        this.keyNow = keyNow;
        this.multiple = multiple;
        this.picture = picture;
        this.video = video;
        this.score = score;
        this.score1 = score1;
        this.class1 = class1;
        this.class2 = class2;
        this.class3 = class3;
        this.analysis = analysis;
        this.admin = admin;
    }

    public Title(Integer id, String content, String key1, String key2, String key3, String key4, String key, String keyNow, Integer multiple, String picture, String video, Integer score, Integer score1, String class1, String class2, String class3, String analysis, Boolean collection, String admin) {
        this.id = id;
        this.content = content;
        this.key1 = key1;
        this.key2 = key2;
        this.key3 = key3;
        this.key4 = key4;
        this.key = key;
        this.keyNow = keyNow;
        this.multiple = multiple;
        this.picture = picture;
        this.video = video;
        this.score = score;
        this.score1 = score1;
        this.class1 = class1;
        this.class2 = class2;
        this.class3 = class3;
        this.analysis = analysis;
        this.collection = collection;
        this.admin = admin;
    }

    public Title(Integer id, String content, String key1, String key2, String key3, String key4, String key, String keyNow, Integer multiple, String picture, String video, Integer score, Integer score1, String class1, String class2, String class3, String analysis, Boolean collection, String admin, Integer wrongcount, Integer rightcount, float rate) {
        this.id = id;
        this.content = content;
        this.key1 = key1;
        this.key2 = key2;
        this.key3 = key3;
        this.key4 = key4;
        this.key = key;
        this.keyNow = keyNow;
        this.multiple = multiple;
        this.picture = picture;
        this.video = video;
        this.score = score;
        this.score1 = score1;
        this.class1 = class1;
        this.class2 = class2;
        this.class3 = class3;
        this.analysis = analysis;
        this.collection = collection;
        this.admin = admin;
        this.wrongcount = wrongcount;
        this.rightcount = rightcount;
        this.rate = rate;
    }

    public Title(String content, String key1, String key2, String key3, String key4, String key, Integer multiple, Integer score, String class1, String class2, String class3, String admin) {
        this.content = content;
        this.key1 = key1;
        this.key2 = key2;
        this.key3 = key3;
        this.key4 = key4;
        this.key = key;
        this.multiple = multiple;
        this.score = score;
        this.class1 = class1;
        this.class2 = class2;
        this.class3 = class3;
        this.admin = admin;
    }

    public Title(Integer id, String content, String key1, String key2, String key3, String key4, String key, Integer multiple, Integer score, String class1, String class2, String class3, String analysis) {
        this.id = id;
        this.content = content;
        this.key1 = key1;
        this.key2 = key2;
        this.key3 = key3;
        this.key4 = key4;
        this.key = key;
        this.multiple = multiple;
        this.score = score;
        this.class1 = class1;
        this.class2 = class2;
        this.class3 = class3;
        this.analysis = analysis;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getKey1() {
        return key1;
    }

    public void setKey1(String key1) {
        this.key1 = key1;
    }

    public String getKey2() {
        return key2;
    }

    public void setKey2(String key2) {
        this.key2 = key2;
    }

    public String getKey3() {
        return key3;
    }

    public void setKey3(String key3) {
        this.key3 = key3;
    }

    public String getKey4() {
        return key4;
    }

    public void setKey4(String key4) {
        this.key4 = key4;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getMultiple() {
        return multiple;
    }

    public void setMultiple(Integer multiple) {
        this.multiple = multiple;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getScore1() {
        return score1;
    }

    public void setScore1(Integer score1) {
        this.score1 = score1;
    }

    public String getClass1() {
        return class1;
    }

    public void setClass1(String class1) {
        this.class1 = class1;
    }

    public String getClass2() {
        return class2;
    }

    public void setClass2(String class2) {
        this.class2 = class2;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getClass3() {
        return class3;
    }

    public void setClass3(String class3) {
        this.class3 = class3;
    }

    public String getKeyNow() {
        return keyNow;
    }

    public void setKeyNow(String keyNow) {
        this.keyNow = keyNow;
    }

    public Boolean getCollection() {
        return collection;
    }

    public void setCollection(Boolean collection) {
        this.collection = collection;
    }

    public Integer getWrongcount() {
        return wrongcount;
    }

    public void setWrongcount(Integer wrongcount) {
        this.wrongcount = wrongcount;
    }

    public Integer getRightcount() {
        return rightcount;
    }

    public void setRightcount(Integer rightcount) {
        this.rightcount = rightcount;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }
}
